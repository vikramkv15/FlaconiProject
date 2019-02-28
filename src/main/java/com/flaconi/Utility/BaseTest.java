package com.flaconi.Utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
	
	static WebDriver driver;
	public static WebDriver initiateDriver() throws  InterruptedException{
	String drivePath = System.getProperty("user.dir")+PropertyManager.getInstance().getdriverPath();
		
	System.setProperty("webdriver.chrome.driver",drivePath);
	ChromeOptions options= new ChromeOptions();
	Boolean headlessvalue= Boolean.valueOf(PropertyManager.getInstance().getHeadlessValue());
	options.setHeadless(headlessvalue);
	driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	return driver;
	
	}
	
}
