package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactoryPattern.DriverManager;
import driverFactoryPattern.DriverManagerFactory;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageUIs.AbstactPageUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class FE_02_Login extends AbstractTest {

	private WebDriver driver;
	String emailVal,passwordVal;
	
	private DriverManager driverManager;
	private HomePageObject homePage;
	private LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driverManager = DriverManagerFactory.getBrowserDriver(browserName);
		driver = driverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		String pageUrl = "https://demo.nopcommerce.com/";
		log.info("Pre-Condition 01 : Open Page Url " + pageUrl);
		driver.get(pageUrl);
	}

	@Test
	public void TC01_Login_With_Empty_Data() {

		emailVal = "";
		passwordVal = "";
		String emailErrMessage = "Please enter your email";
		
		log.info("TC01_Login_With_Empty_Data - Step 01 : Init HomePage");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("TC01_Login_With_Empty_Data - Step 02 : Open Login Page Through Header Login Link");
		homePage.openHeaderDynamicPage(AbstactPageUI.A_CLASS_HEADER_LOGIN_LINK);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("TC01_Login_With_Empty_Data - Step 03 : Login account With Empty Data");
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passwordVal);
		
		log.info("TC01_Login_With_Empty_Data - Step 04 : Click to Login Button");
		loginPage.clickToLoginButton();
		
		log.info("TC01_Login_With_Empty_Data - Step 05 : Verify Error Message in Email Field");
		verifyEquals(emailErrMessage, loginPage.getEmailErrorMessage());

	}

	@Test
	public void TC02_Login_With_Invalid_Email() {

		emailVal = "dfsdfsd@adfdasd";
		passwordVal = "123456";
		String emailErrMessage = "Wrong email";
		
		log.info("TC02_Login_With_Invalid_Email - Step 01 : Login account With Invalid Email");
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passwordVal);
		
		log.info("TC02_Login_With_Invalid_Email - Step 02 : Click to Login Button");
		loginPage.clickToLoginButton();

		log.info("TC02_Login_With_Invalid_Email - Step 03 : Verify Error Message in Email Field");
		verifyEquals(emailErrMessage, loginPage.getValidationErrorMessage());
	}

	@Test
	public void TC03_Login_With_Unregisted_Email() {

		emailVal = "auto01@gmail.com";
		passwordVal = "123456";
		String emailErrMessage = "Login was unsuccessful. Please correct the errors and try again.\n" + 
				"No customer account found";
		
		log.info("TC03_Login_With_Unregisted_Email - Step 01 : Login account With Unregisted Email");
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passwordVal);
		
		log.info("TC03_Login_With_Unregisted_Email - Step 02 : Click to Login Button");
		loginPage.clickToLoginButton();
		
		log.info("TC03_Login_With_Unregisted_Email - Step 03 : Verify Error Message in Email Field");
		verifyEquals(emailErrMessage, loginPage.getLoginCommonErrorMessage());
	
	}

	@Test
	public void TC04_Login_With_Empty_Password() {
		
		emailVal = "automationfc.vn@gmail.com";
		passwordVal = "";
		String emailErrMessage = "Login was unsuccessful. Please correct the errors and try again.\n" + 
				"The credentials provided are incorrect";
		
		log.info("TC04_Login_With_Empty_Password - Step 01 : Login account With Empty Password");
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passwordVal);
		
		log.info("TC04_Login_With_Empty_Password - Step 02 : Click to Login Button");
		loginPage.clickToLoginButton();
		
		log.info("TC04_Login_With_Empty_Password - Step 03 : Verify Error Message in Password Field");
		verifyEquals(emailErrMessage, loginPage.getLoginCommonErrorMessage());
	}


	@Test
	public void TC05_Login_With_Wrong_Password() {

		emailVal = "automationfc.vn@gmail.com";
		passwordVal = "1234567";
		String emailErrMessage = "Login was unsuccessful. Please correct the errors and try again.\n" + 
				"The credentials provided are incorrect";
		
		log.info("TC05_Login_With_Wrong_Password - Step 01 : Login account With Wrong Password");
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passwordVal);
		
		log.info("TC05_Login_With_Wrong_Password - Step 02 : Click to Login Button");
		loginPage.clickToLoginButton();
		
		log.info("TC05_Login_With_Wrong_Password - Step 03 : Verify Error Message in Password Field");
		verifyEquals(emailErrMessage, loginPage.getLoginCommonErrorMessage());

	}

	@Test
	public void TC06_Login_To_System() {

		emailVal = "auto@gmail.com";
		passwordVal = "123456";
	
		log.info("TC06_Login_To_System - Step 01 : Login account With Valid Data");
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passwordVal);
		
		log.info("TC06_Login_To_System - Step 02 : Click to Login Button and back To HomePage");
		loginPage.clickToLoginButton();
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("TC06_Login_To_System - Step 03 : Verify login success and show 'My Account' link in Header");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	
	@AfterClass
	public void afterClass() {
		driverManager.quitDriver();
	}

}
