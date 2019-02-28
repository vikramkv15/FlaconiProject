package com.flaconi.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlaconiMainPage {
	
	public static WebElement searchContainer(WebDriver driver) {
		WebElement searchContainerTextBox = driver.findElement(By.xpath("//*[@id=\"autosuggest-form-header\"]/input"));
		return searchContainerTextBox;
	}

	public static WebElement searchButton(WebDriver driver) {
		WebElement searchContainerButton = driver.findElement(By.cssSelector("button[class='button']"));
		return searchContainerButton;
	}
	
}
