package com.eox.externalhdo.elementfleet.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eox.externalhdo.elementfleet.hdolutils.ExternalUtils;
import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.HDOUtils;

public class TileAccessValidationPage extends ExternalUtils {
	public static WebDriver driver;

	public TileAccessValidationPage(WebDriver driver) {
		super(driver);
		TileAccessValidationPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='dasboard-viewer-content']")
	WebElement element;

	public boolean tileaccesscheck() {
		CommonFunctionUtils.waitForSpinnerGoesOff();
		driver.findElement(By.xpath("//i[@class='fa fa-refresh']//parent::button[@class='btn btn-primary']")).click();
		CommonFunctionUtils.waitForVisibility(element);
		boolean result = HDOUtils.readTilesRolesBasis("Admin", "HDO\\ElementFleet\\Tileaccess.json");
		return result;
	}

}
