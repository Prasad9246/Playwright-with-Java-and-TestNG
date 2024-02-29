package com.qa.opencart.utilits;

import java.util.Base64;
import com.microsoft.playwright.Page;
import com.qa.opencart.threadLocalManager.ThreadManager;

public class ScreenshotUtility {

    public static String takeScreenshot() {
        try {
            Page page = ThreadManager.getPage();
            byte[] buffer = page.screenshot();
            String base64String = Base64.getEncoder().encodeToString(buffer);
            return base64String;
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
            return null;
        }
    }
}
