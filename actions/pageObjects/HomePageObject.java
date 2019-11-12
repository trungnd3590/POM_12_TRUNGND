package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage {
	
	public HomePageObject(WebDriver driver) {
		super(driver);
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementVisible(HomePageUI.REGISTER_LINK);
		clickToElement(HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementVisible(HomePageUI.LOGIN_LINK);
		clickToElement(HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(HomePageUI.MY_ACCOUNT_LINK);
		return elementIsDisplayed(HomePageUI.MY_ACCOUNT_LINK);
	}

}
