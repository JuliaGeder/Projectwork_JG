package base_items;

import driver.BrowserType;
import driver.DriverInitializer;
import driver.Settings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait explicitWait;

    @BeforeEach
    public void initializeDriver() {
        driver = DriverInitializer.initializeDriver(BrowserType.CHROME);
        driver.get(Settings.TESCO_URL);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement acceptCookiesBttn = driver.findElement(By.xpath("//span[contains(text(),'Accept all cookies')]//ancestor::button"));
        acceptCookiesBttn.click();
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}
