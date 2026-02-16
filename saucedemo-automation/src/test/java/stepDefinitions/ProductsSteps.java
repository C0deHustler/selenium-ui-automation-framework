package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ProductsPage;
import utilities.DriverFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsSteps {
    WebDriver driver = DriverFactory.getDriver();
    ProductsPage products = new ProductsPage(driver);

    @Then("Default sorting option should be {string}")
    public void default_sorting_option_should_be(String expected) {
        Assert.assertEquals(products.getSelectedSortOption(), expected, "Default sort mismatch");
    }

    @When("User applies filter {string}")
    public void user_applies_filter(String option) {
        products.selectSort(option);
    }

    @Then("Products should be displayed in ascending order of price")
    public void products_should_be_displayed_in_ascending_order_of_price() {
        List<Double> prices = products.getAllPrices();
        List<Double> sorted = new ArrayList<>(prices);
        Collections.sort(sorted);
        Assert.assertEquals(prices, sorted, "Prices are not ascending");
    }

    @Then("Products should be displayed in descending order of price")
    public void products_should_be_displayed_in_descending_order_of_price() {
        List<Double> prices = products.getAllPrices();
        List<Double> sorted = new ArrayList<>(prices);
        sorted.sort(Collections.reverseOrder());
        Assert.assertEquals(prices, sorted, "Prices are not descending");
    }

    @Then("Products should be displayed in reverse alphabetical order")
    public void products_should_be_displayed_in_reverse_alphabetical_order() {
        List<String> names = products.getAllNames();
        List<String> sorted = new ArrayList<>(names);
        sorted.sort(Collections.reverseOrder());
        Assert.assertEquals(names, sorted, "Names are not Z->A");
    }

    @When("User adds {int} product to cart")
    public void user_adds_product_to_cart(Integer index) {
        products.addProductByIndex(index);
    }

    @Then("Cart should contain {int} items")
    public void cart_should_contain_items(Integer expected) {
        Assert.assertEquals(products.getCartCount(), expected.intValue(), "Cart count mismatch");
    }

    @When("User navigates to Cart")
    public void user_navigates_to_cart() {
        products.clickCart();
    }

    @Then("User should be redirected to Your Cart page")
    public void user_should_be_redirected_to_your_cart_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"), "Not on cart page");
    }
}
