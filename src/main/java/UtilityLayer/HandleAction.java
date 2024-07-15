package UtilityLayer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseLayer.BaseClass;

public class HandleAction extends BaseClass {

	public static void click(WebElement wb) {
		new Actions(getDriver()).click(Wait.visibilityof(wb)).build().perform();
	}

	public static void sendKeys(WebElement wb, String value) {
		new Actions(getDriver()).sendKeys(Wait.visibilityof(wb), value).build().perform();
	}

	public static void moveToElement(WebElement wb) {
		new Actions(getDriver()).moveToElement(Wait.visibilityof(wb)).build().perform();
	}

	public static void release(WebElement wb) {
		new Actions(getDriver()).release(Wait.visibilityof(wb)).build().perform();
	}

	public static void clickAndHold(WebElement wb) {
		new Actions(getDriver()).clickAndHold(Wait.visibilityof(wb)).build().perform();
	}

	public static void dragAndDrop(WebElement wb, WebElement dest) {
		new Actions(getDriver()).dragAndDrop(Wait.visibilityof(wb), Wait.visibilityof(dest)).build().perform();
	}

	public static void doubleclick(WebElement wb) {
		new Actions(getDriver()).doubleClick(Wait.visibilityof(wb)).build().perform();
	}

	public static void contextclick(WebElement wb) {
		new Actions(getDriver()).contextClick(Wait.visibilityof(wb)).build().perform();
	}

	public static void enterUppercaseText(WebElement wb, String value) {
		new Actions(getDriver()).keyDown(Keys.SHIFT).sendKeys(Wait.visibilityof(wb), value).build().perform();
	}
}
