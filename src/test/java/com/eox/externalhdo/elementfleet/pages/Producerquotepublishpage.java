package com.eox.externalhdo.elementfleet.pages;

import java.util.Optional;

import org.openqa.selenium.WebDriver;

import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.HDOUtils;

public class Producerquotepublishpage {

	public static WebDriver driver;

	public Producerquotepublishpage(WebDriver driver) {
		Producerquotepublishpage.driver = driver;
		// TODO Auto-generated constructor stub
	}
		public void publishquoteaction() {
			CommonFunctionUtils.waitForSpinnerGoesOff();
			HDOUtils.openTiles("Insurance", "Quotes");
			CommonFunctionUtils.waitForSpinnerGoesOff();
			CommonFunctionUtils.verifyListViewRecordAndAction( driver, "Company Name", "ATZZ Test Client",Optional.of("Review Quote"));
			CommonFunctionUtils.activeButtonClick("Publish");
			CommonFunctionUtils.activeButtonClick("OK");
			
			
			
			
	}

}
