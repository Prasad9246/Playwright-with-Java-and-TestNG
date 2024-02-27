package com.qa.opencart.utilits;

import java.nio.file.Paths;

import com.microsoft.playwright.Page;
import com.qa.opencart.constant.FrameworkConstant;
import com.qa.opencart.threadLocalManager.ThreadManager;

public class ScreenshotUtility {

	public static String takeScreenshot() {
		/*
		 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		 byte[] screenshot = ThreadManager.getPage().screenshot();
		 try {
			outputStream.write(screenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return Base64.getEncoder().encodeToString(outputStream.toByteArray());
		*/
		ThreadManager.getPage().screenshot(new Page.ScreenshotOptions()
				.setPath(Paths.get(FrameworkConstant.getScreenshotPath())).setFullPage(true));
		return FrameworkConstant.getConfigPath();
		
	}

}
