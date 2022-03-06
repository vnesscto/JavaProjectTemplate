package BussinessProcess;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import utils.CommonMethods;
import utils.Constants;
import utils.PageInitializer;
import utils.WaitForHelper;


/**
 * This is an example business processes for Test Project demo website tests.
 */
public class TestProjectExampleWebSite {

    /**
     * This step executes CommonMethods class methods and steps for a login process to test project demo website.
     *
     * @param driver used to manage timeouts.
     * @return Boolean value  for validation.
     */
    @Step("Login process")
    public static Boolean loginToTestProject(WebDriver driver) {
        PageInitializer.testProjectLoginPage.goToURL("https://example.testproject.io/web/");
        CommonMethods.sendText(PageInitializer.testProjectLoginPage.getUserNameElement(), Constants.USER_NAME);
        CommonMethods.sendText(PageInitializer.testProjectLoginPage.getPasswordElement(), Constants.PASSWORD);
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
        CommonMethods.selectDropDownByText(PageInitializer.testProjectFormPage.getCountries(), Constants.COUNTRY_TO_SELECT);
        CommonMethods.sendText(PageInitializer.testProjectFormPage.getAddressElement(), Constants.ADDRESS);
        CommonMethods.sendText(PageInitializer.testProjectFormPage.getEmailElement(), Constants.EMAIL);
        CommonMethods.sendText(PageInitializer.testProjectFormPage.getPhoneElement(), Constants.PHONE_NUMBER);
        CommonMethods.click(PageInitializer.testProjectFormPage.getSaveButtonElement());

        new WaitForHelper(driver).presenceOfTheElement(PageInitializer.testProjectFormPage.getConfirmMessageElement());
        return PageInitializer.testProjectFormPage.getConfirmMessageElement().getText();
    }
}
