package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	
	public LoginPageObject(WebDriver driver) {
		super(driver);
	}

	public void inputToEmailTextbox(String emaiVal) {
		waitForElementVisible(LoginPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(LoginPageUI.EMAIL_TEXTBOX, emaiVal);
	}

	public void inputToPasswordTextbox(String passwordVal) {
		waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(LoginPageUI.PASSWORD_TEXTBOX, passwordVal);

	}
	
	public String getEmailErrorMessage() {
		waitForElementVisible(LoginPageUI.EMAIL_TEXTBOX_MESSAGE);
		return getTextElement(LoginPageUI.EMAIL_TEXTBOX_MESSAGE);
	}

	public String getUnregistedEmailErrorMessage() {
		waitForElementVisible(LoginPageUI.UNREGISTED_EMAIL_MESSAGE);
		return getTextElement(LoginPageUI.UNREGISTED_EMAIL_MESSAGE);
	}
	
	public String getValidationErrorMessage() {
		waitForElementVisible(LoginPageUI.VALIDATION_ERROR_MESSAGE);
		return getTextElement(LoginPageUI.VALIDATION_ERROR_MESSAGE);
	}
}
