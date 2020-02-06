package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstactPageUI;
import pageUIs.AdminLoginPageUI;

public class AdminLoginPageObject extends AbstractPage{

	public AdminLoginPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void inputToAdminEmailTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC, AdminLoginPageUI.INPUT_ID_ADMIN_LOGIN_EMAIL_TEXTBOX);
		sendkeysToElement(keyVal, AbstactPageUI.INPUT_ID_DYNAMIC, AdminLoginPageUI.INPUT_ID_ADMIN_LOGIN_EMAIL_TEXTBOX);
	}
	
	public void inputToAdminPasswordTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC, AdminLoginPageUI.INPUT_ID_ADMIN_LOGIN_PASSWORD_TEXTBOX);
		sendkeysToElement(keyVal, AbstactPageUI.INPUT_ID_DYNAMIC, AdminLoginPageUI.INPUT_ID_ADMIN_LOGIN_PASSWORD_TEXTBOX);
	}
	
	public void clickToAdminLoginButton() {
		waitForElementClickable(AbstactPageUI.INPUT_CLASS_DYNAMIC, AdminLoginPageUI.INPUT_CLASS_ADMIN_LOGIN_BUTTON);
		clickToElement(AbstactPageUI.INPUT_CLASS_DYNAMIC, AdminLoginPageUI.INPUT_CLASS_ADMIN_LOGIN_BUTTON);
	}
}
