package PageLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.HandleAction;
import UtilityLayer.HandleDropDown;
import UtilityLayer.HandleJsEvent;
import UtilityLayer.Wait;

public class PimPage extends BaseClass {

	public static String EmployeeId;

	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement PimLink;

	@FindBy(xpath = "//a[text()='Add Employee']")
	private WebElement addEmployeeLink;

	@FindBy(name = "firstName")
	private WebElement firstName;

	@FindBy(name = "middleName")
	private WebElement middleName;

	@FindBy(name = "lastName")
	private WebElement lastName;

	@FindBy(xpath = "//button[text()=' Save ']")
	private WebElement SaveButton1;

	@FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
	private WebElement empId;

	@FindBy(xpath = "//label[text()='Nationality']/following::div[@class='oxd-select-text oxd-select-text--active'][1]")
	private WebElement nationalityDropDown;

	@FindBys(@FindBy(xpath = "//div[@class='oxd-select-option']/child::span"))
	private List<WebElement> countryList;

	@FindBys(@FindBy(xpath = "//input[@type='radio']"))
	private List<WebElement> genderList;

	@FindBy(xpath = "//p[text()=' * Required']/parent::div/child::button")
	private WebElement savebutton2;

	@FindBy(xpath = "//a[text()='Employee List']")
	private WebElement employeeList;

	@FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div/child::input")
	private WebElement employeeIdTextBox;

	@FindBy(xpath = "//button[text()=' Search ']")
	private WebElement search;

	public PimPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void PimPageFunctionality(String fname, String mname, String Lname, String expectedCountry,
			String expectedGender) {
		Wait.click(PimLink);
		HandleJsEvent.click(addEmployeeLink);
		Wait.sendKeys(firstName, fname);
		HandleAction.sendKeys(middleName, mname);
		Wait.sendKeys(lastName, Lname);
		Wait.click(SaveButton1);

		EmployeeId = Wait.getAttrribute(empId, "value");

		Wait.click(nationalityDropDown);
		HandleDropDown.selectvalue(countryList, expectedCountry);

		for (WebElement g : genderList) {
			String actualvalue = g.getText();
			if (actualvalue.equalsIgnoreCase(expectedGender)) {
				Wait.click(g);
				break;
			}
		}

		Wait.click(savebutton2);
		Wait.click(employeeList);
		Wait.sendKeys(employeeIdTextBox, EmployeeId);
		Wait.click(search);
	}

}
