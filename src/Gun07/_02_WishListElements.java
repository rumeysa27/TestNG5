package Gun07;

import Utlity.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _02_WishListElements {

    public _02_WishListElements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css="div[class='caption']>h4>a")
    List<WebElement> searchResult;

    @FindBy(xpath="//button[@data-original-title='Add to Wish List']")
    List<WebElement> wishBtnList;

    @FindBy(id="wishlist-total")
    WebElement btnWisthProducts;

    @FindBy(css="[class='text-left']>a")
    List<WebElement> wishTableNames;

}
