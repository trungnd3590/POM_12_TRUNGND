package pageUIs;

import org.openqa.selenium.By;

public class SearchPageUI {

	public static final By SEARCH_PAGE_FORM = By.xpath("//div[@class='search-input']");
	public static final By SEARCH_TEXTBOX = By.xpath("//input[@id='q']");
	public static final By SEARCH_ADVANCE_CHECKBOX = By.xpath("//input[@id='adv']");
	public static final By SEARCH_ADVANCE_FORM = By.xpath("//div[@id='advanced-search-block']");
	public static final By SEARCH_ADVANCE_CATEGORY_DROPDOWN = By.xpath("//select[@id='cid']");
	public static final By SEARCH_ADVANCE_SUB_CATEGORY_CHECKBOX = By.xpath("//input[@id='isc']");
	public static final By SEARCH_ADVANCE_MANUFACTURER_DROPDOWN = By.xpath("//select[@id='mid']");
	public static final By SEARCH_ADVANCE_MINIMUM_PRICE_RANGE_TEXTBOX = By.xpath("//input[@id='pf']");
	public static final By SEARCH_ADVANCE_MAXIMUM_PRICE_RANGE_TEXTBOX = By.xpath("//input[@id='pt']");
	public static final By SEARCH_BUTTON = By.xpath("//input[@class='button-1 search-button']");
	public static final By SEARCH_WARNING_MESSAGE = By.xpath("//div[@class='warning']");
	public static final By SEARCH_NO_RESULT_MESSAGE = By.xpath("//div[@class='no-result']");
	public static final By SEARCH_RESULT_ITEM_GRID = By.xpath("//div[@class='item-grid']");
	public static final By SEARCH_RESULT_ITEM_NAME = By.xpath("//div[@class='item-box']//h2[@class='product-title']");
}
