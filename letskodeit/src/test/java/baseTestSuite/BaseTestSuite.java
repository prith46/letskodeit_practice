package baseTestSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTestSuite {

    public static WebDriver driver;
    String baseURL = "https://www.letskodeit.com/practice";

    @BeforeSuite
    @Parameters({"browser"})
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
