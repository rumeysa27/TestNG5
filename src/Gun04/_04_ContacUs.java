package Gun04;
/*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact US yazısını doğrulayınız.
 */

import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _04_ContacUs extends BaseDriver {
    @Test
    @Parameters("mesaj")// xml deki parametre adı aynı olmak zorunda
    void contactUs(String gelenMesaj){
        // String gelenMesaj:metod için gerekli tanımlama aynı olmak zorunda değil

        WebElement contactUsBtn= driver.findElement(By.linkText("Contact Us"));
        contactUsBtn.click();

        WebElement enquiryArea= driver.findElement(By.id("input-enquiry"));
        enquiryArea.sendKeys(gelenMesaj);

        WebElement submitButton= driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));
    }

//BURADA HATA ALIYORUM
}
