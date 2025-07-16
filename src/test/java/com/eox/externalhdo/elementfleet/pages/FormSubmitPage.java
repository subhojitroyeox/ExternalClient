package com.eox.externalhdo.elementfleet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eox.externalhdo.elementfleet.hdolutils.ExternalUtils;
import com.eox.utils.CommonFunctionUtils;

public class FormSubmitPage extends ExternalUtils {
	public static WebDriver driver;

	public FormSubmitPage(WebDriver driver) {
		super(driver);
		FormSubmitPage.driver = driver;
	}

	public void submitForm() {
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.addTextToTheInputField("Date", "07-15-2025");
		driver.findElement(By.xpath("//i[@class='fa fa-calendar']")).click();
		drawSignature();
		CommonFunctionUtils.waitForClickableElement(driver.findElement(By.xpath("//button[text()='Submit Form']")));
		try {
			CommonFunctionUtils.activeButtonClick("Submit Form");
			CommonFunctionUtils.activeButtonClick("Ok");
		} catch (Exception e) {
			System.out.println("Date exception occured");
			CommonFunctionUtils.activeButtonClick("Submit Form");
			CommonFunctionUtils.activeButtonClick("Ok");
		}

	}

}
