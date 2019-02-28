package com.flaconi.TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.flaconi.Utility.PropertyManager;

public class BaseTest {
	
	public static WebDriver driver;
	
	public static WebDriver initiateDriver() throws  InterruptedException{
	
	System.setProperty("webdriver.chrome.driver",PropertyManager.getInstance().getdriverPath());
	ChromeOptions options= new ChromeOptions();
	
	Boolean headlessvalue= Boolean.valueOf(PropertyManager.getInstance().getHeadlessValue());
	options.setHeadless(headlessvalue);
	
	driver = new ChromeDriver(options);
	
	driver.manage().window().maximize();
	return driver;
	}
	
	public static void closeDriver(WebDriver driver) {
		driver.quit();
	}
}
