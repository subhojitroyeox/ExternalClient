package com.eox.externalhdo.elementfleet.base;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.eox.externalhdo.elementfleet.pages.UserManagementClientAdminPage;
import com.eox.externalhdo.elementfleet.pages.UserManagementEditPage;
import com.eox.externalhdo.elementfleet.hdolutils.ExternalUtils;
import com.eox.externalhdo.elementfleet.pages.EditApplicationPage;
import com.eox.externalhdo.elementfleet.pages.FormSubmitPage;
import com.eox.externalhdo.elementfleet.pages.InsuranceFormPage;
import com.eox.externalhdo.elementfleet.pages.PaymentPage;
import com.eox.externalhdo.elementfleet.pages.ReferralConditionPage;
import com.eox.externalhdo.elementfleet.pages.SendApplicationPage;
import com.eox.externalhdo.elementfleet.pages.TileAccessValidationPage;
import com.eox.externalhdo.elementfleet.pages.UnitsEquipmentDataGridPage;
import com.eox.externalhdo.elementfleet.pages.UserManagementPage;
import com.eox.externalhdo.elementfleet.hdolutils.ElementUtils;
import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.FTNIPayment;
import com.eox.utils.HDOUtils;
import com.eox.utils.LoginUtils;
import com.eox.utils.SupportUtils;
import com.eox.utils.WebDriverUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Basetest {
	public static WebDriver driver;
	public static CommonFunctionUtils cu;
	public static UserManagementPage userManagementPage;
	public static UserManagementClientAdminPage userManagementClientAdminPage;
	public static UserManagementEditPage userManagementEditPage;
	public static UserManagementPage UmPage;
	public static ExternalUtils utils;
	public static ReferralConditionPage referralpage;
	public static InsuranceFormPage insurancepage;
	public static UnitsEquipmentDataGridPage unitsequipmentDatagrid;
	public static FormSubmitPage formSubmit;
	public static TileAccessValidationPage tilevalidate;
	public static EditApplicationPage editpage;
	public static HDOUtils hdoutils;
	public static PaymentPage payment;
	public static SendApplicationPage referralCheck;
	public static LoginUtils loginUtils;
	public static FTNIPayment fTNIPayment;
	private static String web_URL = SupportUtils.getProperty("hdoStage");
	private static String userID = SupportUtils.getProperty("clientadminusername");
	private static String password = SupportUtils.getProperty("clientadminpassword");

	@BeforeSuite
	public static void initializebrowser() {
		driver = WebDriverUtils.getDriver();
		driver.get("https://hdoustest.eoxvantage.com/#login");
		cu = new CommonFunctionUtils(driver, 10);
		userManagementPage = new UserManagementPage(driver);
		userManagementClientAdminPage = new UserManagementClientAdminPage(driver);
		userManagementEditPage = new UserManagementEditPage(driver);
		UmPage = new UserManagementPage(driver);
		referralpage = new ReferralConditionPage(driver);
		insurancepage = new InsuranceFormPage(driver);
		unitsequipmentDatagrid = new UnitsEquipmentDataGridPage(driver);
		formSubmit = new FormSubmitPage(driver);
		tilevalidate = new TileAccessValidationPage(driver);
		editpage = new EditApplicationPage(driver);
		hdoutils = new HDOUtils(driver);
		payment = new PaymentPage(driver);
		referralCheck = new SendApplicationPage(driver);
		loginUtils = new LoginUtils(driver, web_URL, userID, password);
		fTNIPayment = new FTNIPayment(driver);

	}

	@BeforeTest
	public static void loginSetup() {
		LoginUtils.loginToApplication("HDO");
	}

//	@AfterTest
//	public static void terminate() {
//		driver.close();
//	}

	// @AfterSuite
//	public static void terminate()
//	{
//		WebDriverUtils.quitDriver();
//	}
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
		// read json to string
		String jsonContent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		// String to Hashmap using Jackson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

}
