package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.*;

/**
 * Base class for over test classes.
 * Test classes should extend this class.
 */
public class TestBase extends DriverManager {

    /**
     * This is a setup method that runs before each test class and used to call initDriver method of DriverManager.
     */
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        Log.info("Setting up driver");
        initDriver();
        switch (Constants.PLATFORM.toLowerCase()) {
            case "web":
                PageInitializer.initWebPages();
                Log.info("Initializing web pages");
                break;
            case "desktop":
                PageInitializer.initDesktopPages();
                Log.info("Initializing desktop pages");
                break;
            case "mobile":
                //PageInitializer.initMobilePages();
                Log.info("Initializing mobile pages");
                break;
        }
        new WaitForHelper(driver).implicitWait();
    }

    /**
     * This method is a teardown method used to quit driver after each test class.
     */
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Log.info("Closing driver");
        driver.quit();
    }
}
