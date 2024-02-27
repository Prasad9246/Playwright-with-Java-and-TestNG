package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.constant.AppConstants;

import base.BaseTest;

import static com.qa.opencart.readProperties.ReadProperties.prop;

public class LoginTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageNavigationTest() {
		loginPage = homePage.navigateToLoginPage();
		String actualLoginPageTitle = loginPage.getLoginPageTitle();
		String expectedLoginPageTitle = AppConstants.LOGIN_PAGE_TITLE;
		Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle);

	}
	
	@Test(priority = 2)
	public void forgetPasswordLinkExitTest() {
		loginPage = homePage.navigateToLoginPage();
		Assert.assertTrue(loginPage.isForgotPasswordLintVisiable());
	}
	
	@Test(priority = 3)
	public void appLoginTest() {
		loginPage = homePage.navigateToLoginPage();
		Assert.assertTrue(loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password")));
		
	}
}
