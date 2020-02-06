package pageUIs;

public class AdminPageUI {
	
	public static final String PRODUCTS_FORM_SEARCH_BUTTON = "//button[@id='search-products']";
	public static final String CUSTOMERS_FORM_SEARCH_BUTTON = "//button[@id='search-customers']";
	public static final String PRODUCTS_FORM_SEARCH_GO_DIRECTLY_TO_SKU_BUTTON = "//button[@id='go-to-product-by-sku']";
	public static final String PRODUCTS_FORM_SEARCH_RESULT_ROWS = "//tbody//tr[@role='row']";
	public static final String PRODUCTS_FORM_PUBLISHED_TRUE_ICON = "//i[@class='fa fa-check true-icon']";
	public static final String CUSTOMERS_FORM_ACTIVE_TRUE_ICON = "//td[contains(text(),'%s')]/following-sibling::td//i[@class='fa fa-check true-icon']";
	public static final String CUSTOMERS_FORM_EDIT_CUSTOMER_BUTTON = "//td[contains(text(),'%s')]/following-sibling::td//a[@class='btn btn-default']";
	public static final String PRODUCTS_FORM_DATA_TABLE_EMPTY_TEXT = "//td[@class='dataTables_empty']";
	public static final String ADD_NEW_CUSTOMER_FORM_ADMIN_COMMENT_TEXTAREA = "//textarea[@id='AdminComment']";
	public static final String ADD_NEW_CUSTOMER_FORM_SAVE_AND_CONTINUE_BUTTON = "//button[@name='save-continue']";
	public static final String ADMIN_BACK_TO_PREVIOUS_FORM = "//h1[@class='pull-left']//a";
	public static final String ADD_NEW_CUSTOMER_CUSTOMER_ROLES_ALL_ITEMS_DROPDOWN = "//li[@class='k-item']";
	public static final String ADD_NEW_CUSTOMER_CUSTOMER_ROLES_GUESTS_ITEM_DROPDOWN = "//li[@class='k-item'][contains(text(),'%s')]";
	public static final String EDIT_CUSTOMER_DETAILS_FORM_ADDRESS_PANEL =  "//div[@id='customer-address']//div[@class='panel-heading']";
	public static final String EDIT_CUSTOMER_DETAILS_FORM_AĐD_NEW_ADDRESS_BUTTON =  "//button[contains(text(),'Add new address')]";
	
	public static final String A_CONTAINS_TEXT_ADMIN_LOGOUT_LINK = "Logout";
	
	public static final String A_CLASS_CUSTOMERS_FORM_ADD_NEW_BUTTON = "btn bg-blue";
	
	public static final String TD_CONTAINS_TEXT_PRODUCTS_FORM_SEARCH_RESULT_TEXT = "//td[contains(text(),'%s')]";
	
	public static final String DIV_CLASS_ADD_NEW_CUSTOMER_SUCCESS_MESSAGE = "alert alert-success alert-dismissable";
	public static final String ADD_NEW_CUSTOMER_CUSTOMER_ROLES_PARENT_DROPDOWN = "//div[@class='k-multiselect-wrap k-floatwrap']";
	public static final String ADD_NEW_CUSTOMER_CUSTOMER_ROLES_PARENT_DROPDOWN_TEXT = "//li[@class='k-button']//span[contains(text(),'%s')]";
	
	public static final String SIDEBAR_MENU_CATALOG_MENU = "//ul[@class='sidebar-menu tree']//span[text()='Catalog']";
	public static final String SIDEBAR_MENU_PRODUCTS_SUB_MENU = "//ul[@class='sidebar-menu tree']//span[text()='Products']";
	public static final String SIDEBAR_MENU_CUSTOMER_MENU = "//i[@class='fa fa-user']/parent::a//span";
	public static final String SIDEBAR_MENU_CUSTOMER_SUB_MENU = "//span[@class='menu-item-title' and text() = 'Customers']";

