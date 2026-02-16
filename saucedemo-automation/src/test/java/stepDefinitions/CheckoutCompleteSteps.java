package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutInfoPage;
import pages.CheckoutOverviewPage;
import pages.LoginPage;
import pages.ProductsPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class CheckoutCompleteSteps {
	WebDriver driver = DriverFactory.getDriver();
	LoginPage login = new LoginPage(driver);
    ProductsPage products = new ProductsPage(driver);
    CartPage cart = new CartPage(driver);
    CheckoutInfoPage info = new CheckoutInfoPage(driver);
    CheckoutOverviewPage overview = new CheckoutOverviewPage(driver);
    CheckoutCompletePage complete = new CheckoutCompletePage(driver);

	@Given("User has completed checkout")
	public void user_has_completed_checkout() throws InterruptedException {
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
        overview.clickFinish();
	}

	@Then("User should see success message {string}")
	public void user_should_see_success_message(String expected) {
		Assert.assertEquals(complete.getHeader(), expected, "Success header mismatch");
	}

	@When("User clicks Back Home button")
	public void user_clicks_back_home_button() {
		complete.backHome();
	}
}
