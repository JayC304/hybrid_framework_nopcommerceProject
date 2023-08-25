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
import pageObjects.MyAccountPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class User_03_MyAccount extends BaseTest {
	private WebDriver driver;
	private String emailAddress, firstName, lastName, password, gender, birthDay;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		gender = "Male";
		birthDay = "30/4/1998";
		firstName = "Anh";
		lastName = "Tran";
		password = "123456";
		emailAddress = "anhtran" + generateFakeNumber() + "@gmail.vn";
		// emailAddress = "anhtran123@gmail.com";
	}

	@Test(priority = 0)
	public void User_01_Register() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.selectGender(gender);
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.selectDateOfBirth(birthDay);
		registerPage.inputToEmailTextbox(emailAddress);
		System.out.println(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		// registerPage.clickToLogoutLink();
	}

	@Test(priority = 0)
	public void User_02_LoginSuccess() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertEquals(homePage.isMyAccountLinkDisplayed(), true);
	}

	@Test(priority = 1)
	public void My_Account_01_Update_Customer_Inforation() {
		String newGender = "Female";
		String newFirstName = "Auto";
		String newLastName = "mation";
		String newDateOfBirth = "1/1/2000";
		String newEmail = "anhtran6789@gmail.com";
		myAccountPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed());
		myAccountPage.updateGender(newGender);
		myAccountPage.updateFirstName(newFirstName);
		myAccountPage.updateLastName(newLastName);
		myAccountPage.updateDateOfBirth(newDateOfBirth);
		myAccountPage.updateEmail(newEmail);
		myAccountPage.clickTosaveCustomerInfo();
		myAccountPage.checkCustomerInfoUpdate(newGender, newFirstName, newLastName, newDateOfBirth, newEmail);
		Assert.assertEquals(myAccountPage.getUpdatedSuccessMessage(),
				"The customer info has been updated successfully.");
	}

//	@Test
//	public void My_Account_02_Update_Customer_Inforation() {
//		loginPage = homePage.clickToLoginLink();
//		loginPage.inputToEmailTextBox("anhtran@gmail.com");
//		loginPage.inputToPasswordTextBox(password);
//		loginPage.clickToLoginButton();
//	}
//
//	@Test
//	public void Login_05_Incorrect_Password() {
//	}
//
//	@Test
//	public void Login_06_Valid_Email_Password() {
//	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
