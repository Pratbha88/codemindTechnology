package omayo.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.codemindPP.Utility;

public class HomePage {
	WebDriver driver;
	WebElement maleRedioButton;
	WebElement clickToGetAlert;
	WebElement disabledButton1;
	WebElement selenium143Link;
	WebElement SignInLink;
	WebElement signInFrame;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getMaleRedioButton() {
		setMaleRedioButton();
		return maleRedioButton;
	}

	public void setMaleRedioButton() {
		this.maleRedioButton = driver.findElement(By.cssSelector("input#radio1"));
	}

	public WebElement getClickToGetAlert() {
		setClickToGetAlert();
		return clickToGetAlert;
	}

	public void setClickToGetAlert() {
		this.clickToGetAlert = driver.findElement(By.cssSelector("input#alert1"));
	}

	public WebElement getDisabledButton1() {
		setDisabledButton1();
		return disabledButton1;
	}

	public void setDisabledButton1() {
		this.disabledButton1 = driver.findElement(By.cssSelector("button#but1"));
	}
	
	public WebElement getSignInLink() {
		setSignInLink();
		return SignInLink;
	}

	public void setSignInLink() {
		SignInLink = driver.findElement(By.xpath("//a[text()='Sign In']"));
	}
	
	
	public WebElement getSignInFrame() {
		setSignInFrame();
		return signInFrame;
	}

	public void setSignInFrame() {
		this.signInFrame = driver.findElement(By.xpath("//iframe[@name='navbar-iframe']"));
	}

	public boolean verifyButton1IsDisabulled() {
		 return getDisabledButton1().isEnabled();
		
	}
	
	public WebElement getSelenium143Link() {
		setSelenium143Link();
		return selenium143Link;
	}

	public void setSelenium143Link() {
		this.selenium143Link = driver.findElement(By.cssSelector("a#selenium143"));
	}
	public String GetAlertText(WebDriver driver) {
		 getClickToGetAlert().click();
		 Utility.waitForAlert(driver, 10l);
		 Alert alert = driver.switchTo().alert();
		String alertText= alert.getText();
		alert.accept();
		return alertText;
		
	}
	public void navigateToSelenium143() {
		getSelenium143Link().click();
 }
	
	public void clickOnSignIn() {
		Utility.switchToFrame(driver, getSignInFrame());
		getSignInFrame().click();
		Utility.switchToHomePage(driver);
		
	}


}
