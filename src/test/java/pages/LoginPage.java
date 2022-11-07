package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    @FindBy(css = ".signup-form>h2")
    public WebElement newUserSignupText;

    @FindBy(css = ".login-form>h2")
    public WebElement loginToYourAccountText;

    @FindBy(xpath = "//input[@data-qa=\"signup-name\"]")
    public WebElement signupNameInput;

    @FindBy(xpath = "//input[@data-qa=\"login-email\"]")
    public WebElement loginEmailAddress;

    @FindBy(xpath = "//input[@data-qa=\"login-password\"]")
    public WebElement loginPassword;

    @FindBy(xpath = "//input[@data-qa=\"signup-email\"]")
    public WebElement signupEmailInput;

    @FindBy(xpath = "//button[@data-qa=\"signup-button\"]")
    public WebElement signupButton;

    @FindBy(xpath = "//button[@data-qa=\"login-button\"]")
    public WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
