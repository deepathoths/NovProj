package Testingfiles;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class simpletest {
	@Test
	public void testLoginPage() {
	
	System.getProperty("webdriver.chrome.driver", "./drivers/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.get("https://practicetestautomation.com/practice-test-login/");
	driver.manage().window().maximize();
}
}
