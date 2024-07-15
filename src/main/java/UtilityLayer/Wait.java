package UtilityLayer;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class Wait extends BaseClass {

	public static WebElement visibilityof(WebElement wb) {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb));
	}

	public static void click(WebElement wb) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(wb))
				.click();
	}

	public static void submit(WebElement wb) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(wb))
				.submit();
	}

	public static void sendKeys(WebElement wb, String value) {
		visibilityof(wb).sendKeys(value);
	}

	public static String getText(WebElement wb) {
		return visibilityof(wb).getText();
	}

	public static String getAttrribute(WebElement wb, String value) {
		return visibilityof(wb).getAttribute(value);
	}

	public static void clear(WebElement wb) {
		visibilityof(wb).clear();
	}

	public static boolean isDisplayed(WebElement wb) {
		return visibilityof(wb).isDisplayed();
	}

	public static boolean isEnabled(WebElement wb) {
		return visibilityof(wb).isEnabled();
	}

	public static boolean isSelected(WebElement wb) {
		return visibilityof(wb).isSelected();
	}

}
