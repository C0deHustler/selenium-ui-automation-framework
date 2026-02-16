//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class CheckoutCompletePage {
//    private WebDriver driver;
//    private By header = By.className("complete-header");
//    private By backHome = By.id("back-to-products");
//
//    public CheckoutCompletePage(WebDriver driver) { this.driver = driver; }
//
//    public String getHeader() { return driver.findElement(header).getText(); }
//    public void backHome() { driver.findElement(backHome).click(); }
//}


package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CheckoutCompletePage {

    private WebDriver driver;
    private By header = By.className("complete-header");
    private By backHome = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    // Updated method with explicit wait
    public String getHeader() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        return headerElement.getText();
    }

    public void backHome() {
        driver.findElement(backHome).click();
    }
    
    public boolean isAt() {
		return driver.getCurrentUrl().contains("checkout-complete.html");
	}
}
