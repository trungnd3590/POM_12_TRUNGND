package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstactPageUI;
import pageUIs.DesktopPageUI;

public class DesktopPageObject extends AbstractPage{

	public DesktopPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isDesktopPageDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC, DesktopPageUI.DIV_CLASS_DESKTOP_PAGE_TITLE);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC, DesktopPageUI.DIV_CLASS_DESKTOP_PAGE_TITLE);
	}

}
