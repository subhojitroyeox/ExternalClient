package com.eox.externalhdo.amazon.test;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eox.externalhdo.amazon.base.Basetest;
import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.SupportUtils;

public class MyCompanysubmissionTest extends Basetest {

	@Test(dataProvider = "getData")
	public void mcdSubmission(HashMap<String, String> input) throws InterruptedException {
		//mcd.MCDform();
		aznutils.esignPdf("HUB Drive Online Privacy Notice-US.pdf", "Click to sign the document");
		aznutils.esignPdf("HUB Drive Online Terms and Conditions US.pdf", "Click to sign the document");
		aznutils.esignPdf("Telematics-User-Agreement.pdf", "Click to sign the document");
		aznutils.esignPdf("Amendment-User-Agreement.pdf", "Click to sign the document");
		aznutils.esignPdf("DSP Claims Authorization Letter US.pdf", "Click to sign the document");
//		gi.generalInfoForm(input);
		//opn.operations(input);
//		ul.unitsFileUpload();
//		ul.laborFileUpload();
//		nop.nonownedform(input);
//		// esignform.esignInForm();
//		attach.uploaddocuments();
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//data//TestData2.json");
		return new Object[][] { { data.get(0) } };

	};

}
