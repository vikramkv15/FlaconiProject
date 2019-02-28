package com.flaconi.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.flaconi.Utility.PropertyManager;


public class FlaconiCartPage {

	private static WebElement cartItemName;

	public static WebElement cartDetails(WebDriver driver) {
		List<WebElement> cartProductList = driver.findElements(By.xpath("//div[starts-with(@class,'row product cell')]"));
		for (int i = 0; i < cartProductList.size(); i++) {
			cartItemName = cartProductList.get(i).findElement(By.className("display"));
			if (cartItemName.getAttribute("alt").contains(PropertyManager.getInstance().getMatchingPerfume())) {
				break;
			}

		}
		return cartItemName;
	}

}
