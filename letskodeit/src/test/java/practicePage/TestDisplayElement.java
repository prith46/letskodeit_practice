package practicePage;

import GenericMethods.GenericMethods;
import baseTestSuite.BaseTestSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDisplayElement extends BaseTestSuite {
    WebDriver driver;
    GenericMethods generic;
    ExtentReports reports;
    ExtentTest test;

    @BeforeClass
    public void setupClass(){
        driver = getDriver();
        generic = new GenericMethods(driver);
        reports = new ExtentReports("E://Selenium//reports//LetsKodeit.html");
        test = reports.startTest("Verify Radio button");
        test.log(LogStatus.INFO, "Browser Started...");
    }

    @Test
    public void testHideButton(){
        WebElement element = generic.getElement("id", "displayed-text");
        if (element.isDisplayed()){
            generic.getElement("id", "hide-textbox").click();
        }
        if (element.isDisplayed()){
            System.out.println("Hide Button is not working");
        }
    }

    @Test
    public void testShowButton() {
        WebElement element = generic.getElement("id", "displayed-text");
        if (!element.isDisplayed()){
            generic.getElement("id", "show-textbox").click();
        }
        if (!element.isDisplayed()){
            System.out.println("Show Button is not working");
        }
    }
}
