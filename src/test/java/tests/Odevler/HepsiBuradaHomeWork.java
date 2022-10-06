package tests.Odevler;

import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import pages.HerokuTestPage;
import tests.day18.C03_ConfigReader;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class HepsiBuradaHomeWork {
    @Test
    public void test01() throws IOException {
        //Hepsiburada sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("hpsbrdUrl"));

        //Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım
        HepsiBuradaPage hepsiBuradaPage = new HepsiBuradaPage();

        hepsiBuradaPage.elektronikButton.click();                        //sixtysixWE liste atama
        ReusableMethods.hover(hepsiBuradaPage.elektronikButton);         //yapılabilmesi için açılır menunun en az bir defa
        ReusableMethods.waitForVisibility(hepsiBuradaPage.bilgisayarTabletButton,3);//gorunur olması gerekir
        ReusableMethods.hover(hepsiBuradaPage.bilgisayarTabletButton);


        int sixtysisCount = hepsiBuradaPage.sixtysixWE.size();
        for(int i =63; i < sixtysisCount; i++) {


            hepsiBuradaPage.elektronikButton.click();
            ReusableMethods.hover(hepsiBuradaPage.elektronikButton);
            ReusableMethods.waitForVisibility(hepsiBuradaPage.bilgisayarTabletButton,3);
            ReusableMethods.hover(hepsiBuradaPage.bilgisayarTabletButton);
            ReusableMethods.waitForVisibility(hepsiBuradaPage.sixtysixPlace,3);

            hepsiBuradaPage.sixtysixWE.get(i).click();

            //Her linkten sonra o sayfaya gittimizi test edelim ve o sayfanız resmini alalım
            //Sayfayı kapatalım

            ReusableMethods.getScreenshot("hepsiburada - ");
            Driver.getDriver().navigate().back();
        }
    }
}