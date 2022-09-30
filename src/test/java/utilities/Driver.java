package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    static WebDriver driver;  //driver e her yerden ulaşabilmek için static yapıldı
    /*
    teslerimizi calıştırdıgımızda her seferinde yani driver oluşturdugu için her test methodu
    için yeni bir pencer(driver) acıyor. eger driver a bir deger atanmamişsa yani driver == null ise
    bir kere driver i calıstır diyerek bir kere if içini calıstıracak. ve driver artık bir kere
    çalıştıgı için ve deger atandığı için null olmayacak ve direk return edecek ve diğer testlerimiz
    aynıpencere(driver uzerinde çalişacak.)
     */

    public static WebDriver getDriver() {

        if (driver == null) { //coklu cagirmada ayni browserda acmak için
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();//bos açilan chrome

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;

    }

    public static void closeDriver() {
        if (driver != null) {  // driver e deger atanmamışsa
            driver.close();
            driver = null;  //kapandıktan sonra ki açmaları garanti altına almak için driver i tekrar null yaptık
        }

    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;

        }
    }
}