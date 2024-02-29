package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.opencart.constant.FrameworkConstant;

public class ExtentReportsManager {
	 private static ExtentReports extent;

	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            extent = new ExtentReports();
	            ExtentSparkReporter reporter = new ExtentSparkReporter(FrameworkConstant.getReportPath());
	            reporter.config().setReportName("Open cart automation Test Result");
	            extent.attachReporter(reporter);
	            extent.setSystemInfo("System", "Windows");
	            extent.setSystemInfo("Author", "Prasad");
	            extent.setSystemInfo("Build#", "1.1");
	            extent.setSystemInfo("Team", "QA");
	            extent.setSystemInfo("Customer Name", "Open Cart");
	        }
	        return extent;
	    }

}
