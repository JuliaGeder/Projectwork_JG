package base_items;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    public WebElement addressField;

    @FindBy(id = "password")
    public WebElement passwordField;

    public void enterCredentials(String email, String password) {
        addressField.clear();
        addressField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/div[2]/div/div[2]/p[1]")
    public WebElement errorMessage;

    @FindBy(id = "main-content")
    private WebElement signInForm;
    @FindBy(id = "signin-button")
    public WebElement signInButton;

    @FindBy(id = "utility-header-logout-link")
    public WebElement signOutButton;

    @FindBy(id = "utility-header-account-link")
    public WebElement accountButton;

    public void loginFormIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(signInForm));
    }


}
