package com.eox.functional.Hdo.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.eox.utils.WebDriverUtils;

public class PracClass {
	
	@Test
	public void myTest() throws InterruptedException {
		WebDriver driver = WebDriverUtils.getDriver();
		driver.get("https://hdoustest.eoxvantage.com/");
		Thread.sleep(3000);
	}

}
