package com.nopcommerce.templates;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_04_Page_Generator_Manager {
	WebDriver driver;
	String regFirstName, regLastName, regDateOfBirth, regDateOfMonth, regDateOfYear, regEmail, regCompanyName,
			regPassword;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {

		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\FirefoxLogs.txt");
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

		homePage = loginPage.clickToLoginButton();
		
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
