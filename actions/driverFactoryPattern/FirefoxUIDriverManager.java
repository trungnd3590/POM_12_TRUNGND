package driverFactoryPattern;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxUIDriverManager extends DriverManager{

	@Override
	protected void createDriver() {
		
		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\FirefoxLogs.txt");
		driver = new FirefoxDriver();
	}

}
