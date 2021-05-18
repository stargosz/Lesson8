package TestBase;

import Setup.Screenshot;
import Setup.Timestamp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestBase {

    private static Logger logger = LoggerFactory.getLogger("TestBase.class");

    private static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }


    @BeforeAll
    static void setUp() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        logger.info(">>>> Starting test >>>>");
    }

    @BeforeEach
    void beforeEach() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Implicit wait set for 10 seconds");
    }

    @AfterEach
    void afterEach() throws IOException {

        Screenshot.takeScreenShot(driver, "src/main/resources/Screenshots/" + Timestamp.timestamp() + ".png");
        logger.debug("Screenshot path: 'src/main/resources/Screenshots/"+Timestamp.timestamp()+ ".png'");
        logger.info(">>>> Finished test >>>>");
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
        logger.info("Driver has been closed properly");
    }
}