package com.eox.externalhdo.amazon.mandatory.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eox.externalhdo.amazon.base.Basetest;
import com.eox.utils.CommonFunctionUtils;

public class MyCompanyDetailsMandatoryPage {

	public static WebDriver driver;

	public MyCompanyDetailsMandatoryPage(WebDriver driver) {

		MyCompanyDetailsMandatoryPage.driver = driver;
	}

	public void mandatoryFields(HashMap<String, String> input) {

		// Application Acknoweldgement tab
		driver.findElement(By.xpath("//i[@class='fa fa-refresh']//parent::button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//a[@page-id='78f4380e-44a0-470a-9042-3fc00efaba71']")).click();
		CommonFunctionUtils.waitForSpinnerGoesOff();
		CommonFunctionUtils.activeButtonClick("Next");
		try {
			CommonFunctionUtils.waitForSpinnerGoesOff();
		} catch (Exception e) {
			System.out.println("Exception occured");
		}
		CommonFunctionUtils.checkBoxClick("Privacy Policy.");
		CommonFunctionUtils.checkBoxClick("I have read and agree to the HDOL terms and conditions.");
		CommonFunctionUtils.checkBoxClick(" Netradyne device to push event video");
		CommonFunctionUtils.checkBoxClick("Telematics Use Agreement");
		CommonFunctionUtils.checkBoxClick("Authorization Letter.");
		CommonFunctionUtils.checkBoxClick("License Agreement.");
		CommonFunctionUtils.radioButtonSelect("no", "Do you want to share your Netradyne data with HUB?");
	}

	public void mandatory2(HashMap<String, String> input) {
		// General Information tab
		CommonFunctionUtils.selectItemFromDropdown("Please select the Company Type", input.get("Company type"));
		CommonFunctionUtils.addTextToTheInputField("Mailing Address", input.get("Mailing Address"));
		CommonFunctionUtils.addTextToTheInputField("Principle Garaging Address",
				input.get("Principle Garaging Address"));
		CommonFunctionUtils.addTextToTheInputField("Year Business Established", input.get("Year Business Established"));
		CommonFunctionUtils.radioButtonSelect(input.get("Are any filings required?"), "Are any filings required?");
		CommonFunctionUtils.addTextToTheInputField("Date First Contracted with Amazon",
				input.get("Date First Contracted with Amazon"));
		CommonFunctionUtils.addTextToTheInputField("Primary Owner First Name", input.get("Primary Owner First Name"));
		CommonFunctionUtils.addTextToTheInputField("Primary Owner Last Name", input.get("Primary Owner Last Name"));
		CommonFunctionUtils.addTextToTheInputField("Number of Drivers", input.get("Number of Drivers"));
		CommonFunctionUtils.addTextToTheInputField("Number of Vehicles", input.get("Number of Vehicles"));
		CommonFunctionUtils.activeButtonClick("Next");

		// operations tab
		// CommonFunctionUtils.radioButtonSelect("no", "Do you wish to upload your
		// current and prior policy information?");
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

		// Non-Owned
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.drawSignature();

	}

}
