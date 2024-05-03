package base_items;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends HomePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='personal-details']/a[1]")
    public WebElement editPersonalDetailsButton;

    @FindBy(id = "first-name")
    public WebElement inputFirstName;

    @FindBy(id = "last-name")
    public WebElement inputLastName;

    @FindBy(xpath = "//*[@id='personal-details']/form/div/div/button")
    public WebElement saveChangesPersonalDetails;
    @FindBy(xpath = "//*[@id='personal-details']/div/div[1]/span")
    public WebElement fullName;

    public void isLoadedAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(editPersonalDetailsButton));
    }

    public void clickEditPersonalDetails() {
        editPersonalDetailsButton.click();
        wait.until(ExpectedConditions.visibilityOf(inputFirstName));
    }

    public void clearInputs() {
        inputFirstName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        inputLastName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public void enterNewName(String first, String last) {
        inputFirstName.sendKeys(first);
        inputLastName.sendKeys(last);
    }

    public void saveChanges() {
        wait.until(ExpectedConditions.elementToBeClickable(saveChangesPersonalDetails));
        saveChangesPersonalDetails.click();
    }
}
