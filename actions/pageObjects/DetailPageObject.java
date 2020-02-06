package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstactPageUI;
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
	
	public String getProductDetailTitleData(String locatorName) {
		waitForElementVisible(AbstactPageUI.H1_CONTAINS_TEXT_DYNAMIC_PRODUCT,locatorName);
		return getTextElement(AbstactPageUI.H1_CONTAINS_TEXT_DYNAMIC_PRODUCT,locatorName);
	}
	
	public void clickToWishListButton() {
		waitForElementClickable(AbstactPageUI.INPUT_ID_DYNAMIC,DetailPageUI.INPUT_ID_DETAIL_PAGE_ADD_TO_WISHLIST_BUTTON);
		clickToElement(AbstactPageUI.INPUT_ID_DYNAMIC,DetailPageUI.INPUT_ID_DETAIL_PAGE_ADD_TO_WISHLIST_BUTTON);
	}
	
	public void selectDataFromDropdown(String dataVal, String locatorName) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC,locatorName);
		selectItemInDropdown(dataVal,AbstactPageUI.SELECT_ID_DYNAMIC,locatorName);
	}
	
	public void clickToRadioButton(String locatorName) {
		waitForElementClickable(AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
		clickToElement(AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
	}
	
	public void clickToCheckbox(String locatorName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
		checkToCheckbox(AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
	}
	
	public void unClickToCheckbox(String locatorName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
		unCheckToCheckbox(AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
	}
	
	public String getUnitPriceData() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC, DetailPageUI.DIV_CLASS_DETAIL_PAGE_PRODUCT_UNIT_PRICE);
		return getTextElement(AbstactPageUI.DIV_CLASS_DYNAMIC, DetailPageUI.DIV_CLASS_DETAIL_PAGE_PRODUCT_UNIT_PRICE);
	}
	
	public void clickToAddToCartButton() {
		waitForElementClickable(DetailPageUI.DETAIL_PAGE_ADD_TO_CART_BUTTON);
		clickToElement(DetailPageUI.DETAIL_PAGE_ADD_TO_CART_BUTTON);
	}
	
	public boolean isDetailPageSuccesNotificationBarDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,DetailPageUI.DIV_CLASS_DETAIL_PAGE_SUCCESS_NOTIFCATION_BAR);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,DetailPageUI.DIV_CLASS_DETAIL_PAGE_SUCCESS_NOTIFCATION_BAR);
	}
	
	public String getDetailPageSuccesNotificationBarData() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,DetailPageUI.DIV_CLASS_DETAIL_PAGE_SUCCESS_NOTIFCATION_BAR);
		return getTextElement(AbstactPageUI.DIV_CLASS_DYNAMIC,DetailPageUI.DIV_CLASS_DETAIL_PAGE_SUCCESS_NOTIFCATION_BAR);
	}
	
	public void clickToNotificationBarCloseButton() {
		waitForElementClickable(AbstactPageUI.SPAN_CLASS_DYNAMIC,DetailPageUI.SPAN_CLASS_DETAIL_PAGE_NOTIFCATION_BAR_CLOSE_BUTTON);
		clickToElement(AbstactPageUI.SPAN_CLASS_DYNAMIC,DetailPageUI.SPAN_CLASS_DETAIL_PAGE_NOTIFCATION_BAR_CLOSE_BUTTON);
	}
	
	public void clickToMiniShoppingCartButton() {
		waitForElementClickable(AbstactPageUI.INPUT_CLASS_DYNAMIC, AbstactPageUI.INPUT_CLASS_MINI_SHOPPING_CART_BUTTON);
		clickToElement(AbstactPageUI.INPUT_CLASS_DYNAMIC, AbstactPageUI.INPUT_CLASS_MINI_SHOPPING_CART_BUTTON);
	}
	
	public void addMoreQuantity(String numberVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC, DetailPageUI.INPUT_ID_DETAIL_PAGE_UPDATE_QUANTITY_TEXTBOX);
		sendkeysToElement(numberVal,AbstactPageUI.INPUT_ID_DYNAMIC, DetailPageUI.INPUT_ID_DETAIL_PAGE_UPDATE_QUANTITY_TEXTBOX);
	}
	
}
