package Gun04;

import org.testng.annotations.Test;

public class _03_Groups {
    @Test(groups = {"SmokeTest"})
    void test1(){
        System.out.println("test 1");}

    @Test(groups = {"Regression"})
    void test3(){
        System.out.println("test 3");}

    @Test(groups ={"Regression"})
    void test5(){
        System.out.println("test 5");}

    @Test(groups = {"Regression"})
    void test2(){
        System.out.println("test 2");}

    @Test(groups = {"SmokeTest"})
    void test4(){
        System.out.println("test 4");}

    @Test(groups = {"SmokeTest"})
    void test6(){
        System.out.println("test 6");}

    @Test
    void test7(){
        System.out.println("test 7");
    }
}
