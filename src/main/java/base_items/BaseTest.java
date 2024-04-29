package base_items;

import driver.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

 /*   public WebDriver driver;
    public WebDriverWait wait;

    @BeforeEach
    public void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        driver.get(Settings.TESCO_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement acceptCookiesBttn = driver.findElement(By.xpath("//span[contains(text(),'Accept all cookies')]//ancestor::button"));
        acceptCookiesBttn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("brand-logo-link")));
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }*/
}