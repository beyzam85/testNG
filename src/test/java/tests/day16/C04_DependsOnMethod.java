package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C04_DependsOnMethod extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1() {
        // amazon ana sayfasına gidelim
        driver.get("https://www.amazon.com");
    }

    @Test (dependsOnMethods = "test1") //depends on dayanmak demek.test 1 e bagımlı calışır demek
                                       // hata varsa aralarda dependson konulursa aralarda çıkan hatalarda sonuna
                                       // kadar beklenmemiş olur hatalar bulunmus olur ve daha cabuk
                                       // mudahale edilmiş olur
    public void test2() {
        //Nutella aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
    }

    @Test (dependsOnMethods = "test2")
    public void test3() {

        //Sonuc yazısının amazon içerdiğini test edelim
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertFalse(sonuc.getText().contains("amazon"));
    }
}
