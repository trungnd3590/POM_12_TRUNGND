package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstactPageUI;
import pageUIs.SearchPageUI;

public class SearchPageObject extends AbstractPage{

	public SearchPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isSearchPageFormDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,SearchPageUI.DIV_CLASS_SEARCH_PAGE_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,SearchPageUI.DIV_CLASS_SEARCH_PAGE_FORM);
	}
	
	public void inputToSearchTextbox(String searchVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,SearchPageUI.INPUT_ID_SEARCH_TEXTBOX);
		sendkeysToElement(searchVal,AbstactPageUI.INPUT_ID_DYNAMIC,SearchPageUI.INPUT_ID_SEARCH_TEXTBOX);
	}
	
	public void clickToAdvanceSearchCheckbox() {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,SearchPageUI.INPUT_ID_SEARCH_ADVANCE_CHECKBOX);
		checkToCheckbox(AbstactPageUI.INPUT_ID_DYNAMIC,SearchPageUI.INPUT_ID_SEARCH_ADVANCE_CHECKBOX);
	}
	
	public boolean isSearchAdvanceFormDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_ID_DYNAMIC,SearchPageUI.DIV_ID_SEARCH_ADVANCE_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_ID_DYNAMIC,SearchPageUI.DIV_ID_SEARCH_ADVANCE_FORM);
	}
	
	public void selectItemFromCategoryDropdown(String itemVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC,SearchPageUI.SELECT_ID_SEARCH_ADVANCE_CATEGORY_DROPDOWN);
		selectItemInDropdown(itemVal,AbstactPageUI.SELECT_ID_DYNAMIC,SearchPageUI.SELECT_ID_SEARCH_ADVANCE_CATEGORY_DROPDOWN);
	}
	
	public void clickToAdvanceSearchSubCategoryCheckbox() {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,SearchPageUI.INPUT_ID_SEARCH_ADVANCE_SUB_CATEGORY_CHECKBOX);
		checkToCheckbox(AbstactPageUI.INPUT_ID_DYNAMIC,SearchPageUI.INPUT_ID_SEARCH_ADVANCE_SUB_CATEGORY_CHECKBOX);
	}
	
	public void selectItemFromManufacturerDropdown(String itemVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC,SearchPageUI.SELECT_ID_SEARCH_ADVANCE_MANUFACTURER_DROPDOWN);
		selectItemInDropdown(itemVal,AbstactPageUI.SELECT_ID_DYNAMIC,SearchPageUI.SELECT_ID_SEARCH_ADVANCE_MANUFACTURER_DROPDOWN);
	}
	
	public void inputToMinimumPriceRangeTextbox(String minVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,SearchPageUI.INPUT_ID_SEARCH_ADVANCE_MINIMUM_PRICE_RANGE_TEXTBOX);
		sendkeysToElement(minVal,AbstactPageUI.INPUT_ID_DYNAMIC,SearchPageUI.INPUT_ID_SEARCH_ADVANCE_MINIMUM_PRICE_RANGE_TEXTBOX);
	}
	
	public void inputToMaximumPriceRangeTextbox(String maxVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,SearchPageUI.INPUT_ID_SEARCH_ADVANCE_MAXIMUM_PRICE_RANGE_TEXTBOX);
		sendkeysToElement(maxVal,AbstactPageUI.INPUT_ID_DYNAMIC,SearchPageUI.INPUT_ID_SEARCH_ADVANCE_MAXIMUM_PRICE_RANGE_TEXTBOX);
	}
	
	public void clickToSearchButton() {
		waitForElementVisible(AbstactPageUI.INPUT_CLASS_DYNAMIC,SearchPageUI.INPUT_CLASS_SEARCH_BUTTON);
		clickToElement(AbstactPageUI.INPUT_CLASS_DYNAMIC,SearchPageUI.INPUT_CLASS_SEARCH_BUTTON);
	}
	
	public String getSearchWarningMesssageData() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,SearchPageUI.DIV_CLASS_SEARCH_WARNING_MESSAGE);
		return getTextElement(AbstactPageUI.DIV_CLASS_DYNAMIC,SearchPageUI.DIV_CLASS_SEARCH_WARNING_MESSAGE);
	}
	
	public String getSearchNoResultMesssageData() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,SearchPageUI.DIV_CLASS_SEARCH_NO_RESULT_MESSAGE);
		return getTextElement(AbstactPageUI.DIV_CLASS_DYNAMIC,SearchPageUI.DIV_CLASS_SEARCH_NO_RESULT_MESSAGE);
	}
	
	public boolean isSearchResultItemGridDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,SearchPageUI.DIV_CLASS_SEARCH_RESULT_ITEM_GRID);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,SearchPageUI.DIV_CLASS_SEARCH_RESULT_ITEM_GRID);
	}
	
	public int countNumberOfItems() {
		waitForAllElementsVisible(SearchPageUI.SEARCH_RESULT_ITEM_NAME);
		return  countElementNumber(SearchPageUI.SEARCH_RESULT_ITEM_NAME);
	}
	
	public boolean isSearchItemNameDisplayed(String expItemNameVal) {
		waitForAllElementsVisible(SearchPageUI.SEARCH_RESULT_ITEM_NAME);
		return compareStringFromElementsText(expItemNameVal,SearchPageUI.SEARCH_RESULT_ITEM_NAME);
	}
	
	

}
