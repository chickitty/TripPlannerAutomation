package webBrowserDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserDrivers {

	public static WebDriver getInternetExplorerDriver() 
	{
		System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer_x64_3.5.1\\IEDriverServer.exe");
		InternetExplorerOptions iEOptions = new InternetExplorerOptions();
		iEOptions.introduceFlakinessByIgnoringSecurityDomains();
		iEOptions.requireWindowFocus();
		return new InternetExplorerDriver(iEOptions);
	}

	public static WebDriver getGeckoDriver() 
	{
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\Gecko\\geckodriver\\geckodriver.exe");
		//System.setProperty("webdriver.firefox.marionette","C:\\Selenium\\Gecko\\geckodriver\\geckodriver.exe");
		
		return new FirefoxDriver();
	}
	

}
