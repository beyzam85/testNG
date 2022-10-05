package tests.day18;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_ConfigReader {
    @Test(groups = "gp2")
    public void test01() {
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

        //https://www.hotelmycamp.com/ adresine git  login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        hotelMyCampPage.login.click();


        //test data username: manager ,  test data password : Manager1!
        hotelMyCampPage.userName.sendKeys(ConfigReader.getProperty("hmcUserName"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcPassword")).
                sendKeys(Keys.TAB,Keys.ENTER).perform();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test e
        hotelMyCampPage.login.click();


    }
}
