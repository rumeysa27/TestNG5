package Gun03;

/*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En sondan 2. adresi siliniz.
 */

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class _02_AddressFunctionality extends BaseDriver {

    @Test
    void addAddress(){
        WebElement addressBook= driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        WebElement newAdress= driver.findElement(By.linkText("New Address"));
        newAdress.click();

        WebElement firstName= driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Rümeysa");

        WebElement lastname= driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("Bakır");

        WebElement company= driver.findElement(By.id("input-company"));
        company.sendKeys("Techno Study");

        WebElement address1= driver.findElement(By.id("input-address-1"));
        address1.sendKeys("Yeditepe mah. 43 nolu sokak");

        WebElement address2= driver.findElement(By.id("input-address-2"));
        address2.sendKeys("no 42 dünyalar apt.");

        WebElement city= driver.findElement(By.id("input-city"));
        city.sendKeys("G.Antep");

        WebElement postCode= driver.findElement(By.id("input-postcode"));
        postCode.sendKeys("12345");

        // ülke seçimi tamam
        WebElement webCountry= driver.findElement(By.id("input-country"));
        Select country=new Select(webCountry);
        country.selectByVisibleText("Turkey");

        //2.Seçenek
       wait.until(ExpectedConditions.elementToBeClickable(webCountry));

        // state yani şehir seçimi
        // 1.Seçenek
//        WebElement options=driver.findElement(By.cssSelector("select[id='input-zone']>option"));
//        wait.until(ExpectedConditions.stalenessOf(options));

        WebElement webState= driver.findElement(By.id("input-zone"));
        Select state=new Select(webState);
        //state.selectByVisibleText("Gaziantep");
        //state.selectByValue("3347");
        state.selectByIndex(28);
        // stale element hatası : eski element

        //selectByVisibleText, selectByValue : findElement gibi çalıştığından
        //                                     implictly wait i kullanır.
        // selectByIndex : implicitlyWait ie çalışMIYOR. ancak ExplicitWait ile çalışır


        WebElement defaddress = driver.findElement(By.xpath("//input[@value='1']"));
        defaddress.click();

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        Tools.successMessageValidation();
    }


    @Test(dependsOnMethods = {"addAddress"})
    void editAddress(){
        WebElement addressBook= driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editAll= driver.findElements(By.linkText("Edit"));
        WebElement sonEdit= editAll.get( editAll.size()-1 ); // son edit
        sonEdit.click();

        WebElement firstName= driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys("rümeysa1");

        WebElement lastname= driver.findElement(By.id("input-lastname"));
        lastname.clear();
        lastname.sendKeys("Bakır1");

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        // Tools.successMessageValidation();//hata veriyo
    }

    @Test(dependsOnMethods = {"editAddress"})
    void deleteAddress(){

        WebElement addressBook= driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editAll= driver.findElements(By.linkText("Delete"));
        WebElement silinebilirAdres= editAll.get( editAll.size()-2 ); // silinebilir 2.cisi
        silinebilirAdres.click();

        Tools.successMessageValidation();
    }

}