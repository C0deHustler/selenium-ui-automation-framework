package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CheckoutInfoPage;
import pages.CheckoutOverviewPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class CheckoutInfoSteps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage login = new LoginPage(driver);
    ProductsPage products = new ProductsPage(driver);
    CartPage cart = new CartPage(driver);
    CheckoutInfoPage info = new CheckoutInfoPage(driver);
    CheckoutOverviewPage overview = new CheckoutOverviewPage(driver);

    @Given("User is on Checkout: Your Information page")
    public void user_is_on_checkout_your_information_page() {
        // Ensure we are on the Info page by adding one item and navigating through Cart
        login.open(ConfigReader.get("baseUrl"));
        login.login(ConfigReader.get("username"), ConfigReader.get("password"));
        Assert.assertTrue(products.isAt(), "Login failed");
        products.addProductByIndex(0);
        products.clickCart();
        cart.checkout();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"),
                "Not on Checkout: Your Information page");
    }

    @When("User enters checkout information {string} {string} {string}")
    public void user_enters_checkout_information(String f, String l, String zip) throws InterruptedException {
        info.fill(f,l,zip);
        info.continueNext();
    }
    
    @Then("User should be redirected to Checkout Your Information page")
    public void user_should_be_redirected_to_checkout_your_information_page() {
    	Assert.assertTrue(info.isAt(), "Not on Checkout: Your Information page after login.");
    }
    
    @Then("User should be redirected to Checkout Overview page")
    public void user_should_be_redirected_to_checkout_overview_page() {
    	Assert.assertTrue(overview.isAt(), "Not on Checkout: Overview page after login.");
    }
}
