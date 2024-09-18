package practicePage;

import GenericMethods.GenericMethods;
import baseTestSuite.BaseTestSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestRadioButton extends BaseTestSuite {
    WebDriver driver;
    GenericMethods generic;

    @BeforeClass
    public void setupClass(){
        driver = getDriver();
        generic = new GenericMethods(driver);
    }

    @Test
    public void testEachButton() {

        boolean isPresent = generic.isAvailable("xpath","//div[@id='radio-btn-example']//input");
        System.out.println(isPresent);
        if (isPresent) {
            List<WebElement> elements = generic.getElements("xpath", "//div[@id='radio-btn-example']//input");
            for (WebElement element : elements) {
                element.click();
            }
        }
    }
}
