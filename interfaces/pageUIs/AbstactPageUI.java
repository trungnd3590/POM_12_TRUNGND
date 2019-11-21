package pageUIs;

import org.openqa.selenium.By;

public class AbstactPageUI {

	public static final By HEADER_REGISTER_LINK = By.xpath("//a[@class='ico-register']");
	public static final By HEADER_LOGIN_LINK = By.xpath("//a[@class='ico-login']");
	public static final By HEADER_MY_ACCOUNT_LINK = By.xpath("//a[@class='ico-account']");
	public static final By HEADER_LOGIN_BUTTON = By.xpath("//input[@class='button-1 login-button']");
	public static final By HEADER_LOGOUT_LINK = By.xpath("//a[@class='ico-logout']");
	public static final By MENUBAR_COMPUTER_MENU = By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]");
	public static final By MENUBAR_NOTEBOOKS_LINK = By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Notebooks')]");
	public static final By NOTERBOOKS_ASUS_N551_PRODUCT = By.xpath("//a[contains(text(),'Asus N551JK-XO076H Laptop')]");
	public static final By ADD_YOUR_REVIEW_LINK = By.xpath("//a[contains(text(),'Add your review')]");
}
