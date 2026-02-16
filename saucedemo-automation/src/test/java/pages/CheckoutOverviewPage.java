package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
	private WebDriver driver;

	private By summaryItems = By.className("cart_item");
	private By itemTotal = By.className("summary_subtotal_label");
	private By tax = By.className("summary_tax_label");
	private By total = By.className("summary_total_label");
	private By finishBtn = By.id("finish");
	private By cancelBtn = By.id("cancel");

	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
	}

	public int getSummaryItemCount() {
		return driver.findElements(summaryItems).size();
	}

	public double getItemTotal() {
		String t = driver.findElement(itemTotal).getText().replace("Item total: $", "").trim();
		return Double.parseDouble(t);
	}

	public double getTax() {
		String t = driver.findElement(tax).getText().replace("Tax: $", "").trim();
		return Double.parseDouble(t);
	}

	public double getTotal() {
		String t = driver.findElement(total).getText().replace("Total: $", "").trim();
		return Double.parseDouble(t);
	}

	public void clickFinish() {
		driver.findElement(finishBtn).click();
	}

	public void clickCancel() {
		driver.findElement(cancelBtn).click();
	}
	
	public boolean isAt() {
		return driver.getCurrentUrl().contains("checkout-step-two.html");
	}
}
