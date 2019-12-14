package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstactPageUI;
import pageUIs.NoteBooksPageUI;

public class NoteBooksPageObject extends AbstractPage{

	public NoteBooksPageObject(WebDriver driver) {
		super(driver);
	}
	
	public boolean isNoteBookPageDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,NoteBooksPageUI.DIV_CLASS_NOTEBOOKS_PAGE_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,NoteBooksPageUI.DIV_CLASS_NOTEBOOKS_PAGE_FORM);
	} 
	
	public void selectSortFromDropdown(String sortVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC,NoteBooksPageUI.SELECT_ID_NOTEBOOKS_PAGE_SORT_DROPDOWN);
		selectItemInDropdown(sortVal,AbstactPageUI.SELECT_ID_DYNAMIC,NoteBooksPageUI.SELECT_ID_NOTEBOOKS_PAGE_SORT_DROPDOWN);
	}
	
	public void selectProductDisplayPerPageFromDropdown(String perVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC,NoteBooksPageUI.SELECT_ID_NOTEBOOKS_PPRODUCTS_DISPLAY_PER_PAGE_DROPDOWN);
		selectItemInDropdown(perVal,AbstactPageUI.SELECT_ID_DYNAMIC,NoteBooksPageUI.SELECT_ID_NOTEBOOKS_PPRODUCTS_DISPLAY_PER_PAGE_DROPDOWN);
	}
	
	public boolean isProductNameSortedAtoZ() {
		waitForAllElementsVisible(NoteBooksPageUI.NOTERBOKS_PRODUCT_TITLES);
		return sortDataAcending(NoteBooksPageUI.NOTERBOKS_PRODUCT_TITLES);
	}
	
	public boolean isProductNameSortedZtoA() {
		waitForAllElementsVisible(NoteBooksPageUI.NOTERBOKS_PRODUCT_TITLES);
		return sortDataDecending(NoteBooksPageUI.NOTERBOKS_PRODUCT_TITLES);
	}
	
	public boolean isProductPriceSortedLowToHigh() {
		waitForAllElementsVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,NoteBooksPageUI.DIV_CLASS_NOTETBOOKS_PRODUCT_PRICES);
		return sortDataAcending(AbstactPageUI.DIV_CLASS_DYNAMIC,NoteBooksPageUI.DIV_CLASS_NOTETBOOKS_PRODUCT_PRICES);
	}
	
	public boolean isProductPriceSortedHighToLow() {
		waitForAllElementsVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,NoteBooksPageUI.DIV_CLASS_NOTETBOOKS_PRODUCT_PRICES);
		return sortDataDecending(AbstactPageUI.DIV_CLASS_DYNAMIC,NoteBooksPageUI.DIV_CLASS_NOTETBOOKS_PRODUCT_PRICES);
	}
	
	public boolean isNumberOfProductsPerPageMatched(int expVal) {
		waitForAllElementsVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,NoteBooksPageUI.DIV_CLASS_NOTERBOOKS_PRODUCTS_NUMBER_PER_PAGE);
		return compareNumberOfItem(expVal,AbstactPageUI.DIV_CLASS_DYNAMIC,NoteBooksPageUI.DIV_CLASS_NOTERBOOKS_PRODUCTS_NUMBER_PER_PAGE);
	}
	
	public boolean isPagingDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,NoteBooksPageUI.DIV_CLASS_NOTEBOOKS_PRODUCT_PAGING);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,NoteBooksPageUI.DIV_CLASS_NOTEBOOKS_PRODUCT_PAGING);
	}
	
	public boolean isPagingNotDisplayed() {
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,NoteBooksPageUI.DIV_CLASS_NOTEBOOKS_PRODUCT_PAGING);
	}
	
	public boolean isNextPageButtonDisplayed() {
		waitForElementVisible(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC,NoteBooksPageUI.A_CONTAINS_TEXT_NOTEBOOKS_NEXT_PAGE_BUTTON);
		return elementIsDisplayed(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC,NoteBooksPageUI.A_CONTAINS_TEXT_NOTEBOOKS_NEXT_PAGE_BUTTON);
	}
	
	public void clickToPageTwo() {
		waitForElementVisible(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC,NoteBooksPageUI.A_CONTAINS_TEXT_NOTEBOOKS_PAGE_TWO_BUTTON);
		clickToElement(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC,NoteBooksPageUI.A_CONTAINS_TEXT_NOTEBOOKS_PAGE_TWO_BUTTON);
	}
	
	public boolean isPreviousPageButtonDisplayed() {
		waitForElementVisible(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC,NoteBooksPageUI.A_CONTAINS_TEXT_NOTEBOOKS_PREVIOUS_PAGE_BUTTON);
		return elementIsDisplayed(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC,NoteBooksPageUI.A_CONTAINS_TEXT_NOTEBOOKS_PREVIOUS_PAGE_BUTTON);
	}
	
	public void addProductToCompare(String locatorName) {
		waitForElementVisible(AbstactPageUI.A_CONTAINS_TEXT_ADD_TO_COMPARE_DYNAMIC,locatorName);
		clickToElement(AbstactPageUI.A_CONTAINS_TEXT_ADD_TO_COMPARE_DYNAMIC,locatorName);
	}
	
	public boolean isNoteBookPageSuccesNotificationBarDisplayed() {
		waitForElementVisible(NoteBooksPageUI.NOTEBOOKS_SUCCESS_NOTIFICATION_BAR);
		return elementIsDisplayed(NoteBooksPageUI.NOTEBOOKS_SUCCESS_NOTIFICATION_BAR);
	}
	
	public String getNoteBookPageSuccesNotificationBarData() {
		waitForElementVisible(NoteBooksPageUI.NOTEBOOKS_SUCCESS_NOTIFICATION_BAR);
		return getTextElement(NoteBooksPageUI.NOTEBOOKS_SUCCESS_NOTIFICATION_BAR);
	}

}
