package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ReusableMethods {

    public static void takeScreenshot(String fileName) {
        try {
            File file = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(ConfigReader.getProperty("screenshotsPath") + fileName + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void waitElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
