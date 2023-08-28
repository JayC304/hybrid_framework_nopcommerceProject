package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import adminPageUIs.AdminLoginPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextBox(String email) {
		waitForElementVisiable(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisiable(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public AdminDashboardPageObject loginAsAdmin(String emailAddress, String password) {
		inputToEmailTextBox(emailAddress);
		inputToPasswordTextBox(password);
		return clickToLoginButton();
	}
}
