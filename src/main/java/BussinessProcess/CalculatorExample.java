package BussinessProcess;

import io.qameta.allure.Step;
import utils.CommonMethods;
import utils.ManagePages;
import utils.PropertyReader;

/**
 * This is an example business process for calculator addition test.
 */
public class CalculatorExample {

    /**
     * This Step executes CommonMethods class methods and steps to achieve addition action of the calculator app.
     *
     * @return String of the addition result for validation.
     */
    @Step("Addition between two numbers example")
    public static String performAddition() {
        CommonMethods.click(ManagePages.desktopCalculatorPage.getNumber(PropertyReader.readElementsRepoItem("first_number")));
        CommonMethods.click(ManagePages.desktopCalculatorPage.getMathSign(PropertyReader.readElementsRepoItem("math_sign_plus")));
        CommonMethods.click(ManagePages.desktopCalculatorPage.getNumber(PropertyReader.readElementsRepoItem("second_number")));
        CommonMethods.click(ManagePages.desktopCalculatorPage.getNumber(PropertyReader.readElementsRepoItem("math_sign_equals")));
        return ManagePages.desktopCalculatorPage.getResult();
    }
}
