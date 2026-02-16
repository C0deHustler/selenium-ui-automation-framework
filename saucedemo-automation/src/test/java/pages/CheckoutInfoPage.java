package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage {
	private WebDriver driver;

	private By firstName = By.id("first-name");
	private By lastName = By.id("last-name");
	private By postalCode = By.id("postal-code");
	private By continueBtn = By.id("continue");
	private By error = By.cssSelector("h3[data-test='error']");

	public CheckoutInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	public void fill(String f, String l, String zip) throws InterruptedException {
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys(f);
		
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(l);
		
		driver.findElement(postalCode).clear();
		driver.findElement(postalCode).sendKeys(zip);
	}

	public void continueNext() {
		driver.findElement(continueBtn).click();
	}

	public String getError() {
		return driver.findElement(error).getText();
	}
	
	public boolean isAt() {
		return driver.getCurrentUrl().contains("checkout-step-one.html");
	}
}
