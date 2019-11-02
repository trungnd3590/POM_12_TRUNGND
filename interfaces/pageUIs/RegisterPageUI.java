package pageUIs;

import org.openqa.selenium.By;

public class RegisterPageUI {
	public static final By GENDER_MALE_RADIOBUTTON = By.xpath("//input[@id='gender-male']");
	public static final By FIRSTNAME_TEXTBOX = By.xpath("//input[@id='FirstName']");
	public static final By LASTNAME_TEXTBOX = By.xpath("//input[@id='LastName']");
	public static final By DATEOFBIRTH_DROPDOWN = By.xpath("//select[@name='DateOfBirthDay']");
	public static final By DATEOFMONTH_DROPDOWN = By.xpath("//select[@name='DateOfBirthMonth']");
	public static final By DATEOFYEAR_DROPDOWN = By.xpath("//select[@name='DateOfBirthYear']");
	public static final By EMAIL_TEXTBOX = By.xpath("//input[@id='Email']");
	public static final By COMPANYNAME_TEXTBOX = By.xpath("//input[@id='Company']");
	public static final By PASSWORD_TEXTBOX = By.xpath("//input[@id='Password']");
	public static final By CONFIRM_PASSWORD_TEXTBOX = By.xpath("//input[@id='ConfirmPassword']");
	public static final By REGISTER_BUTTON = By.xpath("//input[@id='register-button']");
	public static final By REGISTER_SUCCESS_MESSAGE = By.xpath("//div[@class='result']");
	public static final By LOGOUT_LINK = By.xpath("//a[@class='ico-logout']");
}
