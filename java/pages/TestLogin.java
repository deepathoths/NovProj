package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class TestLogin extends TestBase {
        
	private WebDriver driver;

	public TestLogin(WebDriver driver) {
	this.driver = driver;
    PageFactory.initElements(driver, this);
}
	
	
	
	@FindBy(xpath="//section[@id='login']/h2")
	private WebElement loginSectionHeading;
	public WebElement getLoginSectionHeading() {
		return loginSectionHeading;
	

	}
	@FindBy(xpath="//section[@id='login']/p")
	private WebElement loginSectionMessage;
	public WebElement getLoginSectionMessage() {
		return loginSectionMessage;
}
	
	@FindBy(id="username")
	private WebElement enterUserName;
	public WebElement enterUserName() {
		return enterUserName;
		
	}
		@FindBy(id="password")
		private WebElement enterPassword;
		public WebElement enterPassword() {
			return enterPassword;
		}
		
		@FindBy(xpath="//button[@id='submit']")
		private WebElement submitButton;
		public WebElement getSubmitButton() {
			return submitButton;
		}
		
		@FindBy(id="error")
		private WebElement errorMessage;
		public WebElement errorMessage() {
			return errorMessage;
			//Your username is invalid!
		}
		
		@FindBy(xpath="//h5[contains text(),'Test case 1']")
	private WebElement testCase1Heading;
		public WebElement testCase1Heading() {
			return testCase1Heading;
		}
		
		@FindBy(xpath="//@li[text='']")
		private WebElement testCase1Message;
			public WebElement testCase1Message() {
				return testCase1Heading;
			}	
	
}



