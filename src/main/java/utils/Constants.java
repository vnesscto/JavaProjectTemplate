package utils;

/*
  This class hold constant parameters for configuration and file paths.
 */
public class Constants {

    // General

    public static final String LOG_ERROR_MESSAGE = "Error accrued: ";

    // Platform options: Web, Desktop, Mobile.
    public static final String PLATFORM = "Desktop";

    // Driver Implicit wait time(seconds).
    public static final int IMPLICIT_WAIT_TIME = 10;

    // Driver Explicit wait time(seconds).
    public static final int EXPLICIT_WAIT_TIME = 20;

    // Driver Page load time out(seconds).
    public static final int PAGE_LOAD_TIME_OUT = 15;

    // Screenshot path.
    public static final String SCREENSHOT_PATH = "";


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
    public static final String UD_ID = "";

    // Application package.
    public static final String APP_PACKAGE = "";

    // Application activity.
    public static final String APP_ACTIVITY = ".MainActivity";

    // Driver URL.
    public static final String DRIVER_URL = "";

    // Report directory name.
    public static final String REPORT_DIRECTORY = "";

    // Report format.
    public static final String REPORT_FORMAT = "xml";

    // Test name.
    public static final String TEST_NAME = "";


    // Test Project Demo Login credentials and form data.

    //login
    public static final String USER_NAME = "Test";
    public static final String PASSWORD = "12345";

    // Form data.
    public static final String COUNTRY_TO_SELECT = "Israel";
    public static final String ADDRESS = "Israel israel 1";
    public static final String EMAIL = "Israel@Israel.com";
    public static final String PHONE_NUMBER = "+972509991111";
    public static final String EXPECTED_TEXT = "Saved";


    // Windows Calculator.
    public static final String EXPECTED_CALC_RESULT = "Display is 11";

}
