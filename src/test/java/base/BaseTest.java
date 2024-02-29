package base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.readProperties.ReadProperties;

import pages.HomePage;
import pages.LoginPage;

public class BaseTest {

	PlaywrightFactory pf;
	Page page;
	public HomePage homePage;
	public LoginPage loginPage;

	static Properties prop = null;

	@BeforeSuite
	public void loadPropertyFile() {
		prop = ReadProperties.readPropertyFile();
	}

	@BeforeTest
	public void setUp() {
		pf = new PlaywrightFactory();
		page = pf.initBrowser(prop.getProperty("browser"));
		homePage = new HomePage(page);
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
