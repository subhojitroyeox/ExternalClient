package com.eox.externalhdo.elementfleet.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eox.externalhdo.elementfleet.hdolutils.ElementUtils;
import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.SupportUtils;

public class ApplicationAcknowledgementPage {

	public static WebDriver driver;

	public ApplicationAcknowledgementPage(WebDriver driver) {
		ApplicationAcknowledgementPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page objects
	@FindBy(xpath = "//input[@id='username']")
	WebElement usernamev;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordv;
	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginbutton;
	@FindBy(xpath = "//a[normalize-space()='Manage Application']")
	WebElement manageapplication;
	@FindBy(xpath = "//button[text()='Next']")
	WebElement nextbutton;
	@FindBy(xpath = "//button[@title='Already Signed'][normalize-space()='eSign Completed']")
	List<WebElement> esigncompleted;
	@FindBy(xpath = "//input[@id='e3r6khm-fein']")
	WebElement fein;
	@FindBy(xpath = "//input[contains(@id,'-contactFirstName')]")
	WebElement contactfirstname;
	@FindBy(xpath = "//input[contains(@id,'-contactLastName')]")
	WebElement contactlastname;
	@FindBy(xpath = "//div[@id='ecklymi']/div//div[contains(@class,'ui fluid selection dropdown')]")
	WebElement roletypeclick;
	@FindBy(xpath = "//div[contains(@id,'contactType-item-choice-')]")
	List<WebElement> dropvalues;
	@FindBy(xpath = " //input[contains(@id,'-emailAddress')]")
	WebElement emailid;

	public LeasedEquipment insuranceApplication() throws InterruptedException {
		driver.findElement(By.xpath("//i[@class='fa fa-refresh']//parent::button[@class='btn btn-primary']")).click();
		CommonFunctionUtils.elementClick(manageapplication);
		CommonFunctionUtils.waitForSpinnerGoesOff();
		Thread.sleep(2000);
		CommonFunctionUtils.waitForVisibility(nextbutton);
		CommonFunctionUtils.elementClick(nextbutton);
		CommonFunctionUtils.waitForVisibility(nextbutton);

//		CommonFunctionUtils.checkBoxClick("I have read the HDOL Privacy Policy");
//		CommonFunctionUtils.checkBoxClick("HDOL terms and conditions.");
//		CommonFunctionUtils.checkBoxClick("End User License Agreement");
//		
//		CommonFunctionUtils.elementClick(nextbutton);
//		
//		CommonFunctionUtils.elementClick(nextbutton);
//		CommonFunctionUtils.enterText(fein, SupportUtils.getProperty("fein"));
//		CommonFunctionUtils.enterText(contactfirstname, SupportUtils.getProperty("contactfirstname"));
//		CommonFunctionUtils.enterText(contactlastname, "contactlastname");
//		CommonFunctionUtils.elementClick(roletypeclick);
//		Thread.sleep(1000);
//		ElementUtils.waitForListOfElements(dropvalues);
//		ElementUtils.dropdownvalues("Safety Manager");
//		emailid.clear();
//		CommonFunctionUtils.enterText(emailid, SupportUtils.getProperty("primaryemailid"));
//		ElementUtils.radioButtonClick("e99kdal--no");
//		ElementUtils.radioButtonClick("euxbre7--no");
//		ElementUtils.radioButtonClick("es7usd8--no");
//		ElementUtils.radioButtonClick("ekx7dmu--no");
//		ElementUtils.radioButtonClick("ejd2p8w--no");
//		ElementUtils.radioButtonClick("e61xe9k--no");
//		ElementUtils.radioButtonClick("e0xj6v--no");
//		ElementUtils.radioButtonClick("ejtqevg--no");
//		ElementUtils.radioButtonClick("e08lys--no");
//		ElementUtils.radioButtonClick("erc332--no");
//		ElementUtils.radioButtonClick("es9e0c--no");
//		CommonFunctionUtils.elementClick(nextbutton);
//		CommonFunctionUtils.elementClick(nextbutton);
//		CommonFunctionUtils.elementClick(nextbutton);
//		ElementUtils.radioButtonClick("ea8ow3f--no");
//		ElementUtils.radioButtonClick("ea8ow3f--no");
		return new LeasedEquipment(driver);
//	}

	}
}