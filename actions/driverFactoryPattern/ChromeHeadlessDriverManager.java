package driverFactoryPattern;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromeHeadlessDriverManager extends DriverManager{

	@Override
	protected void createDriver() {
		
		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", rootFolder + "\\resources\\chromedriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\ChromeHeadlessLogs.txt");
		ChromeOptions chromeOpitons = new ChromeOptions();
		chromeOpitons.setHeadless(true);
		chromeOpitons.addArguments("window-size=1920x1080");
		driver = new ChromeDriver(chromeOpitons);
	}

}
