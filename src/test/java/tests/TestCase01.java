package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

/*
    *** Register User Test ***
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and email address
    7. Click 'Signup' button
    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    9. Fill details: Title, Name, Email, Password, Date of birth
    10. Select checkbox 'Sign up for our newsletter!'
    11. Select checkbox 'Receive special offers from our partners!'
    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    13. Click 'Create Account button'
    14. Verify that 'ACCOUNT CREATED!' is visible
    15. Click 'Continue' button
    16. Verify that 'Logged in as username' is visible
    17. Click 'Delete Account' button
    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
 */
public class TestCase01 {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();
    AccountConfirmPage accountConfirmPage = new AccountConfirmPage();
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
    public void verifyNewUserSignupText() {
        Assert.assertEquals(loginPage.newUserSignupText.getText(), "New User Signup!");
    }

    @Test(priority = 4)
    public void fillNewUserForm() {
        loginPage.signupNameInput.sendKeys(ConfigReader.getProperty("userName"));
        loginPage.signupEmailInput.sendKeys(ConfigReader.getProperty("userEmail"));
    }

    @Test(priority = 5)
    public void clickSignupButton() {
        loginPage.signupButton.click();
    }

    @Test(priority = 6)
    public void verifyEnterAccountInformationText() {
        Assert.assertEquals(profilePage.profileH2Texts.get(0).getText(), "ENTER ACCOUNT INFORMATION");
    }

    @Test(priority = 7)
    public void fillDetailsInProfilePage1() {
        profilePage.gender.click();
        profilePage.password.sendKeys(ConfigReader.getProperty("userPassword"));
        profilePage.day.click();
        profilePage.month.click();
        profilePage.year.click();
        profilePage.name.sendKeys("Yusuf");
        profilePage.lastName.sendKeys("Renkoglu");
    }

    @Test(priority = 8)
    public void selectNewsletter() {
        profilePage.newsletterButton.click();
    }

    @Test(priority = 9)
    public void selectReceiveOffers() {
        profilePage.receiveOffersButton.click();
    }

    @Test(priority = 10)
    public void fillDetailsInProfilePage2() {
        profilePage.company.sendKeys("-");
        profilePage.addressLine1.sendKeys("Helsinki");
        profilePage.getAddressLine2.sendKeys("Adres Line 2");
        profilePage.country.click();
        profilePage.state.sendKeys("-");
        profilePage.city.sendKeys("Helsinki");
        profilePage.zipCode.sendKeys("00001");
        profilePage.mobileNumber.sendKeys("0440000000");
    }

    @Test(priority = 11)
    public void clickToCreateAccountButton() {
        profilePage.mobileNumber.sendKeys(Keys.ENTER);
    }

    @Test(priority = 12)
    public void verifyAccountConfirmedText() {
        Assert.assertEquals(accountConfirmPage.accountConfirmText.getText(), "ACCOUNT CREATED!");
    }

    @Test(priority = 13)
    public void clickToContinueButton() {
        accountConfirmPage.continueButton.click();
    }

    @Test(priority = 14)
    public void verifyLoggedInAsUsername() {
        Assert.assertEquals(homePage.menuLinks.get(9).getText(), "Logged in as " + ConfigReader.getProperty("userName"));
    }

    @Test(priority = 15)
    public void deleteAccountButton() {
        homePage.menuLinks.get(4).click();
    }

    @Test(priority = 16)
    public void verifyAccountDeletedText() {
        Assert.assertEquals(accountDeletedPage.accountDeletedText.getText(), "ACCOUNT DELETED!");
        accountDeletedPage.continueButton.click();
    }

    @AfterClass
    public void close() {
        Driver.closeDriver();
    }
}
