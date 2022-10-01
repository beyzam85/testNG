package tests.day19;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_NegatifTest {
    @Test
    public void negatifTest() {
        //1 ) Bir Class olustur : NegativeTest
        //2) Bir test method olustur NegativeLoginTest()

        //https://www.hotelmycamp.com/ adresine git
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));

        //login butonuna bas
        hotelMyCampPage.login.click();

        //test data username: manager1 ,
        // test data password : manager1!

        hotelMyCampPage.userName.sendKeys(ConfigReader.getProperty("hmcWrongUser"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcWrongPass")).
                sendKeys(Keys.TAB,Keys.ENTER).perform();

        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hotelMyCampPage.girisYapilamadi.isDisplayed());

        //Sayfayi kapatınız
        Driver.closeDriver();
    }
}
