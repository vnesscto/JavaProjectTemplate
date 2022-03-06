package tests;

import BussinessProcess.TestProjectExampleWebSite;
import base.TestBase;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Constants;
import utils.Log;


/**
 * This is an example of two tests on Test Project Demo website.
 */
public class TestLoginSample extends TestBase {

    /**
     * This is a login test to test project example website.
     */
    @Test(description = "Login to Test Project.")
    @Description("Verify login to TestProject Demo.")
    public void login() {
        Log.startTestCase("login");
        Boolean result = TestProjectExampleWebSite.loginToTestProject(driver);
        Assert.assertTrue(result);
        Log.endTestCase("login");
    }

    /**
     * This is a form fill test on test project example website.
     * The form will appear after a successful Login test.(Previous Test)
     */
    @Test(description = "Fill Test Project demo form.", dependsOnMethods = "login")
    @Description("Verify form saved after fill.")
    public void fillForm() {
        Log.startTestCase("Fill Form");
        String result = TestProjectExampleWebSite.fillTestProjectForm(driver);
        Assert.assertEquals(result, Constants.EXPECTED_TEXT);
        Log.endTestCase("Fill Form");
    }
}
