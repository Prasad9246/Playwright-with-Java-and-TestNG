package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.qa.opencart.utilits.ScreenshotUtility;

public class CustomMediaEntityBuilder {
	public static MediaEntityBuilder createScreenCaptureFromBase64String() {
        String base64Screenshot = ScreenshotUtility.takeScreenshot();
        return (base64Screenshot != null) ? MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot)
                : null;
    }

}
