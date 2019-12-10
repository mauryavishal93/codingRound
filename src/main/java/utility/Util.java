package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sun.javafx.PlatformUtil;

@SuppressWarnings("restriction")
public class Util {

	WebDriverWait wait;


	public WebDriver selectBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-features=VizDisplayCompositor");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		return new ChromeDriver(options);
	}
	
	public void setDriverPath() {

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

	public void clickElement(WebDriver driver,By byElement) {
		wait=new WebDriverWait(driver, 20);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)) != null) {
			driver.findElement(byElement).click();
			Assert.assertTrue(true,byElement+" successfully found...!!!");
		}
		else {
			Assert.assertFalse(false,byElement+" Not found...!!!");
		}
	}


	public String getTextElement(WebDriver driver,By byElement) {
		wait=new WebDriverWait(driver, 50);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)) != null) {
			Assert.assertTrue(true,byElement+" successfully found...!!!");
			return driver.findElement(byElement).getText();
		}
		else {
			Assert.assertFalse(false,byElement+" Not found...!!!");
			return null;
		}
	}

	public void switchToFrame(WebDriver driver,By byElement,String frameId) {

		if(wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)) != null) {
			driver.switchTo().frame(frameId);
			Assert.assertTrue(true,frameId+" successfully found...!!!");
		}
		else {
			Assert.assertFalse(false,frameId+" Not found...!!!");
		}

	}


	public void sendKeysToTextBox(WebDriver driver,By byElement, String keysToSend) {
		wait=new WebDriverWait(driver, 20);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)) != null) {
			driver.findElement(byElement).clear();
			driver.findElement(byElement).sendKeys(keysToSend);
			Assert.assertTrue(true,byElement+" successfully found...!!!");
		}
		else {
			Assert.assertFalse(false,byElement+" Not found...!!!");
		}
	}


	public void selectFromListElementId(WebDriver driver,By byElement, int postion) {
		wait=new WebDriverWait(driver, 20);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)) != null) {
			List<WebElement> destinationOptions = driver.findElement(byElement).findElements(By.tagName("li"));
			destinationOptions.get(postion).click();
			Assert.assertTrue(true,byElement+" successfully found...!!!");
		}
		else {
			Assert.assertFalse(false,byElement+" Not found...!!!");
		}

	}	public void selectFromDropDown(WebDriver driver,By byElement, String option) {
		wait=new WebDriverWait(driver, 20);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)) != null) {
			Select element = new Select(driver.findElement(byElement));
			element.selectByVisibleText(option);
		}
		else {
			Assert.assertFalse(false,byElement+" Not found...!!!");
		}
	}
	
	
	public void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}


	public boolean isElementPresent(WebDriver driver,By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
