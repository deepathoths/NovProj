package base;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import org.testng.annotations.Parameters;
import pages.TestLogin;
import pages.SuccessLogin;

import org.apache.logging.log4j.Logger;
import utilities.ReadConfig;

@Listeners(TestListenerClass.class)

public class TestBase {
public static WebDriver driver;
ReadConfig readconfig = new ReadConfig();
protected Logger log=LogManager.getLogger(TestBase.class);
protected TestLogin testloginObj;
protected SuccessLogin successloginObj;
@BeforeMethod
@Parameters("browser")

public void setUp(String br)
{
	if(br.equalsIgnoreCase("chrome"))
	{
		log.info("== TEst setup Started==");
		log.debug("Initialising browser");
		log.info("Browser parameter value: " + br);
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver = new ChromeDriver();
	}
	else if(br.equalsIgnoreCase("Firefox"))
	{
		log.info("== Test setup Started==");
		log.debug("Initialising browser");
		System.setProperty("webdriver.gecko.driver",readconfig.getFireFoxPath());
		driver = new FirefoxDriver();
	}
	log.info("Browser Launched");
	String url = readconfig.getApplicationUrl();
	driver.get(url);
	log.info("Navigated to URL: "+url);
	driver.manage().window().maximize();
	testloginObj = new TestLogin(driver);
	successloginObj = new SuccessLogin(driver);
	driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
}
@AfterMethod
public void tearDown() 
{
	log.info("== Test Execution Completed==");
	driver.quit();
}

}
