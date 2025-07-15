package com.eox.externalhdo.elementfleet.base;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

<<<<<<< HEAD
import com.eox.externalhdo.elementfleet.hdolutils.ExternalUtils;
import com.eox.externalhdo.elementfleet.pages.EditApplicationPage;
import com.eox.externalhdo.elementfleet.pages.FormSubmitPage;
import com.eox.externalhdo.elementfleet.pages.InsuranceFormPage;
import com.eox.externalhdo.elementfleet.pages.ReferralConditionPage;
import com.eox.externalhdo.elementfleet.pages.TileAccessValidationPage;
import com.eox.externalhdo.elementfleet.pages.UnitsEquipmentDataGridPage;
import com.eox.externalhdo.elementfleet.pages.UserManagementPage;
import com.eox.externalhdo.elementfleet.hdolutils.ElementUtils;
=======
import com.eox.externalhdo.elementfleet.hdolutils.HDOLUtils;
import com.eox.externalhdo.elementfleet.hdolutils.ElementUtils;
import com.eox.externalhdo.elementfleet.pages.ApplicationAcknowledgementPage;
import com.eox.externalhdo.elementfleet.pages.EsignPage;
import com.eox.externalhdo.elementfleet.pages.TilevalidationPage;
import com.eox.externalhdo.elementfleet.pages.UserManagementLaunchPage;
import com.eox.externalhdo.elementfleet.test.ApplicationAcknowledgementTest;
>>>>>>> 4bec8d9b0069b90632aee01e3352ec61b9aff608
import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.HDOUtils;
import com.eox.utils.SupportUtils;
import com.eox.utils.WebDriverUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Basetest {
	public static WebDriver driver;
	public static CommonFunctionUtils cu;
<<<<<<< HEAD
	public static UserManagementPage UmPage;
	public static ExternalUtils utils;
	public static ReferralConditionPage referralpage;
	public static InsuranceFormPage insurancepage;
	public static UnitsEquipmentDataGridPage unitsequipmentDatagrid;
	public static FormSubmitPage formSubmit;
	public static TileAccessValidationPage tilevalidate;
	public static EditApplicationPage editpage;
	public static HDOUtils hdoutils;
=======
	public static ApplicationAcknowledgementPage AAT;
	public static ElementUtils elementutils;
	public static EsignPage esign;
	public static UserManagementLaunchPage userpage;
	public static HDOUtils hdoUtils;
	public static ApplicationAcknowledgementPage apppage;
	public static HDOLUtils pdfesign;
	public static TilevalidationPage tile;
>>>>>>> 4bec8d9b0069b90632aee01e3352ec61b9aff608

	@BeforeSuite
	public static void initializebrowser() {
		driver = WebDriverUtils.getDriver();
		driver.get("https://hdoustest.eoxvantage.com/#login");
		cu = new CommonFunctionUtils(driver, 10);
<<<<<<< HEAD
		UmPage = new UserManagementPage(driver);
		referralpage = new ReferralConditionPage(driver);
		insurancepage = new InsuranceFormPage(driver);
		unitsequipmentDatagrid = new UnitsEquipmentDataGridPage(driver);
		formSubmit = new FormSubmitPage(driver);
		tilevalidate = new TileAccessValidationPage(driver);
		editpage = new EditApplicationPage(driver);
		hdoutils = new HDOUtils(driver);
=======
		apppage = new ApplicationAcknowledgementPage(driver);
		userpage = new UserManagementLaunchPage(driver);
		pdfesign = new HDOLUtils(driver);
		tile = new TilevalidationPage(driver);
>>>>>>> 4bec8d9b0069b90632aee01e3352ec61b9aff608

	}

	@BeforeClass
	public static void loginSetup() {
		CommonFunctionUtils.loginToApplication(SupportUtils.getProperty("elementusername"),
				SupportUtils.getProperty("elementpassword"), "HDO");
	}
<<<<<<< HEAD

=======
>>>>>>> 4bec8d9b0069b90632aee01e3352ec61b9aff608
	// @AfterSuite
//	public static void terminate()
//	{
//		WebDriverUtils.quitDriver();
//	}
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
		// read json to string
		String jsonContent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		// String to Json using Jackson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

}
