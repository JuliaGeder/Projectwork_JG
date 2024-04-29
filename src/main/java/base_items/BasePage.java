package base_items;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

   @FindBy(className = "brand-logo-link")
    private WebElement brandLogo;

    @FindBy(xpath = "//span[contains(text(),'Accept all cookies')]//ancestor::button")
    public WebElement policyButton;

    public void isLoaded() {
        wait.until(ExpectedConditions.visibilityOf(brandLogo));
    }
}
