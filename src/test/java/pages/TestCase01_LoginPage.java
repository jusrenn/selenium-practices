package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestCase01_LoginPage {

    @FindBy(css = ".signup-form>h2")
    public WebElement newUserSignupText;

    @FindBy(xpath = "//input[@data-qa=\"signup-name\"]")
    public WebElement signupNameInput;

    @FindBy(xpath = "//input[@data-qa=\"signup-email\"]")
    public WebElement signupEmailInput;

    @FindBy(xpath = "//button[@data-qa=\"signup-button\"]")
    public WebElement signupButton;

    public TestCase01_LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
