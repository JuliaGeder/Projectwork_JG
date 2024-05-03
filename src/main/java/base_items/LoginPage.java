package base_items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    public WebElement addressField;

    @FindBy(id = "password")
    public WebElement passwordField;
    @FindBy(xpath = "//*[@class = 'styled__StyledBodyText-sc-119w3hf-5 cjzjrS beans-notification__title']")
    public WebElement errorMessage;

    //   @FindBy(id = "main-content")
    //  private WebElement signInForm;
    @FindBy(id = "signin-button")
    public WebElement signInButton;

    //   @FindBy(id = "utility-header-logout-link")
    //   public WebElement signOutButton;
  //  private static final By logOutBtn = By.id("utility-header-logout-link");
    private static final By signInForm = By.id("main-content");

    @FindBy(xpath = "//*[@class = 'styled__GreetingMessage-sc-9ltfcf-1 cfKIRj']")
    private WebElement greetingMessage;

    @FindBy(id = "utility-header-account-link")
    public WebElement accountButton;

    public void enterCredentials(String email, String password) {
        addressField.clear();
        addressField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void loginFormIsLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInForm));
    }
    public void waitLogOutBtn() {
        wait.until(ExpectedConditions.visibilityOf(greetingMessage));
    }
}
