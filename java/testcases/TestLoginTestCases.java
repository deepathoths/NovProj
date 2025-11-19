package testcases;
import org.testng.annotations.Test;
import pages.SuccessLogin;
import pages.TestLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;

import base.TestBase;

public class TestLoginTestCases extends TestBase{
	
	
	@Test (priority=1)
	public void TestLoginTestCases() {
		testloginObj.enterUserName().sendKeys("student");
		testloginObj.enterPassword().sendKeys("Password123");
		testloginObj.getSubmitButton().click();
		log.info("Logged in to application with valid credentials");
	}
	
	
}