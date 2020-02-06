package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactoryPattern.DriverManager;
import driverFactoryPattern.DriverManagerFactory;
import pageObjects.DetailPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.NoteBooksPageObject;
import pageObjects.ProductReviewPageObject;
import pageObjects.RegisterPageObject;
import pageUIs.AbstactPageUI;
import pageUIs.DetailPageUI;
import pageUIs.HomePageUI;
import pageUIs.MyAccountPageUI;
import pageUIs.RegisterPageUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class FE_03_MyAccount extends AbstractTest {

	private WebDriver driver;
	private String firstNameVal, lastNameVal, dateOfBirthVal, dateOfMonthVal, dateOfYearVal, emailVal, companyNameVal, passVal, attributeVal,randomVal;
	private String upFirstNameVal, upLastNameVal, upDateOfBirthVal, upDateOfMonthVal, upDateOfYearVal, upEmailVal, upCompanyNameVal,newPassVal;
	private String addFirstNameVal, addLastNameVal,addEmailVal, addCompanyNameVal, addCountryVal, addStateVal, addCityNameVal,  addAddress01Val, addAddress02Val, 
	addZipcodeVal, addPhoneNumberVal, addFaxNumberVal;
	private String changePassResultText,passErrMessage,asusProductName,asusTitleVal,asusDescriptionVal,addReviewResultMessage;
	boolean genderMale,genderFemale;
	
	private DriverManager driverManager;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private MyAccountPageObject myAccountPage;
	private NoteBooksPageObject noteBooksPage;
	private DetailPageObject detailPage;
	private ProductReviewPageObject productReviewPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driverManager = DriverManagerFactory.getBrowserDriver(browserName);
		driver = driverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		attributeVal = "value";randomVal = "" + randomNumber() + ""; newPassVal = "" + randomNumber() + "";
		
		changePassResultText = "Password was changed";
		passErrMessage = "Login was unsuccessful. Please correct the errors and try again.\n" + 
				"The credentials provided are incorrect";
		
		asusProductName = "Asus N551JK-XO076H Laptop";
		asusTitleVal = "Asus N551JK Review Title";
		asusDescriptionVal = "Asus N551JK Review Description";
		addReviewResultMessage = "Product review is successfully added.";

		firstNameVal = "Spider"; lastNameVal = "Man" + randomVal; dateOfBirthVal = "20"; dateOfMonthVal = "October"; dateOfYearVal = "2000";
		emailVal = "spider_man_" + randomVal + "@gmail.com"; companyNameVal = "Marvel Studio Entertainment" + randomVal; passVal = "" + randomVal + "";
		
		upFirstNameVal = "John"; upLastNameVal = "Wick" + randomVal; upDateOfBirthVal = "15"; upDateOfMonthVal = "May"; upDateOfYearVal = "1990";
		upEmailVal = "john_wick_" + randomVal + "@gmail.com"; upCompanyNameVal = "John Wick Entertainment" + randomVal;
		
		addFirstNameVal = "Doctor"; addLastNameVal = "Strange" + randomVal; addEmailVal = "doctor_strange_" + randomVal +"@gmail.com"; 
		addCompanyNameVal = "Marvel Entertainment" + randomVal; addCountryVal = "Viet Nam"; addStateVal = "Other (Non US)"; 
		addCityNameVal = "Ha Noi";  addAddress01Val = "03 Tran Thai Tong"; addAddress02Val = "09 Nguyen Huy Tuong"; addZipcodeVal = "10166"; 
		addPhoneNumberVal = "0987654321"; addFaxNumberVal = "0123456789";
		
		String pageUrl = "https://demo.nopcommerce.com/";
		log.info("Pre-Condition 01 : Open Page Url " + pageUrl);
		driver.get(pageUrl);
	}

	@Test
	public void TC01_Update_Customer_Info() throws Exception {
		
		log.info("TC01_Update_Customer_Info - Step 01 : Init HomePage");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("TC01_Update_Customer_Info - Step 02 : Open Register Page Through Header Register Link");
		homePage.openHeaderDynamicPage(AbstactPageUI.A_CLASS_HEADER_REGISTER_LINK);
		
		log.info("TC01_Update_Customer_Info - Step 03 : Init Register Page");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		log.info("TC01_Update_Customer_Info - Step 04 : Register Account with Valid Data");
		registerPage.clickToRadioButton(RegisterPageUI.INPUT_ID_GENDER_MALE_RADIOBUTTON);
		registerPage.inputToTextboxName(firstNameVal, RegisterPageUI.INPUT_ID_FIRSTNAME_TEXTBOX);
		registerPage.inputToTextboxName(lastNameVal, RegisterPageUI.INPUT_ID_LASTNAME_TEXTBOX);
		registerPage.selectDateOfBirthFromDropdown(dateOfBirthVal, RegisterPageUI.SELECT_NAME_DATEOFBIRTH_DROPDOWN);
		registerPage.selectDateOfBirthFromDropdown(dateOfMonthVal, RegisterPageUI.SELECT_NAME_DATEOFMONTH_DROPDOWN);
		registerPage.selectDateOfBirthFromDropdown(dateOfYearVal, RegisterPageUI.SELECT_NAME_DATEOFYEAR_DROPDOWN);
		registerPage.inputToTextboxName(emailVal, RegisterPageUI.INPUT_ID_EMAIL_TEXTBOX);
		registerPage.inputToTextboxName(companyNameVal, RegisterPageUI.INPUT_ID_COMPANYNAME_TEXTBOX);
		registerPage.inputToTextboxName(passVal, RegisterPageUI.INPUT_ID_PASSWORD_TEXTBOX);
		registerPage.inputToTextboxName(passVal, RegisterPageUI.INPUT_ID_CONFIRM_PASSWORD_TEXTBOX);
		
		log.info("TC01_Update_Customer_Info - Step 05 : Click to Register Button");
		registerPage.clickToRegisterButton();
		
		log.info("TC01_Update_Customer_Info - Step 06 : Verify Create Account Successfully");
		verifyTrue(registerPage.isSuccessMessageDisplayed());
		
		log.info("TC01_Update_Customer_Info - Step 07 : Logout Account");
		homePage = registerPage.clickToLogoutLink();
		
		log.info("TC01_Update_Customer_Info - Step 08 : Open Login Page Through Header Login Link");
		homePage.openHeaderDynamicPage(AbstactPageUI.A_CLASS_HEADER_LOGIN_LINK);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("TC01_Update_Customer_Info - Step 09 : Login account With Valid Data");
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passVal);
		
		log.info("TC01_Update_Customer_Info - Step 10 : Click to Login Button");
		loginPage.clickToLoginButton();
		
		log.info("TC01_Update_Customer_Info - Step 11 : Verify login success and show 'My Account' link in Header ");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("TC01_Update_Customer_Info - Step 12 : Open My Account Page Through Header My Account Link");
		homePage.openHeaderDynamicPage(AbstactPageUI.A_CLASS_HEADER_MY_ACCOUNT_LINK);
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		
		log.info("TC01_Update_Customer_Info - Step 13 : Verify My Account Page is Displayed");
		verifyTrue(myAccountPage.isMyAccountPageDisplayed());
		
		log.info("TC01_Update_Customer_Info - Step 14 : Verify Account Info is Matched with Register Data");
		//Assert.verifyEquals("",myAccountPage.isGenderButtonSelected(MyAccountPageUI.SPAN_CLASS_GENDER_MALE_RADIOBUTTON, "checked"));
		verifyEquals(firstNameVal, myAccountPage.getTexBoxNameData(MyAccountPageUI.INPUT_ID_FIRSTNAME_TEXTBOX, attributeVal));
		verifyEquals(lastNameVal, myAccountPage.getTexBoxNameData(MyAccountPageUI.INPUT_ID_LASTNAME_TEXTBOX, attributeVal));
		verifyEquals(dateOfBirthVal, myAccountPage.getDateOfBirthDropDownData(MyAccountPageUI.SELECT_NAME_DATEOFBIRTH_DROPDOWN));
		verifyEquals(dateOfMonthVal, myAccountPage.getDateOfBirthDropDownData(MyAccountPageUI.SELECT_NAME_DATEOFMONTH_DROPDOWN));
		verifyEquals(dateOfYearVal, myAccountPage.getDateOfBirthDropDownData(MyAccountPageUI.SELECT_NAME_DATEOFYEAR_DROPDOWN));
		verifyEquals(emailVal, myAccountPage.getTexBoxNameData(MyAccountPageUI.INPUT_ID_EMAIL_TEXTBOX, "value"));
		verifyEquals(companyNameVal, myAccountPage.getTexBoxNameData(MyAccountPageUI.INPUT_ID_COMPANYNAME_TEXTBOX, attributeVal));
		
		log.info("TC01_Update_Customer_Info - Step 15 : Change Account Info with New Data");
		myAccountPage.clickToRadioButton(MyAccountPageUI.SPAN_CLASS_GENDER_FEMALE_RADIOBUTTON);
		myAccountPage.inputToCustomerInfoTextboxName(MyAccountPageUI.INPUT_ID_FIRSTNAME_TEXTBOX, upFirstNameVal);
		myAccountPage.inputToCustomerInfoTextboxName(MyAccountPageUI.INPUT_ID_LASTNAME_TEXTBOX, upLastNameVal);
		myAccountPage.selectDateOfBirthFromDropdown(MyAccountPageUI.SELECT_NAME_DATEOFBIRTH_DROPDOWN, upDateOfBirthVal);
		myAccountPage.selectDateOfBirthFromDropdown(MyAccountPageUI.SELECT_NAME_DATEOFMONTH_DROPDOWN, upDateOfMonthVal);
		myAccountPage.selectDateOfBirthFromDropdown(MyAccountPageUI.SELECT_NAME_DATEOFYEAR_DROPDOWN, upDateOfYearVal);
		myAccountPage.inputToCustomerInfoTextboxName(MyAccountPageUI.INPUT_ID_EMAIL_TEXTBOX, upEmailVal);
		myAccountPage.inputToCustomerInfoTextboxName(MyAccountPageUI.INPUT_ID_COMPANYNAME_TEXTBOX, upCompanyNameVal);
		
		log.info("TC01_Update_Customer_Info - Step 16 : Click to Save Button");
		myAccountPage.clickToCustomerInfoSaveButton();
		
		log.info("TC01_Update_Customer_Info - Step 17 : Verify Account Info is Matched with New Data");
		//Assert.verifyEquals("",myAccountPage.isGenderButtonSelected(MyAccountPageUI.SPAN_CLASS_GENDER_MALE_RADIOBUTTON, "checked"));
		verifyEquals(upFirstNameVal, myAccountPage.getTexBoxNameData(MyAccountPageUI.INPUT_ID_FIRSTNAME_TEXTBOX, attributeVal));
		verifyEquals(upLastNameVal, myAccountPage.getTexBoxNameData(MyAccountPageUI.INPUT_ID_LASTNAME_TEXTBOX, attributeVal));
		verifyEquals(upDateOfBirthVal, myAccountPage.getDateOfBirthDropDownData(MyAccountPageUI.SELECT_NAME_DATEOFBIRTH_DROPDOWN));
		verifyEquals(upDateOfMonthVal, myAccountPage.getDateOfBirthDropDownData(MyAccountPageUI.SELECT_NAME_DATEOFMONTH_DROPDOWN));
		verifyEquals(upDateOfYearVal, myAccountPage.getDateOfBirthDropDownData(MyAccountPageUI.SELECT_NAME_DATEOFYEAR_DROPDOWN));
		verifyEquals(upEmailVal, myAccountPage.getTexBoxNameData(MyAccountPageUI.INPUT_ID_EMAIL_TEXTBOX, attributeVal));
		verifyEquals(upCompanyNameVal, myAccountPage.getTexBoxNameData(MyAccountPageUI.INPUT_ID_COMPANYNAME_TEXTBOX, attributeVal));
		
	}

	@Test
	public void TC02_Update_Address() {
		
		log.info("TC02_Update_Address - Step 01 : Open Addess Form by Click to 'Address' side-menu");
		myAccountPage.clickToAddressLink();
		
		log.info("TC02_Update_Address - Step 02 : Click to Add New Address Button");
		myAccountPage.clickToAddressAddNewButton();
		
		log.info("TC02_Update_Address - Step 03 : Verify New Address Form is Displayed");
		verifyTrue(myAccountPage.isAddressTableDisplayed());
		
		log.info("TC02_Update_Address - Step 04 : Fill the New Address Form with valid Data");
		myAccountPage.inputToAddressTextboxName(MyAccountPageUI.INPUT_ID_ADDRESS_FIRSTNAME_TEXTBOX, addFirstNameVal);
		myAccountPage.inputToAddressTextboxName(MyAccountPageUI.INPUT_ID_ADDRESS_LASTNAME_TEXTBOX, addLastNameVal);
		myAccountPage.inputToAddressTextboxName(MyAccountPageUI.INPUT_ID_ADDRESS_EMAIL_TEXTBOX, addEmailVal);
		myAccountPage.inputToAddressTextboxName(MyAccountPageUI.INPUT_ID_ADDRESS_COMPANYNAME_TEXTBOX,addCompanyNameVal);
		myAccountPage.selectAddressFromDropdownName(MyAccountPageUI.SELECT_ID_ADDRESS_COUNTRY_DROPDOWN, addCountryVal);
		myAccountPage.selectAddressFromDropdownName(MyAccountPageUI.SELECT_ID_ADDRESS_STATE_DROPDOWN,addStateVal);
		myAccountPage.inputToAddressTextboxName(MyAccountPageUI.INPUT_ID_ADDRESS_CITY_TEXTBOX,addCityNameVal);
		myAccountPage.inputToAddressTextboxName(MyAccountPageUI.INPUT_ID_ADDRESS_ADDRESS01_TEXTBOX,addAddress01Val);
		myAccountPage.inputToAddressTextboxName(MyAccountPageUI.INPUT_ID_ADDRESS_ADDRESS02_TEXTBOX,addAddress02Val);
		myAccountPage.inputToAddressTextboxName(MyAccountPageUI.INPUT_ID_ADDRESS_ZIPCODE_TEXTBOX,addZipcodeVal);
		myAccountPage.inputToAddressTextboxName(MyAccountPageUI.INPUT_ID_ADDRESS_PHONENUMBER_TEXTBOX,addPhoneNumberVal);
		myAccountPage.inputToAddressTextboxName(MyAccountPageUI.INPUT_ID_ADDRESS_FAXNUMBER_TEXTBOX,addFaxNumberVal);
		
		log.info("TC02_Update_Address - Step 05 : Click to Save Button");
		myAccountPage.clickToAddressSaveButton();
		
		log.info("TC02_Update_Address - Step 06 : Verify New Address Info Form with New Data is Displayed");
		verifyTrue(myAccountPage.isAddressInfoTableDisplayed());
	
		log.info("TC02_Update_Address - Step 07 : Verify New Address Info Data is Matched with Input Data");
		verifyEquals(addFirstNameVal +" "+addLastNameVal, myAccountPage.getAddressNameTextData(MyAccountPageUI.LI_CLASS_ADDRESS_FIRST_LAST_NAME_TEXT));
		verifyEquals("Email: "+addEmailVal, myAccountPage.getAddressNameTextData(MyAccountPageUI.LI_CLASS_ADDRESS_EMAIL_TEXT));
		verifyEquals("Phone number: "+addPhoneNumberVal, myAccountPage.getAddressNameTextData(MyAccountPageUI.LI_CLASS_ADDRESS_PHONENUMBER_TEXT));
		verifyEquals("Fax number: "+addFaxNumberVal, myAccountPage.getAddressNameTextData(MyAccountPageUI.LI_CLASS_ADDRESS_FAXNUMBER_TEXT));
		verifyEquals(addCompanyNameVal, myAccountPage.getAddressNameTextData(MyAccountPageUI.LI_CLASS_ADDRESS_COMPANYNAME_TEXT));
		verifyEquals(addAddress01Val, myAccountPage.getAddressNameTextData(MyAccountPageUI.LI_CLASS_ADDRESS_ADDRESS01_TEXT));
		verifyEquals(addAddress02Val, myAccountPage.getAddressNameTextData(MyAccountPageUI.LI_CLASS_ADDRESS_ADDRESS02_TEXT));
		verifyEquals(addCityNameVal +", "+addZipcodeVal, myAccountPage.getAddressNameTextData(MyAccountPageUI.LI_CLASS_ADDRESS_CITY_ZIPCODE_TEXT));
		verifyEquals( addCountryVal, myAccountPage.getAddressNameTextData(MyAccountPageUI.LI_CLASS_ADDRESS_COUNTRY_TEXT));
		
	}

	@Test
	public void TC03_Change_Account_Password() {
		
		log.info("TC03_Change_Account_Password - Step 01 : Open Change Password Form by Click to 'Change Password' side-menu");
		myAccountPage.clickToChangePasswordLink();
		
		log.info("TC03_Change_Account_Password - Step 02 : Verify Change Password Form is Displayed");
		verifyTrue(myAccountPage.isChangePasswordFormDisplayed());
	
		log.info("TC03_Change_Account_Password - Step 03 : Fill the change Password Form with Valid Data");
		myAccountPage.inputToChangePasswordTextboxName(MyAccountPageUI.INPUT_ID_CHANGE_OLD_PASSWORD_TEXTBOX, passVal);
		myAccountPage.inputToChangePasswordTextboxName(MyAccountPageUI.INPUT_ID_CHANGE_NEW_PASSWORD_TEXTBOX,newPassVal);
		myAccountPage.inputToChangePasswordTextboxName(MyAccountPageUI.INPUT_ID_CHANGE_CONFIRM_NEW_PASSWORD_TEXTBOX,newPassVal);
		
		log.info("TC03_Change_Account_Password - Step 04 : Click to Save Button");
		myAccountPage.clickToChangePasswordButton();
		
		log.info("TC03_Change_Account_Password - Step 05 : Verify Change Password successfully");
		verifyEquals(changePassResultText, myAccountPage.getChangeNewPassResultMessageData());
		
		log.info("TC03_Change_Account_Password - Step 06 : Click to LogOut Account");
		homePage = myAccountPage.clickToLogoutLink();
		
		log.info("TC03_Change_Account_Password - Step 07 : Open Login Page Through Header Login Link");
		homePage.openHeaderDynamicPage(AbstactPageUI.A_CLASS_HEADER_LOGIN_LINK);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("TC03_Change_Account_Password - Step 08 : Login with old Password");
		loginPage.inputToEmailTextbox(upEmailVal);
		loginPage.inputToPasswordTextbox(passVal);
		
		log.info("TC03_Change_Account_Password - Step 09 : Click to Login Button");
		loginPage.clickToLoginButton();
		
		log.info("TC03_Change_Account_Password - Step 10 : Verify Error Message in Password Field");
		verifyEquals(passErrMessage, loginPage.getLoginCommonErrorMessage());
		
		log.info("TC03_Change_Account_Password - Step 11 : Login with New Password");
		loginPage.inputToEmailTextbox(upEmailVal);
		loginPage.inputToPasswordTextbox(newPassVal);
		
		log.info("TC03_Change_Account_Password - Step 12 : Click to Login Button");
		loginPage.clickToLoginButton();
		
		log.info("TC03_Change_Account_Password - Step 13 : Verify login success and show 'My Account' link in Header");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}
	@Test
	public void TC04_Product_Review() {
		
		log.info("TC04_Product_Review - Step 01 : Hover to 'Computers' Menu and Click to 'Notebooks' link");
		homePage.hoverToMenuBarName(HomePageUI.A_CONTAINS_TEXT_MENUBAR_COMPUTER);
		homePage.openMenuBarDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_NOTEBOOKS_LINK);
		
		log.info("TC04_Product_Review - Step 02 : Open and Verify Notebook Page is Displayed");
		noteBooksPage = PageGeneratorManager.getNoteBooksPage(driver);
		verifyTrue(noteBooksPage.isNoteBookPageDisplayed());
		
		log.info("TC04_Product_Review - Step 03 : Click to Open Asus N551 Product");
		noteBooksPage.openDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_NOTERBOOKS_ASUS_N551_PRODUCT);
		detailPage = PageGeneratorManager.getDetailPage(driver);
		
		log.info("TC04_Product_Review - Step 04 : Verify Asus N551 Product Detail Page is Displayed");
		verifyTrue(detailPage.isDetailPageDisplayed());
		
		log.info("TC04_Product_Review - Step 05 : Verify Asus N551 Product Name is Matched");
		verifyEquals(asusProductName, detailPage.getProductDetailTitleData(DetailPageUI.H1_CONTAINS_TEXT_PRODUCT_ASUS_N551_NAME));
		
		log.info("TC04_Product_Review - Step 06 : Click to Open Asus N551 Product Review Page");
		detailPage.openDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_ADD_YOUR_REVIEW_LINK);
		productReviewPage = PageGeneratorManager.getProductReviewPage(driver);
		
		log.info("TC04_Product_Review - Step 06 : Verify Asus N551 Product Review Page is Displayed");
		verifyTrue(productReviewPage.isProductReviewPageDisplayed());
		
		log.info("TC04_Product_Review - Step 07 : Verify Asus N551 Product Name is Matched");
		verifyEquals(asusProductName, productReviewPage.getProductReviewNameData(AbstactPageUI.A_CONTAINS_TEXT_NOTERBOOKS_ASUS_N551_PRODUCT));
		
		log.info("TC04_Product_Review - Step 08 : Fill revied Form with Valid Data");
		productReviewPage.inputToReviewTitleTexbox(asusTitleVal);
		productReviewPage.inputToReviewDescriptionTextarea(asusDescriptionVal);
		
		log.info("TC04_Product_Review - Step 09 : Click to Submit Review Button");
		productReviewPage.clickToSubmitReviewButton();
		
		log.info("TC04_Product_Review - Step 10 : Verify Review Success Message is Displayed");
		verifyEquals(addReviewResultMessage, productReviewPage.getProductReviewResultMessageData());
		
		log.info("TC04_Product_Review - Step 11 : Open My Account Page Through My Account Link");
		productReviewPage.openHeaderDynamicPage(AbstactPageUI.A_CLASS_HEADER_MY_ACCOUNT_LINK);
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		
		log.info("TC04_Product_Review - Step 12 : Verify My Account Page is Displayed");
		verifyTrue(myAccountPage.isMyAccountPageDisplayed());
		
		log.info("TC04_Product_Review - Step 13 : Open My Product Review Form by Click to 'My Product Review' side-menu");
		myAccountPage.clickToMyProductReviewLink();
		
		log.info("TC04_Product_Review - Step 14 : Verify My Product Review Form is Displayed");
		verifyTrue(myAccountPage.isMyProductReviewFormDisplayed());
		
		log.info("TC04_Product_Review - Step 15 : Verify Recent New Review is Displayed");
		verifyTrue(myAccountPage.isMyProductReviewTitleDisplayed(asusTitleVal));
		verifyTrue(myAccountPage.isMyProductReviewDescriptionDisplayed(asusDescriptionVal));
		verifyTrue(myAccountPage.isMyProductReviewInfoDisplayed(asusProductName));
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
