package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.PurchaseProduct;

public class PurchaseProductStepDefinitions {
    PurchaseProduct purchaseProduct = new PurchaseProduct();
    public PurchaseProductStepDefinitions(){

    }
    @Given("user open the webpage product store")
    public void user_open_the_webpage_product_store(){
        purchaseProduct.openUrl();
    }
    @Given("user select the product from the category {string}")
    public void user_select_the_product_from_the_category(String category) throws InterruptedException {
        purchaseProduct.selectProduct(category);
    }
    @When("user add to cart the product")
    public void user_add_to_cart_the_product(){
        purchaseProduct.addToCart();
    }
    @When("user go to cart shopping")
    public void user_go_to_cart_shopping(){
        purchaseProduct.clickLinkCart();
    }
    @When("user purchase the product")
    public void user_purchase_the_product() throws InterruptedException {
        purchaseProduct.purchaseProduct();
    }
    @When("user complete the form purchase")
    public void user_complete_the_form_purchase(){
        purchaseProduct.fillPurchaseForm();
    }
    @Then("user validate alert register")
    public void user_validate_alert_register() throws InterruptedException {
        purchaseProduct.validateAlert();
    }
}
