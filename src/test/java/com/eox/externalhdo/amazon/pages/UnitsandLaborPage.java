package com.eox.externalhdo.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eox.utils.CommonFunctionUtils;

public class UnitsandLaborPage {
	public static WebDriver driver;

	public UnitsandLaborPage(WebDriver driver) {
		UnitsandLaborPage.driver = driver;
	}
	public void unitsFileUpload()
	{
		CommonFunctionUtils.elementClick(driver.findElement(By.xpath("//i[@ref='removeLink']")));
		CommonFunctionUtils.excelUpload("Excel Upload", "DSP_risk_management_units.xlsx");
		CommonFunctionUtils
				.waitForClickableElement(driver.findElement(By.xpath("//button[contains(text(),'Upload Excel')]")));
		CommonFunctionUtils.waitForVisibility(driver.findElement(By.xpath("//i[@ref='removeLink']")));
		CommonFunctionUtils.activeButtonClick("Upload Excel");
		CommonFunctionUtils.waitForClickableElement(driver.findElement(By.xpath("//button[contains(text(),'OK')]")));
		CommonFunctionUtils.activeButtonClick("OK");
		CommonFunctionUtils.activeButtonClick("Next");
	}
	public void laborFileUpload()
	{
		CommonFunctionUtils.elementClick(driver.findElement(By.xpath("//i[@ref='removeLink']")));
		CommonFunctionUtils.excelUpload("Excel Upload", "DSP_Risk_Management_Labor.xlsx");
		CommonFunctionUtils
				.waitForClickableElement(driver.findElement(By.xpath("//button[contains(text(),'Upload Excel')]")));
		CommonFunctionUtils.waitForVisibility(driver.findElement(By.xpath("//i[@ref='removeLink']")));
		CommonFunctionUtils.activeButtonClick("Upload Excel");
		CommonFunctionUtils.waitForClickableElement(driver.findElement(By.xpath("//button[contains(text(),'OK')]")));
		CommonFunctionUtils.activeButtonClick("OK");
		CommonFunctionUtils.activeButtonClick("Next");
	}

}
