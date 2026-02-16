package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.ProductsPage;
import utilities.DriverFactory;

public class CartSteps {
    WebDriver driver = DriverFactory.getDriver();
    CartPage cart = new CartPage(driver);
    ProductsPage products = new ProductsPage(driver);

    @Then("Both products should be displayed in Cart")
    public void both_products_should_be_displayed_in_cart() {
        Assert.assertEquals(cart.getItemCount(), 2, "Cart should have 2 items");
    }

    @When("User removes product from cart")
    public void user_removes_product_from_cart() {
        cart.removeFirstItem();
    }

    @When("User proceeds to Checkout")
    public void user_proceeds_to_checkout() {
        cart.checkout();
    }

    @When("User clicks Continue Shopping button")
    public void user_clicks_continue_shopping_button() {
        cart.continueShopping();
    }

    @Then("User should be redirected to Products page from Cart")
    public void user_should_be_redirected_to_products_page_from_cart() {
        Assert.assertTrue(products.isAt(), "Did not return to Products page");
    }
}
