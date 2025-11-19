package base;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import base.TestBase;
import java.io.File;




import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class TestListenerClass  implements ITestListener {
	WebDriver driver;
	@Override
	public void onStart(ITestContext context) {
			System.out.println("The test suite started is: " + context.getName());
	}
@Override
public void onTestSkipped(ITestResult result) {
		System.out.println("The test case skipped is: " + result.getName());
}
@Override
public void onTestSuccess(ITestResult result) {
    System.out.println("Test case passed: " + result.getName());
}

@Override
public void onTestFailure(ITestResult result) {
System.out.println("The test case failed is: " + result.getName());

 driver = TestBase.driver;
 if (driver!=null){
	

TakesScreenshot ts = (TakesScreenshot)driver;
File file= ts.getScreenshotAs(OutputType.FILE);
File destFile=new File("./Screenshots/screenshot1.png");
try {
	FileUtils.copyFile(file, destFile);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.getMessage();
}

System.out.println("Screenshot taken for failed test case saved at : " + file.getAbsolutePath());
}
 else {
		System.out.println("Driver is null, screenshot not taken.");
}


}
}
