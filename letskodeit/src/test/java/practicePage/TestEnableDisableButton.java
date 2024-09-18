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

public class TestEnableDisableButton extends BaseTestSuite {

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
    public void testDisableButton() {
        boolean isPresent = generic.isAvailable("xpath", "//input[@id='enabled-example-input']");
        if(!isPresent){
            System.out.println("Element not found");
            return;
        }

        WebElement button = generic.getElement("xpath", "//input[@id='enabled-button']");
        button.click();
        WebElement element = generic.getElement("xpath", "//input[@id='enabled-example-input']");
        boolean isEnabled = element.isEnabled();
        if (isEnabled){
            generic.getElement("xpath", "//input[@id='disabled-button']").click();
            element = generic.getElement("xpath", "//input[@id='enabled-example-input']");
            isEnabled = element.isEnabled();
            if(isEnabled){
                System.out.println("Error in disabling");
                return;
            }
        }
    }

    @Test
    public void testEnableButton() throws InterruptedException {
        boolean isPresent = generic.isAvailable("xpath", "//input[@id='enabled-example-input']");
        if(!isPresent){
            System.out.println("Element not found");
            return;
        }

        WebElement button = generic.getElement("xpath", "//input[@id='disabled-button']");
        button.click();
        WebElement element = generic.getElement("xpath", "//input[@id='enabled-example-input']");
        boolean isEnabled = element.isEnabled();
        if(!isEnabled){
            generic.getElement("xpath", "//input[@id='enabled-button']").click();
            element = generic.getElement("xpath", "//input[@id='enabled-example-input']");
            isEnabled = element.isEnabled();
            if(!isEnabled){
                System.out.println("Error in disabling");
                return;
            }
            element.sendKeys("Testing");
            String text = element.getAttribute("value");
            if (!text.equals("Testing")){
                System.out.println("Error in sending text");
            }
        }
    }
}
