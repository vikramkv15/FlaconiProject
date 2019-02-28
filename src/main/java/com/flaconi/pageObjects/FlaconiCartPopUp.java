package com.flaconi.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlaconiCartPopUp extends BasePage {
	
	public FlaconiCartPopUp(WebDriver driver) {
		super(driver);
	}
	
	By perfumeAddCartPopUpHeader = By.cssSelector("div#htmlData.columns");
	By addCartButton = By.xpath("//*[@id=\"htmlData\"]/div[4]/div/a");
	By closeButtonPopUp = By.cssSelector("div[class='close']");	
	By cartIconbutton = By.id("mini-basket");
	
	public FlaconiCartPage cartPageTo() {
		click(addCartButton);
		return new FlaconiCartPage(driver);
	}
	
	public FlaconiCartPopUp getPopUpText() {
		readText(perfumeAddCartPopUpHeader);
		return this;
	}
	
	public FlaconiCartPage cartPage() {
		click(addCartButton);
		return new FlaconiCartPage(driver);
	}

	public FlaconiCartPage cartPageIcon() {
		click(cartIconbutton);
		return new FlaconiCartPage(driver);

	}
}
