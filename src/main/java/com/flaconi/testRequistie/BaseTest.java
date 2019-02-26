package com.flaconi.testRequistie;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	static WebDriver driver;
	//static String DriverPath = System.getProperty("user.dir")+TestDataValueReader.readPropFile("driverPath");
	
	public static WebDriver initiateDriver() throws  InterruptedException{
	//File file = new File(DriverPath);
	System.setProperty("webdriver.chrome.driver",TestDataValueReader.readPropFile("driverPath"));
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	return driver;
	}

}
