package pageObjects;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {

	public RegisterPageObject(WebDriver driver) {
		super(driver);
	}

	public void clickToMaleRadioButton() {
		waitForElementVisible(RegisterPageUI.GENDER_MALE_RADIOBUTTON);
		clickToElement(RegisterPageUI.GENDER_MALE_RADIOBUTTON);
	}

	public void inputToFirstnameTextbox(String fistNameVal) {
		waitForElementVisible(RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeysToElement(RegisterPageUI.FIRSTNAME_TEXTBOX, fistNameVal);
	}

	public void inputToLastnameTextbox(String lastNameVal) {
		waitForElementVisible(RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeysToElement(RegisterPageUI.LASTNAME_TEXTBOX, lastNameVal);
	}

	public void selectDateOfBirthFromDropdown(String dateOfBirthVal) {
		waitForElementVisible(RegisterPageUI.DATEOFBIRTH_DROPDOWN);
		selectItemInDropdown(RegisterPageUI.DATEOFBIRTH_DROPDOWN, dateOfBirthVal);
	}

	public void selectDateOfMonthFromDropdown(String dateOfMonthVal) {
		waitForElementVisible(RegisterPageUI.DATEOFMONTH_DROPDOWN);
		selectItemInDropdown(RegisterPageUI.DATEOFMONTH_DROPDOWN, dateOfMonthVal);
	}

	public void selectDateOfYearFromDropdown(String dateOfYearVal) {
		waitForElementVisible(RegisterPageUI.DATEOFYEAR_DROPDOWN);
		selectItemInDropdown(RegisterPageUI.DATEOFYEAR_DROPDOWN, dateOfYearVal);
	}

	public void inputToEmailTextbox(String emailVal) {
		waitForElementVisible(RegisterPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(RegisterPageUI.EMAIL_TEXTBOX, emailVal);

	}

	public void inputToCompanynameTextbox(String companyNameVal) {
		waitForElementVisible(RegisterPageUI.COMPANYNAME_TEXTBOX);
		sendkeysToElement(RegisterPageUI.COMPANYNAME_TEXTBOX, companyNameVal);

	}

	public void inputToPasswordTextbox(String passwordVal) {
		waitForElementVisible(RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(RegisterPageUI.PASSWORD_TEXTBOX, passwordVal);

	}

	public void inputToConfimPasswordTextbox(String confirmPasswordVal) {
		waitForElementVisible(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeysToElement(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPasswordVal);

	}

	public void clickToRegisterButton() {
		waitForElementVisible(RegisterPageUI.REGISTER_BUTTON);
		clickToElement(RegisterPageUI.REGISTER_BUTTON);
	}

	public boolean isSuccessMessageDisplayed() {
		return elementIsDisplayed(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}
	
	public String getFirstNameErrorMessage() {
		waitForElementVisible(RegisterPageUI.FIRSTNAME_TEXTBOX_MESSAGE);
		return getTextElement(RegisterPageUI.FIRSTNAME_TEXTBOX_MESSAGE);
	}
	
	public String getLastNameErrorMessage() {
		waitForElementVisible(RegisterPageUI.LASTNAME_TEXTBOX_MESSAGE);
		return getTextElement(RegisterPageUI.LASTNAME_TEXTBOX_MESSAGE);
	}
	
	public String getEmailErrorMessage() {
		waitForElementVisible(RegisterPageUI.EMAIL_TEXTBOX_MESSAGE);
		return getTextElement(RegisterPageUI.EMAIL_TEXTBOX_MESSAGE);
	}
	
	public String getPasswordErrorMessage() {
		waitForElementVisible(RegisterPageUI.PASSWORD_TEXTBOX_MESSAGE);
		return getTextElement(RegisterPageUI.PASSWORD_TEXTBOX_MESSAGE);
	}
	
	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX_MESSAGE);
		return getTextElement(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX_MESSAGE);
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
