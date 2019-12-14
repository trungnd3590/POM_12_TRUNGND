package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.DesktopPageObject;
import pageObjects.DetailPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.NoteBooksPageObject;
import pageObjects.ProductComparePageObject;
import pageObjects.ProductReviewPageObject;
import pageObjects.RecentViewProductPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.SearchPageObject;
import pageObjects.ShoppingCartPageObject;
import pageObjects.WishListPageObject;

public class PageGeneratorManager {

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
	
	public static NoteBooksPageObject getNoteBooksPage(WebDriver driver) {
		return new NoteBooksPageObject(driver);
	}
	
	public static DetailPageObject getDetailPage(WebDriver driver) {
		return new DetailPageObject(driver);
	}
	
	public static ProductReviewPageObject getProductReviewPage(WebDriver driver) {
		return new ProductReviewPageObject(driver);
	}
	
	public static SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);
	}
	
	public static WishListPageObject getWishListPage(WebDriver driver) {
		return new WishListPageObject(driver);
	}
	
	public static ProductComparePageObject getProductComparePage(WebDriver driver) {
		return new ProductComparePageObject(driver);
	}
	
	public static RecentViewProductPageObject getRecentViewProductPage(WebDriver driver) {
		return new RecentViewProductPageObject(driver);
	}
	
	public static DesktopPageObject getDesktopPage(WebDriver driver) {
		return new DesktopPageObject(driver);
	}
	
	public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
		return new ShoppingCartPageObject(driver);
	}
}
