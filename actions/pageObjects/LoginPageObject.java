package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage{

	public LoginPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void inputToEmailTextbox(String emaiVal) {
		waitForElementVisible(LoginPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(LoginPageUI.EMAIL_TEXTBOX, emaiVal);
	}

	public void inputToPasswordTextbox(String passwordVal) {
		waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(LoginPageUI.PASSWORD_TEXTBOX, passwordVal);
		
	}

	public void clickToLoginButton() {
		waitForElementVisible(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
	}

}
