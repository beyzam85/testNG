package tests.day17;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C01_DependsOnMethods extends TestBaseBeforeMethodAfterMethod {
    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
    }

    @Test(dependsOnMethods = "test01")
    public void testtest02() {
        driver.get("https://facebook.com");

    }

    @Test(dependsOnMethods = "test02")
    public void testtest03() {
      driver.get("https://bestbuy.com");
    }

    @Test(priority = -1)
    public void test04() {
        driver.get("https://www.youtube.com");
    }
}
