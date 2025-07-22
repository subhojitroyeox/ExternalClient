package com.eox.externalhdo.elementfleet.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.HDOUtils;

public class SendApplicationPage {

	public static WebDriver driver;

	public SendApplicationPage(WebDriver driver) {
		SendApplicationPage.driver = driver;
	}

	WebDriverWait wait;

	public void referralTab() {
		CommonFunctionUtils.waitForSpinnerGoesOff();
		HDOUtils.openTiles("Insurance", "Quotes");
		CommonFunctionUtils.verifyListViewRecordAndAction(driver, "Company Name", "Main Test Company",
				Optional.of("Edit Application"));
		CommonFunctionUtils.waitForSpinnerGoesOff();
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.waitForVisibility(driver.findElement(By.xpath("//button[@title='Already Signed']")));
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.addTextToTheInputField("Percentage of Ownership", "100");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Next");
	}

	public void expandReferralConditionsIfCollapsed() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement header = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@ref='header' and contains(.,'Referral conditions')]")));
		if ("false".equals(header.getAttribute("aria-expanded"))) {
			header.click();
			// Wait for the referral conditions to be visible after expanding
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.cssSelector(".formio-component-htmlelement ul li p[style='color: red;']")));
		}
	}

	public List<String> getActualReferralConditions() {
		expandReferralConditionsIfCollapsed();
		List<String> actual = new ArrayList<>();
		// Find all referral condition components by their class
		List<WebElement> referralElements = driver
				.findElements(By.cssSelector(".formio-component-htmlelement ul li p[style='color: red;']"));
		for (WebElement el : referralElements) {
			actual.add(el.getText().trim());
		}
		return actual;
	}
	public void referralCheck() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("There is wear and tear caused on the vehicle.");
		expected.add("There is damage caused by freezing or extreme weather conditions.");
		expected.add("There is mechanical or electrical breakdowns of the vehicle.");
		expected.add("There is blowouts, punctures, or other road damage caused to tires.");
		expected.add(
				"There is damage caused due to gradual deterioration or the effects of improper or lack of maintenance.");
		expected.add("There has been loss due to conversion, embezzlement, or secretion of the vehicle.");
		expected.add("There has been loss due to mysterious disappearance or damage caused by a criminal act.");
		expected.add("There has been loss of value at repossession.");
		expected.add("There has been manufacturer defects.");
		expected.add("There are non-licensed drivers who are allowed to operate the vehicles.");
		List<String> actual = getActualReferralConditions();
		// Assert both lists are equal
		org.testng.Assert.assertEquals(actual, expected, "Referral conditions do not match!");

	}

}