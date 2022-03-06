package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertyReader;

/**
 * This is an Example for Page Object class.
 */
public class TestProjectFormPage extends BasePage {

    public TestProjectFormPage(WebDriver driver) {
        super(driver);
    }

    // Elements Locators.
    private By countries = By.xpath(PropertyReader.readElementsRepoItem("tp_country_dropdown_xpath"));
    private By address = By.xpath(PropertyReader.readElementsRepoItem("tp_address_input_xpath"));
    private By email = By.xpath(PropertyReader.readElementsRepoItem("tp_email_input_xpath"));
    private By phone = By.xpath(PropertyReader.readElementsRepoItem("tp_phone_input_xpath"));
    private By saveButton = By.xpath(PropertyReader.readElementsRepoItem("tp_save_button_xpath"));
    private By confirmMessage = By.xpath(PropertyReader.readElementsRepoItem("tp_confirm_message_xpath"));


    /**
     * This method return the country input element.
     *
     * @return WebElement
     */
    public WebElement getCountries() {
        return driver.findElement(countries);
    }

    /**
     * This method return the address input element.
     *
     * @return WebElement
     */
    public WebElement getAddressElement() {
        return driver.findElement(address);
    }

    /**
     * This method return the email input element.
     *
     * @return WebElement
     */
    public WebElement getEmailElement() {
        return driver.findElement(email);
    }

    /**
     * This method return the phone input element.
     *
     * @return WebElement
     */
    public WebElement getPhoneElement() {
        return driver.findElement(phone);
    }

    /**
     * This method return the saveButton button element.
     *
     * @return WebElement
     */
    public WebElement getSaveButtonElement() {
        return driver.findElement(saveButton);
    }

    /**
     * This method return the confirmMessage element.
     *
     * @return WebElement
     */
    public WebElement getConfirmMessageElement() {
        return driver.findElement(confirmMessage);
    }
}
