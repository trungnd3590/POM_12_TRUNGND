package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstactPageUI;
import pageUIs.WishListPageUI;

public class WishListPageObject extends AbstractPage{

	public WishListPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isWishListPageDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,WishListPageUI.DIV_CLASS_WISHLIST_PAGE_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,WishListPageUI.DIV_CLASS_WISHLIST_PAGE_FORM);
	}
	
	public String getWishListProductNameData(String locatorName) {
		waitForElementVisible(AbstactPageUI.A_CLASS_DYNAMIC,locatorName);
		return getTextElement(AbstactPageUI.A_CLASS_DYNAMIC,locatorName);
	}
	
	public void clickToWishListShareLink() {
		waitForElementVisible(AbstactPageUI.A_CLASS_DYNAMIC,WishListPageUI.A_CLASS_WISHLIST_PAGE_SHARE_LINK);
		clickToElement(AbstactPageUI.A_CLASS_DYNAMIC,WishListPageUI.A_CLASS_WISHLIST_PAGE_SHARE_LINK);
	}

	public String getWishListShareLinkTitleData() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,WishListPageUI.DIV_CLASS_WISHLIST_PAGE_VIEW_SHARE_LINK);
		return getTextElement(AbstactPageUI.DIV_CLASS_DYNAMIC,WishListPageUI.DIV_CLASS_WISHLIST_PAGE_VIEW_SHARE_LINK);
	}
	
	public void clickToAddToCartCheckbox() {
		waitForElementVisible(AbstactPageUI.INPUT_NAME_DYNAMIC,WishListPageUI.INPUT_NAME_WISHLIST_PAGE_ADD_TO_CART_CHECKBOX);
		checkToCheckbox(AbstactPageUI.INPUT_NAME_DYNAMIC,WishListPageUI.INPUT_NAME_WISHLIST_PAGE_ADD_TO_CART_CHECKBOX);
	}
	
	public void clickToRemoveCheckbox() {
		waitForElementVisible(AbstactPageUI.INPUT_NAME_DYNAMIC,WishListPageUI.INPUT_NAME_WISHLIST_PAGE_REMOVE_CHECKBOK);
		checkToCheckbox(AbstactPageUI.INPUT_NAME_DYNAMIC,WishListPageUI.INPUT_NAME_WISHLIST_PAGE_REMOVE_CHECKBOK);
	}
	
	public void clickToAddToCartButton() {
		waitForElementVisible(AbstactPageUI.INPUT_NAME_DYNAMIC,WishListPageUI.INPUT_NAME_WISHLIST_PAGE_ADD_TO_CART_BUTTON);
		clickToElement(AbstactPageUI.INPUT_NAME_DYNAMIC,WishListPageUI.INPUT_NAME_WISHLIST_PAGE_ADD_TO_CART_BUTTON);
	}
	
	public void clickToUpdateWishListButton() {
		waitForElementVisible(AbstactPageUI.INPUT_NAME_DYNAMIC,WishListPageUI.INPUT_NAME_WISHLIST_PAGE_UPDATE_WISHLIST_CHECKBOX);
		clickToElement(AbstactPageUI.INPUT_NAME_DYNAMIC,WishListPageUI.INPUT_NAME_WISHLIST_PAGE_UPDATE_WISHLIST_CHECKBOX);
	}
	
	public String getNoDataMessageData() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,WishListPageUI.DIV_CLASS_WISHLIST_PAGE_NO_DATA_MESSAGE);
		return getTextElement(AbstactPageUI.DIV_CLASS_DYNAMIC,WishListPageUI.DIV_CLASS_WISHLIST_PAGE_NO_DATA_MESSAGE);
	}
	
	public boolean isProductNameNotDisplayed(String locatorName) {
		return elementIsDisplayed(AbstactPageUI.A_CLASS_DYNAMIC,locatorName);
	}
}
