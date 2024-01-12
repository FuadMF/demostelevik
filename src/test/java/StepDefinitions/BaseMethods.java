package StepDefinitions;

import DriverSession.CucumberHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseMethods {

    public  WebDriver driver = CucumberHooks.driver;


    protected WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    protected List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }

    protected int generateRanNum(int size){
        return (int) (Math.random()*size);
    }

    protected WebElement searchInsideDiv(By locator,String text){
        List<WebElement>elements = getElements(locator);
        for (WebElement element:elements){
            if (element.getText().contains(text)){
                return element;
            }
        }
        return null;
    }
}
