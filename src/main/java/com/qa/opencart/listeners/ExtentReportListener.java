package com.qa.opencart.listeners;

import java.util.Calendar;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.opencart.constant.FrameworkConstant;

import static com.qa.opencart.utilits.ScreenshotUtility.takeScreenshot;

public class ExtentReportListener implements ITestListener {

	private static ExtentReports extent = init();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private static ExtentReports extentReports;

	private static ExtentReports init() {
		extentReports = new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter(FrameworkConstant.getReportPath());
		reporter.config().setReportName("Open cart automation Test Result");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("System", "Windows");
		extentReports.setSystemInfo("Author", "Prasad");
		extentReports.setSystemInfo("Build#", "1.1");
		extentReports.setSystemInfo("Team", "QA");
		extentReports.setSystemInfo("Customer Name", "Open Cart");
		return extentReports;
	}

	@Override
	public void onStart(ITestContext contaxt) {
		System.out.println("Test Suite Started....");
	}

	@Override
	public void onFinish(ITestContext contaxt) {
		System.out.println("Test Suite is ending....");
		extent.flush();
		test.remove();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String qualifiedName = result.getMethod().getQualifiedName();
		int last = qualifiedName.lastIndexOf(".");
		int mid = qualifiedName.substring(0, last).indexOf(".");
		String className = qualifiedName.substring(mid + 1, last);
		System.out.println(methodName + " started!");
		ExtentTest extentText = extent.createTest(result.getMethod().getMethodName(),
				result.getMethod().getMethodName());
		extentText.assignAuthor(result.getTestContext().getSuite().getName());
		extentText.assignCategory(className);
		test.set(extentText);
		test.get().getModel().setStartTime(getTime(result.getStartMillis()));

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " passed!");
		test.get().pass("Test Passed");
		 test.get().pass(result.getThrowable(),
		 MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " failed!");
		test.get().fail(result.getThrowable(),
				MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " skipped!");
		test.get().skip(result.getThrowable(),
				MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage for" + result.getMethod().getMethodName());
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}
