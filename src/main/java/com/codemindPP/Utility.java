package com.codemindPP;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	WebDriver driver;
	public void switchToWindow(WebDriver driver) {
		String currentHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!(handle.equals(currentHandle))) {
				driver.switchTo().window(handle);
			}
		}
	}

	public static void waitForAlert(WebDriver driver, Long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.alertIsPresent());

		
	}
	public WebDriver getDriver() {
	  driver = new FirefoxDriver();
		return driver;
	}
	public static String readProperties(String key) throws IOException {

		File file = new File("src/test/resources/data.properties");
		FileInputStream fileInputStream = new FileInputStream(file);

		Properties properties = new Properties();
		properties.load(fileInputStream);

		return properties.getProperty(key);

	}
	public static void switchToFrame(WebDriver driver, WebElement framelocator) {
		driver.switchTo().frame(framelocator);
	}
	
	public static void switchToHomePage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public static void takeSnapShot(WebDriver driver, String name) {
		TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
		File file = takeScreenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file,new File("src/test/resources/Screenshots/" + name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> readExceldata() {
		File file = new File("src/test/resources/Resistration data 2.xls");
		FileInputStream fileInputstream = null;
		HSSFWorkbook hssfworkbook=null;
		ArrayList<String> data = new ArrayList<String>();
		try {
			fileInputstream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			hssfworkbook = new HSSFWorkbook(fileInputstream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HSSFSheet hssfsheet = hssfworkbook.getSheetAt(0);
		int lastRowNumber = hssfsheet.getLastRowNum();
		
		for (int i = 1; i <= lastRowNumber; i++) {
			HSSFRow hssfRow = hssfsheet.getRow(i);
			int lastCellNumber = hssfRow.getLastCellNum();

			for (int j = 0; j < lastCellNumber; j++) {
			data.add(hssfRow.getCell(j).getStringCellValue());
			}
		}
        return data;
	}

}
