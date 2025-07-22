package com.eox.externalhdo.elementfleet.pages;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.eox.externalhdo.elementfleet.hdolutils.ExternalUtils;
import com.eox.utils.CommonFunctionUtils;

public class InsuranceFormPage extends ExternalUtils {
	public static WebDriver driver;

	public InsuranceFormPage(WebDriver driver) {
		super(driver);
		InsuranceFormPage.driver = driver;
	}

	public void welcomeTab() {
		CommonFunctionUtils.elementClick(driver.findElement(By.xpath("//i[@class='fa fa-refresh']//parent::button[@class='btn btn-primary']")));
		CommonFunctionUtils.elementClick(driver.findElement(By.xpath("//a[@page-id='cfdf0029-ad61-4eae-b18a-ad27eef968d5']")));
		try {
			CommonFunctionUtils.waitForSpinnerGoesOff();
			CommonFunctionUtils.activeButtonClick("Next");
		} catch (Exception e) {
			CommonFunctionUtils.activeButtonClick("Next");
		}
	}
	
	public void ApplicationTabEsign() {
		esignPdf("HUB Drive Online Privacy Notice-US.pdf", "Click to sign the document");
		esignPdf("HUB Drive Online Terms and Conditions US.pdf", "Click to sign the document");
		esignPdf("HUB Drive Online EULA US.pdf", "Click to sign the document");
	}
	
	public void ApplicationTabWithEsign(HashMap<String, String> input) {
		//ApplicationTabEsign();
		ApplicationTab(input);
	}
	
	public void ApplicationTab(HashMap<String, String> input) {
		CommonFunctionUtils.waitForSpinnerGoesOff();
		CommonFunctionUtils
				.checkBoxClick("I have read the HDOL Privacy Policy. I agree with the terms and conditions.");
		CommonFunctionUtils.checkBoxClick("I have read and agree to the HDOL terms and conditions.");
		CommonFunctionUtils.checkBoxClick("I agree to the terms of the End User License Agreement");
		CommonFunctionUtils.activeButtonClick("Next");
	}

