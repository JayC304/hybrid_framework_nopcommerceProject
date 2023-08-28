package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import adminPageUIs.AdminDashboardPageUI;
import commons.BasePage;

public class AdminDashboardPageObject extends BasePage {
	private WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashboardHeaderDisplayed() {
		waitForElementVisiable(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
	}
}
