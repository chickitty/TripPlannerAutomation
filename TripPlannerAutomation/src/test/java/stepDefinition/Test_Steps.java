package stepDefinition;

import java.util.List;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import transportinfo.PageObjects.TripPlannerPage;
import webBrowser.BrowserDrivers;
import webBrowser.BrowserScreenshot;

public class Test_Steps {

	static WebDriver driver;
	static WebDriverWait wait;

	TripPlannerPage TripPlannerPage;

	@Given("^Phileas is planning a trip$")
	public void Phileas_is_planning_a_trip() throws Throwable 
	{
		
		//driver = BrowserDrivers.getInternetExplorerDriver();
		//driver = BrowserDrivers.getGeckoDriver();
		driver = BrowserDrivers.getChromeDriver();
		
		driver.get("https://transportnsw.info/trip");

		//initialise all pages dependent on this given statements
		TripPlannerPage = PageFactory.initElements(driver, TripPlannerPage.class);

	}

	@When("^he executes a trip plan from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void he_executes_a_trip_plan_from_to(String FromLocation, String ToLocation) throws Throwable {

		//input to "From" box
		//TripPlannerPage.setSearchInputFromField(FromLocation.toLowerCase());
		TripPlannerPage.setSearchInputFromField(FromLocation);

		//input to "To" box
		TripPlannerPage.setSearchInputToField(ToLocation);
		
		//click "Go" button
		TripPlannerPage.clickTripPlannerGo();
		
		
	}

	@Then("^a list of trips should be provided$")
	public void a_list_of_trips_should_be_provided() throws Throwable {
		
		// if it gets more complicated than this: TripPlannerPage.getAllTrips();
		List<WebElement> allTrips = driver.findElements(By.tagName("trip-summary"));

		Assert.assertTrue(allTrips.size()>0);//assert there is a list of trips, defined as one ore more 'trip-summary' tags

		/* this snippet is to validate the 'definition' of a trip.
		 * Should be moved into a 'TripPlannerPage.validateTrip()' method when ready.
		for (WebElement trip: allTrips) {
	    	//if(trip.getText().equals("TripTextExpected"))
				//return; // or break or throw
		}
		 */
	}
	
	@After
    public void afterScenario()
    {
		driver.quit();
    }
	
	
	@After
	public void embedScreenshot(Scenario scenario) throws Exception {
	    if (scenario.isFailed()) {
	        try {
	        	BrowserScreenshot.getScreenShot(driver, scenario);
	        } catch (WebDriverException wde) {
	            System.err.println(wde.getMessage());
	        } catch (ClassCastException cce) {
	            cce.printStackTrace();}
	        }
	    }
} 
