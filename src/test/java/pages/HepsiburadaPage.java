package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiburadaPage {
    public HepsiburadaPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
@FindBy(xpath = "(//*[text()='Elektronik'])[1]")
    public WebElement elektronik;

    @FindBy(xpath = "(//*[@href='https://www.hepsiburada.com/bilgisayarlar-c-2147483646'])[2]")
    public WebElement bilgisayarTablet;
}