package com.eox.externalhdo.amazon.base;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.eox.externalhdo.amazon.mandatory.pages.ManCheckGeneralInformationPage;
import com.eox.externalhdo.amazon.mandatory.pages.ManCheckHiredAutosPage;
import com.eox.externalhdo.amazon.mandatory.pages.ManCheckOpearionsPage;
import com.eox.externalhdo.amazon.mandatory.pages.ManCheckUnitsLaborPage;
import com.eox.externalhdo.amazon.mandatory.pages.MyCompanyDetailsMandatoryPage;
import com.eox.externalhdo.amazon.mandatory.pages.WelcomeApplicationAcknoweldgementPage;
import com.eox.externalhdo.amazon.pages.AttachmentsPage;
import com.eox.externalhdo.amazon.pages.GeneralInformationPage;
import com.eox.externalhdo.amazon.pages.NonownedPage;
import com.eox.externalhdo.amazon.pages.OperationsPage;
import com.eox.externalhdo.amazon.pages.UnitsandLaborPage;
import com.eox.externalhdo.amazon.pages.WelcomeandAcknowledgementPage;
import com.eox.externalhdo.elementfleet.hdolutils.ExternalUtils;
import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.FTNIPayment;
import com.eox.utils.LoginUtils;
import com.eox.utils.SupportUtils;
import com.eox.utils.WebDriverUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Basetest {
	public static WebDriver driver;
	public static CommonFunctionUtils cu;
	public static WelcomeandAcknowledgementPage mcd;
	public static GeneralInformationPage gi;
	public static OperationsPage opn;
	public static UnitsandLaborPage ul;
	public static NonownedPage nop;
	public static AttachmentsPage attach;
	public static ExternalUtils aznutils;

	public static MyCompanyDetailsMandatoryPage mand;
	public static WelcomeApplicationAcknoweldgementPage first;
	public static ManCheckGeneralInformationPage third;
	public static ManCheckOpearionsPage fourth;
	public static ManCheckUnitsLaborPage fifth;
	public static ManCheckHiredAutosPage sixth;
	public static LoginUtils loginUtils;
	public static FTNIPayment fTNIPayment;
	private static String web_URL = SupportUtils.getProperty("hdoStage");
	private static String userID = SupportUtils.getProperty("dspUsername");
	private static String password = SupportUtils.getProperty("dspPassword");

	@BeforeSuite
	public static void initializebrowser() {
		driver = WebDriverUtils.getDriver();
		driver.get("https://hdoustest.eoxvantage.com/#login");
		cu = new CommonFunctionUtils(driver, 10);
		first = new WelcomeApplicationAcknoweldgementPage(driver);
		third = new ManCheckGeneralInformationPage(driver);
		fourth = new ManCheckOpearionsPage(driver);
		fifth = new ManCheckUnitsLaborPage(driver);
		sixth = new ManCheckHiredAutosPage(driver);
		mcd = new WelcomeandAcknowledgementPage(driver);
		gi = new GeneralInformationPage(driver);
		opn = new OperationsPage(driver);
		ul = new UnitsandLaborPage(driver);
		nop = new NonownedPage(driver);
		attach = new AttachmentsPage(driver);
		aznutils = new ExternalUtils(driver);
		mand = new MyCompanyDetailsMandatoryPage(driver);
		loginUtils = new LoginUtils(driver, web_URL, userID, password);
		fTNIPayment = new FTNIPayment(driver);
	}

	@BeforeClass
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
		// String to Json using Jackson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}
}
