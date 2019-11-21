package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.MyAccountPageUI;

public class MyAccountPageObject extends AbstractPage {
	
	public MyAccountPageObject(WebDriver driver) {
		super(driver);
	}
	
	public boolean isMyAccountPageDisplayed() {
		waitForElementVisible(MyAccountPageUI.MY_ACCOUNT_PAGE_FORM);
		return elementIsDisplayed(MyAccountPageUI.MY_ACCOUNT_PAGE_FORM);
	}

	public String isGenderMaleButtonSelected(String attributeName) {
		waitForElementVisible(MyAccountPageUI.GENDER_MALE_RADIOBUTTON);
		return getAttributeValue(MyAccountPageUI.GENDER_MALE_RADIOBUTTON,attributeName);
	}
	
	public String isGenderFemaleButtonSelected(String attributeName) {
		waitForElementVisible(MyAccountPageUI.GENDER_FEMALE_RADIOBUTTON);
		return getAttributeValue(MyAccountPageUI.GENDER_FEMALE_RADIOBUTTON,attributeName);
	}
	
	public String getFirstNameData(String attributeName) {
		waitForElementVisible(MyAccountPageUI.FIRSTNAME_TEXTBOX);
		return getAttributeValue(MyAccountPageUI.FIRSTNAME_TEXTBOX, attributeName);
	}

	public String getLastNameData(String attributeName) {
		waitForElementVisible(MyAccountPageUI.LASTNAME_TEXTBOX);
		return getAttributeValue(MyAccountPageUI.LASTNAME_TEXTBOX,attributeName);
	}
	
	public String getDateOfBirthData() {
		waitForElementVisible(MyAccountPageUI.DATEOFBIRTH_DROPDOWN);
		return getItemValueInDropdown(MyAccountPageUI.DATEOFBIRTH_DROPDOWN);
	}
	
	public String getDateOfMonthData() {
		waitForElementVisible(MyAccountPageUI.DATEOFMONTH_DROPDOWN);
		return getItemValueInDropdown(MyAccountPageUI.DATEOFMONTH_DROPDOWN);
	}
	
	public String getDateOfYearData() {
		waitForElementVisible(MyAccountPageUI.DATEOFYEAR_DROPDOWN);
		return getItemValueInDropdown(MyAccountPageUI.DATEOFYEAR_DROPDOWN);
	}
	
