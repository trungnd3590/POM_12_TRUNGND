package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactoryPattern.DriverManager;
import driverFactoryPattern.DriverManagerFactory;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.SearchPageObject;
import pageUIs.AbstactPageUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class FE_04_Search extends AbstractTest {

	private WebDriver driver;
	private DriverManager driverManager;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private SearchPageObject searchPage;
	
	private String emailVal,passVal,searchMinimumLengthMessage,dataNotExist,noResult,lenovoProducKeyWord,lenovoThinkpad,lenovoIdeaCentre,thinkPadProducKeyWord;
	private String macBookProducKeyWord,categoryComputersVal,macBookPro,manufacturerHPVal,manufacturerAppleVal,minVal,maxVal;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driverManager = DriverManagerFactory.getBrowserDriver(browserName);
		driver = driverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		emailVal = "automationfc.vn@gmail.com";
		passVal = "123456";
		
		lenovoProducKeyWord = "Lenovo";
		thinkPadProducKeyWord = "Thinkpad X1 Carbon";
		macBookProducKeyWord = "Apple MacBook Pro";
		
		dataNotExist = "MacBook Pro 2050";
		lenovoThinkpad  = "Lenovo Thinkpad X1 Carbon Laptop";
		lenovoIdeaCentre = "Lenovo IdeaCentre 600 All-in-One PC";
		macBookPro  = "Apple MacBook Pro 13-inch";
		
		categoryComputersVal = "Computers";
		
		manufacturerHPVal = "HP";
		manufacturerAppleVal = "Apple";
		
		noResult  = "No products were found that matched your criteria.";
		searchMinimumLengthMessage = "Search term minimum length is 3 characters";
		
		String pageUrl = "https://demo.nopcommerce.com/";
		log.info("Pre-Condition 01 : Open Page Url " + pageUrl);
		driver.get(pageUrl);
	}

	@Test
	public void TC01_Search_With_Empty_Data() {
		
		log.info("TC01_Search_With_Empty_Data - Step 01 : Init HomePage");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("TC01_Search_With_Empty_Data - Step 02 : Open Login Page Through Header Login Link");
		homePage.openHeaderDynamicPage(AbstactPageUI.A_CLASS_HEADER_LOGIN_LINK);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("TC01_Search_With_Empty_Data - Step 03 : Login Account with valid Data");
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passVal);
		
		log.info("TC01_Search_With_Empty_Data - Step 04 : Click to Login Button");
		loginPage.clickToLoginButton();
		
		log.info("TC01_Search_With_Empty_Data - Step 05 : Verify login success and 'My Account' link is Displayed in Header");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("TC01_Search_With_Empty_Data - Step 06 : Open Search Page Through Footer Search Link");
		homePage.openFooterDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_FOOTER_SEARCH_PAGE_LINK);
		searchPage = PageGeneratorManager.getSearchPage(driver);
		
		log.info("TC01_Search_With_Empty_Data - Step 07 : Verify Search Page is Displayed");
		verifyTrue(searchPage.isSearchPageFormDisplayed());
		
		log.info("TC01_Search_With_Empty_Data - Step 08 : Click to Search Button with Empty Data");
		searchPage.clickToSearchButton();
		
		log.info("TC01_Search_With_Empty_Data - Step 09 : Verify Warning Message is Displayed");
		verifyEquals(searchMinimumLengthMessage, searchPage.getSearchWarningMesssageData());
	}
	
	@Test
	public void TC02_Search_With_Data_Not_Exist() {
		
		log.info("TC02_Search_With_Data_Not_Exist - Step 01 : Input Data Not Exist in Search Field");
		searchPage.inputToSearchTextbox(dataNotExist);
		
		log.info("TC02_Search_With_Data_Not_Exist - Step 02 : Click to Search Button");
		searchPage.clickToSearchButton();
		
		log.info("TC02_Search_With_Data_Not_Exist - Step 03 : Verify No Result Message is Displayed");
		verifyEquals(noResult, searchPage.getSearchNoResultMesssageData());
	}
	
	@Test
	public void TC03_Search_With_Relative_Product_Name() {
		
		log.info("TC03_Search_With_Relative_Product_Name - Step 01 : Input Data with Relative Product in Search Field");
		searchPage.inputToSearchTextbox(lenovoProducKeyWord);
		
		log.info("TC03_Search_With_Relative_Product_Name - Step 02 : Click to Search Button");
		searchPage.clickToSearchButton();
	
		log.info("TC03_Search_With_Relative_Product_Name - Step 03 : Verify Search Result Grid is Displayed");
		verifyTrue(searchPage.isSearchResultItemGridDisplayed());

		log.info("TC03_Search_With_Relative_Product_Name - Step 04 : Verify Number of Item and Name is match with search Data");
		verifyEquals(2, searchPage.countNumberOfItems());
		verifyTrue(searchPage.isSearchItemNameDisplayed(lenovoIdeaCentre));	
		verifyTrue(searchPage.isSearchItemNameDisplayed(lenovoThinkpad));
	}
	
	@Test
	public void TC04_Search_With_Absolute_ProductName() {
		
		log.info("TC04_Search_With_Absolute_ProductName - Step 01 : Input Data with Absolute Product in Search Field");
		searchPage.inputToSearchTextbox(thinkPadProducKeyWord);
		
		log.info("TC04_Search_With_Absolute_ProductName - Step 02 : Click to Search Button");
		searchPage.clickToSearchButton();
		
		log.info("TC04_Search_With_Absolute_ProductName - Step 03 : Verify Search Result Grid is Displayed");
		verifyTrue(searchPage.isSearchResultItemGridDisplayed());
		
		log.info("TC04_Search_With_Absolute_ProductName - Step 04 : Verify Number of Item and Name is match with search Data");
		verifyEquals(1, searchPage.countNumberOfItems());
		verifyTrue(searchPage.isSearchItemNameDisplayed(thinkPadProducKeyWord));
	
	}
	
	@Test
	public void TC05_Advance_Search_With_Parent_Categogies() {
		
		log.info("TC05_Advance_Search_With_Parent_Categogies - Step 01 : Input Data in Advance Search");
		searchPage.inputToSearchTextbox(macBookProducKeyWord);
		
		log.info("TC05_Advance_Search_With_Parent_Categogies - Step 02 : Click to Advance Search Check box");
		searchPage.clickToAdvanceSearchCheckbox();
		
		log.info("TC05_Advance_Search_With_Parent_Categogies - Step 03 : Verify Advance Search Form is Displayed");
		verifyTrue(searchPage.isSearchAdvanceFormDisplayed());
		
		log.info("TC05_Advance_Search_With_Parent_Categogies - Step 04 : Select Item from Category Dropdown List");
		searchPage.selectItemFromCategoryDropdown(categoryComputersVal);
		
		log.info("TC05_Advance_Search_With_Parent_Categogies - Step 05 : Click to Search Button");
		searchPage.clickToSearchButton();
		
		log.info("TC05_Advance_Search_With_Parent_Categogies - Step 06 : Verify No Result Message is Displayed");
		verifyEquals(noResult, searchPage.getSearchNoResultMesssageData());
		
	}
	
	@Test
	public void TC06_Advance_Search_With_Sub_Categories() {
		
		log.info("TC06_Advance_Search_With_Sub_Categories - Step 01 : Input Data in Advance Search");
		searchPage.inputToSearchTextbox(macBookProducKeyWord);
		
		log.info("TC06_Advance_Search_With_Sub_Categories - Step 02 : Click to Advance Search Check box");
		searchPage.clickToAdvanceSearchCheckbox();
		
		log.info("TC06_Advance_Search_With_Sub_Categories - Step 03 : Verify Advance Search Form is Displayed");
		verifyTrue(searchPage.isSearchAdvanceFormDisplayed());
		
		log.info("TC06_Advance_Search_With_Sub_Categories - Step 04 : Select Item from Category Dropdown List");
		searchPage.selectItemFromCategoryDropdown(categoryComputersVal);
		
		log.info("TC06_Advance_Search_With_Sub_Categories - Step 05 : Click to Advance Search Sub Category Check box");
		searchPage.clickToAdvanceSearchSubCategoryCheckbox();
		
		log.info("TC06_Advance_Search_With_Sub_Categories - Step 06 : Click to Search Button");
		searchPage.clickToSearchButton();
		
		log.info("TC06_Advance_Search_With_Sub_Categories - Step 06 : Verify Search Result Grid is Displayed");
		verifyTrue(searchPage.isSearchResultItemGridDisplayed());
		
		log.info("TC06_Advance_Search_With_Sub_Categories - Step 05 : Verify Number of Item and Name is match with search Data");
		verifyEquals(1, searchPage.countNumberOfItems());
		verifyTrue(searchPage.isSearchItemNameDisplayed(macBookPro));
	}
	
	@Test
	public void TC07_Advance_Search_With_Incorrect_Manufacturer() {
		
		log.info("TC07_Advance_Search_With_Incorrect_Manufacturer - Step 01 : Input Data in Advance Search");
		searchPage.inputToSearchTextbox(macBookProducKeyWord);
		
		log.info("TC07_Advance_Search_With_Incorrect_Manufacturer - Step 02 : Click to Advance Search Check box");
		searchPage.clickToAdvanceSearchCheckbox();
		
		log.info("TC07_Advance_Search_With_Incorrect_Manufacturer - Step 03 : Verify Advance Search Form is Displayed");
		verifyTrue(searchPage.isSearchAdvanceFormDisplayed());
		
		log.info("TC07_Advance_Search_With_Incorrect_Manufacturer - Step 04 : Select Item from Category Dropdown List");
		searchPage.selectItemFromCategoryDropdown(categoryComputersVal);
		
		log.info("TC07_Advance_Search_With_Incorrect_Manufacturer - Step 05 : Click to Advance Search Sub Category Check box");
		searchPage.clickToAdvanceSearchSubCategoryCheckbox();
		
		log.info("TC07_Advance_Search_With_Incorrect_Manufacturer - Step 06 : Select Item from  Manufacture Dropdown List");
		searchPage.selectItemFromManufacturerDropdown(manufacturerHPVal);
		
		log.info("TC07_Advance_Search_With_Incorrect_Manufacturer - Step 07 : Click to Search Button");
		searchPage.clickToSearchButton();
		
		log.info("TC07_Advance_Search_With_Incorrect_Manufacturer - Step 08 : Verify No Result Message is Displayed");
		verifyEquals(noResult, searchPage.getSearchNoResultMesssageData());
	}
	
	@Test
	public void TC08_Advance_Search_With_Correct_Manufacturer() {
	
		log.info("TC08_Advance_Search_With_Correct_Manufacturer - Step 01 : Input Data in Advance Search");
		searchPage.inputToSearchTextbox(macBookProducKeyWord);
		
		log.info("TC08_Advance_Search_With_Correct_Manufacturer - Step 02 : Click to Advance Search Check box");
		searchPage.clickToAdvanceSearchCheckbox();
		
		log.info("TC08_Advance_Search_With_Correct_Manufacturer - Step 03 : Verify Advance Search Form is Displayed");
		verifyTrue(searchPage.isSearchAdvanceFormDisplayed());
		
		log.info("TC08_Advance_Search_With_Correct_Manufacturer - Step 04 : Select Item from Category Dropdown List");
		searchPage.selectItemFromCategoryDropdown(categoryComputersVal);
		
		log.info("TC08_Advance_Search_With_Correct_Manufacturer - Step 05 : Click to Advance Search Sub Category Check box");
		searchPage.clickToAdvanceSearchSubCategoryCheckbox();
		
		log.info("TC08_Advance_Search_With_Correct_Manufacturer - Step 06 : Select Item from  Manufacture Dropdown List");
		searchPage.selectItemFromManufacturerDropdown(manufacturerAppleVal);
		
		log.info("TC08_Advance_Search_With_Correct_Manufacturer - Step 07 : Click to Search Button");
		searchPage.clickToSearchButton();
		
		log.info("TC08_Advance_Search_With_Correct_Manufacturer - Step 08 : Verify Search Result Grid is Displayed");
		verifyTrue(searchPage.isSearchResultItemGridDisplayed());
		
		log.info("TC08_Advance_Search_With_Correct_Manufacturer - Step 09 : Verify Number of Item and Name is match with search Data");
		verifyEquals(1, searchPage.countNumberOfItems());
		verifyTrue(searchPage.isSearchItemNameDisplayed(macBookPro));
	}
	
	@Test
	public void TC09_Advance_Search_With_Price_Range() {
		
		minVal = "1000";
		maxVal = "2000";
	
		log.info("TC09_Advance_Search_With_Price_Range - Step 01 : Input Data in Advance Search");
		searchPage.inputToSearchTextbox(macBookProducKeyWord);
		
		log.info("TC09_Advance_Search_With_Price_Range - Step 02 : Click to Advance Search Check box");
		searchPage.clickToAdvanceSearchCheckbox();
		
		log.info("TC09_Advance_Search_With_Price_Range - Step 03 : Verify Advance Search Form is Displayed");
		verifyTrue(searchPage.isSearchAdvanceFormDisplayed());
		
		log.info("TC09_Advance_Search_With_Price_Range - Step 04 : Select Item from Category Dropdown List");
		searchPage.selectItemFromCategoryDropdown(categoryComputersVal);
		
		log.info("TC09_Advance_Search_With_Price_Range - Step 05 : Click to Advance Search Sub Category Check box");
		searchPage.clickToAdvanceSearchSubCategoryCheckbox();
		
		log.info("TC09_Advance_Search_With_Price_Range - Step 06 : Select Item from  Manufacture Dropdown List");
		searchPage.selectItemFromManufacturerDropdown(manufacturerAppleVal);
		
		log.info("TC09_Advance_Search_With_Price_Range - Step 07 : Input Price in Ranger Min - Max Text Box");
		searchPage.inputToMinimumPriceRangeTextbox(minVal);
		searchPage.inputToMaximumPriceRangeTextbox(maxVal);
		
		log.info("TC09_Advance_Search_With_Price_Range - Step 08 : Click to Search Button");
		searchPage.clickToSearchButton();
		
		log.info("TC09_Advance_Search_With_Price_Range - Step 09 : Verify Search Result Grid is Displayed");
		verifyTrue(searchPage.isSearchResultItemGridDisplayed());
		
		log.info("TC09_Advance_Search_With_Price_Range - Step 10 : Verify Number of Item and Name is match with search Data");
		verifyEquals(1, searchPage.countNumberOfItems());
		verifyTrue(searchPage.isSearchItemNameDisplayed(macBookPro));
	}
	
	@Test
	public void TC10_Advance_Search_With_Max_Price_Range_Lower_Than_Product_Price() {
		
		minVal = "1000";
		maxVal = "1700";
		noResult = "No products were found that matched your criteria.";
	
		log.info("TC10_Advance_Search_With_Max_Price_Range_Lower_Than_Product_Price - Step 01 : Input Data in Advance Search");
		searchPage.inputToSearchTextbox(macBookProducKeyWord);
		
		log.info("TC10_Advance_Search_With_Max_Price_Range_Lower_Than_Product_Price - Step 02 : Click to Advance Search Check box");
		searchPage.clickToAdvanceSearchCheckbox();
		
		log.info("TC10_Advance_Search_With_Max_Price_Range_Lower_Than_Product_Price - Step 03 : Verify Advance Search Form is Displayed");
		verifyTrue(searchPage.isSearchAdvanceFormDisplayed());
		
		log.info("TC10_Advance_Search_With_Max_Price_Range_Lower_Than_Product_Price - Step 04 : Select Item from Category Dropdown List");
		searchPage.selectItemFromCategoryDropdown(categoryComputersVal);
		
		log.info("TC10_Advance_Search_With_Max_Price_Range_Lower_Than_Product_Price - Step 05 : Click to Advance Search Sub Category Check box");
		searchPage.clickToAdvanceSearchSubCategoryCheckbox();
		
		log.info("TC10_Advance_Search_With_Max_Price_Range_Lower_Than_Product_Price - Step 06 : Select Item from  Manufacture Dropdown List");
		searchPage.selectItemFromManufacturerDropdown(manufacturerAppleVal);
		
		log.info("TC10_Advance_Search_With_Max_Price_Range_Lower_Than_Product_Price - Step 07 : Input Price in Ranger Min - Max Text Box");
		searchPage.inputToMinimumPriceRangeTextbox(minVal);
		searchPage.inputToMaximumPriceRangeTextbox(maxVal);
		
		log.info("TC10_Advance_Search_With_Max_Price_Range_Lower_Than_Product_Price - Step 08 : Click to Search Button");
		searchPage.clickToSearchButton();
		
		log.info("TC10_Advance_Search_With_Max_Price_Range_Lower_Than_Product_Price - Step 09 : Verify No Result Message is Displayed");
		verifyEquals(noResult, searchPage.getSearchNoResultMesssageData());		
	}
	
	@Test
	public void TC11_Advance_Search_With_Min_Price_Range_Lower_Than_Product_Price() {

		minVal = "1900";
		maxVal = "5000";
	
		log.info("TC11_Advance_Search_With_Min_Price_Range_Lower_Than_Product_Price - Step 01 : Input Data in Advance Search");
		searchPage.inputToSearchTextbox(macBookProducKeyWord);
		
		log.info("TC11_Advance_Search_With_Min_Price_Range_Lower_Than_Product_Price - Step 02 : Click to Advance Search Check box");
		searchPage.clickToAdvanceSearchCheckbox();
		
		log.info("TC11_Advance_Search_With_Min_Price_Range_Lower_Than_Product_Price - Step 03 : Verify Advance Search Form is Displayed");
		verifyTrue(searchPage.isSearchAdvanceFormDisplayed());
		
		log.info("TC11_Advance_Search_With_Min_Price_Range_Lower_Than_Product_Price - Step 04 : Select Item from Category Dropdown List");
		searchPage.selectItemFromCategoryDropdown(categoryComputersVal);
		
		log.info("TC11_Advance_Search_With_Min_Price_Range_Lower_Than_Product_Price - Step 05 : Click to Advance Search Sub Category Check box");
		searchPage.clickToAdvanceSearchSubCategoryCheckbox();
		
		log.info("TC11_Advance_Search_With_Min_Price_Range_Lower_Than_Product_Price - Step 06 : Select Item from  Manufacture Dropdown List");
		searchPage.selectItemFromManufacturerDropdown(manufacturerAppleVal);
		
		log.info("TC11_Advance_Search_With_Min_Price_Range_Lower_Than_Product_Price - Step 07 : Input Price in Ranger Min - Max Text Box");
		searchPage.inputToMinimumPriceRangeTextbox(minVal);
		searchPage.inputToMaximumPriceRangeTextbox(maxVal);
		
		log.info("TC11_Advance_Search_With_Min_Price_Range_Lower_Than_Product_Price - Step 08 : Click to Search Button");
		searchPage.clickToSearchButton();
		
		log.info("TC11_Advance_Search_With_Min_Price_Range_Lower_Than_Product_Price - Step 09 : Verify No Result Message is Displayed");
		verifyEquals(noResult, searchPage.getSearchNoResultMesssageData());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
