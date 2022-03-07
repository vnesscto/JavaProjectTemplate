package bussinessprocesses;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import utils.*;


/**
 * This is an example business processes for Test Project demo website tests.
 */
public class TPExampleWebSiteProcess {

    /**
     * This step executes CommonMethods class methods and steps for a login process to test project demo website.
     *
     * @param driver given to manage timeouts.
     * @return Boolean value for validation.
     */
    @Step("Login process")
    public static Boolean loginToTestProject(WebDriver driver) {
        PageInitializer.testProjectLoginPage.goToURL("https://example.testproject.io/web/");
        CommonMethods.sendText(PageInitializer.testProjectLoginPage.getUserNameElement(), PropertyReader.readConfigItem("tp_user_name"));
        CommonMethods.sendText(PageInitializer.testProjectLoginPage.getPasswordElement(), PropertyReader.readConfigItem("tp_password"));
        CommonMethods.click(PageInitializer.testProjectLoginPage.getLoginBtnElement());

        new WaitForHelper(driver).presenceOfTheElement(PageInitializer.testProjectLoginPage.getLogOutBtnElement());
        return PageInitializer.testProjectLoginPage.getLogOutBtnElement().isDisplayed();
    }

    /**
     * This step executes CommonMethods class methods and steps for a form fill process on test project demo website.
     *
     * @param driver used to manage timeouts.
     * @return String result for validation.
     */
    @Step("Fill Test Project example form")
    public static String fillTestProjectForm(WebDriver driver) {
        CommonMethods.selectDropDownByText(PageInitializer.testProjectFormPage.getCountries(), PropertyReader.readConfigItem("tp_country_to_select"));
        CommonMethods.sendText(PageInitializer.testProjectFormPage.getAddressElement(), PropertyReader.readConfigItem("tp_address"));
        CommonMethods.sendText(PageInitializer.testProjectFormPage.getEmailElement(), PropertyReader.readConfigItem("tp_email"));
        CommonMethods.sendText(PageInitializer.testProjectFormPage.getPhoneElement(), PropertyReader.readConfigItem("tp_phone_number"));
        CommonMethods.click(PageInitializer.testProjectFormPage.getSaveButtonElement());

        new WaitForHelper(driver).presenceOfTheElement(PageInitializer.testProjectFormPage.getConfirmMessageElement());
        return PageInitializer.testProjectFormPage.getConfirmMessageElement().getText();
    }
}
