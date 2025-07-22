package com.eox.externalhdo.elementfleet.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.HDOUtils;

public class UserManagementEditPage 
{
    public static WebDriver driver;
    public UserManagementEditPage(WebDriver driver) 
    {
        UserManagementPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void umPage(String emailId) throws InterruptedException 
    {
        CommonFunctionUtils.waitForSpinnerGoesOff();
        driver.findElement(By.xpath("//i[@class='fa fa-refresh']//parent::button[@class='btn btn-primary']")).click();
        HDOUtils.openTiles("Element Fleet UM","Launch" );
            // Enter email in the filter box
            WebElement emailFilter = driver.findElement(By.xpath("//input[@aria-label='email Filter']"));
            emailFilter.clear();
            emailFilter.sendKeys(emailId);
            CommonFunctionUtils.waitForSpinnerGoesOff();

            // Click the Edit button for the matching email record
            String xpath = "//tr[contains(@class,'k-table-row') and .//td[2][normalize-space(text())='" + emailId + "']]//abbr[@title='Edit']/button";
            WebElement editBtn = driver.findElement(By.xpath(xpath));
            editBtn.click();
        
        
    }

}
