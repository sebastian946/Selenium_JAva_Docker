package steps;

import components.FormPlaceOrderComponent;
import components.HeaderComponent;
import helper.GenerateData;
import io.cucumber.java.AfterAll;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailPage;
import utils.Configuration;

public class PurchaseProduct extends Configuration {

    @BeforeClass
    public void con(){
        super.setUp();
    }

    private String titleProduct;
    private String url = "https://www.demoblaze.com/index.html";
    private HomePage homePage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    private HeaderComponent headerComponent;
    private FormPlaceOrderComponent formPlaceOrderComponent;
    private GenerateData generateData = new GenerateData();
    public PurchaseProduct(){
        this.homePage = new HomePage(driver);
        this.productDetailPage = new ProductDetailPage(driver);
        this.cartPage = new CartPage(driver);
        this.headerComponent = new HeaderComponent(driver);
        this.formPlaceOrderComponent = new FormPlaceOrderComponent(driver);
    }
    public void openUrl(){
        this.homePage.openBrowser(url);
    }
    public void selectProduct(String category) throws InterruptedException {
        this.homePage.clickCategory(category);
        this.titleProduct = this.homePage.clickRandomItem();
    }
    public void addToCart(){
        this.productDetailPage.assertElement(this.titleProduct);
        this.productDetailPage.clickButtonAddProduct();
        this.productDetailPage.clickAlert();
    }
    public void clickLinkCart(){
        this.headerComponent.clickCart();
    }
    public void purchaseProduct() throws InterruptedException {
        this.cartPage.waitTableContentPresent();
        this.cartPage.clickPlaceOrder();
    }
    public void fillPurchaseForm(){
        String name = generateData.fullName();
        String country = generateData.country();
        String city = generateData.city();
        String creditCard = generateData.creditCard();
        this.formPlaceOrderComponent.fillname(name);
        this.formPlaceOrderComponent.fillCountry(country);
        this.formPlaceOrderComponent.fillCity(city);
        this.formPlaceOrderComponent.fillCreditCard(creditCard);
        this.formPlaceOrderComponent.fillMonth("November");
        this.formPlaceOrderComponent.fillYear("2021");
        this.formPlaceOrderComponent.clickPurchase();
    }
    public void validateAlert() throws InterruptedException {
        this.formPlaceOrderComponent.alertPresent();
    }
    @AfterClass
    public void close(){
        driver.quit();
    }
}
