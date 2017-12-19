package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import transportinfo.PageObjects.TripPlannerPage;

public class Test_Steps {

	static WebDriver driver;

	TripPlannerPage TripPlannerPage;

	@Given("^Phileas is planning a trip$")
	public void Phileas_is_planning_a_trip() throws Throwable {
		// Express the Regexp above with the code you wish you had
		System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer_x64_3.5.1\\IEDriverServer.exe");
		InternetExplorerOptions iEOptions = new InternetExplorerOptions();
		iEOptions.introduceFlakinessByIgnoringSecurityDomains();
		iEOptions.requireWindowFocus();
		driver = new InternetExplorerDriver(iEOptions);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://transportnsw.info/trip");

		//initialise all pages dependent on this given statements
		TripPlannerPage = PageFactory.initElements(driver, TripPlannerPage.class);

	}

	@When("^he executes a trip plan from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void he_executes_a_trip_plan_from_to(String FromLocation, String ToLocation) throws Throwable {

		//input to "From" box
		TripPlannerPage.txtbox_search_input_From.clear();
		TripPlannerPage.txtbox_search_input_From.sendKeys(FromLocation);
		Reporter.log("Entered data into \"From\" Trip textbox.\n\r");

		//input to "To" box
		TripPlannerPage.txtbox_search_input_To.clear();
		TripPlannerPage.txtbox_search_input_To.sendKeys(ToLocation);
		Reporter.log("Entered data into \"To\" Trip textbox\n\r");

		Thread.sleep(10);
		
		//click "Go" button
		//TripPlannerPage.btn_Go.click();
		TripPlannerPage.clickTripPlannerGo();
		Reporter.log("Clicked button \"Go\" to calculate Trip\n\r");
		
		
		
	}

	@Then("^a list of trips should be provided$")
	public void a_list_of_trips_should_be_provided() throws Throwable {
		List<WebElement> allTrips = driver.findElements(By.tagName("trip-summary"));


		System.out.println("Number of trips is: " + allTrips.size());
		Assert.assertTrue(allTrips.size()>0);//assert there is a list of trips

		/* this snippet is to validate the 'definition' of a trip.
		for (WebElement trip: allTrips) {
	    	//if(trip.getText().equals("TripTextExpected"))
				//return; // or break or throw
		}
		 */

		driver.quit();
	}

}
