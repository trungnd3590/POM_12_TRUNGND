package com.nopcommerce.backend;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactoryPattern.DriverManager;
import driverFactoryPattern.DriverManagerFactory;
import pageObjects.AdminLoginPageObject;
import pageObjects.AdminPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class FE_08_Admin extends AbstractTest {

	private WebDriver driver;
	private DriverManager driverManager;
	private AdminLoginPageObject adminLoginPage;
	private AdminPageObject adminPage;
	
	private int ranCusVal, ranEditVal, ranAddVal;
	private String emailVal,passwordVal;
	private String cusEmailVal,cusPassVal,cusFirstnameVal,cusLastnameVal,cusDateOfBirthVal,cusCompanynameVal,cusRolesVal,cusVendorVal,cusCommentVal;
	private String editEmailVal,editFirstnameVal,editLastnameVal,editDateOfBirthVal,editCompanynameVal,editRolesVal,editVendorVal,editCommentVal;
	private String addFirstNameVal, addLastNameVal,addEmailVal, addCompanyNameVal, addCountryVal, addStateVal, addCityNameVal,  addAddress01Val, addAddress02Val, addZipcodeVal, addPhoneNumberVal, addFaxNumberVal;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driverManager = DriverManagerFactory.getBrowserDriver(browserName);
		driver = driverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		emailVal = "admin@yourstore.com";
		passwordVal = "admin";
		
		ranCusVal = randomNumber();
		cusEmailVal = "john_wick_" + ranCusVal + "@gmail.com";
		cusPassVal = "" + ranCusVal;
		cusFirstnameVal = "John";
		cusLastnameVal = "Wick" + ranCusVal;
		cusDateOfBirthVal = "12/10/2010";
		cusCompanynameVal = "John Wick" + ranCusVal;
		cusRolesVal = "Guests";
		cusVendorVal = "Vendor 2";
		cusCommentVal = ranCusVal + " "+ ranCusVal +" "+ ranCusVal +" "+ ranCusVal;
		
		ranEditVal = randomNumber();
		editEmailVal = "spider_man_"+ ranEditVal +"@gmail.com" ;
		editFirstnameVal = "Spider" ;
		editLastnameVal = "Man"+ ranEditVal;
		editDateOfBirthVal = "10/12/2010";
		editCompanynameVal = "Spider Man"+ ranEditVal;
		editRolesVal = "Vendors";
		editVendorVal = "Vendor 1";
		editCommentVal = ranEditVal +" "+ ranEditVal +" "+ ranEditVal +" "+ ranEditVal;
		
		ranAddVal = randomNumber();
		addFirstNameVal = "Doctor"; 
		addLastNameVal = "Strange"+ ranAddVal; 
		addEmailVal = "doctor_strange_"+ ranAddVal +"@gmail.com";
		addCompanyNameVal = "Marvel Entertainment"+ ranAddVal; 
		addCountryVal = "Viet Nam"; 
		addStateVal = "Other (Non US)"; 
		addCityNameVal = "Ha Noi";  
		addAddress01Val = ranAddVal +" Tran Thai Tong"; 
		addAddress02Val = ranAddVal +" Nguyen Huy Tuong"; 
		addZipcodeVal = "10166"; 
		addPhoneNumberVal = "0987"+ ranAddVal; 
		addFaxNumberVal = "0123"+ ranAddVal;
		
		String pageUrl = "https://admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";
		log.info("Pre-Condition 01 : Open Admin Page Url " + pageUrl);
		driver.get(pageUrl);
		
		log.info("Pre-Condition 02 : Init Admin Login Page");
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Pre-Condition 03 : Login to Admin Page");
		adminLoginPage.inputToAdminEmailTextbox(emailVal);
		adminLoginPage.inputToAdminPasswordTextbox(passwordVal);
		adminLoginPage.clickToAdminLoginButton();
		
		log.info("Pre-Condition 04 : Verify Login to Admin Page successfully");
		adminPage = PageGeneratorManager.getAdminPage(driver);
		verifyTrue(adminPage.isAdminLogoutLinkDisplayed());
	}

	@Test
	public void TC01_Search_With_ProductName() {
		
		String productsFormTitle = "Products";
		String lenovoIdeaCentreProductName = "Lenovo IdeaCentre 600 All-in-One PC";
		String lenovoIdeaCentreSKU = "LE_IC_600";
		String lenovoIdeaCentreUnitPrice = "500";
		String lenovoIdeaCentreQuantiy = "10000";
		String lenovoIdeaCentreProductType = "Simple";
		
		log.info("TC01_Search_With_ProductName - Step 01 : Open Admin Products Form");
		adminPage.clickToSidebarCatalogMenu();
		adminPage.clickToSidebarProductsSubMenu();
		
		log.info("TC01_Search_With_ProductName - Step 02 : Verify Admin Products Form is Displayed");
		verifyEquals(productsFormTitle, adminPage.getAdminFormTitleValue());
		
		log.info("TC01_Search_With_ProductName - Step 03 : Search Product Name With Data");
		adminPage.inputToProductsFormSearchProductNameTextbox(lenovoIdeaCentreProductName);
		
		log.info("TC01_Search_With_ProductName - Step 04 : Click to Search Button");
		adminPage.clickToProductsFormSearchButton();
		
		log.info("TC01_Search_With_ProductName - Step 05 : Verify Search Result With Data");
		verifyEquals(adminPage.countNumberOfSearchResult(), 1);
		verifyEquals(adminPage.getProductsFormSearchResultData(lenovoIdeaCentreProductName), lenovoIdeaCentreProductName);
		verifyEquals(adminPage.getProductsFormSearchResultData(lenovoIdeaCentreSKU), lenovoIdeaCentreSKU);
		verifyEquals(adminPage.getProductsFormSearchResultData(lenovoIdeaCentreUnitPrice), lenovoIdeaCentreUnitPrice);
		verifyEquals(adminPage.getProductsFormSearchResultData(lenovoIdeaCentreQuantiy), lenovoIdeaCentreQuantiy);
		verifyEquals(adminPage.getProductsFormSearchResultData(lenovoIdeaCentreProductType), lenovoIdeaCentreProductType);
		verifyTrue(adminPage.isProductsFormPublishedTrueIconDisplayed());
	}
	
	@Test
	public void TC02_Search_With_ProductName_Parent_Category_Unchecked() {
		
		String lenovoIdeaCentreProductName = "Lenovo IdeaCentre 600 All-in-One PC";
		String categoryVal = "Computers";
		String dataTableEmptyVal = "No data available in table";
		
		log.info("TC02_Search_With_ProductName_Parent_Category_Unchecked - Step 01 : Search Product Name With Data");
		adminPage.inputToProductsFormSearchProductNameTextbox(lenovoIdeaCentreProductName);
		adminPage.selectFromCategoryDropdown(categoryVal);
		adminPage.unCheckFromSubCategoryCheckbox();
		
		log.info("TC02_Search_With_ProductName_Parent_Category_Unchecked - Step 02 : Click to Search Button");
		adminPage.clickToProductsFormSearchButton();
		
		log.info("TC02_Search_With_ProductName_Parent_Category_Unchecked - Step 03 : Verify Search Result With Data");
		verifyEquals(adminPage.getProductsFormDataEmptyMessage(), dataTableEmptyVal);
	}
	
	@Test
	public void TC03_Search_With_ProductName_Parent_Category_Checked() {
		
		String lenovoIdeaCentreProductName = "Lenovo IdeaCentre 600 All-in-One PC";
		String lenovoIdeaCentreSKU = "LE_IC_600";
		String lenovoIdeaCentreUnitPrice = "500";
		String lenovoIdeaCentreQuantiy = "10000";
		String lenovoIdeaCentreProductType = "Simple";
		String categoryVal = "Computers";
		
		log.info("TC03_Search_With_ProductName_Parent_Category_Checked - Step 01 : Search Product Name With Data");
		adminPage.inputToProductsFormSearchProductNameTextbox(lenovoIdeaCentreProductName);
		adminPage.selectFromCategoryDropdown(categoryVal);
		adminPage.checkFromSubCategoryCheckbox();
		
		log.info("TC03_Search_With_ProductName_Parent_Category_Checked - Step 02 : Click to Search Button");
		adminPage.clickToProductsFormSearchButton();
		
		log.info("TC03_Search_With_ProductName_Parent_Category_Checked - Step 03 : Verify Search Result With Data");
		verifyEquals(adminPage.countNumberOfSearchResult(), 1);
		verifyEquals(adminPage.getProductsFormSearchResultData(lenovoIdeaCentreProductName), lenovoIdeaCentreProductName);
		verifyEquals(adminPage.getProductsFormSearchResultData(lenovoIdeaCentreSKU), lenovoIdeaCentreSKU);
		verifyEquals(adminPage.getProductsFormSearchResultData(lenovoIdeaCentreUnitPrice), lenovoIdeaCentreUnitPrice);
		verifyEquals(adminPage.getProductsFormSearchResultData(lenovoIdeaCentreQuantiy), lenovoIdeaCentreQuantiy);
		verifyEquals(adminPage.getProductsFormSearchResultData(lenovoIdeaCentreProductType), lenovoIdeaCentreProductType);
		verifyTrue(adminPage.isProductsFormPublishedTrueIconDisplayed());
	}
	
	@Test
	public void TC04_Search_With_ProductName_Child_Category() {
		
		String lenovoIdeaCentreProductName = "Lenovo IdeaCentre 600 All-in-One PC";
		String lenovoIdeaCentreSKU = "LE_IC_600";
		String lenovoIdeaCentreUnitPrice = "500";
		String lenovoIdeaCentreQuantiy = "10000";
		String lenovoIdeaCentreProductType = "Simple";
		String categoryVal = "Computers >> Desktops";
		
		log.info("TC04_Search_With_ProductName_Child_Category - Step 01 : Search Product Name With Data");
		adminPage.inputToProductsFormSearchProductNameTextbox(lenovoIdeaCentreProductName);
		adminPage.selectFromCategoryDropdown(categoryVal);
		adminPage.unCheckFromSubCategoryCheckbox();
		
		log.info("TC04_Search_With_ProductName_Child_Category - Step 02 : Click to Search Button");
		adminPage.clickToProductsFormSearchButton();
		
		log.info("TC04_Search_With_ProductName_Child_Category - Step 03 : Verify Search Result With Data");
		verifyEquals(adminPage.countNumberOfSearchResult(), 1);
		verifyEquals(adminPage.getProductsFormSearchResultData(lenovoIdeaCentreProductName), lenovoIdeaCentreProductName);
		verifyEquals(adminPage.getProductsFormSearchResultData(lenovoIdeaCentreSKU), lenovoIdeaCentreSKU);
		verifyEquals(adminPage.getProductsFormSearchResultData(lenovoIdeaCentreUnitPrice), lenovoIdeaCentreUnitPrice);
		verifyEquals(adminPage.getProductsFormSearchResultData(lenovoIdeaCentreQuantiy), lenovoIdeaCentreQuantiy);
		verifyEquals(adminPage.getProductsFormSearchResultData(lenovoIdeaCentreProductType), lenovoIdeaCentreProductType);
		verifyTrue(adminPage.isProductsFormPublishedTrueIconDisplayed());
	}
	
	@Test
	public void TC05_Search_With_ProductName_Manufacturer() {
		
		String lenovoIdeaCentreProductName = "Lenovo IdeaCentre 600 All-in-One PC";
		String categoryVal = "All";
		String dataTableEmptyVal = "No data available in table";
		String manufacturerVal = "Apple";
		
		log.info("TC05_Search_With_ProductName_Manufacturer - Step 01 : Search Product Name With Data");
		adminPage.inputToProductsFormSearchProductNameTextbox(lenovoIdeaCentreProductName);
		adminPage.selectFromCategoryDropdown(categoryVal);
		adminPage.unCheckFromSubCategoryCheckbox();
		adminPage.selectFromManufacturerDropdown(manufacturerVal);
		
		log.info("TC05_Search_With_ProductName_Manufacturer - Step 02 : Click to Search Button");
		adminPage.clickToProductsFormSearchButton();
		
		log.info("TC05_Search_With_ProductName_Manufacturer - Step 03 : Verify Search Result With Data");
		verifyEquals(adminPage.getProductsFormDataEmptyMessage(), dataTableEmptyVal);
	}
	
	@Test
	public void TC06_Go_Directly_To_Product_SKU() {
		
		String lenovoIdeaCentreProductName = "Lenovo IdeaCentre 600 All-in-One PC";
		String lenovoIdeaCentreProductDetailsTitle = "Edit product details - Lenovo IdeaCentre 600 All-in-One PC";
		String lenovoIdeaCentreSKU = "LE_IC_600";
		
		log.info("TC06_Go_Directly_To_Product_SKU - Step 01 : Search Product Name directly With SKU");
		adminPage.inputToProductsFormSearchGoDirectlyToSKUTextbox(lenovoIdeaCentreSKU);
		
		log.info("TC06_Go_Directly_To_Product_SKU - Step 02 : Click to GO button");
		adminPage.clickToProductsFormGoDirectlyToSKUButton();
		
		log.info("TC06_Go_Directly_To_Product_SKU - Step 03 : Verify Product Details With Data");
		verifyTrue(adminPage.getAdminFormTitleContainsValue(lenovoIdeaCentreProductDetailsTitle));
		verifyEquals(adminPage.getProductDetailsFormProductNameValue("value"), lenovoIdeaCentreProductName);
	}
	
	@Test
	public void TC07_Create_New_Customer() {
		
		String customersFormTitle = "Customers";
		String addNewCusFormTitle = "Add a new customer";
		String attributeName = "value";
		
		log.info("TC07_Create_New_Customer - Step 01 : Open Admin Customers Form");
		adminPage.clickToSidebarCustomersMenu();
		adminPage.clickToSidebarCustomersSubMenu();
		
		log.info("TC07_Create_New_Customer - Step 02 : Verify Admin Customers Form is Displayed");
		verifyEquals(customersFormTitle, adminPage.getAdminFormTitleValue());
		
		log.info("TC07_Create_New_Customer - Step 03 : Click to Add New Button");
		adminPage.clickToCustomersFormAddNewCustomerButton();
		
		log.info("TC07_Create_New_Customer - Step 04 : Verify Admin Add New Customer Form is Displayed");
		verifyTrue(adminPage.getAdminFormTitleContainsValue(addNewCusFormTitle));
		
		log.info("TC07_Create_New_Customer - Step 05 : Add new Customer with Data");
		adminPage.inputToAddNewCustomerFormEmailTextbox(cusEmailVal);
		adminPage.inputToAddNewCustomerFormPasswordTextbox(cusPassVal);
		adminPage.inputToAddNewCustomerFormFirstnameTextbox(cusFirstnameVal);
		adminPage.inputToAddNewCustomerFormLastnameTextbox(cusLastnameVal);
		adminPage.clickToAddNewCustomerFormGenderMaleRadiobutton();
		adminPage.inputToAddNewCustomerFormDateOfBirthTextbox(cusDateOfBirthVal);
		adminPage.inputToAddNewCustomerFormCompanynameTextbox(cusCompanynameVal);
		adminPage.inputToAddNewCustomerFormCustomerRoleDropdown(cusRolesVal);
		adminPage.selectFromAddNewCustomerFormVendorDropdown(cusVendorVal);
		adminPage.inputToAddNewCustomerFormCommentTextarea(cusCommentVal);
		
		log.info("TC07_Create_New_Customer - Step 06 : Click to Save And Continue Button");
		adminPage.clickToAddNewCustomerFormSaveAndContinueButton();
		
		log.info("TC07_Create_New_Customer - Step 07 : Verify Add new Customer Success Message is Displayed");
		verifyTrue(adminPage.isAddNewCustomerFormSuccessMessageDisplayed());
		
		log.info("TC07_Create_New_Customer - Step 08 : Verify Add new Customer Data is Displayed and Matched");
		verifyEquals(adminPage.getAddNewCustomerFormEmailTextboxValue(attributeName), cusEmailVal);
		verifyEquals(adminPage.getAddNewCustomerFormFirstnameTextboxValue(attributeName), cusFirstnameVal);
		verifyEquals(adminPage.getAddNewCustomerFormLastnameTextboxValue(attributeName), cusLastnameVal);
		verifyTrue(adminPage.isAddNewCustomerFormGenderMaleisSelected());
		verifyEquals(adminPage.getAddNewCustomerFormDateOfBirthTextboxValue(attributeName), cusDateOfBirthVal);
		verifyEquals(adminPage.getAddNewCustomerFormCompanynameTextboxValue(attributeName), cusCompanynameVal);
		verifyEquals(adminPage.getAddNewCustomerFormCustomerRolesDropdownValue(cusRolesVal), cusRolesVal);
		verifyEquals(adminPage.getAddNewCustomerFormActiveCheckboxValue(attributeName),"true");
		verifyEquals(adminPage.getAddNewCustomerFormAdminCommentValue(attributeName), cusCommentVal);
		
		log.info("TC07_Create_New_Customer - Step 09 : Click to 'Back to Customers List' Button");
		adminPage.clickBackToPreviousFormButton();
		
		log.info("TC07_Create_New_Customer - Step 10 : Verify Admin Customers Form is Displayed");
		verifyEquals(customersFormTitle, adminPage.getAdminFormTitleValue());
		
		log.info("TC07_Create_New_Customer - Step 11 : Add Search Data and click to 'Customers' Form 'Search' button");
		adminPage.removeDataFromCustomerFormCustomerRoleDropdown();
		adminPage.clickToCustomersFormSearchButton();
		
		log.info("TC07_Create_New_Customer - Step 12 : Verify Search Result With Data");
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusFirstnameVal +" "+cusLastnameVal), cusFirstnameVal +" "+cusLastnameVal);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusRolesVal), cusRolesVal);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusCompanynameVal), cusCompanynameVal);
		verifyTrue(adminPage.isCustomersFormActiveIconDisplayed(cusEmailVal));
	}
	
	@Test
	public void TC08_Search_Customer_With_Email() {
		
		log.info("TC08_Search_Customer_With_Email - Step 01 : Add Search Data and click to 'Customers' Form 'Search' button");
		adminPage.inputToCustomerFormSearchEmailTextbox(cusEmailVal);
		adminPage.inputToAddNewCustomerFormCustomerRoleDropdown(cusRolesVal);
		adminPage.clickToCustomersFormSearchButton();
		
		log.info("TC08_Search_Customer_With_Email - Step 02 : Verify Search Result With Data");
		verifyEquals(adminPage.countNumberOfSearchResult(), 1);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusEmailVal), cusEmailVal);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusFirstnameVal +" "+cusLastnameVal), cusFirstnameVal +" "+cusLastnameVal);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusRolesVal), cusRolesVal);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusCompanynameVal), cusCompanynameVal);
		verifyTrue(adminPage.isCustomersFormActiveIconDisplayed(emailVal));
	}
	
	@Test
	public void TC09_Search_Customer_With_Firstname_And_Lastname() {
		
		log.info("TC09_Search_Customer_With_Firstname_And_Lastname - Step 01 : Add Search Data and click to 'Customers' Form 'Search' button");
		adminPage.inputToCustomerFormSearchFirstnameTextbox(cusFirstnameVal);
		adminPage.inputToCustomerFormSearchLastnameTextbox(cusLastnameVal);
		adminPage.inputToAddNewCustomerFormCustomerRoleDropdown(cusRolesVal);
		adminPage.clickToCustomersFormSearchButton();
		
		log.info("TC09_Search_Customer_With_Firstname_And_Lastname - Step 02 : Verify Search Result With Data");
		verifyEquals(adminPage.countNumberOfSearchResult(), 1);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusEmailVal), cusEmailVal);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusFirstnameVal +" "+cusLastnameVal), cusFirstnameVal +" "+cusLastnameVal);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusRolesVal), cusRolesVal);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusCompanynameVal), cusCompanynameVal);
		verifyTrue(adminPage.isCustomersFormActiveIconDisplayed(emailVal));
	}
	
	@Test
	public void TC10_Search_Customer_With_Companyname() {
		
		log.info("TC10_Search_Customer_With_Companyname - Step 01 : Add Search Data and click to 'Customers' Form 'Search' button");
		adminPage.inputToCustomerFormSearchCompanynameTextbox(cusCompanynameVal);
		adminPage.inputToAddNewCustomerFormCustomerRoleDropdown(cusRolesVal);
		adminPage.clickToCustomersFormSearchButton();
		
		log.info("TC10_Search_Customer_With_Companyname - Step 02 : Verify Search Result With Data");
		verifyEquals(adminPage.countNumberOfSearchResult(), 1);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusEmailVal), cusEmailVal);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusFirstnameVal +" "+cusLastnameVal), cusFirstnameVal +" "+cusLastnameVal);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusRolesVal), cusRolesVal);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusCompanynameVal), cusCompanynameVal);
		verifyTrue(adminPage.isCustomersFormActiveIconDisplayed(cusEmailVal));
	}
	
	@Test
	public void TC11_Search_Customer_With_Full_Data() {
		
		log.info("TC11_Search_Customer_With_Full_Data - Step 01 : Add Search Data and click to 'Customers' Form 'Search' button");
		adminPage.inputToCustomerFormSearchEmailTextbox(cusEmailVal);
		adminPage.inputToCustomerFormSearchFirstnameTextbox(cusFirstnameVal);
		adminPage.inputToCustomerFormSearchLastnameTextbox(cusLastnameVal);
		adminPage.inputToCustomerFormSearchCompanynameTextbox(cusCompanynameVal);
		adminPage.selectFromCustomerFormSearchMonthOfBirthDropdown("1");
		adminPage.selectFromCustomerFormSearchDayOfBirthDropdown("1");
		adminPage.inputToAddNewCustomerFormCustomerRoleDropdown(cusRolesVal);
		adminPage.clickToCustomersFormSearchButton();
		
		log.info("TC11_Search_Customer_With_Full_Data - Step 02 : Verify Search Result With Data");
		verifyEquals(adminPage.countNumberOfSearchResult(), 1);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusEmailVal), cusEmailVal);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusFirstnameVal +" "+cusLastnameVal), cusFirstnameVal +" "+cusLastnameVal);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusRolesVal), cusRolesVal);
		verifyEquals(adminPage.getCustomersFormSearchResultData(cusCompanynameVal), cusCompanynameVal);
		verifyTrue(adminPage.isCustomersFormActiveIconDisplayed(cusEmailVal));
	}
	
	@Test
	public void TC12_Edit_Customer() {
		
		String editCusDetailFormTitle = "Edit customer details";
		String attributeName = "value";
		
		log.info("TC12_Edit_Customer - Step 01 : Click to Edit Button from Selected Customer");
		adminPage.clickToCustomerFormSelectedCustomerEditButton(cusEmailVal);
		
		log.info("TC12_Edit_Customer - Step 02 : Verify Admin Edit Customer Detail Form is Displayed");
		verifyTrue(adminPage.getAdminFormTitleContainsValue(editCusDetailFormTitle));
		
		log.info("TC12_Edit_Customer - Step 03 : Edit Customer with Data");
		adminPage.inputToAddNewCustomerFormEmailTextbox(editEmailVal);
		adminPage.inputToAddNewCustomerFormFirstnameTextbox(editFirstnameVal);
		adminPage.inputToAddNewCustomerFormLastnameTextbox(editLastnameVal);
		adminPage.inputToAddNewCustomerFormDateOfBirthTextbox(editDateOfBirthVal);
		adminPage.inputToAddNewCustomerFormCompanynameTextbox(editCompanynameVal);
		adminPage.inputToAddNewCustomerFormCustomerRoleDropdown(editRolesVal);
		adminPage.selectFromAddNewCustomerFormVendorDropdown(editVendorVal);
		adminPage.inputToAddNewCustomerFormCommentTextarea(editCommentVal);
		
		log.info("TC12_Edit_Customer - Step 04 : Click to Save And Continue Button");
		adminPage.clickToAddNewCustomerFormSaveAndContinueButton();
		
		log.info("TC12_Edit_Customer - Step 05 : Verify Edit Customer Success Message is Displayed");
		verifyTrue(adminPage.isAddNewCustomerFormSuccessMessageDisplayed());
		
		log.info("TC12_Edit_Customer - Step 06 : Verify Edit Customer Data is Displayed and Matched");
		verifyEquals(adminPage.getAddNewCustomerFormEmailTextboxValue(attributeName), editEmailVal);
		verifyEquals(adminPage.getAddNewCustomerFormFirstnameTextboxValue(attributeName), editFirstnameVal);
		verifyEquals(adminPage.getAddNewCustomerFormLastnameTextboxValue(attributeName), editLastnameVal);
		verifyTrue(adminPage.isAddNewCustomerFormGenderMaleisSelected());
		verifyEquals(adminPage.getAddNewCustomerFormDateOfBirthTextboxValue(attributeName), editDateOfBirthVal);
		verifyEquals(adminPage.getAddNewCustomerFormCompanynameTextboxValue(attributeName), editCompanynameVal);
		verifyEquals(adminPage.getAddNewCustomerFormCustomerRolesDropdownValue(cusRolesVal), editRolesVal);
		verifyEquals(adminPage.getAddNewCustomerFormActiveCheckboxValue(attributeName),"true");
		verifyEquals(adminPage.getAddNewCustomerFormAdminCommentValue(attributeName), editCommentVal);
	}
	
	@Test
	public void TC13_Add_New_Address_In_Customer_Detail() {
		
		String editCusDetailFormTitle = "Edit customer details";
		String addNewAddFormTitle = "Add a new address";
		String attributeName = "value";
		
		log.info("TC13_Add_New_Address_In_Customer_Detail - Step 01 : Click to Open Address Panel");
		adminPage.clickToEditCustomerDetailFormAddressPanel();
		
		log.info("TC13_Add_New_Address_In_Customer_Detail - Step 02 : Click to 'Add New Address' Button");
		adminPage.clickToEditCustomerDetailFormAddNewAddressButton();
		
		log.info("TC13_Add_New_Address_In_Customer_Detail - Step 03 : Verify Admin 'Add New Address' Form is Displayed");
		verifyTrue(adminPage.getAdminFormTitleContainsValue(addNewAddFormTitle));
		
		log.info("TC13_Add_New_Address_In_Customer_Detail - Step 04 : Add New Address with Data");
		adminPage.inputToAddNewAddressFormFirstnameTextbox(addFirstNameVal);
		adminPage.inputToAddNewAddressFormLastnameTextbox(addLastNameVal);
		adminPage.inputToAddNewAddressFormLEmailTextbox(addEmailVal);
		adminPage.inputToAddNewAddressFormCompanynameTextbox(addCompanyNameVal);
		adminPage.selectFromAddNewAddressFormCountryDropdown(addCountryVal);
		adminPage.selectFromAddNewAddressFormStateDropdown(addStateVal);
		adminPage.inputToAddNewAddressFormCityTextbox(addCityNameVal);
		adminPage.inputToAddNewAddressFormAddress01Textbox(addAddress01Val);
		adminPage.inputToAddNewAddressFormAddress02Textbox(addAddress02Val);
		adminPage.inputToAddNewAddressFormZipCodeTextbox(addZipcodeVal);
		adminPage.inputToAddNewAddressFormPhoneNumberTextbox(addPhoneNumberVal);
		adminPage.inputToAddNewAddressFormFaxNumberTextbox(addFaxNumberVal);
		
		log.info("TC13_Add_New_Address_In_Customer_Detail - Step 05 : Click to 'Save' Button");
		adminPage.clickToCustomersFormAddNewCustomerButton();
		
		log.info("TC13_Add_New_Address_In_Customer_Detail - Step 06 : 'Add New Address' Success Message is Displayed");
		verifyTrue(adminPage.isAddNewCustomerFormSuccessMessageDisplayed());
		
		log.info("TC13_Add_New_Address_In_Customer_Detail - Step 07 : Verify 'Add New Address' Data is Displayed and Matched");
		verifyEquals(adminPage.getAddNewAddressFormFirstnameValue(attributeName), addFirstNameVal);
		verifyEquals(adminPage.getAddNewAddressFormLastnameValue(attributeName), addLastNameVal);
		verifyEquals(adminPage.getAddNewAddressFormEmailValue(attributeName), addEmailVal);
		verifyEquals(adminPage.getAddNewAddressFormCompanyValue(attributeName), addCompanyNameVal);
		verifyEquals(adminPage.getAddNewAddressFormCountryDropdownValue(), addCountryVal);
		verifyEquals(adminPage.getAddNewAddressFormStateDropdownValue(), addStateVal);
		verifyEquals(adminPage.getAddNewAddressFormCityValue(attributeName), addCityNameVal);
		verifyEquals(adminPage.getAddNewAddressFormAddress01Value(attributeName), addAddress01Val);
		verifyEquals(adminPage.getAddNewAddressFormAddress02Value(attributeName), addAddress02Val);
		verifyEquals(adminPage.getAddNewAddressFormZipCodeValue(attributeName), addZipcodeVal);
		verifyEquals(adminPage.getAddNewAddressFormPhoneNumberValue(attributeName), addPhoneNumberVal);
		verifyEquals(adminPage.getAddNewAddressFormFaxNumberValue(attributeName), addFaxNumberVal);
		
		log.info("TC13_Add_New_Address_In_Customer_Detail - Step 08 : Click to 'Back to Customers List' Button");
		adminPage.clickBackToPreviousFormButton();
		
		log.info("TC13_Add_New_Address_In_Customer_Detail - Step 09 : Verify Admin Edit Customer Detail Form is Displayed");
		verifyTrue(adminPage.getAdminFormTitleContainsValue(editCusDetailFormTitle));
		
		log.info("TC13_Add_New_Address_In_Customer_Detail - Step 10 : Click to Open Address Panel");
		adminPage.clickToEditCustomerDetailFormAddressPanel();
		
		log.info("TC13_Add_New_Address_In_Customer_Detail - Step 11 : Verify New Address Data is Displayed");
		verifyEquals(adminPage.getEditCustomerDetailFormAddressData(addFirstNameVal), addFirstNameVal);
		verifyEquals(adminPage.getEditCustomerDetailFormAddressData(addLastNameVal), addLastNameVal);
		verifyEquals(adminPage.getEditCustomerDetailFormAddressData(addEmailVal), addEmailVal);
		verifyEquals(adminPage.getEditCustomerDetailFormAddressData(addPhoneNumberVal), addPhoneNumberVal);
		verifyEquals(adminPage.getEditCustomerDetailFormAddressData(addFaxNumberVal), addFaxNumberVal);
		verifyEquals(adminPage.getEditCustomerDetailFormAddressData(addCompanyNameVal), addCompanyNameVal);
		verifyEquals(adminPage.getEditCustomerDetailFormAddressData(addAddress01Val), addAddress01Val);
		verifyEquals(adminPage.getEditCustomerDetailFormAddressData(addAddress02Val), addAddress02Val);
		verifyEquals(adminPage.getEditCustomerDetailFormAddressData(addCityNameVal+","+addZipcodeVal), addCityNameVal+","+addZipcodeVal);
		verifyEquals(adminPage.getEditCustomerDetailFormAddressData(addCountryVal),addCountryVal);
	}
	
	@Test
	public void TC14_Edit_Address_In_Customer_Detail() {
	}
	
	@Test
	public void TC15_Delete_Customer_In_Customer_Detail() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
