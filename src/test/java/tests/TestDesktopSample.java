package tests;


import bussinessprocesses.CalculatorExampleProcess;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import common.Constants;
import utils.Log;

/**
 * This is Windows Applications example test.
 */
public class TestDesktopSample extends TestBase {

    /**
     * This is an addition example test using windows calculator.
     */
    @Test(description = "Addition test.")
    public void additionTest() {
        Log.startTestCase("additionTest");
        String result = CalculatorExampleProcess.performAddition();
        Assert.assertEquals(result, Constants.EXPECTED_CALC_RESULT);
        Log.endTestCase("additionTest");
    }
}
