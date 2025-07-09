package com.eox.externalhdo.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.SupportUtils;

public class WelcomeandAcknowledgementPage {

	public static WebDriver driver;

	public WelcomeandAcknowledgementPage(WebDriver driver) {
		WelcomeandAcknowledgementPage.driver = driver;

	}

	public void MCDform() {
		driver.findElement(By.xpath("//i[@class='fa fa-refresh']//parent::button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//a[@page-id='78f4380e-44a0-470a-9042-3fc00efaba71']")).click();
		CommonFunctionUtils.waitForSpinnerGoesOff();
		CommonFunctionUtils.activeButtonClick("Next");
		try {
			CommonFunctionUtils.waitForSpinnerGoesOff();
		} catch (Exception e) {
			System.out.println("Exception occured");
		}
		CommonFunctionUtils.checkBoxClick("Privacy Policy.");
		CommonFunctionUtils.checkBoxClick("I have read and agree to the HDOL terms and conditions.");
		CommonFunctionUtils.checkBoxClick(" Netradyne device to push event video");
		CommonFunctionUtils.checkBoxClick("Telematics Use Agreement");
		CommonFunctionUtils.checkBoxClick("Authorization Letter.");
		CommonFunctionUtils.checkBoxClick("License Agreement.");
		CommonFunctionUtils.radioButtonSelect("no", "Do you want to share your Netradyne data with HUB?");
	}

}
