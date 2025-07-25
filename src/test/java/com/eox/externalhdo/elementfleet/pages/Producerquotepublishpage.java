package com.eox.externalhdo.elementfleet.pages;

import java.util.Optional;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.HDOUtils;

public class Producerquotepublishpage {

	public static WebDriver driver;
	public static ExtentReports extent;

	public Producerquotepublishpage(WebDriver driver, ExtentReports extent) {
		Producerquotepublishpage.driver = driver;
		Producerquotepublishpage.extent = extent;
		// TODO Auto-generated constructor stub
	}

	public void publishquoteaction() {
		ExtentTest test = extent.createTest("Popup Wait Test");
		test.info("Waiting for the popup to appear (up to 3 minutes)");
		CommonFunctionUtils.waitForSpinnerGoesOff();
		HDOUtils.openTiles("Insurance", "Quotes");
		CommonFunctionUtils.waitForSpinnerGoesOff();
		CommonFunctionUtils.verifyListViewRecordAndAction(driver, "Company Name", "ATZZ Test Client",
				Optional.of("Review Quote"));
		CommonFunctionUtils.activeButtonClick("Publish");
		CommonFunctionUtils.popupAccept();

	}

}
