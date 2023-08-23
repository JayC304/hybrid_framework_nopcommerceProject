package user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class User_02_Login extends BaseTest {
	private WebDriver driver;
	private String emailAddress, firstName, lastName, password;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		firstName = "Anh";
		lastName = "Tran";
		password = "123456";
		emailAddress = "anhtran" + generateFakeNumber() + "@gmail.vn";
	}

	@Test
	public void Login_01_Empty_Data() {
		loginPage = homePage.clickToLoginLink();
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox("aaa");
		loginPage.inputToPasswordTextBox(password);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox("aaa@aaa");
		loginPage.inputToPasswordTextBox(password);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtPasswordTextbox(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Empty_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox("anhtran@gmail.com");
		loginPage.inputToPasswordTextBox(password);
		loginPage.clickToLoginButton();
	}

	@Test
	public void Login_05_Incorrect_Password() {
	}

	@Test
	public void Login_06_Valid_Email_Password() {
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
