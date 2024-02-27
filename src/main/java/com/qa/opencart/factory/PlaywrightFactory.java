package com.qa.opencart.factory;

import static com.qa.opencart.readProperties.ReadProperties.prop;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.qa.opencart.threadLocalManager.ThreadManager;

public class PlaywrightFactory {

	public Page initBrowser(String browserName) {
		System.out.println("Browser Name : " + browserName);
		ThreadManager.setPlaywright(Playwright.create());

		switch (browserName.toLowerCase()) {
		case "chromium":
			ThreadManager.setBrowser(ThreadManager.getPlaywright().chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "firfox":
			ThreadManager.setBrowser(
					ThreadManager.getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "safari":
			ThreadManager.setBrowser(
					ThreadManager.getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "chrome":
			ThreadManager.setBrowser(ThreadManager.getPlaywright().chromium()
					.launch(new LaunchOptions().setChannel("chrome").setHeadless(false)));
			break;
		default:
			System.out.println("Please pass the right browser name .......!");
			break;
		}

		ThreadManager.setBrowserContext(ThreadManager.getBrowser().newContext());
		ThreadManager.setPage(ThreadManager.getBrowserContext().newPage());
		ThreadManager.getPage().navigate(prop.getProperty("url"));
		return ThreadManager.getPage();

	}

}
