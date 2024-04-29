package steps;

import base_items.HomePage;
import base_items.LoginPage;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {

    public WebDriver driver = DriverInitializer.initializeDriver(BrowserType.CHROME);
    ;

    public LoginPage loginPage = new LoginPage(driver);
    ;

    @Before
    public void startDriver() {
        //   driver = DriverInitializer.initializeDriver(BrowserType.CHROME);
        driver.get(Settings.TESCO_URL);
        //  loginPage = new LoginPage(driver);
        loginPage.isLoaded();
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
        loginPage.loginFormIsLoaded();
    }

    @Then("Login was unsuccessful and error message was shown")
    public void loginWasUnsuccessfulAndErrorMessageWasShown() {
        Assertions.assertEquals("Unfortunately we do not recognise those details.", loginPage.errorMessage.getText());
    }

    @After
    public void closeBrowser() {
        driver.close();
    }
}