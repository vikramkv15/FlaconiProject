package com.flaconi.TestCase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.flaconi.Utility.ApplicationInfoLog;
import com.flaconi.Utility.GetScreenShots;
import com.flaconi.Utility.PropertyManager;

public class BaseTest {
	
    public static WebDriver driver;
    public static Logger log;
	
	@BeforeMethod
	public void initiateDriver() {
	
		log = Logger.getLogger("devpinoyLogger");
		
	System.setProperty("webdriver.chrome.driver",PropertyManager.getInstance().getdriverPath());
	ChromeOptions options= new ChromeOptions();
	
	Boolean headlessvalue= Boolean.valueOf(PropertyManager.getInstance().getHeadlessValue());
	options.setHeadless(headlessvalue);
	
	driver = new ChromeDriver(options);
	ApplicationInfoLog.loggingInfo(log, "Chrome Driver Initiated");
	
	driver.manage().window().maximize();
	
	// Load the Flaconi URL from the properties file
	driver.get(PropertyManager.getInstance().getURL());
	ApplicationInfoLog.loggingInfo(log, "Flaconi Url is loaded");
		
	}
	
	@AfterMethod
	public void closeDriver(ITestResult result) throws Exception {
		if(ITestResult.FAILURE==result.getStatus()) {
			GetScreenShots.takeSnapShot(driver, "PerfumeInCartNotcorrect");
		}
		else if(ITestResult.SUCCESS==result.getStatus()) {
			GetScreenShots.takeSnapShot(driver, "PerfumeInCart");
		}
		driver.quit();
	}
}
