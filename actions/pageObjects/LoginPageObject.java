package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.AbstactPageUI;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	
	public LoginPageObject(WebDriver driver) {
		super(driver);
	}

	public void inputToEmailTextbox(String emaiVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,LoginPageUI.INPUT_ID_EMAIL_TEXTBOX);
		sendkeysToElement(emaiVal,AbstactPageUI.INPUT_ID_DYNAMIC,LoginPageUI.INPUT_ID_EMAIL_TEXTBOX);
	}

	public void inputToPasswordTextbox(String passwordVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,LoginPageUI.INPUT_ID_PASSWORD_TEXTBOX);
		sendkeysToElement(passwordVal,AbstactPageUI.INPUT_ID_DYNAMIC,LoginPageUI.INPUT_ID_PASSWORD_TEXTBOX);
	}
	
	public String getEmailErrorMessage() {
		waitForElementVisible(AbstactPageUI.SPAN_ID_DYNAMIC,LoginPageUI.SPAN_ID_EMAIL_ERROR_MESSAGE);
		return getTextElement(AbstactPageUI.SPAN_ID_DYNAMIC,LoginPageUI.SPAN_ID_EMAIL_ERROR_MESSAGE);
	}

	public String getLoginCommonErrorMessage() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,LoginPageUI.DIV_CLASS_UNREGISTED_EMAIL_MESSAGE);
		return getTextElement(AbstactPageUI.DIV_CLASS_DYNAMIC,LoginPageUI.DIV_CLASS_UNREGISTED_EMAIL_MESSAGE);
	}
	
	public String getValidationErrorMessage() {
		waitForElementVisible(AbstactPageUI.SPAN_CLASS_DYNAMIC,LoginPageUI.SPAN_CLASS_VALIDATION_EMAL_MESSAGE);
		return getTextElement(AbstactPageUI.SPAN_CLASS_DYNAMIC,LoginPageUI.SPAN_CLASS_VALIDATION_EMAL_MESSAGE);
	}

	public void clickToLoginButton() {
		waitForElementClickable(AbstactPageUI.INPUT_CLASS_DYNAMIC, LoginPageUI.INPUT_CLASS_LOGIN_BUTTON);
		clickToElement(AbstactPageUI.INPUT_CLASS_DYNAMIC, LoginPageUI.INPUT_CLASS_LOGIN_BUTTON);
	}
	
	public HomePageObject openHomepageByClickToLoginButton() {
		waitForElementClickable(AbstactPageUI.INPUT_CLASS_DYNAMIC, LoginPageUI.INPUT_CLASS_LOGIN_BUTTON);
		clickToElement(AbstactPageUI.INPUT_CLASS_DYNAMIC, LoginPageUI.INPUT_CLASS_LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}
}
