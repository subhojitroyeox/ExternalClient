package com.eox.externalhdo.elementfleet.pages;

import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.eox.externalhdo.elementfleet.hdolutils.ExternalUtils;
import com.eox.utils.CommonFunctionUtils;

public class EditApplicationPage extends ExternalUtils {
	public static WebDriver driver;

	public EditApplicationPage(WebDriver driver) {
		super(driver);
		EditApplicationPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchAndEditApplicationForCompany(String companyName) {
		CommonFunctionUtils.waitForSpinnerGoesOff();
		driver.findElement(By.xpath("//i[@class='fa fa-refresh']//parent::button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//a[@page-id='2d52af74-d94d-4da8-8520-7ad5b8a47fac']")).click();
		// Enter company name in the search box
		WebElement searchBox = driver
				.findElement(By.xpath("//input[@placeholder='Search' and @aria-label='companyname Filter']"));
		searchBox.clear();
		searchBox.sendKeys(companyName);
		CommonFunctionUtils.waitForSpinnerGoesOff();

		// Click the Edit Application button for the company
		String xpath = "//tr[contains(@class,'k-table-row') and .//td[1][normalize-space(text())='" + companyName
				+ "']]//abbr[@title='Edit Application']/button";
		WebElement editBtn = driver.findElement(By.xpath(xpath));
		editBtn.click();
	}

	public void editAndSubmit() throws InterruptedException {
		CommonFunctionUtils.waitForSpinnerGoesOff();
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.waitForVisibility(driver.findElement(By.xpath("//button[@title='Already Signed']")));
		IntStream.range(0, 2).forEach(i -> CommonFunctionUtils.activeButtonClick("Next"));
		selectChoicesDropdownValue("data[inWhatRadiusDoTheMajorityOfYourVehiclesOperateInMiles]", "51-200");
		addInputToDatagrid("data[applicantInformationGrid][0][zipCode]", "12345");
		IntStream.range(0, 7).forEach(i -> CommonFunctionUtils.activeButtonClick("Next"));
		CommonFunctionUtils.activeButtonClick("Submit Form");
		String text = PopupValidation();
		System.out.println(text);
		CommonFunctionUtils.activeButtonClick("OK");
		Assert.assertEquals(text, "Application Submitted Successfully");
	}
}
