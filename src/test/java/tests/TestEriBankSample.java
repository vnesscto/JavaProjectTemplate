package tests;

import base.TestBase;
import bussinessprocesses.MobileExampleProcess;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Log;


public class TestEriBankSample extends TestBase {

    /**
     * This is a login test to EriBank Mobile app(Android).
     */
    @Test(description = "Login to eri bank")
    @Description("Verify login to eri bank app")
    public void eriLogin() {
        Log.startTestCase("eri login");
        Boolean result = MobileExampleProcess.loginToEriBank(driver);
        Assert.assertTrue(result);
        Log.startTestCase("eri login");
    }

}
