package Utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
   public void baslangicIslemler(){
        System.out.println("Başlangıç işlemleri yapılıyor");
        Logger logger= Logger.getLogger(""); // output  ait bütün logları üreten objeye/servise ulaştım ""
        logger.setLevel(Level.SEVERE); // Sadece errorları göster
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        ChromeOptions options=new ChromeOptions(); //google ı güncellerse bu 3 satırı aç 36yı yoruma al
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);


        driver.manage().window().maximize();//
        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);//test için şimdilik kaldırdık

        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        loginTest();


    }

    void loginTest()
    {
        System.out.println("Login Test");

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement inputEmail=driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("rumys@hotmail.com");

        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("1234");

        WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();

        Assert.assertTrue(driver.getTitle().equals("My Account"));
        // Assert.assertTrue(driver.getCurrentUrl().contains("account/account"));


    }
    @AfterClass
   public void bitiIslemleri(){

        System.out.println("Bitiş işlemleri yapılıyor");

        Tools.Bekle(3);
        driver.quit();
    }
}
