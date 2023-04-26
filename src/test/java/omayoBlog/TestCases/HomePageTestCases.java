package omayoBlog.TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.codemindPP.Utility;

import omayo.pages.HomePage;

public class HomePageTestCases extends BaseTestCase {

	HomePage homepage;

	@Test (groups = {"sanity"} , priority = 1)
		public void verifyBlogTitle() {
		System.out.println(driver.getTitle());
	}

	@Test(groups = {"sanity"} , priority = 2)
	public void verifyAlertTest() {
		homepage = new HomePage(driver);
		String alertText = homepage.GetAlertText(driver);
		assertTrue(alertText.equals("Hello")); 
		
	}
}
