package com.eox.externalhdo.elementfleet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eox.externalhdo.elementfleet.hdolutils.ElementUtils;
import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.SupportUtils;

public class LeasedEquipment {
	public static WebDriver driver;
	public LeasedEquipment(WebDriver driver) {
		LeasedEquipment.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//page objects
	@FindBy(xpath=" //input[contains(@id,'-UnitNumber')]")
	WebElement eqpno;
	@FindBy(xpath=" //input[contains(@id,'-eqyear')]")
	WebElement eqpyear;
	@FindBy(xpath=" //input[contains(@id,'-eqmake')]")
	WebElement eqpmake;
	@FindBy(xpath=" //input[contains(@id,'-eqmodel')]")
	WebElement eqpmodel;
	@FindBy(xpath=" //input[contains(@id,'-eqserialNumber')]")
	WebElement eqpserialno;
	@FindBy(xpath="//div[@id='eu382o8']//div[@class='form-control ui fluid selection dropdown']")
	WebElement eqpvehicletype;
	
	
	public void leasedEquipmentform() throws InterruptedException
	{
		CommonFunctionUtils.enterText(eqpno, SupportUtils.getProperty("eqpno"));
		CommonFunctionUtils.enterText(eqpyear, SupportUtils.getProperty("eqpyear"));
		CommonFunctionUtils.enterText(eqpno, SupportUtils.getProperty("eqpno"));
		CommonFunctionUtils.enterText(eqpmake, SupportUtils.getProperty("eqpmake"));
		CommonFunctionUtils.enterText(eqpmodel, SupportUtils.getProperty("eqpmodel"));
		CommonFunctionUtils.enterText(eqpserialno, SupportUtils.getProperty("eqpserial"));
		CommonFunctionUtils.elementClick(eqpvehicletype);
		Thread.sleep(1000);
		//ElementUtils.dropdownvalues("Forklifts");
	}
}
