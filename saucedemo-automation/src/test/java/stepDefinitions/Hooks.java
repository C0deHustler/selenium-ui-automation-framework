package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.PopupHandler;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverFactory.initDriver();
        // Open base URL before each scenario
        driver.get(ConfigReader.get("baseUrl"));
    }

    // ✅ Runs after every step to dismiss unexpected popups
    @AfterStep
    public void dismissPopupsAfterStep() {
        PopupHandler.handleAlertIfPresent(driver);
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Attach screenshot to Cucumber report
            byte[] shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(shot, "image/png", "failure");
        }
        DriverFactory.quitDriver();
    }
}
