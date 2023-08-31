package userPageUIs;

public class BasePageUI {
	public static final String REGISTER_LINK = "xpath=//a[@class='ico-register']";
	public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String LOG_OUT_LINK_AT_USER = "xpath=//a[@class='ico-logout']";
	public static final String LOG_OUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	public static String DYNAMIC_LINK_BY_PAGE_NAME = "//div[contains(@class,'%s')]//a[text()='%s']";
}
