package test;

import pages.FlightBookingPOM;
import utility.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightBookingTest extends Util{

	Util util = new Util();
	WebDriver driver = util.selectBrowser();
	FlightBookingPOM flightBooking = new FlightBookingPOM(driver);
	@Test
	public void testThatResultsAppearForAOneWayJourney() {
		try {

			String fromDeparture= "Bangalore";
			String toDestination= "Delhi";
			
			util.setDriverPath();
			
			driver.manage().window().maximize(); 
			
			driver.get("https://www.cleartrip.com/");

			flightBooking.oneWayRadioButton();

			flightBooking.fromDept(fromDeparture);

			flightBooking.fromDeptElement();

			flightBooking.toDest(toDestination);

			flightBooking.toDestElement();

			flightBooking.datePickerElement();
			
			flightBooking.enterDate("31/12/2019");
			
			flightBooking.searchButton();

			util.waitFor(5000);
			//verify that result appears for the provided journey search
			Assert.assertTrue(util.isElementPresent(driver,By.className("searchSummary")));
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.quit();
		}

	}
}
