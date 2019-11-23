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

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class FE_03_MyAccount extends AbstractTest {

	private WebDriver driver;
	String firstNameVal, lastNameVal, dateOfBirthVal, dateOfMonthVal, dateOfYearVal, emailVal, companyNameVal, passVal;
	String upFirstNameVal, upLastNameVal, upDateOfBirthVal, upDateOfMonthVal, upDateOfYearVal, upEmailVal, upCompanyNameVal;
	String addFirstNameVal, addLastNameVal,addEmailVal, addCompanyNameVal, addCountryVal, addStateVal, addCityNameVal,  addAddress01Val, addAddress02Val, addZipcodeVal, addPhoneNumberVal, addFaxNumberVal;
	boolean genderMale,genderFemale;
	
	private DriverManager driverManager;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
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

		String pageUrl = "https://demo.nopcommerce.com/";
		driver.get(pageUrl);
	}

	@Test
	public void TC01_Update_Customer_Info() throws Exception {

		firstNameVal = "Spider"; lastNameVal = "Man"; dateOfBirthVal = "20"; dateOfMonthVal = "October"; dateOfYearVal = "2000";
		emailVal = "spider_man_2019@gmail.com"; companyNameVal = "Marvel Studio Entertainment"; passVal = "123456";
		
		upFirstNameVal = "John"; upLastNameVal = "Wick"; upDateOfBirthVal = "15"; upDateOfMonthVal = "May"; upDateOfYearVal = "1990";
		upEmailVal = "john_wick_2019@gmail.com"; upCompanyNameVal = "John Wick Entertainment";

		homePage = PageGeneratorManager.getHomePage(driver);
		loginPage = homePage.openLoginPage();
		
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passVal);
		homePage = loginPage.clickToLoginButton();
		
	
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		myAccountPage = homePage.openMyAccountPage();
		
		Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed());
		
		//Assert.assertEquals("",myAccountPage.isGenderFemaleButtonSelected("checked"));
		Assert.assertEquals(firstNameVal, myAccountPage.getFirstNameData("value"));
		Assert.assertEquals(lastNameVal, myAccountPage.getLastNameData("value"));
		Assert.assertEquals(dateOfBirthVal, myAccountPage.getDateOfBirthData());
		Assert.assertEquals(dateOfMonthVal, myAccountPage.getDateOfMonthData());
		Assert.assertEquals(dateOfYearVal, myAccountPage.getDateOfYearData());
		Assert.assertEquals(emailVal, myAccountPage.getEmailData("value"));
		Assert.assertEquals(companyNameVal, myAccountPage.getCompanyNameData("value"));
		
		myAccountPage.clickToFemaleRadioButton();
		myAccountPage.inputToFirstnameTextbox(upFirstNameVal);
		myAccountPage.inputToLastnameTextbox(upLastNameVal);
		myAccountPage.selectDateOfBirthFromDropdown(upDateOfBirthVal);
		myAccountPage.selectDateOfMonthFromDropdown(upDateOfMonthVal);
		myAccountPage.selectDateOfYearFromDropdown(upDateOfYearVal);
		myAccountPage.inputToEmailTextbox(upEmailVal);
		myAccountPage.inputToCompanynameTextbox(upCompanyNameVal);
		myAccountPage.clickToSaveButton();
		
		//Assert.assertEquals("", myAccountPage.isGenderMaleButtonSelected("checked"));
		Assert.assertEquals(upFirstNameVal, myAccountPage.getFirstNameData("value"));
		Assert.assertEquals(upLastNameVal, myAccountPage.getLastNameData("value"));
		Assert.assertEquals(upDateOfBirthVal, myAccountPage.getDateOfBirthData());
		Assert.assertEquals(upDateOfMonthVal, myAccountPage.getDateOfMonthData());
		Assert.assertEquals(upDateOfYearVal, myAccountPage.getDateOfYearData());
		Assert.assertEquals(upEmailVal, myAccountPage.getEmailData("value"));
		Assert.assertEquals(upCompanyNameVal, myAccountPage.getCompanyNameData("value"));
		
	}

	@Test
	public void TC02_Update_Address() {

		addFirstNameVal = "Doctor"; addLastNameVal = "Strange"; addEmailVal = "doctor_strange_2519@gmail.com"; addCompanyNameVal = "Marvel Entertainment"; addCountryVal = "Viet Nam"; 
		addStateVal = "Other (Non US)"; addCityNameVal = "Ha Noi";  addAddress01Val = "03 Tran Thai Tong"; addAddress02Val = "09 Nguyen Huy Tuong"; addZipcodeVal = "10166"; 
		addPhoneNumberVal = "0987654321"; addFaxNumberVal = "0123456789";
		
		myAccountPage.clickToAddressLink();
		myAccountPage.clickToAddNewAddressButton();
		
		Assert.assertTrue(myAccountPage.isAddressTableDisplayed());
		
		myAccountPage.inputToAddressFirstnameTextbox(addFirstNameVal);
		myAccountPage.inputToAddressLastnameTextbox(addLastNameVal);
		myAccountPage.inputToAddressEmailTextbox(addEmailVal);
		myAccountPage.inputToAddressCompanynameTextbox(addCompanyNameVal);
		myAccountPage.selectAddressCountryFromDropdown(addCountryVal);
		myAccountPage.selectAddressStateFromDropdown(addStateVal);
		myAccountPage.inputToAddressCityTextbox(addCityNameVal);
		myAccountPage.inputToAddress01Textbox(addAddress01Val);
		myAccountPage.inputToAddress02Textbox(addAddress02Val);
		myAccountPage.inputToAddressZipcodeTextbox(addZipcodeVal);
		myAccountPage.inputToAddressPhoneNumberTextbox(addPhoneNumberVal);
		myAccountPage.inputToAddressFaxNumberTextbox(addFaxNumberVal);
		myAccountPage.clickToAddressSaveButton();
		
		Assert.assertTrue(myAccountPage.isAddressInfoTableDisplayed());
	
		Assert.assertEquals(addFirstNameVal +" "+addLastNameVal, myAccountPage.getAddressFirstLastNameData());
		Assert.assertEquals("Email: "+addEmailVal, myAccountPage.getAddressEmailData());
		Assert.assertEquals("Phone number: "+addPhoneNumberVal, myAccountPage.getAddressPhoneNumberData());
		Assert.assertEquals("Fax number: "+addFaxNumberVal, myAccountPage.getAddressFaxNumberData());
		Assert.assertEquals(addCompanyNameVal, myAccountPage.getAddressCompanyNameData());
		Assert.assertEquals(addAddress01Val, myAccountPage.getAddress01Data());
		Assert.assertEquals(addAddress02Val, myAccountPage.getAddress02Data());
		Assert.assertEquals(addCityNameVal +", "+addZipcodeVal, myAccountPage.getAddressCityStateData());
		Assert.assertEquals( addCountryVal, myAccountPage.getAddressCountryData());
		
	}

	//@Test
	public void TC03_Change_Account_Password() {

		emailVal = "spider_man_2019@gmail.com";
		passVal = "1234567";
		String newPasswordVal = "12345678";
		String changePassResultText = "Password was changed";
		String passErrMessage = "Login was unsuccessful. Please correct the errors and try again.\n" + 
				"The credentials provided are incorrect";
		
		myAccountPage.clickToChangePasswordLink();
		Assert.assertTrue(myAccountPage.isChangePasswordFormDisplayed());
	
		myAccountPage.inputToChangeOldPasswordTextbox(passVal);
		myAccountPage.inputToChangeNewPasswordTextbox(newPasswordVal);
		myAccountPage.inputToChangeConfirmNewPasswordTextbox(newPasswordVal);
		myAccountPage.clickToChangePasswordButton();
		
		Assert.assertEquals(changePassResultText, myAccountPage.getChangeNewPassResultMessageData());
		
		homePage = myAccountPage.clickToLogoutLink();
		loginPage = homePage.openLoginPage();
		
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passVal);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(passErrMessage, loginPage.getValidationErrorMessage());
		
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(newPasswordVal);
		homePage = loginPage.clickToLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	@Test
	public void TC04_Product_Review() {
		
		String productName = "Asus N551JK-XO076H Laptop";
		String titleVal = "Asus N551JK Review Title";
		String descriptionVal = "Asus N551JK Review Description";
		String addReviewResultMessage = "Product review is successfully added.";
		
		noteBooksPage = homePage.openNoteBooksPage();
		Assert.assertTrue(noteBooksPage.isNoteBookPageDisplayed());
		
		detailPage = noteBooksPage.openDetailPage();
		Assert.assertTrue(detailPage.isDetailPageDisplayed());
		Assert.assertEquals(productName, detailPage.getProductDetailTitleData());
		
		productReviewPage = detailPage.openProductReviewPage();
		Assert.assertTrue(productReviewPage.isProductReviewPageDisplayed());
		Assert.assertEquals(productName, productReviewPage.getProductReviewNameData());
		
		productReviewPage.inputToReviewTitleTexbox(titleVal);
		productReviewPage.inputToReviewDescriptionTextarea(descriptionVal);
		productReviewPage.clickToSubmitReviewButton();
		
		Assert.assertEquals(addReviewResultMessage, productReviewPage.getProductReviewResultMessageData());
		
		myAccountPage = productReviewPage.openMyAccountPage();
		
		myAccountPage.clickToMyProductReviewLink();
		Assert.assertTrue(myAccountPage.isMyProductReviewFormDisplayed());
		
		Assert.assertTrue(myAccountPage.isMyProductReviewTitleDisplayed(titleVal));
		Assert.assertTrue(myAccountPage.isMyProductReviewDescriptionDisplayed(descriptionVal));
		Assert.assertTrue(myAccountPage.isMyProductReviewInfoDisplayed(productName));
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
	
	@AfterClass
	public void afterClass() {
		driverManager.quitDriver();
	}

}
