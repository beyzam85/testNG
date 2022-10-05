package tests.day21;

import org.testng.annotations.Test;
import tests.day18.C03_ConfigReader;
import utilities.ConfigReader;
import utilities.Driver;

public class HomeWork {
    @Test
    public void test01() {
        //Hepsiburada sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("hpsbrdUrl"));
        //Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım

        //Her linkten sonra o sayfaya gittimizi test edelim ve o sayfanız resmini alalım
        //Sayfayı kapatalım
    }
}