package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ProfilePage {

    @FindBy(xpath = "//h2[@class=\"title text-center\"]//b")
    public List<WebElement> profileH2Texts;

    @FindBy(id = "id_gender1")
    public WebElement gender;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//select[@data-qa=\"days\"]//option[@value=\"1\"]")
    public WebElement day;

    @FindBy(xpath = "//select[@data-qa=\"months\"]//option[@value=\"1\"]")
    public WebElement month;

    @FindBy(xpath = "//select[@data-qa=\"years\"]//option[@value=\"1984\"]")
    public WebElement year;

    @FindBy(id = "newsletter")
    public WebElement newsletterButton;

    @FindBy(id = "optin")
    public WebElement receiveOffersButton;

    @FindBy(id = "first_name")
    public WebElement name;

    @FindBy(id = "last_name")
    public WebElement lastName;

    @FindBy(id = "company")
    public WebElement company;

    @FindBy(id = "address1")
    public WebElement addressLine1;

    @FindBy(id = "address2")
    public WebElement getAddressLine2;

    @FindBy(xpath = "//select[@data-qa=\"country\"]//option[@value=\"United States\"]")
    public WebElement country;

    @FindBy(id = "state")
    public WebElement state;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "zipcode")
    public WebElement zipCode;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumber;

    public ProfilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
