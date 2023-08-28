package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import userPageUIs.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {

	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public void inputToEmailTextBox(String email) {
		waitForElementVisiable(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisiable(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisiable(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisiable(driver, UserLoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
	}

	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		inputToEmailTextBox(emailAddress);
		inputToPasswordTextBox(password);
		return clickToLoginButton();
	}
}
