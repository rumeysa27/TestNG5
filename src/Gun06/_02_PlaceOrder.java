package Gun06;

import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_PlaceOrder extends BaseDriver {
    @Test
    void ProceedToCheckout(){

        WebElement searchBox=driver.findElement(By.name("search"));
        searchBox.sendKeys("ipod");

        WebElement searchButton=driver.findElement(By.cssSelector("[class='btn btn-default btn-lg']"));
        searchButton.click();

        WebElement addToChart=driver.findElement(By.xpath("//span[text()='Add to Cart']"));
        addToChart.click();

        WebElement shoppingChart=driver.findElement(By.linkText("Shopping Cart"));
        shoppingChart.click();

        WebElement checkOut=driver.findElement(By.linkText("Checkout"));
        checkOut.click();

        WebElement continue1=wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address")));
        continue1.click();

        WebElement continue2=wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-address")));
        continue2.click();

        WebElement continue3=wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));
        continue3.click();

        WebElement agree=driver.findElement(By.name("agree"));
        agree.click();

        WebElement continue4=wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-method")));
        continue4.click();

        WebElement confirm=wait.until(ExpectedConditions.elementToBeClickable(By.id("button-confirm")));
        confirm.click();

        wait.until(ExpectedConditions.urlContains("success"));

        WebElement msg=driver.findElement(By.cssSelector("[id='content']>h1"));
        Assert.assertEquals(msg.getText(),"Your order has been placed!","Onay texti bulunamadi");

    }
}
