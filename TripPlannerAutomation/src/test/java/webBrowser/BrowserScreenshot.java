package webBrowser;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;

public class BrowserScreenshot 
{
	public static void getScreenShot(WebDriver driver, Scenario scenario) throws IOException
	{
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        String testName = scenario.getName();
        scenario.embed(screenshot, "image/png");
        scenario.write(testName);
	}
	
	public static void getScreenShot(WebDriver driver) throws IOException
	{
	
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//The below method will save the screen shot in C drive with name "screenshot.png"
	FileUtils.copyFile(scrFile, new File("C:\\screenshot.png"));
	}
}
