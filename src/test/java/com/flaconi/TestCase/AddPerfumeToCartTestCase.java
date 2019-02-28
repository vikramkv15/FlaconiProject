package com.flaconi.TestCase;

import org.testng.annotations.Test;

import com.flaconi.Utility.PropertyManager;
import com.flaconi.pageObjects.FlaconiCartPage;
import com.flaconi.pageObjects.FlaconiMainPage;
import com.flaconi.pageObjects.FlaconiPerfumePage;
import com.flaconi.pageObjects.FlaconiSearchPage;
import com.flaconi.Utility.ApplicationInfoLog;
import com.flaconi.Utility.BaseTest;
import com.flaconi.Utility.GetScreenShot;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AddPerfumeToCartTestCase extends BaseTest {

	static WebDriver driver;

	@BeforeTest
	// Chrome Driver Initiation
	public static void DriverInitiation() {
		Logger log = Logger.getLogger("devpinoyLogger");
		try {

			driver = BaseTest.initiateDriver();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		ApplicationInfoLog.loggingInfo(log, "Chrome Driver Initiated");
	}

	@Test
	public void flaconiUserJourney() throws Exception {
		Logger log = Logger.getLogger("devpinoyLogger");
		String expectedPerfume = PropertyManager.getInstance().getexpectedPerfumeName();

		// Load the Flaconi URL from the properties file
		driver.get(PropertyManager.getInstance().getURL());
		ApplicationInfoLog.loggingInfo(log, "Flaconi Url is loaded");

		// Enter the Perfume name to be searched
		FlaconiMainPage.searchContainer(driver).sendKeys(expectedPerfume);
		System.out.println(expectedPerfume + " perfume to be added to cart is entered in the search container");

		// Closing the cookie pop up
		if (FlaconiPerfumePage.cookieCloseButton(driver).isDisplayed()) {
			FlaconiPerfumePage.cookieCloseButton(driver).click();
		}

		// Click on search button
		FlaconiMainPage.searchButton(driver).click();
		ApplicationInfoLog.loggingInfo(log, "Click on the search button");

		// Searching the matching perfume and selecting it
		List<WebElement> perfumList = FlaconiSearchPage.searchPerfumeList(driver);
		for (int i = 0; i < perfumList.size(); i++) {
			String perfumeElement = perfumList.get(i).getText();
			if (perfumeElement.contains(PropertyManager.getInstance().getMatchingPerfume())) {
				perfumList.get(i).click();
				break;
			}
		}
		ApplicationInfoLog.loggingInfo(log, "Selected the perfume to be added to cart");
		GetScreenShot.takeSnapShot(driver, "PerfumeSelected");

		// Adding the perfume to cart from the perfume page.
		FlaconiPerfumePage.perfumeAddCartFiftyMl(driver).click();
		ApplicationInfoLog.loggingInfo(log, "Added the perfume to the cart");

		// Verifying the pop up for perfume added is displayed
		FlaconiPerfumePage.perfumeAddCartPopUp(driver).isDisplayed();
		System.out.println(FlaconiPerfumePage.perfumeAddCartPopUp(driver).getText());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/*
		 * // Clicking on the button to navigate to cart
		 * FlaconiPerfumePage.addCartButtonInPopUp(driver).click();
		 * ApplicationInfoLog.loggingInfo(log, "Cart is opened");
		 */

		// TO Be removed once the issue of pop up is resolved
		driver.navigate().refresh();
		FlaconiSearchPage.CartIcon(driver).click();
		ApplicationInfoLog.loggingInfo(log, "Cart is opened");

		// Assertion if the perfume available in the cart
		String expectedperfumeInCart = FlaconiCartPage.cartDetails(driver).getAttribute("alt");

		Assert.assertEquals(expectedperfumeInCart, expectedPerfume);
		System.out.println(expectedperfumeInCart + " perfume found in the cart");
		ApplicationInfoLog.loggingInfo(log, "Expected Perfume is found in the Cart");
		GetScreenShot.takeSnapShot(driver, "PerfumeInCart");
	}

	@AfterTest
	public static void DriverExit() {
		driver.quit();
	}
}
