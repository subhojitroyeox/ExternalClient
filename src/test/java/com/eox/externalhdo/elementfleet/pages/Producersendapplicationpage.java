package com.eox.externalhdo.elementfleet.pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eox.externalhdo.elementfleet.hdolutils.ExternalUtils;
import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.HDOUtils;
import com.eox.utils.SupportUtils;

public class Producersendapplicationpage extends ExternalUtils {
	public static WebDriver driver;

	public Producersendapplicationpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		Producersendapplicationpage.driver = driver;
	}

	public void sendapplication() {
		CommonFunctionUtils.waitForSpinnerGoesOff();
		HDOUtils.openTiles("Insurance", "Quotes");
		CommonFunctionUtils.verifyListViewRecordAndAction(driver, "Company Name", "ATZZ Test Client",
				Optional.of("Edit Application"));
		CommonFunctionUtils.waitForSpinnerGoesOff();
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.waitForVisibility(driver.findElement(By.xpath("//button[@title='Already Signed']")));
		IntStream.range(0, 9).forEach(i -> CommonFunctionUtils.activeButtonClick("Next"));
		CommonFunctionUtils.activeButtonClick("Send Application");
		System.out.println("Wait for Quote generation");
		// waitForQuoteGenerationWithRetry();
		SupportUtils.waitFor(60000);
		System.out.println("ready to click ok");
		CommonFunctionUtils.popupAccept();
		CommonFunctionUtils.waitForVisibility(driver.findElement(By.xpath("//tr[@data-grid-row-index='0']//td")));
		CommonFunctionUtils.verifyListViewRecordAndAction(driver, "Company Name", null, null);
	}

	public void waitForQuoteGenerationWithRetry() {
		int maxRetries = 5;
		int retryIntervalMillis = 1500;

		for (int attempt = 1; attempt <= maxRetries; attempt++) {
			System.out.println("Attempt " + attempt + " to wait for quote generation invisibility...");
			try {
				CommonFunctionUtils.waitForSpinnerGoesOff();

				System.out.println("Quote generation message disappeared successfully.");
				return;
			} catch (NoSuchElementException e) {
				System.out.println(
						"Quote generation message not found in DOM (yet or not applicable). Proceeding with next check.");
				return;
			} catch (Exception e) {
				System.out.println("Failed to wait for invisibility on attempt " + attempt + ": " + e.getMessage());

				if (attempt < maxRetries) {
					System.out.println("Retrying in " + (retryIntervalMillis / 1000.0) + " seconds...");
					SupportUtils.waitFor(retryIntervalMillis);
				} else {
					System.err.println("Maximum retries reached. Quote generation message did not disappear.");
					throw new RuntimeException(
							"Quote generation message did not disappear after " + maxRetries + " attempts.", e);
				}
			}
		}
	}

}
