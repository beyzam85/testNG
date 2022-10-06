package tests.Practice08;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerokuTestPage;
import utilities.Driver;

import java.util.List;

public class P01 {

//class seviyesinde olusturduk
HerokuTestPage herokuTestPage;
Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() throws InterruptedException {
        //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        Driver.getDriver().get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        //Click all the buttons and verify they are all clicked
        herokuTestPage = new HerokuTestPage();


        //kodlarımızı yazrken clean kod kapsamında daha sade kod yazabilmek amacıyla
        //her test methodu içerisinde, ayrı bir object create temektense bu
        // objecti class seviyesinde instance olarak create edip
        //test methodlarında buna değer atamak ve kullanmak daha uygun bir yöntemdir

        herokuTestPage.onBlur.click();
        herokuTestPage.onClick.click();
        herokuTestPage.onClick.click();
        actions.contextClick(herokuTestPage.onContextMenu).
                doubleClick(herokuTestPage.onDoubleClick).
                click(herokuTestPage.onFocus).
                click(herokuTestPage.onKeyDown)
                .sendKeys(Keys.ENTER).
                click(herokuTestPage.onKeyUp).
                sendKeys(Keys.ENTER).
                click(herokuTestPage.onKeyPress).
                sendKeys(Keys.ENTER).
                moveToElement(herokuTestPage.onMouseOver).
                moveToElement(herokuTestPage.onMouseLeave).
                moveToElement(herokuTestPage.onMouseOver).
                click(herokuTestPage.onMouseDown).perform();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        List<WebElement> trig = herokuTestPage.eventTriggered;
        Assert.assertTrue(trig.size()==11);
    }
    }



