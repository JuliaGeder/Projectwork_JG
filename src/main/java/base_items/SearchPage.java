package base_items;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class SearchPage extends HomePage {


    public SearchPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[contains(@class, 'styled__StyledLIProductItem-sc-198470k-1 fmKLdy product-list--list-item')]")
    public List<WebElement> searchResults;

    @FindBy(xpath = "//*[@class = 'heading query']")
    public WebElement headingQuery;

    @FindBy(xpath = "//*[@id='product-list']/div[2]/div[3]/div/div[1]/div[1]/div[2]/a")
    public WebElement show48PerPage;

    @FindBy(xpath = "//*[@id='product-list']/div[2]/div[3]/div/div[2]/div/p")
    public WebElement emptySearchResult;

    @FindBy(xpath = "//*[@class = 'styled__BaseButton-rsekm1-0 styled__PrimaryButton-rsekm1-2 jChbeY geeWOF styled__StyledButton-vtxwzb-5 japAxb beans-quantity-controls__add-button beans-button__container']")
    private List<WebElement> addButtons;

    @FindBy(xpath = "//*[@class = 'sc-jIkXHa kIZajg']")
    private WebElement currentPrice;

    @FindBy(xpath = "//*[@class = 'component__StyledHeading-sc-1t0ixqu-0 kOFvCa ddsweb-heading sc-jOxtWs jByFCH']")
    public WebElement totalPrice;
    @FindBy(xpath = "//*[@class = 'sc-jrQzAO kkiGfi basket-tile']")
    public List<WebElement> itemsInTheCard;

    @FindBy(xpath = "//*[@class = 'styled__StyledIconButton-sc-rnkc1-1 hHdQvE ddsweb-button ddsweb-button--icon-button']")
    private WebElement removeFromTheCart;

    public void addToCart(String number) {
        for (int i = 0; i < Integer.valueOf(number); i++) {
            Random rand = new Random();
            int max = addButtons.size() - 1;
            int min = 1;
            int buttonNumber = rand.nextInt(max - min + 1) + min;
            addButtons.get(buttonNumber).click();
            wait.until(ExpectedConditions.visibilityOf(currentPrice));
        }
    }

    public void removeAllItems() {
        int numberOfItems = itemsInTheCard.size();
        for (int i = 0; i < numberOfItems; i++) {
            removeFromTheCart.click();
            wait.until(ExpectedConditions.visibilityOf(currentPrice));
        }
    }
}
