package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Actions;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    private Actions actions;
    private String title_card = "//a[@class=\"hrefch\"]";
    public HomePage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }
    public void openBrowser(String url){
        this.actions.openUrl(url);
    }
    public void clickCategory(String category) throws InterruptedException {
        this.actions.clickElement("xpath","//a[text()='"+category+"']");
    }
    public String clickRandomItem() throws InterruptedException {
        return this.actions.clickRandomElement("xpath",title_card);
    }

}
