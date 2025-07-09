package com.eox.externalhdo.amazon.mandatory.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eox.externalhdo.elementfleet.hdolutils.HDOLUtils;
import com.eox.utils.CommonFunctionUtils;

public class ManCheckGeneralInformationPage {
	public static WebDriver driver;

	public ManCheckGeneralInformationPage(WebDriver driver) {
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
		CommonFunctionUtils.radioButtonSelect(input.get("Are any filings required?"), "Are any filings required?");
		CommonFunctionUtils.addTextToTheInputField("If yes, please list", "test");
		CommonFunctionUtils.radioButtonSelect("no", "Are your loss runs currently available in Loss Runs Pro?");
		CommonFunctionUtils.addTextToTheInputField("Date First Contracted with Amazon",
				input.get("Date First Contracted with Amazon"));
		CommonFunctionUtils.addTextToTheInputField("Primary Owner First Name", input.get("Primary Owner First Name"));
		CommonFunctionUtils.addTextToTheInputField("Primary Owner Last Name", input.get("Primary Owner Last Name"));
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@ref='datagrid-dataGrid1-addRow']")).click();

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
