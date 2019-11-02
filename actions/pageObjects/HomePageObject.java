package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage{
	
	public HomePageObject(WebDriver driver) {
		super(driver);
	}

	public void clickToRegisterLink() {
		waitForElementVisible(HomePageUI.REGISTER_LINK);
		clickToElement(HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		waitForElementVisible(HomePageUI.LOGIN_LINK);
		clickToElement(HomePageUI.LOGIN_LINK);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(HomePageUI.MY_ACCOUNT_LINK);
		return elementIsDisplayed(HomePageUI.MY_ACCOUNT_LINK);
	}

}
