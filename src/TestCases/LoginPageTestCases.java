package TestCases;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTestCases extends Parameters {

	@BeforeTest()
	public void setUp() {
		driver.manage().window().maximize();
		driver.get(theURL);

	}

	@Test(priority = 1)
	public void verifyLoginWithValidUsernameAndPassword() {

		driver.findElement(By.partialLinkText("Form Authentication")).click();
		;

		usernameField = driver.findElement(By.id("username"));
		usernameField.sendKeys(correctUsername);

		passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys(correctPassword);

		loginButton = driver.findElement(By.className("fa-sign-in"));
		loginButton.click();

		loginWelcomeMsg = driver.findElement(By.id("flash"));
		Boolean actualResult = loginWelcomeMsg.getText().contains("You logged into");
		Boolean expectedResult = true;

		assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 2)
	public void verifyLogout() {

		logoutButton = driver.findElement(By.className("icon-signout"));
		logoutButton.click();

		logoutMsg = driver.findElement(By.id("flash"));
		Boolean actualResult = logoutMsg.getText().contains("You logged out");
		Boolean expectedResult = true;

		assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 3)
	public void verifySomeTableData() {
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		tableOne = driver.findElement(By.id("table1"));

		List<WebElement> tableRows = tableOne.findElements(By.tagName("tr"));
		int rowsSize = tableRows.size();

		System.out.println(rowsSize);

		for (int i = 1; i < rowsSize; i++) {

			if (tableRows.get(0).getText().contains("First Name") && tableRows.get(0).getText().contains("Last Name")
					&& tableRows.get(0).getText().contains("Email") && tableRows.get(0).getText().contains("Due")
					&& tableRows.get(0).getText().contains("Web site")
					&& tableRows.get(0).getText().contains("Action")) {

				Boolean actualResult = tableRows.get(i).getText().contains("http://www.")
						&& tableRows.get(i).getText().contains("@") && tableRows.get(i).getText().contains("$");

				Boolean expectedResult = true;
				assertEquals(actualResult, expectedResult);

			}

		}

	}

}
