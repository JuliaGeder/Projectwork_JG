package base_items;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends HomePage {


    public SearchPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@class = 'styled__StyledLIProductItem-sc-198470k-1 fmKLdy product-list--list-item']")
    public List<WebElement> searchResults;

    @FindBy (xpath = "//*[@class = 'heading query']")
    public WebElement headingQuery;

    @FindBy (xpath = "//*[@id=\"product-list\"]/div[2]/div[3]/div/div[1]/div[1]/div[2]/a")
    public WebElement show48PerPage;
}
