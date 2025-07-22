package com.eox.externalhdo.elementfleet.pages;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.HDOUtils;

public class clientadmincancelpage {
	public static WebDriver driver;
	public clientadmincancelpage(WebDriver driver) {
		
		// TODO Auto-generated constructor stub
		clientadmincancelpage.driver=driver;
		
	}
	public void cancellation () {
		CommonFunctionUtils.waitForSpinnerGoesOff();
		HDOUtils.openTiles("Insurance", "Quotes");
		CommonFunctionUtils.verifyListViewRecordAndAction( driver, "Company Name", "Subhojit Test Company",Optional.of("Edit Application"));
		CommonFunctionUtils.waitForSpinnerGoesOff();
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.waitForVisibility(driver.findElement(By.xpath("//button[@title='Already Signed']")));
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Cancel");
		CommonFunctionUtils.popupDismiss();
		
	
	}
}


