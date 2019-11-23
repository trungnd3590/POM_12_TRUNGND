package commons;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class AbstractTest {

	private WebDriver driver;
	String rootFolder = System.getProperty("user.dir");

	public WebDriver getMultiBrowserDriver(String browserName) {
		if (browserName.equalsIgnoreCase("firefox_ui")) {
			System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\FirefoxLogs.txt");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("firefox_headless")) {
			System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setHeadless(true);
			driver = new FirefoxDriver(firefoxOptions);
		} else if (browserName.equalsIgnoreCase("chrome_ui")) {
			System.setProperty("webdriver.chrome.driver", rootFolder + "\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("chrome_headless")) {
			System.setProperty("webdriver.chrome.driver", rootFolder + "\\resources\\chromedriver.exe");
			ChromeOptions chromeOpitons = new ChromeOptions();
			chromeOpitons.setHeadless(true);
			driver = new ChromeDriver(chromeOpitons);
		} else {
			System.out.println("Please input your browser name !");
		}
		return driver;
	}
	
	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
	
}
