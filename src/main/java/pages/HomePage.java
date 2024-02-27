package pages;

import com.microsoft.playwright.Page;

public class HomePage {

	Page page;

	private static final String SEARCH = "//input[@placeholder='Search']";
	private static final String SEARCH_ICON = ".fa.fa-search";
	private static final String SEARCH_PAGE_HEADER = "div[id='content'] h1";
	private static final String LOGIN_LINK = "(//a[normalize-space()='Login'])[1]";
	private static final String MY_ACCOUNT_LINK = "//span[normalize-space()='My Account']";

	public HomePage(Page page) {
		this.page = page;
	}

	public String getHomePageURl() {
		String msg = page.url();
		System.out.println("HomePage URL : " + msg);
		return msg;
	}

	public String getHomePageTitle() {
		String msg = page.title();
		System.out.println("HomePage Title : " + msg);
		return msg;
	}

	public String doSearch(String productName) {
		page.fill(SEARCH, productName);
		page.click(SEARCH_ICON);
		String header = page.textContent(SEARCH_PAGE_HEADER);
		System.out.println("Search Header : " + header);
		return header;
	}

	public LoginPage navigateToLoginPage() {
		page.click(MY_ACCOUNT_LINK);
		page.click(LOGIN_LINK);
		return new LoginPage(page);
	}

}
