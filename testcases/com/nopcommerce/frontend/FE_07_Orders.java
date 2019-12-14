package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactoryPattern.DriverManager;
import driverFactoryPattern.DriverManagerFactory;
import pageObjects.DesktopPageObject;
import pageObjects.DetailPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.NoteBooksPageObject;
import pageObjects.ShoppingCartPageObject;
import pageUIs.AbstactPageUI;
import pageUIs.DetailPageUI;
import pageUIs.HomePageUI;
import pageUIs.MyAccountPageUI;
import pageUIs.ShoppingCartPageUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class FE_07_Orders extends AbstractTest {

	private WebDriver driver;
	private DriverManager driverManager;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private DetailPageObject detailPage;
	private DesktopPageObject desktopPage;
	private NoteBooksPageObject noteBooksPage;
	private ShoppingCartPageObject shoppingCartPage;
	private MyAccountPageObject myAccountPage;
	
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
	public void TC01_Add_Product_To_Cart() throws Exception {
		
		emailVal = "auto01@gmail.com";
		passVal = "123456";
		String productName = "Build your own computer";
		String processorVal = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
		String ramVal = "8GB [+$60.00]";
		String miniShoppingCartCount = "There are 1 item(s) in your cart.";
		String miniShoppingCartAttibutes = "Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]\n" + 
				"RAM: 8GB [+$60.00]\n" + 
				"HDD: 400 GB [+$100.00]\n" + 
				"OS: Vista Premium [+$60.00]\n" + 
				"Software: Microsoft Office [+$50.00]\n" + 
				"Software: Acrobat Reader [+$10.00]\n" + 
				"Software: Total Commander [+$5.00]";
		String miniShoppingCartPrice = "$1,500.00";
		String miniShoppingCartQuantity = "1";
		String miniShoppingCartTotals = "$1,500.00";
		String shoppingCartAddSuccessMessage = "The product has been added to your shopping cart";
		String shoppingCartPageTitle = "Shopping cart";
		String totalPriceVal ;
		
		log.info("TC01_Add_Product_To_Cart - Step 01 : Init HomePage");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("TC01_Add_Product_To_Cart - Step 02 : Open Login Page Through Header Login Link");
		homePage.openHeaderDynamicPage(AbstactPageUI.A_CLASS_HEADER_LOGIN_LINK);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("TC01_Add_Product_To_Cart - Step 03 : Login Account with valid Data");
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passVal);
		
		log.info("TC01_Add_Product_To_Cart - Step 04 : Click to Login Button");
		loginPage.clickToLoginButton();
		
		log.info("TC01_Add_Product_To_Cart - Step 05 : Verify login success and 'My Account' link is Displayed in Header");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("TC01_Add_Product_To_Cart - Step 06 : Hover to 'Computers' Menu and Click to 'Desktop' link");
		homePage.hoverToMenuBarName(HomePageUI.A_CONTAINS_TEXT_MENUBAR_COMPUTER);
		homePage.openMenuBarDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_DESKTOP_LINK);
		
		log.info("TC01_Add_Product_To_Cart - Step 07 : Open and Verify Desktop Page is Displayed");
		desktopPage = PageGeneratorManager.getDesktopPage(driver);
		verifyTrue(desktopPage.isDesktopPageDisplayed());
		
		log.info("TC01_Add_Product_To_Cart - Step 08 : Click to Open 'Build your own Computer' Product");
		desktopPage.openDetailDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_DESKTOPS_BUILD_YOUR_OWN_COMPUTER);
		
		log.info("TC01_Add_Product_To_Cart - Step 09 : Verify 'Build your own Computer' Product Detail Page is Displayed");
		detailPage = PageGeneratorManager.getDetailPage(driver);
		verifyEquals(detailPage.getProductDetailTitleData(DetailPageUI.H1_CONTAINS_TEXT_PRODUCT_BUILD_YOUR_COMPUTERS_NAME), productName);
		
		log.info("TC01_Add_Product_To_Cart - Step 10 : Fill the Data in 'Build your own Computer' Product Detail Page");
		detailPage.selectDataFromDropdown(processorVal, DetailPageUI.SELECT_ID_PROCESSOR_DROPDOWN);
		detailPage.selectDataFromDropdown(ramVal, DetailPageUI.SELECT_ID_RAM_DROPDOWN);
		detailPage.clickToRadioButton(DetailPageUI.INPUT_ID_HDD_400GB_RADIO_BUTTON);
		detailPage.clickToRadioButton(DetailPageUI.INPUT_ID_OS_VISTA_PREMIUM_RADIO_BUTTON);
		detailPage.clickToCheckbox(DetailPageUI.INPUT_ID_SOFTWARE_ACROBAT_CHECKBOX);
		detailPage.clickToCheckbox(DetailPageUI.INPUT_ID_SOFTWARE_TOTAL_COMMANDER_CHECKBOX);
		
		log.info("TC01_Add_Product_To_Cart - Step 11 : Get Unit Price Data");
		totalPriceVal = detailPage.getUnitPriceData();
		
		log.info("TC01_Add_Product_To_Cart - Step 12 : Click to Add To Cart Button");
		detailPage.clickToAddToCartButton();
		
		log.info("TC01_Add_Product_To_Cart - Step 13 : Verify Add to Cart success notification message is Displayed");
		verifyTrue(detailPage.isDetailPageSuccesNotificationBarDisplayed());
		verifyEquals(detailPage.getDetailPageSuccesNotificationBarData(), shoppingCartAddSuccessMessage);
		
		/*
		 * Thread.sleep(3000); detailPage.clickToNotificationBarCloseButton();
		 * Thread.sleep(3000); detailPage.hoverToHeaderShoppingCart();
		 * Thread.sleep(3000);
		 * verifyTrue(detailPage.isMiniShoppingCartDisplayed());
		 * verifyEquals(detailPage.getMiniShoppingCartByValue(AbstactPageUI.
		 * DIV_CLASS_DYNAMIC, AbstactPageUI.DIV_CLASS_MINI_SHOPPING_CART_COUNTS),
		 * miniShoppingCartCount); verifyEquals(AbstactPageUI.DIV_CLASS_DYNAMIC,
		 * AbstactPageUI.DIV_CLASS_MINI_SHOPPING_CART_NAME, productName);
		 * verifyEquals(AbstactPageUI.SHOPPING_CART_HEADER_ATTRIBUTES,
		 * miniShoppingCartAttibutes);
		 * verifyEquals(AbstactPageUI.DIV_CLASS_DYNAMIC,
		 * AbstactPageUI.DIV_CLASS_MINI_SHOPPING_CART_PRICE, miniShoppingCartPrice);
		 * verifyEquals(AbstactPageUI.DIV_CLASS_DYNAMIC,
		 * AbstactPageUI.DIV_CLASS_MINI_SHOPPING_CART_QUANTITY,
		 * miniShoppingCartQuantity);
		 * verifyEquals(AbstactPageUI.DIV_CLASS_DYNAMIC,
		 * AbstactPageUI.DIV_CLASS_MINI_SHOPPING_CART_TOTALS, miniShoppingCartTotals);
		 */
		/*
		 * detailPage.clickToMiniShoppingCartButton(); shoppingCardPage =
		 * PageGeneratorManager.getShoppingCartPage(driver);
		 */
		
		  log.info("TC01_Add_Product_To_Cart - Step 14 :  Open Shopping Cart Page Through Header Shopping Cart Link");	
		  detailPage.openDynamicPage(DetailPageUI.A_CONTAINS_TEXT_SHOPPING_CART_NOTIFICATION_BAR); 
		  
		  log.info("TC01_Add_Product_To_Cart - Step 15 : Verify Shopping Cart Page is Displayed");
		  shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		  verifyTrue(shoppingCartPage.isShoppingCartPageDisplayed());
		  
		  log.info("TC01_Add_Product_To_Cart - Step 16 : Verify Product Data is Displayed and Matched");
		  verifyEquals(shoppingCartPage.getShoppingCartPageTitle(),shoppingCartPageTitle);
		  verifyEquals(shoppingCartPage.getShoppingCartProductNameData(ShoppingCartPageUI.A_CLASS_SHOPPING_CART_PAGE_PRODUCT_NAME), productName);
		  verifyEquals(shoppingCartPage.getShoppingCartProductData(ShoppingCartPageUI.PRODUCT_DETAIL),miniShoppingCartAttibutes);
		  verifyEquals(shoppingCartPage.getShoppingCartProductData(ShoppingCartPageUI.PRODUCT_UNIT_PRICE_TEXT), miniShoppingCartPrice);
		  verifyEquals(shoppingCartPage.getShoppingCartQuantityData("value"), miniShoppingCartQuantity);
		  verifyEquals(shoppingCartPage.getShoppingCartProductData(AbstactPageUI.SPAN_CLASS_DYNAMIC, ShoppingCartPageUI.SPAN_CLASS_PRODUCT_SUB_TOTAL_TEXT), miniShoppingCartTotals);
		 
	}
	
	@Test
	public void TC02_Edit_Product_In_Shopping_Cart() {
		
		String processorVal = "2.2 GHz Intel Pentium Dual-Core E2200";
		String ramVal = "4GB [+$20.00]";
		String totalPriceVal ;
		String productName = "Build your own computer";
		String miniShoppingCartAttibutes = "Processor: 2.2 GHz Intel Pentium Dual-Core E2200\n" + 
				"RAM: 4GB [+$20.00]\n" + 
				"HDD: 320 GB\n" + 
				"OS: Vista Home [+$50.00]\n" + 
				"Software: Microsoft Office [+$50.00]";
		String miniShoppingCartPrice = "$1,320.00";
		String miniShoppingCartQuantity = "1";
		String miniShoppingCartTotals = "$1,320.00";
		String shoppingCartAddSuccessMessage = "The product has been added to your shopping cart";
		String shoppingCartPageTitle = "Shopping cart";
		
		log.info("TC02_Edit_Product_In_Shopping_Cart - Step 01 : Click to Edit Product Button");
		shoppingCartPage.clickToEditProductButton();
		
		log.info("TC02_Edit_Product_In_Shopping_Cart - Step 02 : Verify 'Build your own Computer' Product Detail Page is Displayed");
		detailPage = PageGeneratorManager.getDetailPage(driver);
		verifyEquals(detailPage.getProductDetailTitleData(DetailPageUI.H1_CONTAINS_TEXT_PRODUCT_BUILD_YOUR_COMPUTERS_NAME), productName);
		
		log.info("TC02_Edit_Product_In_Shopping_Cart - Step 03 : Fill the Data in 'Build your own Computer' Product Detail Page");
		detailPage.selectDataFromDropdown(processorVal, DetailPageUI.SELECT_ID_PROCESSOR_DROPDOWN);
		detailPage.selectDataFromDropdown(ramVal, DetailPageUI.SELECT_ID_RAM_DROPDOWN);
		detailPage.clickToRadioButton(DetailPageUI.INPUT_ID_HDD_320GB_RADIO_BUTTON);
		detailPage.clickToRadioButton(DetailPageUI.INPUT_ID_OS_VISTA_HOME_RADIO_BUTTON);
		detailPage.unClickToCheckbox(DetailPageUI.INPUT_ID_SOFTWARE_ACROBAT_CHECKBOX);
		detailPage.unClickToCheckbox(DetailPageUI.INPUT_ID_SOFTWARE_TOTAL_COMMANDER_CHECKBOX);
		
		log.info("TC02_Edit_Product_In_Shopping_Cart - Step 04 : Get Unit Price Data");
		totalPriceVal = detailPage.getUnitPriceData();
		
		log.info("TC02_Edit_Product_In_Shopping_Cart - Step 05 : Click to Add To Cart Button");
		detailPage.clickToAddToCartButton();
		
		log.info("TC02_Edit_Product_In_Shopping_Cart - Step 06 : Verify Add to Cart success notification message is Displayed");
		verifyTrue(detailPage.isDetailPageSuccesNotificationBarDisplayed());
		verifyEquals(detailPage.getDetailPageSuccesNotificationBarData(), shoppingCartAddSuccessMessage);
		
		log.info("TC02_Edit_Product_In_Shopping_Cart - Step 07 :  Open Shopping Cart Page Through Header Shopping Cart Link");	
		detailPage.openDynamicPage(DetailPageUI.A_CONTAINS_TEXT_SHOPPING_CART_NOTIFICATION_BAR); 
		
		log.info("TC02_Edit_Product_In_Shopping_Cart - Step 08 : Verify Shopping Cart Page is Displayed");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		verifyTrue(shoppingCartPage.isShoppingCartPageDisplayed());
		
		log.info("TC02_Edit_Product_In_Shopping_Cart - Step 09 : Verify Product Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getShoppingCartPageTitle(),shoppingCartPageTitle);
		verifyEquals(shoppingCartPage.getShoppingCartProductNameData(ShoppingCartPageUI.A_CLASS_SHOPPING_CART_PAGE_PRODUCT_NAME), productName);
		verifyEquals(shoppingCartPage.getShoppingCartProductData(ShoppingCartPageUI.PRODUCT_DETAIL),miniShoppingCartAttibutes);
		verifyEquals(shoppingCartPage.getShoppingCartProductData(ShoppingCartPageUI.PRODUCT_UNIT_PRICE_TEXT), miniShoppingCartPrice);
		verifyEquals(shoppingCartPage.getShoppingCartQuantityData("value"), miniShoppingCartQuantity);
		verifyEquals(shoppingCartPage.getShoppingCartProductData(AbstactPageUI.SPAN_CLASS_DYNAMIC, ShoppingCartPageUI.SPAN_CLASS_PRODUCT_SUB_TOTAL_TEXT), miniShoppingCartTotals);
	}
	
	@Test
	public void TC03_Remove_From_Cart() {
		
		String noDataMessage = "Your Shopping Cart is empty!";
		
		log.info("TC03_Remove_From_Cart - Step 01 : Click to Remove Checkbox");
		shoppingCartPage.clickToRemoveCheckbox();
		
		log.info("TC03_Remove_From_Cart - Step 01 : Click to Update Shopping Cart Button");
		shoppingCartPage.clickToUpdateShoppingCartButton();
		
		log.info("TC03_Remove_From_Cart - Step 03 : Verify Product Data are Cleared and No Data Message is Displayed");
		verifyEquals(shoppingCartPage.getNoDataMessage(), noDataMessage);
		verifyFalse(shoppingCartPage.isProductNotDisplayed());
		
	}
		
	@Test
	public void TC04_Update_Shopping_Cart() {
		
		String productName = "Lenovo IdeaCentre 600 All-in-One PC";
		String shoppingCartAddSuccessMessage = "The product has been added to your shopping cart";
		String shoppingCartPageTitle = "Shopping cart";
		String totalPriceVal = "$2,500.00";
		
		log.info("TC04_Update_Shopping_Cart - Step 01 : Hover to 'Computers' Menu and Click to 'Desktop' link");
		shoppingCartPage.hoverToMenuBarName(HomePageUI.A_CONTAINS_TEXT_MENUBAR_COMPUTER);
		shoppingCartPage.openMenuBarDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_DESKTOP_LINK);
		
		log.info("TC04_Update_Shopping_Cart - Step 02 : Open and Verify Desktop Page is Displayed");
		desktopPage = PageGeneratorManager.getDesktopPage(driver);
		verifyTrue(desktopPage.isDesktopPageDisplayed());
		
		log.info("TC04_Update_Shopping_Cart - Step 03 : Click to Open 'Lenovo Idea Centre 600' Product");
		desktopPage.openDetailDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_DESKTOPS_LENOVO_IDEA_CENTRE_600);
		
		log.info("TC04_Update_Shopping_Cart - Step 04 : Verify 'Lenovo Idea Centre 600' Product Detail Page is Displayed");
		detailPage = PageGeneratorManager.getDetailPage(driver);
		verifyEquals(detailPage.getProductDetailTitleData(DetailPageUI.H1_CONTAINS_TEXT_PRODUCT_LENOVO_IDEA_CENTRE_600_NAME), productName);
		
		log.info("TC04_Update_Shopping_Cart - Step 05 : Add the quantity to 5 ");
		detailPage.addMoreQuantity("5");
		
		log.info("TC04_Update_Shopping_Cart - Step 06 : Click to Add To Cart Button");
		detailPage.clickToAddToCartButton();
		
		log.info("TC04_Update_Shopping_Cart - Step 07 : Verify Add to Cart success notification message is Displayed");
		verifyTrue(detailPage.isDetailPageSuccesNotificationBarDisplayed());
		verifyEquals(detailPage.getDetailPageSuccesNotificationBarData(), shoppingCartAddSuccessMessage);
		
		log.info("TC04_Update_Shopping_Cart - Step 08 :  Open Shopping Cart Page Through Header Shopping Cart Link");	
		detailPage.openDynamicPage(DetailPageUI.A_CONTAINS_TEXT_SHOPPING_CART_NOTIFICATION_BAR); 
		
		log.info("TC04_Update_Shopping_Cart - Step 09 : Verify Shopping Cart Page is Displayed");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		verifyTrue(shoppingCartPage.isShoppingCartPageDisplayed());
		
		log.info("TC04_Update_Shopping_Cart - Step 10 : Verify Product Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getShoppingCartPageTitle(),shoppingCartPageTitle);
		verifyEquals(shoppingCartPage.getShoppingCartProductNameData(ShoppingCartPageUI.A_CLASS_SHOPPING_CART_PAGE_PRODUCT_NAME), productName);
		verifyEquals(shoppingCartPage.getShoppingCartQuantityData("value"), "5");
		verifyEquals(shoppingCartPage.getShoppingCartProductData(AbstactPageUI.SPAN_CLASS_DYNAMIC, ShoppingCartPageUI.SPAN_CLASS_PRODUCT_SUB_TOTAL_TEXT), totalPriceVal);
		
		log.info("TC04_Update_Shopping_Cart - Step 11 : Click to Remove Checkbox");
		shoppingCartPage.clickToRemoveCheckbox();
		
		log.info("TC04_Update_Shopping_Cart - Step 12 : Click to Update Shooping Cart Button");
		shoppingCartPage.clickToUpdateShoppingCartButton();
	}
	
	@Test
	public void TC05_Checkout_Order_Product_By_Cheque() {
		
		String productName = "Apple MacBook Pro 13-inch";
		String shoppingCartAddSuccessMessage = "The product has been added to your shopping cart";
		String shoppingCartPageTitle = "Shopping cart";
		String skuVal,unitPriceVal,quantityVal,totalPriceVal,subTotalVal,shippingCostVal,taxVal,orderNumberTextVal,orderNumVal ;
		
		int randomVal01 = randomNumber();
		String bFirstNameVal = "auto" + randomVal01;
		String bLastNameVal = "mation" + randomVal01;
		String bCityVal = "John_Wick" + randomVal01;
		String bAddress01Val = "Entertainment" + randomVal01; 
		String bZipCode = randomVal01 + "";
		String bPhoneNumberVal = randomVal01 + "" + randomVal01;
		
		int randomVal02 = randomNumber();
		String sFirstNameVal = "auto" + randomVal02;
		String sLastNameVal = "mation" + randomVal02;
		String sCityVal = "John_Wick" + randomVal02;
		String sAddress01Val = "Entertainment" + randomVal02; 
		String sZipCode = randomVal02 + "";
		String sPhoneNumberVal = randomVal02 + "" + randomVal02;
		
		String sectionPaymentInfoVal = "Mail Personal or Business Check, Cashier's Check or money order to:\n" + 
				"\n" + 
				"NOP SOLUTIONS\n" + 
				"your address here,\n" + 
				"New York, NY 10001\n" + 
				"USA\n" + 
				"Notice that if you pay by Personal or Business Check, your order may be held for up to 10 days after we receive your check to allow enough time for the check to clear. If you want us to ship faster upon receipt of your payment, then we recommend your send a money order or Cashier's check.\n" + 
				"P.S. You can edit this text from admin panel.";
		
		String customerOrderDetailTitle = "Order information";
		String confirmOrferBillingAddressTitle = "Billing Address";
		String confirmOrferShippingAddressTitle = "Shipping Address";
		String confirmOrferPaymentMethodTitle = "Payment";
		String confirmOrferShippingMethodTitle = "Shipping";
		String moneyOrderPaymentMethodInfo = "Check / Money Order";
		String shippingMethodInfo = "Ground";
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 01 : Open HomePage by click to HomePage Icon");
		homePage = shoppingCartPage.clickHomePageIcon();
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 02 : Hover to 'Computers' Menu and Click to 'Notebooks' link");
		homePage.hoverToMenuBarName(HomePageUI.A_CONTAINS_TEXT_MENUBAR_COMPUTER);
		homePage.openMenuBarDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_NOTEBOOKS_LINK);
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 03 : Open and Verify Notebook Page is Displayed");
		noteBooksPage = PageGeneratorManager.getNoteBooksPage(driver);
		verifyTrue(noteBooksPage.isNoteBookPageDisplayed());
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 04 : Click to Open Macbook Product");
		noteBooksPage.openDetailDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_NOTERBOOKS_APPLE_MACBOOK_PRODUCT);
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 05 : Verify Macbook Product Detail Page is Displayed");
		detailPage = PageGeneratorManager.getDetailPage(driver);
		verifyTrue(detailPage.isDetailPageDisplayed());
		verifyEquals(productName, detailPage.getProductDetailTitleData(DetailPageUI.H1_CONTAINS_TEXT_PRODUCT_APPLE_MACBOOK_NAME));
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 06 : Get Unit Price Data");
		totalPriceVal = detailPage.getUnitPriceData();
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 07 : Click to Add To Cart Button");
		detailPage.clickToAddToCartButton();
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 08 : Verify Add to Cart success notification message is Displayed");
		verifyTrue(detailPage.isDetailPageSuccesNotificationBarDisplayed());
		verifyEquals(detailPage.getDetailPageSuccesNotificationBarData(), shoppingCartAddSuccessMessage);
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 09 : Open Shopping Cart Page Through Success Notification Link");
		detailPage.openDynamicPage(DetailPageUI.A_CONTAINS_TEXT_SHOPPING_CART_NOTIFICATION_BAR); 
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 10 : Verify Shopping Cart Page is Displayed");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		verifyTrue(shoppingCartPage.isShoppingCartPageDisplayed());
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 11 : Verify Product Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getShoppingCartPageTitle(),shoppingCartPageTitle);
		verifyEquals(shoppingCartPage.getShoppingCartProductNameData(ShoppingCartPageUI.A_CLASS_SHOPPING_CART_PAGE_PRODUCT_NAME), productName);
		verifyEquals(shoppingCartPage.getShoppingCartQuantityData("value"), "2");
		verifyEquals(shoppingCartPage.getShoppingCartProductData(AbstactPageUI.SPAN_CLASS_DYNAMIC, ShoppingCartPageUI.SPAN_CLASS_PRODUCT_SUB_TOTAL_TEXT), "$3,600.00");
		verifyEquals(shoppingCartPage.getCheckOutTotalOrderValue(), "$3,600.00");
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 12 : Get Data to Compare");
		skuVal = shoppingCartPage.getShoppingCartProductData(AbstactPageUI.SPAN_CLASS_DYNAMIC, ShoppingCartPageUI.SPAN_CLASS_PRODUCT_SKU_TEXT);
		unitPriceVal = shoppingCartPage.getShoppingCartProductData(AbstactPageUI.SPAN_CLASS_DYNAMIC, ShoppingCartPageUI.SPAN_CLASS_PRODUCT_UNIT_PRICE_TEXT);
		quantityVal = shoppingCartPage.getShoppingCartQuantityData("value");
		subTotalVal = shoppingCartPage.getShoppingCartProductData(ShoppingCartPageUI.CONFIRM_ORDER_SUB_TOTAL_TEXT);
		shippingCostVal = shoppingCartPage.getShoppingCartProductData(ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_COST_TEXT);
		taxVal = shoppingCartPage.getShoppingCartProductData(ShoppingCartPageUI.CONFIRM_ORDER_TAX_TEXT);
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 13 : Fill Valid Data in Checkout Form");
		shoppingCartPage.selectCheckOutCountryFromDropdown("Viet Nam");
		shoppingCartPage.inputToZipPortalCodeTextBox("550000");
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 14 : Click to Term Of Service Checkbox");
		shoppingCartPage.clickToTermOfServiceCheckbox();
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 15 : Click to CheckOut Button");
		shoppingCartPage.clickToCheckOutButton();
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 16 : Verify Billing Address Form is Displayed");
		verifyTrue(shoppingCartPage.isBillingAddressFormDisplayed());
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 17 : Uncheck To Shipping Same Method Checkbox");
		shoppingCartPage.unCheckToShippingSameAddressCheckBox();
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 18 : Select Data from Billing Addres Dropdown list");
		shoppingCartPage.selectCheckOutBillingAddressFromDropdown("New Address");
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 19 : Verify Edit Billing Address Form is Displayed");
		verifyTrue(shoppingCartPage.isCheckOutEditAddressFormDisplayed());
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 20 : Fill Data to Edit Billing Address Form ");
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bFirstNameVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_FIRST_NAME_TEXT_BOX);
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bLastNameVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_LAST_NAME_TEXT_BOX);
		shoppingCartPage.selectCheckOutBillingCountryFromDropdown("Viet Nam");
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bCityVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_CITY_TEXT_BOX);
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bAddress01Val, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_ADDRESS01_TEXT_BOX);
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bZipCode, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_ZIP_PORTAL_CODE_TEXT_BOX);
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bPhoneNumberVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_PHONE_NUMBER_TEXT_BOX);
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 21 : Click to Billing Address Continue Button");
		shoppingCartPage.clickToBillingAddressContinueButton();
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 22 : Verify Shipping Address Form is Displayed");
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 23 : Uncheck To Shipping Same Method Checkbox");
		shoppingCartPage.unCheckToShippingSameAddressCheckBox();
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 24 : Select Data from Shipping Addres Dropdown list");
		shoppingCartPage.selectCheckOutShippingAddressFromDropdown("New Address");
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 25 : Verify Edit Shipping Address Form is Displayed");
		verifyTrue(shoppingCartPage.isCheckOutEditAddressFormDisplayed());
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 26 : Fill Data to Edit Shipping Address Form ");
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sFirstNameVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_FIRST_NAME_TEXT_BOX);
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sLastNameVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_LAST_NAME_TEXT_BOX);
		shoppingCartPage.selectCheckOutShipplingCountryFromDropdown("Viet Nam");
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sCityVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_CITY_TEXT_BOX);
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sAddress01Val, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_ADDRESS01_TEXT_BOX);
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sZipCode, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_ZIP_PORTAL_CODE_TEXT_BOX);
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sPhoneNumberVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_PHONE_NUMBER_TEXT_BOX);
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 27 : Click to Shipping Address Continue Button");
		shoppingCartPage.clickToShippingAddressContinueButton();
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 28 : Verify Shipping Method Form is Displayed");
		verifyTrue(shoppingCartPage.isCheckoutShippingMethodFormDisplayed());
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 29 : Click to Shipping Method Continue Button");
		shoppingCartPage.clickToCheckoutShippingMethodContinueButton();
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 30 : Verify Payment Method Form is Displayed");
		verifyTrue(shoppingCartPage.isCheckoutPaymentMethodFormDisplayed());
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 31 : Click to Payment Method Continue Button");
		shoppingCartPage.clickToCheckoutPaymentMethodContinueButton();
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 32 : Verify Section Payment Info Form is Displayed");
		verifyTrue(shoppingCartPage.isSectionPaymentInfoFormDisplayed());
		verifyEquals(shoppingCartPage.getSectionPaymentInfoValue(), sectionPaymentInfoVal);
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 33 : Click to  Section Payment Info Continue Button");
		shoppingCartPage.clickToSectionPaymentInfoContinueButton();
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 34 : Verify Confirm Order Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderFormDisplayed());
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 35 : Verify Confirm Order Billing Address Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderBillingAddressFormDisplayed());
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressTitle(), confirmOrferBillingAddressTitle);
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 36 : Verify Confirm Order Billing Address Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_NAME_TEXT), bFirstNameVal + " " + bLastNameVal);
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_EMAIL_TEXT), "Email: auto01@gmail.com");
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_PHONE_TEXT), "Phone: " + bPhoneNumberVal);
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_FAX_TEXT), "Fax:");
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_ADDRESS01_TEXT), bAddress01Val);
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_CITY_STATE_ZIP_TEXT), bCityVal + ", " + bZipCode);
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_COUNTRY_TEXT), "Viet Nam");
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 37 : Verify Confirm Order Shipping Address Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderShippingAddressFormDisplayed());
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressTitle(), confirmOrferShippingAddressTitle);
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 38 : Verify Confirm Order Shipping Address Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_NAME_TEXT), sFirstNameVal + " " + sLastNameVal);
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_EMAIL_TEXT), "Email: auto01@gmail.com");
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_PHONE_TEXT), "Phone: " + sPhoneNumberVal);
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_FAX_TEXT), "Fax:");
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_ADDRESS01_TEXT), sAddress01Val);
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_CITY_STATE_ZIP_TEXT), sCityVal + ", " + sZipCode);
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_COUNTRY_TEXT), "Viet Nam");
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 39 : Verify Confirm Order Payment Method Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderPaymentMethodFormDisplayed());
		verifyEquals(shoppingCartPage.getConfimOrderPaymentMethodTitle(), confirmOrferPaymentMethodTitle);
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 40 : Verify Confirm Order Payment Method Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getConfimOrderPaymentMethodValue(), "Payment Method: " + moneyOrderPaymentMethodInfo);
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 41 : Verify Confirm Order Shipping Method Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderShippingMethodFormDisplayed());
		verifyEquals(shoppingCartPage.getConfimOrderShippingMethodTitle(), confirmOrferShippingMethodTitle);
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 42 : Verify Confirm Order Shipping Method Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getConfimOrderShippingMethodValue(), "Shipping Method: " + shippingMethodInfo);
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 43 : Verify Confirm Order Shopping Cart Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderShoppingCartFormDisplayed());
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 44 : Verify Confirm Order Shopping Cart Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartProductSkuValue(), skuVal);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartProductNameValue(), productName);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartProductUnitPriceValue(), unitPriceVal);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartProductQuantityValue(), quantityVal);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartProductTotalPriceValue(), "$3,600.00");
		
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartOptionsSubTotalValue(), subTotalVal);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartOptionsShippingCostValue(), shippingCostVal);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartOptionsTaxCostValue(), taxVal);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartOptionsTotalCostValue(), "$3,600.00");
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 45 : Click to  Confirm Order Confirm Button");
		shoppingCartPage.clickToConfirmOrderConfirmButton();
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 46 : Verify CheckOut Complete Form is Displayed");
		verifyTrue(shoppingCartPage.isCheckOutCompleteFormDisplayed());
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 47 : Verify CheckOut Complete Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getCheckOutCompleteFormTile(), "Thank you");
		verifyEquals(shoppingCartPage.getCheckOutCompleteFormInfoValue(), "Your order has been successfully processed!");
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 48 : Get Order Number Data");
		orderNumberTextVal = shoppingCartPage.getOrderNumberTextValue();
		orderNumVal = shoppingCartPage.getOrderNumberValue();
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 49 : Open My Account Page Through My Account Link");
		shoppingCartPage.openHeaderDynamicPage(AbstactPageUI.A_CLASS_HEADER_MY_ACCOUNT_LINK);
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 50 : Verify 'My Account' Page is Displayed ");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		verifyTrue(myAccountPage.isMyAccountPageDisplayed());
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 51 : Open 'Customer Order' Form by Click to 'Customer Order' side-menu");
		myAccountPage.clickToCustomerOrderLink();
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 52 : Verify 'Customer Order' Form is Displayed ");
		verifyTrue(myAccountPage.isCustomerOrderFormrDisplayed());
		verifyTrue(myAccountPage.isOrderNumberDisplayed(orderNumberTextVal));
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 53 : Open 'Customer Order Detail' Form by Click to 'Customer Order Detail' icon");
		myAccountPage.clickToOpenOrderDetail(orderNumberTextVal);
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 54 : Verify 'Customer Order Detail' Form is Displayed ");
		verifyTrue(myAccountPage.isCustomerOrderDetailDisplayed());
		verifyTrue(myAccountPage.isCustomerOrderDetailNumberDisplayed(orderNumVal));
		verifyEquals(myAccountPage.getCustomerOrderDetailStatus(), "Order Status: Pending");
		verifyEquals(myAccountPage.getCustomerOrderDetailTotal(), "Order Total: "+"$3,600.00");
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 55 : Verify Billing Address Form Data is Displayed and Matched");
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingTitle(), confirmOrferBillingAddressTitle);
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_FIRST_LAST_NAME_TEXT), bFirstNameVal + " " + bLastNameVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_EMAIL_TEXT), "Email: auto01@gmail.com");
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_PHONENUMBER_TEXT), "Phone: " + bPhoneNumberVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_FAXNUMBER_TEXT), "Fax:");
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_ADDRESS01_TEXT), bAddress01Val);
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_CITY_ZIPCODE_TEXT), bCityVal + ", " + bZipCode);
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_COUNTRY_TEXT), "Viet Nam");
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 56 : Verify Shipping Address Form Data is Displayed and Matched");
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingTitle(), confirmOrferShippingAddressTitle);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_FIRST_LAST_NAME_TEXT), sFirstNameVal + " " + sLastNameVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_EMAIL_TEXT), "Email: auto01@gmail.com");
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_PHONENUMBER_TEXT), "Phone: " + sPhoneNumberVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_FAXNUMBER_TEXT), "Fax:");
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_ADDRESS01_TEXT), sAddress01Val);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_CITY_ZIPCODE_TEXT), sCityVal + ", " + sZipCode);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_COUNTRY_TEXT), "Viet Nam");
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 57 : Verify Payment Method Form Data is Displayed and Matched");
		verifyEquals(myAccountPage.getCustomerOrderDetailPaymentMethodTitle(), confirmOrferPaymentMethodTitle);
		verifyEquals(myAccountPage.getCustomerOrderDetailPaymentMethodInfo(), "Payment Method: " + moneyOrderPaymentMethodInfo);
		verifyEquals(myAccountPage.getCustomerOrderDetailPaymentMethodStatus(), "Payment Status: Pending");
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 58 : Verify Shipping Method Form Data is Displayed and Matched");
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingMethodTitle(), confirmOrferShippingMethodTitle);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingMethodInfo(), "Shipping Method: " + shippingMethodInfo);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingMethodStatus(),"Shipping Status: Not yet shipped");
		
		log.info("TC05_Checkout_Order_Product_By_Cheque - Step 59 : Verify Shopping Cart Form Data is Displayed and Matched");
		verifyEquals(myAccountPage.getCustomerOrderDetailProductSkuValue(), skuVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductNameValue(), productName);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductUnitPriceValue(), unitPriceVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductQuantityValue(), quantityVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductTotalPriceValue(), "$3,600.00");
		
		verifyEquals(myAccountPage.getCustomerOrderDetailProductSubTotalCostValue(),subTotalVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductShippingCostValue(), shippingCostVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductTaxCostValue(), taxVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductTotalCostValue(), "$3,600.00");
	}
	
	@Test
	public void TC06_Checkout_Order_Product_By_Visa_Master() {
		
		emailVal = "auto01@gmail.com";
		passVal = "123456";
		String productName = "Apple MacBook Pro 13-inch";
		String shoppingCartAddSuccessMessage = "The product has been added to your shopping cart";
		String shoppingCartPageTitle = "Shopping cart";
		String skuVal,unitPriceVal,quantityVal,totalPriceVal,subTotalVal,shippingCostVal,taxVal,orderNumberTextVal,orderNumVal ;
		
		int randomVal01 = randomNumber();
		String bFirstNameVal = "auto" + randomVal01;
		String bLastNameVal = "mation" + randomVal01;
		String bCityVal = "John_Wick" + randomVal01;
		String bAddress01Val = "Entertainment" + randomVal01; 
		String bZipCode = randomVal01 + "";
		String bPhoneNumberVal = randomVal01 + "" + randomVal01;
		
		int randomVal02 = randomNumber();
		String sFirstNameVal = "auto" + randomVal02;
		String sLastNameVal = "mation" + randomVal02;
		String sCityVal = "John_Wick" + randomVal02;
		String sAddress01Val = "Entertainment" + randomVal02; 
		String sZipCode = randomVal02 + "";
		String sPhoneNumberVal = randomVal02 + "" + randomVal02;
		String cardHolder =  "Addison Robinson";
		String cardNumber =  "4880776376588648";
		String cardCode = "3423";
		
		String sectionPaymentInfoVal = "Mail Personal or Business Check, Cashier's Check or money order to:\n" + 
				"\n" + 
				"NOP SOLUTIONS\n" + 
				"your address here,\n" + 
				"New York, NY 10001\n" + 
				"USA\n" + 
				"Notice that if you pay by Personal or Business Check, your order may be held for up to 10 days after we receive your check to allow enough time for the check to clear. If you want us to ship faster upon receipt of your payment, then we recommend your send a money order or Cashier's check.\n" + 
				"P.S. You can edit this text from admin panel.";
		
		String customerOrderDetailTitle = "Order information";
		String confirmOrferBillingAddressTitle = "Billing Address";
		String confirmOrferShippingAddressTitle = "Shipping Address";
		String confirmOrferPaymentMethodTitle = "Payment";
		String confirmOrferShippingMethodTitle = "Shipping";
		String moneyOrderPaymentMethodInfo = "Credit Card";
		String shippingMethodInfo = "Ground";
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 01 : Open HomePage by click to HomePage Icon");
		homePage = shoppingCartPage.clickHomePageIcon();
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 02 : Hover to 'Computers' Menu and Click to 'Notebooks' link");
		homePage.hoverToMenuBarName(HomePageUI.A_CONTAINS_TEXT_MENUBAR_COMPUTER);
		homePage.openMenuBarDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_NOTEBOOKS_LINK);
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 03 : Open and Verify Notebook Page is Displayed");
		noteBooksPage = PageGeneratorManager.getNoteBooksPage(driver);
		verifyTrue(noteBooksPage.isNoteBookPageDisplayed());
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 04 : Click to Open Macbook Product");
		noteBooksPage.openDetailDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_NOTERBOOKS_APPLE_MACBOOK_PRODUCT);
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 05 : Verify Macbook Product Detail Page is Displayed");
		detailPage = PageGeneratorManager.getDetailPage(driver);
		verifyTrue(detailPage.isDetailPageDisplayed());
		verifyEquals(productName, detailPage.getProductDetailTitleData(DetailPageUI.H1_CONTAINS_TEXT_PRODUCT_APPLE_MACBOOK_NAME));
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 06 : Get Unit Price Data");
		totalPriceVal = detailPage.getUnitPriceData();
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 07 : Click to Add To Cart Button");
		detailPage.clickToAddToCartButton();
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 08 : Verify Add to Cart success notification message is Displayed");
		verifyTrue(detailPage.isDetailPageSuccesNotificationBarDisplayed());
		verifyEquals(detailPage.getDetailPageSuccesNotificationBarData(), shoppingCartAddSuccessMessage);
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 09 : Open Shopping Cart Page Through Success Notification Link");
		detailPage.openDynamicPage(DetailPageUI.A_CONTAINS_TEXT_SHOPPING_CART_NOTIFICATION_BAR); 
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 10 : Verify Shopping Cart Page is Displayed");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		verifyTrue(shoppingCartPage.isShoppingCartPageDisplayed());
		verifyEquals(shoppingCartPage.getShoppingCartPageTitle(),shoppingCartPageTitle);
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 11 : Verify Product Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getShoppingCartProductNameData(ShoppingCartPageUI.A_CLASS_SHOPPING_CART_PAGE_PRODUCT_NAME), productName);
		verifyEquals(shoppingCartPage.getShoppingCartQuantityData("value"), "2");
		verifyEquals(shoppingCartPage.getShoppingCartProductData(AbstactPageUI.SPAN_CLASS_DYNAMIC, ShoppingCartPageUI.SPAN_CLASS_PRODUCT_SUB_TOTAL_TEXT), "$3,600.00");
		verifyEquals(shoppingCartPage.getCheckOutTotalOrderValue(), "$3,600.00");
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 12 : Get Data to Compare");
		skuVal = shoppingCartPage.getShoppingCartProductData(AbstactPageUI.SPAN_CLASS_DYNAMIC, ShoppingCartPageUI.SPAN_CLASS_PRODUCT_SKU_TEXT);
		unitPriceVal = shoppingCartPage.getShoppingCartProductData(AbstactPageUI.SPAN_CLASS_DYNAMIC, ShoppingCartPageUI.SPAN_CLASS_PRODUCT_UNIT_PRICE_TEXT);
		quantityVal = shoppingCartPage.getShoppingCartQuantityData("value");
		subTotalVal = shoppingCartPage.getShoppingCartProductData(ShoppingCartPageUI.CONFIRM_ORDER_SUB_TOTAL_TEXT);
		shippingCostVal = shoppingCartPage.getShoppingCartProductData(ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_COST_TEXT);
		taxVal = shoppingCartPage.getShoppingCartProductData(ShoppingCartPageUI.CONFIRM_ORDER_TAX_TEXT);
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 13 : Fill Valid Data in Checkout Form");
		shoppingCartPage.selectCheckOutCountryFromDropdown("Viet Nam");
		shoppingCartPage.inputToZipPortalCodeTextBox("550000");
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 14 : Click to Term Of Service Checkbox");
		shoppingCartPage.clickToTermOfServiceCheckbox();
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 15 : Click to CheckOut Button");
		shoppingCartPage.clickToCheckOutButton();
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 16 : Verify Billing Address Form is Displayed");
		verifyTrue(shoppingCartPage.isBillingAddressFormDisplayed());
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 17 : Uncheck To Shipping Same Method Checkbox");
		shoppingCartPage.unCheckToShippingSameAddressCheckBox();
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 18 : Select Data from Billing Addres Dropdown list");
		shoppingCartPage.selectCheckOutBillingAddressFromDropdown("New Address");
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 19 : Verify Edit Billing Address Form is Displayed");
		verifyTrue(shoppingCartPage.isCheckOutEditAddressFormDisplayed());
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 20 : Fill Data to Edit Billing Address Form ");
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bFirstNameVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_FIRST_NAME_TEXT_BOX);
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bLastNameVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_LAST_NAME_TEXT_BOX);
		shoppingCartPage.selectCheckOutBillingCountryFromDropdown("Viet Nam");
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bCityVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_CITY_TEXT_BOX);
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bAddress01Val, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_ADDRESS01_TEXT_BOX);
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bZipCode, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_ZIP_PORTAL_CODE_TEXT_BOX);
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bPhoneNumberVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_PHONE_NUMBER_TEXT_BOX);
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 21 : Click to Billing Address Continue Button");
		shoppingCartPage.clickToBillingAddressContinueButton();
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 22 : Verify Shipping Address Form is Displayed");
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 23 : Uncheck To Shipping Same Method Checkbox");
		shoppingCartPage.unCheckToShippingSameAddressCheckBox();
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 24 : Select Data from Shipping Addres Dropdown list");
		shoppingCartPage.selectCheckOutShippingAddressFromDropdown("New Address");
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 25 : Verify Edit Shipping Address Form is Displayed");
		verifyTrue(shoppingCartPage.isCheckOutEditAddressFormDisplayed());
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 26 : Fill Data to Edit Shipping Address Form ");
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sFirstNameVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_FIRST_NAME_TEXT_BOX);
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sLastNameVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_LAST_NAME_TEXT_BOX);
		shoppingCartPage.selectCheckOutShipplingCountryFromDropdown("Viet Nam");
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sCityVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_CITY_TEXT_BOX);
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sAddress01Val, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_ADDRESS01_TEXT_BOX);
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sZipCode, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_ZIP_PORTAL_CODE_TEXT_BOX);
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sPhoneNumberVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_PHONE_NUMBER_TEXT_BOX);
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 27 : Click to Shipping Address Continue Button");
		shoppingCartPage.clickToShippingAddressContinueButton();
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 28 : Verify Shipping Method Form is Displayed");
		verifyTrue(shoppingCartPage.isCheckoutShippingMethodFormDisplayed());
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 29 : Click to Shipping Method Continue Button");
		shoppingCartPage.clickToCheckoutShippingMethodContinueButton();
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 30 : Verify Payment Method Form is Displayed");
		verifyTrue(shoppingCartPage.isCheckoutPaymentMethodFormDisplayed());
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 31 : Click to  Credit Card Radio Button");
		shoppingCartPage.clickToCheckOutPaymentMethodCreditCardRadioButton();
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 32 : Click to Payment Method Continue Button");
		shoppingCartPage.clickToCheckoutPaymentMethodContinueButton();
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 33 : Verify Section Payment Info Form is Displayed");
		verifyTrue(shoppingCartPage.isCheckoutSectionPaymentInfoDisplayed());
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 34 : Fill Valid Data to Section Payment Info Form");
		shoppingCartPage.inputToCheckoutSectionPaymentCardHolderTextBox(cardHolder);
		shoppingCartPage.inputToCheckoutSectionPaymentCardNumberTextBox(cardNumber);
		shoppingCartPage.selectToCheckoutSectionPaymentExpireMonthDropdown("05");
		shoppingCartPage.selectToCheckoutSectionPaymentExpireYearDropdown("2024");
		shoppingCartPage.inputToCheckoutSectionPaymentCardCodeTextBox(cardCode);
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 35 : Click to  Section Payment Info Continue Button");
		shoppingCartPage.clickToSectionPaymentInfoContinueButton();
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 36 : Verify Confirm Order Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderFormDisplayed());
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 37 : Verify Confirm Order Billing Address Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderBillingAddressFormDisplayed());
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressTitle(), confirmOrferBillingAddressTitle);
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 38 : Verify Confirm Order Billing Address Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_NAME_TEXT), bFirstNameVal + " " + bLastNameVal);
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_EMAIL_TEXT), "Email: auto01@gmail.com");
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_PHONE_TEXT), "Phone: " + bPhoneNumberVal);
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_FAX_TEXT), "Fax:");
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_ADDRESS01_TEXT), bAddress01Val);
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_CITY_STATE_ZIP_TEXT), bCityVal + ", " + bZipCode);
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_COUNTRY_TEXT), "Viet Nam");
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 39 : Verify Confirm Order Shipping Address Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderShippingAddressFormDisplayed());
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressTitle(), confirmOrferShippingAddressTitle);
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 40 : Verify Confirm Order Shipping Address Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_NAME_TEXT), sFirstNameVal + " " + sLastNameVal);
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_EMAIL_TEXT), "Email: auto01@gmail.com");
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_PHONE_TEXT), "Phone: " + sPhoneNumberVal);
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_FAX_TEXT), "Fax:");
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_ADDRESS01_TEXT), sAddress01Val);
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_CITY_STATE_ZIP_TEXT), sCityVal + ", " + sZipCode);
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_COUNTRY_TEXT), "Viet Nam");
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 41 : Verify Confirm Order Payment Method Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderPaymentMethodFormDisplayed());
		verifyEquals(shoppingCartPage.getConfimOrderPaymentMethodTitle(), confirmOrferPaymentMethodTitle);
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 42 : Verify Confirm Order Payment Method Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getConfimOrderPaymentMethodValue(), "Payment Method: " + moneyOrderPaymentMethodInfo);
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 43 : Verify Confirm Order Shipping Method Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderShippingMethodFormDisplayed());
		verifyEquals(shoppingCartPage.getConfimOrderShippingMethodTitle(), confirmOrferShippingMethodTitle);
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 44 : Verify Confirm Order Shipping Method Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getConfimOrderShippingMethodValue(), "Shipping Method: " + shippingMethodInfo);
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 45 : Verify Confirm Order Shopping Cart Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderShoppingCartFormDisplayed());
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 46 : Verify Confirm Order Shopping Cart Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartProductSkuValue(), skuVal);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartProductNameValue(), productName);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartProductUnitPriceValue(), unitPriceVal);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartProductQuantityValue(), quantityVal);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartProductTotalPriceValue(), "$3,600.00");
		
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartOptionsSubTotalValue(), subTotalVal);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartOptionsShippingCostValue(), shippingCostVal);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartOptionsTaxCostValue(), taxVal);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartOptionsTotalCostValue(), "$3,600.00");
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 47 : Click to  Confirm Order Confirm Button");
		shoppingCartPage.clickToConfirmOrderConfirmButton();
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 48 : Verify CheckOut Complete Form is Displayed");
		verifyTrue(shoppingCartPage.isCheckOutCompleteFormDisplayed());
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 49 : Verify CheckOut Complete Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getCheckOutCompleteFormTile(), "Thank you");
		verifyEquals(shoppingCartPage.getCheckOutCompleteFormInfoValue(), "Your order has been successfully processed!");
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 50 : Get Order Number Data");
		orderNumberTextVal = shoppingCartPage.getOrderNumberTextValue();
		orderNumVal = shoppingCartPage.getOrderNumberValue();
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 51 : Open My Account Page Through My Account Link");
		shoppingCartPage.openHeaderDynamicPage(AbstactPageUI.A_CLASS_HEADER_MY_ACCOUNT_LINK);
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 52 : Verify 'My Account' Page is Displayed ");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 53 : Open 'Customer Order' Form by Click to 'Customer Order' side-menu");
		myAccountPage.clickToCustomerOrderLink();
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 54 : Verify 'Customer Order' Form is Displayed ");
		verifyTrue(myAccountPage.isCustomerOrderFormrDisplayed());
		verifyTrue(myAccountPage.isOrderNumberDisplayed(orderNumberTextVal));
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 55 : Open 'Customer Order Detail' Form by Click to 'Customer Order Detail' icon");
		myAccountPage.clickToOpenOrderDetail(orderNumberTextVal);
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 56 : Verify 'Customer Order Detail' Form is Displayed ");
		verifyTrue(myAccountPage.isCustomerOrderDetailDisplayed());
		verifyTrue(myAccountPage.isCustomerOrderDetailNumberDisplayed(orderNumVal));
		verifyEquals(myAccountPage.getCustomerOrderDetailStatus(), "Order Status: Pending");
		verifyEquals(myAccountPage.getCustomerOrderDetailTotal(), "Order Total: "+"$3,600.00");
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 57 : Verify Billing Address Form Data is Displayed and Matched");
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingTitle(), confirmOrferBillingAddressTitle);
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_FIRST_LAST_NAME_TEXT), bFirstNameVal + " " + bLastNameVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_EMAIL_TEXT), "Email: auto01@gmail.com");
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_PHONENUMBER_TEXT), "Phone: " + bPhoneNumberVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_FAXNUMBER_TEXT), "Fax:");
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_ADDRESS01_TEXT), bAddress01Val);
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_CITY_ZIPCODE_TEXT), bCityVal + ", " + bZipCode);
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_COUNTRY_TEXT), "Viet Nam");
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 58 : Verify Shipping Address Form Data is Displayed and Matched");
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingTitle(), confirmOrferShippingAddressTitle);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_FIRST_LAST_NAME_TEXT), sFirstNameVal + " " + sLastNameVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_EMAIL_TEXT), "Email: auto01@gmail.com");
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_PHONENUMBER_TEXT), "Phone: " + sPhoneNumberVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_FAXNUMBER_TEXT), "Fax:");
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_ADDRESS01_TEXT), sAddress01Val);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_CITY_ZIPCODE_TEXT), sCityVal + ", " + sZipCode);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_COUNTRY_TEXT), "Viet Nam");
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 59 : Verify Payment Method Form Data is Displayed and Matched");
		verifyEquals(myAccountPage.getCustomerOrderDetailPaymentMethodTitle(), confirmOrferPaymentMethodTitle);
		verifyEquals(myAccountPage.getCustomerOrderDetailPaymentMethodInfo(), "Payment Method: " + moneyOrderPaymentMethodInfo);
		verifyEquals(myAccountPage.getCustomerOrderDetailPaymentMethodStatus(), "Payment Status: Pending");
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 60 : Verify Shipping Method Form Data is Displayed and Matched");
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingMethodTitle(), confirmOrferShippingMethodTitle);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingMethodInfo(), "Shipping Method: " + shippingMethodInfo);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingMethodStatus(),"Shipping Status: Not yet shipped");
		
		log.info("TC06_Checkout_Order_Product_By_Visa_Master - Step 61 : Verify Shopping Cart Form Data is Displayed and Matched");
		verifyEquals(myAccountPage.getCustomerOrderDetailProductSkuValue(), skuVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductNameValue(), productName);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductUnitPriceValue(), unitPriceVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductQuantityValue(), quantityVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductTotalPriceValue(), "$3,600.00");
		
		verifyEquals(myAccountPage.getCustomerOrderDetailProductSubTotalCostValue(),subTotalVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductShippingCostValue(), shippingCostVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductTaxCostValue(), taxVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductTotalCostValue(), "$3,600.00");
	}
	
	@Test
	public void TC07_Re_Order_Product() {
		
		String productName = "Apple MacBook Pro 13-inch";
		String shoppingCartAddSuccessMessage = "The product has been added to your shopping cart";
		String shoppingCartPageTitle = "Shopping cart";
		String skuVal,unitPriceVal,quantityVal,totalPriceVal,subTotalVal,shippingCostVal,taxVal,orderNumberTextVal,orderNumVal ;
		
		int randomVal01 = randomNumber();
		String bFirstNameVal = "auto" + randomVal01;
		String bLastNameVal = "mation" + randomVal01;
		String bCityVal = "John_Wick" + randomVal01;
		String bAddress01Val = "Entertainment" + randomVal01; 
		String bZipCode = randomVal01 + "";
		String bPhoneNumberVal = randomVal01 + "" + randomVal01;
		
		int randomVal02 = randomNumber();
		String sFirstNameVal = "auto" + randomVal02;
		String sLastNameVal = "mation" + randomVal02;
		String sCityVal = "John_Wick" + randomVal02;
		String sAddress01Val = "Entertainment" + randomVal02; 
		String sZipCode = randomVal02 + "";
		String sPhoneNumberVal = randomVal02 + "" + randomVal02;
		String cardHolder =  "Addison Robinson";
		String cardNumber =  "4880776376588648";
		String cardCode = "3423";
		
		String sectionPaymentInfoVal = "Mail Personal or Business Check, Cashier's Check or money order to:\n" + 
				"\n" + 
				"NOP SOLUTIONS\n" + 
				"your address here,\n" + 
				"New York, NY 10001\n" + 
				"USA\n" + 
				"Notice that if you pay by Personal or Business Check, your order may be held for up to 10 days after we receive your check to allow enough time for the check to clear. If you want us to ship faster upon receipt of your payment, then we recommend your send a money order or Cashier's check.\n" + 
				"P.S. You can edit this text from admin panel.";
		
		String customerOrderDetailTitle = "Order information";
		String confirmOrferBillingAddressTitle = "Billing Address";
		String confirmOrferShippingAddressTitle = "Shipping Address";
		String confirmOrferPaymentMethodTitle = "Payment";
		String confirmOrferShippingMethodTitle = "Shipping";
		String moneyOrderPaymentMethodInfo = "Credit Card";
		String shippingMethodInfo = "Next Day Air";
		
		log.info("TC07_Re_Order_Product - Step 01 : Click to Re-Order Button in Customer Order Detail Form");
		myAccountPage.clickToCustomerOrderDetailReOrderButton();
		
		log.info("TC07_Re_Order_Product - Step 02 : Verify Shopping Cart Page is Displayed");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		verifyTrue(shoppingCartPage.isShoppingCartPageDisplayed());
		verifyEquals(shoppingCartPage.getShoppingCartPageTitle(),shoppingCartPageTitle);
	
		log.info("TC07_Re_Order_Product - Step 03 : Update the quantity to 10");
		shoppingCartPage.inputToShoppingCartQuantityTextBox("10");
		
		log.info("TC07_Re_Order_Product - Step 04 : Click to Update Shopping Cart Button");
		shoppingCartPage.clickToUpdateShoppingCartButton();
		
		log.info("TC07_Re_Order_Product - Step 05 : Verify Product Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getShoppingCartProductNameData(ShoppingCartPageUI.A_CLASS_SHOPPING_CART_PAGE_PRODUCT_NAME), productName);
		verifyEquals(shoppingCartPage.getShoppingCartQuantityData("value"), "10");
		verifyEquals(shoppingCartPage.getShoppingCartProductData(AbstactPageUI.SPAN_CLASS_DYNAMIC, ShoppingCartPageUI.SPAN_CLASS_PRODUCT_SUB_TOTAL_TEXT), "$18,000.00");
		verifyEquals(shoppingCartPage.getCheckOutTotalOrderValue(), "$18,000.00");
		
		log.info("TC07_Re_Order_Product - Step 06 : Get Data to Compare");
		skuVal = shoppingCartPage.getShoppingCartProductData(AbstactPageUI.SPAN_CLASS_DYNAMIC, ShoppingCartPageUI.SPAN_CLASS_PRODUCT_SKU_TEXT);
		unitPriceVal = shoppingCartPage.getShoppingCartProductData(AbstactPageUI.SPAN_CLASS_DYNAMIC, ShoppingCartPageUI.SPAN_CLASS_PRODUCT_UNIT_PRICE_TEXT);
		quantityVal = shoppingCartPage.getShoppingCartQuantityData("value");
		subTotalVal = shoppingCartPage.getShoppingCartProductData(ShoppingCartPageUI.CONFIRM_ORDER_SUB_TOTAL_TEXT);
		shippingCostVal = shoppingCartPage.getShoppingCartProductData(ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_COST_TEXT);
		taxVal = shoppingCartPage.getShoppingCartProductData(ShoppingCartPageUI.CONFIRM_ORDER_TAX_TEXT);
		
		log.info("TC07_Re_Order_Product - Step 07 : Fill Valid Data in Checkout Form");
		shoppingCartPage.selectCheckOutCountryFromDropdown("Viet Nam");
		shoppingCartPage.inputToZipPortalCodeTextBox("550000");
		
		log.info("TC07_Re_Order_Product - Step 08 : Click to Term Of Service Checkbox");
		shoppingCartPage.clickToTermOfServiceCheckbox();
		
		log.info("TC07_Re_Order_Product - Step 09 : Click to CheckOut Button");
		shoppingCartPage.clickToCheckOutButton();
		
		log.info("TC07_Re_Order_Product - Step 10 : Verify Billing Address Form is Displayed");
		verifyTrue(shoppingCartPage.isBillingAddressFormDisplayed());
		
		log.info("TC07_Re_Order_Product - Step 11 : Uncheck To Shipping Same Method Checkbox");
		shoppingCartPage.unCheckToShippingSameAddressCheckBox();
		
		log.info("TC07_Re_Order_Product - Step 12 : Select Data from Billing Addres Dropdown list");
		shoppingCartPage.selectCheckOutBillingAddressFromDropdown("New Address");
		
		log.info("TC07_Re_Order_Product - Step 13 : Verify Edit Billing Address Form is Displayed");
		verifyTrue(shoppingCartPage.isCheckOutEditAddressFormDisplayed());
		
		log.info("TC07_Re_Order_Product - Step 14 : Fill Data to Edit Billing Address Form ");
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bFirstNameVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_FIRST_NAME_TEXT_BOX);
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bLastNameVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_LAST_NAME_TEXT_BOX);
		shoppingCartPage.selectCheckOutBillingCountryFromDropdown("Viet Nam");
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bCityVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_CITY_TEXT_BOX);
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bAddress01Val, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_ADDRESS01_TEXT_BOX);
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bZipCode, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_ZIP_PORTAL_CODE_TEXT_BOX);
		shoppingCartPage.inputToCheckOutBillingAddessTextBoxByValue(bPhoneNumberVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_BILLING_PHONE_NUMBER_TEXT_BOX);
		
		log.info("TC07_Re_Order_Product - Step 15 : Click to Billing Address Continue Button");
		shoppingCartPage.clickToBillingAddressContinueButton();
		
		log.info("TC07_Re_Order_Product - Step 16 : Verify Shipping Address Form is Displayed");
		log.info("TC07_Re_Order_Product - Step 17 : Uncheck To Shipping Same Method Checkbox");
		shoppingCartPage.unCheckToShippingSameAddressCheckBox();
		
		log.info("TC07_Re_Order_Product - Step 18 : Select Data from Shipping Addres Dropdown list");
		shoppingCartPage.selectCheckOutShippingAddressFromDropdown("New Address");
		
		log.info("TC07_Re_Order_Product - Step 19 : Verify Edit Shipping Address Form is Displayed");
		verifyTrue(shoppingCartPage.isCheckOutEditAddressFormDisplayed());
		
		log.info("TC07_Re_Order_Product - Step 20 : Fill Data to Edit Shipping Address Form ");
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sFirstNameVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_FIRST_NAME_TEXT_BOX);
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sLastNameVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_LAST_NAME_TEXT_BOX);
		shoppingCartPage.selectCheckOutShipplingCountryFromDropdown("Viet Nam");
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sCityVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_CITY_TEXT_BOX);
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sAddress01Val, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_ADDRESS01_TEXT_BOX);
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sZipCode, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_ZIP_PORTAL_CODE_TEXT_BOX);
		shoppingCartPage.inputToCheckOutShippingAddessTextBoxByValue(sPhoneNumberVal, ShoppingCartPageUI.INPUT_ID_CHECK_OUT_SHIPPING_PHONE_NUMBER_TEXT_BOX);
		
		log.info("TC07_Re_Order_Product - Step 21 : Click to Shipping Address Continue Button");
		shoppingCartPage.clickToShippingAddressContinueButton();
		
		log.info("TC07_Re_Order_Product - Step 22 : Verify Shipping Method Form is Displayed");
		verifyTrue(shoppingCartPage.isCheckoutShippingMethodFormDisplayed());
		
		log.info("TC07_Re_Order_Product - Step 23 : Click to Shipping Method Next Day Air Radio Button");
		shoppingCartPage.clickToCheckOutShippingMethodNextDayAirRadioButton();
		
		log.info("TC07_Re_Order_Product - Step 24 : Click to Shipping Method Continue Button");
		shoppingCartPage.clickToCheckoutShippingMethodContinueButton();
		
		log.info("TC07_Re_Order_Product - Step 25 : Verify Payment Method Form is Displayed");
		verifyTrue(shoppingCartPage.isCheckoutPaymentMethodFormDisplayed());
		
		log.info("TC07_Re_Order_Product - Step 26 : Click to  Credit Card Radio Button");
		shoppingCartPage.clickToCheckOutPaymentMethodCreditCardRadioButton();
		
		log.info("TC07_Re_Order_Product - Step 27 : Click to Payment Method Continue Button");
		shoppingCartPage.clickToCheckoutPaymentMethodContinueButton();
		
		log.info("TC07_Re_Order_Product - Step 28 : Verify Section Payment Info Form is Displayed");
		verifyTrue(shoppingCartPage.isCheckoutSectionPaymentInfoDisplayed());
		
		log.info("TC07_Re_Order_Product - Step 29 : Fill Valid Data to Section Payment Info Form");
		shoppingCartPage.inputToCheckoutSectionPaymentCardHolderTextBox(cardHolder);
		shoppingCartPage.inputToCheckoutSectionPaymentCardNumberTextBox(cardNumber);
		shoppingCartPage.selectToCheckoutSectionPaymentExpireMonthDropdown("05");
		shoppingCartPage.selectToCheckoutSectionPaymentExpireYearDropdown("2024");
		shoppingCartPage.inputToCheckoutSectionPaymentCardCodeTextBox(cardCode);
		
		log.info("TC07_Re_Order_Product - Step 30 : Click to  Section Payment Info Continue Button");
		shoppingCartPage.clickToSectionPaymentInfoContinueButton();
		
		log.info("TC07_Re_Order_Product - Step 31 : Verify Confirm Order Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderFormDisplayed());
		
		log.info("TC07_Re_Order_Product - Step 32 : Verify Confirm Order Billing Address Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderBillingAddressFormDisplayed());
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressTitle(), confirmOrferBillingAddressTitle);
		
		log.info("TC07_Re_Order_Product - Step 33 : Verify Confirm Order Billing Address Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_NAME_TEXT), bFirstNameVal + " " + bLastNameVal);
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_EMAIL_TEXT), "Email: auto01@gmail.com");
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_PHONE_TEXT), "Phone: " + bPhoneNumberVal);
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_FAX_TEXT), "Fax:");
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_ADDRESS01_TEXT), bAddress01Val);
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_CITY_STATE_ZIP_TEXT), bCityVal + ", " + bZipCode);
		verifyEquals(shoppingCartPage.getConfimOrderBillingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_COUNTRY_TEXT), "Viet Nam");
		
		log.info("TC07_Re_Order_Product - Step 34 : Verify Confirm Order Shipping Address Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderShippingAddressFormDisplayed());
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressTitle(), confirmOrferShippingAddressTitle);
		
		log.info("TC07_Re_Order_Product - Step 35 : Verify Confirm Order Shipping Address Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_NAME_TEXT), sFirstNameVal + " " + sLastNameVal);
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_EMAIL_TEXT), "Email: auto01@gmail.com");
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_PHONE_TEXT), "Phone: " + sPhoneNumberVal);
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_FAX_TEXT), "Fax:");
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_ADDRESS01_TEXT), sAddress01Val);
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_CITY_STATE_ZIP_TEXT), sCityVal + ", " + sZipCode);
		verifyEquals(shoppingCartPage.getConfimOrderShippingAddressValue(ShoppingCartPageUI.LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_COUNTRY_TEXT), "Viet Nam");
		
		log.info("TC07_Re_Order_Product - Step 36 : Verify Confirm Order Payment Method Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderPaymentMethodFormDisplayed());
		verifyEquals(shoppingCartPage.getConfimOrderPaymentMethodTitle(), confirmOrferPaymentMethodTitle);
		
		log.info("TC07_Re_Order_Product - Step 37 : Verify Confirm Order Payment Method Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getConfimOrderPaymentMethodValue(), "Payment Method: " + moneyOrderPaymentMethodInfo);
		
		log.info("TC07_Re_Order_Product - Step 38 : Verify Confirm Order Shipping Method Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderShippingMethodFormDisplayed());
		verifyEquals(shoppingCartPage.getConfimOrderShippingMethodTitle(), confirmOrferShippingMethodTitle);
		
		log.info("TC07_Re_Order_Product - Step 39 : Verify Confirm Order Shipping Method Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getConfimOrderShippingMethodValue(), "Shipping Method: " + shippingMethodInfo);
		
		log.info("TC07_Re_Order_Product - Step 40 : Verify Confirm Order Shopping Cart Form is Displayed");
		verifyTrue(shoppingCartPage.isConfirmOrderShoppingCartFormDisplayed());
		
		log.info("TC07_Re_Order_Product - Step 41 : Verify Confirm Order Shopping Cart Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartProductSkuValue(), skuVal);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartProductNameValue(), productName);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartProductUnitPriceValue(), unitPriceVal);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartProductQuantityValue(), quantityVal);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartProductTotalPriceValue(), "$18,000.00");
		
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartOptionsSubTotalValue(), "$18,000.00");
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartOptionsShippingCostValue(), shippingCostVal);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartOptionsTaxCostValue(), taxVal);
		verifyEquals(shoppingCartPage.getConfimOrderShoppingCartOptionsTotalCostValue(), "$18,000.00");
		
		log.info("TC07_Re_Order_Product - Step 42 : Click to  Confirm Order Confirm Button");
		//shoppingCartPage.sleepInSecond(5);
		shoppingCartPage.clickToConfirmOrderConfirmButton();
		//shoppingCartPage.sleepInSecond(5);
		//shoppingCartPage.acceptAlert();
		//shoppingCartPage.clickToConfirmOrderConfirmButton();
		
		log.info("TC07_Re_Order_Product - Step 43 : Verify CheckOut Complete Form is Displayed");
		verifyTrue(shoppingCartPage.isCheckOutCompleteFormDisplayed());
		//shoppingCartPage.sleepInSecond(5);
		
		log.info("TC07_Re_Order_Product - Step 44 : Verify CheckOut Complete Form Data is Displayed and Matched");
		verifyEquals(shoppingCartPage.getCheckOutCompleteFormTile(), "Thank you");
		verifyEquals(shoppingCartPage.getCheckOutCompleteFormInfoValue(), "Your order has been successfully processed!");
		
		log.info("TC07_Re_Order_Product - Step 45 : Get Order Number Data");
		orderNumberTextVal = shoppingCartPage.getOrderNumberTextValue();
		orderNumVal = shoppingCartPage.getOrderNumberValue();
		
		log.info("TC07_Re_Order_Product - Step 46 : Open My Account Page Through My Account Link");
		shoppingCartPage.openHeaderDynamicPage(AbstactPageUI.A_CLASS_HEADER_MY_ACCOUNT_LINK);
		log.info("TC07_Re_Order_Product - Step 47 : Verify 'My Account' Page is Displayed ");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		
		log.info("TC07_Re_Order_Product - Step 48 : Open 'Customer Order' Form by Click to 'Customer Order' side-menu");
		myAccountPage.clickToCustomerOrderLink();
		
		log.info("TC07_Re_Order_Product - Step 49 : Verify 'Customer Order' Form is Displayed ");
		verifyTrue(myAccountPage.isCustomerOrderFormrDisplayed());
		verifyTrue(myAccountPage.isOrderNumberDisplayed(orderNumberTextVal));
		
		log.info("TC07_Re_Order_Product - Step 50 : Open 'Customer Order Detail' Form by Click to 'Customer Order Detail' icon");
		myAccountPage.clickToOpenOrderDetail(orderNumberTextVal);
		
		log.info("TC07_Re_Order_Product - Step 51 : Verify 'Customer Order Detail' Form is Displayed ");
		verifyTrue(myAccountPage.isCustomerOrderDetailDisplayed());
		verifyTrue(myAccountPage.isCustomerOrderDetailNumberDisplayed(orderNumVal));
		verifyEquals(myAccountPage.getCustomerOrderDetailStatus(), "Order Status: Pending");
		verifyEquals(myAccountPage.getCustomerOrderDetailTotal(), "Order Total: "+"$18,000.00");
		
		log.info("TC07_Re_Order_Product - Step 52 : Verify Billing Address Form Data is Displayed and Matched");
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingTitle(), confirmOrferBillingAddressTitle);
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_FIRST_LAST_NAME_TEXT), bFirstNameVal + " " + bLastNameVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_EMAIL_TEXT), "Email: auto01@gmail.com");
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_PHONENUMBER_TEXT), "Phone: " + bPhoneNumberVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_FAXNUMBER_TEXT), "Fax:");
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_ADDRESS01_TEXT), bAddress01Val);
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_CITY_ZIPCODE_TEXT), bCityVal + ", " + bZipCode);
		verifyEquals(myAccountPage.getCustomerOrderDetailBillingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_COUNTRY_TEXT), "Viet Nam");
		
		log.info("TC07_Re_Order_Product - Step 53 : Verify Shipping Address Form Data is Displayed and Matched");
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingTitle(), confirmOrferShippingAddressTitle);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_FIRST_LAST_NAME_TEXT), sFirstNameVal + " " + sLastNameVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_EMAIL_TEXT), "Email: auto01@gmail.com");
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_PHONENUMBER_TEXT), "Phone: " + sPhoneNumberVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_FAXNUMBER_TEXT), "Fax:");
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_ADDRESS01_TEXT), sAddress01Val);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_CITY_ZIPCODE_TEXT), sCityVal + ", " + sZipCode);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingInfo(MyAccountPageUI.LI_CLASS_ADDRESS_COUNTRY_TEXT), "Viet Nam");
		
		log.info("TC07_Re_Order_Product - Step 54 : Verify Payment Method Form Data is Displayed and Matched");
		verifyEquals(myAccountPage.getCustomerOrderDetailPaymentMethodTitle(), confirmOrferPaymentMethodTitle);
		verifyEquals(myAccountPage.getCustomerOrderDetailPaymentMethodInfo(), "Payment Method: " + moneyOrderPaymentMethodInfo);
		verifyEquals(myAccountPage.getCustomerOrderDetailPaymentMethodStatus(), "Payment Status: Pending");
		
		log.info("TC07_Re_Order_Product - Step 55 : Verify Shipping Method Form Data is Displayed and Matched");
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingMethodTitle(), confirmOrferShippingMethodTitle);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingMethodInfo(), "Shipping Method: " + shippingMethodInfo);
		verifyEquals(myAccountPage.getCustomerOrderDetailShippingMethodStatus(),"Shipping Status: Not yet shipped");
		
		log.info("TC07_Re_Order_Product - Step 46 : Verify Shopping Cart Form Data is Displayed and Matched");
		verifyEquals(myAccountPage.getCustomerOrderDetailProductSkuValue(), skuVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductNameValue(), productName);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductUnitPriceValue(), unitPriceVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductQuantityValue(), quantityVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductTotalPriceValue(), "$18,000.00");
		
		verifyEquals(myAccountPage.getCustomerOrderDetailProductSubTotalCostValue(),"$18,000.00");
		verifyEquals(myAccountPage.getCustomerOrderDetailProductShippingCostValue(), shippingCostVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductTaxCostValue(), taxVal);
		verifyEquals(myAccountPage.getCustomerOrderDetailProductTotalCostValue(), "$18,000.00");
		
	}

	@AfterClass
	public void afterClass() {
		driverManager.quitDriver();
	}

}
