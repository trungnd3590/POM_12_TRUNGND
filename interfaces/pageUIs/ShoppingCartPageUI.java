package pageUIs;

public class ShoppingCartPageUI {

	public static final String PRODUCT_DETAIL = "//div[@class='table-wrapper']//div[@class='attributes']";
	public static final String PRODUCT_QUANTITY = "//td[@class='quantity']//input";
	public static final String PRODUCT_UNIT_PRICE_TEXT = "//td[@class='unit-price']";
	public static final String REMOVE_PRODUCT_CHECKBOX = "//td[@class='remove-from-cart']//input";
	public static final String SHOPPING_CART_CHECK_OUT_BUTTON = "//button[@id='checkout']";
	public static final String SHOPPING_CART_CHECK_OUT_ORDER_TOTAL = "//tr[@class='order-total']//span[@class='value-summary']";
	public static final String CHECK_OUT_BILLING_ADDRESS_CONTINUE_BUTTON = "//div[@id='billing-buttons-container']//input[@class='button-1 new-address-next-step-button']";
	public static final String CHECK_OUT_SHIPPING_ADDRESS_CONTINUE_BUTTON = "//div[@id='shipping-buttons-container']//input[@class='button-1 new-address-next-step-button']";
	public static final String CHECK_OUT_PAYMENT_METHOD_FORM = "//ul[@id='payment-method-block']";
	public static final String CHECK_OUT_PAYMENT_METHOD_CREDIT_CARD_RADIO_BUTTON = "//div[@class='payment-details']//input[@value='Payments.Manual']";
	public static final String CHECK_OUT_SHIPPING_METHOD_NEXT_DAY_AIR_RADIO_BUTTON = "//div[@class='method-name']//input[@value='Next Day Air___Shipping.FixedByWeightByTotal']";
	public static final String CHECK_OUT_SHIPPING_METHOD_NEXT_DAY_AIR_LABEL_RADIO_BUTTON = "//input[@value='Next Day Air___Shipping.FixedByWeightByTotal']/parent::div[@class='method-name']//label";
	public static final String CONFIRM_ORDER_BILLING_ADDRESS_TITLE = "//div[@class='billing-info']//div[@class='title']";
	public static final String CONFIRM_ORDER_SHIPPING_ADDRESS_TITLE = "//div[@class='shipping-info']//div[@class='title']";
	public static final String CONFIRM_ORDER_PAYMENT_METHOD_TITLE = "//div[@class='payment-method-info']//div[@class='title']";
	public static final String CONFIRM_ORDER_SHIPPING_METHOD_TITLE = "//div[@class='shipping-method-info']//div[@class='title']";
	public static final String CONFIRM_ORDER_PAYMENT_METHOD_INFO = "//li[@class='payment-method']";
	public static final String CONFIRM_ORDER_SHIPPING_METHOD_INFO = "//div[@class='shipping-method-info']//ul[@class='info-list']";
	public static final String CONFIRM_ORDER_SHOPPING_CART_FORM = "//form[@id='shopping-cart-form']";
	public static final String CONFIRM_ORDER_SUB_TOTAL_TEXT = "//tr[@class='order-subtotal']//td[@class='cart-total-right']";
	public static final String CONFIRM_ORDER_SHIPPING_COST_TEXT = "//tr[@class='shipping-cost']//td[@class='cart-total-right']";
	public static final String CONFIRM_ORDER_TAX_TEXT = "//tr[@class='tax-value']//td[@class='cart-total-right']";
	public static final String CONFIRM_ORDER_TOTAL_COST_TEXT = "//tr[@class='order-total']//span[@class='value-summary']";
	public static final String CHECK_OUT_COMPLETE_FORM_INFO = "//div[@class='section order-completed']//div[@class='title']";
	
	public static final String A_CONTAINS_TEXT_EDIT_PRODUCT ="Edit";

	public static final String A_CLASS_SHOPPING_CART_PAGE_PRODUCT_NAME = "product-name";
	
	public static final String DIV_CLASS_CHECK_OUT_EDIT_ADDRES_FORM = "edit-address";
	public static final String DIV_CLASS_CHECK_OUT_SECTION_PAYMENT_INFO_FORM = "info";
	public static final String DIV_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_FORM = "billing-info";
	public static final String DIV_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_FORM = "shipping-info";
	public static final String DIV_CLASS_CONFIRM_ORDER_PAYMENT_METHOD_FORM = "payment-method-info";
	public static final String DIV_CLASS_CONFIRM_ORDER_SHIPPING_METHOD_FORM = "shipping-method-info";
	public static final String DIV_CLASS_CHECK_OUT_COMPLETE_FORM = "page checkout-page order-completed-page";
	public static final String DIV_CLASS_ORDER_NUMBER = "order-number";
	public static final String DIV_CLASS_SECTION_PAYMENT_INFO = "section payment-info";
	
	public static final String DIV_ID_BILLING_ADDRESS_FORM = "checkout-step-billing";
	public static final String DIV_ID_SHIPPING_ADDRESS_FORM = "checkout-step-shipping";
	public static final String DIV_ID_CHECKOUT_SHIPPING_METHOD_FORM = "checkout-shipping-method-load";
	public static final String DIV_ID_CHECKOUT_CONFIRM_ORDER_FORM = "checkout-step-confirm-order";
	
	public static final String INPUT_NAME_UPDATE_SHOPPING_CART_BUTTON = "updatecart";
	
	public static final String INPUT_CLASS_CHECK_OUT_SHIPPING_METHOD_CONTINUE_BUTTON = "button-1 shipping-method-next-step-button";
	public static final String INPUT_CLASS_CHECK_OUT_PAYMENT_METHOD_CONTINUE_BUTTON = "button-1 payment-method-next-step-button";
	public static final String INPUT_CLASS_CHECK_OUT_SECTION_PAYMENT_INFO_CONTINUE_BUTTON = "button-1 payment-info-next-step-button";
	public static final String INPUT_CLASS_CONFIRM_ORDER_INFO_CONFIRM_BUTTON = "button-1 confirm-order-next-step-button";
	
