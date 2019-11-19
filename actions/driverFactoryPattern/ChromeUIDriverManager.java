package driverFactoryPattern;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromeUIDriverManager extends DriverManager{

	@Override
	protected void createDriver() {
		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", rootFolder + "\\resources\\chromedriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\ChromeUILogs.txt");
		ChromeOptions chromeOpitons = new ChromeOptions();
		chromeOpitons.addArguments("--incognito");
		chromeOpitons.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOpitons);
		
	}

}
