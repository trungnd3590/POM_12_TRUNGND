package pageUIs;

import org.openqa.selenium.By;

public class LoginPageUI {
	public static final By EMAIL_TEXTBOX = By.xpath("//input[@id='Email']");
	public static final By PASSWORD_TEXTBOX = By.xpath("//input[@id='Password']");
	public static final By EMAIL_TEXTBOX_MESSAGE = By.xpath("//span[@class='field-validation-error']");
	public static final By UNREGISTED_EMAIL_MESSAGE = By.xpath("//div[@class='message-error validation-summary-errors']");
	public static final By VALIDATION_ERROR_MESSAGE = By.xpath("//div[@class='message-error validation-summary-errors']");
}
