package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Util {
	WebDriverWait wait;

	public void clickElementUsingXpath(WebDriver driver,String xpath) {
		wait=new WebDriverWait(driver, 20);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))) != null) {
			driver.findElement(By.xpath(xpath)).click();
			Assert.assertTrue(true,xpath+" successfully found...!!!");
		}
		else {
			Assert.assertFalse(false,xpath+" Not found...!!!");
		}
	}


	public String getTextElementUsingId(WebDriver driver,String id) {
		wait=new WebDriverWait(driver, 50);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))) != null) {
			Assert.assertTrue(true,id+" successfully found...!!!");
			return driver.findElement(By.id(id)).getText();
		}
		else {
			Assert.assertFalse(false,id+" Not found...!!!");
			return null;
		}
	}

	public void switchToFrame(WebDriver driver,String frameId) {

		if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(frameId))) != null) {
			driver.switchTo().frame(frameId);
			Assert.assertTrue(true,frameId+" successfully found...!!!");
		}
		else {
			Assert.assertFalse(false,frameId+" Not found...!!!");
		}

	}

	public void clickElementUsingId(WebDriver driver,String id) {
		wait=new WebDriverWait(driver, 20);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))) != null) {
			driver.findElement(By.id(id)).click();
			Assert.assertTrue(true,id+" successfully found...!!!");
		}
		else {
			Assert.assertFalse(false,id+" Not found...!!!");
		}
	}

	public void sendKeysUsingXpath(WebDriver driver,String xpath, String keysToSend) {
		wait=new WebDriverWait(driver, 20);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))) != null) {
			driver.findElement(By.xpath(xpath)).clear();
			driver.findElement(By.xpath(xpath)).sendKeys(keysToSend);
			Assert.assertTrue(true,xpath+" successfully found...!!!");
		}
		else {
			Assert.assertFalse(false,xpath+" Not found...!!!");
		}
	}


	public void sendKeysUsingId(WebDriver driver,String id, String keysToSend) {
		wait=new WebDriverWait(driver, 20);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))) != null) {
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(keysToSend);
			Assert.assertTrue(true,id+" successfully found...!!!");
		}
		else {
			Assert.assertFalse(false,id+" Not found...!!!");
		}
	}


	public void selectFromListElementUsingId(WebDriver driver,String id, int postion) {
		wait=new WebDriverWait(driver, 20);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))) != null) {
			List<WebElement> destinationOptions = driver.findElement(By.id(id)).findElements(By.tagName("li"));
			destinationOptions.get(postion).click();
			Assert.assertTrue(true,id+" successfully found...!!!");
		}
		else {
			Assert.assertFalse(false,id+" Not found...!!!");
		}
	}

}
