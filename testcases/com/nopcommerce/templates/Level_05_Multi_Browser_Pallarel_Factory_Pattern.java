package com.nopcommerce.templates;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_05_Multi_Browser_Pallarel_Factory_Pattern extends AbstractTest {
	private WebDriver driver;
	String regFirstName, regLastName, regDateOfBirth, regDateOfMonth, regDateOfYear, regEmail, regCompanyName,
			regPassword;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getMultiBrowserDriver(browserName);
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
	}

	@Test
	public void TC01_RegisterToSystem() {

		homePage = PageGeneratorManager.getHomePage(driver);

		registerPage = homePage.openRegisterPage();

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

		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC02_LoginToSystem() {

		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(regEmail);
		loginPage.inputToPasswordTextbox(regPassword);

		homePage = loginPage.openHomepageByClickToLoginButton();

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
