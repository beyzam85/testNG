package tests.day23;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BlueRentalCarPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {

    @DataProvider
    public static Object[][] kullanicilar() {
        return new Object[][]{{"beyza@gmail.com","12345"},{"mahir@gmail.com","6789"},{"elif@gmail.com","98765"}};
    }

    @Test(dataProvider = "kullanicilar")
    public void test01(String emailAdres,String password) {

        //https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //login butonuna bas
        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        blueRentalCarPage.login.click();

        //Data provider ile 3 farklı userEmail ve 3 farklı password girelim
        blueRentalCarPage.emailAdres.sendKeys(("userEmail"));

        //login butonuna tiklayin
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("pass"))
                .sendKeys(Keys.ENTER).perform();

        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(blueRentalCarPage.ikincilogin.isDisplayed());

    }
}
