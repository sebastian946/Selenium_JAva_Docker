package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Configuration {
    protected static WebDriver driver = new ChromeDriver();
    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
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
