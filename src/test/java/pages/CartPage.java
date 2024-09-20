package pages;

import org.openqa.selenium.WebDriver;
import utils.Actions;

public class CartPage {
    private WebDriver driver;
    private Actions actions;
    private String xpath_buttonPlaceOrder = "//button[contains(text(),\"Order\")]";
    private String id_tableContent = "tbodyid";
    public CartPage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }
    public void waitTableContentPresent() throws InterruptedException {
        this.actions.validateVisible("id",id_tableContent);
    }
    public void clickPlaceOrder(){
        this.actions.clickElement("xpath",xpath_buttonPlaceOrder);
    }

}
