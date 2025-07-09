package com.eox.externalhdo.amazon.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.SupportUtils;

public class OperationsPage {

	public static WebDriver driver;

	public OperationsPage(WebDriver driver) {

		OperationsPage.driver = driver;
	}

	public void operations(HashMap<String, String> input) throws InterruptedException {
		CommonFunctionUtils.radioButtonSelect("no", "Do you wish to upload your current and prior policy information?");
		CommonFunctionUtils.addTextToTheInputField("Policy Number", input.get("Policy Number"));
		CommonFunctionUtils.addTextToTheInputField("Insurer", input.get("Insurer"));
		CommonFunctionUtils.addEmailToTheInputField("Insurer Email", input.get("Insurer Email"));
		CommonFunctionUtils.addTextToTheInputField("Broker First Name", input.get("Broker FirstName"));
		CommonFunctionUtils.addTextToTheInputField("Broker Last Name", "first two");
		CommonFunctionUtils.addEmailToTheInputField("Broker Email", input.get("Broker Email"));
		CommonFunctionUtils.addTextToTheInputField("Broker Company", input.get("Broker Company"));
		CommonFunctionUtils.addTextToTheInputField("Effective Date", input.get("Effective Date"));
		CommonFunctionUtils.addTextToTheInputField("Expiration Date", input.get("Expiration Date"));
		CommonFunctionUtils.selectItemFromDropdown("Line of Business", input.get("Line of Business"));
		CommonFunctionUtils.excelUpload("Upload Loss Run", "DSP_risk_management_units.xlsx");
		CommonFunctionUtils.activeButtonClick("Next");

	}

}
