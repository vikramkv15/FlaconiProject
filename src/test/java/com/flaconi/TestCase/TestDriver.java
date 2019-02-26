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
import com.flaconi.testRequistie.TestDataValueReader;




public class TestDriver {

static WebDriver driver;
	
	@Test
	public static void initiateDriver() throws  InterruptedException{
	System.setProperty("webdriver.chrome.driver", "C:\\Project\\driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.flaconi.de");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	
	FlaconiMainPage.searchContainer(driver).sendKeys("Giorgio Armani Acqua di Giò Homme Eau de Toilette für Herren");
	
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
	
	FlaconiPerfumePage.perfumeAddCartFiftyMl(driver).click();
	
	System.out.println(FlaconiPerfumePage.perfumeAddCartPopUp(driver).getText());
	FlaconiPerfumePage.perfumeAddCartPopUp(driver).click();
	 FlaconiPerfumePage.addCartButtonInPopUp(driver);

	
	String expectedperfumeInCart = FlaconiCartPage.cartDetails(driver).getAttribute("alt");
	
	Assert.assertEquals(expectedperfumeInCart,TestDataValueReader.readPropFile("expectedPerfumeName"));
	}

}

	

