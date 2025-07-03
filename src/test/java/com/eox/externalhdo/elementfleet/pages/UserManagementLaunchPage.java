package com.eox.externalhdo.elementfleet.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.HDOUtils;

public class UserManagementLaunchPage {

	public static WebDriver driver;

	public UserManagementLaunchPage(WebDriver driver) {
		UserManagementLaunchPage.driver = driver;
	}

	public void clickManageApplication() {

		CommonFunctionUtils.elementClick(
				driver.findElement(By.xpath("//i[@class='fa fa-refresh']//parent::button[@class='btn btn-primary']")));
		driver.findElement(By.xpath("//i[@class='fa fa-refresh']//parent::button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//a[@page-id='6e358417-2b71-4f4f-8640-ded07d4a1267']/..")).click();
		CommonFunctionUtils.clickOperationalButtons("create user");
		CommonFunctionUtils.addTextToTheInputField("First Name", "test fn");
		CommonFunctionUtils.addTextToTheInputField("Middle Name", "test mn");
		CommonFunctionUtils.addTextToTheInputField("Last Name", "test ln");
		CommonFunctionUtils.selectItemFromDropdown("Role Type", "Pro");
		CommonFunctionUtils.addEmailToTheInputField("Email", "test+69@hubinternational.com");
		CommonFunctionUtils.selectItemFromDropdown("State", "Ala");
		CommonFunctionUtils.activeButtonClick("Submit");
		CommonFunctionUtils.activeButtonClick("OK");
		HDOUtils.hdoClickActionsButtons("test+68@hubinternational.com", "Edit");

	}

}
