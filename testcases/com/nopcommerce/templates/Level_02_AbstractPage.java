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

import commons.AbstractPage;

public class Level_02_AbstractPage {

	WebDriver driver;
	String regFirstName, regLastName, regDateOfBirth, regDateOfMonth, regDateOfYear, regEmail, regCompanyName,
			regPassword;
	AbstractPage absPage;

	String registerLinkX = "//a[@class='ico-register']";
	String registerPageX = "//div[@class='page registration-page']";
	String genderMaleRadioBtnX = "//input[@id='gender-male']";
	String firstNameTxtX = "//input[@id='FirstName']";
	String lastNameTxtX = "//input[@id='LastName']";
	String dateOfBirthDropDownX = "//select[@name='DateOfBirthDay']";
	String dateOfMonthDropDownX = "//select[@name='DateOfBirthMonth']";
	String dateOfYearDropDownX = "//select[@name='DateOfBirthYear']";
	String emailTxtX = "//input[@id='Email']";
	String companyNameTxtX = "//input[@id='Company']";
	String passwordTxtX = "//input[@id='Password']";
	String confirmPasswordTxtX = "//input[@id='ConfirmPassword']";
	String registerBtnX = "//input[@id='register-button']";

	String registerSuccessMsgX = "//div[@class='result']";
	String logOutLinkX = "//a[@class='ico-logout']";

	String loginLinkX = "//a[@class='ico-login']";
	String loginPageX = "//div[@class='page login-page']";
	String loginBtnX = "//input[@class='button-1 login-button']";
	String myAccountLinkX = "//a[@class='ico-account']";

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		absPage = new AbstractPage(driver);
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
		absPage.openUrl(pageUrl);
		
	}

	@Test
	public void TC01_Register() {

		absPage.clickToElement(registerLinkX);

		absPage.clickToElement(genderMaleRadioBtnX);
		absPage.sendkeysToElement(firstNameTxtX, regFirstName);
		absPage.sendkeysToElement(lastNameTxtX, regLastName);
		absPage.selectItemInDropdown(dateOfBirthDropDownX, regDateOfBirth);
		absPage.selectItemInDropdown(dateOfMonthDropDownX, regDateOfMonth);
		absPage.selectItemInDropdown(dateOfYearDropDownX, regDateOfYear);
		absPage.sendkeysToElement(emailTxtX, regEmail);
		absPage.sendkeysToElement(companyNameTxtX, regCompanyName);
		absPage.sendkeysToElement(passwordTxtX, regPassword);
		absPage.sendkeysToElement(confirmPasswordTxtX, regPassword);
		absPage.clickToElement(registerBtnX);

		System.out.println("TC01 : 2. Register message : " + absPage.getTextElement(registerSuccessMsgX));

		System.out.println("TC01 : 3. Click Log Out Link");
		absPage.clickToElement(logOutLinkX);

		System.out.println("TC01 : 4. Navigate to Home Page : " + absPage.getPageCurrentUrl());

	}

	@Test
	public void TC02_Login() {

		absPage.clickToElement(loginLinkX);

		System.out.println("TC02 : 2. Login Page Display Status :" + absPage.elementIsDisplayed(loginPageX));

		absPage.sendkeysToElement(emailTxtX, regEmail);
		absPage.sendkeysToElement(passwordTxtX, regPassword);
		absPage.clickToElement(loginBtnX);

		// Verify Login Successfully
		System.out.println("TC02 : 3. Login Successfully Status : " + absPage.elementIsDisplayed(myAccountLinkX));
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
