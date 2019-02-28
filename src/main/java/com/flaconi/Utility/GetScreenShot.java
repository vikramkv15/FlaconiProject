package com.flaconi.Utility;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenShot {
	
	public static WebDriver takeSnapShot(WebDriver driver, String screenshotname) throws Exception {
		
		
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy h-mm-ssa");
		String timeStamp= sdf.format(new Timestamp(date.getTime()));
		String folder = System.getProperty("user.dir")+PropertyManager.getInstance().getEvidencePath();
		Thread.sleep(200);
		
		validateFolderExists(folder);
		
		String path = folder+"\\"+screenshotname+" "+timeStamp+".png" ;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Copy file at destination
		try {
		FileUtils.copyFile(SrcFile, new File(path));
		Thread.sleep(10);
		}catch(IOException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		return driver;
	}
	
	private static void validateFolderExists(String folderPath) {
		File evidences = new File(folderPath);
		if (!evidences.exists())
			evidences.mkdir();
	}
}
