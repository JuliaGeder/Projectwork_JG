package steps;

import base_items.HomePage;
import base_items.LoginPage;
import base_items.SearchPage;
import driver.BrowserType;
import driver.DriverInitializer;
import driver.Settings;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Steps {

    public WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;
    public HomePage homePage;
    public SearchPage searchPage;
    ;;

    @Before
    // @Given("Start driver login")
    public void startDriverLogin() {
        driver = DriverInitializer.initializeDriver(BrowserType.CHROME);
        loginPage = new LoginPage(driver);
        driver.get(Settings.TESCO_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new HomePage(driver);
        homePage.policyButton.click();
        searchPage = new SearchPage(driver);
        homePage.isLoaded();
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Given("I am on the sign-in page")
    public void iAmOnTheSignInPage() {
        loginPage.signInButtonHomePage.click();
        loginPage.loginFormIsLoaded();
    }

    @When("I enter {string} and {string}")
    public void iEnterUsernameAndPassword(String email, String password) {
        loginPage.enterCredentials(email, password);
        loginPage.signInButton.click();

    }

    @Then("Login was unsuccessful and error message was shown")
    public void loginWasUnsuccessfulAndErrorMessageWasShown() {
        loginPage.loginFormIsLoaded();
        Assertions.assertEquals("Unfortunately we do not recognise those details.", loginPage.errorMessage.getText());
    }

    @Then("Login was successful")
    public void loginWasSuccessful() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.signOutButton));
    }

    @Given("language is set to {string}")
    public void languageIsSetToCurrentLanguage(String newLanguage) {
        if (homePage.contentTitle.getText().equals("Offers this week from Tesco")) {
            if (newLanguage.equals("hungarian")) {
                homePage.languageSwitch.click();
            }
        } else {
            if (newLanguage.equals("english")) {
                homePage.languageSwitch.click();
            }
        }
        homePage.isLoaded();
    }

    @When("I change language to {string}")
    public void iChangeLanguageToNewLanguage(String newLanguage) {
        if (newLanguage.equals("english")) {
            homePage.languageSwitch.click();
        } else {
            homePage.languageSwitch.click();
        }
        //wait for the page to reload
        homePage.isLoaded();
    }

    @Then("language is changed to {string}")
    public void languageIsChangedToExpectedLanguage(String expectedLanguage) {
        String currentLanguage = "";
        if (homePage.contentTitle.getText().equals("Offers this week from Tesco")) {
            currentLanguage = "english";
        } else {
            currentLanguage = "hungarian";
        }
        Assertions.assertEquals(expectedLanguage, currentLanguage);
    }

    @Given("I select search field")
    public void iSelectSearchField() {
        searchPage.searchField.click();
    }

    @When("I enter {string}")
    public void iEnterItem(String item) {
        searchPage.searchField.clear();
        searchPage.searchField.sendKeys(item);
        searchPage.searchButton.click();
        wait.until(ExpectedConditions.visibilityOf(searchPage.headingQuery));
    }

    @Then("The page with search results is shown")
    public void thePageWithSearchResultsIsShown() {
        wait.until(ExpectedConditions.visibilityOf(searchPage.headingQuery));
        System.out.println(searchPage.searchResults.size() + " items on the first search page.");
    }

    @And("I click on Show more per page")
    public void iClickOnShowPerPage() {
        searchPage.show48PerPage.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(searchPage.searchResults));
        System.out.println(searchPage.searchResults.size() + " items on the first search page.");

    }

    @Then("Zero items were found")
    public void zeroItemsWereFound() {
        Assertions.assertEquals("Please double-check the spelling, try a more generic search term or try other search terms.", searchPage.emptySearchResult.getText());
    }


    @And("I add {string} of products to cart")
    public void iAddNumberProducts(String number) {
    searchPage.addToCart(number);
    }


    @Then("the cart contains the selected {string} items")
    public void theCartContainsTheSelectedItems(String number) {
        Assertions.assertEquals(Integer.valueOf(number), searchPage.itemsInTheCard.size());
    }

    @And("Remove all the items from the cart")
    public void removeAllTheItems() {
        searchPage.removeAllItems();
    }

    @And("Cart is empty")
    public void cartIsEmpty() {
        Assertions.assertEquals("0 Ft", searchPage.totalPrice.getText());
    }
}