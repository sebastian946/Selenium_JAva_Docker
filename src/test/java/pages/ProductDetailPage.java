package pages;

import org.openqa.selenium.WebDriver;
import utils.Actions;

public class ProductDetailPage {
    private WebDriver driver;
    private Actions actions;
    private String titleProduct;
    private String button_addCart = "//a[contains(text(),\"Add\")]";
    private String h2_titleProduct = "//h2[@class=\"name\"]";
    public ProductDetailPage(WebDriver driver,String titleProduct){
        this.driver = driver;
        this.actions =  new Actions(this.driver);
        this.titleProduct = titleProduct;
    }
    public void assertElement(){
        this.actions.assertText("xpath", h2_titleProduct,this.titleProduct);
    }
    public void clickButtonAddProduct(){
        this.actions.clickElement("xpath",button_addCart);
    }
    public void clickAlert(){
        this.actions.clickAlert();
    }

}
