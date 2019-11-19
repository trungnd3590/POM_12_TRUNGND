package driverFactoryPattern;

public class DriverManagerFactory {

	public static DriverManager getBrowserDriver(String browserName) {
		
		DriverManager driverNamager;
		switch (browserName) {
		case "firefox_ui":
			driverNamager = new FirefoxUIDriverManager();
			break;
		case "firefox_headless":
			driverNamager = new FirefoxHeadlessDriverManager();
			break;
		case "chrome_ui":
			driverNamager = new ChromeUIDriverManager();
			break;
		case "chrome_headless":
			driverNamager = new FirefoxHeadlessDriverManager();
			break;
		case "edge_ui":
			driverNamager = new EdgeDriverManager();
			break;
		case "ie_ui":
			driverNamager = new IEDriverManager();
			break;
		case "safari_ui":
			driverNamager = new SafariDriverManager();
			break;
		case "opera_ui":
			driverNamager = new OperaDriverManager();
			break;

		default:
			driverNamager = new FirefoxUIDriverManager();
			break;
		}
		return driverNamager;
		
	}
}
