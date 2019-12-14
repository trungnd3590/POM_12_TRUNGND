package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactoryPattern.DriverManager;
import driverFactoryPattern.DriverManagerFactory;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NoteBooksPageObject;
import pageUIs.AbstactPageUI;
import pageUIs.HomePageUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class FE_05_Sort_Display_Paging extends AbstractTest {

	private WebDriver driver;
	private DriverManager driverManager;
	private HomePageObject homePage;
	private NoteBooksPageObject noteBooksPage;
	private LoginPageObject loginPage;
	
	String emailVal,passVal;

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
	public void TC01_Sort_Name_A_To_Z() {
		
		emailVal = "auto01@gmail.com";
		passVal = "123456";
		String sortAtoZ = "Name: A to Z";
		
		log.info("TC01_Sort_Name_A_To_Z - Step 01 : Init HomePage");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("TC01_Sort_Name_A_To_Z - Step 02 : Open Login Page Through Header Login Link");
		homePage.openHeaderDynamicPage(AbstactPageUI.A_CLASS_HEADER_LOGIN_LINK);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("TC01_Sort_Name_A_To_Z - Step 03 : Login Account with valid Data");
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passVal);
		
		log.info("TC01_Sort_Name_A_To_Z - Step 04 : Click to Login Button");
		loginPage.clickToLoginButton();
		
		log.info("TC01_Sort_Name_A_To_Z - Step 05 : Verify login success and 'My Account' link is Displayed in Header");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("TC01_Sort_Name_A_To_Z - Step 06 : Hover to 'Computers' Menu and Click to 'Notebooks' link");
		homePage.hoverToMenuBarName(HomePageUI.A_CONTAINS_TEXT_MENUBAR_COMPUTER);
		homePage.openMenuBarDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_NOTEBOOKS_LINK);
		
		log.info("TC01_Sort_Name_A_To_Z - Step 07 : Open and Verify Notebook Page is Displayed");
		noteBooksPage = PageGeneratorManager.getNoteBooksPage(driver);
		verifyTrue(noteBooksPage.isNoteBookPageDisplayed());
		
		log.info("TC01_Sort_Name_A_To_Z - Step 08 : Sort Name A to Z from Sort Dropdown List");
		noteBooksPage.selectSortFromDropdown(sortAtoZ);
		
		log.info("TC01_Sort_Name_A_To_Z - Step 09 : Verify Product Name is sorted A to Z");
		verifyTrue(noteBooksPage.isProductNameSortedAtoZ());
	}
	
	@Test
	public void TC02_Sort_Name_Z_To_A() {
		
		String sortZtoA = "Name: Z to A";
		
		log.info("TC02_Sort_Name_Z_To_A - Step 01 : Sort Name Z to A from Sort Dropdown List");
		noteBooksPage.selectSortFromDropdown(sortZtoA);
		
		log.info("TC02_Sort_Name_Z_To_A - Step 02 : Verify Product Name is sorted Z to A");
		verifyTrue(noteBooksPage.isProductNameSortedZtoA());
	}
	
	@Test
	public void TC03_Sort_Price_Low_To_High() {
		
		String sortPriceLowToHigh = "Price: Low to High";
		
		log.info("TC03_Sort_Price_Low_To_High - Step 01 : Sort Price Low to High from Sort Dropdown List");
		noteBooksPage.selectSortFromDropdown(sortPriceLowToHigh);
		
		log.info("TC03_Sort_Price_Low_To_High - Step 02 : Verify Product Price is sorted Low to High");
		verifyTrue(noteBooksPage.isProductPriceSortedLowToHigh());
	}
		
	@Test
	public void TC04_Sort_Price_High_To_Low() {
		
		String sortPriceHighToLow = "Price: High to Low";
		
		log.info("TC04_Sort_Price_High_To_Low - Step 01 : Sort Price High to Low from Sort Dropdown List");
		noteBooksPage.selectSortFromDropdown(sortPriceHighToLow);
		
		log.info("TC04_Sort_Price_High_To_Low - Step 02 : Verify Product Price is sorted High to Low");
		verifyTrue(noteBooksPage.isProductPriceSortedHighToLow());
	}
	
	@Test
	public void TC05_Display_Three_Products_Per_Page() {
		
		String dropdownVal = "3";
		int numberPerPage = 3;
		
		log.info("TC05_Display_Three_Products_Per_Page - Step 01 : Input 3 in Product Display Per Page Dropdown List");
		noteBooksPage.selectProductDisplayPerPageFromDropdown(dropdownVal);
		
		log.info("TC05_Display_Three_Products_Per_Page - Step 02 : Verify numer of Products is Showed 3 Products Per Page");
		verifyTrue(noteBooksPage.isNumberOfProductsPerPageMatched(numberPerPage));
		
		log.info("TC05_Display_Three_Products_Per_Page - Step 03 : Verify Paging is Displayed");
		verifyTrue(noteBooksPage.isPagingDisplayed());
		verifyTrue(noteBooksPage.isNextPageButtonDisplayed());
		
		log.info("TC05_Display_Three_Products_Per_Page - Step 04 : Click to Page Two");
		noteBooksPage.clickToPageTwo();
		
		log.info("TC05_Display_Three_Products_Per_Page - Step 05 : Verify numer of Products is Showed 3 Or less than 3 Products Per Page");
		verifyTrue(noteBooksPage.isNumberOfProductsPerPageMatched(numberPerPage));
		
		log.info("TC05_Display_Three_Products_Per_Page - Step 06 : Verify Previous Page Button is Displayed");
		verifyTrue(noteBooksPage.isPreviousPageButtonDisplayed());
	}
	
	@Test
	public void TC06_Display_Six_Products_Per_Page() {
		
		String dropdownVal = "6";
		int numberPerPage = 6;
		
		log.info("TC06_Display_Six_Products_Per_Page - Step 01 : Input 6 in Product Display Per Page Dropdown List");
		noteBooksPage.selectProductDisplayPerPageFromDropdown(dropdownVal);
		
		log.info("TC06_Display_Six_Products_Per_Page - Step 02 : Verify numer of Products is Showed 6 Products Per Page");
		verifyTrue(noteBooksPage.isNumberOfProductsPerPageMatched(numberPerPage));
		
		log.info("TC06_Display_Six_Products_Per_Page - Step 03 : Verify Paging is Not Displayed");
		verifyFalse(noteBooksPage.isPagingNotDisplayed());
	}
	
	@Test
	public void TC07_Display_Nine_Products_Per_Page() {
		
		String dropdownVal = "9";
		int numberPerPage = 9;
		
		log.info("TC07_Display_Nine_Products_Per_Page - Step 01 : Input 9 in Product Display Per Page Dropdown List");
		noteBooksPage.selectProductDisplayPerPageFromDropdown(dropdownVal);
		
		log.info("TC07_Display_Nine_Products_Per_Page - Step 02 : Verify numer of Products is Showed 9 Or less than 9 Products Per Page");
		verifyTrue(noteBooksPage.isNumberOfProductsPerPageMatched(numberPerPage));
		
		log.info("TC07_Display_Nine_Products_Per_Page - Step 03 : Verify Paging is Not Displayed");
		verifyFalse(noteBooksPage.isPagingNotDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driverManager.quitDriver();
	}

}