	public void insuranceandApplicantInformationTab(HashMap<String, String> input) throws InterruptedException {
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.radioButtonSelect(input.get("Do you require insurance on units and equipment"),
				"Do you require insurance on units and equipment other than the Element-Leased units and equipment?");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.selectItemFromDropdown("Company Type", input.get("Company"));
		CommonFunctionUtils.addTextToTheInputField("Proposed Effective Date", "07-15-2025");
		CommonFunctionUtils.addTextToTheInputField("MC Number", input.get("MC Number"));
		CommonFunctionUtils.addTextToTheInputField("DOT Number", input.get("DOT Number"));
		CommonFunctionUtils.addTextToTheInputField("SIC", input.get("SIC"));
		CommonFunctionUtils.addTextToTheInputField("NAICS", input.get("NAICS"));
		driver.findElement(By.xpath("//input[contains(@id,'fein')]")).clear();
		CommonFunctionUtils.addTextToTheInputField("FEIN", input.get("fein"));
		CommonFunctionUtils.addTextToTheInputField("Business Phone", input.get("Business Phone"));
		CommonFunctionUtils.addTextToTheInputField("Website Address", input.get("Webiste"));
		addInputToDatagrid("data[applicantInformationGrid][0][addressLine]", "NY");
		CommonFunctionUtils.addTextToTheInputField("Address Line 2", input.get("Address Line 2"));
		CommonFunctionUtils.addTextToTheInputField("City", input.get("City"));
		CommonFunctionUtils.selectItemFromDropdown("State", input.get("State"));
		CommonFunctionUtils.addTextToTheInputField("Zip Code", input.get("applicant Zip Code"));
		CommonFunctionUtils.addTextToTheInputField("Contact First Name", input.get("Contact First Name"));
		CommonFunctionUtils.addTextToTheInputField("Contact Last Name", input.get("Contact Last Name"));
		CommonFunctionUtils.selectItemFromDropdown("Role Type", input.get("Role Type"));
		CommonFunctionUtils.addTextToTheInputField("Business Phone", input.get("Business Phone"));
		CommonFunctionUtils.addTextToTheInputField("Mobile Phone", input.get("Mobile Phone"));		
		addInputToDatagrid("data[locationInformationGrid][0][address]", input.get("loc Address"));
		addInputToDatagrid("data[locationInformationGrid][0][city]", input.get("loc City"));
		selectChoicesDropdownValue("data[locationInformationGrid][0][stateProvince]", input.get("loc State"));
		addInputToDatagrid("data[locationInformationGrid][0][zipCode]", input.get("loc Zip Code"));
		CommonFunctionUtils.addTextToTheInputField("Date Business Started", input.get("Date Business Started"));
		CommonFunctionUtils.addTextToTheInputField("Please describe primary operations",
				input.get("Please describe primary operations"));
		CommonFunctionUtils.radioButtonSelect(input.get("Are you a subsidiary of another entity?"),
				"Are you a subsidiary of another entity?");
		CommonFunctionUtils.addTextToTheInputField("Parent Company Name", input.get("Parent Company Name"));
		CommonFunctionUtils.addTextToTheInputField("Relationship Description", input.get("Relationship Description"));
		CommonFunctionUtils.addTextToTheInputField("Percentage of Ownership", input.get("Percentage of Ownership1"));
		CommonFunctionUtils.radioButtonSelect(input.get("Do you have any subsidiaries?"),
				"Do you have any subsidiaries?");

		addInputToDatagrid("data[subsidiaryCompanyName]", "Test Firstname");
		addInputToDatagrid("[relationshipDescription1]", "test description");
		addInputToDatagrid("data[percentageOfOwnership1]", "20");
		selectChoicesDropdownValue("data[inWhatRadiusDoTheMajorityOfYourVehiclesOperateInMiles]", "0-50");
		selectChoicesDropdownValue("data[whatIsTheUseForTheMajorityOfYourVehicles]",
				input.get("What is the Use for the majority of your vehicles?"));
		selectChoicesDropdownValue("data[pleaseSelectYourPerOccurrenceDeductibleInCad]", "2500");

		CommonFunctionUtils.radioButtonSelect(input.get("Would you like to add tow coverage?"),
				"Would you like to add tow coverage?");
		selectChoicesDropdownValue("data[towLimitInCad]", "10,000");
		CommonFunctionUtils.radioButtonSelect(input.get("Is a formal safety program in operation?"),
				"Is a formal safety program in operation?");
		CommonFunctionUtils.radioButtonSelect(input.get("Do you have a dedicated Safety Manager?"),
				"Do you have a dedicated Safety Manager?");

		addInputToDatagrid("data[firstNamesafetymanager]", input.get("First Name"));
		addInputToDatagrid("data[lastNamesafetymanager]", input.get("Last Name"));

		addInputToDatagrid("data[emailAddresssafetymanager]", "test+saftey@email.com");
		CommonFunctionUtils.radioButtonSelect(input.get("Any policy or coverage declined, cancelled"),
				"Any policy or coverage declined, cancelled, or non-renewed during the prior three (3) years for any premises or operations?");
		CommonFunctionUtils.checkBoxClick(input.get("Reason"));
		CommonFunctionUtils.radioButtonSelect(
				input.get("Does applicant have other business ventures for which coverage is not requested?"),
				"Does applicant have other business ventures for which coverage is not requested?");
		CommonFunctionUtils.addTextToTheInputField("Describe other operations for which coverage is not requested",
				input.get("Describe other operations for which coverage is not requested"));
		CommonFunctionUtils.selectItemFromDropdown("Nature of Business", input.get("Nature of Business"));
		CommonFunctionUtils.addTextToTheInputField("Year", input.get("Year"));
		CommonFunctionUtils.addTextToTheInputField("Carrier", input.get("Carrier"));
		CommonFunctionUtils.addTextToTheInputField("Policy Number", input.get("Policy Number"));
		CommonFunctionUtils.addTextToTheInputField("Broker Name", input.get("Broker Name"));
		CommonFunctionUtils.addTextToTheInputField("Premium", input.get("Premium"));
		CommonFunctionUtils.addTextToTheInputField("Effective Date", input.get("Effective Date"));
		CommonFunctionUtils.addTextToTheInputField("Expiration Date", input.get("Expiration Date"));
		CommonFunctionUtils.radioButtonSelect(
				input.get("Do over 50% of the employees use their autos in the business?"),
				"Do over 50% of the employees use their autos in the business?");
		CommonFunctionUtils.radioButtonSelect(input.get("Is there a vehicle maintenance program in operation?"),
				"Is there a vehicle maintenance program in operation?");
		CommonFunctionUtils.radioButtonSelect(input.get("Are any vehicles leased to others?"),
				"Are any vehicles leased to others?");
		CommonFunctionUtils.radioButtonSelect(input.get("Do operations involve transporting hazardous material?"),
				"Do operations involve transporting hazardous material?");
		CommonFunctionUtils.radioButtonSelect(input.get("Any hold harmless agreements?"),
				"Any hold harmless agreements?");
		CommonFunctionUtils.radioButtonSelect(input.get("Any vehicles used by family members? If so, identify"),
				"Any vehicles used by family members? If so, identify");
		CommonFunctionUtils.radioButtonSelect(input.get("Do you obtain MVR (Motor Vehicle Report) verifications?"),
				"Do you obtain MVR (Motor Vehicle Report) verifications?");
		CommonFunctionUtils.radioButtonSelect(input.get("Any vehicles owned but not scheduled on this application?"),
				"Any vehicles owned but not scheduled on this application?");
		CommonFunctionUtils.radioButtonSelect(
				input.get("Has there been any damage caused by normal wear and tear on the vehicles?"),
				"Has there been any damage caused by normal wear and tear on the vehicles?");
		CommonFunctionUtils.radioButtonSelect(
				input.get("Has there been any damage caused by freezing or extreme weather conditions?"),
				"Has there been any damage caused by freezing or extreme weather conditions?");
		CommonFunctionUtils.radioButtonSelect(
				input.get("Has there been any mechanical or electrical breakdown of the vehicles?"),
				"Has there been any mechanical or electrical breakdown of the vehicles?");
		CommonFunctionUtils.radioButtonSelect(
				input.get("Has there been any blowouts, punctures, or other road damage to tires?"),
				"Has there been any blowouts, punctures, or other road damage to tires?");
		CommonFunctionUtils.radioButtonSelect(input.get(
				"Has there been any damage due to gradual deterioration or the effects of improper/lack of maintenance?"),
				"Has there been any damage due to gradual deterioration or the effects of improper/lack of maintenance?");
		CommonFunctionUtils.radioButtonSelect(
				input.get("Has there been any loss due to conversion, embezzlement, or secretion of the vehicle?"),
				"Has there been any loss due to conversion, embezzlement, or secretion of the vehicle?");
		CommonFunctionUtils.radioButtonSelect(
				input.get(
						"Has there been any loss due to mysterious disappearance or damage caused by a criminal act?"),
				"Has there been any loss due to mysterious disappearance or damage caused by a criminal act?");
		CommonFunctionUtils.radioButtonSelect(input.get("Is there any loss of value at repossession?"),
				"Is there any loss of value at repossession?");
		CommonFunctionUtils.radioButtonSelect(input.get("Are you aware of any manufacturer defects?"),
				"Are you aware of any manufacturer defects?");
		CommonFunctionUtils.radioButtonSelect(
				input.get("Are any non-licensed drivers allowed to operate the vehicles?"),
				"Are any non-licensed drivers allowed to operate the vehicles?");

		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
	}

}
