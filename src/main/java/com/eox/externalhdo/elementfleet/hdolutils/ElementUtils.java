package com.eox.externalhdo.elementfleet.hdolutils;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ElementUtils {
	public static void click(WebElement element) {
		element.click();
	}

	public static void sendKeys(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public static void waitForVisibility(WebDriver driver, WebElement element, int seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds))
				.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForClickable(WebDriver driver, WebElement element, int seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds))
				.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForInvisibility(WebDriver driver, By locator, int seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds))
				.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	public static void waitForListOfElements(WebDriver driver, By locator, int seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds))
				.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

}