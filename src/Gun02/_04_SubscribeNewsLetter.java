package Gun02;

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe işlemini abone lunuz(YES)
  3- Ayrı bir test ile Newsletter  Subscribe işlemini abonelikten çıkınız(NO)
  4- Ayrı bir test ile Newsletter  Subscribe durumunu kontrol ediniz YES ise NO, NO ise YES yapınız.
 */
public class _04_SubscribeNewsLetter extends BaseDriver {

    By link=By.linkText("Newsletter");
    By subYes= By.xpath("//input[@value='1']");
    By subNo= By.xpath("//input[@value='0']");
    By cntBtn= By.xpath("//input[@value='Continue']");

    @Test(priority = 1) //hepsini sırayla çalştırsın diye bu priorty kullandık
    void subscribeFunctionYes(){

        WebElement newsLetterLink=driver.findElement(link);
        newsLetterLink.click();

        WebElement subscribeYes=driver.findElement(subYes);
        subscribeYes.click();

        WebElement continueButton=driver.findElement(cntBtn);
        continueButton.click();


        Tools.successMessageValidation();
    }


    @Test(priority = 2)
    void subscribeFunctionNo() {
        WebElement newsLetterLink=driver.findElement(link);
        newsLetterLink.click();

        WebElement subscribeNo=driver.findElement(subNo);
        subscribeNo.click();

        WebElement continueButton=driver.findElement(cntBtn);
        continueButton.click();

        Tools.successMessageValidation();
    }

    @Test(priority = 3)
    void subscribeFunctionForBoth() {
        WebElement newsLetterLink=driver.findElement(link);
        newsLetterLink.click();

        WebElement subscribeYes=driver.findElement(subYes);
        WebElement subscribeNo=driver.findElement(subNo);

        if (subscribeYes.isSelected())
            subscribeNo.click();
        else
            subscribeYes.click();

        WebElement continueButton=driver.findElement(cntBtn);
        continueButton.click();

        Tools.successMessageValidation();
    }

}
