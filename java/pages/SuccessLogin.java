package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class SuccessLogin extends TestBase {
public SuccessLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait setup
	}
@FindBy(xpath="//h1[@class='post-title']")
private WebElement loggedInTitle;
public WebElement getLoggedInTitle() {
	return loggedInTitle;
}
@FindBy(xpath="//p[@class='has-text-align-center']")
private WebElement successMessage;
public WebElement getSuccessMessage() {
	return successMessage;

}
@FindBy(css="a.wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color")
private WebElement logOutButton;
public WebElement getLogOutButton() {
	return logOutButton;
}
}

