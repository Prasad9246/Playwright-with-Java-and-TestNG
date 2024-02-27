package com.qa.opencart.constant;

public class FrameworkConstant {
	
	
	private static final String CONFIG_FILE_PATH = System.getProperty("user.dir")
			+ "/src/test/resources/config/config.properties";
	
	private static final String SCREENSHOT_FILE_PATH = System.getProperty("user.dir")+ "/src/test/resources/screenshot/index_"
			+ System.currentTimeMillis() + ".png";
	private static final String REPORT_PATH = System.getProperty("user.dir") + "/src/test/resources/report/index_"
			+ System.currentTimeMillis() + ".html";
	
	public static String getConfigPath() {
		return CONFIG_FILE_PATH;
	}

	public static String getScreenshotPath() {
		return SCREENSHOT_FILE_PATH;
	}
	
	public static String getReportPath() {
		return REPORT_PATH;
	}
}
