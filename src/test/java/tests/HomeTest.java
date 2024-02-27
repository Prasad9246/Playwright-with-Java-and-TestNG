package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.constant.AppConstants;

import static com.qa.opencart.readProperties.ReadProperties.prop;

import base.BaseTest;

public class HomeTest extends BaseTest {

	@DataProvider
	public Object[][] getDataProvider() {
		return new Object[][] { { "Macbook" }, { "iMac" }, { "Samsung" } };
	}

	@Test(priority = 1)
	public void verifyHomePageUrl() {
		String actualURL = homePage.getHomePageURl();
		String expectedURL = prop.getProperty("url");
		Assert.assertEquals(actualURL, expectedURL);
	}

	@Test(priority = 2)
	public void verifyHomePageTitle() {
		String actualTitle = homePage.getHomePageTitle();
		String expectedTitle = AppConstants.HOME_PAGE_TITLE;
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 3, dataProvider = "getDataProvider")
	public void verifyHomePageHeader(String productName) {
		String actualHeader = homePage.doSearch(productName);
		String expectedHeader = "Search - " + productName;
		Assert.assertEquals(actualHeader, expectedHeader);
	}

}
