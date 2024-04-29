package steps;

import base_items.BaseTest;
import base_items.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Search {
    public WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    @Given("I select search field")
    public void iSelectSearchField(String item) {
       homePage.searchField.click();
           }

    @When("I enter {string}")
    public void iEnterItem(String item) {
        homePage.searchField.clear();
        homePage.searchField.sendKeys(item);
        driver.findElement(By.xpath("//*[@id=\"search-form\"]/button"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("heading query")));
    }

    @Then("The page with search results is shown")
    public void thePageWithSearchResultsIsShown() {
        List<WebElement> searchResults = driver.findElements(By.className("styled__StyledLIProductItem-sc-198470k-1 fmKLdy product-list--list-item"));
        System.out.println(searchResults.size() + "items on the first search page.");
    }

    @And("I click on Show {int} per page")
    public void iClickOnShowPerPage(int arg0) {
        driver.findElement(By.xpath("//*[@id=\"product-list\"]/div[2]/div[3]/div/div[1]/div[1]/div[2]/a"));
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
}
