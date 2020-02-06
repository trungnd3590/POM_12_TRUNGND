package pageUIs;

public class AbstactPageUI {

	public static final String HOME_PAGE_LOGO = "//div[@class='header-logo']//a//img";
	public static final String SHOPPING_CART_HEADER_ATTRIBUTES = "//div[@class='mini-shopping-cart']//div[@class='attributes']";
	public static final String ADMIN_FORM_TITLE = "//h1[@class='pull-left']";
	
	public static final String A_CLASS_DYNAMIC = "//a[@class='%s']";
	public static final String A_CONTAINS_TEXT_DYNAMIC =  "//a[contains(text(),'%s')]";
	public static final String A_CONTAINS_TEXT_PRODUCT_TITLE_DYNAMIC = "//h2[@class='product-title']//a[contains(text(),'%s')]";
	public static final String A_CONTAINS_TEXT_MENUBAR_DYNAMIC = "//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	public static final String A_CONTAINS_TEXT_DYNAMIC_FOOTER = "//div[@class='footer']//a[contains(text(),'%s')]";
	public static final String A_CONTAINS_TEXT_PRODUCT_COMPARE_TEXT_DYNAMIC = "//label[contains(text(),'%s')]/parent::td/following-sibling::td";
	public static final String A_CONTAINS_TEXT_ADD_TO_COMPARE_DYNAMIC = "//a[contains(text(),'%s')]/parent::h2/following-sibling::div[@class='add-info']//input[@value='Add to compare list']";
	public static final String DIV_CLASS_DYNAMIC = "//div[@class='%s']";
	public static final String DIV_ID_DYNAMIC = "//div[@id='%s']";
	public static final String INPUT_NAME_DYNAMIC = "//input[@name='%s']";
	public static final String INPUT_CLASS_DYNAMIC = "//input[@class='%s']";
	public static final String INPUT_ID_DYNAMIC = "//input[@id='%s']";
	public static final String H1_CONTAINS_TEXT_DYNAMIC_PRODUCT = "//h1[contains(text(),'%s')]";
	public static final String LI_CLASS_DYNAMIC = "//li[@class='%s']";
	public static final String SELECT_ID_DYNAMIC = "//select[@id='%s']";
	public static final String SELECT_NAME_DYNAMIC = "//select[@name='%s']";
	public static final String SPAN_ID_DYNAMIC = "//span[@id='%s']";
	public static final String SPAN_CLASS_DYNAMIC = "//span[@class='%s']";
	
	public static final String A_CLASS_HEADER_REGISTER_LINK = "ico-register";
	public static final String A_CLASS_HEADER_LOGIN_LINK = "ico-login";
	public static final String A_CLASS_HEADER_MY_ACCOUNT_LINK = "ico-account";
	public static final String A_CLASS_HEADER_WISHLIST_LINK ="ico-wishlist";
	public static final String A_CLASS_HEADER_LOGOUT_LINK ="ico-logout";
	
	public static final String DIV_CLASS_PAGE_TITLE = "page-title";
	public static final String DIV_CLASS_MINI_SHOPPING_CART = "mini-shopping-cart";
	public static final String DIV_CLASS_MINI_SHOPPING_CART_COUNTS = "count";
	public static final String DIV_CLASS_MINI_SHOPPING_CART_NAME = "name";
	public static final String DIV_CLASS_MINI_SHOPPING_CART_PRICE = "mini-shopping-cart";
	public static final String DIV_CLASS_MINI_SHOPPING_CART_QUANTITY = "quantity";
	public static final String DIV_CLASS_MINI_SHOPPING_CART_TOTALS = "totals";
	public static final String DIV_CLASS_NO_DATA_MESSAGE = "no-data";
	
	public static final String INPUT_CLASS_HEADER_LOGIN_BUTTON= "button-1 login-button";
	public static final String INPUT_CLASS_MINI_SHOPPING_CART_BUTTON = "button-1 cart-button";
	
	public static final String SPAN_CLASS_HEADER_WISHLIST_LINK = "wishlist-label";
	public static final String SPAN_CLASS_HEADER_WISHLISH_NUMBER = "wishlist-qty";
	public static final String SPAN_CLASS_HEADER_SHOPPING_CART = "cart-label";
	
	public static final String A_CONTAINS_TEXT_MENUBAR_NOTEBOOKS_LINK = "Notebooks";
	public static final String A_CONTAINS_TEXT_MENUBAR_DESKTOP_LINK = "Desktops";
	
	public static final String A_CONTAINS_TEXT_FOOTER_SEARCH_PAGE_LINK = "Search";
	
	public static final String A_CONTAINS_TEXT_WISHLIST_NOTIFICATION_BAR = "wishlist";
	public static final String A_CONTAINS_TEXT_ADD_TO_COMPARE_NOTIFICATION_BAR = "product comparison";
	public static final String A_CONTAINS_TEXT_ADD_YOUR_REVIEW_LINK = "Add your review";
	public static final String A_CONTAINS_TEXT_RECENT_REVIEW_PRODUCTS_LINK = "Recently viewed products";
	public static final String A_CONTAINS_TEXT_FOOTER_WISHLIST_LINK = "Wishlist";
	public static final String A_CONTAINS_TEXT_NOTERBOOKS_ASUS_N551_PRODUCT = "Asus N551JK-XO076H Laptop";
	public static final String A_CONTAINS_TEXT_NOTERBOOKS_APPLE_MACBOOK_PRODUCT = "Apple MacBook Pro 13-inch";
	public static final String A_CONTAINS_TEXT_NOTERBOOKS_HP_ENVY_PRODUCT = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
	public static final String A_CONTAINS_TEXT_NOTERBOOKS_HP_SPECTRE_PRODUCT = "HP Spectre XT Pro UltraBook";
	public static final String A_CONTAINS_TEXT_NOTERBOOKS_LENOVO_THINKPAD_PRODUCT = "Lenovo Thinkpad X1 Carbon Laptop";
	public static final String A_CONTAINS_TEXT_DESKTOPS_BUILD_YOUR_OWN_COMPUTER = "Build your own computer";
	public static final String A_CONTAINS_TEXT_DESKTOPS_LENOVO_IDEA_CENTRE_600 = "Lenovo IdeaCentre 600 All-in-One PC";
}