	public String getEmailData(String attributeName) {
		waitForElementVisible(MyAccountPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(MyAccountPageUI.EMAIL_TEXTBOX,attributeName);
	}
	
	public String getCompanyNameData(String attributeName) {
		waitForElementVisible(MyAccountPageUI.COMPANYNAME_TEXTBOX);
		return getAttributeValue(MyAccountPageUI.COMPANYNAME_TEXTBOX,attributeName);
	}
	
	public void clickToFemaleRadioButton() {
		waitForElementVisible(MyAccountPageUI.GENDER_FEMALE_RADIOBUTTON);
		clickToElement(MyAccountPageUI.GENDER_FEMALE_RADIOBUTTON);
	}

	public void inputToFirstnameTextbox(String fistNameVal) {
		waitForElementVisible(MyAccountPageUI.FIRSTNAME_TEXTBOX);
		sendkeysToElement(MyAccountPageUI.FIRSTNAME_TEXTBOX, fistNameVal);
	}

	public void inputToLastnameTextbox(String lastNameVal) {
		waitForElementVisible(MyAccountPageUI.LASTNAME_TEXTBOX);
		sendkeysToElement(MyAccountPageUI.LASTNAME_TEXTBOX, lastNameVal);
	}

	public void selectDateOfBirthFromDropdown(String dateOfBirthVal) {
		waitForElementVisible(MyAccountPageUI.DATEOFBIRTH_DROPDOWN);
		selectItemInDropdown(MyAccountPageUI.DATEOFBIRTH_DROPDOWN, dateOfBirthVal);
	}

	public void selectDateOfMonthFromDropdown(String dateOfMonthVal) {
		waitForElementVisible(MyAccountPageUI.DATEOFMONTH_DROPDOWN);
		selectItemInDropdown(MyAccountPageUI.DATEOFMONTH_DROPDOWN, dateOfMonthVal);
	}

	public void selectDateOfYearFromDropdown(String dateOfYearVal) {
		waitForElementVisible(MyAccountPageUI.DATEOFYEAR_DROPDOWN);
		selectItemInDropdown(MyAccountPageUI.DATEOFYEAR_DROPDOWN, dateOfYearVal);
	}

	public void inputToEmailTextbox(String emailVal) {
		waitForElementVisible(MyAccountPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(MyAccountPageUI.EMAIL_TEXTBOX, emailVal);

	}

	public void inputToCompanynameTextbox(String companyNameVal) {
		waitForElementVisible(MyAccountPageUI.COMPANYNAME_TEXTBOX);
		sendkeysToElement(MyAccountPageUI.COMPANYNAME_TEXTBOX, companyNameVal);

	}
	
	public void clickToSaveButton() {
		waitForElementVisible(MyAccountPageUI.SAVE_BUTTON);
		clickToElement(MyAccountPageUI.SAVE_BUTTON);
	}
	
	public void clickToAddressLink() {
		waitForElementVisible(MyAccountPageUI.ADDRESS_LINKS);
		clickToElement(MyAccountPageUI.ADDRESS_LINKS);
	}
	
	public void clickToAddNewAddressButton() {
		waitForElementVisible(MyAccountPageUI.ADDRESS_NEW_ADDRESS_BUTTON);
		clickToElement(MyAccountPageUI.ADDRESS_NEW_ADDRESS_BUTTON);
	}
	
	public boolean isAddressTableDisplayed() {
		waitForElementVisible(MyAccountPageUI.ADDRESS_NEW_ADDRESS_TABLE);
		return elementIsDisplayed(MyAccountPageUI.ADDRESS_NEW_ADDRESS_TABLE);
	}
	
	public void inputToAddressFirstnameTextbox(String addFirstNameVal) {
		waitForElementVisible(MyAccountPageUI.ADDRESS_FIRSTNAME_TEXTBOX);
		sendkeysToElement(MyAccountPageUI.ADDRESS_FIRSTNAME_TEXTBOX, addFirstNameVal);
	}
	
	public void inputToAddressLastnameTextbox(String addLastNameVal) {
		waitForElementVisible(MyAccountPageUI.ADDRESS_LASTNAME_TEXTBOX);
		sendkeysToElement(MyAccountPageUI.ADDRESS_LASTNAME_TEXTBOX, addLastNameVal);
	}
	
	public void inputToAddressEmailTextbox(String addEmailVal) {
		waitForElementVisible(MyAccountPageUI.ADDRESS_EMAIL_TEXTBOX);
		sendkeysToElement(MyAccountPageUI.ADDRESS_EMAIL_TEXTBOX, addEmailVal);
	}
	
	public void inputToAddressCompanynameTextbox(String addCompanyNameVal) {
		waitForElementVisible(MyAccountPageUI.ADDRESS_COMPANYNAME_TEXTBOX);
		sendkeysToElement(MyAccountPageUI.ADDRESS_COMPANYNAME_TEXTBOX, addCompanyNameVal);
	}
	
	public void selectAddressCountryFromDropdown(String addCountryVal) {
		waitForElementVisible(MyAccountPageUI.ADDRESS_COUNTRY_DROPDOWN);
		selectItemInDropdown(MyAccountPageUI.ADDRESS_COUNTRY_DROPDOWN, addCountryVal);
	}
	
	public void selectAddressStateFromDropdown(String addStateVal) {
		waitForElementVisible(MyAccountPageUI.ADDRESS_STATE_DROPDOWN);
		selectItemInDropdown(MyAccountPageUI.ADDRESS_STATE_DROPDOWN, addStateVal);
	}
	
	public void inputToAddressCityTextbox(String addCityNameVal) {
		waitForElementVisible(MyAccountPageUI.ADDRESS_CITY_TEXTBOX);
		sendkeysToElement(MyAccountPageUI.ADDRESS_CITY_TEXTBOX, addCityNameVal);
	}
	
	public void inputToAddress01Textbox(String addAddress01Val) {
		waitForElementVisible(MyAccountPageUI.ADDRESS_ADDRESS01_TEXTBOX);
		sendkeysToElement(MyAccountPageUI.ADDRESS_ADDRESS01_TEXTBOX, addAddress01Val);
	}
	
	public void inputToAddress02Textbox(String addAddress02Val) {
		waitForElementVisible(MyAccountPageUI.ADDRESS_ADDRESS02_TEXTBOX);
		sendkeysToElement(MyAccountPageUI.ADDRESS_ADDRESS02_TEXTBOX, addAddress02Val);
	}
	
	public void inputToAddressZipcodeTextbox(String addZipcodeVal) {
		waitForElementVisible(MyAccountPageUI.ADDRESS_ZIPCODE_TEXTBOX);
		sendkeysToElement(MyAccountPageUI.ADDRESS_ZIPCODE_TEXTBOX, addZipcodeVal);
	}
	
	public void inputToAddressPhoneNumberTextbox(String addPhoneNumberVal) {
		waitForElementVisible(MyAccountPageUI.ADDRESS_PHONENUMBER_TEXTBOX);
		sendkeysToElement(MyAccountPageUI.ADDRESS_PHONENUMBER_TEXTBOX, addPhoneNumberVal);
	}
	
	public void inputToAddressFaxNumberTextbox(String addFaxNumberVal) {
		waitForElementVisible(MyAccountPageUI.ADDRESS_FAXNUMBER_TEXTBOX);
		sendkeysToElement(MyAccountPageUI.ADDRESS_FAXNUMBER_TEXTBOX, addFaxNumberVal);
	}
	
	public void clickToAddressSaveButton() {
		waitForElementVisible(MyAccountPageUI.ADDRESS_SAVE_BUTTON);
		clickToElement(MyAccountPageUI.ADDRESS_SAVE_BUTTON);
	}
	
	public boolean isAddressInfoTableDisplayed() {
		waitForElementVisible(MyAccountPageUI.ADDRESS_INFO_TABLE);
		return elementIsDisplayed(MyAccountPageUI.ADDRESS_INFO_TABLE);
	}
	
	public String getAddressFirstLastNameData() {
		waitForElementVisible(MyAccountPageUI.ADDRESS_FIRST_LAST_NAME_TEXT);
		return getTextElement(MyAccountPageUI.ADDRESS_FIRST_LAST_NAME_TEXT);
	}
	
	public String getAddressEmailData() {
		waitForElementVisible(MyAccountPageUI.ADDRESS_EMAIL_TEXT);
		return getTextElement(MyAccountPageUI.ADDRESS_EMAIL_TEXT);
	}
	
	public String getAddressPhoneNumberData() {
		waitForElementVisible(MyAccountPageUI.ADDRESS_PHONENUMBER_TEXT);
		return getTextElement(MyAccountPageUI.ADDRESS_PHONENUMBER_TEXT);
	}
	
	public String getAddressFaxNumberData() {
		waitForElementVisible(MyAccountPageUI.ADDRESS_FAXNUMBER_TEXT);
		return getTextElement(MyAccountPageUI.ADDRESS_FAXNUMBER_TEXT);
	}
	
	public String getAddressCompanyNameData() {
		waitForElementVisible(MyAccountPageUI.ADDRESS_COMPANYNAME_TEXT);
		return getTextElement(MyAccountPageUI.ADDRESS_COMPANYNAME_TEXT);
	}
	
	public String getAddress01Data() {
		waitForElementVisible(MyAccountPageUI.ADDRESS_ADDRESS01_TEXT);
		return getTextElement(MyAccountPageUI.ADDRESS_ADDRESS01_TEXT);
	}
	
	public String getAddress02Data() {
		waitForElementVisible(MyAccountPageUI.ADDRESS_ADDRESS02_TEXT);
		return getTextElement(MyAccountPageUI.ADDRESS_ADDRESS02_TEXT);
	}
	
	public String getAddressCityStateData() {
		waitForElementVisible(MyAccountPageUI.ADDRESS_CITY_ZIPCODE_TEXT);
		return getTextElement(MyAccountPageUI.ADDRESS_CITY_ZIPCODE_TEXT);
	}
	
	public String getAddressCountryData() {
		waitForElementVisible(MyAccountPageUI.ADDRESS_COUNTRY_TEXT);
		return getTextElement(MyAccountPageUI.ADDRESS_COUNTRY_TEXT);
	}
	
	public void clickToChangePasswordLink() {
		waitForElementVisible(MyAccountPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(MyAccountPageUI.CHANGE_PASSWORD_LINK);
	}
	
	public boolean isChangePasswordFormDisplayed() {
		waitForElementVisible(MyAccountPageUI.CHANGE_PASSWORD_FORM);
		return elementIsDisplayed(MyAccountPageUI.CHANGE_PASSWORD_FORM);
	}
	
	public void inputToChangeOldPasswordTextbox(String oldPasswordVal) {
		waitForElementVisible(MyAccountPageUI.CHANGE_OLD_PASSWORD_TEXTBOX);
		sendkeysToElement(MyAccountPageUI.CHANGE_OLD_PASSWORD_TEXTBOX, oldPasswordVal);
	}
	
	public void inputToChangeNewPasswordTextbox(String newPasswordVal) {
		waitForElementVisible(MyAccountPageUI.CHANGE_NEW_PASSWORD_TEXTBOX);
		sendkeysToElement(MyAccountPageUI.CHANGE_NEW_PASSWORD_TEXTBOX, newPasswordVal);
	}
	
	public void inputToChangeConfirmNewPasswordTextbox(String confirmPasswordVal) {
		waitForElementVisible(MyAccountPageUI.CHANGE_CONFIRM_NEW_PASSWORD_TEXTBOX);
		sendkeysToElement(MyAccountPageUI.CHANGE_CONFIRM_NEW_PASSWORD_TEXTBOX, confirmPasswordVal);
	}
	
	public void clickToChangePasswordButton() {
		waitForElementVisible(MyAccountPageUI.CHANGE_NEW_PASSWORD_BUTTON);
		clickToElement(MyAccountPageUI.CHANGE_NEW_PASSWORD_BUTTON);
		}
	
	public String getChangeNewPassResultMessageData() {
		waitForElementVisible(MyAccountPageUI.CHANGE_NEW_PASSWORD_RESULT_MESSAGE);
		return getTextElement(MyAccountPageUI.CHANGE_NEW_PASSWORD_RESULT_MESSAGE);
	}
	
	public void clickToMyProductReviewLink() {
		waitForElementVisible(MyAccountPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(MyAccountPageUI.MY_PRODUCT_REVIEW_LINK);
	}
	
	public boolean isMyProductReviewFormDisplayed() {
		waitForElementVisible(MyAccountPageUI.MY_PRODUCT_REVIEW_FORM);
		return elementIsDisplayed(MyAccountPageUI.MY_PRODUCT_REVIEW_FORM);
	}
	
	public boolean isMyProductReviewTitleDisplayed(String expTitleVal) {
		waitForAllElementsVisible(MyAccountPageUI.MY_PRODUCT_REVIEW_PRODUCT_TITLE);
		return compareStringFromElementText(MyAccountPageUI.MY_PRODUCT_REVIEW_PRODUCT_TITLE, expTitleVal);
	}
	
	public boolean isMyProductReviewDescriptionDisplayed(String expDescriptionVal) {
		waitForAllElementsVisible(MyAccountPageUI.MY_PRODUCT_REVIEW_PRODUCT_DESCRIPTION);
		return compareStringFromElementText(MyAccountPageUI.MY_PRODUCT_REVIEW_PRODUCT_DESCRIPTION, expDescriptionVal);
	}
	
	public boolean isMyProductReviewInfoDisplayed(String expInfoVal) {
		waitForAllElementsVisible(MyAccountPageUI.MY_PRODUCT_REVIEW_PRODUCT_INFO);
		return compareStringFromElementText(MyAccountPageUI.MY_PRODUCT_REVIEW_PRODUCT_INFO, expInfoVal);
	}
}
