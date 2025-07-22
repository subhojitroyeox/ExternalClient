package com.eox.externalhdo.elementfleet.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eox.externalhdo.elementfleet.base.Basetest;
import com.eox.utils.CommonFunctionUtils;

public class InsuranceFormSubmissionTest extends Basetest {
	@Test(dataProvider = "getData")
	public void insuranceApplicationSubmission(HashMap<String, String> input) throws InterruptedException {
		insurancepage.welcomeTab();
		insurancepage.ApplicationTab(input);
		insurancepage.insuranceandApplicantInformationTab(input);
		unitsequipmentDatagrid.elementLeasedUnits(input);
		unitsequipmentDatagrid.elementLeasedEquipment(input);
		unitsequipmentDatagrid.nonElementLeasedUnits(input);
		unitsequipmentDatagrid.nonElementLeasedEquipments(input);
		formSubmit.submitForm();

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//data//InsuranceForm.json");
		return new Object[][] { { data.get(0) } };
	};
}
