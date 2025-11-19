package testcases;
import base.TestBase;
import org.testng.annotations.Test;
import pages.TestLogin;
import pages.SuccessLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
public class negativeLoginTestCases extends TestBase {
	
	@Test(dataProvider="invalidCredentials", priority=2)
	public void negativeTestCasesLogin(String username, String password, String expectederrormessage) {
		testloginObj.enterUserName().sendKeys(username);
		testloginObj.enterPassword().sendKeys(password);
		testloginObj.getSubmitButton().click();
		log.info("Attempted to log in with invalid credentials: " + username +","+password);
WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOf(testloginObj.errorMessage()));
String errorText=testloginObj.errorMessage().getText().trim();
log.info("Error message displayed: " + errorText);
Assert.assertEquals(errorText.trim(), expectederrormessage.trim(), "Error message does not match expected value.");
}
@DataProvider(name="invalidCredentials")

	public Object[][]getinvalidCredentials()
	{
		return new Object[][] {
			{"invaliduser1","Password123","Your username is invalid!"},
			{"student","wrongpassword","Your password is invalid!"},
			{"invaliduser2","wrongpassword","Your username is invalid!"},
			{"","Password123","Your username is invalid!"},
			{"student","","Your password is invalid!"},
			{"","","Your username is invalid!"}
		};
}
}

