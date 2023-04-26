package omayo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoBlazeResistration {
	WebDriver driver;
	WebElement firstname;
	WebElement lastname;
	WebElement phone;
	WebElement email;
	

	public DemoBlazeResistration(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getFirstname() {
		setFirstname();
		return firstname;
	}

	public void setFirstname() {
		this.firstname = driver.findElement(By.xpath("//input[@name='firstName']"));

	}

	public WebElement getLastname() {
		setLastname();
		return lastname;
	}

	public void setLastname() {
		this.lastname = driver.findElement(By.xpath("//input[@name='lastName']"));
	}

	public WebElement getPhone() {
		setPhone();
		return phone;
	}

	public void setPhone() {
		this.phone = driver.findElement(By.xpath("//input[@name='phone']"));
	}

	public WebElement getEmail() {
		setEmail();
		return email;
	}

	public void setEmail() {
		this.email = driver.findElement(By.xpath("//input[@name='userName']"));;
	}

}
