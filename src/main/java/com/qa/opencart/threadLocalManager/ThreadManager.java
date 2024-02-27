package com.qa.opencart.threadLocalManager;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ThreadManager {

	private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<>();

	public static void setPlaywright(Playwright playwright) {
		tlPlaywright.set(playwright);
	}

	public static void setBrowser(Browser browser) {
		tlBrowser.set(browser);
	}

	public static void setBrowserContext(BrowserContext browserContext) {
		tlBrowserContext.set(browserContext);
	}

	public static void setPage(Page page) {
		tlPage.set(page);
	}

	public static Playwright getPlaywright() {
		return tlPlaywright.get();
	}

	public static Browser getBrowser() {
		return tlBrowser.get();
	}

	public static BrowserContext getBrowserContext() {
		return tlBrowserContext.get();
	}

	public static Page getPage() {
		return tlPage.get();
	}

}
