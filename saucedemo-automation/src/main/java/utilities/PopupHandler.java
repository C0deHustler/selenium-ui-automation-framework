package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

/**
 * Utility to handle unexpected popups in Selenium
 */
public class PopupHandler {

    /**
     * Checks if an alert is present, and accepts it if so.
     * Safe to call even if no alert is displayed.
     */
    public static void handleAlertIfPresent(WebDriver driver) {
        try {
            // Switch to alert
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert detected: " + alert.getText());

            // Accept the alert (click OK)
            alert.accept();
            System.out.println("Alert dismissed successfully.");
        } catch (NoAlertPresentException e) {
            // No alert is present → nothing to do
        } catch (Exception e) {
            System.out.println("Unexpected error while handling alert: " + e.getMessage());
        }
    }
}
