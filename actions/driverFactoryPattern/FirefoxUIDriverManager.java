package driverFactoryPattern;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxUIDriverManager extends DriverManager{

	@Override
	protected void createDriver() {
		
		String rootFolder = System.getProperty("user.dir");
		//System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\FirefoxLogs.txt");
		driver = new FirefoxDriver();
	}

}
