package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactoryPattern.DriverManager;
import driverFactoryPattern.DriverManagerFactory;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;
import pageUIs.AbstactPageUI;
import pageUIs.RegisterPageUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class FE_01_Register extends AbstractTest {

	private WebDriver driver;
	private String firstNameVal, lastNameVal, dateOfBirthVal, dateOfMonthVal, dateOfYearVal, emailVal, companyNameVal, passVal,confirmPassVal;
	private String emptyFirstNameErrMess,emptyLastNameErrMess,emptyEmailErrMess,emptyPassErrMess,wrongEmailErrMess,existEmailErrMess;
	private String passwordRuleMessage,passwordLessThan6CharacterErrorMessage,confirmPassErrMess;

	private DriverManager driverManager;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driverManager = DriverManagerFactory.getBrowserDriver(browserName);
		driver = driverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		emptyFirstNameErrMess = "First name is required.";
		emptyLastNameErrMess = "Last name is required.";
		emptyEmailErrMess = "Email is required.";
		emptyPassErrMess = "Password is required.";
		wrongEmailErrMess = "Wrong email";
		existEmailErrMess = "The specified email already exists";
		passwordRuleMessage = "Password must meet the following rules:";
		passwordLessThan6CharacterErrorMessage = "must have at least 6 characters";
		confirmPassErrMess = "The password and confirmation password do not match.";
		
		String pageUrl = "https://demo.nopcommerce.com/";
		log.info("Pre-Condition 01 : Open Page Url " + pageUrl);
		driver.get(pageUrl);
	}

	@Test
	public void TC01_Register_With_Empty_Data() {

		firstNameVal = "";
		lastNameVal = "";
		emailVal = "";
		companyNameVal = "";
		passVal = "";

		log.info("TC01_Register_With_Empty_Data - Step 01 : Init HomePage");
		homePage = PageGeneratorManager.getHomePage(driver);

		log.info("TC01_Register_With_Empty_Data - Step 02 : Open Register Page Through Header Register Link");
		homePage.openHeaderDynamicPage(AbstactPageUI.A_CLASS_HEADER_REGISTER_LINK);
		
		log.info("TC01_Register_With_Empty_Data - Step 03 : Init Register Page");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		log.info("TC01_Register_With_Empty_Data - Step 04 : Register Account with Empty Data");
		registerPage.clickToRadioButton(RegisterPageUI.INPUT_ID_GENDER_MALE_RADIOBUTTON);
		registerPage.inputToTextboxName(firstNameVal, RegisterPageUI.INPUT_ID_FIRSTNAME_TEXTBOX);
		registerPage.inputToTextboxName(lastNameVal,RegisterPageUI.INPUT_ID_LASTNAME_TEXTBOX);
		registerPage.inputToTextboxName(emailVal,RegisterPageUI.INPUT_ID_EMAIL_TEXTBOX);
		registerPage.inputToTextboxName(companyNameVal,RegisterPageUI.INPUT_ID_COMPANYNAME_TEXTBOX);
		registerPage.inputToTextboxName(passVal,RegisterPageUI.INPUT_ID_PASSWORD_TEXTBOX);
		registerPage.inputToTextboxName(passVal,RegisterPageUI.INPUT_ID_CONFIRM_PASSWORD_TEXTBOX);
		
		log.info("TC01_Register_With_Empty_Data - Step 05 : Click to Register Button");
		registerPage.clickToRegisterButton();

		log.info("TC01_Register_With_Empty_Data - Step 06 : Verify Error Mesages in Required Fields");
		verifyEquals(emptyFirstNameErrMess, registerPage.getErrorMessageFromField(RegisterPageUI.SPAN_ID_FIRSTNAME_TEXTBOX_MESSAGE));
		verifyEquals(emptyLastNameErrMess, registerPage.getErrorMessageFromField(RegisterPageUI.SPAN_ID_LASTNAME_TEXTBOX_MESSAGE));
		verifyEquals(emptyEmailErrMess, registerPage.getErrorMessageFromField(RegisterPageUI.SPAN_ID_EMAIL_TEXTBOX_MESSAGE));
		verifyEquals(emptyPassErrMess, registerPage.getErrorMessageFromField(RegisterPageUI.SPAN_ID_PASSWORD_TEXTBOX_MESSAGE));
		verifyEquals(emptyPassErrMess, registerPage.getErrorMessageFromField(RegisterPageUI.SPAN_ID_CONFIRM_PASSWORD_TEXTBOX_MESSAGE));
	}

	@Test
	public void TC02_Register_With_Invalid_Email() {

		firstNameVal = "John";
		lastNameVal = "Wick";
		dateOfBirthVal = "15";
		dateOfMonthVal = "May";
		dateOfYearVal = "1990";
		emailVal = "john_wickgmail.com";
		companyNameVal = "John Wick Entertainment";
		passVal = "123456";

		log.info("TC02_Register_With_Invalid_Email - Step 01 : Register Account with Invalid Email");
		registerPage.clickToRadioButton(RegisterPageUI.INPUT_ID_GENDER_MALE_RADIOBUTTON);
		registerPage.inputToTextboxName(firstNameVal, RegisterPageUI.INPUT_ID_FIRSTNAME_TEXTBOX);
		registerPage.inputToTextboxName(lastNameVal, RegisterPageUI.INPUT_ID_LASTNAME_TEXTBOX);
		registerPage.inputToTextboxName(emailVal, RegisterPageUI.INPUT_ID_EMAIL_TEXTBOX);
		registerPage.inputToTextboxName(companyNameVal, RegisterPageUI.INPUT_ID_COMPANYNAME_TEXTBOX);
		registerPage.inputToTextboxName(passVal, RegisterPageUI.INPUT_ID_PASSWORD_TEXTBOX);
		registerPage.inputToTextboxName(passVal, RegisterPageUI.INPUT_ID_CONFIRM_PASSWORD_TEXTBOX);
		
		log.info("TC02_Register_With_Invalid_Email - Step 02 : Click to Register Button");
		registerPage.clickToRegisterButton();

		log.info("TC02_Register_With_Invalid_Email - Step 03 : Verify Error Message in Email Field ");
		verifyEquals(wrongEmailErrMess,
				registerPage.getErrorMessageFromField(RegisterPageUI.SPAN_ID_EMAIL_TEXTBOX_MESSAGE));

	}

	@Test
	public void TC03_Register_With_Exist_Email() {

		
		firstNameVal = "John";
		lastNameVal = "Wick";
		dateOfBirthVal = "15";
		dateOfMonthVal = "May";
		dateOfYearVal = "1990";
		emailVal = "automationfc.vn@gmail.com";
		companyNameVal = "John Wick Entertainment";
		passVal = "123456";

		log.info("TC03_Register_With_Exist_Email - Step 01 : Register Account with Exist Email");
		registerPage.clickToRadioButton(RegisterPageUI.INPUT_ID_GENDER_MALE_RADIOBUTTON);
		registerPage.inputToTextboxName(firstNameVal, RegisterPageUI.INPUT_ID_FIRSTNAME_TEXTBOX);
		registerPage.inputToTextboxName(lastNameVal, RegisterPageUI.INPUT_ID_LASTNAME_TEXTBOX);
		registerPage.selectDateOfBirthFromDropdown(dateOfBirthVal, RegisterPageUI.SELECT_NAME_DATEOFBIRTH_DROPDOWN);
		registerPage.selectDateOfBirthFromDropdown(dateOfMonthVal, RegisterPageUI.SELECT_NAME_DATEOFMONTH_DROPDOWN);
		registerPage.selectDateOfBirthFromDropdown(dateOfYearVal, RegisterPageUI.SELECT_NAME_DATEOFYEAR_DROPDOWN);
		registerPage.inputToTextboxName(emailVal, RegisterPageUI.INPUT_ID_EMAIL_TEXTBOX);
		registerPage.inputToTextboxName(companyNameVal, RegisterPageUI.INPUT_ID_COMPANYNAME_TEXTBOX);
		registerPage.inputToTextboxName(passVal, RegisterPageUI.INPUT_ID_PASSWORD_TEXTBOX);
		registerPage.inputToTextboxName(passVal, RegisterPageUI.INPUT_ID_CONFIRM_PASSWORD_TEXTBOX);
		
		log.info("TC03_Register_With_Exist_Email - Step 02 : Click to Register Button");
		registerPage.clickToRegisterButton();

		log.info("TC03_Register_With_Exist_Email - Step 03 : Verify Error Mesage in Email Field");
		verifyEquals(existEmailErrMess, registerPage.getExistEmailErrorMessage());

	}

	@Test
	public void TC04_Register_With_Password_Less_Than_Six_Character() {

		
		firstNameVal = "John";
		lastNameVal = "Wick";
		dateOfBirthVal = "15";
		dateOfMonthVal = "May";
		dateOfYearVal = "1990";
		emailVal = "automationfc.vn@gmail.com";
		companyNameVal = "John Wick Entertainment";
		passVal = "12345";

		log.info("TC04_Register_With_Password_Less_Than_Six_Character - Step 01 : Register Account with Password Less Than Six Character");
		registerPage.clickToRadioButton(RegisterPageUI.INPUT_ID_GENDER_MALE_RADIOBUTTON);
		registerPage.inputToTextboxName(firstNameVal, RegisterPageUI.INPUT_ID_FIRSTNAME_TEXTBOX);
		registerPage.inputToTextboxName(lastNameVal, RegisterPageUI.INPUT_ID_LASTNAME_TEXTBOX);
		registerPage.selectDateOfBirthFromDropdown(dateOfBirthVal, RegisterPageUI.SELECT_NAME_DATEOFBIRTH_DROPDOWN);
		registerPage.selectDateOfBirthFromDropdown(dateOfMonthVal, RegisterPageUI.SELECT_NAME_DATEOFMONTH_DROPDOWN);
		registerPage.selectDateOfBirthFromDropdown(dateOfYearVal, RegisterPageUI.SELECT_NAME_DATEOFYEAR_DROPDOWN);
		registerPage.inputToTextboxName(emailVal, RegisterPageUI.INPUT_ID_EMAIL_TEXTBOX);
		registerPage.inputToTextboxName(companyNameVal, RegisterPageUI.INPUT_ID_COMPANYNAME_TEXTBOX);
		registerPage.inputToTextboxName(passVal, RegisterPageUI.INPUT_ID_PASSWORD_TEXTBOX);
		registerPage.inputToTextboxName(passVal, RegisterPageUI.INPUT_ID_CONFIRM_PASSWORD_TEXTBOX);
		
		log.info("TC04_Register_With_Password_Less_Than_Six_Character - Step 02 : Click to Register Button");
		registerPage.clickToRegisterButton();

		log.info("TC04_Register_With_Password_Less_Than_Six_Character - Step 03 : Verify Error Messages in Password Field");
		verifyEquals(passwordRuleMessage, registerPage.getPasswordRulesErrorMessage());
		verifyEquals(passwordLessThan6CharacterErrorMessage,
				registerPage.getPasswordLessThan6CharacterErrorMessage());
		 
	}

	@Test
	public void TC05_Register_With_Confirm_Password_Does_Not_Match() {

		
		firstNameVal = "John";
		lastNameVal = "Wick";
		dateOfBirthVal = "15";
		dateOfMonthVal = "May";
		dateOfYearVal = "1990";
		emailVal = "john_wick_" + randomNumber() + "@gmail.com";
		companyNameVal = "John Wick Entertainment";
		passVal = "123456";
		confirmPassVal = "12345";

		log.info("TC05_Register_With_Confirm_Password_Does_Not_Match - Step 01 : Register Account with Confirm Password Does Not Match");
		registerPage.clickToRadioButton(RegisterPageUI.INPUT_ID_GENDER_MALE_RADIOBUTTON);
		registerPage.inputToTextboxName(firstNameVal, RegisterPageUI.INPUT_ID_FIRSTNAME_TEXTBOX);
		registerPage.inputToTextboxName(lastNameVal, RegisterPageUI.INPUT_ID_LASTNAME_TEXTBOX);
		registerPage.selectDateOfBirthFromDropdown(dateOfBirthVal, RegisterPageUI.SELECT_NAME_DATEOFBIRTH_DROPDOWN);
		registerPage.selectDateOfBirthFromDropdown(dateOfMonthVal, RegisterPageUI.SELECT_NAME_DATEOFMONTH_DROPDOWN);
		registerPage.selectDateOfBirthFromDropdown(dateOfYearVal, RegisterPageUI.SELECT_NAME_DATEOFYEAR_DROPDOWN);
		registerPage.inputToTextboxName(emailVal, RegisterPageUI.INPUT_ID_EMAIL_TEXTBOX);
		registerPage.inputToTextboxName(companyNameVal, RegisterPageUI.INPUT_ID_COMPANYNAME_TEXTBOX);
		registerPage.inputToTextboxName(passVal, RegisterPageUI.INPUT_ID_PASSWORD_TEXTBOX);
		registerPage.inputToTextboxName(confirmPassVal, RegisterPageUI.INPUT_ID_CONFIRM_PASSWORD_TEXTBOX);
		
		log.info("TC05_Register_With_Confirm_Password_Does_Not_Match - Step 02 : Click to Register Button");
		registerPage.clickToRegisterButton();

		log.info("TC05_Register_With_Confirm_Password_Does_Not_Match - Step 03 : Verify Error Message in ConfirmPassWord Field");
		verifyEquals(confirmPassErrMess,
				registerPage.getErrorMessageFromField(RegisterPageUI.SPAN_ID_CONFIRM_PASSWORD_TEXTBOX_MESSAGE));

	}

	@Test
	public void TC06_Register_To_System() {

		
		firstNameVal = "John";
		lastNameVal = "Wick";
		dateOfBirthVal = "15";
		dateOfMonthVal = "May";
		dateOfYearVal = "1990";
		emailVal = "john_wick_" + randomNumber() + "@gmail.com";
		companyNameVal = "John Wick Entertainment";
		passVal = "123456";

		log.info("TC06_Register_To_System - Step 01 : Register Account with valid Data");
		registerPage.clickToRadioButton(RegisterPageUI.INPUT_ID_GENDER_MALE_RADIOBUTTON);
		registerPage.inputToTextboxName(firstNameVal, RegisterPageUI.INPUT_ID_FIRSTNAME_TEXTBOX);
		registerPage.inputToTextboxName(lastNameVal, RegisterPageUI.INPUT_ID_LASTNAME_TEXTBOX);
		registerPage.selectDateOfBirthFromDropdown(dateOfBirthVal, RegisterPageUI.SELECT_NAME_DATEOFBIRTH_DROPDOWN);
		registerPage.selectDateOfBirthFromDropdown(dateOfMonthVal, RegisterPageUI.SELECT_NAME_DATEOFMONTH_DROPDOWN);
		registerPage.selectDateOfBirthFromDropdown(dateOfYearVal, RegisterPageUI.SELECT_NAME_DATEOFYEAR_DROPDOWN);
		registerPage.inputToTextboxName(emailVal, RegisterPageUI.INPUT_ID_EMAIL_TEXTBOX);
		registerPage.inputToTextboxName(companyNameVal, RegisterPageUI.INPUT_ID_COMPANYNAME_TEXTBOX);
		registerPage.inputToTextboxName(passVal, RegisterPageUI.INPUT_ID_PASSWORD_TEXTBOX);
		registerPage.inputToTextboxName(passVal, RegisterPageUI.INPUT_ID_CONFIRM_PASSWORD_TEXTBOX);
		
		log.info("TC06_Register_To_System - Step 02 : Click to Register Button");
		registerPage.clickToRegisterButton();

		log.info("TC06_Register_To_System - Step 03 : Verify Create Account Successfully");
		verifyTrue(registerPage.isSuccessMessageDisplayed());
		 
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
