package com.flaconi.testRequistie;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
	
	static WebDriver driver;
	public static WebDriver initiateDriver() throws  InterruptedException{
	
	System.setProperty("webdriver.chrome.driver",TestDataValueReader.readPropFile("driverPath"));
	ChromeOptions options= new ChromeOptions();
	Boolean headlessvalue= Boolean.valueOf(TestDataValueReader.readPropFile("Headless"));
	options.setHeadless(headlessvalue);
	driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	return driver;
	}
}
