package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstactPageUI;
import pageUIs.ShoppingCartPageUI;

public class ShoppingCartPageObject extends AbstractPage{

	public ShoppingCartPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isShoppingCartPageDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC, AbstactPageUI.DIV_CLASS_PAGE_TITLE);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC, AbstactPageUI.DIV_CLASS_PAGE_TITLE);
	}
	
	public String getShoppingCartPageTitle() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC, AbstactPageUI.DIV_CLASS_PAGE_TITLE);
		return getTextElement(AbstactPageUI.DIV_CLASS_DYNAMIC, AbstactPageUI.DIV_CLASS_PAGE_TITLE);
	}
	
	public String getShoppingCartProductNameData(String locatorName) {
		waitForElementVisible(AbstactPageUI.A_CLASS_DYNAMIC,locatorName);
		return getTextElement(AbstactPageUI.A_CLASS_DYNAMIC,locatorName);
	}
	
	public String getShoppingCartProductData(String dynamicLocator , String... relLocator) {
		waitForElementVisible(dynamicLocator, relLocator);
		return getTextElement(dynamicLocator, relLocator);
	}
	
	public String getShoppingCartQuantityData(String attributeName) {
		waitForElementVisible(ShoppingCartPageUI.PRODUCT_QUANTITY);
		return getAttributeValue(attributeName,ShoppingCartPageUI.PRODUCT_QUANTITY);
	}
	
	public void inputToShoppingCartQuantityTextBox(String numberVal) {
		waitForElementVisible(ShoppingCartPageUI.PRODUCT_QUANTITY);
		sendkeysToElement(numberVal,ShoppingCartPageUI.PRODUCT_QUANTITY);
	}
	
	public void clickToEditProductButton() {
		waitForElementClickable(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC, ShoppingCartPageUI.A_CONTAINS_TEXT_EDIT_PRODUCT);
		clickToElement(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC, ShoppingCartPageUI.A_CONTAINS_TEXT_EDIT_PRODUCT);
	}

	public void clickToRemoveCheckbox() {
		waitForElementVisible(ShoppingCartPageUI.REMOVE_PRODUCT_CHECKBOX);
		checkToCheckbox(ShoppingCartPageUI.REMOVE_PRODUCT_CHECKBOX);
	}
	
	public void clickToUpdateShoppingCartButton() {
		waitForElementClickable(AbstactPageUI.INPUT_NAME_DYNAMIC, ShoppingCartPageUI.INPUT_NAME_UPDATE_SHOPPING_CART_BUTTON);
		clickToElement(AbstactPageUI.INPUT_NAME_DYNAMIC, ShoppingCartPageUI.INPUT_NAME_UPDATE_SHOPPING_CART_BUTTON);
	}
	
	public String getNoDataMessage() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC, AbstactPageUI.DIV_CLASS_NO_DATA_MESSAGE);
		return getTextElement(AbstactPageUI.DIV_CLASS_DYNAMIC, AbstactPageUI.DIV_CLASS_NO_DATA_MESSAGE);
	}
	
	public boolean isProductNotDisplayed() {
		return elementIsDisplayed(AbstactPageUI.A_CLASS_DYNAMIC, ShoppingCartPageUI.A_CLASS_SHOPPING_CART_PAGE_PRODUCT_NAME);
	}
	
	public void selectCheckOutCountryFromDropdown(String itemVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC, ShoppingCartPageUI.SELECT_ID_COUNTRY_DROPDOWN);
		selectItemInDropdown(itemVal, AbstactPageUI.SELECT_ID_DYNAMIC, ShoppingCartPageUI.SELECT_ID_COUNTRY_DROPDOWN);
	}
	
	public void inputToZipPortalCodeTextBox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC, ShoppingCartPageUI.INPUT_ID_ZIP_PORTAL_CODE_TEXTBOX);
		sendkeysToElement(keyVal, AbstactPageUI.INPUT_ID_DYNAMIC, ShoppingCartPageUI.INPUT_ID_ZIP_PORTAL_CODE_TEXTBOX);
	}
	
	public void clickToTermOfServiceCheckbox() {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,ShoppingCartPageUI.INPUT_ID_TERM_OF_SERVICE_CHECKBOX);
		checkToCheckbox(AbstactPageUI.INPUT_ID_DYNAMIC,ShoppingCartPageUI.INPUT_ID_TERM_OF_SERVICE_CHECKBOX);
	}
	
	public String getCheckOutTotalOrderValue() {
		waitForElementVisible(ShoppingCartPageUI.SHOPPING_CART_CHECK_OUT_ORDER_TOTAL);
		return getTextElement(ShoppingCartPageUI.SHOPPING_CART_CHECK_OUT_ORDER_TOTAL);
	}
	
	public void clickToCheckOutButton() {
		waitForElementClickable(ShoppingCartPageUI.SHOPPING_CART_CHECK_OUT_BUTTON);
		clickToElement(ShoppingCartPageUI.SHOPPING_CART_CHECK_OUT_BUTTON);
	}
	
	public boolean isBillingAddressFormDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_ID_DYNAMIC, ShoppingCartPageUI.DIV_ID_BILLING_ADDRESS_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_ID_DYNAMIC, ShoppingCartPageUI.DIV_ID_BILLING_ADDRESS_FORM);
	}
	
	public void unCheckToShippingSameAddressCheckBox() {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC, ShoppingCartPageUI.INPUT_ID_SHIPPING_SAME_ADDRESS_CHECKBOX);
		unCheckToCheckbox(AbstactPageUI.INPUT_ID_DYNAMIC, ShoppingCartPageUI.INPUT_ID_SHIPPING_SAME_ADDRESS_CHECKBOX);
	}
	
	public void selectCheckOutBillingAddressFromDropdown(String itemVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC, ShoppingCartPageUI.SELECET_ID_BILLING_ADDRESS_DROPDOWN);
		selectItemInDropdown(itemVal, AbstactPageUI.SELECT_ID_DYNAMIC, ShoppingCartPageUI.SELECET_ID_BILLING_ADDRESS_DROPDOWN);
	}
	
	public boolean isCheckOutEditAddressFormDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC, ShoppingCartPageUI.DIV_CLASS_CHECK_OUT_EDIT_ADDRES_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC, ShoppingCartPageUI.DIV_CLASS_CHECK_OUT_EDIT_ADDRES_FORM);
	}
	
	public void inputToCheckOutBillingAddessTextBoxByValue(String keyVal, String locatorName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC, locatorName);
		sendkeysToElement(keyVal, AbstactPageUI.INPUT_ID_DYNAMIC, locatorName);
	}
	
	public void selectCheckOutBillingCountryFromDropdown(String itemVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC, ShoppingCartPageUI.SELECT_ID_CHECK_OUT_BILLING_COUNTRY_DROPDOWN);
		selectItemInDropdown(itemVal, AbstactPageUI.SELECT_ID_DYNAMIC, ShoppingCartPageUI.SELECT_ID_CHECK_OUT_BILLING_COUNTRY_DROPDOWN);
	}
	
	public void clickToBillingAddressContinueButton() {
		waitForElementClickable(ShoppingCartPageUI.CHECK_OUT_BILLING_ADDRESS_CONTINUE_BUTTON);
		clickToElement(ShoppingCartPageUI.CHECK_OUT_BILLING_ADDRESS_CONTINUE_BUTTON);
	}
	
	public void selectCheckOutShippingAddressFromDropdown(String itemVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC, ShoppingCartPageUI.SELECET_ID_SHIPPING_ADDRESS_DROPDOWN);
		selectItemInDropdown(itemVal, AbstactPageUI.SELECT_ID_DYNAMIC, ShoppingCartPageUI.SELECET_ID_SHIPPING_ADDRESS_DROPDOWN);
	}
	
	public void inputToCheckOutShippingAddessTextBoxByValue(String keyVal, String locatorName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC, locatorName);
		sendkeysToElement(keyVal, AbstactPageUI.INPUT_ID_DYNAMIC, locatorName);
	}
	
	public void selectCheckOutShipplingCountryFromDropdown(String itemVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC, ShoppingCartPageUI.SELECT_ID_CHECK_OUT_SHIPPING_COUNTRY_DROPDOWN);
		selectItemInDropdown(itemVal, AbstactPageUI.SELECT_ID_DYNAMIC, ShoppingCartPageUI.SELECT_ID_CHECK_OUT_SHIPPING_COUNTRY_DROPDOWN);
	}
	
	public void clickToShippingAddressContinueButton() {
		waitForElementClickable(ShoppingCartPageUI.CHECK_OUT_SHIPPING_ADDRESS_CONTINUE_BUTTON);
		clickToElement(ShoppingCartPageUI.CHECK_OUT_SHIPPING_ADDRESS_CONTINUE_BUTTON);
	}
	
	public boolean isCheckoutShippingMethodFormDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_ID_DYNAMIC, ShoppingCartPageUI.DIV_ID_CHECKOUT_SHIPPING_METHOD_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_ID_DYNAMIC, ShoppingCartPageUI.DIV_ID_CHECKOUT_SHIPPING_METHOD_FORM);
	}
	
	public void clickToCheckOutShippingMethodNextDayAirRadioButton() {
		waitForElementClickable(ShoppingCartPageUI.CHECK_OUT_SHIPPING_METHOD_NEXT_DAY_AIR_RADIO_BUTTON);
		clickToElement(ShoppingCartPageUI.CHECK_OUT_SHIPPING_METHOD_NEXT_DAY_AIR_RADIO_BUTTON);
	}
	
	public void clickToCheckoutShippingMethodContinueButton() {
		waitForElementClickable(AbstactPageUI.INPUT_CLASS_DYNAMIC,ShoppingCartPageUI.INPUT_CLASS_CHECK_OUT_SHIPPING_METHOD_CONTINUE_BUTTON);
		clickToElement(AbstactPageUI.INPUT_CLASS_DYNAMIC,ShoppingCartPageUI.INPUT_CLASS_CHECK_OUT_SHIPPING_METHOD_CONTINUE_BUTTON);
	}

	public boolean isCheckoutPaymentMethodFormDisplayed() {
		waitForElementVisible(ShoppingCartPageUI.CHECK_OUT_PAYMENT_METHOD_FORM);
		return elementIsDisplayed(ShoppingCartPageUI.CHECK_OUT_PAYMENT_METHOD_FORM);
	}
	
	public void clickToCheckOutPaymentMethodCreditCardRadioButton() {
		waitForElementClickable(ShoppingCartPageUI.CHECK_OUT_PAYMENT_METHOD_CREDIT_CARD_RADIO_BUTTON);
		clickToElement(ShoppingCartPageUI.CHECK_OUT_PAYMENT_METHOD_CREDIT_CARD_RADIO_BUTTON);
	}
	
	public boolean isCheckoutSectionPaymentInfoDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_SECTION_PAYMENT_INFO);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_SECTION_PAYMENT_INFO);
	}
	
	public void inputToCheckoutSectionPaymentCardHolderTextBox(String textVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SECTION_PAYMENT_CARD_HOLDER_TEXT_BOX);
		sendkeysToElement(textVal, AbstactPageUI.INPUT_ID_DYNAMIC, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SECTION_PAYMENT_CARD_HOLDER_TEXT_BOX);
	}
	
	public void inputToCheckoutSectionPaymentCardNumberTextBox(String textVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SECTION_PAYMENT_CARD_NUMBER_TEXT_BOX);
		sendkeysToElement(textVal, AbstactPageUI.INPUT_ID_DYNAMIC, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SECTION_PAYMENT_CARD_NUMBER_TEXT_BOX);
	}
	
	public void selectToCheckoutSectionPaymentExpireMonthDropdown(String textVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC, ShoppingCartPageUI.SELECT_ID_CHECK_OUT_SECTION_PAYMENT_EXPIRE_MONTH_DROPDOWN);
		selectItemInDropdown(textVal, AbstactPageUI.SELECT_ID_DYNAMIC, ShoppingCartPageUI.SELECT_ID_CHECK_OUT_SECTION_PAYMENT_EXPIRE_MONTH_DROPDOWN);
	}
	
	public void selectToCheckoutSectionPaymentExpireYearDropdown(String textVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC, ShoppingCartPageUI.SELECT_ID_CHECK_OUT_SECTION_PAYMENT_EXPIRE_YEAR_DROPDOWN);
		selectItemInDropdown(textVal, AbstactPageUI.SELECT_ID_DYNAMIC, ShoppingCartPageUI.SELECT_ID_CHECK_OUT_SECTION_PAYMENT_EXPIRE_YEAR_DROPDOWN);
	}
	
	public void inputToCheckoutSectionPaymentCardCodeTextBox(String textVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SECTION_PAYMENT_CARD_CODE_TEXT_BOX);
		sendkeysToElement(textVal, AbstactPageUI.INPUT_ID_DYNAMIC, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SECTION_PAYMENT_CARD_CODE_TEXT_BOX);
	}
	
	public void clickToCheckoutPaymentMethodContinueButton() {
		waitForElementClickable(AbstactPageUI.INPUT_CLASS_DYNAMIC,ShoppingCartPageUI.INPUT_CLASS_CHECK_OUT_PAYMENT_METHOD_CONTINUE_BUTTON);
		clickToElement(AbstactPageUI.INPUT_CLASS_DYNAMIC,ShoppingCartPageUI.INPUT_CLASS_CHECK_OUT_PAYMENT_METHOD_CONTINUE_BUTTON);
	}
	
	public boolean isSectionPaymentInfoFormDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_CHECK_OUT_SECTION_PAYMENT_INFO_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_CHECK_OUT_SECTION_PAYMENT_INFO_FORM);
	}
	
	public String getSectionPaymentInfoValue() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_CHECK_OUT_SECTION_PAYMENT_INFO_FORM);
		return getTextElement(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_CHECK_OUT_SECTION_PAYMENT_INFO_FORM);
	}
	
	public void clickToSectionPaymentInfoContinueButton() {
		waitForElementClickable(AbstactPageUI.INPUT_CLASS_DYNAMIC,ShoppingCartPageUI.INPUT_CLASS_CHECK_OUT_SECTION_PAYMENT_INFO_CONTINUE_BUTTON);
		clickToElement(AbstactPageUI.INPUT_CLASS_DYNAMIC,ShoppingCartPageUI.INPUT_CLASS_CHECK_OUT_SECTION_PAYMENT_INFO_CONTINUE_BUTTON);
	}
	
	public boolean isConfirmOrderFormDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_ID_DYNAMIC,ShoppingCartPageUI.DIV_ID_CHECKOUT_CONFIRM_ORDER_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_ID_DYNAMIC,ShoppingCartPageUI.DIV_ID_CHECKOUT_CONFIRM_ORDER_FORM);
	}
	
	public boolean isConfirmOrderBillingAddressFormDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_FORM);
	}
	
	public String getConfimOrderBillingAddressTitle() {
		waitForElementVisible(ShoppingCartPageUI.CONFIRM_ORDER_BILLING_ADDRESS_TITLE);
		return getTextElement(ShoppingCartPageUI.CONFIRM_ORDER_BILLING_ADDRESS_TITLE);
	}
	
	public String getConfimOrderBillingAddressValue(String locatorName) {
		waitForElementVisible(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_DYNAMIC,locatorName);
		return getTextElement(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_DYNAMIC,locatorName);
	}
	
	public boolean isConfirmOrderShippingAddressFormDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_FORM);
	}
	
	public String getConfimOrderShippingAddressTitle() {
		waitForElementVisible(ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_ADDRESS_TITLE);
		return getTextElement(ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_ADDRESS_TITLE);
	}
	
	public String getConfimOrderShippingAddressValue(String locatorName) {
		waitForElementVisible(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_DYNAMIC,locatorName);
		return getTextElement(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_DYNAMIC,locatorName);
	}
	
	public boolean isConfirmOrderPaymentMethodFormDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_CONFIRM_ORDER_PAYMENT_METHOD_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_CONFIRM_ORDER_PAYMENT_METHOD_FORM);
	}
	
	public String getConfimOrderPaymentMethodTitle() {
		waitForElementVisible(ShoppingCartPageUI.CONFIRM_ORDER_PAYMENT_METHOD_TITLE);
		return getTextElement(ShoppingCartPageUI.CONFIRM_ORDER_PAYMENT_METHOD_TITLE);
	}
	
	public String getConfimOrderPaymentMethodValue() {
		waitForElementVisible(ShoppingCartPageUI.CONFIRM_ORDER_PAYMENT_METHOD_INFO);
		return getTextElement(ShoppingCartPageUI.CONFIRM_ORDER_PAYMENT_METHOD_INFO);
	}
	
	public boolean isConfirmOrderShippingMethodFormDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_CONFIRM_ORDER_SHIPPING_METHOD_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_CONFIRM_ORDER_SHIPPING_METHOD_FORM);
	}
	
	public String getConfimOrderShippingMethodTitle() {
		waitForElementVisible(ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_METHOD_TITLE);
		return getTextElement(ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_METHOD_TITLE);
	}
	
	public String getConfimOrderShippingMethodValue() {
		waitForElementVisible(ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_METHOD_INFO);
		return getTextElement(ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_METHOD_INFO);
	}
	
	public boolean isConfirmOrderShoppingCartFormDisplayed() {
		waitForElementVisible(ShoppingCartPageUI.CONFIRM_ORDER_SHOPPING_CART_FORM);
		return elementIsDisplayed(ShoppingCartPageUI.CONFIRM_ORDER_SHOPPING_CART_FORM);
	}
	
	public String getConfimOrderShoppingCartProductSkuValue() {
		waitForElementVisible(AbstactPageUI.SPAN_CLASS_DYNAMIC,ShoppingCartPageUI.SPAN_CLASS_PRODUCT_SKU_TEXT);
		return getTextElement(AbstactPageUI.SPAN_CLASS_DYNAMIC,ShoppingCartPageUI.SPAN_CLASS_PRODUCT_SKU_TEXT);
	}
	
	public String getConfimOrderShoppingCartProductNameValue() {
		waitForElementVisible(AbstactPageUI.A_CLASS_DYNAMIC,ShoppingCartPageUI.A_CLASS_SHOPPING_CART_PAGE_PRODUCT_NAME);
		return getTextElement(AbstactPageUI.A_CLASS_DYNAMIC,ShoppingCartPageUI.A_CLASS_SHOPPING_CART_PAGE_PRODUCT_NAME);
	}
	
	public String getConfimOrderShoppingCartProductUnitPriceValue() {
		waitForElementVisible(AbstactPageUI.SPAN_CLASS_DYNAMIC,ShoppingCartPageUI.SPAN_CLASS_PRODUCT_UNIT_PRICE_TEXT);
		return getTextElement(AbstactPageUI.SPAN_CLASS_DYNAMIC,ShoppingCartPageUI.SPAN_CLASS_PRODUCT_UNIT_PRICE_TEXT);
	}
	
	public String getConfimOrderShoppingCartProductQuantityValue() {
		waitForElementVisible(AbstactPageUI.SPAN_CLASS_DYNAMIC,ShoppingCartPageUI.SPAN_CLASS_PRODUCT_QUANTITY_TEXT);
		return getTextElement(AbstactPageUI.SPAN_CLASS_DYNAMIC,ShoppingCartPageUI.SPAN_CLASS_PRODUCT_QUANTITY_TEXT);
	}
	
	public String getConfimOrderShoppingCartProductTotalPriceValue() {
		waitForElementVisible(AbstactPageUI.SPAN_CLASS_DYNAMIC,ShoppingCartPageUI.SPAN_CLASS_PRODUCT_SUB_TOTAL_TEXT);
		return getTextElement(AbstactPageUI.SPAN_CLASS_DYNAMIC,ShoppingCartPageUI.SPAN_CLASS_PRODUCT_SUB_TOTAL_TEXT);
	}
	
	public String getConfimOrderShoppingCartOptionsSubTotalValue() {
		waitForElementVisible(ShoppingCartPageUI.CONFIRM_ORDER_SUB_TOTAL_TEXT);
		return getTextElement(ShoppingCartPageUI.CONFIRM_ORDER_SUB_TOTAL_TEXT);
	}
	
	public String getConfimOrderShoppingCartOptionsShippingCostValue() {
		waitForElementVisible(ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_COST_TEXT);
		return getTextElement(ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_COST_TEXT);
	}
	
	public String getConfimOrderShoppingCartOptionsTaxCostValue() {
		waitForElementVisible(ShoppingCartPageUI.CONFIRM_ORDER_TAX_TEXT);
		return getTextElement(ShoppingCartPageUI.CONFIRM_ORDER_TAX_TEXT);
	}
	
	public String getConfimOrderShoppingCartOptionsTotalCostValue() {
		waitForElementVisible(ShoppingCartPageUI.CONFIRM_ORDER_TOTAL_COST_TEXT);
		return getTextElement(ShoppingCartPageUI.CONFIRM_ORDER_TOTAL_COST_TEXT);
	}
	
	public void clickToConfirmOrderConfirmButton() {
		waitForElementClickable(AbstactPageUI.INPUT_CLASS_DYNAMIC, ShoppingCartPageUI.INPUT_CLASS_CONFIRM_ORDER_INFO_CONFIRM_BUTTON);
		clickToElement(AbstactPageUI.INPUT_CLASS_DYNAMIC, ShoppingCartPageUI.INPUT_CLASS_CONFIRM_ORDER_INFO_CONFIRM_BUTTON);
	}
	
	public boolean isCheckOutCompleteFormDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_CHECK_OUT_COMPLETE_FORM);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_CHECK_OUT_COMPLETE_FORM);
	}
	
	public String getCheckOutCompleteFormTile() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,AbstactPageUI.DIV_CLASS_PAGE_TITLE);
		return getTextElement(AbstactPageUI.DIV_CLASS_DYNAMIC,AbstactPageUI.DIV_CLASS_PAGE_TITLE);
	}
	
	public String getCheckOutCompleteFormInfoValue() {
		waitForElementVisible(ShoppingCartPageUI.CHECK_OUT_COMPLETE_FORM_INFO);
		return getTextElement(ShoppingCartPageUI.CHECK_OUT_COMPLETE_FORM_INFO);
	}
	
	public String getOrderNumberTextValue() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_ORDER_NUMBER);
		return getCapitalizeTextElement(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_ORDER_NUMBER);
	}
	
	public String getOrderNumberValue() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_ORDER_NUMBER);
		return getNumberFromElementText(AbstactPageUI.DIV_CLASS_DYNAMIC,ShoppingCartPageUI.DIV_CLASS_ORDER_NUMBER);
	}
}
