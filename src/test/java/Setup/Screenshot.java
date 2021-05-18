package Setup;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static void takeScreenShot(WebDriver webDriver, String filePath) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) webDriver);
        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        FileUtils.copyFile(scrFile, destFile);
    }
}
