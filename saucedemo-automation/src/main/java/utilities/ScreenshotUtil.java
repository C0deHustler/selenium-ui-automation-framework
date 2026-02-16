package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

/** Captures screenshots to target/screenshots and returns the path. */
public class ScreenshotUtil {
	public static String captureScreenshot(WebDriver driver, String name) {
		String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String fileName = name.replaceAll("[^a-zA-Z0-9-_]", "_") + "_" + ts + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("target/screenshots/" + fileName);
		dest.getParentFile().mkdirs();
		try {
			Files.copy(src.toPath(), dest.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest.getPath();
	}
}
