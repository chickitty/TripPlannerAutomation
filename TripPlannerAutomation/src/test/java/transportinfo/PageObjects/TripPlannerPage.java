package transportinfo.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TripPlannerPage extends TripPlannerTemplate
{
	final WebDriver driver;
	static WebDriverWait wait;

		
	@FindBy(how = How.ID, using = "search-input-From")
	public WebElement txtbox_search_input_From;
	
	@FindBy(how = How.ID, using = "search-input-To")
	public WebElement txtbox_search_input_To;
	
	@FindBy(how = How.ID, using = "search-button")
	public WebElement btn_Go;
	
	//Clear
	//@FindBy(how = How.LINK_TEXT, using = "Clear")
	//public WebElement btn_clearFrom;
	
	public TripPlannerPage(WebDriver driver)
	{
		super(driver); //inherits all Template objects as well
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}
	
	public void clickTripPlannerGo()
	{
		//locate the button
		//WebElement goButton;// = driver.findElement(By.id("search-button"));
		
		//goButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search-button\"]")));
		
		//goButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-button")));
		
		ExpectedConditions.visibilityOf(btn_Go);
		
		//click "Go" button
		//goButton.click();
		btn_Go.click();
		//validate the button has been clicked
		
	}

	public void setSearchInputFromField(String fromLocation) 
	{
		ExpectedConditions.visibilityOf(txtbox_search_input_From);
		txtbox_search_input_From.clear();
		txtbox_search_input_From.sendKeys(fromLocation);
		//txtbox_search_input_From.sendKeys(Keys.TAB);
		
		//select from drop down
		//wait for elements to appear
		WebElement location = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'" + fromLocation + "')]")));
		location.click();
	}

	public void setSearchInputToField(String toLocation) 
	{
		ExpectedConditions.visibilityOf(txtbox_search_input_To);
		txtbox_search_input_To.clear();
		
		txtbox_search_input_To.sendKeys(toLocation);
		
		//select from drop down
		//wait for elements to appear
		
		WebElement location = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'" + toLocation + "')]")));
		location.click();
	}
}