package transportinfo.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class TripPlannerPage extends TripPlannerTemplate
{
	final WebDriver driver;
		
	@FindBy(how = How.ID, using = "search-input-From")
	public WebElement txtbox_search_input_From;
	
	@FindBy(how = How.ID, using = "search-input-To")
	public WebElement txtbox_search_input_To;
	
	@FindBy(how = How.CLASS_NAME, using = "tp-search-go")
	public WebElement btn_Go;
	
	//Clear
	//@FindBy(how = How.LINK_TEXT, using = "Clear")
	//public WebElement btn_clearFrom;
	
	public TripPlannerPage(WebDriver driver)
	{
		super(driver); //inherits all Template objects as well
		this.driver = driver;
	}
	
	public void clickTripPlannerGo()
	{
		//locate the button
		WebElement goButton;// = driver.findElement(By.id("search-button"));
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		
		goButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search-button\"]")));
		
		//click "Go" button
		goButton.click();
		Reporter.log("Clicked button \"Go\" to calculate Trip\n\r");
		
		//validate the button has been clicked
		
	}
	
}