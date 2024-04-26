package steps;

import base_items.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Search extends BaseTest {
    WebElement searchField = driver.findElement(By.xpath("//input[@id='search-input']"));

    @Given("I select search field")
    public void iSelectSearchField(String item) {
       searchField.click();
           }

    @When("I enter {string}")
    public void iEnterItem(String item) {
        searchField.clear();
        searchField.sendKeys(item);
        driver.findElement(By.xpath("//*[@id=\"search-form\"]/button"));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("heading query")));
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
}
