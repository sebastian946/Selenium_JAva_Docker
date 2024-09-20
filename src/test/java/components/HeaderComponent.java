package components;

import org.openqa.selenium.WebDriver;
import utils.Actions;

public class HeaderComponent {
    private WebDriver driver;
    private String id_link_cart = "cartur";
    private Actions actions;
    public HeaderComponent(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }
    public void clickCart(){
        this.actions.clickElement("id",id_link_cart);
    }

}
