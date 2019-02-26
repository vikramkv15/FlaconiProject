package com.flaconi.TestCase;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flaconi.pageObjects.FlaconiCartPage;
import com.flaconi.pageObjects.FlaconiMainPage;
import com.flaconi.pageObjects.FlaconiPerfumePage;
import com.flaconi.pageObjects.FlaconiSearchPage;
import com.flaconi.testRequistie.GetScreenShot;
import com.flaconi.testRequistie.TestDataValueReader;




public class TestDriver {

static WebDriver driver;
	
	@Test
	public static void initiateDriver() throws  Exception{
	System.setProperty("webdriver.chrome.driver",TestDataValueReader.readPropFile("driverPath"));
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.flaconi.de");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	
	FlaconiMainPage.searchContainer(driver).sendKeys("Giorgio Armani Acqua di Giò Homme Eau de Toilette  50 ml");
	
	//Click on search button
	FlaconiMainPage.searchButton(driver).click();
	
	if(FlaconiPerfumePage.cookieCloseButton(driver).isDisplayed()) {
		FlaconiPerfumePage.cookieCloseButton(driver).click();
	}
	
	//Searching the matching perfume and selecting it
	List<WebElement> perfumList = FlaconiSearchPage.searchPerfumeList(driver);
	for (int i = 0; i < perfumList.size(); i++)
	{	String perfumeElement = perfumList.get(i).getText();
	    if(perfumeElement.contains("Acqua di Giò Homme")) {
	    	perfumList.get(i).click();
	    	break;
	    }
	}
	GetScreenShot.takeSnapShot(driver, "PerfumeSelected");
	
	FlaconiPerfumePage.perfumeAddCartFiftyMl(driver).click();
	
	System.out.println(FlaconiPerfumePage.perfumeAddCartPopUp(driver).getText());
	FlaconiPerfumePage.perfumeAddCartPopUp(driver).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 FlaconiPerfumePage.addCartButtonInPopUp(driver).click();

	
	String expectedperfumeInCart = FlaconiCartPage.cartDetails(driver).getAttribute("alt");
	
	Assert.assertEquals(expectedperfumeInCart,TestDataValueReader.readPropFile("expectedPerfumeName"));
	GetScreenShot.takeSnapShot(driver, "PerfumeSelected");
	driver.close();
	
	}
	
}

	

