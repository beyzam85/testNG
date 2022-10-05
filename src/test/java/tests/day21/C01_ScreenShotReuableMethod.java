package tests.day21;

import org.junit.Test;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShotReuableMethod {
    @Test
    public void test01() throws IOException {
        //hepsiburada sayfasına gidiniz
        Driver.getDriver().get("https://hepsiburada.com");

        //ve sayfanın resmini alınız
       ReusableMethods.getScreenshot("hepsiburada");

        //sayfayı kapatınız
        Driver.closeDriver();
    }

    @Test
    public void test02() throws IOException {
        //Amazon sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        AmazonPage amazonPage = new AmazonPage();
        //nutella aratınız
        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //arama sonuc yazısı Webelementinin resmini alınız
        ReusableMethods.getScreenshotWebElement("AramaSonucuWE",amazonPage.aramaSonucWE);
    }
}