	public static final String INPUT_ID_PRODUCTS_FORM_SEARCH_PRODUCTNAME_TEXTBOX = "SearchProductName";
	public static final String INPUT_ID_PRODUCTS_FORM_SEARCH_SUB_CATEGORY_CHECKBOX = "SearchIncludeSubCategories";
	public static final String INPUT_ID_PRODUCTS_FORM_SEARCH_GO_DIRECTLY_TO_SKU_TEXTBOX = "GoDirectlyToSku";
	public static final String INPUT_ID_PRODUCT_DETAILS_FORM_PROUCTNAME_TEXTBOX = "Name";
	public static final String INPUT_ID_ADD_NEW_CUSTOMER_FORM_EMAIL_TEXTBOX = "Email";
	public static final String INPUT_ID_ADD_NEW_CUSTOMER_FORM_PASSWORD_TEXTBOX = "Password";
	public static final String INPUT_ID_ADD_NEW_CUSTOMER_FORM_FIRSTNAME_TEXTBOX = "FirstName";
	public static final String INPUT_ID_ADD_NEW_CUSTOMER_FORM_LASTNAME_TEXTBOX = "LastName";
	public static final String INPUT_ID_ADD_NEW_CUSTOMER_FORM_GENDER_MALE_RADIOBUTTON = "Gender_Male";
	public static final String INPUT_ID_ADD_NEW_CUSTOMER_FORM_DATEOFBIRTH_TEXTBOX = "DateOfBirth";
	public static final String INPUT_ID_ADD_NEW_CUSTOMER_FORM_COMPANYNAME_TEXTBOX = "Company";
	public static final String INPUT_ID_ADD_NEW_CUSTOMER_FORM_ACTIVE_CHECKBOX = "Active";
	public static final String INPUT_ID_CUSTOMER_FORM_SEARCH_EMAIL_TEXTBOX = "SearchEmail";
	public static final String INPUT_ID_CUSTOMER_FORM_SEARCH_FIRSTNAME_TEXTBOX = "SearchFirstName";
	public static final String INPUT_ID_CUSTOMER_FORM_SEARCH_LASTNAME_TEXTBOX = "SearchLastName";
	public static final String INPUT_ID_CUSTOMER_FORM_SEARCH_COMPANYNAME_TEXTBOX = "SearchCompany";
	public static final String INPUT_ID_ADD_NEW_ADDRESS_FORM_FIRSTNAME_TEXTBOX = "Address_FirstName";
	public static final String INPUT_ID_ADD_NEW_ADDRESS_FORM_LASTNAME_TEXTBOX = "Address_LastName";
	public static final String INPUT_ID_ADD_NEW_ADDRESS_FORM_EMAIL_TEXTBOX = "Address_Email";
	public static final String INPUT_ID_ADD_NEW_ADDRESS_FORM_COMPANYNAME_TEXTBOX = "Address_Company";
	public static final String INPUT_ID_ADD_NEW_ADDRESS_FORM_CITY_TEXTBOX = "Address_City";
	public static final String INPUT_ID_ADD_NEW_ADDRESS_FORM_ADDRESS01_TEXTBOX = "Address_Address1";
	public static final String INPUT_ID_ADD_NEW_ADDRESS_FORM_ADDRESS02_TEXTBOX = "Address_Address2";
	public static final String INPUT_ID_ADD_NEW_ADDRESS_FORM_ZIPCODE_TEXTBOX = "Address_ZipPostalCode";
	public static final String INPUT_ID_ADD_NEW_ADDRESS_FORM_PHONENUMBER_TEXTBOX = "Address_PhoneNumber";
	public static final String INPUT_ID_ADD_NEW_ADDRESS_FORM_FAXNUMBER_TEXTBOX = "Address_FaxNumber";
	
	public static final String SELECT_ID_PRODUCTS_FORM_SEARCH_CATEGORY_DROPDOWN = "SearchCategoryId";
	public static final String SELECT_ID_PRODUCTS_FORM_SEARCH_MANUFACTURER_DROPDOWN = "SearchManufacturerId";
	public static final String SELECT_ID_ADD_NEW_CUSTOMER_FORM_MANAGER_OF_VENDOR_DROPDOWN = "VendorId";
	public static final String SELECT_ID_CUSTOMER_FORM_SEARCH_MONTH_OF_BIRTH_DROPDOWN = "SearchMonthOfBirth";
	public static final String SELECT_ID_CUSTOMER_FORM_SEARCH_DAY_OF_BIRTH_DROPDOWN = "SearchDayOfBirth";
	public static final String SELECT_ID_ADD_NEW_ADDRESS_FORM_COUNTRY_DROPDOWN = "Address_CountryId";
	public static final String SELECT_ID_ADD_NEW_ADDRESS_FORM_STATE_DROPDOWN = "Address_StateProvinceId";
	
	public static final String SPAN_CLASS_ADD_NEW_CUSTOMER_FORM_CUSTOMER_ROLE_DELETE_BUTTON = "k-icon k-delete";
}
