package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private static final String USERNAME = "#input-email";
	private static final String PASSWORD = "#input-password";
	private static final String LOGIN_BUTTON = "//input[@type='submit']";
	private static final String FORGOTTEN_PASSWORD = "div[class='form-group'] a";
	private static final String LOG_OUT_LINK = "//a[@class='list-group-item'][normalize-space()='Logout']";

	Page page;

	public LoginPage(Page page) {
		this.page = page;
	}

	public String getLoginPageTitle() {
		return page.title();
	}

	public boolean isForgotPasswordLintVisiable() {
		return page.isVisible(FORGOTTEN_PASSWORD);
	}

	public boolean doLogin(String username, String password) {
		System.out.println("username : " + username + "\n" + "Password : " + password);
		page.fill(USERNAME, username);
		page.fill(PASSWORD, password);
		page.click(LOGIN_BUTTON);
		if (page.isVisible(LOG_OUT_LINK)) {
			System.out.println("User get Login Successfully.....");
			return true;
		}
		return false;

	}

}
