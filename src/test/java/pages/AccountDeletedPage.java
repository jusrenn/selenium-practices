package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountDeletedPage {

    @FindBy(css = "h2>b")
    public WebElement accountDeletedText;

    @FindBy(xpath = "//a[@data-qa=\"continue-button\"]")
    public WebElement continueButton;

    public AccountDeletedPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
