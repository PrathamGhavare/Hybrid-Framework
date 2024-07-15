package UtilityLayer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class HandleDropDown extends BaseClass {

	public static void selectByVisibleText(WebElement wb, String value) {
		new Select(Wait.visibilityof(wb)).selectByVisibleText(value);
	}

	public static void selectByValue(WebElement wb, String value) {
		new Select(Wait.visibilityof(wb)).selectByValue(value);
	}

	public static void selectByIndex(WebElement wb, int Index) {
		new Select(Wait.visibilityof(wb)).selectByIndex(Index);
	}

	public static String getFirstSelectedOption(WebElement wb) {
		return new Select(Wait.visibilityof(wb)).getFirstSelectedOption().getText();
	}

	public static int size(WebElement wb) {
		return new Select(Wait.visibilityof(wb)).getOptions().size();
	}

	public static void getOptions(WebElement wb) {
		List<WebElement> list = new Select(Wait.visibilityof(wb)).getOptions();
		for (WebElement value : list) {
			System.out.println(value.getText());
		}
	}

	public static void selectvalue(List<WebElement> ls, String expectedValue) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(ls));

		for (WebElement value : ls) {
			String actualvalue = value.getText();
			if (actualvalue.equalsIgnoreCase(expectedValue)) {
				Wait.click(value);
				break;
			}
		}
	}

}
