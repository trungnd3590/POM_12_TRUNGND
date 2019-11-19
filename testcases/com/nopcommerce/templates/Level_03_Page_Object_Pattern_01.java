package com.nopcommerce.templates;

import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Object_Pattern_01 {

	WebDriver driver;
	String regFirstName, regLastName, regDateOfBirth, regDateOfMonth, regDateOfYear, regEmail, regCompanyName,
			regPassword;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
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
		homePage = new HomePageObject(driver);
	}

	@Test
	public void TC01_RegisterToSystem() {

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.clickToMaleRadioButton();
		registerPage.inputToFirstnameTextbox(regFirstName);
		registerPage.inputToLastnameTextbox(regLastName);
		registerPage.selectDateOfBirthFromDropdown(regDateOfBirth);
		registerPage.selectDateOfMonthFromDropdown(regDateOfMonth);
		registerPage.selectDateOfYearFromDropdown(regDateOfYear);
		registerPage.inputToEmailTextbox(regEmail);
		registerPage.inputToCompanynameTextbox(regCompanyName);
		registerPage.inputToPasswordTextbox(regPassword);
		registerPage.inputToConfimPasswordTextbox(regPassword);
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
	}

	@Test
	public void TC02_LoginToSystem() {

		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(regEmail);
		loginPage.inputToPasswordTextbox(regPassword);
		loginPage.clickToLoginButton();

		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
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
