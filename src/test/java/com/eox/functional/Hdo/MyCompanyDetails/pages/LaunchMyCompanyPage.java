package com.eox.functional.Hdo.MyCompanyDetails.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eox.utils.CommonFunctionUtils;

public class LaunchMyCompanyPage {

	public static WebDriver driver;
	public LaunchMyCompanyPage(WebDriver driver) {
		LaunchMyCompanyPage.driver = driver;
	}
	
	// Count and validate existing tabs content
	@FindBy(xpath = "//li[contains(@class,'page-item')]//button")
	static
	WebElement allTabsButtons;
	
	public static void fetchAllTabsButton() throws InterruptedException {
		CommonFunctionUtils.waitForClickableElement(driver.findElement(By.xpath("//li[contains(@class,'page-item')]//button")));
		for (WebElement ele:driver.findElements(By.xpath("//li[contains(@class,'page-item')]//button"))) {
    		System.out.println(ele.getText());
    	}

		CommonFunctionUtils.activeButtonClick("Next");
		//CommonFunctionUtils.checkBoxUnchecked("I have read the HDOL Privacy Policy. I agree with the terms and conditions.");
		//CommonFunctionUtils.checkBoxClick("I have read the HDOL Privacy Policy.");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.selectItemFromDropdown("Please select the Company Type", "Partnership");
		CommonFunctionUtils.addTextToTheInputField("Amazon DSP Number", "ARMA");
		
	}
	
	

}
