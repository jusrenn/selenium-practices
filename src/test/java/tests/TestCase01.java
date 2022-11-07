package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase01 {

    TestCase01_HomePage homePage = new TestCase01_HomePage();
    TestCase01_LoginPage loginPage = new TestCase01_LoginPage();
    TestCase01_ProfilePage profilePage = new TestCase01_ProfilePage();
    TestCase01_AccountConfirmPage accountConfirmPage = new TestCase01_AccountConfirmPage();
    TestCase01_AccountDeletedPage accountDeletedPage = new TestCase01_AccountDeletedPage();

    @BeforeClass
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("UrlTest01"));
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
    public void clickToContiuneButton() {
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
