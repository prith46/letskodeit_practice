package GenericMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GenericMethods {
    WebDriver driver;

    public GenericMethods(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getElement(String type, String locator){
        type = type.toLowerCase();
        switch (type) {
            case "id": return driver.findElement(By.id(locator));
            case "xpath": return driver.findElement(By.xpath(locator));
            case "css": return driver.findElement(By.cssSelector(locator));
            case "linktext": return driver.findElement(By.linkText(locator));
            case "partiallinktext": return driver.findElement(By.partialLinkText(locator));
            default:
                System.out.println("Type is not supported");
                return null;
        }
    }

    public List<WebElement> getElements(String type, String locator){
        type = type.toLowerCase();
        switch (type){
            case "id": return driver.findElements(By.id(locator));
            case "xpath": return driver.findElements(By.xpath(locator));
            case "css": return driver.findElements(By.cssSelector(locator));
            case "linktext": return driver.findElements(By.linkText(locator));
            case "partiallinktext": return driver.findElements(By.partialLinkText(locator));
            default:
                System.out.println("Type is not supported");
                return null;
        }
    }

    public boolean isAvailable(String type, String locator){
        List<WebElement> elements = getElements(type, locator);
        if(elements.isEmpty()){
            System.out.println("Element is not available");
            return false;
        }
        return true;
    }
}
