package com.eox.externalhdo.elementfleet.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.eox.externalhdo.elementfleet.hdolutils.HDOLUtils;
import com.eox.externalhdo.elementfleet.hdolutils.ElementUtils;
import com.eox.externalhdo.elementfleet.pages.ApplicationAcknowledgementPage;
import com.eox.externalhdo.elementfleet.pages.EsignPage;
import com.eox.externalhdo.elementfleet.pages.TilevalidationPage;
import com.eox.externalhdo.elementfleet.pages.UserManagementLaunchPage;
import com.eox.externalhdo.elementfleet.test.ApplicationAcknowledgementTest;
import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.HDOUtils;
import com.eox.utils.SupportUtils;
import com.eox.utils.WebDriverUtils;

public class Basetest {
	public static WebDriver driver;
	public static CommonFunctionUtils cu;
	public static ApplicationAcknowledgementPage AAT;
	public static ElementUtils elementutils;
	public static EsignPage esign;
	public static UserManagementLaunchPage userpage;
	public static HDOUtils hdoUtils;
	public static ApplicationAcknowledgementPage apppage;
	public static HDOLUtils pdfesign;
	public static TilevalidationPage tile;

	@BeforeSuite
	public static void initializebrowser() {
		driver = WebDriverUtils.getDriver();
		driver.get("https://hdoustest.eoxvantage.com/#login");
		cu = new CommonFunctionUtils(driver, 10);
		apppage = new ApplicationAcknowledgementPage(driver);
		userpage = new UserManagementLaunchPage(driver);
		pdfesign = new HDOLUtils(driver);
		tile = new TilevalidationPage(driver);

	}

	@BeforeClass
	public static void loginSetup() {
		CommonFunctionUtils.loginToApplication(SupportUtils.getProperty("elementusername"),
				SupportUtils.getProperty("elementpassword"));
	}
	// @AfterSuite
//	public static void terminate()
//	{
//		WebDriverUtils.quitDriver();
//	}

}
