package utilities;

import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class EdgeDriverTest {
    public static void main(String[] args) {
        // Initialize driver
        WebDriver driver = DriverFactory.initDriver();

        // Navigate to SauceDemo
        driver.get("https://www.saucedemo.com/");

        // Print page title
        System.out.println(driver.getTitle());

        // Quit driver
        DriverFactory.quitDriver();
    }
}
