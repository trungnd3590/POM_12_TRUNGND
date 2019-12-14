package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstactPageUI;
import pageUIs.ProductComparePageUI;

public class ProductComparePageObject extends AbstractPage{

	public ProductComparePageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getProductComparePageTitleData() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,AbstactPageUI.DIV_CLASS_PAGE_TITLE);
		return getTextElement(AbstactPageUI.DIV_CLASS_DYNAMIC,AbstactPageUI.DIV_CLASS_PAGE_TITLE);
	}
	
	public boolean isNumberOfRemoveButtonMatched(int expVal) {
		waitForAllElementsVisible(ProductComparePageUI.PRODUCT_COMPARE_REMOVE_BUTTON);
		return compareNumberOfItem(expVal,ProductComparePageUI.PRODUCT_COMPARE_REMOVE_BUTTON);
	}
	
	public boolean isRemoveTextDisplayed(String expRemoveVal) {
		waitForAllElementsVisible(ProductComparePageUI.PRODUCT_COMPARE_REMOVE_BUTTON);
		return elementIsDisplayed(expRemoveVal,ProductComparePageUI.PRODUCT_COMPARE_REMOVE_BUTTON );
	}
	
	public boolean isNumberOfProductMatched(int expVal) {
		waitForAllElementsVisible(ProductComparePageUI.PRODUCT_COMPARE_NAME_TEXT);
		return compareNumberOfItem(expVal,ProductComparePageUI.PRODUCT_COMPARE_NAME_TEXT);
	}
	
	public boolean isProductNameDisplayed(String expNameVal) {
		waitForAllElementsVisible(ProductComparePageUI.PRODUCT_COMPARE_NAME_TEXT);
		return compareStringFromElementsText(expNameVal,ProductComparePageUI.PRODUCT_COMPARE_NAME_TEXT);
	}
	
	public boolean isNumberOfProductMatchedByRowName(int expVal,String locatorName) {
		waitForAllElementsVisible(AbstactPageUI.A_CONTAINS_TEXT_PRODUCT_COMPARE_TEXT_DYNAMIC,locatorName);
		return compareNumberOfItem(expVal,AbstactPageUI.A_CONTAINS_TEXT_PRODUCT_COMPARE_TEXT_DYNAMIC,locatorName);
	}
	
	public boolean isProductInfoDisplayedByRowName(String expPriceVal,String locatorName) {
		waitForAllElementsVisible(AbstactPageUI.A_CONTAINS_TEXT_PRODUCT_COMPARE_TEXT_DYNAMIC,locatorName);
		return compareStringFromElementsText(expPriceVal,AbstactPageUI.A_CONTAINS_TEXT_PRODUCT_COMPARE_TEXT_DYNAMIC,locatorName);
	}
	
	public boolean isClearListButtonDisplayed() {
		waitForElementVisible(AbstactPageUI.A_CLASS_DYNAMIC,ProductComparePageUI.A_CLASS_PRODUCT_COMPARE_CLEAR_LIST_BUTTON);
		return elementIsDisplayed(AbstactPageUI.A_CLASS_DYNAMIC,ProductComparePageUI.A_CLASS_PRODUCT_COMPARE_CLEAR_LIST_BUTTON);
	}
	
	public void clickToClearListButton() {
		waitForElementVisible(AbstactPageUI.A_CLASS_DYNAMIC,ProductComparePageUI.A_CLASS_PRODUCT_COMPARE_CLEAR_LIST_BUTTON);
		clickToElement(AbstactPageUI.A_CLASS_DYNAMIC,ProductComparePageUI.A_CLASS_PRODUCT_COMPARE_CLEAR_LIST_BUTTON);
	}
	
	public boolean isProductCompareTableNotDisplayed() {
		return elementIsDisplayed(ProductComparePageUI.PRODUCT_COMPARE_PAGE_TABLE);
	}
	
	public String getNoDataMessageData() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,ProductComparePageUI.DIV_CLASS_PRODUCT_COMPARE_PAGE_NO_DATA_MESSAGE);
		return getTextElement(AbstactPageUI.DIV_CLASS_DYNAMIC,ProductComparePageUI.DIV_CLASS_PRODUCT_COMPARE_PAGE_NO_DATA_MESSAGE);
	}
}
