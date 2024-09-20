package components;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Actions;

public class FormPlaceOrderComponent {
    private WebDriver driver;
    private Actions actions;
    private String id_name = "name";
    private String id_country = "country";
    private String id_city = "city";
    private String id_creditCard = "card";
    private String id_Month = "month";
    private String id_year = "year";
    private String xpath_buttonPurchase = "//button[text()=\"Purchase\"]";
    private String xpath_titleAlert = "//h2[contains(text(),\"Thank\")]";
    public FormPlaceOrderComponent(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }
    public void fillname(String name){
        this.actions.sendKeys("id",id_name,name);
    }
    public void fillCountry(String country){
        this.actions.sendKeys("id",id_country,country);
    }
    public void fillCity(String city){
        this.actions.sendKeys("id",id_city,city);
    }
    public void fillCreditCard(String creditCard){
        this.actions.sendKeys("id",id_creditCard,creditCard);
    }
    public void fillMonth(String month){
        this.actions.sendKeys("id",id_Month,month);
    }
    public void fillYear(String year){
        this.actions.sendKeys("id",id_year,year);
    }
    public void clickPurchase(){
        this.actions.clickElement("xpath",xpath_buttonPurchase);
    }
    public void alertPresent() throws InterruptedException {
        Assert.assertEquals(this.actions.validateVisible("xpath",xpath_titleAlert),true);
    }
}
