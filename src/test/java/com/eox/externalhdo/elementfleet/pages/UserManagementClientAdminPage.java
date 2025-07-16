package com.eox.externalhdo.elementfleet.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eox.utils.CommonFunctionUtils;

public class UserManagementClientAdminPage {
	  public static WebDriver driver;

	    public UserManagementClientAdminPage(WebDriver driver) {
	    	UserManagementClientAdminPage.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(xpath = "//a[@page-id='589466a0-6cb5-456e-9a7b-984ca23accfc']")
	    WebElement tileclick;

	    public String umPage(HashMap<String, String> input) throws InterruptedException {
	       // CommonFunctionUtils.waitForSpinnerGoesOff();
	       // driver.findElement(By.xpath("//i[@class='fa fa-refresh']//parent::button[@class='btn btn-primary']")).click();
	        tileclick.click();
	        driver.findElement(By.xpath("//*[@title='Add User']")).click();
	        CommonFunctionUtils.addTextToTheInputField("First Name", input.get("First Name"));
	        CommonFunctionUtils.addTextToTheInputField("Middle Name", input.get("Middle Name"));
	        CommonFunctionUtils.addTextToTheInputField("Last Name", input.get("Last Name"));
	        CommonFunctionUtils.selectItemFromDropdown("Role Type", input.get("Role Type"));
	        CommonFunctionUtils.addEmailToTheInputField("Email", input.get("Email"));
	        CommonFunctionUtils.selectItemFromDropdown("State", input.get("State"));
	        CommonFunctionUtils.activeButtonClick("Submit");
	      //  CommonFunctionUtils.activeButtonClick("OK");

	        WebElement popupMessage = driver.findElement(By.xpath("//tr[@class='text-success']/td[1]"));
	        CommonFunctionUtils.waitForVisibility(popupMessage);
	        String message = popupMessage.getText();
	        return message;
	    }

}
