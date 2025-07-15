package com.eox.externalhdo.elementfleet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eox.utils.CommonFunctionUtils;

public class UserManagementPage {

	public static WebDriver driver;

	public UserManagementPage(WebDriver driver) {

		UserManagementPage.driver = driver;
	}

	public void dataGridtest() {
		CommonFunctionUtils.waitForSpinnerGoesOff();
		driver.findElement(By.xpath("//i[@class='fa fa-refresh']//parent::button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//a[@page-id='6e358417-2b71-4f4f-8640-ded07d4a1267']")).click();
		CommonFunctionUtils.activeButtonClick("Add User");
		driver.findElement(By.xpath("//button[normalize-space()='Add Another']")).click();

	}

}
