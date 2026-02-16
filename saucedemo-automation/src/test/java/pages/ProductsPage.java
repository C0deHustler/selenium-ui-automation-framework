package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {
	private WebDriver driver;

	private By title = By.cssSelector(".title");
	private By sortDropdown = By.className("product_sort_container");
	private By inventoryItem = By.className("inventory_item");
	private By itemName = By.className("inventory_item_name");
	private By itemPrice = By.className("inventory_item_price");
	private By addToCartButtons = By.cssSelector(".inventory_item button");
	private By cartBadge = By.className("shopping_cart_badge");
	private By cartIcon = By.className("shopping_cart_link");

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isAt() {
		return driver.getCurrentUrl().contains("inventory.html");
	}

	public String getSelectedSortOption() {
		Select sel = new Select(driver.findElement(sortDropdown));
		return sel.getFirstSelectedOption().getText();
	}

	public void selectSort(String visibleText) {
		new Select(driver.findElement(sortDropdown)).selectByVisibleText(visibleText);
	}

	public List<Double> getAllPrices() {
		List<WebElement> items = driver.findElements(inventoryItem);
		List<Double> prices = new ArrayList<>();
		for (WebElement it : items) {
			String priceText = it.findElement(itemPrice).getText().replace("$", "").trim();
			prices.add(Double.parseDouble(priceText));
		}
		return prices;
	}

	public List<String> getAllNames() {
		List<WebElement> items = driver.findElements(inventoryItem);
		List<String> names = new ArrayList<>();
		for (WebElement it : items) {
			names.add(it.findElement(itemName).getText());
		}
		return names;
	}

	/** Add product by index in the current list (0-based). */
	public void addProductByIndex(int index) {
		List<WebElement> buttons = driver.findElements(addToCartButtons);
		buttons.get(index).click();
	}

	public void clickCart() {
		driver.findElement(cartIcon).click();
	}

	public Integer getCartCount() {
		List<WebElement> badges = driver.findElements(cartBadge);
		return badges.isEmpty() ? 0 : Integer.parseInt(badges.get(0).getText());
	}
}
