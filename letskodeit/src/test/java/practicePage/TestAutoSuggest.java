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

public class TestAutoSuggest extends BaseTestSuite {

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
    public void testAutoSuggest() throws InterruptedException {
        boolean isPresent = generic.isAvailable("xpath", "//input[@id='autosuggest']");
        if (isPresent){
            WebElement element = generic.getElement("xpath", "//input[@id='autosuggest']");
            element.sendKeys("pyt");
            Thread.sleep(500);
            List<WebElement> elements = generic.getElements("xpath", "//ul[@id='ui-id-1']//li");
            if (elements.size() != 3){
                System.out.println("Check the elements out, it is not matching");
                return;
            }

            element.clear();
            element.sendKeys("auto");
            Thread.sleep(500);
            elements = generic.getElements("xpath", "//ul[@id='ui-id-1']//li");
            if (elements.size() != 8){
                System.out.println("Check the elements out, it is not matching");
                return;
            }
        }
    }
}
