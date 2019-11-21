package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.DetailPageUI;

public class DetailPageObject extends AbstractPage{

	public DetailPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isDetailPageDisplayed() {
		waitForElementVisible(DetailPageUI.DETAIL_PAGE_FORM);
		return elementIsDisplayed(DetailPageUI.DETAIL_PAGE_FORM);
	}
	
	public String getProductDetailTitleData() {
		waitForElementVisible(DetailPageUI.PRODUCT_ASUS_N551_NAME);
		return getTextElement(DetailPageUI.PRODUCT_ASUS_N551_NAME);
	}
}
