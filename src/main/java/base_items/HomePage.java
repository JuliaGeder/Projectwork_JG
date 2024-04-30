package base_items;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "content-title__txt")
    public WebElement contentTitle;

    @FindBy(id = "utility-header-language-switch-link")
    public WebElement languageSwitch;

    @FindBy(xpath = "//input[@id='search-input']")
    public WebElement searchField;
    @FindBy(xpath = "//*[@id='search-form']/button")
    public WebElement searchButton;


}
