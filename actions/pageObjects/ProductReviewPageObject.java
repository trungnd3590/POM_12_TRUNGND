package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.ProductReviewPageUI;

public class ProductReviewPageObject extends AbstractPage{

	public ProductReviewPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isProductReviewPageDisplayed() {
		waitForElementVisible(ProductReviewPageUI.PRODUCT_REVIEW_FORM);
		return elementIsDisplayed(ProductReviewPageUI.PRODUCT_REVIEW_FORM);
	}
	
	public String getProductReviewNameData() {
		waitForElementVisible(ProductReviewPageUI.PRODUCT_ASUS_N551_REVIEW);
		return getTextElement(ProductReviewPageUI.PRODUCT_ASUS_N551_REVIEW);
	}
	
	public void inputToReviewTitleTexbox(String titleVal) {
		waitForElementVisible(ProductReviewPageUI.PRODUCT_REVIEW_TITLE_TEXTBOX);
		sendkeysToElement(ProductReviewPageUI.PRODUCT_REVIEW_TITLE_TEXTBOX, titleVal);
	}
	
	public void inputToReviewDescriptionTextarea(String descriptionVal) {
		waitForElementVisible(ProductReviewPageUI.PRODUCT_REVIEW_DESCRIPTION_TEXTAREA);
		sendkeysToElement(ProductReviewPageUI.PRODUCT_REVIEW_DESCRIPTION_TEXTAREA, descriptionVal);
	}
	
	public void clickToSubmitReviewButton() {
		waitForElementVisible(ProductReviewPageUI.PRODUCT_REVIEW_SUBMIT_BUTTON);
		clickToElement(ProductReviewPageUI.PRODUCT_REVIEW_SUBMIT_BUTTON);
	}
	
	public String getProductReviewResultMessageData() {
		waitForElementVisible(ProductReviewPageUI.PRODUCT_REVIEW_RESULT_MESSAGE);
		return getTextElement(ProductReviewPageUI.PRODUCT_REVIEW_RESULT_MESSAGE);
	}
}
