// src/test/java/com/eox/externalhdo/elementfleet/pages/EsignPage.java
package com.eox.externalhdo.elementfleet.pages;
import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.SupportUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class EsignPage {
    public static WebDriver driver;
    public EsignPage(WebDriver driver) {
        EsignPage.driver = driver;
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
    // Checkboxes
    @FindBy(id = "e2wt6p-enucbcg--iHaveReadTheHdolPrivacyPolicyIAgreeWithTheTermsAndConditions")
    public WebElement privacyPolicyCheckbox;
    @FindBy(id = "e2wt6p-egbv7zo--iHaveReadAndAgreeToTheHdolTermsAndConditions")
    public WebElement termsConditionsCheckbox;
    @FindBy(id = "e2wt6p-etilqjf--iAgreeToTheTermsOfTheEndUserLicenseAgreement")
    public WebElement eulaCheckbox;
    // E-Sign buttons
    @FindBy(xpath = "//button[@title='Click to sign the document'][@id='sign_btn_e8d8s9i']")
    public WebElement privacyPolicyEsignButton;
    @FindBy(xpath = "//span[contains(text(),'sign in') and contains(text(),'field')]")
    public WebElement esignHyperlink;
    @FindBy(id = "sign_btn_efd4dq8i")
    public WebElement termsConditionsEsignButton;
    @FindBy(id = "sign_btn_ewuz8r")
    public WebElement eulaEsignButton;
    @FindBy(css = ".documentsigner1-signFile")
    public List<WebElement> allEsignButtons;

    @FindBy(xpath="//button[@data-test='consentToBusinessSubmitBtn']/child::span")
    WebElement submitclick;

    @FindBy(xpath = "//button[@data-test='consentToBusinessSubmitBtn']/child::span")
    WebElement submitDocumentButton;

    public void loginSuccessfully2() {
        CommonFunctionUtils.enterText(usernamev, SupportUtils.getProperty("username"));
        CommonFunctionUtils.enterText(passwordv, SupportUtils.getProperty("password"));
        CommonFunctionUtils.elementClick(loginbutton);
        CommonFunctionUtils.waitForSpinnerGoesOff();
        CommonFunctionUtils.elementClick(manageapplication);
        CommonFunctionUtils.waitForSpinnerGoesOff();
        CommonFunctionUtils.waitForVisibility(nextbutton);
        CommonFunctionUtils.elementClick(nextbutton);
        CommonFunctionUtils.waitForVisibility(nextbutton);
        // Wait for the eSign buttons to be visible
    }

    public void performEsignAndSign(WebElement esignButton) throws InterruptedException {
        CommonFunctionUtils.elementClick(esignButton);
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1));
            waitForElementVisible(esignHyperlink, 20);
            CommonFunctionUtils.elementClick(esignHyperlink);
            String value = esignHyperlink.getText();
            String[] parts = value.split(" ");
            String number = "";
            for (String part : parts) {
                if (part.matches("\\d+")) {
                    number = part;
                    break;
                }
            }
            int signCount = Integer.parseInt(number);
            for (int i = 0; i < signCount; i++) {
                waitForEsignPageAndClickSign();
                waitForAndClickNextOnEsignDialog();
            }
        }
    }
    public void waitForEsignPageAndClickSign() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("img[src*='prod-is-ace-images']")
                ));

        WebElement clickToSignButton = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class,'fieldToFocus') and contains(.,'Click to Sign')]")
                ));

        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", clickToSignButton);

      //  Thread.sleep(500);

        try {
            clickToSignButton.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", clickToSignButton);
        }
    }
    public void waitForAndClickNextOnEsignDialog() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[data-test='onNextFieldDialogButton']"))
        );
        nextButton.click();
       wait.until(ExpectedConditions.elementToBeClickable(submitclick));
        submitclick.click();
        WebElement consentSubmit=wait.until(ExpectedConditions.elementToBeClickable(submitDocumentButton));
        consentSubmit.click();
        wait.until(ExpectedConditions.invisibilityOf(submitDocumentButton));
        driver.close();


    }

//    // Usage for each document:
//    public void agreePrivacyPolicyAndSign() throws InterruptedException {
//        performEsignAndSign(privacyPolicyEsignButton);
//    }
//
//    public void agreeTermsAndConditionsAndSign() throws InterruptedException {
//        performEsignAndSign(termsConditionsEsignButton);
//    }
//
//    public void agreeEulaAndSign() throws InterruptedException {
//        performEsignAndSign(eulaEsignButton);
//    }


    public void waitForElementVisible(WebElement element, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