	public static final String INPUT_ID_ZIP_PORTAL_CODE_TEXTBOX = "ZipPostalCode";
	public static final String INPUT_ID_TERM_OF_SERVICE_CHECKBOX = "termsofservice";
	public static final String INPUT_ID_SHIPPING_SAME_ADDRESS_CHECKBOX = "ShipToSameAddress";
	public static final String INPUT_ID_CHECK_OUT_BILLING_FIRST_NAME_TEXT_BOX = "BillingNewAddress_FirstName"; 
	public static final String INPUT_ID_CHECK_OUT_BILLING_LAST_NAME_TEXT_BOX = "BillingNewAddress_LastName";
	public static final String INPUT_ID_CHECK_OUT_BILLING_CITY_TEXT_BOX = "BillingNewAddress_City";
	public static final String INPUT_ID_CHECK_OUT_BILLING_ADDRESS01_TEXT_BOX = "BillingNewAddress_Address1";
	public static final String INPUT_ID_CHECK_OUT_BILLING_ZIP_PORTAL_CODE_TEXT_BOX = "BillingNewAddress_ZipPostalCode";
	public static final String INPUT_ID_CHECK_OUT_BILLING_PHONE_NUMBER_TEXT_BOX = "BillingNewAddress_PhoneNumber";

	public static final String INPUT_ID_CHECK_OUT_SHIPPING_FIRST_NAME_TEXT_BOX = "ShippingNewAddress_FirstName"; 
	public static final String INPUT_ID_CHECK_OUT_SHIPPING_LAST_NAME_TEXT_BOX = "ShippingNewAddress_LastName";
	public static final String INPUT_ID_CHECK_OUT_SHIPPING_CITY_TEXT_BOX = "ShippingNewAddress_City";
	public static final String INPUT_ID_CHECK_OUT_SHIPPING_ADDRESS01_TEXT_BOX = "ShippingNewAddress_Address1";
	public static final String INPUT_ID_CHECK_OUT_SHIPPING_ZIP_PORTAL_CODE_TEXT_BOX = "ShippingNewAddress_ZipPostalCode";
	public static final String INPUT_ID_CHECK_OUT_SHIPPING_PHONE_NUMBER_TEXT_BOX = "ShippingNewAddress_PhoneNumber";
	
	public static final String INPUT_ID_CHECK_OUT_SECTION_PAYMENT_CARD_HOLDER_TEXT_BOX = "CardholderName";
	public static final String INPUT_ID_CHECK_OUT_SECTION_PAYMENT_CARD_NUMBER_TEXT_BOX = "CardNumber";
	public static final String INPUT_ID_CHECK_OUT_SECTION_PAYMENT_CARD_CODE_TEXT_BOX = "CardCode";
	
	public static final String LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_DYNAMIC = "//div[@class='billing-info']//li[@class='%s']";
	public static final String LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_NAME_TEXT = "name";
	public static final String LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_EMAIL_TEXT = "email";
	public static final String LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_PHONE_TEXT = "phone";
	public static final String LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_FAX_TEXT = "fax";
	public static final String LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_ADDRESS01_TEXT = "address1";
	public static final String LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_CITY_STATE_ZIP_TEXT = "city-state-zip";
	public static final String LI_CLASS_CONFIRM_ORDER_BILLING_ADDRESS_INFO_COUNTRY_TEXT = "country";
	
	public static final String LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_DYNAMIC = "//div[@class='shipping-info']//li[@class='%s']";
	public static final String LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_NAME_TEXT = "name";
	public static final String LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_EMAIL_TEXT = "email";
	public static final String LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_PHONE_TEXT = "phone";
	public static final String LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_FAX_TEXT = "fax";
	public static final String LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_ADDRESS01_TEXT = "address1";
	public static final String LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_CITY_STATE_ZIP_TEXT = "city-state-zip";
	public static final String LI_CLASS_CONFIRM_ORDER_SHIPPING_ADDRESS_INFO_COUNTRY_TEXT = "country";
	
	
	public static final String SELECT_ID_GIFT_WRAPPING_DROPDOWN = "checkout_attribute_1";
	public static final String SELECT_ID_COUNTRY_DROPDOWN = "CountryId";
	public static final String SELECT_ID_CHECK_OUT_BILLING_COUNTRY_DROPDOWN = "BillingNewAddress_CountryId";
	public static final String SELECT_ID_CHECK_OUT_SHIPPING_COUNTRY_DROPDOWN = "ShippingNewAddress_CountryId";
	public static final String SELECET_ID_BILLING_ADDRESS_DROPDOWN = "billing-address-select";
	public static final String SELECET_ID_SHIPPING_ADDRESS_DROPDOWN = "shipping-address-select";
	public static final String SELECT_ID_CHECK_OUT_SECTION_PAYMENT_EXPIRE_MONTH_DROPDOWN = "ExpireMonth";
	public static final String SELECT_ID_CHECK_OUT_SECTION_PAYMENT_EXPIRE_YEAR_DROPDOWN = "ExpireYear";
	
	public static final String SPAN_CLASS_PRODUCT_SKU_TEXT = "sku-number";
	public static final String SPAN_CLASS_PRODUCT_UNIT_PRICE_TEXT = "product-unit-price";
	public static final String SPAN_CLASS_PRODUCT_QUANTITY_TEXT = "product-quantity";
	public static final String SPAN_CLASS_PRODUCT_SUB_TOTAL_TEXT = "product-subtotal";
	
}
