package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HepsiBuradaPage {
    public HepsiBuradaPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
@FindBy(xpath = "(//*[text()='Elektronik'])[1]")
    public WebElement elektronikButton;

    @FindBy(xpath = "(//a[text()='Bilgisayar/Tablet']")
    public WebElement bilgisayarTabletButton;

    @FindBy (xpath = "(//div[@class='sf-ChildMenuItems-OMxRJDk0466HYQpTli0P'])[1]//span")
     public List<WebElement> sixtysixWE;

    @FindBy (xpath = "(//div[@class='sf-ChildMenuItems-OMxRJDk0466HYQpTli0P'])[1]")
    public WebElement sixtysixPlace;




}