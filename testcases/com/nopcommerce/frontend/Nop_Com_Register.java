package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactoryPattern.DriverManager;
import driverFactoryPattern.DriverManagerFactory;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Nop_Com_Register extends AbstractTest {

	private WebDriver driver;
	String firstNameVal, lastNameVal, dateOfBirthVal, dateOfMonthVal, dateOfYearVal, emailVal, companyNameVal, passVal;

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

		String pageUrl = "https://demo.nopcommerce.com/";
		driver.get(pageUrl);
	}

	@Test
	public void TC01_Register_With_Empty_Data() {

		firstNameVal = "";
		lastNameVal = "";
		emailVal = "";
		companyNameVal = "";
		passVal = "";
		String firstNameErrMess = "First name is required.";
		String lastNameErrMess = "Last name is required.";
		String emailErrMess = "Email is required.";
		String passErrMess = "Password is required.";

		homePage = PageGeneratorManager.getHomePage(driver);

		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToMaleRadioButton();
		registerPage.inputToFirstnameTextbox(firstNameVal);
		registerPage.inputToLastnameTextbox(lastNameVal);
		registerPage.inputToEmailTextbox(emailVal);
		registerPage.inputToCompanynameTextbox(companyNameVal);
		registerPage.inputToPasswordTextbox(passVal);
		registerPage.inputToConfimPasswordTextbox(passVal);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(firstNameErrMess, registerPage.getFirstNameErrorMessage());
		Assert.assertEquals(lastNameErrMess, registerPage.getLastNameErrorMessage());
		Assert.assertEquals(emailErrMess, registerPage.getEmailErrorMessage());
		Assert.assertEquals(passErrMess, registerPage.getPasswordErrorMessage());
		Assert.assertEquals(passErrMess, registerPage.getConfirmPasswordErrorMessage());
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
		String emailErrMess = "Wrong email";

		registerPage.clickToMaleRadioButton();
		registerPage.inputToFirstnameTextbox(firstNameVal);
		registerPage.inputToLastnameTextbox(lastNameVal);
		registerPage.selectDateOfBirthFromDropdown(dateOfBirthVal);
		registerPage.selectDateOfMonthFromDropdown(dateOfMonthVal);
		registerPage.selectDateOfYearFromDropdown(dateOfYearVal);
		registerPage.inputToEmailTextbox(emailVal);
		registerPage.inputToCompanynameTextbox(companyNameVal);
		registerPage.inputToPasswordTextbox(passVal);
		registerPage.inputToConfimPasswordTextbox(passVal);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(emailErrMess, registerPage.getEmailErrorMessage());
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
		String emailErrMess = "The specified email already exists";

		registerPage.clickToMaleRadioButton();
		registerPage.inputToFirstnameTextbox(firstNameVal);
		registerPage.inputToLastnameTextbox(lastNameVal);
		registerPage.selectDateOfBirthFromDropdown(dateOfBirthVal);
		registerPage.selectDateOfMonthFromDropdown(dateOfMonthVal);
		registerPage.selectDateOfYearFromDropdown(dateOfYearVal);
		registerPage.inputToEmailTextbox(emailVal);
		registerPage.inputToCompanynameTextbox(companyNameVal);
		registerPage.inputToPasswordTextbox(passVal);
		registerPage.inputToConfimPasswordTextbox(passVal);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(emailErrMess, registerPage.getExistEmailErrorMessage());
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
		String passwordRuleMessage = "Password must meet the following rules:";
		String passwordLessThan6CharacterErrorMessage = "must have at least 6 characters";

		registerPage.clickToMaleRadioButton();
		registerPage.inputToFirstnameTextbox(firstNameVal);
		registerPage.inputToLastnameTextbox(lastNameVal);
		registerPage.selectDateOfBirthFromDropdown(dateOfBirthVal);
		registerPage.selectDateOfMonthFromDropdown(dateOfMonthVal);
		registerPage.selectDateOfYearFromDropdown(dateOfYearVal);
		registerPage.inputToEmailTextbox(emailVal);
		registerPage.inputToCompanynameTextbox(companyNameVal);
		registerPage.inputToPasswordTextbox(passVal);
		registerPage.inputToConfimPasswordTextbox(passVal);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(passwordRuleMessage, registerPage.getPasswordRulesErrorMessage());
		Assert.assertEquals(passwordLessThan6CharacterErrorMessage,
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
		String confirmPassVal = "12345";
		String confirmPassErrMess = "The password and confirmation password do not match.";

		registerPage.clickToMaleRadioButton();
		registerPage.inputToFirstnameTextbox(firstNameVal);
		registerPage.inputToLastnameTextbox(lastNameVal);
		registerPage.selectDateOfBirthFromDropdown(dateOfBirthVal);
		registerPage.selectDateOfMonthFromDropdown(dateOfMonthVal);
		registerPage.selectDateOfYearFromDropdown(dateOfYearVal);
		registerPage.inputToEmailTextbox(emailVal);
		registerPage.inputToCompanynameTextbox(companyNameVal);
		registerPage.inputToPasswordTextbox(passVal);
		registerPage.inputToConfimPasswordTextbox(confirmPassVal);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(confirmPassErrMess, registerPage.getConfirmPasswordErrorMessage());
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

		registerPage.clickToMaleRadioButton();
		registerPage.inputToFirstnameTextbox(firstNameVal);
		registerPage.inputToLastnameTextbox(lastNameVal);
		registerPage.selectDateOfBirthFromDropdown(dateOfBirthVal);
		registerPage.selectDateOfMonthFromDropdown(dateOfMonthVal);
		registerPage.selectDateOfYearFromDropdown(dateOfYearVal);
		registerPage.inputToEmailTextbox(emailVal);
		registerPage.inputToCompanynameTextbox(companyNameVal);
		registerPage.inputToPasswordTextbox(passVal);
		registerPage.inputToConfimPasswordTextbox(passVal);
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
	
	@AfterClass
	public void afterClass() {
		driverManager.quitDriver();
	}

}
