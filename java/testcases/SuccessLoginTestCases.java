package testcases;
import base.TestBase;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.SuccessLogin;
import pages.TestLogin;
import org.apache.logging.log4j.Logger;

public class SuccessLoginTestCases extends TestBase {
@BeforeMethod
public void loginTOApplication() {
	//using valid credentials to login 
	testloginObj.enterUserName().sendKeys("student");
	testloginObj.enterPassword().sendKeys("Password123");
	testloginObj.getSubmitButton().click();
	log.info("Logged in to application with valid credentials");
}

@Test(priority=1)
public void verifySuccessPageHeading()
{
	String Heading=successloginObj.getLoggedInTitle().getText();
	Assert.assertEquals(Heading,"Logged In Successfully","Success Page title does not match");
	log.info("SuccessPage title verified"); 
}
@Test(priority=2)
public void verifySuccessMessage()
{
	String message =successloginObj.getSuccessMessage().getText();
	Assert.assertEquals(message.trim(),"Congratulations student. You successfully logged in!","Success message does not match");
}

@Test(priority=3)
public void verifyLogoutButton()
{
	Assert.assertEquals(successloginObj.getLogOutButton().isDisplayed(), true,"Logout button is not displayed");
	log.info("Logout button is displayed");
	Assert.assertEquals(successloginObj.getLogOutButton().isEnabled(),true,"Logout button is not enabled");
	log.info("Logout button is enabled");
	Assert.assertEquals(successloginObj.getLogOutButton().getText(),"Log out","Logout button text does not match");
	log.info("Logout button text verified");
}
@Test(priority=4)
public void verifyLogoutFunctionality() {
	
	successloginObj.getLogOutButton().click();
	String Heading2=driver.getTitle();
	Assert.assertEquals(Heading2,"Test Login | Practice Test Automation","User is not navigated to login page after logout");
}
	
}
