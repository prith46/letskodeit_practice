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

import java.util.List;

public class TestCheckbox extends BaseTestSuite {
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
    public void testEachCheckBox(){
        boolean isPresent = generic.isAvailable("xpath", "//div[@id='checkbox-example-div']//input");
        if(isPresent){
            List<WebElement> elements = generic.getElements("xpath", "//div[@id='checkbox-example-div']//input");
            for(WebElement element : elements){
                element.click();
            }
            for(WebElement element : elements){
                element.click();
            }
        }
    }
}
