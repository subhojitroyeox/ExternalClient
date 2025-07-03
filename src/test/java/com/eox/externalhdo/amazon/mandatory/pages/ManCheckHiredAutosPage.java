package com.eox.externalhdo.amazon.mandatory.pages;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.eox.utils.CommonFunctionUtils;

public class ManCheckHiredAutosPage {
	public static WebDriver driver;

	public ManCheckHiredAutosPage(WebDriver driver) {
		ManCheckHiredAutosPage.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void hiredAutosFormsubmission() {
		CommonFunctionUtils.activeButtonClick("Next");
		CommonFunctionUtils.activeButtonClick("Submit Form");

	}
	public void drawSignature() {
        WebElement canvas = driver.findElement(By.xpath("//canvas[@class='signature-pad-canvas']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", canvas);
        int canvasWidth = canvas.getSize().getWidth();
        int canvasHeight = canvas.getSize().getHeight();

        int baseX = canvasWidth / 8;
        int baseY = canvasHeight / 3; // Start higher up

        // Draw 'T'
        Actions tAction = new Actions(driver);
        tAction.moveToElement(canvas, baseX, baseY)
              .clickAndHold()
              .moveByOffset(50, 0) // top bar
              .moveByOffset(-25, 0)
              .moveByOffset(0, 40) // vertical line
              .release()
              .pause(Duration.ofMillis(120))
              .perform();

        // Draw 'e'
        Actions eAction = new Actions(driver);
        eAction.moveToElement(canvas, baseX + 60, baseY + 20)
              .clickAndHold()
              .moveByOffset(20, 0)
              .moveByOffset(0, 15)
              .moveByOffset(-20, 0)
              .moveByOffset(0, -15)
              .release()
              .pause(Duration.ofMillis(120))
              .perform();

        // Draw 'j'
        Actions jAction = new Actions(driver);
        jAction.moveToElement(canvas, baseX + 95, baseY + 5)
              .clickAndHold()
              .moveByOffset(0, 40)
              .moveByOffset(10, 10)
              .moveByOffset(10, -10)
              .release()
              .pause(Duration.ofMillis(120))
              .perform();

        // Draw 'a'
        Actions aAction = new Actions(driver);
        aAction.moveToElement(canvas, baseX + 120, baseY + 20)
              .clickAndHold()
              .moveByOffset(20, 0)
              .moveByOffset(0, 15)
              .moveByOffset(-20, 0)
              .moveByOffset(0, -15)
              .release()
              .perform();

        System.out.println("Signature 'Teja' drawing attempt completed.");
    }

}
