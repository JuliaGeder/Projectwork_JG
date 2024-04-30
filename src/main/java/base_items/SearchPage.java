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


    @FindBy(xpath = "//*[@class = 'styled__StyledLIProductItem-sc-198470k-1 fmKLdy product-list--list-item']")
    public List<WebElement> searchResults;

    @FindBy (xpath = "//*[@class = 'heading query']")
    public WebElement headingQuery;

    @FindBy (xpath = "//*[@id=\"product-list\"]/div[2]/div[3]/div/div[1]/div[1]/div[2]/a")
    public WebElement show48PerPage;

    @FindBy (xpath = "//*[@id=\"product-list\"]/div[2]/div[3]/div/div[2]/div/p")
    public WebElement emptySearchResult;

    @FindBy(className = "styled__BaseButton-rsekm1-0 styled__PrimaryButton-rsekm1-2 jChbeY geeWOF styled__StyledButton-vtxwzb-5 japAxb beans-quantity-controls__add-button beans-button__container")
    private List<WebElement> addButtons;

    @FindBy (xpath = "//*[@id=\"mini-trolley\"]/div/div[2]/div[1]/div[2]/div[1]/div")
    private WebElement currentPrice;

    public void addToCart(int number){
        for (int i= 0; i < number; i++) {
            Random rand = new Random();
            int max= addButtons.size(), min=1;
            int buttonNumber = rand.nextInt(max - min + 1) + min;
            addButtons.get(buttonNumber).click();
            wait.until(ExpectedConditions.visibilityOf(currentPrice));
        }
    }
    @FindBy (xpath = "//*[@class = 'sc-kDTinF jrofoJ basket-tile']")
    public List<WebElement> itemsInTheCard;

    @FindBy (xpath = "//*[@class = 'styled__StyledIconButton-sc-rnkc1-1 bxKkFX ddsweb-button ddsweb-button--icon-button']")
    private WebElement removeFromTheCart;

    public void removeAllItems(){
        for (int i= 0; i < itemsInTheCard.size(); i++) {
            removeFromTheCart.click();
            wait.until(ExpectedConditions.visibilityOf(currentPrice));
        }
    }
    @FindBy (xpath = "//*[@id=\"mini-trolley\"]/div/div[2]/div[1]/div[2]/div[1]/div/h4[2]")
    public WebElement totalPrice;
}
