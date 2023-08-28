package user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstans;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;

public class User_03_Switch_Role extends BaseTest {
	private WebDriver driver;
	private String userEmailAddress, firstName, lastName, userPassword, gender, birthDay;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		gender = "Male";
		birthDay = "30/4/1998";
		firstName = "Anh";
		lastName = "Tran";
		userPassword = "123456";
		userEmailAddress = "anhtran123@gmail.com";
	}

	@Test
	public void Role_01_User() {
		userLoginPage = userHomePage.clickToLoginLink();
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertEquals(userHomePage.isMyAccountLinkDisplayed(), true);
	}

	@Test
	public void Role_02_Admin() {
		userHomePage.openPageUrl(driver, GlobalConstans.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashboardPage = adminLoginPage.loginAsAdmin(GlobalConstans.ADMIN_EMAIL_ADDRESS,
				GlobalConstans.ADMIN_PASSWORD);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
