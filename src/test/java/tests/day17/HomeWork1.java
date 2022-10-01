package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork1 extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1() {


        //“http://zero.webappsecurity.com/” Adresine gidin


        //Sign in butonuna basin


        //Login kutusuna “username” yazin


        //Password kutusuna “password” yazin


        //Sign in tusuna basin


        //*** bu site güvenli baglantı saaglayamıyor navigate().back komutu ile aşabiliriz.
       driver.navigate().back();

       //Online banking menusu icinde Pay Bills sayfasina gidin

        //“Purchase Foreign Currency” tusuna basin


        //“Currency” drop down menusunden Eurozone’u secin
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        dropDown.sendKeys("Eurozone (euro)");

        //soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        String actualDropDownTitle = dropDown.getAccessibleName();
        softAssert.assertNotEquals(actualDropDownTitle, "Eurozone (Euro)");

        //soft assert kullanarak "Eurozone (Euro)" secildigini test edin

        //soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
        // "China  (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
        // "Hong Kong  (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
        // "New Zealand  (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
        Select select = new Select(dropDown);
        List<WebElement> list=select.getOptions();
        List<String> expectedList = new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)",
                "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)",
                "Norway (krone)", "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"));
        for (int i = 0; i < expectedList.size(); i++) {
            softAssert.assertEquals(list.get(i).getText(), expectedList.get(i));
        }
        softAssert.assertAll();
        driver.quit();
    }
}
