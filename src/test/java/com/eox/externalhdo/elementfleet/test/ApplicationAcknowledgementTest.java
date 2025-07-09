package com.eox.externalhdo.elementfleet.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.eox.externalhdo.elementfleet.base.Basetest;
import com.eox.externalhdo.elementfleet.pages.LeasedEquipment;
import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.SupportUtils;

public class ApplicationAcknowledgementTest extends Basetest {
	@Test
	public void insurancesubmission() throws InterruptedException {
		apppage.insuranceApplication();
//		pdfesign.esignPdf("HUB Drive Online Privacy Notice-US.pdf", "Click to sign the document");
//		pdfesign.esignPdf("HUB Drive Online Terms and Conditions US.pdf", "Click to sign the document");
//		pdfesign.esignPdf("HUB Drive Online EULA US.pdf", "Click to sign the document");

	}
}