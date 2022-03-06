package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertyReader;

/**
 * This is an Example for Page Object class.
 */
public class TestProjectLoginPage extends BasePage {

    public TestProjectLoginPage(WebDriver driver) {
        super(driver);
    }

    // Elements Locators.
    private By username = By.xpath(PropertyReader.readElementsRepoItem("tp_user_name_input_xpath"));
    private By password = By.xpath(PropertyReader.readElementsRepoItem("tp_password_input_xpath"));
    private By loginButton = By.xpath(PropertyReader.readElementsRepoItem("tp_login_button_xpath"));
    private By logoutButton = By.xpath(PropertyReader.readElementsRepoItem("tp_logout_button_xpath"));

    /**
     * This method return the username input element.
     *
     * @return WebElement.
     */
    public WebElement getUserNameElement() {
        return driver.findElement(username);
    }

    /**
     * This method return the password input element.
     *
     * @return WebElement.
     */
    public WebElement getPasswordElement() {
        return driver.findElement(password);
    }

    /**
     * This method return the login button element.
     *
     * @return WebElement.
     */
    public WebElement getLoginBtnElement() {
        return driver.findElement(loginButton);
    }

    /**
     * This method return the logout button element.
     *
     * @return WebElement.
     */
    public WebElement getLogOutBtnElement() {
        return driver.findElement(logoutButton);
    }

}
