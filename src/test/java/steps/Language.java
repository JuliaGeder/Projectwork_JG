package steps;

import base_items.BaseTest;
import driver.BrowserType;
import driver.DriverInitializer;
import driver.Settings;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Language {

    public WebDriver driver;
    public WebDriverWait explicitWait;

    @Given("I open the main page")
    public void iOpenTheMainPage() {
        driver = DriverInitializer.initializeDriver(BrowserType.CHROME);
        driver.get(Settings.TESCO_URL);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And("I accept cookies")
    public void iAcceptCookies() {
       /* WebElement acceptCookiesBttn = driver.findElement(By.xpath("//span[contains(text(),'Accept all cookies')]//ancestor::button"));
        acceptCookiesBttn.click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("brand-logo-link")));
   */ }

    @Given("language is set to {string}")
    public void languageIsSetToCurrentLanguage(String newLanguage) {
        WebElement currentLanguageElement = driver.findElement(By.className("content-title__txt"));
        WebElement langualeSwitch = driver.findElement(By.id("utility-header-language-switch-link"));
        if (currentLanguageElement.getText().equals("Offers this week from Tesco")) {
            if (newLanguage.equals("hungarian")) {
                langualeSwitch.click();
            }
        } else {
            if (newLanguage.equals("english")) {
                langualeSwitch.click();
            }
        }
        //wait for the page to reload
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("brand-logo-link")));
    }

    @When("I change language to {string}")
    public void iChangeLanguageToNewLanguage(String newLanguage) {
        if (newLanguage.equals("english")) {
            driver.findElement(By.id("utility-header-language-switch-link")).click();
        } else {
            driver.findElement(By.id("utility-header-language-switch-link")).click();
        }
        //wait for the page to reload
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("brand-logo-link")));
    }

    @Then("language is changed to {string}")
    public void languageIsChangedToExpectedLanguage(String expectedLanguage) {
        String currentLanguage = "";

        WebElement currentLanguageElement = driver.findElement(By.className("content-title__txt"));
        if (currentLanguageElement.getText().equals("Offers this week from Tesco")) {
            currentLanguage = "english";
        } else {
            currentLanguage = "hungarian";
        }

        driver.quit();
    }
}