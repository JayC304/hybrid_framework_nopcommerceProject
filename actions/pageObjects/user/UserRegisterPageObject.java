package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import userPageUIs.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementVisiable(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisiable(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisiable(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisiable(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisiable(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirstnameTextbox(String firstName) {
		waitForElementVisiable(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastnameTextbox(String lastName) {
		waitForElementVisiable(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisiable(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisiable(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisiable(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisiable(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public UserHomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisiable(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

	public void selectGender(String gender) {
		if (gender.equals("Male")) {
			checkToDefaultCheckboxRadio(driver, UserRegisterPageUI.MALE_GENDER);
		} else if (gender.equals("FeMale")) {
			checkToDefaultCheckboxRadio(driver, UserRegisterPageUI.FEMALE_GENDER);
		} else {
			throw new RuntimeException("Gender invalid.");
		}
	}

	public void selectDateOfBirth(String birthDay) {
		String Date[] = birthDay.split("/");
		selectItemInDefaultDrodown(driver, UserRegisterPageUI.DATE_OF_BIRTHDAY, Date[0]);
		selectItemByTextInDefaultDrodown(driver, UserRegisterPageUI.DATE_OF_BIRTHMONTH, convertMonth(Date[1]));
		selectItemInDefaultDrodown(driver, UserRegisterPageUI.DATE_OF_BIRTHYEAR, Date[2]);
	}
}
