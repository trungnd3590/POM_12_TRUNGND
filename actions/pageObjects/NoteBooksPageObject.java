package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NoteBooksPageUI;

public class NoteBooksPageObject extends AbstractPage{

	public NoteBooksPageObject(WebDriver driver) {
		super(driver);
	}
	
	public boolean isNoteBookPageDisplayed() {
		waitForElementVisible(NoteBooksPageUI.NOTEBOOKS_PAGE_TITLE);
		return elementIsDisplayed(NoteBooksPageUI.NOTEBOOKS_PAGE_TITLE);
	} 

}
