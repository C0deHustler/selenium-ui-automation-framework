package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
	private WebDriver driver;

	private By cartItem = By.className("cart_item");
	private By removeButtons = By.xpath("//button[text()='Remove']");
	private By continueShoppingBtn = By.id("continue-shopping");
	private By checkoutBtn = By.id("checkout");

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public int getItemCount() {
		return driver.findElements(cartItem).size();
	}

	public void removeFirstItem() {
		List<WebElement> removes = driver.findElements(removeButtons);
		if (!removes.isEmpty())
			removes.get(0).click();
	}

	public void continueShopping() {
		driver.findElement(continueShoppingBtn).click();
	}

	public void checkout() {
		driver.findElement(checkoutBtn).click();
	}
}
