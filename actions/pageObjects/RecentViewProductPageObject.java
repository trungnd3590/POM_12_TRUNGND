package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstactPageUI;
import pageUIs.ProductComparePageUI;
import pageUIs.RecentViewProductPageUI;

public class RecentViewProductPageObject extends AbstractPage{

	public RecentViewProductPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isRecentViewProductPageTitleDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,RecentViewProductPageUI.DIV_CLASS_RECENT_VIEW_PRODUCTS_PAGE_TITLE);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,RecentViewProductPageUI.DIV_CLASS_RECENT_VIEW_PRODUCTS_PAGE_TITLE);
	}

	public boolean isRecentViewProductPageFormDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,RecentViewProductPageUI.DIV_CLASS_RECENT_VIEW_PRODUCTS_PAGE_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,RecentViewProductPageUI.DIV_CLASS_RECENT_VIEW_PRODUCTS_PAGE_FORM);
	}
	
	public boolean isNumberOfProductNameMatched(int expVal) {
		waitForAllElementsVisible(ProductComparePageUI.PRODUCT_COMPARE_NAME_TEXT);
		return compareNumberOfItem(expVal,ProductComparePageUI.PRODUCT_COMPARE_NAME_TEXT);
	}
	
	public boolean isProductNameDisplayed(String expVal) {
		waitForAllElementsVisible(ProductComparePageUI.PRODUCT_COMPARE_NAME_TEXT);
		return compareStringFromElementsText(expVal,ProductComparePageUI.PRODUCT_COMPARE_NAME_TEXT);
	}

}
