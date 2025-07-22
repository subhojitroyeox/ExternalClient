package com.eox.externalhdo.elementfleet.pages;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.HDOUtils;

public class Clientadminsaveandclosepage {
	public static WebDriver driver;

	public Clientadminsaveandclosepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		Clientadminsaveandclosepage.driver = driver;
	}
	
	public void save () {
		CommonFunctionUtils.waitForSpinnerGoesOff();
		HDOUtils.openTiles("Insurance", "Quotes");
		CommonFunctionUtils.verifyListViewRecordAndAction( driver, "Company Name", "ATZZ Test Client",Optional.of("Edit Application"));
		CommonFunctionUtils.waitForSpinnerGoesOff();
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.waitForVisibility(driver.findElement(By.xpath("//button[@title='Already Signed']")));
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Save and Close");
		

	}
	}
	
