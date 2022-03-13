package common;

import common.Constants;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;
import utils.Log;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * This class contains basic web actions methods.
 */
public class CommonMethods extends DriverManager {

    /**
     * This method clicks on the element parameter.
     *
     * @param element is the element to be clicked.
     */
    @Step("Click given web element.")
    public static void click(WebElement element) {
        element.click();
    }

    /**
     * This method clears text box and send another text
     *
     * @param element is the element to receive keys.
     * @param text    is the text to send.
     */
    @Step("Send keys to given element.")
    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * This method moves the mouse cursor to the given element.
     *
     * @param element is the element to hover on.
     */
    @Step("Move to given element.")
    public static void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    /**
     * This method checks if radio/checkbox is enabled and then clicks on the
     * element that has the value we want
     *
     * @param listElement List of elements to be checked by given value.
     * @param value       the value to search on the given list.
     */
    @Step("Click Radio button or Checkbox.")
    public static void clickRadioButtonOrCheckbox(List<WebElement> listElement, String value) {
        String actualValue;

        for (WebElement el : listElement) {
            actualValue = el.getAttribute("value").trim();
            if (el.isEnabled() && actualValue.equals(value)) {
                el.click();
            }
        }
    }

    /**
     * This method checks if the text is found in the dropdown element and only then
     * selects it
     *
     * @param element      contains the dropdown element.
     * @param textToSelect the desired text to be selected from the dropdown.
     */
    @Step("Select Dropdown by Text.")
    public static void selectDropDownByText(WebElement element, String textToSelect) {

        try {
            Select select = new Select(element);
            List<WebElement> options = select.getOptions();

            for (WebElement el : options) {
                if (el.getText().equals(textToSelect)) {
                    select.selectByVisibleText(textToSelect);
                    break;
                }
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
            Log.error(Constants.LOG_ERROR_MESSAGE, e);
        }
    }


    /**
     * This method checks if the index is valid and only then selects it
     *
     * @param element contains the dropdown element.
     * @param index   the desired index to be selected from the dropdown.
     */
    @Step("Select Dropdown by Index.")
    public static void selectDropDownByIndex(WebElement element, int index) {
        try {
            Select select = new Select(element);
            int size = select.getOptions().size();
            if (size > index && index >= 0) {
                select.selectByIndex(index);
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
            Log.error(Constants.LOG_ERROR_MESSAGE, e);
        }
    }


    /**
     * This method accepts alerts and catches exception if alert is not present
     */
    @Step("Accept alert.")
    public static void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
            Log.error(Constants.LOG_ERROR_MESSAGE, e);
        }
    }

    /**
     * This method will dismiss the alert after checking if alert is present
     */
    @Step("Dismiss Alert.")
    public static void dismissAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
            Log.error(Constants.LOG_ERROR_MESSAGE, e);
        }
    }


    /**
     * This method switches to frame by using name or id
     *
     * @param nameOrId given id or name to switch to.
     */
    @Step("Switch to frame by name or id.")
    public static void switchToFrameByNameOrID(String nameOrId) {

        try {
            driver.switchTo().frame(nameOrId);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
            Log.error(Constants.LOG_ERROR_MESSAGE, e);
        }
    }


    /**
     * This method switches to frame by using an index
     *
     * @param index given index to switch to.
     */
    @Step("Switch to frame by index.")
    public static void switchToFrameByIndex(int index) {

        try {
            driver.switchTo().frame(index);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
            Log.error(Constants.LOG_ERROR_MESSAGE, e);
        }
    }


    /**
     * This method switches to frame by using WebElement
     *
     * @param element given element to switch to.
     */
    @Step("Switch to frame by element.")
    public static void switchToFrameByElement(WebElement element) {

        try {
            driver.switchTo().frame(element);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
            Log.error(Constants.LOG_ERROR_MESSAGE, e);
        }
    }


    /**
     * This method switches focus to a child window.
     */
    @Step("Switch to child window.")
    public static void switchToChildWindow() {

        String mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
            }
        }
    }

    /**
     * This method switches focus to the newest window open.
     *
     * @param previousWindowHandles given previous window handles that were open
     *                              before opening the desired window to switch to.
     */
    public static void switchToNewWindow(Set<String> previousWindowHandles) {
        Set<String> currentWindows = driver.getWindowHandles();
        for (String window : currentWindows) {
            if (!previousWindowHandles.contains(window)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }


    /**
     * This method sends the RETURN key to a given element.
     *
     * @param element given element to send RETURN Key to.
     */
    @Step("Send RETURN Key.")
    public static void sendReturnKey(WebElement element) {
        element.sendKeys(Keys.RETURN);
    }

    /**
     * This method creates a WebDriverWait object and returns it
     *
     * @return WebDriverWait
     */
    public static WebDriverWait getWaitObject() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
        return wait;
    }


    /**
     * This method waits for an item to be clickable
     *
     * @param element wait for.
     * @return WebElement
     */
    public static WebElement waitForClickability(WebElement element) {
        return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * This method waits for an item to be visible
     *
     * @param element  Wait to be visible.
     * @return WebElement that should be visible
     */
    public static WebElement waitForVisibility(WebElement element) {
        return getWaitObject().until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * This method clicks an element and wait implemented on it
     *
     * @param element to wait and click on.
     */
    public static void waitAndClick(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    /**
     * This method wraps Thread sleep using given second.
     *
     * @param seconds amount of second for sleep method.
     */
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.error(Constants.LOG_ERROR_MESSAGE, e);
        }
    }


    /**
     * This method casts the driver to a JavascriptExecutor and returns it
     *
     * @return JavascriptExecutor
     */

    public static JavascriptExecutor getJSObject() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    /**
     * This method will click on the element passed to it used by JavascriptExecutor
     *
     * @param element to be clicked.
     */
    public static void jsClick(WebElement element) {
        getJSObject().executeScript("arguments[0].click()", element);
    }


    /**
     * This method will scroll the page until the element passed to it becomes visible.
     *
     * @param element to be scrolled at.
     */
    public static void scrollToElement(WebElement element) {
        getJSObject().executeScript("arguments[0].scrollIntoView(true)", element);
    }


    /**
     * This method will scroll the page up based on the passed pixel parameter
     *
     * @param pixel amount of pixel to be scrolled.
     */
    public static void scrollUp(int pixel) {
        getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
    }


    /**
     * This method will scroll the page down based on the passed pixel parameter
     *
     * @param pixel amount of pixel to be scrolled.
     */
    public static void scrollDown(int pixel) {
        getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
    }

    /**
     * This method will select date from the calendar
     *
     * @param elements list of WebElements representing days.
     * @param text the day to select/
     */
    public static void selectCalendarDate(List<WebElement> elements, String text) {
        for (WebElement day : elements) {
            if (day.isEnabled()) {
                if (day.getText().equals(text)) {
                    day.click();
                    break;
                }
            }
        }
    }


    /**
     * This method will take a screenshot
     *
     * @param fileName File screenshots saved at.
     */
    public static byte[] takeScreenShot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File file = ts.getScreenshotAs(OutputType.FILE);
        // Create destination as: filepath + filename + timestamp + .png
        String destination = Constants.SCREENSHOT_PATH + fileName + getTimeStamp() + ".png";
        try {
            FileUtils.copyFile(file, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
            Log.error(Constants.LOG_ERROR_MESSAGE, e);
        }

        return picBytes;

    }

    /**
     * This method will return current timestamp in a String
     *
     * @return String with the current time stamp.
     */
    public static String getTimeStamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

        return sdf.format(date.getTime());

    }
}
