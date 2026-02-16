package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CheckoutInfoPage;
import pages.CheckoutOverviewPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import pages.CheckoutCompletePage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class CheckoutOverviewSteps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage login = new LoginPage(driver);
    ProductsPage products = new ProductsPage(driver);
    CartPage cart = new CartPage(driver);
    CheckoutInfoPage info = new CheckoutInfoPage(driver);
    CheckoutOverviewPage overview = new CheckoutOverviewPage(driver);
    CheckoutCompletePage complete = new CheckoutCompletePage(driver);

    @Given("User is on Checkout: Overview page with products added")
    public void user_is_on_checkout_overview_page_with_products_added() throws InterruptedException {
        login.open(ConfigReader.get("baseUrl"));
        login.login(ConfigReader.get("username"), ConfigReader.get("password"));
        Assert.assertTrue(products.isAt(), "Login failed");
        products.addProductByIndex(0);
        products.addProductByIndex(1);
        products.clickCart();
        cart.checkout();
        info.fill("John","Doe","12345");
        info.continueNext();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two.html"),
                "Not on Checkout Overview page");
    }

    @Then("Selected products and quantities should be displayed")
    public void selected_products_and_quantities_should_be_displayed() {
        Assert.assertTrue(overview.getSummaryItemCount() > 0, "No items shown in summary");
    }

    @Then("Item total, tax, and total amount should be displayed correctly")
    public void item_total_tax_and_total_amount_should_be_displayed_correctly() {
        double item = overview.getItemTotal();
        double tax = overview.getTax();
        double total = overview.getTotal();
        // Floating point tolerance
        Assert.assertEquals(total, Math.round((item + tax) * 100.0)/100.0, 0.01, "Total != item + tax");
    }

    @When("User confirms the order")
    public void user_confirms_the_order() {
        overview.clickFinish();
    }

    @When("User clicks Cancel button")
    public void user_clicks_cancel_button() {
        overview.clickCancel();
    }
    
    @Then("User should be redirected to Checkout: Complete page")
    public void user_should_be_redirected_to_checkout_complete_page() {
    	Assert.assertTrue(complete.isAt(), "Not on Checkout: Complete page after login.");
    }
}
