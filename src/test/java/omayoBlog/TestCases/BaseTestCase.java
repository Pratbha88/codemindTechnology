package omayoBlog.TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.codemindPP.Utility;

public class BaseTestCase {
	WebDriver driver;

	@BeforeMethod
	public void initiateBrowser() throws IOException {
		this.driver = new Utility().getDriver();
		driver.get(Utility.readProperties("URL"));
		driver.manage().window().maximize();
	}

	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus());
		{
			Utility.takeSnapShot(driver, result.getName());
		}
	
		driver.quit();
	}

}
