package com.eox.externalhdo.elementfleet.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eox.externalhdo.elementfleet.base.Basetest;

public class ReferralConditionTest extends Basetest {

	@Test(dataProvider = "getData")
	public void clientAdminSubmit(HashMap<String, String> input) throws InterruptedException {
		insurancepage.welcomeTab();
		insurancepage.ApplicationTab(input);
		insurancepage.insuranceandApplicantInformationTab(input);
		unitsequipmentDatagrid.elementLeasedUnits(input);
		unitsequipmentDatagrid.elementLeasedEquipment(input);
		unitsequipmentDatagrid.nonElementLeasedUnits(input);
		unitsequipmentDatagrid.nonElementLeasedEquipments(input);
		formSubmit.submitForm();

	}

	@Test
	public void referraltest() {
		loginUtils.switchUser("hub_1752834223754", "He_7aMRSek5i", "Element Fleet");
		referralCheck.referralTab();
		referralCheck.referralCheck();
		}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//data//Referral.json");
		return new Object[][] { { data.get(0) } };
	};

}
