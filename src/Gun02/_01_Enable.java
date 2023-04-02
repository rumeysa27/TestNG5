package Gun02;

import Utlity.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _01_Enable {
    @Test
void Test1(){

        System.out.println("test 1");
    }
@Test (enabled = false)
    void Test2(){
    System.out.println("test 2");

}
@Test
    void Test3(){

    System.out.println("test 3");

  }
public static WebDriver driver;
  @BeforeClass
  void baslangicIslemler(){
      System.out.println("Başlangıç işlemleri yapılıyor");
      Logger logger= Logger.getLogger(""); // output  ait bütün logları üreten objeye/servise ulaştım ""
      logger.setLevel(Level.SEVERE); // Sadece errorları göster
      System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
      ChromeOptions options=new ChromeOptions(); //google ı güncellerse bu 3 satırı aç 36yı yoruma al
      options.addArguments("--remote-allow-origins=*");
      driver=new ChromeDriver(options);
      Duration dr=Duration.ofSeconds(30);
      driver.manage().timeouts().pageLoadTimeout(dr);
      driver.manage().timeouts().implicitlyWait(dr);



  }
  @AfterClass
    void bitiIslemleri(){

      System.out.println("Bitiş işlemleri yapılıyor");

      Tools.Bekle(3);
      driver.quit();
  }

}
