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

public class TestRadioButton extends BaseTestSuite {
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
    public void testEachButton() {
        boolean isPresent = generic.isAvailable("xpath","//div[@id='radio-btn-example']//input");
        if (isPresent) {
            List<WebElement> elements = generic.getElements("xpath", "//div[@id='radio-btn-example']//input");
            for (WebElement element : elements) {
                element.click();
            }
        }
        test.log(LogStatus.PASS, "Testing Each button");
    }

    @Test
    public void testMultiplebutton(){
        boolean isPresent = generic.isAvailable("xpath","//div[@id='radio-btn-example']//input");
        if (isPresent) {
            List<WebElement> elements = generic.getElements("xpath", "//div[@id='radio-btn-example']//input");
            for (WebElement element : elements) {
                int count = 0;
                element.click();
                for(WebElement check : elements){
                    if(check.isSelected()){
                        count++;
                    }
                }
                if (count > 1){
                    System.out.println("Multiple keys are selected");
                    test.log(LogStatus.FAIL, "Testing Multiple button failed");
                    return;
                }
            }
        }
        test.log(LogStatus.PASS, "Testing Multiple button");
    }
}
