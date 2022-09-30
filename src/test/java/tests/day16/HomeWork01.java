package tests.day16;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class HomeWork01 extends TestBaseBeforeClassAfterClass {
    /*
    1) Bir class oluşturun: YoutubeAssertions
    2) https://www.youtube.com adresine gidin
    3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    ○ titleTest => Sayfa başlığının "YouTube" oldugunu test edin
    ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
     ○ wrongTitleTest => Sayfa basliginin "youtube" olmadigini dogrulayin
     */

    @Test
    public void test() {
        //https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }
    // 3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    @Test  (dependsOnMethods = "test")
    public void titleTest() {

        // ○ titleTest => Sayfa başlığının "YouTube" oldugunu test edin
        String expectedTitle="YouTube";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(expectedTitle.contains(actualTitle));
    }

    @Test (dependsOnMethods = "titleTest")
    public void imageTest() {
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        // WebElement youTubeImage=driver.findElement(By.xpath("(//*[@class='style-scope ytd-logo'])[1]"));
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='style-scope ytd-logo'])[1]")).isDisplayed());

    }

    @Test (dependsOnMethods = "imageTest")
    public void searchBoxTest() {
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id='search'])[3]")).isEnabled());
    }

    @Test (dependsOnMethods = "searchBoxTest")
    public void wrongTitleTest() {
        //○ wrongTitleTest => Sayfa basliginin "youtube" olmadigini dogrulayin

        Assert.assertNotEquals(driver.getTitle(),"youtube");
    }
}