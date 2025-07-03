package com.eox.externalhdo.amazon.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.eox.utils.CommonFunctionUtils;

public class NonownedPage {

	public static WebDriver driver;

	public NonownedPage(WebDriver driver) {
		NonownedPage.driver = driver;
	}

	public void nonownedform(HashMap<String, String> input) {
		CommonFunctionUtils.radioButtonSelect("yes",
				"Do any of your employees use their own vehicle to deliver parcels or packages?");
		CommonFunctionUtils.radioButtonSelect("yes",
				"Do you require proof the employee carries personal auto coverage?");
		CommonFunctionUtils.addTextToTheInputField("If yes, how many employees do this on a regular basis?",
				input.get("how many"));
		CommonFunctionUtils.radioButtonSelect("yes",
				"Do you rent or lease vehicles for your use on a short-term (less than 6 months) basis?");
		CommonFunctionUtils.addTextToTheInputField("What limit of insurance do you require the employee carry?",
				input.get("limit of insurance"));
		CommonFunctionUtils.addTextToTheInputField("What is your estimated annual cost of hire?",
				input.get("annual cost"));
		CommonFunctionUtils.radioButtonSelect("monthly", "How often do you rent or lease vehicles?");

	}

}
