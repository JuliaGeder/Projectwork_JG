package steps;

import base_items.BaseTest;
import base_items.HomePage;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Search {
    public WebDriver driver;
    public WebDriverWait wait;
    public SearchPage searchPage;

    @Before
    public void startDriverForSearch() {

        driver = DriverInitializer.initializeDriver(BrowserType.CHROME);
        driver.get(Settings.TESCO_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        searchPage = new SearchPage(driver);
        searchPage.policyButton.click();
        searchPage.isLoaded();
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
        wait.until(ExpectedConditions.visibilityOfAllElements(searchPage.searchResults));
        //   List<WebElement> searchResults = driver.findElements(By.className("styled__StyledLIProductItem-sc-198470k-1 fmKLdy product-list--list-item"));
        System.out.println(searchPage.searchResults.size() + "items on the first search page.");
    }

    @And("I click on Show more per page")
    public void iClickOnShowPerPage() {
        searchPage.show48PerPage.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(searchPage.searchResults));
        System.out.println(searchPage.searchResults.size() + "items on the first search page.");

    }
    @After
    public void closeBrowser() {
        driver.close();
    }
}
