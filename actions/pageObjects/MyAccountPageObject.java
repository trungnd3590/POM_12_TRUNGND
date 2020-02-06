package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstactPageUI;
import pageUIs.MyAccountPageUI;

public class MyAccountPageObject extends AbstractPage {
	
	public MyAccountPageObject(WebDriver driver) {
		super(driver);
	}
	
	public boolean isMyAccountPageDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_MY_ACCOUNT_PAGE_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_MY_ACCOUNT_PAGE_FORM);
	}

	public String isGenderButtonSelected(String locatorName,String attributeName) {
		waitForElementVisible(AbstactPageUI.SPAN_CLASS_DYNAMIC,locatorName);
		return getAttributeValue(attributeName,AbstactPageUI.SPAN_CLASS_DYNAMIC,locatorName);
	}
	
	public String getTexBoxNameData(String locatorName,String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
		return getAttributeValue(attributeName,AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
	}
	
	public String getDateOfBirthDropDownData(String locatorName) {
		waitForElementVisible(AbstactPageUI.SELECT_NAME_DYNAMIC,locatorName);
		return getItemValueInDropdown(AbstactPageUI.SELECT_NAME_DYNAMIC,locatorName);
	}
	
	public void clickToRadioButton(String locatorName) {
		waitForElementClickable(AbstactPageUI.SPAN_CLASS_DYNAMIC,locatorName);
		clickToElement(AbstactPageUI.SPAN_CLASS_DYNAMIC,locatorName);
	}

	public void inputToCustomerInfoTextboxName(String locatorName,String fistNameVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
		sendkeysToElement(fistNameVal,AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
	}

	public void selectDateOfBirthFromDropdown(String locatorName,String dateOfBirthVal) {
		waitForElementVisible(AbstactPageUI.SELECT_NAME_DYNAMIC,locatorName);
		selectItemInDropdown(dateOfBirthVal,AbstactPageUI.SELECT_NAME_DYNAMIC,locatorName);
	}
	
	public void clickToCustomerInfoSaveButton() {
		waitForElementClickable(AbstactPageUI.INPUT_ID_DYNAMIC,MyAccountPageUI.INPUT_ID_SAVE_BUTTON);
		clickToElement(AbstactPageUI.INPUT_ID_DYNAMIC,MyAccountPageUI.INPUT_ID_SAVE_BUTTON);
	}
	
	public void clickToAddressLink() {
		waitForElementClickable(MyAccountPageUI.ADDRESS_LINKS);
		clickToElement(MyAccountPageUI.ADDRESS_LINKS);
	}
	
	public void clickToAddressAddNewButton() {
		waitForElementClickable(AbstactPageUI.INPUT_CLASS_DYNAMIC,MyAccountPageUI.INPUT_CLASS_ADDRESS_ADD_NEW_ADDRESS_BUTTON);
		clickToElement(AbstactPageUI.INPUT_CLASS_DYNAMIC,MyAccountPageUI.INPUT_CLASS_ADDRESS_ADD_NEW_ADDRESS_BUTTON);
	}
	
	public boolean isAddressTableDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_ADDRESS_NEW_ADDRESS_TABLE);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_ADDRESS_NEW_ADDRESS_TABLE);
	}
	
	public void inputToAddressTextboxName(String locatorName,String addFirstNameVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
		sendkeysToElement(addFirstNameVal,AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
	}
	
	public void selectAddressFromDropdownName(String locatorName,String addSelectVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC,locatorName);
		selectItemInDropdown(addSelectVal,AbstactPageUI.SELECT_ID_DYNAMIC,locatorName);
	}

	public void clickToAddressSaveButton() {
		waitForElementClickable(AbstactPageUI.INPUT_CLASS_DYNAMIC,MyAccountPageUI.INPUT_CLASS_ADDRESS_SAVE_BUTTON);
		clickToElement(AbstactPageUI.INPUT_CLASS_DYNAMIC,MyAccountPageUI.INPUT_CLASS_ADDRESS_SAVE_BUTTON);
	}
	
	public boolean isAddressInfoTableDisplayed() {
		waitForElementVisible(MyAccountPageUI.ADDRESS_INFO_TABLE);
		return elementIsDisplayed(MyAccountPageUI.ADDRESS_INFO_TABLE);
	}
	
	public String getAddressNameTextData(String locatorName) {
		waitForElementVisible(AbstactPageUI.LI_CLASS_DYNAMIC,locatorName);
		return getTextElement(AbstactPageUI.LI_CLASS_DYNAMIC,locatorName);
	}
	
	public void clickToChangePasswordLink() {
		waitForElementClickable(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC,MyAccountPageUI.A_CONTAINS_TEXT_CHANGE_PASSWORD_LINK);
		clickToElement(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC,MyAccountPageUI.A_CONTAINS_TEXT_CHANGE_PASSWORD_LINK);
	}
	
	public boolean isChangePasswordFormDisplayed() {
		waitForElementVisible(MyAccountPageUI.CHANGE_PASSWORD_FORM);
		return elementIsDisplayed(MyAccountPageUI.CHANGE_PASSWORD_FORM);
	}
	
	public void inputToChangePasswordTextboxName(String locatorName,String texVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
		sendkeysToElement(texVal,AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
	}
	
	public void clickToChangePasswordButton() {
		waitForElementClickable(AbstactPageUI.INPUT_CLASS_DYNAMIC,MyAccountPageUI.INPUT_CLASS_CHANGE_NEW_PASSWORD_BUTTON);
		clickToElement(AbstactPageUI.INPUT_CLASS_DYNAMIC,MyAccountPageUI.INPUT_CLASS_CHANGE_NEW_PASSWORD_BUTTON);
		}
	
	public String getChangeNewPassResultMessageData() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_CHANGE_NEW_PASSWORD_RESULT_MESSAGE);
		return getTextElement(AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_CHANGE_NEW_PASSWORD_RESULT_MESSAGE);
	}
	
	public void clickToMyProductReviewLink() {
		waitForElementClickable(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC,MyAccountPageUI.A_CONTAINS_TEXT_MY_PRODUCT_REVIEW_LINK);
		clickToElement(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC,MyAccountPageUI.A_CONTAINS_TEXT_MY_PRODUCT_REVIEW_LINK);
	}
	
	public boolean isMyProductReviewFormDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_MY_PRODUCT_REVIEW_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_MY_PRODUCT_REVIEW_FORM);
	}
	
	public boolean isMyProductReviewTitleDisplayed(String expTitleVal) {
		waitForAllElementsVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_MY_PRODUCT_REVIEW_PRODUCT_TITLE);
		return compareStringFromElementsText(expTitleVal,AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_MY_PRODUCT_REVIEW_PRODUCT_TITLE);
	}
	
	public boolean isMyProductReviewDescriptionDisplayed(String expDescriptionVal) {
		waitForAllElementsVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_MY_PRODUCT_REVIEW_PRODUCT_DESCRIPTION);
		return compareStringFromElementsText(expDescriptionVal,AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_MY_PRODUCT_REVIEW_PRODUCT_DESCRIPTION);
	}
	
	public boolean isMyProductReviewInfoDisplayed(String expInfoVal) {
		waitForAllElementsVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_MY_PRODUCT_REVIEW_PRODUCT_INFO);
		return compareStringFromElementText(expInfoVal,AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_MY_PRODUCT_REVIEW_PRODUCT_INFO);
	}
	
	public void clickToCustomerOrderLink() {
		waitForElementClickable(MyAccountPageUI.CUSTOMER_ORDER_LINKS);
		clickToElement(MyAccountPageUI.CUSTOMER_ORDER_LINKS);
	}
	
	public boolean isCustomerOrderFormrDisplayed() {
		waitForAllElementsVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_CUSTOMER_ORDER_TABLE);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_CUSTOMER_ORDER_TABLE);
	}
	
	public boolean isOrderNumberDisplayed(String expInfoVal) {
		waitForAllElementsVisible(MyAccountPageUI.CUSTOMER_ORDER_NUMBER_TITLE);
		return compareStringFromElementText(expInfoVal,MyAccountPageUI.CUSTOMER_ORDER_NUMBER_TITLE);
	}
	
	public void clickToOpenOrderDetail(String locatorName) {
		waitForElementClickable(MyAccountPageUI.A_CONTAINS_TEXT_CUSTOMER_ORDER_DETAL_BUTTON_DYNAMIC,locatorName);
		clickToElement(MyAccountPageUI.A_CONTAINS_TEXT_CUSTOMER_ORDER_DETAL_BUTTON_DYNAMIC,locatorName);
	}
	
	public boolean isCustomerOrderDetailDisplayed() {
		waitForAllElementsVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_CUSTOMER_ORDER_DETAIL_TABLE);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_CUSTOMER_ORDER_DETAIL_TABLE);
	}
	
	public String getCustomerOrderDetailTitle() {
		waitForElementVisible(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_TITLE);
		return getTextElement(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_TITLE);
	}
	
	public boolean isCustomerOrderDetailNumberDisplayed(String expInfoVal) {
		waitForAllElementsVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_CUSTOMER_ORDER_DETAIL_NUMBER);
		return compareStringFromElementText(expInfoVal,AbstactPageUI.DIV_CLASS_DYNAMIC,MyAccountPageUI.DIV_CLASS_CUSTOMER_ORDER_DETAIL_NUMBER);
	}
	
	public String getCustomerOrderDetailStatus() {
		waitForElementVisible(AbstactPageUI.LI_CLASS_DYNAMIC,MyAccountPageUI.LI_CLASS_CUSTOMER_ORDER_DETAIL_STATUS);
		return getTextElement(AbstactPageUI.LI_CLASS_DYNAMIC,MyAccountPageUI.LI_CLASS_CUSTOMER_ORDER_DETAIL_STATUS);
	}
	
	public String getCustomerOrderDetailTotal() {
		waitForElementVisible(AbstactPageUI.LI_CLASS_DYNAMIC,MyAccountPageUI.LI_CLASS_CUSTOMER_ORDER_DETAIL_TOTAL);
		return getTextElement(AbstactPageUI.LI_CLASS_DYNAMIC,MyAccountPageUI.LI_CLASS_CUSTOMER_ORDER_DETAIL_TOTAL);
	}
	
	public String getCustomerOrderDetailBillingTitle() {
		waitForElementVisible(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_BILLING_TITLE);
		return getTextElement(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_BILLING_TITLE);
	}
	
	public String getCustomerOrderDetailBillingInfo(String locatorName) {
		waitForElementVisible(MyAccountPageUI.DIV_CLASS_CUSTOMER_ORDER_DETAIL_BILLING_DYNAMIC,locatorName);
		return getTextElement(MyAccountPageUI.DIV_CLASS_CUSTOMER_ORDER_DETAIL_BILLING_DYNAMIC, locatorName);
	}
	
	public String getCustomerOrderDetailShippingTitle() {
		waitForElementVisible(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_SHIPPING_TITLE);
		return getTextElement(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_SHIPPING_TITLE);
	}
	
	public String getCustomerOrderDetailShippingInfo(String locatorName) {
		waitForElementVisible(MyAccountPageUI.DIV_CLASS_CUSTOMER_ORDER_DETAIL_SHIPPING_DYNAMIC,locatorName);
		return getTextElement(MyAccountPageUI.DIV_CLASS_CUSTOMER_ORDER_DETAIL_SHIPPING_DYNAMIC, locatorName);
	}
	
	public String getCustomerOrderDetailPaymentMethodTitle() {
		waitForElementVisible(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_PAYMENT_METHOD_TITLE);
		return getTextElement(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_PAYMENT_METHOD_TITLE);
	}
	
	public String getCustomerOrderDetailPaymentMethodInfo() {
		waitForElementVisible(AbstactPageUI.LI_CLASS_DYNAMIC,MyAccountPageUI.LI_CLASS_CUSTOMER_ORDER_DETAIL_PAYMENT_INFO);
		return getTextElement(AbstactPageUI.LI_CLASS_DYNAMIC,MyAccountPageUI.LI_CLASS_CUSTOMER_ORDER_DETAIL_PAYMENT_INFO);
	}
	
	public String getCustomerOrderDetailPaymentMethodStatus() {
		waitForElementVisible(AbstactPageUI.LI_CLASS_DYNAMIC,MyAccountPageUI.LI_CLASS_CUSTOMER_ORDER_DETAIL_PAYMENT_STATUS);
		return getTextElement(AbstactPageUI.LI_CLASS_DYNAMIC,MyAccountPageUI.LI_CLASS_CUSTOMER_ORDER_DETAIL_PAYMENT_STATUS);
	}
	
	public String getCustomerOrderDetailShippingMethodTitle() {
		waitForElementVisible(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_SHIPPING_METHOD_TITLE);
		return getTextElement(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_SHIPPING_METHOD_TITLE);
	}
	
	public String getCustomerOrderDetailShippingMethodInfo() {
		waitForElementVisible(AbstactPageUI.LI_CLASS_DYNAMIC,MyAccountPageUI.LI_CLASS_CUSTOMER_ORDER_DETAIL_SHIPPING_INFO);
		return getTextElement(AbstactPageUI.LI_CLASS_DYNAMIC,MyAccountPageUI.LI_CLASS_CUSTOMER_ORDER_DETAIL_SHIPPING_INFO);
	}
	
	public String getCustomerOrderDetailShippingMethodStatus() {
		waitForElementVisible(AbstactPageUI.LI_CLASS_DYNAMIC,MyAccountPageUI.LI_CLASS_CUSTOMER_ORDER_DETAIL_SHIPPING_STATUS);
		return getTextElement(AbstactPageUI.LI_CLASS_DYNAMIC,MyAccountPageUI.LI_CLASS_CUSTOMER_ORDER_DETAIL_SHIPPING_STATUS);
	}
	
	public String getCustomerOrderDetailProductSkuValue() {
		waitForElementVisible(AbstactPageUI.SPAN_CLASS_DYNAMIC,MyAccountPageUI.SPAN_CLASS_CUSTOMER_DETAIL_PRODUCT_SKU_TEXT);
		return getTextElement(AbstactPageUI.SPAN_CLASS_DYNAMIC,MyAccountPageUI.SPAN_CLASS_CUSTOMER_DETAIL_PRODUCT_SKU_TEXT);
	}
	
	public String getCustomerOrderDetailProductNameValue() {
		waitForElementVisible(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_PRODUCT_NAME_TEXT);
		return getTextElement(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_PRODUCT_NAME_TEXT);
	}
	
	public String getCustomerOrderDetailProductUnitPriceValue() {
		waitForElementVisible(AbstactPageUI.SPAN_CLASS_DYNAMIC,MyAccountPageUI.SPAN_CLASS_CUSTOMER_DETAIL_PRODUCT_UNIT_PRICE_TEXT);
		return getTextElement(AbstactPageUI.SPAN_CLASS_DYNAMIC,MyAccountPageUI.SPAN_CLASS_CUSTOMER_DETAIL_PRODUCT_UNIT_PRICE_TEXT);
	}
	
	public String getCustomerOrderDetailProductQuantityValue() {
		waitForElementVisible(AbstactPageUI.SPAN_CLASS_DYNAMIC,MyAccountPageUI.SPAN_CLASS_CUSTOMER_DETAIL_PRODUCT_QUANTITY_TEXT);
		return getTextElement(AbstactPageUI.SPAN_CLASS_DYNAMIC,MyAccountPageUI.SPAN_CLASS_CUSTOMER_DETAIL_PRODUCT_QUANTITY_TEXT);
	}
	
	public String getCustomerOrderDetailProductTotalPriceValue() {
		waitForElementVisible(AbstactPageUI.SPAN_CLASS_DYNAMIC,MyAccountPageUI.SPAN_CLASS_CUSTOMER_DETAIL_PRODUCT_TOTAL_PRICE_TEXT);
		return getTextElement(AbstactPageUI.SPAN_CLASS_DYNAMIC,MyAccountPageUI.SPAN_CLASS_CUSTOMER_DETAIL_PRODUCT_TOTAL_PRICE_TEXT);
	}
	
	public String getCustomerOrderDetailProductSubTotalCostValue() {
		waitForElementVisible(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_SUB_TOTAL_COST_TEXT);
		return getTextElement(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_SUB_TOTAL_COST_TEXT);
	}
	
	public String getCustomerOrderDetailProductShippingCostValue() {
		waitForElementVisible(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_SHIPPING_COST_TEXT);
		return getTextElement(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_SHIPPING_COST_TEXT);
	}
	
	public String getCustomerOrderDetailProductTaxCostValue() {
		waitForElementVisible(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_TAX_COST_TEXT);
		return getTextElement(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_TAX_COST_TEXT);
	}
	
	public String getCustomerOrderDetailProductTotalCostValue() {
		waitForElementVisible(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_TOTAL_COST_TEXT);
		return getTextElement(MyAccountPageUI.CUSTOMER_ORDER_DETAIL_TOTAL_COST_TEXT);
	}
	
	public void clickToCustomerOrderDetailReOrderButton() {
		waitForElementClickable(AbstactPageUI.INPUT_CLASS_DYNAMIC,MyAccountPageUI.INPUT_CLASS_CUSTOMER_ORDER_DETAIL_REORDER_BUTTON);
		clickToElement(AbstactPageUI.INPUT_CLASS_DYNAMIC,MyAccountPageUI.INPUT_CLASS_CUSTOMER_ORDER_DETAIL_REORDER_BUTTON);
	}
}
