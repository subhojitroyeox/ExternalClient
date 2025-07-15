package com.eox.externalhdo.amazon.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.eox.utils.CommonFunctionUtils;

public class GeneralInformationPage {

	public static WebDriver driver;

	public GeneralInformationPage(WebDriver driver) {
		GeneralInformationPage.driver = driver;
	}

	public void generalInfoForm(HashMap<String, String> input) {
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.selectItemFromDropdown("Please select the Company Type", input.get("Company type"));
		CommonFunctionUtils.addTextToTheInputField("Amazon DSP Number", input.get("Amazon DSP Number"));
		CommonFunctionUtils.addTextToTheInputField("Mailing Address", input.get("Mailing Address"));
		CommonFunctionUtils.addTextToTheInputField("Principle Garaging Address",
				input.get("Principle Garaging Address"));
		CommonFunctionUtils.addTextToTheInputField("Year Business Established", input.get("Year Business Established"));
		CommonFunctionUtils.addTextToTheInputField("Years under Current Management",
				input.get("Years under Current Management"));
		CommonFunctionUtils.radioButtonSelect(
				input.get("Have you ever allowed others to operate under your authority?"),
				"Have you ever allowed others to operate under your authority?");
		CommonFunctionUtils.radioButtonSelect(input.get("Are any filings required?"), "Are any filings required?");
		CommonFunctionUtils.addTextToTheInputField("If yes, please list", input.get("If yes, please list"));
		CommonFunctionUtils.radioButtonSelect("no", "Are your loss runs currently available in Loss Runs Pro?");
		CommonFunctionUtils.radioButtonSelect(input.get("Are you contracted with any other motor carrier?"),
				"Are you contracted with any other motor carrier?");
		CommonFunctionUtils.addTextToTheInputField("Date First Contracted with Amazon",
				input.get("Date First Contracted with Amazon"));
		CommonFunctionUtils.selectItemFromDropdown("What types of responsibilities does this owner/officer perform?",
				input.get("What types of responsibilities does this owner/officer perform?"));
		CommonFunctionUtils.addTextToTheInputField("Primary Owner First Name", input.get("Primary Owner First Name"));
		CommonFunctionUtils.addTextToTheInputField("Primary Owner Last Name", input.get("Primary Owner Last Name"));
		CommonFunctionUtils.addTextToTheInputField("Percentage of Ownership", input.get("Percentage of Ownership"));
		CommonFunctionUtils.radioButtonSelect(input.get("Is there more than one owner?"),
				"Is there more than one owner?");	
		CommonFunctionUtils.addTextToTheInputField("Owner First Name", "test owner");
		CommonFunctionUtils.addTextToTheInputField("Owner Last Name", "test last owner");
		CommonFunctionUtils.addTextToTheInputField("Title", "test title");
		driver.findElement(By.xpath("//input[contains(@name,'[0][percentageOfOwnership]')]")).sendKeys("20");
		CommonFunctionUtils.addTextToTheInputField("First Client Claims Contact Name",
				input.get("First Client Claims Contact Name"));
		CommonFunctionUtils.addEmailToTheInputField("First Client Claims Contact Email",
				input.get("First Client Claims Contact Email"));
		CommonFunctionUtils.addTextToTheInputField("Location #1", input.get("Location #1"));
		CommonFunctionUtils.selectItemFromDropdown("Description of Operations at this Location",
				input.get("Description of Operations at this Location"));
		CommonFunctionUtils.addTextToTheInputField("Street Address", input.get("Street Address"));
		CommonFunctionUtils.addTextToTheInputField("City", input.get("City"));
		CommonFunctionUtils.selectItemFromDropdown("State", input.get("State"));
		CommonFunctionUtils.addTextToTheInputField("Zip Code", input.get("Zip Code"));
		CommonFunctionUtils.addTextToTheInputField("Number of Clerical Employees",
				input.get("Number of Clerical Employees"));
		CommonFunctionUtils.addTextToTheInputField("Total Estimated Monthly Payroll for Clerical Employees",
				input.get("Total Estimated Monthly Payroll for Clerical Employees"));
		CommonFunctionUtils.addTextToTheInputField("Number of Employees Outside Sales",
				input.get("Number of Employees Outside Sales"));
		CommonFunctionUtils.addTextToTheInputField("Total Estimated Monthly Payroll for Employees Outside Sales",
				input.get("Total Estimated Monthly Payroll for Employees Outside Sales"));
		CommonFunctionUtils.addTextToTheInputField("Number of Drivers", input.get("Number of Drivers"));
		CommonFunctionUtils.addTextToTheInputField(
				"Total Estimated Monthly Payroll for Drivers not including installation or assembly services",
				input.get(
						"Total Estimated Monthly Payroll for Drivers not including installation or assembly services"));
		CommonFunctionUtils.radioButtonSelect(input.get("Do any drivers provide installation or assembly services?"),
				"Do any drivers provide installation or assembly services?");
		CommonFunctionUtils.addTextToTheInputField(
				"Total Estimated Monthly Payroll specific to drivers performing installation or assembly services",
				input.get(
						"Total Estimated Monthly Payroll specific to drivers performing installation or assembly services"));
		CommonFunctionUtils.addTextToTheInputField("Number of Garage Employees",
				input.get("Number of Garage Employees"));
		CommonFunctionUtils.addTextToTheInputField("Total Estimated Monthly Payroll for Garage Employees",
				input.get("Total Estimated Monthly Payroll for Garage Employees"));
		CommonFunctionUtils.addTextToTheInputField("Number of Other Employees", input.get("Number of Other Employees"));
		CommonFunctionUtils.addTextToTheInputField("Total Estimated Monthly Payroll for Other Employees",
				input.get("Total Estimated Monthly Payroll for Other Employees"));
		CommonFunctionUtils.addTextToTheInputField("Describe Other Employee Role Types",
				input.get("Describe Other Employee Role Types"));
		CommonFunctionUtils.addTextToTheInputField("Number of Vehicles", input.get("Number of Vehicles"));
		CommonFunctionUtils.addTextToTheInputField("What percentage of vehicles travel outside of 50 miles radius?",
				input.get("What percentage of vehicles travel outside of 50 miles radius?"));
		CommonFunctionUtils.radioButtonSelect(input.get("Do any employees take a scheduled vehicle home at night?"),
				"Do any employees take a scheduled vehicle home at night?");
		CommonFunctionUtils.radioButtonSelect(
				input.get("Do employees, including admin staff, ever use personal vehicles while working?"),
				"Do employees, including admin staff, ever use personal vehicles while working?");
		CommonFunctionUtils.activeButtonClick("Next");

	}

}
