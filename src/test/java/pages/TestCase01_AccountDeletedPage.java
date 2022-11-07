package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestCase01_AccountDeletedPage {

    @FindBy(css = "h2>b")
    public WebElement accountDeletedText;

    @FindBy(xpath = "//a[@data-qa=\"continue-button\"]")
    public WebElement continueButton;

    public TestCase01_AccountDeletedPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
