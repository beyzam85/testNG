package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.awt.*;

public class SauceDemoPage {


        public SauceDemoPage() {
                PageFactory.initElements(Driver.getDriver(), this);
        }
        @FindBy (id = "user-name")
        public WebElement userName;

        @FindBy (xpath = "//input[@id='password']")
        public WebElement password;

        @FindBy (className = "product_sort_container")
        public WebElement ddm;

}



