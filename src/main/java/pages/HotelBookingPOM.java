package pages;

import utility.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelBookingPOM {

	Util util = new Util();
	WebDriver driver;
	By hotelLinkText =By.linkText("Hotels");
	By localityTextBoxTags =By.id("Tags");
	By searchHotelsButton =By.id("SearchHotelsButton");
	By selectTravellersOnhome =By.id("travellersOnhome");
	
	public HotelBookingPOM(WebDriver driver) {
		this.driver=driver;
	}
	public void hotelink() {
		util.clickElement(driver, hotelLinkText);
	}
	
	public void enterLocality(String locality) {
		util.sendKeysToTextBox(driver, localityTextBoxTags, locality);
	}
	
	public void selectTravellerSelection(String option) {
		util.selectFromDropDown(driver, selectTravellersOnhome, option);
	}
	
	public void searchButton() {
		util.clickElement(driver, searchHotelsButton);
	}

}
