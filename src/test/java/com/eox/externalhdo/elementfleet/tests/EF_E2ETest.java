package com.eox.externalhdo.elementfleet.tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eox.externalhdo.elementfleet.base.Basetest;

public class EF_E2ETest extends Basetest { 
	
@Test(priority = 1)
	//1st -clientadminusername
	public void clientadminTilevalidation() {
		boolean result = tilevalidate.tileaccesscheck();
		assertTrue(result);
	}
//2nd -clientadminusername
@Test(dataProvider = "getData",priority = 2)
public void insuranceApplicationSubmission(HashMap<String, String> input) throws InterruptedException {
	insurancepage.welcomeTab();
	insurancepage.ApplicationTabWithEsign(input);
	insurancepage.insuranceandApplicantInformationTab(input);
	unitsequipmentDatagrid.elementLeasedUnits(input);
	unitsequipmentDatagrid.elementLeasedEquipment(input);
	unitsequipmentDatagrid.nonElementLeasedUnits(input);
	unitsequipmentDatagrid.nonElementLeasedEquipments(input);
	formSubmit.submitForm();

}
//3rd -producerusername
@Test(priority = 3)
public void producerSendapplication() {
	loginUtils.switchUser("hub_1752834223754","He_7aMRSek5i","Element Fleet");
	sendapp.sendapplication();	
}
//4th -producerusername
@Test(priority = 4)
public void publishQuotetest()
{
	publishquote.publishquoteaction();
}

//6th - this or 6th can run single time - producerusername ( all)
@Test(priority = 5)

public void quoteAccept() throws InterruptedException
{
	quoteaccepted.quoteaccept();
}


@DataProvider
public Object[][] getData() throws IOException {
	List<HashMap<String, String>> data = getJsonDataToMap(
			System.getProperty("user.dir") + "//src//test//java//data//InsuranceForm.json");
	return new Object[][] { { data.get(0) } };
};

}
