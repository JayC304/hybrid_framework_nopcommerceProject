package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
	private WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, MyAccountPageUI.REGISTER_LINK);
		clickToElement(driver, MyAccountPageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, MyAccountPageUI.LOGIN_LINK);
		clickToElement(driver, MyAccountPageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementClickable(driver, MyAccountPageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, MyAccountPageUI.MY_ACCOUNT_LINK);
	}

	public boolean isMyAccountPageDisplayed() {
		waitForElementVisiable(driver, MyAccountPageUI.CUSTOMER_INFO);
		return isElementDisplayed(driver, MyAccountPageUI.CUSTOMER_INFO);
	}

	public void updateGender(String gender) {
		if (gender.equals("Male")) {
			checkToDefaultCheckboxRadio(driver, MyAccountPageUI.MALE_GENDER);
		} else if (gender.equals("Female")) {
			checkToDefaultCheckboxRadio(driver, MyAccountPageUI.FEMALE_GENDER);
		} else {
			throw new RuntimeException("Gender invalid.");
		}
	}

	public void updateFirstName(String firstName) {
		waitForElementVisiable(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, firstName);

	}

	public void updateLastName(String lastName) {
		waitForElementVisiable(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, lastName);

	}

	public void updateDateOfBirth(String birthDay) {
		String Date[] = birthDay.split("/");
		selectItemInDefaultDrodown(driver, MyAccountPageUI.DATE_OF_BIRTHDAY, Date[0]);
		selectItemByTextInDefaultDrodown(driver, MyAccountPageUI.DATE_OF_BIRTHMONTH, convertMonth(Date[1]));
		selectItemInDefaultDrodown(driver, MyAccountPageUI.DATE_OF_BIRTHYEAR, Date[2]);
	}

	public void updateEmail(String emailAddress) {
		waitForElementVisiable(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, emailAddress);

	}

	public String getUpdatedSuccessMessage() {
		waitForElementVisiable(driver, MyAccountPageUI.UPDATED_SUCCESS_INFO_MESSAGE);
		return getElementText(driver, MyAccountPageUI.UPDATED_SUCCESS_INFO_MESSAGE);
	}

	public void clickTosaveCustomerInfo() {
		waitForElementClickable(driver, MyAccountPageUI.SAVE_CUSTOMER_INFO);
		clickToElement(driver, MyAccountPageUI.SAVE_CUSTOMER_INFO);

	}

	public boolean checkCustomerInfoUpdate(String gender, String firstName, String lastName, String birthDay,
			String email) {
		boolean result = true;
		if (gender.equals("Male")) {
			if (isElementSelected(driver, MyAccountPageUI.MALE_GENDER) == false) {
				result = false;
			}
		} else {
			if (isElementSelected(driver, MyAccountPageUI.FEMALE_GENDER) == false) {
				result = false;
			}
		}
		if (!getElementText(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX).equals(firstName)) {
			result = false;
		}
		if (!getElementText(driver, MyAccountPageUI.LAST_NAME_TEXTBOX).equals(lastName)) {
			result = false;
		}
		if (!getElementText(driver, MyAccountPageUI.EMAIL_TEXTBOX).equals(email)) {
			result = false;
		}
		String Date[] = birthDay.split("/");
		if (!getSelectedItemDefaultDrodown(driver, MyAccountPageUI.DATE_OF_BIRTHDAY).equals(Date[0])) {
			result = false;
		}
		if (!getSelectedItemDefaultDrodown(driver, MyAccountPageUI.DATE_OF_BIRTHMONTH).equals(convertMonth(Date[1]))) {
			result = false;
		}
		if (!getSelectedItemDefaultDrodown(driver, MyAccountPageUI.DATE_OF_BIRTHYEAR).equals(Date[2])) {
			result = false;
		}
		return result;
	}

}
