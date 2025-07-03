package com.eox.externalhdo.amazon.mandatory.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.eox.utils.CommonFunctionUtils;

public class ManCheckOpearionsPage {

	public static WebDriver driver;

	public ManCheckOpearionsPage(WebDriver driver) {
		ManCheckOpearionsPage.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void operationsFormSubmission(HashMap<String, String> input) {
		CommonFunctionUtils.radioButtonSelect("no", "Do you wish to upload your current and prior policy information?");
		CommonFunctionUtils.addTextToTheInputField("Policy Number", input.get("Policy Number"));
		CommonFunctionUtils.addTextToTheInputField("Insurer", input.get("Insurer"));
		CommonFunctionUtils.addEmailToTheInputField("Insurer Email", input.get("Insurer Email"));
		CommonFunctionUtils.addTextToTheInputField("Broker First Name", input.get("Broker FirstName"));
		CommonFunctionUtils.addTextToTheInputField("Broker Last Name", "first two");
		CommonFunctionUtils.addEmailToTheInputField("Broker Email", input.get("Broker Email"));
		CommonFunctionUtils.addTextToTheInputField("Effective Date", input.get("Effective Date"));
		CommonFunctionUtils.addTextToTheInputField("Expiration Date", input.get("Expiration Date"));
		
//extra fields
		CommonFunctionUtils.addTextToTheInputField("Broker Company", input.get("Broker Company"));
		CommonFunctionUtils.selectItemFromDropdown("Line of Business", "Cargo");
		
		
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
	}

}
