package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInitializer {

    //need a function that takes a string as an argument determines if we use chrome or firefox
    //and creates a webdriver instance based on our selection
    public static WebDriver initializeDriver(BrowserType browserType) {
        if (browserType == BrowserType.CHROME) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");
            return new ChromeDriver(options);
        } else {
            return new FirefoxDriver();
        }
    }
}
