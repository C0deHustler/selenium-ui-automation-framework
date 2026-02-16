package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/** Small helper for explicit waits. */
public class WaitUtil {
	public static void waitVisible(WebDriver driver, By locator, long seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
