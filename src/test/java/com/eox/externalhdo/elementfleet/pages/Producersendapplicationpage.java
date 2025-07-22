package com.eox.externalhdo.elementfleet.pages;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eox.externalhdo.elementfleet.hdolutils.ExternalUtils;
import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.HDOUtils;

public class Producersendapplicationpage extends ExternalUtils {
	public static WebDriver driver;

	public Producersendapplicationpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		Producersendapplicationpage.driver = driver;
	}

	public void sendapplication() {
		CommonFunctionUtils.waitForSpinnerGoesOff();
		HDOUtils.openTiles("Insurance", "Quotes");
		CommonFunctionUtils.verifyListViewRecordAndAction(driver, "Company Name", "ATZZ Test Client",
                Optional.of("Edit Application"));
		CommonFunctionUtils.waitForSpinnerGoesOff();
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.waitForVisibility(driver.findElement(By.xpath("//button[@title='Already Signed']")));
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.addTextToTheInputField("Percentage of Ownership", "100");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Send Application");
		
	}

}
