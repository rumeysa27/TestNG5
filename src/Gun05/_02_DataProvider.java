package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider {

    /**
     * Aşağıdaki ikili ile Dataproviderın içindeki bütün veriler tek tek test e gönderilerek
     * data sayısı kadar test çalıştırılır, dataların olduğu yere DataProvider annottion ı konur.
     * çalıştırılacak teste ise dataProvider = "getData"  bölümü eklenir.
     * Dataprovider bir testi birden fazla DATA ile çok çalıştırmak için kullanılır.
     * XML filer file gruplama, pararalel, ve farklı tesleri koordine edip birarada çalıştırmak için kullanılır.
     */

    @Test(dataProvider ="datalarim" )
    //burası hem parmetre hem data alabilir
    void UserNameTest(String useradi){
        System.out.println("useradi = " + useradi);
    }

    @DataProvider // bu metoda dataprovider görevi verildi.
    Object[] datalarim() // DataProvider olarak kullanılcak metodun tipi Object olmak zorunda. her tipi kapsayabilir diye object yaptık string int gibi..
    {
        Object[] userlar={"Nurhayat","Alper","Uğur","Hakan"};

        return userlar;
    }

    /*********************************/

    @Test(dataProvider ="datalarim1" )
    void UserNameTest1(int id){
        System.out.println("useradi = " + id);
    }

    @DataProvider
        // bu metoda dataprovider görevi verildi.
    Object[] datalarim1() // DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.
    {
        Object[] userlar={1,2,3,4};

        return userlar;
    }
}
