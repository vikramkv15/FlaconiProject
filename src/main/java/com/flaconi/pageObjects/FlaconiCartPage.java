package com.flaconi.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.flaconi.testRequistie.TestDataValueReader;

public class FlaconiCartPage {

	WebDriver driver = null;
	private static WebElement cartItemName;

	public static WebElement cartDetails(WebDriver driver) {
		List<WebElement> cartProductList = driver.findElements(By.xpath("//div[starts-with(@class,'row product cell')]"));
		for (int i = 0; i < cartProductList.size(); i++) {
			cartItemName = cartProductList.get(i).findElement(By.className("display"));
			if (cartItemName.getAttribute("alt").contains(TestDataValueReader.readPropFile("matchingPerfume"))) {
				break;
			}

		}
		return cartItemName;
	}

}
