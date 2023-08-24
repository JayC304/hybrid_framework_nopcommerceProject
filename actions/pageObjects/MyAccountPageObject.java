package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.MyAccountUI;
import pageUIs.RegisterPageUI;

public class MyAccountPageObject extends BasePage {
	private WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, MyAccountUI.REGISTER_LINK);
		clickToElement(driver, MyAccountUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, MyAccountUI.LOGIN_LINK);
		clickToElement(driver, MyAccountUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementClickable(driver, MyAccountUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, MyAccountUI.MY_ACCOUNT_LINK);
	}

	public boolean isMyAccountPageDisplayed() {
		waitForElementVisiable(driver, MyAccountUI.CUSTOMER_INFO);
		return isElementDisplayed(driver, MyAccountUI.CUSTOMER_INFO);
	}

	public void updateGender(String gender) {
		if (gender.equals("Male")) {
			checkToDefaultCheckboxRadio(driver, RegisterPageUI.MALE_GENDER);
		} else if (gender.equals("FeMale")) {
			checkToDefaultCheckboxRadio(driver, RegisterPageUI.FEMALE_GENDER);
		} else {
			throw new RuntimeException("Gender invalid.");
		}
	}

	public void updateFirstName(String firstName) {
		waitForElementVisiable(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);

	}

	public void updateLastName(String lastName) {
		waitForElementVisiable(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);

	}

	public void updateDateOfBirth(String birthDay) {
		String Date[] = birthDay.split("/");
		selectItemInDefaultDrodown(driver, RegisterPageUI.DATE_OF_BIRTHDAY, Date[0]);
		selectItemByTextInDefaultDrodown(driver, RegisterPageUI.DATE_OF_BIRTHMONTH, convertMonth(Date[1]));
		selectItemInDefaultDrodown(driver, RegisterPageUI.DATE_OF_BIRTHYEAR, Date[2]);
	}

	public void updateEmail(String emailAddress) {
		waitForElementVisiable(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);

	}

}
