package test;
import pages.HotelBookingPOM;
import utility.Util;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HotelBookingTest {

	Util util = new Util();
	WebDriver driver = util.selectBrowser();
	HotelBookingPOM hotelBooking = new HotelBookingPOM(driver);

	@Test
	public void shouldBeAbleToSearchForHotels() {
		try {
			String locality ="Indiranagar, Bangalore";
			String travellerSection ="1 room, 2 adults";
			util.setDriverPath();
			driver.manage().window().maximize();
			driver.get("https://www.cleartrip.com/");
			hotelBooking.hotelink();
			hotelBooking.enterLocality(locality);
			hotelBooking.selectTravellerSelection(travellerSection);
			hotelBooking.searchButton();

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			driver.quit();
		}

	}
}
