package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitForHelper;

/*
 *Base Page class, Page Object classes should extend this class.
 */
public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method navigates to the given URL.
     *
     * @param url given URL to navigate to.
     */
    public void goToURL(String url) {
        driver.get(url);
    }

    /**
     * This method using WaitForHelper class to set implicit wait time.
     */
    public void waitForTime() {
        new WaitForHelper(driver).implicitWait();
    }

    /**
     * This method waits conditionally for the given element to be present
     *
     * @param element given element to wait for.
     */
    public void waitForElementToAppear(WebElement element) {
        new WaitForHelper(driver).presenceOfTheElement(element);
    }

}
