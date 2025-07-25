package com.eox.externalhdo.elementfleet.pages;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eox.externalhdo.elementfleet.hdolutils.ExternalUtils;
import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.FTNIPayment;
import com.eox.utils.HDOUtils;

public class producerquoteacceptpage extends ExternalUtils {
	public static WebDriver driver;

	public producerquoteacceptpage(WebDriver driver) {
		super(driver);
		producerquoteacceptpage.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void quoteaccept() {
		HDOUtils.openTiles("Insurance", "Quotes");
		CommonFunctionUtils.waitForSpinnerGoesOff();
		CommonFunctionUtils.verifyListViewRecordAndAction(driver, "Company Name", "ATZZ Test Client",
				Optional.of("View Quote"));
		CommonFunctionUtils.activeButtonClick("Accept");
		elementClick("data[gaicGrid][1][accept1]");
		elementClick("data[gaicGrid][2][accept1]");
		CommonFunctionUtils.activeButtonClick("Submit");
		FTNIPayment.ftniPaymentCompletionForUS();
		driver.findElement(By.xpath("//input[@id='submitPaymentButton']")).click();
	}

	public void quotereject() throws InterruptedException {
		CommonFunctionUtils.waitForSpinnerGoesOff();
		HDOUtils.openTiles("Insurance", "Quotes");
		CommonFunctionUtils.waitForSpinnerGoesOff();
		CommonFunctionUtils.verifyListViewRecordAndAction(driver, "Company Name", "ATZZ Test Client",
				Optional.of("View Quote"));
		CommonFunctionUtils.activeButtonClick("Reject");
		elementClick("data[gaicGrid][1][accept2]");
		elementClick("data[gaicGrid][2][accept2]");
		CommonFunctionUtils.activeButtonClick("Submit");
		CommonFunctionUtils.activeButtonClick("OK");

	}
}