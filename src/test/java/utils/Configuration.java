package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Configuration {
    protected static WebDriver driver = new ChromeDriver();
    @BeforeMethod
    public void setUp(){
        if(driver == null){
            driver = new ChromeDriver();
        }
    }
    @AfterMethod
    public void closeBrowser(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
