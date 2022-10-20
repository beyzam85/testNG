package tests.log4J;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import tests.day21.C01_ScreenShotReuableMethod;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class Log4JOrnek {

    //dat21 - C01_ScreenShotReusableMethod.class.getName() den aldık

    private static Logger logger = LogManager.getLogger( C01_ScreenShotReuableMethod.class.getName());
    @Test
    public void test01() throws IOException {

        logger.info("Hepsi Burada sitesine gidilir");
        //Hepsiburada sayfasına gidiniz
        Driver.getDriver().get("https://hepsiburada.com");

        logger.info("Ekran goruntusu Alinir");
        //Ve sayfanın resmini alınız
        ReusableMethods.getScreenshot("hepsiburada");

        logger.warn("Driver kapatilir");
        //Sayfayı kapatınız
        Driver.closeDriver();

    }

    @Test
    public void test02() throws IOException {

        //Amazon sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        AmazonPage amznPage = new AmazonPage();
        //Nutella aratınız
        amznPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        //Arama sonuc yazısı Webelementinin resmini alınız
        ReusableMethods.getScreenshotWebElement("AramaSonucWE",amznPage.aramaSonucWE);
    }
}



