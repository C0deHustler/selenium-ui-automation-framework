package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductsPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class LoginSteps {
	WebDriver driver = DriverFactory.getDriver();
	LoginPage login = new LoginPage(driver);
	ProductsPage products = new ProductsPage(driver);

	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		login.open(ConfigReader.get("baseUrl"));
	}

	@Given("User is logged in with {string} and {string}")
	public void user_is_logged_in_with_and(String user, String pass) {
		login.open(ConfigReader.get("baseUrl"));
		login.login(user, pass);
		Assert.assertTrue(products.isAt(), "Login failed or Products page not loaded.");
	}

	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String user, String pass) {
		login.login(user, pass);
	}

	@When("clicks on Login button")
	public void clicks_on_login_button() {
		// Already clicked in login() - step kept for readability.
	}

	@When("User leaves username and password blank")
	public void user_leaves_username_and_password_blank() {
		login.clickLoginWithBlanks();
	}

	@When("User enters username {string} and leaves password blank")
	public void user_enters_username_and_leaves_password_blank(String user) {
		login.login(user, "");
	}

	@Then("User should be redirected to Products page")
	public void user_should_be_redirected_to_products_page() {
		Assert.assertTrue(products.isAt(), "Not on Products page after login.");
	}

	@Then("Error message {string} should be displayed")
	public void error_message_should_be_displayed(String expected) {
		String actual = login.getErrorMessage();
		Assert.assertTrue(actual.contains(expected), "Expected error to contain: " + expected + " but got: " + actual);
	}
}
