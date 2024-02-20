package LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {
	
	WebDriver driver = new ChromeDriver();
	WebElement usernameField;
	WebElement passwordField;
	WebElement loginButton;
	WebElement loginWelcomeMsg;
	
	WebElement logoutButton;
	WebElement logoutMsg;
	
	WebElement tableOne;
	
	
	String theURL = "https://the-internet.herokuapp.com/";
	String correctUsername = "tomsmith";
	String correctPassword = "SuperSecretPassword!";

}
