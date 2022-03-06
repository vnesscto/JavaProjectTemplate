package tests;


import BussinessProcess.CalculatorExample;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Constants;
import utils.Log;

/**
 * This is Windows Applications example test.
 */
public class TestCalculator extends TestBase {

    /**
     * This is an addition example test using windows calculator.
     */
    @Test(description = "Addition test.")
    public void additionTest() {
        Log.startTestCase("additionTest");
        String result = CalculatorExample.performAddition();
        Assert.assertEquals(result, Constants.EXPECTED_CALC_RESULT);
        Log.endTestCase("additionTest");
    }
}
