package com.eox.externalhdo.elementfleet.pages;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.HDOUtils;

public class Clientadmingethelpandsubmitpage {
	
	public static WebDriver driver;

	public Clientadmingethelpandsubmitpage(WebDriver driver) {
		Clientadmingethelpandsubmitpage.driver=driver;
		
		// TODO Auto-generated constructor stub
	}
public void gethelp() {
CommonFunctionUtils.waitForSpinnerGoesOff();
HDOUtils.openTiles("Insurance", "Quotes");
CommonFunctionUtils.verifyListViewRecordAndAction( driver, "Company Name", "Subhojit Test Company",Optional.of("Edit Application"));
CommonFunctionUtils.waitForSpinnerGoesOff();
CommonFunctionUtils.activeButtonClick("Next");
CommonFunctionUtils.waitForVisibility(driver.findElement(By.xpath("//button[@title='Already Signed']")));
CommonFunctionUtils.activeButtonClick("Next");
CommonFunctionUtils.activeButtonClick("Next");
CommonFunctionUtils.activeButtonClick("Next");
CommonFunctionUtils.activeButtonClick("Next");
CommonFunctionUtils.activeButtonClick("Next");
CommonFunctionUtils.activeButtonClick("Next");
CommonFunctionUtils.activeButtonClick("Next");
CommonFunctionUtils.activeButtonClick("Next");
CommonFunctionUtils.activeButtonClick("Previous");
CommonFunctionUtils.activeButtonClick("Next");
CommonFunctionUtils.activeButtonClick("Next");
CommonFunctionUtils.activeButtonClick("Get Help");
CommonFunctionUtils.activeButtonClick("OK");
CommonFunctionUtils.activeButtonClick("Submit");
CommonFunctionUtils.activeButtonClick("OK");

{
}
}
	
}


