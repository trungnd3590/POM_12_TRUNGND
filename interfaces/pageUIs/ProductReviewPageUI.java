package pageUIs;

import org.openqa.selenium.By;

public class ProductReviewPageUI {

	public static final By PRODUCT_ASUS_N551_REVIEW = By.xpath("//a[contains(text(),'Asus N551JK-XO076H Laptop')]");
	public static final By PRODUCT_REVIEW_FORM = By.xpath("//div[@id='review-form']");
	public static final By PRODUCT_REVIEW_TITLE_TEXTBOX = By.xpath("//input[@id='AddProductReview_Title']");
	public static final By PRODUCT_REVIEW_DESCRIPTION_TEXTAREA = By.xpath("//textarea[@id='AddProductReview_ReviewText']");
	public static final By PRODUCT_REVIEW_RATING_CHECKBOX = By.xpath("//div[@class='rating-options']");
	public static final By PRODUCT_REVIEW_SUBMIT_BUTTON = By.xpath("//input[@name='add-review']");
	public static final By PRODUCT_REVIEW_RESULT_MESSAGE = By.xpath("//div[@class='result']");
}
