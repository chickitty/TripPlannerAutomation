package transportinfo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TripPlannerTemplate {

	final WebDriver driver;

	@FindBy(how = How.LINK_TEXT, using = "Home")
	public WebElement lnk_home;
	
	@FindBy(how = How.LINK_TEXT, using = "Plan")
	public WebElement lnk_plan;
	
	@FindBy(how = How.LINK_TEXT, using = "Tickets and Opal")
	public WebElement lnk_tickets_opal;
	
	@FindBy(how = How.LINK_TEXT, using = "Travel Info")
	public WebElement lnk_travel_info;
	
	@FindBy(how = How.LINK_TEXT, using = "Contact Us")
	public WebElement lnk_contact_us;

	public TripPlannerTemplate(WebDriver driver)
	{
		this.driver = driver;
	}

}
