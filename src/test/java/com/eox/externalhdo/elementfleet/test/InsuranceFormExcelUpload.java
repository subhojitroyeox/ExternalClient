package com.eox.externalhdo.elementfleet.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eox.externalhdo.elementfleet.base.Basetest;

public class InsuranceFormExcelUpload extends Basetest {

	@Test(dataProvider = "getData")
	public void excelUpload(HashMap<String, String> input) throws InterruptedException {
		insurancepage.welcomeTab();
		insurancepage.ApplicationTab(input);
		insurancepage.insuranceandApplicantInformationTab(input);
		unitsequipmentDatagrid.LeasedUnitsExcelupload();
		unitsequipmentDatagrid.LeasedEquipmentExcelupload();
		unitsequipmentDatagrid.NonLeasedUnitExcelupload();
		unitsequipmentDatagrid.NonLeasedEquipmentExcelupload();
		formSubmit.submitForm();

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//data//InsuranceForm.json");
		return new Object[][] { { data.get(0) } };
	};

}
