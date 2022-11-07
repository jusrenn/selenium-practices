package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountDeletedPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

/*
    *** Login User with correct email and password ***
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter correct email address and password
    7. Click 'login' button
    8. Verify that 'Logged in as username' is visible
    9. Click 'Delete Account' button
    10. Verify that 'ACCOUNT DELETED!' is visible
 */
public class TestCase02 {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AccountDeletedPage accountDeletedPage = new AccountDeletedPage();

    @BeforeClass
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @Test(priority = 1)
    public void isVisibleHomePage() {
        Assert.assertEquals(homePage.menuLinks.get(0).getAttribute("style"), "color: orange;");
    }

    @Test(priority = 2)
    public void goToLoginPage() {
        homePage.menuLinks.get(3).click();
    }

    @Test(priority = 3)
    public void verifyLoginToYourAccountText() {
        Assert.assertEquals(loginPage.loginToYourAccountText.getText(), "Login to your account");
    }

    @Test(priority = 4)
    public void enterCorrentEmailAddressAndPassword() {
        loginPage.loginEmailAddress.sendKeys(ConfigReader.getProperty("userEmail"));
        loginPage.loginPassword.sendKeys(ConfigReader.getProperty("userPassword"));
    }

    @Test(priority = 5)
    public void clickLoginButton() {
        loginPage.loginButton.click();
    }

    @Test(priority = 6)
    public void verifyLoggedInAsUsername() {
        Assert.assertEquals(homePage.menuLinks.get(9).getText(), "Logged in as " + ConfigReader.getProperty("userName"));
    }

    @Test(priority = 7)
    public void deleteAccountButton() {
        homePage.menuLinks.get(4).click();
    }

    @Test(priority = 8)
    public void verifyAccountDeletedText() {
        Assert.assertEquals(accountDeletedPage.accountDeletedText.getText(), "ACCOUNT DELETED!");
        accountDeletedPage.continueButton.click();
    }

    @AfterClass
    public void close() {
        Driver.closeDriver();
    }
}
