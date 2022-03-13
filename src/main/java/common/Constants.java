package common;

/*
  This class hold constant parameters for configuration and file paths.
 */
public class Constants {

    // General

    public static final String LOG_ERROR_MESSAGE = "Error accrued: ";

    // Platform options: Web, Desktop, Mobile.
    public static final String PLATFORM = "Web";

    // Driver Implicit wait time(seconds).
    public static final int IMPLICIT_WAIT_TIME = 10;

    // Driver Explicit wait time(seconds).
    public static final int EXPLICIT_WAIT_TIME = 20;

    // Driver Page load time out(seconds).
    public static final int PAGE_LOAD_TIME_OUT = 15;

    // Screenshot path.
    public static final String SCREENSHOT_PATH = "";

    // elementRepo path
    public static final String ELEMENT_REPO_PATH = "src/main/resources/elementsRepo.properties";

    // config path
    public static final String CONFIG_PATH = "src/main/resources/config.properties";


    //Web

    // Browser type options: Chrome, Safari, Edge, ie(Internet Explorer), FireFox, Opera.
    public static final String BROWSER_TYPE = "Chrome";


    // Desktop

    // Application path.
    public static final String APP_PATH = "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App";

    // IPPort
    public static final String IP_PORT = "http://127.0.0.1:4723";


    // Mobile

    // Application UD_ID.
    public static final String UD_ID = "LGD85528c94d24";

    // Application package.
    public static final String APP_PACKAGE = "com.experitest.ExperiBank";

    // Application activity.
    public static final String APP_ACTIVITY = ".LoginActivity";

    // Driver URL.
    public static final String DRIVER_URL = "http://localhost:4723/wd/hub";

    // Report directory name.
    public static final String REPORT_DIRECTORY = "reports";

    // Report format.
    public static final String REPORT_FORMAT = "xml";

    // Test name.
    public static final String TEST_NAME = "Mobile Example";


    // Tests Expected results

    // Test Project:
    public static final String EXPECTED_TP_TEXT = "Saved";

    // Windows Calculator.
    public static final String EXPECTED_CALC_RESULT = "Display is 11";

}
