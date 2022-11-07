package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestCase01_AccountConfirmPage {

    @FindBy(css = "h2>b")
    public WebElement accountConfirmText;

    @FindBy(xpath = "//a[@data-qa=\"continue-button\"]")
    public WebElement continueButton;

    public TestCase01_AccountConfirmPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
