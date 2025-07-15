package com.eox.externalhdo.elementfleet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eox.externalhdo.elementfleet.hdolutils.ExternalUtils;
import com.eox.utils.CommonFunctionUtils;

public class EditApplicationPage extends ExternalUtils {
	public static WebDriver driver;

	public EditApplicationPage(WebDriver driver) {
		super(driver);
		EditApplicationPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page object
	@FindBy(xpath = "//span[.='Edit Application']")
	WebElement editbutton;

	public void editApplication() {
		CommonFunctionUtils.waitForSpinnerGoesOff();
		driver.findElement(By.xpath("//i[@class='fa fa-refresh']//parent::button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//a[@page-id='2d52af74-d94d-4da8-8520-7ad5b8a47fac']")).click();
		editbutton.click();
	}

}
