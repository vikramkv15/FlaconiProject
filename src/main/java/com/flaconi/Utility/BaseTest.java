package com.flaconi.Utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
	
	static WebDriver driver;
	public static WebDriver initiateDriver() throws  InterruptedException{
	
	System.setProperty("webdriver.chrome.driver",PropertyManager.getInstance().getdriverPath());
	ChromeOptions options= new ChromeOptions();
	Boolean headlessvalue= Boolean.valueOf(PropertyManager.getInstance().getHeadlessValue());
	options.setHeadless(headlessvalue);
	driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	return driver;
	}
	
}
