package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtil;

public class LoginPage {
	private WebDriver driver;

	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginBtn = By.id("login-button");
	private By errorMessage = By.cssSelector("h3[data-test='error']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void open(String baseUrl) {
		driver.get(baseUrl);
		WaitUtil.waitVisible(driver, username, 5);
	}

	public void login(String user, String pass) {
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBtn).click();
	}

	public void clickLoginWithBlanks() {
		driver.findElement(username).clear();
		driver.findElement(password).clear();
		driver.findElement(loginBtn).click();
	}

	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}
}
