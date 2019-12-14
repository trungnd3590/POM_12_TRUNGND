package pageUIs;

public class MyAccountPageUI {
	
	public static final String ADDRESS_LINKS = "//a[@class='inactive'][contains(text(),'Addresses')]";
	public static final String CUSTOMER_ORDER_LINKS = "//a[@class='inactive'][contains(text(),'Orders')]";
	public static final String ADDRESS_INFO_TABLE = "//ul[@class='info']";
	public static final String CHANGE_PASSWORD_FORM = "//div[@class='page-body']//form";
	public static final String CUSTOMER_ORDER_NUMBER_TITLE = "//div[@class='section order-item']//div[@class='title']//strong";
	public static final String CUSTOMER_ORDER_DETAIL_TITLE = "//div[@class='page-title']//h1";
	public static final String CUSTOMER_ORDER_DETAIL_BILLING_TITLE = "//div[@class='billing-info']//div[@class='title']";
	public static final String CUSTOMER_ORDER_DETAIL_SHIPPING_TITLE = "//div[@class='shipping-info']//div[@class='title']";
	public static final String CUSTOMER_ORDER_DETAIL_PAYMENT_METHOD_TITLE = "//div[@class='payment-method-info']//div[@class='title']";
	public static final String CUSTOMER_ORDER_DETAIL_SHIPPING_METHOD_TITLE = "//div[@class='shipping-method-info']//div[@class='title']";
	public static final String CUSTOMER_ORDER_DETAIL_PRODUCT_NAME_TEXT = "//td[@class='product']//em";
	
	public static final String CUSTOMER_ORDER_DETAIL_SUB_TOTAL_COST_TEXT = "//label[contains(text(),'Sub-Total:')]/parent::td/following-sibling::td";
	public static final String CUSTOMER_ORDER_DETAIL_SHIPPING_COST_TEXT = "//label[contains(text(),'Shipping:')]/parent::td/following-sibling::td";
	public static final String CUSTOMER_ORDER_DETAIL_TAX_COST_TEXT = "//label[contains(text(),'Tax:')]/parent::td/following-sibling::td";
	public static final String CUSTOMER_ORDER_DETAIL_TOTAL_COST_TEXT = "//label[contains(text(),'Order Total:')]/parent::td/following-sibling::td";
	
	public static final String A_CONTAINS_TEXT_MY_PRODUCT_REVIEW_LINK = "My product reviews";
	public static final String A_CONTAINS_TEXT_CHANGE_PASSWORD_LINK = "Change password";
	public static final String A_CONTAINS_TEXT_CUSTOMER_ORDER_DETAL_BUTTON_DYNAMIC = "//strong[contains(text(),'%s')]/parent::div/following-sibling::div[@class='buttons']//input";
	
	public static final String DIV_CLASS_CUSTOMER_ORDER_DETAIL_BILLING_DYNAMIC = "//div[@class='billing-info']//li[@class='%s']";
	public static final String DIV_CLASS_CUSTOMER_ORDER_DETAIL_SHIPPING_DYNAMIC = "//div[@class='shipping-info']//li[@class='%s']";
	public static final String DIV_CLASS_CHANGE_NEW_PASSWORD_RESULT_MESSAGE = "result";
	public static final String DIV_CLASS_MY_PRODUCT_REVIEW_FORM = "page account-page my-product-reviews-list-page";
	public static final String DIV_CLASS_MY_PRODUCT_REVIEW_PRODUCT_TITLE = "review-item-head";
	public static final String DIV_CLASS_MY_PRODUCT_REVIEW_PRODUCT_DESCRIPTION = "review-text";
	public static final String DIV_CLASS_MY_PRODUCT_REVIEW_PRODUCT_INFO = "review-info";
	public static final String DIV_CLASS_MY_ACCOUNT_PAGE_FORM = "page account-page customer-info-page";
	public static final String DIV_CLASS_ADDRESS_NEW_ADDRESS_TABLE = "edit-address";
	public static final String DIV_CLASS_CUSTOMER_ORDER_TABLE = "order-list";
	public static final String DIV_CLASS_CUSTOMER_ORDER_DETAIL_TABLE = "page order-details-page";
	public static final String DIV_CLASS_CUSTOMER_ORDER_DETAIL_NUMBER = "order-number";
	
