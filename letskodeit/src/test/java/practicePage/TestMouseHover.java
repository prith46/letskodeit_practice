package practicePage;

import GenericMethods.GenericMethods;
import baseTestSuite.BaseTestSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMouseHover extends BaseTestSuite {

    WebDriver driver;
    GenericMethods generic;
    ExtentReports reports;
    ExtentTest test;
    Actions actions;
    JavascriptExecutor js;

    @BeforeClass
    public void setupClass(){
        driver = getDriver();
        generic = new GenericMethods(driver);
        reports = new ExtentReports("E://Selenium//reports//LetsKodeit.html");
        test = reports.startTest("Verify Radio button");
        test.log(LogStatus.INFO, "Browser Started...");
    }

    @Test
    public void testMouseTop() throws InterruptedException {
        js.executeScript("window.scrollBy(0, 200);");
        WebElement element = generic.getElement("id", "mousehover");
        actions.moveToElement(element).perform();
        Thread.sleep(500);
        WebElement subElement = generic.getElement("xpath", "//div[@class='mouse-hover-content']/a");
        actions.moveToElement(subElement).click().perform();
    }

    @Test
    public void testMouseReload() throws InterruptedException {
        js.executeScript("window.scrollBy(0, 200);");
        WebElement element = generic.getElement("id", "mousehover");
        actions.moveToElement(element).perform();
        WebElement subElement = generic.getElement("xpath", "//div[@class='mouse-hover-content']/a[2]");
        actions.moveToElement(subElement).click().perform();
        Thread.sleep(2000);
    }
}
