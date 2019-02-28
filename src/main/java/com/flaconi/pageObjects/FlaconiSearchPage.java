package com.flaconi.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlaconiSearchPage {

	public static List<WebElement> searchPerfumeList(WebDriver driver) {
		WebElement perfumecontainer = driver.findElement(By.xpath("//*[@id='multi-filter']//following-sibling::ul"));
		List<WebElement> perfumeList = perfumecontainer.findElements(By.tagName("li"));
			return perfumeList;
			}
	public static WebElement CartIcon(WebDriver driver) {
		WebElement cartIconbutton = driver.findElement(By.id("mini-basket"));
		return cartIconbutton;
		
	}
		  
	}


