package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

/**
 * Central place to create and manage a single WebDriver instance.
 * Features:
 * - Uses Edge browser
 * - Disables notifications and popups
 * - Uses a manually downloaded EdgeDriver (no network needed)
 */
public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initDriver() {
        if (driver == null) {
            String browser = ConfigReader.get("browser");

            if (browser == null || browser.equalsIgnoreCase("edge")) {

                // ✅ Set system property to manually downloaded EdgeDriver
                System.setProperty("webdriver.edge.driver",
                		"C:\\Users\\acer\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");

                // ✅ EdgeOptions setup
                EdgeOptions options = new EdgeOptions();
                options.addArguments(
                        "--start-maximized",
                        "--disable-popup-blocking",
                        "--disable-notifications",
                        "--disable-translate",
                        "--disable-extensions",
                        "--no-default-browser-check"
                );

                // Initialize EdgeDriver
                driver = new EdgeDriver(options);

            } else {
                throw new RuntimeException("Only Edge is configured in this template. Got: " + browser);
            }
        }
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null)
            initDriver();
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
