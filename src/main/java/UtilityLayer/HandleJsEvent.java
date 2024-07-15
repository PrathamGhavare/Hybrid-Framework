package UtilityLayer;

import org.openqa.selenium.WebElement;

import BaseLayer.BaseClass;
import executor.JavaScriptExecutor;

public class HandleJsEvent extends BaseClass {

	public static JavaScriptExecutor js() {
		return new JavaScriptExecutor(getDriver());
	}

	public static void click(WebElement wb) {
		js().executeScript("arguments[0].click()", Wait.visibilityof(wb));
	}

	public static void sendKeys(WebElement wb, String value) {
		js().executeScript("arguments[0].value='" + value + "'", Wait.visibilityof(wb));
	}

	public static void scrollupToElement(WebElement wb) {
		js().executeScript("arguments[0].scrollIntoView(true);", Wait.visibilityof(wb));
	}

	public static void borderForElement(WebElement wb) {
		js().executeScript("agruments[0].style.border='3px solid green';", Wait.visibilityof(wb));
	}

	public static void get(String url) {
		js().executeScript("window.location='" + url + "';");
	}

	public static void openUrlInNewWindow(String url) {
		js().executeScript("window.open(" + url + ")");
	}

}
