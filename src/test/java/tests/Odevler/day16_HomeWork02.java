package tests.Odevler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class day16_HomeWork02 extends TestBaseBeforeClassAfterClass {
    // 3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    // 1) Bir class oluşturun: YoutubeAssertions
    // 2) "https://www.youtube.com" adresini gidin


    //aynı sayfada yapılacak testler için TestBaseBeforeClassAfterClass kullanılmalıdır
    // çünkü ilk testtte Web sayfası açılmakta,
    // diğer testlerde bu web sayfası üzerinden testler yapılmaktadır.diğer turlu
    // TestBaseBeforeMethodAfterMethod kullanılsa her testte
    //adres vermek gerekir ve dinamik olmaz


    @Test(priority = 1)
    public void testTittle() {
        // ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        driver.get("https://www.youtube.com");
        String expectedTitle ="YouTube";
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle :"+actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);//bu satırda acıklama olunca hata veriyor
    }

    @Test(priority = 2)
    public void testimageTest() {
        // ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youtubeIcon = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(youtubeIcon.isDisplayed());
    }

    @Test(priority = 3)
    public void testSearcBox() {
        // ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement serchBox = driver.findElement(By.xpath("(//*[@id='search'])[1]"));
        Assert.assertTrue(serchBox.isEnabled());

    }
    @Test(priority = 4)
    public void testwrongTitleTest() {
        // ○ wrongTitleTest => Sayfa basliginin "youtube" olmadigini dogrulayin
        String expectedTittle = "youtube";
        String actualTittle = driver.getTitle();
        Assert.assertNotEquals(expectedTittle,actualTittle);

    }
}

