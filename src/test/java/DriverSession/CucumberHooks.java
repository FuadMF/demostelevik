package DriverSession;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHooks {
    public static WebDriver driver;


    @Before
    public void beforeScenario(){
        driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/aspnet-core/eshop/Account/Login");
    }

    @After
    public void afterScenario(){
        driver.quit();
    }
}
