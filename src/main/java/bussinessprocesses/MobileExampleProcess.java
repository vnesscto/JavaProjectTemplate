package bussinessprocesses;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import common.CommonMethods;
import utils.PageInitializer;
import utils.PropertyReader;
import utils.WaitForHelper;

/**
 * This is an example business process for mobile login test.
 */
public class MobileExampleProcess {

    /**
     * This step executes CommonMethods steps and actions to achieve Mobile login test.
     *
     * @param driver given to manage timeouts.
     * @return Boolean value for validation.
     */
    @Step("Login process")
    public static Boolean loginToEriBank(WebDriver driver) {
        CommonMethods.sendText(PageInitializer.mobileLoginPage.getUserNameElement(), PropertyReader.readConfigItem("eri_user_name"));
        CommonMethods.sendText(PageInitializer.mobileLoginPage.getPasswordElement(), PropertyReader.readConfigItem("eri_password"));
        CommonMethods.click(PageInitializer.mobileLoginPage.getLoginButton());

        new WaitForHelper(driver).presenceOfTheElement(PageInitializer.mobileLoginPage.getLogoutButton());
        return PageInitializer.mobileLoginPage.getLogoutButton().isDisplayed();
    }
}
