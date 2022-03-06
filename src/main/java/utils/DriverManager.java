package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

/*
 * This class is for initializing the RemoteWebDriver.
 * For specific mobile actions (e.g. TouchAction) , cast driver to AppiumDriver under CommonMethods class.
 */
public class DriverManager {

    protected static RemoteWebDriver driver;
    DesiredCapabilities dc;

    /**
     * This method calling driver initialize methods using given platform.
     */
    public void initDriver() {
        switch (Constants.PLATFORM.toLowerCase()) {
            case "web" -> {
                Log.info("Initializing Web Driver");
                try {
                    setWebDriver();
                    driver.manage().window().maximize();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    Log.error("Web Driver Failure", e);
                }
            }
            case "desktop" -> {
                Log.info("Initializing Windows Driver");
                try {
                    setWindowsDriver();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    Log.error("Windows Driver Failure", e);
                }
            }
            case "mobile" -> {
                Log.info("Initializing Appium Driver");
                try {
                    setAppiumDriver();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    Log.error("Android Driver Failure", e);
                }
            }
        }
    }

    /**
     * This method initialize web driver using given browser type.
     */
    private void setWebDriver() {
        switch (Constants.BROWSER_TYPE.toLowerCase()) {
            case "chrome" -> {
                Log.info("Found chrome as Browser");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            case "firefox" -> {
                Log.info("Found firefox as Browser");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "ie" -> {
                Log.info("Found IE as Browser");
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            }
            case "safari" -> {
                Log.info("Found safari as Browser");
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }
            case "opera" -> {
                Log.info("Found opera as Browser");
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
            }
            default -> throw new RuntimeException("Unsupported Browser Type");
        }
    }

    /**
     * This method initialize the driver as WindowsDriver.
     *
     * @throws MalformedURLException Thrown to indicate that a malformed URL has occurred.
     */
    private void setWindowsDriver() throws MalformedURLException {
        dc = new DesiredCapabilities();
        dc.setCapability("app", Constants.APP_PATH);
        dc.setCapability("deviceName", "WindowsPC");
        driver = new WindowsDriver<>(new URL(Constants.IP_PORT), dc);
    }

    /**
     * This method initialize the driver as Appium(AndroidDriver).
     *
     * @throws MalformedURLException Thrown to indicate that a malformed URL has occurred.
     */
    private void setAppiumDriver() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", Constants.REPORT_DIRECTORY);
        dc.setCapability("reportFormat", Constants.REPORT_FORMAT);
        dc.setCapability("testName", Constants.TEST_NAME);
        dc.setCapability(MobileCapabilityType.UDID, Constants.UD_ID);
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Constants.APP_PACKAGE);
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Constants.APP_ACTIVITY);
        driver = new AndroidDriver<>(new URL(Constants.DRIVER_URL), dc);
        driver.setLogLevel(Level.INFO);
    }


    /**
     * This method returns the current driver.
     *
     * @return the driver after initialization
     */
    public WebDriver getDriver() {
        return driver;
    }

}
