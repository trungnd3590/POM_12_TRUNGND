package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstactPageUI;
import pageUIs.AdminPageUI;

public class AdminPageObject extends AbstractPage{

	public AdminPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isAdminLogoutLinkDisplayed() {
		waitForElementVisible(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC, AdminPageUI.A_CONTAINS_TEXT_ADMIN_LOGOUT_LINK);
		return elementIsDisplayed(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC, AdminPageUI.A_CONTAINS_TEXT_ADMIN_LOGOUT_LINK);
	}
	
	public void clickToSidebarCatalogMenu() {
		waitForElementClickable(AdminPageUI.SIDEBAR_MENU_CATALOG_MENU);
		clickToElement(AdminPageUI.SIDEBAR_MENU_CATALOG_MENU);
	}
	
	public void clickToSidebarCustomersMenu() {
		waitForElementClickable(AdminPageUI.SIDEBAR_MENU_CUSTOMER_MENU);
		clickToElement(AdminPageUI.SIDEBAR_MENU_CUSTOMER_MENU);
	}
	
	public void clickToSidebarProductsSubMenu() {
		waitForElementClickable(AdminPageUI.SIDEBAR_MENU_PRODUCTS_SUB_MENU);
		clickToElement(AdminPageUI.SIDEBAR_MENU_PRODUCTS_SUB_MENU);
	}
	
	public void clickToSidebarCustomersSubMenu() {
		waitForElementClickable(AdminPageUI.SIDEBAR_MENU_CUSTOMER_SUB_MENU);
		clickToElement(AdminPageUI.SIDEBAR_MENU_CUSTOMER_SUB_MENU);
	}

	public void inputToProductsFormSearchProductNameTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_PRODUCTS_FORM_SEARCH_PRODUCTNAME_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_PRODUCTS_FORM_SEARCH_PRODUCTNAME_TEXTBOX);
	}
	
	public void inputToProductsFormSearchGoDirectlyToSKUTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_PRODUCTS_FORM_SEARCH_GO_DIRECTLY_TO_SKU_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_PRODUCTS_FORM_SEARCH_GO_DIRECTLY_TO_SKU_TEXTBOX);
	}
	
	public void clickToProductsFormSearchButton() {
		waitForElementClickable(AdminPageUI.PRODUCTS_FORM_SEARCH_BUTTON);
		clickToElement(AdminPageUI.PRODUCTS_FORM_SEARCH_BUTTON);
	}
	
	public void clickToProductsFormGoDirectlyToSKUButton() {
		waitForElementClickable(AdminPageUI.PRODUCTS_FORM_SEARCH_GO_DIRECTLY_TO_SKU_BUTTON);
		clickToElement(AdminPageUI.PRODUCTS_FORM_SEARCH_GO_DIRECTLY_TO_SKU_BUTTON);
	}
	
	public String getProductsFormSearchResultData(String textVal) {
		waitForElementVisible(AdminPageUI.TD_CONTAINS_TEXT_PRODUCTS_FORM_SEARCH_RESULT_TEXT, textVal);
		return getTextElement(AdminPageUI.TD_CONTAINS_TEXT_PRODUCTS_FORM_SEARCH_RESULT_TEXT, textVal);
	}
	
	public boolean isProductsFormPublishedTrueIconDisplayed() {
		waitForElementVisible(AdminPageUI.PRODUCTS_FORM_PUBLISHED_TRUE_ICON);
		return elementIsDisplayed(AdminPageUI.PRODUCTS_FORM_PUBLISHED_TRUE_ICON);
	}
	
	public void selectFromCategoryDropdown(String itemVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_PRODUCTS_FORM_SEARCH_CATEGORY_DROPDOWN);
		selectItemInDropdown(itemVal,AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_PRODUCTS_FORM_SEARCH_CATEGORY_DROPDOWN);
	}
	
	public void selectFromManufacturerDropdown(String itemVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_PRODUCTS_FORM_SEARCH_MANUFACTURER_DROPDOWN);
		selectItemInDropdown(itemVal,AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_PRODUCTS_FORM_SEARCH_MANUFACTURER_DROPDOWN);
	}
	
	public void unCheckFromSubCategoryCheckbox() {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC, AdminPageUI.INPUT_ID_PRODUCTS_FORM_SEARCH_SUB_CATEGORY_CHECKBOX);
		unCheckToCheckbox(AbstactPageUI.INPUT_ID_DYNAMIC, AdminPageUI.INPUT_ID_PRODUCTS_FORM_SEARCH_SUB_CATEGORY_CHECKBOX);
	}
	
	public void checkFromSubCategoryCheckbox() {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC, AdminPageUI.INPUT_ID_PRODUCTS_FORM_SEARCH_SUB_CATEGORY_CHECKBOX);
		checkToCheckbox(AbstactPageUI.INPUT_ID_DYNAMIC, AdminPageUI.INPUT_ID_PRODUCTS_FORM_SEARCH_SUB_CATEGORY_CHECKBOX);
	}
	
	public String getProductsFormDataEmptyMessage() {
		waitForElementVisible(AdminPageUI.PRODUCTS_FORM_DATA_TABLE_EMPTY_TEXT);
		return getTextElement(AdminPageUI.PRODUCTS_FORM_DATA_TABLE_EMPTY_TEXT);
	}
	
	public int countNumberOfSearchResult() {
		waitForAllElementsVisible(AdminPageUI.PRODUCTS_FORM_SEARCH_RESULT_ROWS);
		return  countElementNumber(AdminPageUI.PRODUCTS_FORM_SEARCH_RESULT_ROWS);
	}
	
	public boolean getAdminFormTitleContainsValue(String textVal) {
		waitForElementVisible(AbstactPageUI.ADMIN_FORM_TITLE);
		return compareStringFromElementText(textVal,AbstactPageUI.ADMIN_FORM_TITLE);
	}
	
	public String getProductDetailsFormProductNameValue(String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_PRODUCT_DETAILS_FORM_PROUCTNAME_TEXTBOX);
		return getAttributeValue(attributeName, AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_PRODUCT_DETAILS_FORM_PROUCTNAME_TEXTBOX);
	}
	
	public void clickToCustomersFormAddNewCustomerButton() {
		waitForElementClickable(AbstactPageUI.A_CLASS_DYNAMIC,AdminPageUI.A_CLASS_CUSTOMERS_FORM_ADD_NEW_BUTTON);
		clickToElement(AbstactPageUI.A_CLASS_DYNAMIC,AdminPageUI.A_CLASS_CUSTOMERS_FORM_ADD_NEW_BUTTON);
	}
	
	public void inputToAddNewCustomerFormEmailTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_EMAIL_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_EMAIL_TEXTBOX);
	}
	
	public void inputToAddNewCustomerFormPasswordTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_PASSWORD_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_PASSWORD_TEXTBOX);
	}
	
	public void inputToAddNewCustomerFormFirstnameTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_FIRSTNAME_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_FIRSTNAME_TEXTBOX);
	}
	
	public void inputToAddNewCustomerFormLastnameTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_LASTNAME_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_LASTNAME_TEXTBOX);
	}
	
	public void clickToAddNewCustomerFormGenderMaleRadiobutton() {
		waitForElementClickable(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_GENDER_MALE_RADIOBUTTON);
		clickToElement(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_GENDER_MALE_RADIOBUTTON);
	}
	
	public void inputToAddNewCustomerFormDateOfBirthTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_DATEOFBIRTH_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_DATEOFBIRTH_TEXTBOX);
	}
	
	public void inputToAddNewCustomerFormCompanynameTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_COMPANYNAME_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_COMPANYNAME_TEXTBOX);
	}
	
	public void inputToAddNewCustomerFormCustomerRoleDropdown(String itemVal) {
		waitForElementClickable(AdminPageUI.ADD_NEW_CUSTOMER_CUSTOMER_ROLES_PARENT_DROPDOWN);
		if(elementIsDisplayed(AbstactPageUI.SPAN_CLASS_DYNAMIC, AdminPageUI.SPAN_CLASS_ADD_NEW_CUSTOMER_FORM_CUSTOMER_ROLE_DELETE_BUTTON) == true) {
			clickToElement(AbstactPageUI.SPAN_CLASS_DYNAMIC, AdminPageUI.SPAN_CLASS_ADD_NEW_CUSTOMER_FORM_CUSTOMER_ROLE_DELETE_BUTTON);
		}
//		clickToElement(AdminPageUI.ADD_NEW_CUSTOMER_CUSTOMER_ROLES_PARENT_DROPDOWN);
//		waitForElementVisible(AdminPageUI.ADD_NEW_CUSTOMER_CUSTOMER_ROLES_ALL_ITEMS_DROPDOWN);
//		clickToElement(AdminPageUI.ADD_NEW_CUSTOMER_CUSTOMER_ROLES_GUESTS_ITEM_DROPDOWN,itemVal);
		selectItemInCustomDropdown(itemVal, AdminPageUI.ADD_NEW_CUSTOMER_CUSTOMER_ROLES_PARENT_DROPDOWN, AdminPageUI.ADD_NEW_CUSTOMER_CUSTOMER_ROLES_ALL_ITEMS_DROPDOWN);

	}
	
	public void removeDataFromCustomerFormCustomerRoleDropdown() {
		waitForElementClickable(AdminPageUI.ADD_NEW_CUSTOMER_CUSTOMER_ROLES_PARENT_DROPDOWN);
		if(elementIsDisplayed(AbstactPageUI.SPAN_CLASS_DYNAMIC, AdminPageUI.SPAN_CLASS_ADD_NEW_CUSTOMER_FORM_CUSTOMER_ROLE_DELETE_BUTTON) == true) {
			clickToElement(AbstactPageUI.SPAN_CLASS_DYNAMIC, AdminPageUI.SPAN_CLASS_ADD_NEW_CUSTOMER_FORM_CUSTOMER_ROLE_DELETE_BUTTON);
		}
	}
	
	public void selectFromAddNewCustomerFormVendorDropdown(String itemVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_ADD_NEW_CUSTOMER_FORM_MANAGER_OF_VENDOR_DROPDOWN);
		selectItemInDropdown(itemVal,AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_ADD_NEW_CUSTOMER_FORM_MANAGER_OF_VENDOR_DROPDOWN);
	}
	
	public void inputToAddNewCustomerFormCommentTextarea(String keyVal) {
		waitForElementVisible(AdminPageUI.ADD_NEW_CUSTOMER_FORM_ADMIN_COMMENT_TEXTAREA);
		sendkeysToElement(keyVal,AdminPageUI.ADD_NEW_CUSTOMER_FORM_ADMIN_COMMENT_TEXTAREA);
	}
	
	public void clickToAddNewCustomerFormSaveAndContinueButton() {
		waitForElementClickable(AdminPageUI.ADD_NEW_CUSTOMER_FORM_SAVE_AND_CONTINUE_BUTTON);
		clickToElement(AdminPageUI.ADD_NEW_CUSTOMER_FORM_SAVE_AND_CONTINUE_BUTTON);
	}
	
	public boolean isAddNewCustomerFormSuccessMessageDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,AdminPageUI.DIV_CLASS_ADD_NEW_CUSTOMER_SUCCESS_MESSAGE);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,AdminPageUI.DIV_CLASS_ADD_NEW_CUSTOMER_SUCCESS_MESSAGE);
	}
	
	public String getAddNewCustomerFormEmailTextboxValue(String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_EMAIL_TEXTBOX);
		return getAttributeValue(attributeName, AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_EMAIL_TEXTBOX);
	}
	
	public String getAddNewCustomerFormFirstnameTextboxValue(String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_FIRSTNAME_TEXTBOX);
		return getAttributeValue(attributeName, AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_FIRSTNAME_TEXTBOX);
	}
	
	public String getAddNewCustomerFormLastnameTextboxValue(String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_LASTNAME_TEXTBOX);
		return getAttributeValue(attributeName, AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_LASTNAME_TEXTBOX);
	}
	
	public boolean isAddNewCustomerFormGenderMaleisSelected() {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_GENDER_MALE_RADIOBUTTON);
		return elementIsSelected(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_GENDER_MALE_RADIOBUTTON);
	}
	
	public String getAddNewCustomerFormDateOfBirthTextboxValue(String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_DATEOFBIRTH_TEXTBOX);
		return getAttributeValue(attributeName, AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_DATEOFBIRTH_TEXTBOX);
	}
	
	public String getAddNewCustomerFormCompanynameTextboxValue(String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_COMPANYNAME_TEXTBOX);
		return getAttributeValue(attributeName, AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_COMPANYNAME_TEXTBOX);
	}
	
	public String getAddNewCustomerFormCustomerRolesDropdownValue(String itemVal) {
		waitForElementVisible(AdminPageUI.ADD_NEW_CUSTOMER_CUSTOMER_ROLES_PARENT_DROPDOWN_TEXT,itemVal);
		return getTextElement(AdminPageUI.ADD_NEW_CUSTOMER_CUSTOMER_ROLES_PARENT_DROPDOWN_TEXT,itemVal);
	}
	
	public String getAddNewCustomerFormActiveCheckboxValue(String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_ACTIVE_CHECKBOX);
		return getAttributeValue(attributeName, AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_ACTIVE_CHECKBOX);
	}
	
	public String getAddNewCustomerFormAdminCommentValue(String attributeName) {
		waitForElementVisible(AdminPageUI.ADD_NEW_CUSTOMER_FORM_ADMIN_COMMENT_TEXTAREA);
		return getAttributeValue(attributeName,AdminPageUI.ADD_NEW_CUSTOMER_FORM_ADMIN_COMMENT_TEXTAREA);
	}
	
	public void clickBackToPreviousFormButton() {
		waitForElementClickable(AdminPageUI.ADMIN_BACK_TO_PREVIOUS_FORM);
		clickToElement(AdminPageUI.ADMIN_BACK_TO_PREVIOUS_FORM);
	}
	
	public void clickToCustomersFormSearchButton() {
		waitForElementClickable(AdminPageUI.CUSTOMERS_FORM_SEARCH_BUTTON);
		clickToElement(AdminPageUI.CUSTOMERS_FORM_SEARCH_BUTTON);
	}
	
	public String getCustomersFormSearchResultData(String textVal) {
		waitForElementVisible(AdminPageUI.TD_CONTAINS_TEXT_PRODUCTS_FORM_SEARCH_RESULT_TEXT, textVal);
		return getTextElement(AdminPageUI.TD_CONTAINS_TEXT_PRODUCTS_FORM_SEARCH_RESULT_TEXT, textVal);
	}
	
	public boolean isCustomersFormActiveIconDisplayed(String value) {
		waitForElementVisible(AdminPageUI.CUSTOMERS_FORM_ACTIVE_TRUE_ICON,value);
		return elementIsDisplayed(AdminPageUI.CUSTOMERS_FORM_ACTIVE_TRUE_ICON,value);
	}
	
	public void inputToCustomerFormSearchEmailTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_CUSTOMER_FORM_SEARCH_EMAIL_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_CUSTOMER_FORM_SEARCH_EMAIL_TEXTBOX);
	}
	
	public void inputToCustomerFormSearchFirstnameTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_CUSTOMER_FORM_SEARCH_FIRSTNAME_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_CUSTOMER_FORM_SEARCH_FIRSTNAME_TEXTBOX);
	}
	
	public void inputToCustomerFormSearchLastnameTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_CUSTOMER_FORM_SEARCH_LASTNAME_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_CUSTOMER_FORM_SEARCH_LASTNAME_TEXTBOX);
	}
	
	public void inputToCustomerFormSearchCompanynameTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_COMPANYNAME_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_CUSTOMER_FORM_COMPANYNAME_TEXTBOX);
	}
	
	public void selectFromCustomerFormSearchMonthOfBirthDropdown(String itemVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_CUSTOMER_FORM_SEARCH_MONTH_OF_BIRTH_DROPDOWN);
		selectItemInDropdown(itemVal,AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_CUSTOMER_FORM_SEARCH_MONTH_OF_BIRTH_DROPDOWN);
	}
	
	public void selectFromCustomerFormSearchDayOfBirthDropdown(String itemVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_CUSTOMER_FORM_SEARCH_DAY_OF_BIRTH_DROPDOWN);
		selectItemInDropdown(itemVal,AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_CUSTOMER_FORM_SEARCH_DAY_OF_BIRTH_DROPDOWN);
	}
	
	public void clickToCustomerFormSelectedCustomerEditButton(String value) {
		waitForElementClickable(AdminPageUI.CUSTOMERS_FORM_EDIT_CUSTOMER_BUTTON, value);
		clickToElement(AdminPageUI.CUSTOMERS_FORM_EDIT_CUSTOMER_BUTTON, value);
	}
	
	public void clickToEditCustomerDetailFormAddressPanel() {
		waitForElementClickable(AdminPageUI.EDIT_CUSTOMER_DETAILS_FORM_ADDRESS_PANEL);
		clickToElement(AdminPageUI.EDIT_CUSTOMER_DETAILS_FORM_ADDRESS_PANEL);
	}
	
	public void clickToEditCustomerDetailFormAddNewAddressButton() {
		waitForElementClickable(AdminPageUI.EDIT_CUSTOMER_DETAILS_FORM_AĐD_NEW_ADDRESS_BUTTON);
		clickToElement(AdminPageUI.EDIT_CUSTOMER_DETAILS_FORM_AĐD_NEW_ADDRESS_BUTTON);
	}
	
	public void inputToAddNewAddressFormFirstnameTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_FIRSTNAME_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_FIRSTNAME_TEXTBOX);
	}
	
	public void inputToAddNewAddressFormLastnameTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_LASTNAME_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_LASTNAME_TEXTBOX);
	}
	
	public void inputToAddNewAddressFormLEmailTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_EMAIL_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_EMAIL_TEXTBOX);
	}
	
	public void inputToAddNewAddressFormCompanynameTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_COMPANYNAME_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_COMPANYNAME_TEXTBOX);
	}
	
	public void selectFromAddNewAddressFormCountryDropdown(String itemVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_ADD_NEW_ADDRESS_FORM_COUNTRY_DROPDOWN);
		selectItemInDropdown(itemVal,AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_ADD_NEW_ADDRESS_FORM_COUNTRY_DROPDOWN);
	}
	
	public void selectFromAddNewAddressFormStateDropdown(String itemVal) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_ADD_NEW_ADDRESS_FORM_STATE_DROPDOWN);
		selectItemInDropdown(itemVal,AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_ADD_NEW_ADDRESS_FORM_STATE_DROPDOWN);
	}
	
	public void inputToAddNewAddressFormCityTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_CITY_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_CITY_TEXTBOX);
	}
	
	public void inputToAddNewAddressFormAddress01Textbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_ADDRESS01_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_ADDRESS01_TEXTBOX);
	}
	
	public void inputToAddNewAddressFormAddress02Textbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_ADDRESS02_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_ADDRESS02_TEXTBOX);
	}
	
	public void inputToAddNewAddressFormZipCodeTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_ZIPCODE_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_ZIPCODE_TEXTBOX);
	}
	
	public void inputToAddNewAddressFormPhoneNumberTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_PHONENUMBER_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_PHONENUMBER_TEXTBOX);
	}
	
	public void inputToAddNewAddressFormFaxNumberTextbox(String keyVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_FAXNUMBER_TEXTBOX);
		sendkeysToElement(keyVal,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_FAXNUMBER_TEXTBOX);
	}
	
	public String getAddNewAddressFormFirstnameValue(String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_FIRSTNAME_TEXTBOX);
		return getAttributeValue(attributeName,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_FIRSTNAME_TEXTBOX);
	}
	
	public String getAddNewAddressFormLastnameValue(String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_LASTNAME_TEXTBOX);
		return getAttributeValue(attributeName,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_LASTNAME_TEXTBOX);
	}
	
	public String getAddNewAddressFormEmailValue(String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_EMAIL_TEXTBOX);
		return getAttributeValue(attributeName,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_EMAIL_TEXTBOX);
	}
	
	public String getAddNewAddressFormCompanyValue(String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_COMPANYNAME_TEXTBOX);
		return getAttributeValue(attributeName,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_COMPANYNAME_TEXTBOX);
	}
	
	public String getAddNewAddressFormCountryDropdownValue() {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_ADD_NEW_ADDRESS_FORM_COUNTRY_DROPDOWN);
		return getItemValueInDropdown(AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_ADD_NEW_ADDRESS_FORM_COUNTRY_DROPDOWN);
	}
	
	public String getAddNewAddressFormStateDropdownValue( ) {
		waitForElementVisible(AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_ADD_NEW_ADDRESS_FORM_STATE_DROPDOWN);
		return getItemValueInDropdown(AbstactPageUI.SELECT_ID_DYNAMIC, AdminPageUI.SELECT_ID_ADD_NEW_ADDRESS_FORM_STATE_DROPDOWN);
	}
	
	public String getAddNewAddressFormCityValue(String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_CITY_TEXTBOX);
		return getAttributeValue(attributeName,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_CITY_TEXTBOX);
	}
	
	public String getAddNewAddressFormAddress01Value(String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_ADDRESS01_TEXTBOX);
		return getAttributeValue(attributeName,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_ADDRESS01_TEXTBOX);
	}
	
	public String getAddNewAddressFormAddress02Value(String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_ADDRESS02_TEXTBOX);
		return getAttributeValue(attributeName,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_ADDRESS02_TEXTBOX);
	}
	
	public String getAddNewAddressFormZipCodeValue(String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_ZIPCODE_TEXTBOX);
		return getAttributeValue(attributeName,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_ZIPCODE_TEXTBOX);
	}
	
	public String getAddNewAddressFormPhoneNumberValue(String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_PHONENUMBER_TEXTBOX);
		return getAttributeValue(attributeName,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_PHONENUMBER_TEXTBOX);
	}
	
	public String getAddNewAddressFormFaxNumberValue(String attributeName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_FAXNUMBER_TEXTBOX);
		return getAttributeValue(attributeName,AbstactPageUI.INPUT_ID_DYNAMIC,AdminPageUI.INPUT_ID_ADD_NEW_ADDRESS_FORM_FAXNUMBER_TEXTBOX);
	}
	
	public String getEditCustomerDetailFormAddressData(String textVal) {
		waitForElementVisible(AdminPageUI.TD_CONTAINS_TEXT_PRODUCTS_FORM_SEARCH_RESULT_TEXT, textVal);
		return getTextElement(AdminPageUI.TD_CONTAINS_TEXT_PRODUCTS_FORM_SEARCH_RESULT_TEXT, textVal);
	}
}
