package com.eox.externalhdo.amazon.mandatory.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.eox.externalhdo.elementfleet.hdolutils.ExternalUtils;
import com.eox.utils.CommonFunctionUtils;

public class ManCheckGeneralInformationPage extends ExternalUtils {
	public static WebDriver driver;

	public ManCheckGeneralInformationPage(WebDriver driver) {
		super(driver);
		ManCheckGeneralInformationPage.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void giFormsubmission2(HashMap<String, String> input) throws InterruptedException {
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.selectItemFromDropdown("Please select the Company Type", input.get("Company type"));
		CommonFunctionUtils.addTextToTheInputField("Mailing Address", input.get("Mailing Address"));
		CommonFunctionUtils.addTextToTheInputField("Principle Garaging Address",
				input.get("Principle Garaging Address"));
		CommonFunctionUtils.addTextToTheInputField("Year Business Established", input.get("Year Business Established"));
		CommonFunctionUtils.addTextToTheInputField("Years under Current Management, numeric only,",
				input.get("Year CM"));
		CommonFunctionUtils.radioButtonSelect(input.get("operate under your authority"),
				"Have you ever allowed others to operate under your authority?");
		CommonFunctionUtils.radioButtonSelect(input.get("Are any filings required?"), "Are any filings required?");
		CommonFunctionUtils.addTextToTheInputField("If yes, please list", "test");
		CommonFunctionUtils.radioButtonSelect("no", "Are your loss runs currently available in Loss Runs Pro?");
		CommonFunctionUtils.addTextToTheInputField("Date First Contracted with Amazon",
				input.get("Date First Contracted with Amazon"));
		CommonFunctionUtils.addTextToTheInputField("Primary Owner First Name", input.get("Primary Owner First Name"));
		CommonFunctionUtils.addTextToTheInputField("Primary Owner Last Name", input.get("Primary Owner Last Name"));
		CommonFunctionUtils.addTextToTheInputField("Percentage of Ownership, numeric only,",
				input.get("Percentage of Ownership"));
		CommonFunctionUtils.radioButtonSelect(input.get("more than one owner"), "Is there more than one owner?");
		CommonFunctionUtils.addTextToTheInputField("First Client Claims Contact Name", input.get("First Contact Name"));
		CommonFunctionUtils.addTextToTheInputField("First Client Claims Contact Email",
				input.get("First Contact Email"));
		CommonFunctionUtils.addTextToTheInputField("Second Client Claims Contact Name",
				input.get("Second Contact Name"));
		CommonFunctionUtils.addTextToTheInputField("Second Client Claims Contact Email",
				input.get("Second Contact Email"));
		CommonFunctionUtils.addTextToTheInputField("Location #1", input.get("Location1"));
		CommonFunctionUtils.selectItemFromDropdown("Description of Operations at this Location",
				input.get("Description of Operations at this Location1"));
		CommonFunctionUtils.addTextToTheInputField("Street Address", input.get("Street Address1"));
		CommonFunctionUtils.addTextToTheInputField("City", "City1");
		CommonFunctionUtils.addTextToTheInputField("Zip Code", input.get("Zip Code1"));
		CommonFunctionUtils.selectItemFromDropdown("State", input.get("State1"));
		CommonFunctionUtils.addTextToTheInputField("Number of Clerical Employees, numeric only,",input.get("Number of Clerical Employees"));
		

//
//		driver.findElement(By.xpath("//button[@ref='datagrid-dataGrid1-addRow']")).click();
//
//		addInputToDatagrid("[1][locationType]", "Location #1");
//
//		driver.findElement(By.xpath("//button[@ref='datagrid-dataGrid1-addRow']")).click();
//
//		driver.findElement(By.xpath("//button[@ref='datagrid-dataGrid1-addRow']")).click();
//		addInputToDatagrid("[2][locationType]", "Location #1");

//		CommonFunctionUtils.addTextToTheInputField("Number of Clerical Employees", "2");
//		CommonFunctionUtils.addTextToTheInputField("Total Estimated Monthly Payroll for Clerical Employees ", "456");
//		CommonFunctionUtils.addTextToTheInputField("Number of Drivers", input.get("Number of Drivers"));
//		CommonFunctionUtils.addTextToTheInputField("Number of Vehicles", input.get("Number of Vehicles"));
//
//		// extra field
//		CommonFunctionUtils.radioButtonSelect("yes", "Have you ever allowed others to operate under your authority?");
//
//		CommonFunctionUtils.activeButtonClick("Next");
	}

}
