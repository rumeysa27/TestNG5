package Gun04;

import org.testng.annotations.*;

public class _01_Intro {

    /*
     @BeforeSuite //öcekileri kapat daha test çalşmadan önce başlıyo hepsinin üstünde çalışıyo bu birden fazla class olduğunda
       @BeforeTest
         @BeforeGroup
           @BeforeClass
             @BeforeMethod
                 @Test1 method
                 @Test2 method
             @AfterMethod
           @AfterClass
         @AfterGroup
       @AfterTest
     @AfterSuite
   */
    @BeforeSuite
    void bSuite(){
        System.out.println("Before Suite"); }

    @BeforeTest
    void bTest(){
        System.out.println("Before Test");  }

@BeforeGroups
void bGroups(){
    System.out.println("Before groups"); }

    @BeforeClass
    void bClass() { System.out.println("Before Class"); }

    @BeforeMethod
    void bMethod() { System.out.println("Before Metod"); }

    @Test
    void Intro1_Test1() { System.out.println("Intro_1 -> Test 1"); }

    @Test
    void Intro1_Test2() { System.out.println("Intro_1 -> Test 2"); }

    @AfterMethod
    void aMethod() { System.out.println("After Metod"); }

    @AfterClass
    void aClass() { System.out.println("After Class"); }

    @AfterGroups
    void aGroups(){
        System.out.println("After Groups");   }

    @AfterTest
    void aTest(){
        System.out.println("After Test");   }

    @AfterSuite
    void aSuite(){
        System.out.println("After Suite");   }


}