	public static final String LI_CLASS_ADDRESS_FIRST_LAST_NAME_TEXT = "name";
	public static final String LI_CLASS_ADDRESS_EMAIL_TEXT = "email";
	public static final String LI_CLASS_ADDRESS_PHONENUMBER_TEXT = "phone";
	public static final String LI_CLASS_ADDRESS_FAXNUMBER_TEXT = "fax";
	public static final String LI_CLASS_ADDRESS_COMPANYNAME_TEXT = "company";
	public static final String LI_CLASS_ADDRESS_ADDRESS01_TEXT = "address1";
	public static final String LI_CLASS_ADDRESS_ADDRESS02_TEXT = "address2";
	public static final String LI_CLASS_ADDRESS_CITY_ZIPCODE_TEXT = "city-state-zip";
	public static final String LI_CLASS_ADDRESS_COUNTRY_TEXT = "country";
	public static final String LI_CLASS_CUSTOMER_ORDER_DETAIL_STATUS = "order-status";
	public static final String LI_CLASS_CUSTOMER_ORDER_DETAIL_TOTAL = "order-total";
	public static final String LI_CLASS_CUSTOMER_ORDER_DETAIL_PAYMENT_INFO = "payment-method";
	public static final String LI_CLASS_CUSTOMER_ORDER_DETAIL_SHIPPING_INFO = "shipping-method";
	public static final String LI_CLASS_CUSTOMER_ORDER_DETAIL_PAYMENT_STATUS = "payment-method-status";
	public static final String LI_CLASS_CUSTOMER_ORDER_DETAIL_SHIPPING_STATUS = "shipping-status";
	
	public static final String INPUT_ID_FIRSTNAME_TEXTBOX = "FirstName";
	public static final String INPUT_ID_LASTNAME_TEXTBOX ="LastName";
	public static final String INPUT_ID_EMAIL_TEXTBOX = "Email";
	public static final String INPUT_ID_COMPANYNAME_TEXTBOX = "Company";
	public static final String INPUT_ID_CHANGE_OLD_PASSWORD_TEXTBOX = "OldPassword";
	public static final String INPUT_ID_CHANGE_NEW_PASSWORD_TEXTBOX = "NewPassword";
	public static final String INPUT_ID_CHANGE_CONFIRM_NEW_PASSWORD_TEXTBOX = "ConfirmNewPassword";
	public static final String INPUT_ID_SAVE_BUTTON = "save-info-button";
	public static final String INPUT_ID_ADDRESS_FIRSTNAME_TEXTBOX = "Address_FirstName";
	public static final String INPUT_ID_ADDRESS_LASTNAME_TEXTBOX = "Address_LastName";
	public static final String INPUT_ID_ADDRESS_EMAIL_TEXTBOX = "Address_Email";
	public static final String INPUT_ID_ADDRESS_COMPANYNAME_TEXTBOX = "Address_Company";
	public static final String INPUT_ID_ADDRESS_CITY_TEXTBOX = "Address_City";
	public static final String INPUT_ID_ADDRESS_ADDRESS01_TEXTBOX = "Address_Address1";
	public static final String INPUT_ID_ADDRESS_ADDRESS02_TEXTBOX = "Address_Address2";
	public static final String INPUT_ID_ADDRESS_ZIPCODE_TEXTBOX = "Address_ZipPostalCode";
	public static final String INPUT_ID_ADDRESS_PHONENUMBER_TEXTBOX = "Address_PhoneNumber";
	public static final String INPUT_ID_ADDRESS_FAXNUMBER_TEXTBOX = "Address_FaxNumber";
	
	public static final String INPUT_CLASS_ADDRESS_SAVE_BUTTON = "button-1 save-address-button";
	public static final String INPUT_CLASS_CHANGE_NEW_PASSWORD_BUTTON = "button-1 change-password-button";
	public static final String INPUT_CLASS_ADDRESS_ADD_NEW_ADDRESS_BUTTON = "button-1 add-address-button";
	public static final String INPUT_CLASS_CUSTOMER_ORDER_DETAIL_REORDER_BUTTON = "button-1 re-order-button";
	
	public static final String SELECT_NAME_DATEOFBIRTH_DROPDOWN = "DateOfBirthDay";
	public static final String SELECT_NAME_DATEOFMONTH_DROPDOWN ="DateOfBirthMonth";
	public static final String SELECT_NAME_DATEOFYEAR_DROPDOWN = "DateOfBirthYear";

	public static final String SELECT_ID_ADDRESS_COUNTRY_DROPDOWN = "Address_CountryId";
	public static final String SELECT_ID_ADDRESS_STATE_DROPDOWN = "Address_StateProvinceId";
	
	public static final String SPAN_CLASS_GENDER_MALE_RADIOBUTTON = "male";
	public static final String SPAN_CLASS_GENDER_FEMALE_RADIOBUTTON = "female";
	public static final String SPAN_CLASS_CUSTOMER_DETAIL_PRODUCT_SKU_TEXT = "sku-number";
	public static final String SPAN_CLASS_CUSTOMER_DETAIL_PRODUCT_UNIT_PRICE_TEXT = "product-unit-price";
	public static final String SPAN_CLASS_CUSTOMER_DETAIL_PRODUCT_QUANTITY_TEXT = "product-quantity";
	public static final String SPAN_CLASS_CUSTOMER_DETAIL_PRODUCT_TOTAL_PRICE_TEXT = "product-subtotal";
}
