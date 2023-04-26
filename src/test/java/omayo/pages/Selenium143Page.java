package omayo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Selenium143Page {
	WebDriver driver;
	WebElement whatIsSelenium;

	public void selenium143Page(WebDriver driver) {
      this.driver = driver;
	}

	public WebElement getWhatIsSelenium() {
		setWhatIsSelenium();
		return whatIsSelenium;
	}

	public void setWhatIsSelenium() {
		this.whatIsSelenium = driver.findElement(By.xpath("//a[text()='What is Selenium?']"));
	}
}
