package pages;

import utility.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightBookingPOM extends Util{


    Util util = new Util();
	WebDriver driver;
	By oneWay = By.id("OneWay");
	By fromTag = By.id("FromTag");
	By fromTag1stElement = By.id("ui-id-1");
	By toTag = By.id("ToTag");
	By toTag1stElement = By.id("ui-id-2");
	By searchBtn = By.id("SearchBtn");
	By datePicker = By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a");
	By enterDate= By.xpath("//*[@id='DepartDate']");

	public FlightBookingPOM(WebDriver driver) {
		this.driver=driver;
	}
   
	public void oneWayRadioButton() {
		util.clickElement(driver, oneWay);
	}
	
	public void fromDept(String data) {
		util.sendKeysToTextBox(driver, fromTag, data);
	}
	
	public void fromDeptElement() {
		util.clickElement(driver, fromTag1stElement);
	}
	
	
	public void toDest(String data) {
		util.sendKeysToTextBox(driver, toTag, data);
	}
	
	public void toDestElement() {
		util.clickElement(driver, toTag1stElement);
	}
	
	public void searchButton() {
		util.clickElement(driver, searchBtn);
	}
	
	public void datePickerElement() {
		util.clickElement(driver, datePicker);
	}
	
	public void enterDate(String data) {
		util.sendKeysToTextBox(driver, enterDate, data);
	}
	
}
