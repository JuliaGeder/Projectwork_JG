package tests;

import base_items.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LanguageTest extends BaseTest {

    @Test
    public void languageCheck(){
        String newLanguage = "hungarian";
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
}
