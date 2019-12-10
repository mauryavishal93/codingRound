package test;
import com.sun.javafx.PlatformUtil;

import utility.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


@SuppressWarnings("restriction")
public class SignInTest {

	WebDriver driver = new ChromeDriver();
	WebDriverWait wait=new WebDriverWait(driver, 20);
	Util util = new Util();
	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		/**
		 * Added try catch and finally block to handle exception and close browser at the end
		 */
		try {
			setDriverPath();
			driver.manage().window().maximize();
			driver.get("https://www.cleartrip.com/");

			/***
			 * There are multiple link text with 'Your trips'.
			 * So I am using xpath using link text to make it more appropriate and unique
			 * driver.findElement(By.linkText("Your trips")).click();
			 */
			util.clickElementUsingXpath(driver, "//a[@id='userAccountLink']");
			util.clickElementUsingId(driver, "SignIn");
			Thread.sleep(2000);
			util.switchToFrame(driver, "modal_window");
			util.clickElementUsingId(driver, "signInButton");
			String errors1=	util.getTextElementUsingId(driver, "errors1");
			Assert.assertTrue(errors1.contains("There were errors in your submission"));
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		finally {
			driver.quit();
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
