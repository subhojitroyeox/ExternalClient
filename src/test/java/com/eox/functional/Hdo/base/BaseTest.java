package com.eox.functional.Hdo.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.eox.functional.Hdo.MyCompanyDetails.pages.LaunchMyCompanyPage;
import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.WebDriverUtils;

public class BaseTest {
	public static WebDriver driver;
	public CommonFunctionUtils baseUtils;
	public LaunchMyCompanyPage myCompanyPage;
	@BeforeSuite
	public void initialization() {
		driver = WebDriverUtils.getDriver();
		driver.get("https://dsprmstag.hubdriveonline.com/");
		baseUtils = new CommonFunctionUtils(driver,20);
		myCompanyPage = new LaunchMyCompanyPage(driver);
		
	}
	
	@BeforeClass
	public void launchTheApplication() throws InterruptedException {		
		CommonFunctionUtils.enterText(driver.findElement(By.xpath("//input[@autocomplete]")),"jbutterhoff14@gmail.com");
		CommonFunctionUtils.elementClick(driver.findElement(By.xpath("//input[@type='submit']")));
		CommonFunctionUtils.enterText(driver.findElement(By.xpath("//input[@type='password']")),"4Mx5GVxw");
		CommonFunctionUtils.elementClick(driver.findElement(By.xpath("//input[@type='submit']")));
		CommonFunctionUtils.waitForSpinnerGoesOff();
		CommonFunctionUtils.waitForVisibility(driver.findElement(By.xpath("//h5[text()='My Company Details']")));
		CommonFunctionUtils.elementClick(driver.findElement(By.xpath("//div[@class='fas fa-arrow-alt-right']/parent::a[@title='My Company Details']")));
		CommonFunctionUtils.waitForSpinnerGoesOff();
	}
	
	@AfterSuite
	public void tearDown() {
		WebDriverUtils.quitDriver();
	}

}
