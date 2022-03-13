package utils;

import common.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Helper class for managing driver wait.
 */
public class WaitForHelper {

    public WebDriver driver;

    public WaitForHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method sets the implicitlyWait timeout of the driver to a default value is saved in the Constants class.
     */
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    }

    /**
     * This method waits for received element to be clickable.
     * Wait time value is saved in the Constants class.
     *
     * @param element to be checked if clickable.
     * @return the given element.
     */
    public WebElement presenceOfTheElement(WebElement element) {
        WebElement firstResult = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME)
                .until(ExpectedConditions.elementToBeClickable(element));
        return firstResult;
    }
}
