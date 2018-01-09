package webBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserDrivers {

	public static WebDriver getInternetExplorerDriver() 
	{
		String userDir =  System.getProperty("user.dir");
		System.setProperty("webdriver.ie.driver", userDir+"\\src\\\\test\\\\resources\\IEDriverServer_x64_3.5.1.exe");
		//System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer_x64_3.5.1\\IEDriverServer.exe");
		InternetExplorerOptions iEOptions = new InternetExplorerOptions();
		iEOptions.introduceFlakinessByIgnoringSecurityDomains();
		iEOptions.requireWindowFocus();
		return new InternetExplorerDriver(iEOptions);
	}

	public static WebDriver getGeckoDriver() 
	{
		String userDir =  System.getProperty("user.dir");
		//System.setProperty("webdriver.gecko.driver",userDir+"\\src\\test\\resources\\geckodriver_x64_0.1.19.1.exe");//geckodriver_x64_0.19.1.exe
		//System.setProperty("webdriver.firefox.marionette","C:\\Selenium\\Gecko\\geckodriver\\geckodriver.exe");
		
		System.setProperty("webdriver.gecko.driver", userDir+"\\src\\test\\resources\\geckodriver.exe");//geckodriver_x64_0.19.1.exe
		
		//System.setProperty("webdriver.firefox.marionette", userDir+"\\src\\test\\resources\\geckodriver.exe");
		
		return new FirefoxDriver();
	}
	
	public static WebDriver getChromeDriver() 
	{
		String userDir =  System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userDir+"\\src\\\\test\\\\resources\\chromedriver_x86.exe");
		//System.setProperty("webdriver.firefox.marionette","C:\\Selenium\\Gecko\\geckodriver\\geckodriver.exe");
		
		return new ChromeDriver();
	}
}
