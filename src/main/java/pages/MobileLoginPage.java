package pages;


import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertyReader;

/**
 * This is an Example for Page Object class.
 */
public class MobileLoginPage extends BasePage {

    public MobileLoginPage(WebDriver driver) {
        super(driver);
    }

    // Elements Locators.
    private By username = By.xpath(PropertyReader.readElementsRepoItem("eri_username_xpath"));
    private By password = By.xpath(PropertyReader.readElementsRepoItem("eri_password_xpath"));
    private By loginButton = By.xpath(PropertyReader.readElementsRepoItem("eri_login_button_xpath"));
    private By logoutButton = By.xpath(PropertyReader.readElementsRepoItem("eri_logout_button_xpath"));

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
    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    /**
     * This method return the logout button element.
     *
     * @return WebElement.
     */
    public WebElement getLogoutButton() {
        return driver.findElement(logoutButton);
    }

}
