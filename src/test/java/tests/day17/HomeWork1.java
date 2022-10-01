package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroBankPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork1 extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1() {
        ZeroBankPage zeroBankPage = new ZeroBankPage();

        //“http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroBankUrl"));

        //Sign in butonuna basin
        zeroBankPage.signIn.click();

        //Login kutusuna “username” yazin
        zeroBankPage.loginBox.sendKeys(ConfigReader.getProperty("zeroBankUserName"));

        //Password kutusuna “password” yazin
        zeroBankPage.password.sendKeys(ConfigReader.getProperty("zeroBankPassword"));

        //Sign in tusuna basin
        zeroBankPage.submitSignIn.click();

        //*** bu site güvenli baglantı saaglayamıyor navigate().back komutu ile aşabiliriz.
        driver.navigate().back();

        //Online banking menusu icinde Pay Bills sayfasina gidin
        zeroBankPage.onlineBanking.click();
        zeroBankPage.payBills.click();

        //“Purchase Foreign Currency” tusuna basin
        zeroBankPage.purForCur.click();

        //“Currency” drop down menusunden Eurozone’u secin
        //Select select = new Select(ZeroBankPage.currencyDropDwoMenu);
       // select.selectByVisibleText("Eurozone (euro)");
        //soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(select.getFirstSelectedOption().getText()."Eurozone(euro)");

        //soft assert kullanarak "Eurozone (Euro)" secildigini test edin "Select One";

        //soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
        // "China  (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
        // "Hong Kong  (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
        // "New Zealand  (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

        List<WebElement> expectedList = new ArrayList<>();
        List<WebElement> actualList = zeroBankPage.currencyDropDwoMenuList;
        for (int i = 0; i < actualList.size(); i++) {
            expectedList.add(actualList.get(i));
        }
        for (int i = 0; i < expectedList.size(); i++) {
            softAssert.assertEquals(expectedList.get(i).getText(), actualList.get(i).getText());

            System.out.println(expectedList + "     ");
            System.out.println(actualList.get(i).getText());

        }
        softAssert.assertAll();
    }
}