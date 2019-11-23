package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.SearchPageUI;

public class SearchPageObject extends AbstractPage{

	public SearchPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isSearchPageFormDisplayed() {
		waitForElementVisible(SearchPageUI.SEARCH_PAGE_FORM);
		return elementIsDisplayed(SearchPageUI.SEARCH_PAGE_FORM);
	}
	
	public void inputToSearchTextbox(String searchVal) {
		waitForElementVisible(SearchPageUI.SEARCH_TEXTBOX);
		sendkeysToElement(SearchPageUI.SEARCH_TEXTBOX, searchVal);
	}
	
	public void clickToAdvanceSearchCheckbox() {
		waitForElementVisible(SearchPageUI.SEARCH_ADVANCE_CHECKBOX);
		checkToCheckbox(SearchPageUI.SEARCH_ADVANCE_CHECKBOX);
	}
	
	public boolean isSearchAdvanceFormDisplayed() {
		waitForElementVisible(SearchPageUI.SEARCH_ADVANCE_FORM);
		return elementIsDisplayed(SearchPageUI.SEARCH_ADVANCE_FORM);
	}
	
	public void selectItemFromCategoryDropdown(String itemVal) {
		waitForElementVisible(SearchPageUI.SEARCH_ADVANCE_CATEGORY_DROPDOWN);
		selectItemInDropdown(SearchPageUI.SEARCH_ADVANCE_CATEGORY_DROPDOWN, itemVal);
	}
	
	public void clickToAdvanceSearchSubCategoryCheckbox() {
		waitForElementVisible(SearchPageUI.SEARCH_ADVANCE_SUB_CATEGORY_CHECKBOX);
		checkToCheckbox(SearchPageUI.SEARCH_ADVANCE_SUB_CATEGORY_CHECKBOX);
	}
	
	public void selectItemFromManufacturerDropdown(String itemVal) {
		waitForElementVisible(SearchPageUI.SEARCH_ADVANCE_MANUFACTURER_DROPDOWN);
		selectItemInDropdown(SearchPageUI.SEARCH_ADVANCE_MANUFACTURER_DROPDOWN, itemVal);
	}
	
	public void inputToMinimumPriceRangeTextbox(String minVal) {
		waitForElementVisible(SearchPageUI.SEARCH_ADVANCE_MINIMUM_PRICE_RANGE_TEXTBOX);
		sendkeysToElement(SearchPageUI.SEARCH_ADVANCE_MINIMUM_PRICE_RANGE_TEXTBOX, minVal);
	}
	
	public void inputToMaximumPriceRangeTextbox(String maxVal) {
		waitForElementVisible(SearchPageUI.SEARCH_ADVANCE_MAXIMUM_PRICE_RANGE_TEXTBOX);
		sendkeysToElement(SearchPageUI.SEARCH_ADVANCE_MAXIMUM_PRICE_RANGE_TEXTBOX, maxVal);
	}
	
	public void clickToSearchButton() {
		waitForElementVisible(SearchPageUI.SEARCH_BUTTON);
		clickToElement(SearchPageUI.SEARCH_BUTTON);
	}
	
	public String getSearchWarningMesssageData() {
		waitForElementVisible(SearchPageUI.SEARCH_WARNING_MESSAGE);
		return getTextElement(SearchPageUI.SEARCH_WARNING_MESSAGE);
	}
	
	public String getSearchNoResultMesssageData() {
		waitForElementVisible(SearchPageUI.SEARCH_NO_RESULT_MESSAGE);
		return getTextElement(SearchPageUI.SEARCH_NO_RESULT_MESSAGE);
	}
	
	public boolean isSearchResultItemGridDisplayed() {
		waitForElementVisible(SearchPageUI.SEARCH_RESULT_ITEM_GRID);
		return elementIsDisplayed(SearchPageUI.SEARCH_RESULT_ITEM_GRID);
	}
	
	public int countNumberOfItems() {
		waitForAllElementsVisible(SearchPageUI.SEARCH_RESULT_ITEM_NAME);
		return  countElementNumber(SearchPageUI.SEARCH_RESULT_ITEM_NAME);
	}
	
	public boolean isSearchItemNameDisplayed(String expItemNameVal) {
		waitForAllElementsVisible(SearchPageUI.SEARCH_RESULT_ITEM_NAME);
		return compareStringFromElementText(SearchPageUI.SEARCH_RESULT_ITEM_NAME, expItemNameVal);
	}
	
	

}
