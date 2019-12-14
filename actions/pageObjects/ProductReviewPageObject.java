package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstactPageUI;
import pageUIs.ProductReviewPageUI;

public class ProductReviewPageObject extends AbstractPage{

	public ProductReviewPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isProductReviewPageDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_ID_DYNAMIC,ProductReviewPageUI.DIV_ID_PRODUCT_REVIEW_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_ID_DYNAMIC,ProductReviewPageUI.DIV_ID_PRODUCT_REVIEW_FORM);
	}
	
	public String getProductReviewNameData(String locatorName) {
		waitForElementVisible(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC,locatorName);
		return getTextElement(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC,locatorName);
	}
	
	public void inputToReviewTitleTexbox(String titleVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,ProductReviewPageUI.INPUT_ID_PRODUCT_REVIEW_TITLE_TEXTBOX);
		sendkeysToElement(titleVal,AbstactPageUI.INPUT_ID_DYNAMIC,ProductReviewPageUI.INPUT_ID_PRODUCT_REVIEW_TITLE_TEXTBOX);
	}
	
	public void inputToReviewDescriptionTextarea(String descriptionVal) {
		waitForElementVisible(ProductReviewPageUI.PRODUCT_REVIEW_DESCRIPTION_TEXTAREA);
		sendkeysToElement(descriptionVal,ProductReviewPageUI.PRODUCT_REVIEW_DESCRIPTION_TEXTAREA);
	}
	
	public void clickToSubmitReviewButton() {
		waitForElementVisible(AbstactPageUI.INPUT_NAME_DYNAMIC,ProductReviewPageUI.INPUT_NAME_PRODUCT_REVIEW_SUBMIT_BUTTON);
		clickToElement(AbstactPageUI.INPUT_NAME_DYNAMIC,ProductReviewPageUI.INPUT_NAME_PRODUCT_REVIEW_SUBMIT_BUTTON);
	}
	
	public String getProductReviewResultMessageData() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,ProductReviewPageUI.DIV_CLASS_PRODUCT_REVIEW_RESULT_MESSAGE);
		return getTextElement(AbstactPageUI.DIV_CLASS_DYNAMIC,ProductReviewPageUI.DIV_CLASS_PRODUCT_REVIEW_RESULT_MESSAGE);
	}
}
