package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertyReader;

/**
 * This is an Example for Page Object class.
 */
public class DesktopCalculatorPage extends BasePage {

    public DesktopCalculatorPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method receives number to locate the calculator number element.
     *
     * @param number used as a locator.
     * @return the number WebElement.
     */
    public WebElement getNumber(String number) {
        return driver.findElement(By.name(number));
    }

    /**
     * This method receives mathematical sign to locate the calculator sign element.
     *
     * @param sign used as a locator
     * @return the sign WebElement.
     */
    public WebElement getMathSign(String sign) {
        return driver.findElement(By.name(sign));
    }

    /**
     * This method used to locate the result and return the result.
     *
     * @return String of the displayed result.
     */
    public String getResult() {
        return driver.findElement(By.xpath(PropertyReader.readElementsRepoItem("result_xpath")))
                .getText().replace("Display is:", "").trim();
    }

    /**
     * This method used to locate the calculator clear option.
     *
     * @return the clear WebElement
     */
    public WebElement getClear() {
        return driver.findElement(By.xpath(PropertyReader.readElementsRepoItem("clear_button_xpath")));
    }
}
