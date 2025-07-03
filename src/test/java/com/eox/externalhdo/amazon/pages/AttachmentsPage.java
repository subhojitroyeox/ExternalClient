package com.eox.externalhdo.amazon.pages;

import org.openqa.selenium.WebDriver;

import com.eox.utils.CommonFunctionUtils;

public class AttachmentsPage {

	public static WebDriver driver;

	public AttachmentsPage(WebDriver driver) {
		AttachmentsPage.driver = driver;
	}

	public void uploaddocuments() {
		CommonFunctionUtils.excelUpload("Amazon Certificate of Insurance", "amazonattachments/A Test.pdf");
		CommonFunctionUtils.excelUpload("Articles of Incorporation", "amazonattachments/B Test.pdf");
		CommonFunctionUtils.excelUpload("Copy of FEIN", "amazonattachments/C Test.pdf");
		CommonFunctionUtils.excelUpload("Copy of All Insurance Policies", "amazonattachments/A Test.xlsx");
		CommonFunctionUtils.excelUpload("Copy of UIN", "amazonattachments/B Test .docx");
		//CommonFunctionUtils.excelUpload("Worker's Compensation Experience Rating Form",
			//	"amazonattachments/C Test.xlsx");
		CommonFunctionUtils.excelUpload("Executed Amazon Contract", "amazonattachments/C Test.docx");
		CommonFunctionUtils.excelUpload("4 Years of Loss History for all Lines of Business",
				"amazonattachments/C Test.pdf");
		CommonFunctionUtils.activeButtonClick("Submit Form");

	}
}
