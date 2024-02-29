package com.qa.opencart.listeners;

import java.util.Calendar;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import reports.CustomMediaEntityBuilder;
import reports.ExtentReportsManager;
import reports.ThreadLocalManager;

public class MyTestListener implements ITestListener{
	
	 @Override
	    public void onStart(ITestContext context) {
	        ExtentReportsManager.getInstance();
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        String qualifiedName = result.getMethod().getQualifiedName();
	        int last = qualifiedName.lastIndexOf(".");
	        int mid = qualifiedName.substring(0, last).indexOf(".");
	        String className = qualifiedName.substring(mid + 1, last);
	        ExtentTest extentTest = ExtentReportsManager.getInstance().createTest(result.getMethod().getMethodName(),
	                result.getMethod().getMethodName());
	        extentTest.assignAuthor(result.getTestContext().getSuite().getName());
	        extentTest.assignCategory(className);
	        ThreadLocalManager.setExtentTest(extentTest);
	        ThreadLocalManager.getExtentTest().getModel().setStartTime(getTime(result.getStartMillis()));
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        ThreadLocalManager.getExtentTest().pass("Test Passed",
	                CustomMediaEntityBuilder.createScreenCaptureFromBase64String().build());
	        ThreadLocalManager.getExtentTest().getModel().setEndTime(getTime(result.getEndMillis()));
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        ThreadLocalManager.getExtentTest().fail(result.getThrowable(),
	                CustomMediaEntityBuilder.createScreenCaptureFromBase64String().build());
	        ThreadLocalManager.getExtentTest().getModel().setEndTime(getTime(result.getEndMillis()));
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        ThreadLocalManager.getExtentTest().skip(result.getThrowable());
	        ThreadLocalManager.getExtentTest().getModel().setEndTime(getTime(result.getEndMillis()));
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        ExtentReportsManager.getInstance().flush();
	        ThreadLocalManager.removeExtentTest();
	    }
	    
	    private Date getTime(long millis) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(millis);
			return calendar.getTime();
		}

}
