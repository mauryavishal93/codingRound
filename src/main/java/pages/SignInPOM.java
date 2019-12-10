package pages;
import utility.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignInPOM {

	Util util = new Util();
	WebDriver driver;
	By userAccountLink = By.xpath("//a[@id='userAccountLink']");
	By signInButton = By.id("SignIn");
	String iFrameSignInId="modal_window";
	By iFrameSignIn = By.id(iFrameSignInId);
	By signInButton2 = By.id("signInButton");
	By error = By.id("errors1");


	public SignInPOM(WebDriver driver) {
		this.driver=driver;
	}

	//click on userAccountLink

	public void userAccountLink() {

		util.clickElement(driver, userAccountLink);

	}

	//click on signInButton

	public void signInButton() {

		util.clickElement(driver, signInButton);

	}

	//get on error1

	public void swithToFrame() {

		util.switchToFrame(driver, iFrameSignIn, iFrameSignInId);

	}
	//click on signInButton2

	public void signInButton2() {

		util.clickElement(driver, signInButton2);

	}

	//get on error1

	public String error() {

		return util.getTextElement(driver, error);

	}
}
