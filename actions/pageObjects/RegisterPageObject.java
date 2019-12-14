package pageObjects;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstactPageUI;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {

	public RegisterPageObject(WebDriver driver) {
		super(driver);
	}

	public void clickToMaleRadioButton(){
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,RegisterPageUI.INPUT_ID_GENDER_MALE_RADIOBUTTON);
		clickToElement(AbstactPageUI.INPUT_ID_DYNAMIC,RegisterPageUI.INPUT_ID_GENDER_MALE_RADIOBUTTON);
	}
	
	public void inputToFirstnameTextbox(String dataVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,RegisterPageUI.INPUT_ID_FIRSTNAME_TEXTBOX);
		sendkeysToElement(dataVal,AbstactPageUI.INPUT_ID_DYNAMIC,RegisterPageUI.INPUT_ID_FIRSTNAME_TEXTBOX);
	}
	
	public void inputToLastnameTextbox(String dataVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,RegisterPageUI.INPUT_ID_LASTNAME_TEXTBOX);
		sendkeysToElement(dataVal,AbstactPageUI.INPUT_ID_DYNAMIC,RegisterPageUI.INPUT_ID_LASTNAME_TEXTBOX);
	}

	public void selectDateOfBirthFromDropdown(String dateOfBirthVal) {
		waitForElementVisible(AbstactPageUI.SELECT_NAME_DYNAMIC,RegisterPageUI.SELECT_NAME_DATEOFBIRTH_DROPDOWN);
		selectItemInDropdown(dateOfBirthVal,AbstactPageUI.SELECT_NAME_DYNAMIC,RegisterPageUI.SELECT_NAME_DATEOFBIRTH_DROPDOWN);
	}
	
	public void selectDateOfMonthFromDropdown(String dateOfBirthVal) {
		waitForElementVisible(AbstactPageUI.SELECT_NAME_DYNAMIC,RegisterPageUI.SELECT_NAME_DATEOFMONTH_DROPDOWN);
		selectItemInDropdown(dateOfBirthVal,AbstactPageUI.SELECT_NAME_DYNAMIC,RegisterPageUI.SELECT_NAME_DATEOFMONTH_DROPDOWN);
	}

	public void selectDateOfYearFromDropdown(String dateOfBirthVal) {
		waitForElementVisible(AbstactPageUI.SELECT_NAME_DYNAMIC,RegisterPageUI.SELECT_NAME_DATEOFYEAR_DROPDOWN);
		selectItemInDropdown(dateOfBirthVal,AbstactPageUI.SELECT_NAME_DYNAMIC,RegisterPageUI.SELECT_NAME_DATEOFYEAR_DROPDOWN);
	}
	
	public void inputToEmailTextbox(String dataVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,RegisterPageUI.INPUT_ID_EMAIL_TEXTBOX);
		sendkeysToElement(dataVal,AbstactPageUI.INPUT_ID_DYNAMIC,RegisterPageUI.INPUT_ID_EMAIL_TEXTBOX);
	}
	
	public void inputToCompanynameTextbox(String dataVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,RegisterPageUI.INPUT_ID_COMPANYNAME_TEXTBOX);
		sendkeysToElement(dataVal,AbstactPageUI.INPUT_ID_DYNAMIC,RegisterPageUI.INPUT_ID_COMPANYNAME_TEXTBOX);
	}
	
	public void inputToPasswordTextbox(String dataVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,RegisterPageUI.INPUT_ID_PASSWORD_TEXTBOX);
		sendkeysToElement(dataVal,AbstactPageUI.INPUT_ID_DYNAMIC,RegisterPageUI.INPUT_ID_PASSWORD_TEXTBOX);
	}
	
	public void inputToConfimPasswordTextbox(String dataVal) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,RegisterPageUI.INPUT_ID_CONFIRM_PASSWORD_TEXTBOX);
		sendkeysToElement(dataVal,AbstactPageUI.INPUT_ID_DYNAMIC,RegisterPageUI.INPUT_ID_CONFIRM_PASSWORD_TEXTBOX);
	}

	public void clickToRadioButton(String locatorName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
		clickToElement(AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
	}

	public void inputToTextboxName(String dataVal, String locatorName) {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
		sendkeysToElement(dataVal,AbstactPageUI.INPUT_ID_DYNAMIC,locatorName);
	}

	public void selectDateOfBirthFromDropdown(String dateOfBirthVal, String locatorName) {
		waitForElementVisible(AbstactPageUI.SELECT_NAME_DYNAMIC,locatorName);
		selectItemInDropdown(dateOfBirthVal,AbstactPageUI.SELECT_NAME_DYNAMIC,locatorName);
	}

	public void clickToRegisterButton() {
		waitForElementVisible(AbstactPageUI.INPUT_ID_DYNAMIC,RegisterPageUI.INPUT_ID_REGISTER_BUTTON);
		clickToElement(AbstactPageUI.INPUT_ID_DYNAMIC,RegisterPageUI.INPUT_ID_REGISTER_BUTTON);
	}

	public boolean isSuccessMessageDisplayed() {
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,RegisterPageUI.DIV_CLASS_REGISTER_SUCCESS_MESSAGE);
	}
	
	public String getErrorMessageFromField(String locatorName) {
		waitForElementVisible(AbstactPageUI.SPAN_ID_DYNAMIC,locatorName);
		return getTextElement(AbstactPageUI.SPAN_ID_DYNAMIC,locatorName);
	}
	
	public String getExistEmailErrorMessage() {
		waitForElementVisible(RegisterPageUI.EXIST_EMAIL_MESSAGE);
		return getTextElement(RegisterPageUI.EXIST_EMAIL_MESSAGE);
	}
	
	public String getPasswordRulesErrorMessage() {
		waitForElementVisible(RegisterPageUI.PASSWORD_TEXTBOX_RULES_MESSAGE);
		return getTextElement(RegisterPageUI.PASSWORD_TEXTBOX_RULES_MESSAGE);
	}

	public String getPasswordLessThan6CharacterErrorMessage() {
		waitForElementVisible(RegisterPageUI.PASSWORD_LESS_THAN_6_CHARACTER_MESSAGE);
		return getTextElement(RegisterPageUI.PASSWORD_LESS_THAN_6_CHARACTER_MESSAGE);
	}
	
	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
}
