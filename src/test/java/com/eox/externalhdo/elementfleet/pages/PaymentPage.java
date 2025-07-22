package com.eox.externalhdo.elementfleet.pages;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eox.externalhdo.elementfleet.hdolutils.ExternalUtils;
import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.HDOUtils;

public class PaymentPage extends ExternalUtils {
	public static WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		PaymentPage.driver = driver;
	}

	public void AcceptQuote() {
		CommonFunctionUtils.waitForSpinnerGoesOff();
		HDOUtils.openTiles("Insurance", "Quotes");
		CommonFunctionUtils.waitForSpinnerGoesOff();
		CommonFunctionUtils.verifyListViewRecordAndAction(driver, "Company Name", "EDZZZZZZZZZZZZZZZZZZZZZZZ Tesst",
				Optional.of("View Quote"));
		CommonFunctionUtils.activeButtonClick("Accept");
		elementClick("data[gaicGrid][1][accept1]");
		CommonFunctionUtils.activeButtonClick("Submit");
		driver.switchTo().frame(0);

		driver.switchTo().defaultContent();
	}

}
