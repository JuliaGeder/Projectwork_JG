package steps;

import base_items.HomePage;
import driver.BrowserType;
import driver.DriverInitializer;
import driver.Settings;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Language {

    public WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;

    @Before
    public void startDriver() {

     //   driver = DriverInitializer.initializeDriver(BrowserType.CHROME);
        driver.get(Settings.TESCO_URL);
    //    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new HomePage(driver);
        homePage.policyButton.click();
        homePage.isLoaded();
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

    @After
    public void closeBrowser() {
        driver.close();
    }
}