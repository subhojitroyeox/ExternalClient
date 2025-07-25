package com.eox.externalhdo.elementfleet.hdolutils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.SupportUtils;
	
public class ExternalUtils {
	public static WebDriver driver;

	public ExternalUtils(WebDriver driver) {
		ExternalUtils.driver = driver;
		PageFactory.initElements(driver, this);

	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

	//static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
	// 1. esign pdf's

	String firstTab = null;
	String secondTab = null;
	int count = 0;
	WebElement hyperlink;
	WebElement nextButton;
	public WebElement element;
	public WebElement dropdownClick;
	public List<WebElement> dropdownValues;

	public void esignPdf(String pdfName, String title) {
		WebElement esignclick = driver.findElement(By.xpath(
				"//*[contains(text(),'" + pdfName + "')]/following-sibling::span//button[@title='" + title + "']"));
		esignclick.click();
		// Get all window handles
		Set<String> allTabs = driver.getWindowHandles();
		Iterator<String> iterator = allTabs.iterator();
		// Use hasNext() to safely iterate through handles
		if (iterator.hasNext()) {
			firstTab = iterator.next(); // first tab handle
		}

		if (iterator.hasNext()) {
			secondTab = iterator.next(); // second tab handle
		}
		// Switch to the second tab
		if (secondTab != null) {
			driver.switchTo().window(secondTab);
		}
		esignNumber();
	}

	public void esignNumber() {
		System.out.println("Title of second tab: " + driver.getTitle());
		hyperlink = driver.findElement(By.xpath("//*[contains(text(),'sign in')]"));
		String text = hyperlink.getText();
		// System.out.println(text);
		String[] number = text.split(" ");// sign-0 in 1 field//1 //o in //1 1
		count = Integer.parseInt(number[2]);// 1
		System.out.println(count);
		CommonFunctionUtils.waitForClickableElement(hyperlink);
		hyperlink.click();
		doEsign();
	}

	// Java
	public void doEsign() {
		for (int i = 0; i < count; i++) {
			try {
				esign();
			} catch (Exception e) {
				System.err.println("Exception during e-sign #" + (i + 1) + ": " + e.getMessage());
			}
		}
	}

	public void esign() throws InterruptedException {
		try {
			nextButton = driver.findElement(By.xpath(
					"//*[contains(text(),'Click to Sign')]/..//div[contains(@data-cy,'signingSignatureField')]"));
		} catch (Exception e) {
			System.out.println("Exception occuredF");
			hyperlink.click();
			nextButton = driver.findElement(By.xpath(
					"//*[contains(text(),'Click to Sign')]/..//div[contains(@data-cy,'signingSignatureField')]"));
		}

		// Scroll into view and wait for overlays to disappear
		((org.openqa.selenium.JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView({block: 'center'});", nextButton);
		CommonFunctionUtils.waitForClickableElement(nextButton);

		// Optionally, wait for overlays/loaders to disappear here

		try {
			nextButton.click();
		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			// Fallback: click with JavaScript
			((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButton);
		}

		CommonFunctionUtils.waitForClickableElement(
				driver.findElement(By.xpath("//button[@data-test='onNextFieldDialogButton']/child::span")));
		driver.findElement(By.xpath("//button[@data-test='onNextFieldDialogButton']/child::span")).click();

		CommonFunctionUtils.waitForClickableElement(
				driver.findElement(By.xpath("//button[@data-test='submitDocumentBtn']/child::span")));
		driver.findElement(By.xpath("//button[@data-test='submitDocumentBtn']/child::span")).click();

		CommonFunctionUtils.waitForClickableElement(
				driver.findElement(By.xpath("//button[@data-test='consentToBusinessSubmitBtn']/child::span")));
		driver.findElement(By.xpath("//button[@data-test='consentToBusinessSubmitBtn']/child::span")).click();
		Thread.sleep(2000);
		driver.close();
		// Switch back to the first tab
		if (firstTab != null) {
			driver.switchTo().window(firstTab);
		} else {
			System.out.println("First tab is null, cannot switch back.");
		}

	}

	// Draw Signature
	public void drawSignature() {
		WebElement canvas = driver.findElement(By.xpath("//canvas[@class='signature-pad-canvas']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", canvas);
		int canvasWidth = canvas.getSize().getWidth();
		int canvasHeight = canvas.getSize().getHeight();

		// Start near the left-middle, with enough margin
		int startX = (int) (canvasWidth * 0.15);
		int startY = (int) (canvasHeight * 0.5);

		Actions action = new Actions(driver);
		action.moveToElement(canvas, startX, startY).clickAndHold();

		// Draw a smooth, wavy line to simulate a signature
		int[][] deltas = { { 30, -10 }, { 30, 15 }, { 30, -10 }, { 30, 15 }, // wave
				{ 20, 0 }, { 10, -10 }, { 10, 10 }, { 20, 0 }, // tail
		};

		for (int[] delta : deltas) {
			action.moveByOffset(delta[0], delta[1]);
		}

		action.release().perform();
		System.out.println("Optimized signature drawing completed.");
	}

	public void addInputToDatagrid(String nameValue, String inputValue) {
		element = driver.findElement(By.xpath("//*[contains(@name,'" + nameValue + "')]"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(inputValue);
	}

	public void elementClick(String namevalue) {
		driver.findElement(By.xpath("//*[contains(@name,'" + namevalue + "')]/..")).click();

	}

	public void selectChoicesDropdownValue(String namevalue, String valueToSelect) throws InterruptedException {
		// 1. Click the dropdown to open options
		element = driver.findElement(By.xpath("//*[contains(@name,'" + namevalue + "')]/.."));
		element.click();
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.xpath("//*[contains(@name,'" + namevalue
				+ "')]/parent::div/following-sibling::div/div//div[contains(@class,'choices__')]"));
		options.stream().filter(option -> option.getText().equalsIgnoreCase(valueToSelect)).findFirst()
				.ifPresent(WebElement::click);
	}
	public String PopupValidation() {
		element = driver.findElement(
				By.xpath("//div[contains(@class,'swal2-icon-success')]/div[@class='swal2-html-container']"));
		wait.until(ExpectedConditions.visibilityOf(element));
		String popupMessage = element.getText();
		return popupMessage;
	}
	}
