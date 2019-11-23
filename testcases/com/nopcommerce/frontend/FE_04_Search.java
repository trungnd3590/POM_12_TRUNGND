package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactoryPattern.DriverManager;
import driverFactoryPattern.DriverManagerFactory;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.SearchPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class FE_04_Search extends AbstractTest {

	private WebDriver driver;
	private DriverManager driverManager;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private SearchPageObject searchPage;
	
	String emailVal,passVal;

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
	public void TC01_Search_With_Empty_Data() {
		
		emailVal = "auto@gmail.com";
		passVal = "1234567";
		String searchWarningMessage = "Search term minimum length is 3 characters";
		
		homePage = PageGeneratorManager.getHomePage(driver);
		loginPage = homePage.openLoginPage();
		
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passVal);
		homePage = loginPage.clickToLoginButton();
	
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		searchPage = homePage.openSearchPage();
		Assert.assertTrue(searchPage.isSearchPageFormDisplayed());
		
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchWarningMessage, searchPage.getSearchWarningMesssageData());
	}
	
	@Test
	public void TC02_Search_With_Data_Not_Exist() {
		
		String dataNotExist = "MacBook Pro 2050";
		String noResult = "No products were found that matched your criteria.";
		
		searchPage.inputToSearchTextbox(dataNotExist);
		searchPage.clickToSearchButton();
		
		Assert.assertEquals(noResult, searchPage.getSearchNoResultMesssageData());
	}
	
	@Test
	public void TC03_Search_With_Relative_Product_Name() throws Exception {
		
		String producKeyWord = "Lenovo";
		String lenovoThinkpad  = "Lenovo Thinkpad X1 Carbon Laptop";
		String lenovoIdeaCentre = "Lenovo IdeaCentre 600 All-in-One PC";
		
		searchPage.inputToSearchTextbox(producKeyWord);
		searchPage.clickToSearchButton();
	
		Assert.assertTrue(searchPage.isSearchResultItemGridDisplayed());

		Assert.assertEquals(2, searchPage.countNumberOfItems());

		Assert.assertTrue(searchPage.isSearchItemNameDisplayed(lenovoIdeaCentre));	
		Assert.assertTrue(searchPage.isSearchItemNameDisplayed(lenovoThinkpad));
	}
	
	@Test
	public void TC04_Search_With_Absolute_ProductName() {
		
		String producKeyWord = "Thinkpad X1 Carbon";
		
		searchPage.inputToSearchTextbox(producKeyWord);
		searchPage.clickToSearchButton();
		
		Assert.assertTrue(searchPage.isSearchResultItemGridDisplayed());
		
		//Assert.assertEquals(1, searchPage.countNumberOfItems());
		System.out.println("TC04 : countNumberOfItems :"+searchPage.countNumberOfItems());
		
		//Assert.assertTrue(searchPage.isSearchItemNameDisplayed(producKeyWord));
		System.out.println("TC04 : isSearchItemNameDisplayed(producKeyWord) :"+searchPage.isSearchItemNameDisplayed(producKeyWord));
	}
	
	@Test
	public void TC05_Advance_Search_With_Parent_Categogies() {
		
		String producKeyWord = "Apple MacBook Pro";
		String itemVal = "Computers";
		String noResult = "No products were found that matched your criteria.";
		
		searchPage.inputToSearchTextbox(producKeyWord);
		searchPage.clickToAdvanceSearchCheckbox();
		Assert.assertTrue(searchPage.isSearchAdvanceFormDisplayed());
		searchPage.selectItemFromCategoryDropdown(itemVal);
		searchPage.clickToSearchButton();
		
		Assert.assertEquals(noResult, searchPage.getSearchNoResultMesssageData());
		
	}
	
	@Test
	public void TC06_Advance_Search_With_Sub_Categories() {
		
		String producKeyWord = "Apple MacBook Pro";
		String macBookPro  = "Apple MacBook Pro 13-inch";
		String itemVal = "Computers";
		
		searchPage.inputToSearchTextbox(producKeyWord);
		searchPage.clickToAdvanceSearchCheckbox();
		Assert.assertTrue(searchPage.isSearchAdvanceFormDisplayed());
		searchPage.selectItemFromCategoryDropdown(itemVal);
		searchPage.clickToAdvanceSearchSubCategoryCheckbox();
		searchPage.clickToSearchButton();
		
		Assert.assertTrue(searchPage.isSearchResultItemGridDisplayed());
		
		Assert.assertEquals(1, searchPage.countNumberOfItems());
		Assert.assertTrue(searchPage.isSearchItemNameDisplayed(macBookPro));
	}
	
	@Test
	public void TC07_Advance_Search_With_Incorrect_Manufacturer() {
		
		String producKeyWord = "Apple MacBook Pro";
		String categoryItemVal = "Computers";
		String manufacturerItemVal = "HP";
		String noResult = "No products were found that matched your criteria.";
		
		searchPage.inputToSearchTextbox(producKeyWord);
		searchPage.clickToAdvanceSearchCheckbox();
		Assert.assertTrue(searchPage.isSearchAdvanceFormDisplayed());
		searchPage.selectItemFromCategoryDropdown(categoryItemVal);
		searchPage.clickToAdvanceSearchSubCategoryCheckbox();
		searchPage.selectItemFromManufacturerDropdown(manufacturerItemVal);
		searchPage.clickToSearchButton();
		
		Assert.assertEquals(noResult, searchPage.getSearchNoResultMesssageData());
	}
	
	@Test
	public void TC08_Advance_Search_With_Correct_Manufacturer() {
		
		String producKeyWord = "Apple MacBook Pro";
		String macBookPro  = "Apple MacBook Pro 13-inch";
		String categoryItemVal = "Computers";
		String manufacturerItemVal = "Apple";
	
		searchPage.inputToSearchTextbox(producKeyWord);
		searchPage.clickToAdvanceSearchCheckbox();
		Assert.assertTrue(searchPage.isSearchAdvanceFormDisplayed());
		searchPage.selectItemFromCategoryDropdown(categoryItemVal);
		searchPage.clickToAdvanceSearchSubCategoryCheckbox();
		searchPage.selectItemFromManufacturerDropdown(manufacturerItemVal);
		searchPage.clickToSearchButton();
		
		Assert.assertTrue(searchPage.isSearchResultItemGridDisplayed());
		
		Assert.assertEquals(1, searchPage.countNumberOfItems());
		Assert.assertTrue(searchPage.isSearchItemNameDisplayed(macBookPro));
	}
	
	@Test
	public void TC09_Advance_Search_With_Price_Range() {
		
		String producKeyWord = "Apple MacBook Pro";
		String macBookPro  = "Apple MacBook Pro 13-inch";
		String categoryItemVal = "Computers";
		String manufacturerItemVal = "Apple";
		String minVal = "1000";
		String maxVal = "2000";
	
		searchPage.inputToSearchTextbox(producKeyWord);
		searchPage.clickToAdvanceSearchCheckbox();
		Assert.assertTrue(searchPage.isSearchAdvanceFormDisplayed());
		searchPage.selectItemFromCategoryDropdown(categoryItemVal);
		searchPage.clickToAdvanceSearchSubCategoryCheckbox();
		searchPage.selectItemFromManufacturerDropdown(manufacturerItemVal);
		searchPage.inputToMinimumPriceRangeTextbox(minVal);
		searchPage.inputToMaximumPriceRangeTextbox(maxVal);
		searchPage.clickToSearchButton();
		
		Assert.assertTrue(searchPage.isSearchResultItemGridDisplayed());
		
		Assert.assertEquals(1, searchPage.countNumberOfItems());
		Assert.assertTrue(searchPage.isSearchItemNameDisplayed(macBookPro));
	}
	
	@Test
	public void TC10_Advance_Search_With_Max_Price_Range_Lower_Than_Product_Price() {
		
		String producKeyWord = "Apple MacBook Pro";
		String categoryItemVal = "Computers";
		String manufacturerItemVal = "Apple";
		String minVal = "1000";
		String maxVal = "1700";
		String noResult = "No products were found that matched your criteria.";
	
		searchPage.inputToSearchTextbox(producKeyWord);
		searchPage.clickToAdvanceSearchCheckbox();
		Assert.assertTrue(searchPage.isSearchAdvanceFormDisplayed());
		searchPage.selectItemFromCategoryDropdown(categoryItemVal);
		searchPage.clickToAdvanceSearchSubCategoryCheckbox();
		searchPage.selectItemFromManufacturerDropdown(manufacturerItemVal);
		searchPage.inputToMinimumPriceRangeTextbox(minVal);
		searchPage.inputToMaximumPriceRangeTextbox(maxVal);
		searchPage.clickToSearchButton();
		
		Assert.assertEquals(noResult, searchPage.getSearchNoResultMesssageData());
		
	}
	
	@Test
	public void TC11_Advance_Search_With_Min_Price_Range_Lower_Than_Product_Price() {
		
		String producKeyWord = "Apple MacBook Pro";
		String categoryItemVal = "Computers";
		String manufacturerItemVal = "Apple";
		String minVal = "1900";
		String maxVal = "5000";
		String noResult = "No products were found that matched your criteria.";
	
		searchPage.inputToSearchTextbox(producKeyWord);
		searchPage.clickToAdvanceSearchCheckbox();
		Assert.assertTrue(searchPage.isSearchAdvanceFormDisplayed());
		searchPage.selectItemFromCategoryDropdown(categoryItemVal);
		searchPage.clickToAdvanceSearchSubCategoryCheckbox();
		searchPage.selectItemFromManufacturerDropdown(manufacturerItemVal);
		searchPage.inputToMinimumPriceRangeTextbox(minVal);
		searchPage.inputToMaximumPriceRangeTextbox(maxVal);
		searchPage.clickToSearchButton();
		
		Assert.assertEquals(noResult, searchPage.getSearchNoResultMesssageData());
	}

	@AfterClass
	public void afterClass() {
		driverManager.quitDriver();
	}

}
