package test;

import com.sun.javafx.PlatformUtil;

import utility.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingTest extends Util{

    WebDriver driver = new ChromeDriver();
    Util util = new Util();

    @Test
    public void testThatResultsAppearForAOneWayJourney() {

        setDriverPath();
        driver.get("https://www.cleartrip.com/");
        util.clickElementUsingId(driver, "OneWay");
        //driver.findElement(By.id("OneWay")).click();
        util.clickElementUsingId(driver, "OneWay");

		/*
		 * driver.findElement(By.id("FromTag")).clear();
		 * driver.findElement(By.id("FromTag")).sendKeys("Bangalore");
		 */
        util.sendKeysUsingId(driver, "FromTag", "Bangalore");
        //wait for the auto complete options to appear for the origin

		/*
		 * waitFor(2000); List<WebElement> originOptions =
		 * driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		 * originOptions.get(0).click();
		 */
        util.selectFromListElementUsingId(driver, "ui-id-1", 0);
        
        util.sendKeysUsingId(driver, "ToTag", "Delhi");
		/*
		 * driver.findElement(By.id("toTag")).clear();
		 * driver.findElement(By.id("toTag")).sendKeys("Delhi");
		 */

        //wait for the auto complete options to appear for the destination

		/*
		 * waitFor(2000); //select the first item from the destination auto complete
		 * list List<WebElement> destinationOptions =
		 * driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		 * destinationOptions.get(0).click();
		 */
        util.selectFromListElementUsingId(driver, "ui-id-2", 0);
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();
        

        //all fields filled in. Now click on search
        //driver.findElement(By.id("SearchBtn")).click();
        util.clickElementUsingId(driver, "SearchBtn");

        waitFor(5000);
        //verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(By.className("searchSummary")));

        //close the browser
        driver.quit();

    }


    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
}
