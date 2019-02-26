package com.flaconi.testRequistie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInitiate {
	
	static WebDriver driver;
	
	public static WebDriver initiateDriver() throws  InterruptedException{
	System.setProperty("webdriver.chrome.driver", TestDataValueReader.readPropFile("driverPath"));
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	return driver;
	}

}
