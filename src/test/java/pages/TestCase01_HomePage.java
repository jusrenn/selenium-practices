package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestCase01_HomePage {

    @FindBy(css = ".navbar-nav>li>a")
    public List<WebElement> menuLinks;

    public TestCase01_HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
