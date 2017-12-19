package transportinfo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TripPlannerPage extends TripPlannerTemplate
{
	final WebDriver driver;
		
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
	}
	
}
