package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import userPageUIs.UserMyAccountPageUI;

public class UserMyAccountPageObject extends BasePage {
	private WebDriver driver;

	public UserMyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, UserMyAccountPageUI.REGISTER_LINK);
		clickToElement(driver, UserMyAccountPageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, UserMyAccountPageUI.LOGIN_LINK);
		clickToElement(driver, UserMyAccountPageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementClickable(driver, UserMyAccountPageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserMyAccountPageUI.MY_ACCOUNT_LINK);
	}

	public boolean isMyAccountPageDisplayed() {
		waitForElementVisiable(driver, UserMyAccountPageUI.CUSTOMER_INFO);
		return isElementDisplayed(driver, UserMyAccountPageUI.CUSTOMER_INFO);
	}

	public void updateGender(String gender) {
		if (gender.equals("Male")) {
			checkToDefaultCheckboxRadio(driver, UserMyAccountPageUI.MALE_GENDER);
		} else if (gender.equals("Female")) {
			checkToDefaultCheckboxRadio(driver, UserMyAccountPageUI.FEMALE_GENDER);
		} else {
			throw new RuntimeException("Gender invalid.");
		}
	}

	public void updateFirstName(String firstName) {
		waitForElementVisiable(driver, UserMyAccountPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, UserMyAccountPageUI.FIRST_NAME_TEXTBOX, firstName);

	}

	public void updateLastName(String lastName) {
		waitForElementVisiable(driver, UserMyAccountPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, UserMyAccountPageUI.LAST_NAME_TEXTBOX, lastName);

	}

	public void updateDateOfBirth(String birthDay) {
		String Date[] = birthDay.split("/");
		selectItemInDefaultDrodown(driver, UserMyAccountPageUI.DATE_OF_BIRTHDAY, Date[0]);
		selectItemByTextInDefaultDrodown(driver, UserMyAccountPageUI.DATE_OF_BIRTHMONTH, convertMonth(Date[1]));
		selectItemInDefaultDrodown(driver, UserMyAccountPageUI.DATE_OF_BIRTHYEAR, Date[2]);
	}

	public void updateEmail(String emailAddress) {
		waitForElementVisiable(driver, UserMyAccountPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserMyAccountPageUI.EMAIL_TEXTBOX, emailAddress);

	}

	public String getUpdatedSuccessMessage() {
		waitForElementVisiable(driver, UserMyAccountPageUI.UPDATED_SUCCESS_INFO_MESSAGE);
		return getElementText(driver, UserMyAccountPageUI.UPDATED_SUCCESS_INFO_MESSAGE);
	}

	public void clickTosaveCustomerInfo() {
		waitForElementClickable(driver, UserMyAccountPageUI.SAVE_CUSTOMER_INFO);
		clickToElement(driver, UserMyAccountPageUI.SAVE_CUSTOMER_INFO);

	}

	public boolean checkCustomerInfoUpdate(String gender, String firstName, String lastName, String birthDay,
			String email) {
		boolean result = true;
		if (gender.equals("Male")) {
			if (isElementSelected(driver, UserMyAccountPageUI.MALE_GENDER) == false) {
				result = false;
			}
		} else {
			if (isElementSelected(driver, UserMyAccountPageUI.FEMALE_GENDER) == false) {
				result = false;
			}
		}
		if (!getElementText(driver, UserMyAccountPageUI.FIRST_NAME_TEXTBOX).equals(firstName)) {
			result = false;
		}
		if (!getElementText(driver, UserMyAccountPageUI.LAST_NAME_TEXTBOX).equals(lastName)) {
			result = false;
		}
		if (!getElementText(driver, UserMyAccountPageUI.EMAIL_TEXTBOX).equals(email)) {
			result = false;
		}
		String Date[] = birthDay.split("/");
		if (!getSelectedItemDefaultDrodown(driver, UserMyAccountPageUI.DATE_OF_BIRTHDAY).equals(Date[0])) {
			result = false;
		}
		if (!getSelectedItemDefaultDrodown(driver, UserMyAccountPageUI.DATE_OF_BIRTHMONTH).equals(convertMonth(Date[1]))) {
			result = false;
		}
		if (!getSelectedItemDefaultDrodown(driver, UserMyAccountPageUI.DATE_OF_BIRTHYEAR).equals(Date[2])) {
			result = false;
		}
		return result;
	}

}
