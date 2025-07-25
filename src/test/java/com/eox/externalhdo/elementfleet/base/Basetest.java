package com.eox.externalhdo.elementfleet.base;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.eox.externalhdo.elementfleet.pages.UserManagementClientAdminPage;
import com.eox.externalhdo.elementfleet.pages.UserManagementEditPage;
import com.aventstack.extentreports.ExtentReports;
import com.eox.externalhdo.elementfleet.hdolutils.ExternalUtils;
import com.eox.externalhdo.elementfleet.pages.Clientadmingethelpandsubmitpage;
import com.eox.externalhdo.elementfleet.pages.Clientadminsaveandclosepage;
import com.eox.externalhdo.elementfleet.pages.EditApplicationPage;
import com.eox.externalhdo.elementfleet.pages.FormSubmitPage;
import com.eox.externalhdo.elementfleet.pages.InsuranceFormPage;
import com.eox.externalhdo.elementfleet.pages.PaymentPage;
import com.eox.externalhdo.elementfleet.pages.Producerquotepublishpage;
import com.eox.externalhdo.elementfleet.pages.Producersendapplicationpage;
import com.eox.externalhdo.elementfleet.pages.SendApplicationPage;
import com.eox.externalhdo.elementfleet.pages.TileAccessValidationPage;
import com.eox.externalhdo.elementfleet.pages.UnitsEquipmentDataGridPage;
import com.eox.externalhdo.elementfleet.pages.UserManagementPage;
import com.eox.externalhdo.elementfleet.pages.clientadmincancelpage;
import com.eox.externalhdo.elementfleet.pages.producerquoteacceptpage;
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
	public static ExtentReports extent;
	public static UserManagementPage userManagementPage;
	public static UserManagementClientAdminPage userManagementClientAdminPage;
	public static UserManagementEditPage userManagementEditPage;
	public static UserManagementPage UmPage;
	public static ExternalUtils utils;
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
//	From thimmesh 
	public static Producersendapplicationpage sendapp;
	public static Producerquotepublishpage publishquote;
	public static producerquoteacceptpage quoteaccepted;
	public static Clientadmingethelpandsubmitpage gethelpandsubmit;
	public static Clientadminsaveandclosepage saveandclose;
	public static clientadmincancelpage cancel;

//	String variable 
	private static String web_URL = "https://hdoustest.eoxvantage.com/#login";
	private static String userID = SupportUtils.getProperty("clientadminusername");
	private static String password = SupportUtils.getProperty("clientadminpassword");

	@BeforeSuite
	public static void initializebrowser() {
		driver = WebDriverUtils.getDriver();
		driver.get("https://hdoustest.eoxvantage.com/#login");
		cu = new CommonFunctionUtils(driver, 10);
		extent = SupportUtils.getInstance();
		userManagementPage = new UserManagementPage(driver);
		userManagementClientAdminPage = new UserManagementClientAdminPage(driver);
		userManagementEditPage = new UserManagementEditPage(driver);
		UmPage = new UserManagementPage(driver);
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
//		From thimmesh 
		sendapp = new Producersendapplicationpage(driver);
		publishquote = new Producerquotepublishpage(driver, extent);
		quoteaccepted = new producerquoteacceptpage(driver);
		gethelpandsubmit = new Clientadmingethelpandsubmitpage(driver);
		saveandclose = new Clientadminsaveandclosepage(driver);
		cancel = new clientadmincancelpage(driver);

	}

	@BeforeTest
	public static void loginSetup() {
		LoginUtils.loginToApplication("HDO");
	}

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

	@AfterSuite
	public static void terminate() {
		extent.flush();
	}
}
