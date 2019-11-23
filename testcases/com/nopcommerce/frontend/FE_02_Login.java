package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactoryPattern.DriverManager;
import driverFactoryPattern.DriverManagerFactory;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
		driver.get(pageUrl);
	}

	@Test
	public void TC01_Login_With_Empty_Data() {

		emailVal = "";
		passwordVal = "";
		String emailErrMessage = "Please enter your email";
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		loginPage = homePage.openLoginPage();
		
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passwordVal);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(emailErrMessage, loginPage.getEmailErrorMessage());

	}

	@Test
	public void TC02_Login_With_Invalid_Email() {

		emailVal = "dfsdfsd@adfdasd";
		passwordVal = "123456";
		String emailErrMessage = "Wrong email";
		
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passwordVal);
		loginPage.clickToLoginButton();

		Assert.assertEquals(emailErrMessage, loginPage.getEmailErrorMessage());
	}

	@Test
	public void TC03_Login_With_Unregisted_Email() {

		emailVal = "auto@gmail.com";
		passwordVal = "123456";
		String emailErrMessage = "Login was unsuccessful. Please correct the errors and try again.\n" + 
				"No customer account found";
		
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passwordVal);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(emailErrMessage, loginPage.getUnregistedEmailErrorMessage());
	
	}

	@Test
	public void TC04_Login_With_Empty_Password() {
		
		emailVal = "automationfc.vn@gmail.com";
		passwordVal = "";
		String emailErrMessage = "Login was unsuccessful. Please correct the errors and try again.\n" + 
				"The credentials provided are incorrect";
		
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passwordVal);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(emailErrMessage, loginPage.getValidationErrorMessage());
	}


	@Test
	public void TC05_Login_With_Wrong_Password() {

		emailVal = "automationfc.vn@gmail.com";
		passwordVal = "1234567";
		String emailErrMessage = "Login was unsuccessful. Please correct the errors and try again.\n" + 
				"The credentials provided are incorrect";
		
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passwordVal);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(emailErrMessage, loginPage.getValidationErrorMessage());

	}

	@Test
	public void TC06_Login_To_System() {

		emailVal = "automationfc.vn@gmail.com";
		passwordVal = "123456";
	
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passwordVal);
		homePage = loginPage.clickToLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	
	@AfterClass
	public void afterClass() {
		driverManager.quitDriver();
	}

}
