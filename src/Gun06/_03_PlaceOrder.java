package Gun06;

import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_PlaceOrder extends BaseDriver {
    @Test
    void ProceedToCheckout(){

        _03_PlaceOrderElements elements=new _03_PlaceOrderElements();
        elements.searchBox.sendKeys("ipod");
        elements.searchButton.click();
        elements.addToChart.click();
        elements.shoppingChart.click();
        elements.checkOut.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continue1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue3)).click();
        elements.agree.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue4)).click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.confirm)).click();

        wait.until(ExpectedConditions.urlContains("success"));
        Assert.assertEquals(elements.msg.getText(),"Your order has been placed!","Onay texti bulunamadi");

    }
}
