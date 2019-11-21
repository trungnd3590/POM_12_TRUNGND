package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstactPageUI;

public class HomePageObject extends AbstractPage {
	
	public HomePageObject(WebDriver driver) {
		super(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(AbstactPageUI.HEADER_MY_ACCOUNT_LINK);
		return elementIsDisplayed(AbstactPageUI.HEADER_MY_ACCOUNT_LINK);
	}

}
