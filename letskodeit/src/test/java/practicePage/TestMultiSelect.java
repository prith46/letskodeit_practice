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

public class TestMultiSelect extends BaseTestSuite {

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
    public void testEachMultiSelect() throws InterruptedException {
        boolean isPresent = generic.isAvailable("xpath", "//select[@id='multiple-select-example']//option");
        if (!isPresent){
            System.out.println("Element is not present");
            return;
        }
        List<WebElement> elements = generic.getElements("xpath", "//select[@id='multiple-select-example']//option");
        for(WebElement element : elements){
            element.click();
            Thread.sleep(1000);

            if(!element.isSelected()){
                System.out.println("Error in selecting the element");
                return;
            }
            element.click();
        }
    }
}
