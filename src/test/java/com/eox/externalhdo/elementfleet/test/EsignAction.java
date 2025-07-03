package com.eox.externalhdo.elementfleet.test;

import com.eox.externalhdo.elementfleet.base.Basetest;
import com.eox.externalhdo.elementfleet.pages.EsignPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class EsignAction extends Basetest {

    @Test
    public void esignPage() throws InterruptedException {
        esign.loginSuccessfully2();
        // eSign Privacy Policy
        esign.performEsignAndSign(esign.privacyPolicyEsignButton);

      //  driver.findElement(By.xpath("//button[@data-test='submitDocumentBtn']/child::span")).click();
        // Switch back to the first tab (main window)
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

//        // eSign Terms and Conditions
    esign.performEsignAndSign(esign.termsConditionsEsignButton);
//
//        // eSign EULA
      driver.switchTo().window(tabs.get(0));
      esign.performEsignAndSign(esign.eulaEsignButton);
    }
}