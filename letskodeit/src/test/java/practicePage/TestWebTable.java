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

public class TestWebTable extends BaseTestSuite {
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
    public void testGetValues(){
        boolean isPresent = generic.isAvailable("xpath", "//table[@id='product']");
        if(!isPresent){
            System.out.println("Element is not present");
            return;
        }

        List<WebElement> elements = generic.getElements("xpath", "//table[@id='product']//td");
        int i=0;
        for(WebElement element : elements){
            if(i%3 == 0 || i==0){
                i++;
                continue;
            }
            System.out.println("Course name : " + element.getText());
            i++;
        }
    }
}
