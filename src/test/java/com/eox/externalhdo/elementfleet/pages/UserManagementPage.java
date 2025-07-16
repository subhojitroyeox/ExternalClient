package com.eox.externalhdo.elementfleet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eox.utils.CommonFunctionUtils;

import java.util.HashMap;

public class UserManagementPage {

    public static WebDriver driver;

    public UserManagementPage(WebDriver driver) {
        UserManagementPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@page-id='6e358417-2b71-4f4f-8640-ded07d4a1267']")
    WebElement tileclick;

    public String umPage(HashMap<String, String> input) throws InterruptedException {
        CommonFunctionUtils.waitForSpinnerGoesOff();
        driver.findElement(By.xpath("//i[@class='fa fa-refresh']//parent::button[@class='btn btn-primary']")).click();
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
