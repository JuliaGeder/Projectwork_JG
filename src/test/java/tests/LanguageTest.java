package tests;

public class LanguageTest {
  /*  public WebDriver driver = DriverInitializer.initializeDriver(BrowserType.CHROME);
    public WebDriverWait wait;
    public HomePage homePage;


    @Test
    public void languageCheck(){
        driver.get(Settings.TESCO_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new HomePage(driver);
        homePage.policyButton.click();
        homePage.isLoaded();

        String newLanguage = "hungarian";
        if (homePage.contentTitle.getText().equals("Offers this week from Tesco")) {
            if (newLanguage.equals("hungarian")) {
                homePage.languageSwitch.click();
            }
        } else {
            if (newLanguage.equals("english")) {
                homePage.languageSwitch.click();
            }
        }
        //wait for the page to reload
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("brand-logo-link")));
        String currentLanguage = "";
        if (homePage.contentTitle.getText().equals("Offers this week from Tesco")) {
            currentLanguage = "english";
            System.out.println(currentLanguage);
        } else {
            currentLanguage = "hungarian";
            System.out.println(currentLanguage);
        }
        driver.close();
    }*/
}
