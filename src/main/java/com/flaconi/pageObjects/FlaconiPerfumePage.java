package com.flaconi.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlaconiPerfumePage {

	public static WebElement perfumeAddCartThirtyMl(WebDriver driver) {
		WebElement perfumeAddCartThirtyMlButton = driver.findElement(By.xpath("//*[@id=\"productAddToCartForm-20101922\"]/button"));
		return perfumeAddCartThirtyMlButton;
	}
	
	public static WebElement perfumeAddCartFiftyMl(WebDriver driver) {
		WebElement perfumeAddCartFiftyMlButton = driver.findElement(By.xpath("//*[@id=\"productAddToCartForm-20101923\"]/button"));
		return perfumeAddCartFiftyMlButton;
	}
	
	public static WebElement perfumeAddCartHundredMl(WebDriver driver) {
		WebElement perfumeAddCartHundredMlButton = driver.findElement(By.xpath("//*[@id=\"productAddToCartForm-20101924\"]/button"));
		return perfumeAddCartHundredMlButton;
	}
	
	public static WebElement perfumeAddCartTwoHundredMl(WebDriver driver) {
		WebElement perfumeAddCartTwoHundredMlButton = driver.findElement(By.xpath("//*[@id=\"productAddToCartForm-20101925\"]/button"));
		return perfumeAddCartTwoHundredMlButton;
	}
	
	public static WebElement perfumeAddCartPopUp(WebDriver driver) {
		WebElement perfumeAddCartPopUpHeader = driver.findElement(By.cssSelector("div#htmlData.columns"));
		return perfumeAddCartPopUpHeader;
	}
		
	public static WebElement addCartButtonInPopUp(WebDriver driver) {
		WebElement addCartButton = driver.findElement(By.xpath("//*[@id=\"htmlData\"]/div[4]/div/a"));
		return addCartButton;
	}
	
	public static WebElement closeButtonPopUp(WebDriver driver) {
		WebElement closeButton = driver.findElement(By.cssSelector("div[class='close']"));
		return closeButton;
	}
	public static WebElement cookieCloseButton(WebDriver driver) {
		WebElement cookieclose = driver.findElement(By.cssSelector("a.cookie-box__close"));
		return cookieclose;
	
	}
}
