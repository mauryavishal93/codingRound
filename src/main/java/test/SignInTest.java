package test;
import pages.SignInPOM;
import utility.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignInTest {

	WebDriver driver = new ChromeDriver();
	
	WebDriverWait wait=new WebDriverWait(driver, 20);
	
	Util util = new Util();
	
	SignInPOM signIn = new SignInPOM(driver);
	
	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		/**
		 * Added try catch and finally block to handle exception and close browser at the end
		 */
		try {
			util.setDriverPath();
			
			driver.manage().window().maximize();
			
			driver.get("https://www.cleartrip.com/");
			
			/***
			 * There are multiple link text with 'Your trips'.
			 * So I am using xpath using link text to make it more appropriate and unique
			 * driver.findElement(By.linkText("Your trips")).click();
			 * 
			 * Created a page object Model 
			 */

			signIn.userAccountLink();

			signIn.signInButton();

			signIn.swithToFrame();

			signIn.signInButton2();

			String errors1=signIn.error();
			Assert.assertTrue(errors1.contains("There were errors in your submission"));

		}catch(Exception e) {
			e.printStackTrace(); 
		}
		finally {
			driver.quit();
		}
	}

}
