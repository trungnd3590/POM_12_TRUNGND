package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactoryPattern.DriverManager;
import driverFactoryPattern.DriverManagerFactory;
import pageObjects.DetailPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NoteBooksPageObject;
import pageObjects.ProductComparePageObject;
import pageObjects.RecentViewProductPageObject;
import pageObjects.WishListPageObject;
import pageUIs.AbstactPageUI;
import pageUIs.DetailPageUI;
import pageUIs.HomePageUI;
import pageUIs.NoteBooksPageUI;
import pageUIs.ProductComparePageUI;
import pageUIs.WishListPageUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class FE_06_WishList_Compare_RecentView extends AbstractTest {

	private WebDriver driver;
	private DriverManager driverManager;
	private HomePageObject homePage;
	private NoteBooksPageObject noteBooksPage;
	private DetailPageObject detailPage;
	private LoginPageObject loginPage;
	private WishListPageObject wishListPage ;
	private ProductComparePageObject productComparePage;
	private RecentViewProductPageObject recentViewProductPage;
	
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
	public void TC01_Add_To_WishList() {
		
		String productName = "Asus N551JK-XO076H Laptop";
		String succesNotificationBar = "The product has been added to your wishlist";
		String wishListTitle = "Wishlist of auto mation";
		emailVal = "auto01@gmail.com";
		passVal = "123456";
		
		log.info("TC01_Add_To_WishList - Step 01 : Init HomePage");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("TC01_Add_To_WishList - Step 02 : Open Login Page Through Header Login Link");
		homePage.openHeaderDynamicPage(AbstactPageUI.A_CLASS_HEADER_LOGIN_LINK);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("TC01_Add_To_WishList - Step 03 : Login Account with valid Data");
		loginPage.inputToEmailTextbox(emailVal);
		loginPage.inputToPasswordTextbox(passVal);
		
		log.info("TC01_Add_To_WishList - Step 04 : Click to Login Button");
		loginPage.clickToLoginButton();
		
		log.info("TC01_Add_To_WishList - Step 05 : Verify login success and 'My Account' link is Displayed in Header");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("TC01_Add_To_WishList - Step 06 : Hover to 'Computers' Menu and Click to 'Notebooks' link");
		homePage.hoverToMenuBarName(HomePageUI.A_CONTAINS_TEXT_MENUBAR_COMPUTER);
		homePage.openMenuBarDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_NOTEBOOKS_LINK);
		
		log.info("TC01_Add_To_WishList - Step 07 : Open and Verify Notebook Page is Displayed");
		noteBooksPage = PageGeneratorManager.getNoteBooksPage(driver);
		verifyTrue(noteBooksPage.isNoteBookPageDisplayed());
		
		log.info("TC01_Add_To_WishList - Step 08 : Click to Open Asus N551 Product");
		noteBooksPage.openDetailDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_NOTERBOOKS_ASUS_N551_PRODUCT);
		detailPage = PageGeneratorManager.getDetailPage(driver);
		
		log.info("TC01_Add_To_WishList - Step 09 : Verify Asus N551 Product Detail Page is Displayed");
		verifyTrue(detailPage.isDetailPageDisplayed());
		
		log.info("TC01_Add_To_WishList - Step 10 : Verify Asus N551 Product Name is Matched");
		verifyEquals(productName, detailPage.getProductDetailTitleData(DetailPageUI.H1_CONTAINS_TEXT_PRODUCT_ASUS_N551_NAME));
		
		log.info("TC01_Add_To_WishList - Step 11 : Click to WishList Button");
		detailPage.clickToWishListButton();
		
		log.info("TC01_Add_To_WishList - Step 12 : Verify Add to Wishlist success notification message is Displayed");
		verifyTrue(detailPage.isDetailPageSuccesNotificationBarDisplayed());
		verifyEquals(detailPage.getDetailPageSuccesNotificationBarData(), succesNotificationBar);
		
		log.info("TC01_Add_To_WishList - Step 13 : Click to Notification Close Button");
		detailPage.clickToNotificationBarCloseButton();
		
		log.info("TC01_Add_To_WishList - Step 14 :  Open WishList Page Through Header Wishlist Link");
		detailPage.openDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_WISHLIST_NOTIFICATION_BAR);
		wishListPage = PageGeneratorManager.getWishListPage(driver);
		
		log.info("TC01_Add_To_WishList - Step 15 : Verify Wishlist Page is Displayed");
		verifyTrue(wishListPage.isWishListPageDisplayed());
		
		log.info("TC01_Add_To_WishList - Step 16 : Verify Asus N551 Product Name is Matched");
		verifyEquals(wishListPage.getWishListProductNameData(WishListPageUI.A_CLASS_WISHLIST_PAGE_PRODUCT_NAME), productName);
		
		log.info("TC01_Add_To_WishList - Step 17 : Click to Wishlist Share Button");
		wishListPage.clickToWishListShareLink();
		
		log.info("TC01_Add_To_WishList - Step 18 : Verify Wishlist Share Link Title is Displayed");
		verifyEquals(wishListPage.getWishListShareLinkTitleData(), wishListTitle);
		
		log.info("TC01_Add_To_WishList - Step 19 : Click back to Previoud Page");
		wishListPage.backToPage();
	}
	
	@Test
	public void TC02_Add_Product_To_Cart_From_WishList_Page() {
		
		String shoppingCartTitle = "Shopping cart";
		String wishListTitle = "Wishlist";
		String wishListEmptyMessage = "The wishlist is empty!";
		String productName = "Asus N551JK-XO076H Laptop";
		
		log.info("TC02_Add_Product_To_Cart_From_WishList_Page - Step 01 : Click to Add To Cart Check box");
		wishListPage.clickToAddToCartCheckbox();
		
		log.info("TC02_Add_Product_To_Cart_From_WishList_Page - Step 02 : Click to Add To Cart Button");
		wishListPage.clickToAddToCartButton();
		
		log.info("TC02_Add_Product_To_Cart_From_WishList_Page - Step 03 : Verify Wishlist Share Link Title is Displayed");
		verifyEquals(wishListPage.getWishListShareLinkTitleData(), shoppingCartTitle);
		
		log.info("TC02_Add_Product_To_Cart_From_WishList_Page - Step 04 : Verify Asus N551 Product Name is Matched");
		verifyEquals(wishListPage.getWishListProductNameData(WishListPageUI.A_CLASS_WISHLIST_PAGE_PRODUCT_NAME), productName);
		
		log.info("TC02_Add_Product_To_Cart_From_WishList_Page - Step 05 :  Open WishList Page Through Footer Wishlist Link");
		wishListPage.openFooterDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_FOOTER_WISHLIST_LINK);
		
		log.info("TC02_Add_Product_To_Cart_From_WishList_Page - Step 06 : Verify Wishlist Share Link Title is Displayed");
		verifyEquals(wishListPage.getWishListShareLinkTitleData(), wishListTitle);
		
		log.info("TC02_Add_Product_To_Cart_From_WishList_Page - Step 07 : Verify No Data Message is Displayed");
		verifyEquals(wishListPage.getNoDataMessageData(), wishListEmptyMessage);
	}
	
	@Test
	public void TC03_Remove_Product_In_WishList_Page() {
		
		String productName = "Asus N551JK-XO076H Laptop";
		String succesNotificationBar = "The product has been added to your wishlist";
		String wishListEmptyMessage = "The wishlist is empty!";
		
		log.info("TC03_Remove_Product_In_WishList_Page - Step 01 : Hover to 'Computers' Menu and Click to 'Notebooks' link");
		wishListPage.hoverToMenuBarName(HomePageUI.A_CONTAINS_TEXT_MENUBAR_COMPUTER);
		wishListPage.openMenuBarDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_NOTEBOOKS_LINK);
		
		log.info("TC03_Remove_Product_In_WishList_Page - Step 02 : Open and Verify Notebook Page is Displayed");
		noteBooksPage = PageGeneratorManager.getNoteBooksPage(driver);
		verifyTrue(noteBooksPage.isNoteBookPageDisplayed());
		
		log.info("TC03_Remove_Product_In_WishList_Page - Step 03 : Click to Open Asus N551 Product");
		noteBooksPage.openDetailDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_NOTERBOOKS_ASUS_N551_PRODUCT);
		detailPage = PageGeneratorManager.getDetailPage(driver);
		
		log.info("TC03_Remove_Product_In_WishList_Page - Step 04 : Verify Asus N551 Product Detail Page is Displayed");
		verifyTrue(detailPage.isDetailPageDisplayed());
		
		log.info("TC03_Remove_Product_In_WishList_Page - Step 05 : Verify Asus N551 Product Name is Matched");
		verifyEquals(productName, detailPage.getProductDetailTitleData(DetailPageUI.H1_CONTAINS_TEXT_PRODUCT_ASUS_N551_NAME));
		
		log.info("TC03_Remove_Product_In_WishList_Page - Step 06 : Click to WishList Button");
		detailPage.clickToWishListButton();
		
		log.info("TC03_Remove_Product_In_WishList_Page - Step 07 : Verify Add to Wishlist success notification message is Displayed");
		verifyTrue(detailPage.isDetailPageSuccesNotificationBarDisplayed());
		verifyEquals(detailPage.getDetailPageSuccesNotificationBarData(), succesNotificationBar);
		
		log.info("TC03_Remove_Product_In_WishList_Page - Step 08 : Click to Notification Close Button");
		detailPage.clickToNotificationBarCloseButton();
		
		log.info("TC03_Remove_Product_In_WishList_Page - Step 09 :  Open WishList Page Through Header Wishlist Link");
		detailPage.openDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_WISHLIST_NOTIFICATION_BAR);
		wishListPage = PageGeneratorManager.getWishListPage(driver);
		
		log.info("TC03_Remove_Product_In_WishList_Page - Step 10 : Verify Wishlist Page is Displayed");
		verifyTrue(wishListPage.isWishListPageDisplayed());
		
		log.info("TC03_Remove_Product_In_WishList_Page - Step 11 : Verify Asus N551 Product Name is Matched");
		verifyEquals(wishListPage.getWishListProductNameData(WishListPageUI.A_CLASS_WISHLIST_PAGE_PRODUCT_NAME), productName);
		
		log.info("TC03_Remove_Product_In_WishList_Page - Step 12 : Click to Remove Product Check box");
		wishListPage.clickToRemoveCheckbox();
		
		log.info("TC03_Remove_Product_In_WishList_Page - Step 13 : Click to Update Wishlist Button");
		wishListPage.clickToUpdateWishListButton();
		
		log.info("TC03_Remove_Product_In_WishList_Page - Step 14 : Verify No Data Message is Displayed");
		verifyEquals(wishListPage.getNoDataMessageData(), wishListEmptyMessage);
		
		log.info("TC03_Remove_Product_In_WishList_Page - Step 15 : Verify Asus N551 Product Name is Not Displayed");
		verifyFalse(wishListPage.isProductNameNotDisplayed(AbstactPageUI.A_CONTAINS_TEXT_NOTERBOOKS_ASUS_N551_PRODUCT));
		
	}
		
	@Test
	public void TC04_Add_Product_To_Compare() {
		
		String addToCartMessage = "The product has been added to your product comparison";
		String productComparePageTitle = "Compare products";
		String noDataMessage = "You have no items to compare.";
		String asusName = "Asus N551JK-XO076H Laptop";
		String asusPrice = "$1,500.00";
		String asusScreenSize = "15.6''";
		String asusCPU = "Intel Core i7";
		String macBookName = "Apple MacBook Pro 13-inch";
		String macBookPrice = "$1,800.00";
		String macBookScreenSize = "13.0''";
		String macBookCPU = "Intel Core i5";
		
		log.info("TC04_Add_Product_To_Compare - Step 01 : Open HomePage by click to HomePage Icon");
		homePage = wishListPage.clickHomePageIcon();
		
		log.info("TC04_Add_Product_To_Compare - Step 02 : Hover to 'Computers' Menu and Click to 'Notebooks' link");
		homePage.hoverToMenuBarName(HomePageUI.A_CONTAINS_TEXT_MENUBAR_COMPUTER);
		homePage.openMenuBarDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_NOTEBOOKS_LINK);
		
		log.info("TC04_Add_Product_To_Compare - Step 03 : Open and Verify Notebook Page is Displayed");
		noteBooksPage = PageGeneratorManager.getNoteBooksPage(driver);
		verifyTrue(noteBooksPage.isNoteBookPageDisplayed());
		
		log.info("TC04_Add_Product_To_Compare - Step 04 : Click and Add Macbook to Compare");
		noteBooksPage.addProductToCompare(NoteBooksPageUI.A_CONTAINS_TEXT_ADD_TO_COMPARE_MACBOOK_BUTTON);
		
		log.info("TC04_Add_Product_To_Compare - Step 05 : Verify Add to Compare success notification message is Displayed");
		verifyTrue(noteBooksPage.isNoteBookPageSuccesNotificationBarDisplayed());
		verifyEquals(noteBooksPage.getNoteBookPageSuccesNotificationBarData(), addToCartMessage);
		
		log.info("TC04_Add_Product_To_Compare - Step 06 : Click and Add Asus N551 to Compare");
		noteBooksPage.addProductToCompare(NoteBooksPageUI.A_CONTAINS_TEXT_ADD_TO_COMPARE_ASUS_N551_BUTTON);
		
		log.info("TC04_Add_Product_To_Compare - Step 07 : Verify Add to Compare success notification message is Displayed");
		verifyTrue(noteBooksPage.isNoteBookPageSuccesNotificationBarDisplayed());
		verifyEquals(noteBooksPage.getNoteBookPageSuccesNotificationBarData(), addToCartMessage);
		
		log.info("TC04_Add_Product_To_Compare - Step 08 : Open Product Compare Page Through Success Notification Link");
		noteBooksPage.openDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_ADD_TO_COMPARE_NOTIFICATION_BAR);
		productComparePage = PageGeneratorManager.getProductComparePage(driver);
		
		log.info("TC04_Add_Product_To_Compare - Step 09 : Verify Product Compare Page is Displayed");
		verifyEquals(productComparePage.getProductComparePageTitleData(), productComparePageTitle);
		
		log.info("TC04_Add_Product_To_Compare - Step 10 : Verify Product Compare Data is Displayed and Matched");
		verifyTrue(productComparePage.isNumberOfRemoveButtonMatched(2));
		verifyTrue(productComparePage.isNumberOfProductMatched(2));
		verifyTrue(productComparePage.isProductNameDisplayed(asusName));
		verifyTrue(productComparePage.isProductNameDisplayed(macBookName));
		verifyTrue(productComparePage.isNumberOfProductMatchedByRowName(2, ProductComparePageUI.A_CONTAINS_TEXT_PRODUCT_COMPARE_PRICE_TEXT));
		verifyTrue(productComparePage.isProductInfoDisplayedByRowName(asusPrice, ProductComparePageUI.A_CONTAINS_TEXT_PRODUCT_COMPARE_PRICE_TEXT));
		verifyTrue(productComparePage.isProductInfoDisplayedByRowName(macBookPrice,ProductComparePageUI.A_CONTAINS_TEXT_PRODUCT_COMPARE_PRICE_TEXT));
		verifyTrue(productComparePage.isNumberOfProductMatchedByRowName(2,ProductComparePageUI.A_CONTAINS_TEXT_PRODUCT_COMPARE_SCREENSIZE_TEXT));
		verifyTrue(productComparePage.isProductInfoDisplayedByRowName(asusScreenSize,ProductComparePageUI.A_CONTAINS_TEXT_PRODUCT_COMPARE_SCREENSIZE_TEXT));
		verifyTrue(productComparePage.isProductInfoDisplayedByRowName(macBookScreenSize,ProductComparePageUI.A_CONTAINS_TEXT_PRODUCT_COMPARE_SCREENSIZE_TEXT));
		verifyTrue(productComparePage.isNumberOfProductMatchedByRowName(2,ProductComparePageUI.A_CONTAINS_TEXT_PRODUCT_COMPARE_CPU_TEXT));
		verifyTrue(productComparePage.isProductInfoDisplayedByRowName(asusCPU,ProductComparePageUI.A_CONTAINS_TEXT_PRODUCT_COMPARE_CPU_TEXT));
		verifyTrue(productComparePage.isProductInfoDisplayedByRowName(macBookCPU,ProductComparePageUI.A_CONTAINS_TEXT_PRODUCT_COMPARE_CPU_TEXT));

		log.info("TC04_Add_Product_To_Compare - Step 11 : Verify Clear List Button is Displayed");
		verifyTrue(productComparePage.isClearListButtonDisplayed());
		
		log.info("TC04_Add_Product_To_Compare - Step 12 : Click to Clear List Button");
		productComparePage.clickToClearListButton(); 
		
		log.info("TC04_Add_Product_To_Compare - Step 13 : Verify Product Compare Data are Cleared and No Data Message is Displayed");
		verifyTrue(productComparePage.isProductCompareTableNotDisplayed());
		verifyEquals(productComparePage.getNoDataMessageData(), noDataMessage);
	}
	
	@Test
	public void TC05_Recent_View_Product() {
		
		String asusName = "Asus N551JK-XO076H Laptop";
		String macBookName = "Apple MacBook Pro 13-inch";
		String hpEnvyName = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
		String hpSpectreName = "HP Spectre XT Pro UltraBook";
		String lenovoThinkPadName = "Lenovo Thinkpad X1 Carbon Laptop";
		String recentViewProduct = "Recently viewed products";
		
		log.info("TC05_Recent_View_Product - Step 01 : Open HomePage by click to HomePage Icon");
		homePage = productComparePage.clickHomePageIcon();
		
		log.info("TC05_Recent_View_Product - Step 02 : Hover to 'Computers' Menu and Click to 'Notebooks' link");
		homePage.hoverToMenuBarName(HomePageUI.A_CONTAINS_TEXT_MENUBAR_COMPUTER);
		homePage.openMenuBarDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_NOTEBOOKS_LINK);
		
		log.info("TC05_Recent_View_Product - Step 03 : Open and Verify Notebook Page is Displayed");
		noteBooksPage = PageGeneratorManager.getNoteBooksPage(driver);
		verifyTrue(noteBooksPage.isNoteBookPageDisplayed());
		
		log.info("TC05_Recent_View_Product - Step 04 : Click to Open Asus N551 Product");
		noteBooksPage.openDetailDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_NOTERBOOKS_ASUS_N551_PRODUCT);
		
		log.info("TC05_Recent_View_Product - Step 05 : Verify Asus N551 Product Detail Page is Displayed");
		detailPage = PageGeneratorManager.getDetailPage(driver);
		verifyTrue(detailPage.isDetailPageDisplayed());
		
		log.info("TC05_Recent_View_Product - Step 06 : Hover to 'Computers' Menu and Click to 'Notebooks' link");
		detailPage.hoverToMenuBarName(HomePageUI.A_CONTAINS_TEXT_MENUBAR_COMPUTER);
		detailPage.openMenuBarDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_NOTEBOOKS_LINK);
		
		log.info("TC05_Recent_View_Product - Step 07 : Open and Verify Notebook Page is Displayed");
		noteBooksPage = PageGeneratorManager.getNoteBooksPage(driver);
		verifyTrue(noteBooksPage.isNoteBookPageDisplayed());
		
		log.info("TC05_Recent_View_Product - Step 08 : Click to Open Mackbook Product");
		noteBooksPage.openDetailDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_NOTERBOOKS_APPLE_MACBOOK_PRODUCT);
		
		log.info("TC05_Recent_View_Product - Step 09 : Verify Macbook Product Detail Page is Displayed");
		detailPage = PageGeneratorManager.getDetailPage(driver);
		verifyTrue(detailPage.isDetailPageDisplayed());
		
		log.info("TC05_Recent_View_Product - Step 10 : Hover to 'Computers' Menu and Click to 'Notebooks' link");
		detailPage.hoverToMenuBarName(HomePageUI.A_CONTAINS_TEXT_MENUBAR_COMPUTER);
		detailPage.openMenuBarDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_NOTEBOOKS_LINK);
		
		log.info("TC05_Recent_View_Product - Step 11 : Open and Verify Notebook Page is Displayed");
		noteBooksPage = PageGeneratorManager.getNoteBooksPage(driver);
		verifyTrue(noteBooksPage.isNoteBookPageDisplayed());
		
		log.info("TC05_Recent_View_Product - Step 12 : Click to Open HP Envy Product");
		noteBooksPage.openDetailDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_NOTERBOOKS_HP_ENVY_PRODUCT);
		
		log.info("TC05_Recent_View_Product - Step 13 : Verify HP Envy Product Detail Page is Displayed");
		detailPage = PageGeneratorManager.getDetailPage(driver);
		verifyTrue(detailPage.isDetailPageDisplayed());
		
		log.info("TC05_Recent_View_Product - Step 14 : Hover to 'Computers' Menu and Click to 'Notebooks' link");
		detailPage.hoverToMenuBarName(HomePageUI.A_CONTAINS_TEXT_MENUBAR_COMPUTER);
		detailPage.openMenuBarDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_NOTEBOOKS_LINK);
		
		log.info("TC05_Recent_View_Product - Step 15 : Open and Verify Notebook Page is Displayed");
		noteBooksPage = PageGeneratorManager.getNoteBooksPage(driver);
		verifyTrue(noteBooksPage.isNoteBookPageDisplayed());
		
		log.info("TC05_Recent_View_Product - Step 16 : Click to Open HP Spectre Product");
		noteBooksPage.openDetailDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_NOTERBOOKS_HP_SPECTRE_PRODUCT);
		
		log.info("TC05_Recent_View_Product - Step 17 : Verify HP Spectre Product Detail Page is Displayed");
		detailPage = PageGeneratorManager.getDetailPage(driver);
		verifyTrue(detailPage.isDetailPageDisplayed());
		
		log.info("TC05_Recent_View_Product - Step 18 : Hover to 'Computers' Menu and Click to 'Notebooks' link");
		detailPage.hoverToMenuBarName(HomePageUI.A_CONTAINS_TEXT_MENUBAR_COMPUTER);
		detailPage.openMenuBarDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_NOTEBOOKS_LINK);
		
		log.info("TC05_Recent_View_Product - Step 19 : Open and Verify Notebook Page is Displayed");
		noteBooksPage = PageGeneratorManager.getNoteBooksPage(driver);
		verifyTrue(noteBooksPage.isNoteBookPageDisplayed());
		
		log.info("TC05_Recent_View_Product - Step 20 : Click to Open Lenovo ThinkPad Product");
		noteBooksPage.openDetailDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_NOTERBOOKS_LENOVO_THINKPAD_PRODUCT);
		
		log.info("TC05_Recent_View_Product - Step 21 : Verify Lenovo ThinkPad Product Detail Page is Displayed");
		detailPage = PageGeneratorManager.getDetailPage(driver);
		verifyTrue(detailPage.isDetailPageDisplayed());
		
		log.info("TC05_Recent_View_Product - Step 22 : Click to Open Recent View Products Page");
		detailPage.openFooterDynamicPage(AbstactPageUI.A_CONTAINS_TEXT_RECENT_REVIEW_PRODUCTS_LINK);
		
		log.info("TC05_Recent_View_Product - Step 23 : Verify Recent View Products Page is Displayed");
		recentViewProductPage = PageGeneratorManager.getRecentViewProductPage(driver);
		verifyTrue(recentViewProductPage.isRecentViewProductPageTitleDisplayed());
		verifyTrue(recentViewProductPage.isRecentViewProductPageFormDisplayed());
		
		log.info("TC05_Recent_View_Product - Step 24 : Verify 3 Recent View Products are Displayed");
		verifyTrue(recentViewProductPage.isNumberOfProductNameMatched(3));
		verifyTrue(recentViewProductPage.isProductNameDisplayed(hpEnvyName));
		verifyTrue(recentViewProductPage.isProductNameDisplayed(hpSpectreName));
		verifyTrue(recentViewProductPage.isProductNameDisplayed(lenovoThinkPadName));
	}

	@AfterClass
	public void afterClass() {
		driverManager.quitDriver();
	}

}
