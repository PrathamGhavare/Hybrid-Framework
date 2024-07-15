package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.Wait;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//a[@class='oxd-brand']")
	private WebElement logo;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean checkLoogoStatus() {
		return Wait.isDisplayed(logo);
	}

	public static String getUrl() {
		return getDriver().getCurrentUrl();
	}

	public static String getTitle() {
		return getDriver().getTitle();
	}

}
