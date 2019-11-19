package com.nopcommerce.templates;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Step_By_Step {

	WebDriver driver;
	Select select;
	String regFirstName, regLastName, regDateOfBirth, regDateOfMonth, regDateOfYear, regEmail, regCompanyName,
			regPassword;

	By registerLinkX = By.xpath("//a[@class='ico-register']");
	By registerPageX = By.xpath("//div[@class='page registration-page']");
	By genderMaleRadioBtnX = By.xpath("//input[@id='gender-male']");
	By firstNameTxtX = By.xpath("//input[@id='FirstName']");
	By lastNameTxtX = By.xpath("//input[@id='LastName']");
	By dateOfBirthDropDownX = By.xpath("//select[@name='DateOfBirthDay']");
	By dateOfMonthDropDownX = By.xpath("//select[@name='DateOfBirthMonth']");
	By dateOfYearDropDownX = By.xpath("//select[@name='DateOfBirthYear']");
	By emailTxtX = By.xpath("//input[@id='Email']");
	By companyNameTxtX = By.xpath("//input[@id='Company']");
	By passwordTxtX = By.xpath("//input[@id='Password']");
	By confirmPasswordTxtX = By.xpath("//input[@id='ConfirmPassword']");
	By registerBtnX = By.xpath("//input[@id='register-button']");

	By registerSuccessMsgX = By.xpath("//div[@class='result']");
	By logOutLinkX = By.xpath("//a[@class='ico-logout']");

	By loginLinkX = By.xpath("//a[@class='ico-login']");
	By loginPageX = By.xpath("//div[@class='page login-page']");
	By loginBtnX = By.xpath("//input[@class='button-1 login-button']");
	By myAccountLinkX = By.xpath("//a[@class='ico-account']");

	@BeforeClass
	public void beforeClass() {

		System.out.println("Pre-Conditon - Step 01 : Init Firefox Driver ");
		driver = new FirefoxDriver();
		System.out.println("Pre-condition - Step 02: Wait for page loading success");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		regFirstName = "John";
		regLastName = "Wick";
		regDateOfBirth = "15";
		regDateOfMonth = "May";
		regDateOfYear = "1990";
		regEmail = "john_wick_" + randomNumber() + "@gmail.com";
		regCompanyName = "John Wick Entertainment";
		regPassword = "123456";

		String pageUrl = "https://demo.nopcommerce.com/";
		driver.get(pageUrl);
		System.out.println("Pre-condition - Step 03: Go to Page Url" + pageUrl);

	}

	@Test
	public void TC01_Register() {

		// Navigate to Register Page
		clickToElemnet(registerLinkX);
		System.out.println("TC01 : 1. Register Page Display Status : " + checkElementDisplayed(registerPageX));

		// Register new accout
		clickToElemnet(genderMaleRadioBtnX);
		sendkeysToElement(firstNameTxtX, regFirstName);
		sendkeysToElement(lastNameTxtX, regLastName);
		selectElementFromDropDown(dateOfBirthDropDownX, regDateOfBirth);
		selectElementFromDropDown(dateOfMonthDropDownX, regDateOfMonth);
		selectElementFromDropDown(dateOfYearDropDownX, regDateOfYear);
		sendkeysToElement(emailTxtX, regEmail);
		sendkeysToElement(companyNameTxtX, regCompanyName);
		sendkeysToElement(passwordTxtX, regPassword);
		sendkeysToElement(confirmPasswordTxtX, regPassword);
		clickToElemnet(registerBtnX);

		// Verify Account is Created Successfully
		System.out.println("TC01 : 2. Register message : " + getTextFromElement(registerSuccessMsgX));

		// Click Log Out Link
		System.out.println("TC01 : 3. Click Log Out Link");
		clickToElemnet(logOutLinkX);

		// Verify navigate to Home Page
		System.out.println("TC01 : 4. Navigate to Home Page : " + driver.getCurrentUrl());

	}

	@Test
	public void TC02_Login() {

		// Click to Login Link
		System.out.println("TC02 : 1. Click to Login Page");
		clickToElemnet(loginLinkX);

		// Verify Navigate to Login Page
		System.out.println("TC02 : 2. Login Page Display Status :" + checkElementDisplayed(loginPageX));

		// Login to Page
		sendkeysToElement(emailTxtX, regEmail);
		sendkeysToElement(passwordTxtX, regPassword);
		clickToElemnet(loginBtnX);

		// Verify Login Successfully
		System.out.println("TC02 : 3. Login Successfully Status : " + checkElementDisplayed(myAccountLinkX));
	}

	public void clickToElemnet(By by) {
		driver.findElement(by).click();

	}

	public void sendkeysToElement(By by, String value) {
		driver.findElement(by).sendKeys(value);
	}

	public void selectElementFromDropDown(By by, String value) {

		select = new Select(driver.findElement(by));
		select.selectByVisibleText(value);
	}

	public String getTextFromElement(By by) {
		String getText = driver.findElement(by).getText();
		return getText;
	}

	boolean checkElementDisplayed(By by) {
		boolean checkDisplay = driver.findElement(by).isDisplayed();
		return checkDisplay;
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	@AfterClass
	public void afterClass() {

		System.out.println("Post-condition: Close Firefox browser");
		driver.quit();
	}

}
