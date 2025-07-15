package com.eox.externalhdo.elementfleet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eox.utils.CommonFunctionUtils;

public class UnitsEquipmentDataGridPage {
	public static WebDriver driver;

	public UnitsEquipmentDataGridPage(WebDriver driver) {
		UnitsEquipmentDataGridPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page factory
	@FindBy(xpath = "//input[contains(@id,'contractorUnitNumber')]")
	WebElement unitno;
	@FindBy(xpath = "//input[contains(@id,'UnitNumber')]")
	WebElement eqpno;
	@FindBy(xpath = "//input[contains(@id,'eqUnitNumber')]")
	WebElement noneqpno;

	public void elementLeasedUnits() {
		try {
			CommonFunctionUtils.radioButtonSelect("no", "Do you want to add more than 5 Element Leased Units?");
			if (unitno.isDisplayed()) {
				CommonFunctionUtils.addTextToTheInputField("Unit Number", "Unit-123");
				CommonFunctionUtils.addTextToTheInputField("Year", "2025");
				CommonFunctionUtils.addTextToTheInputField("Make", "Ford");
				CommonFunctionUtils.addTextToTheInputField("Model", "Transit 250");
				CommonFunctionUtils.addTextToTheInputField("VIN #", "1FTBR1C8XRKA12345");
				CommonFunctionUtils.selectItemFromDropdown("Gross Vehicle Weight (in lbs)", "14,001 – 16,000 lbs");
				CommonFunctionUtils.selectItemFromDropdown("Vehicle Type", "Heavy Trucks");
				CommonFunctionUtils.addTextToTheInputField("License Plate Number", "TXL-8923");
				CommonFunctionUtils.selectItemFromDropdown("State of License Registration", "AL");
				CommonFunctionUtils.selectItemFromDropdown("Deductible (in USD)", "1000");
				CommonFunctionUtils.radioButtonSelect("no", "Do you intend to use this unit for less than 30 days?");
				CommonFunctionUtils.radioButtonSelect("no", "Is this a Pool Vehicle?");
				CommonFunctionUtils.addTextToTheInputField("Address", "1234 Elm Street");
				CommonFunctionUtils.addTextToTheInputField("City", "Dallas city");
				CommonFunctionUtils.selectItemFromDropdown("State", "AZ");
				CommonFunctionUtils.addTextToTheInputField("Zip Code", "75201");
				CommonFunctionUtils.addTextToTheInputField("Cap Cost (Original cost + Upfit value)(in USD)", "43500");
				CommonFunctionUtils.addTextToTheInputField("Lease Start Date", "07/13/2025");
				CommonFunctionUtils.addTextToTheInputField("Lease Term (in Months)", "25");
				CommonFunctionUtils.activeButtonClick("Next");
			}
		} catch (Exception e) {
			System.out.println("Element is not clickable");
			CommonFunctionUtils.activeButtonClick("Next");
		}
	}

	public void elementLeasedEquipment() {
		try {
			CommonFunctionUtils.radioButtonSelect("no", "Do you want to add more than 5 Element Leased Equipment?");
			CommonFunctionUtils.radioButtonSelect("no", "Do you want to add more than 5 Element Leased Equipment?");
			if (eqpno.isDisplayed()) {
				CommonFunctionUtils.addTextToTheInputField("Equipment Number", "Test-123");
				CommonFunctionUtils.addTextToTheInputField("Year", "2025");
				CommonFunctionUtils.addTextToTheInputField("Make", "Caterpillar");
				CommonFunctionUtils.addTextToTheInputField("Model", "320 GC Hydraulic Excavator");
				CommonFunctionUtils.addTextToTheInputField("Serial Number", "CAT0320GCLX123456");
				CommonFunctionUtils.selectItemFromDropdown("Vehicle Type", "Forklifts");
				CommonFunctionUtils.selectItemFromDropdown("Deductible (in USD)", "1000");
				CommonFunctionUtils.selectItemFromDropdown("Category", "Lifts");
				CommonFunctionUtils.addTextToTheInputField("Address", "1234 Elm Street");
				CommonFunctionUtils.addTextToTheInputField("City", "Dallas city");
				CommonFunctionUtils.selectItemFromDropdown("State", "AZ");
				CommonFunctionUtils.addTextToTheInputField("Zip Code", "75201");
				CommonFunctionUtils.addTextToTheInputField("Equipment Value", "4000");
				CommonFunctionUtils.addTextToTheInputField("Lease Start Date", "07/13/2022");
				CommonFunctionUtils.addTextToTheInputField("Lease Term", "25");
				CommonFunctionUtils.activeButtonClick("Next");
			}
		} catch (Exception e) {
			CommonFunctionUtils.activeButtonClick("Next");
		}

	}

	public void nonElementLeasedUnits() {
//		
//		CommonFunctionUtils.radioButtonSelect("yes", "Do you want to create a list of lessors?");
//		CommonFunctionUtils.addTextToTheInputField("Name", "Lessor1");
//		CommonFunctionUtils.addTextToTheInputField("Address", "1234 Elm Street");
//		CommonFunctionUtils.addTextToTheInputField("City", "Dallas city");
//		CommonFunctionUtils.selectItemFromDropdown("State", "AZ");
//		CommonFunctionUtils.addTextToTheInputField("Zip Code", "75201");
//		CommonFunctionUtils.radioButtonSelect("yes", "Do you want to create a list of loss payees?");
//		CommonFunctionUtils.addTextToTheInputField("Name", "LoasssPayee1");
//		CommonFunctionUtils.addTextToTheInputField("Address", "1234 Elm Street");
//		CommonFunctionUtils.addTextToTheInputField("City", "Dallas city");
//		CommonFunctionUtils.selectItemFromDropdown("State", "AZ");
//		CommonFunctionUtils.addTextToTheInputField("Zip Code", "75201");

		// CommonFunctionUtils.radioButtonSelect("yes", "Do you want to add more than 5
		// Non-Element leased Units?");
		CommonFunctionUtils.radioButtonSelect("yes", "Do you want to add more than 5 Non-Element leased Units?");
		CommonFunctionUtils.activeButtonClick("Next");
//		CommonFunctionUtils.addTextToTheInputField("Unit Number", "Unit-123");
//		CommonFunctionUtils.addTextToTheInputField("Year", "2025");
//		CommonFunctionUtils.addTextToTheInputField("Make", "Ford");
//		CommonFunctionUtils.addTextToTheInputField("Model", "Transit 250");
//		CommonFunctionUtils.addTextToTheInputField("VIN #", "1FTBR1C8XRKA12345");
//		CommonFunctionUtils.selectItemFromDropdown("Gross Vehicle Weight (in lbs)", "14,001 – 16,000 lbs");
//		CommonFunctionUtils.selectItemFromDropdown("Vehicle Type", "Heavy Trucks");
//		CommonFunctionUtils.addTextToTheInputField("License Plate Number", "TXL-8923");
//		CommonFunctionUtils.selectItemFromDropdown("State of License Registration", "AL");
//		CommonFunctionUtils.selectItemFromDropdown("Deductible (in USD)", "1000");
//		CommonFunctionUtils.radioButtonSelect("No", "Do you intend to use this unit for less than 30 days?");
//		CommonFunctionUtils.addTextToTheInputField("Address", "1234 Elm Street");
//		CommonFunctionUtils.addTextToTheInputField("City", "Dallas city");
//		CommonFunctionUtils.selectItemFromDropdown("State", "AZ");
//		CommonFunctionUtils.addTextToTheInputField("Zip Code", "75201");
//		CommonFunctionUtils.addTextToTheInputField("ACV (Actual Cost Value) (in USD)", "4000");
//		CommonFunctionUtils.radioButtonSelect("no", "Is there an Additional Upfitting component?");
//		CommonFunctionUtils.checkBoxClick("Loss Payee");
//		CommonFunctionUtils.checkBoxClick("Lessor");

	}

	public void nonElementLeasedEquipments() {
		try {
			CommonFunctionUtils.radioButtonSelect("no", "Do you want to add more than 5 Non-Element leased Equipment?");
			//CommonFunctionUtils.radioButtonSelect("no", "Do you want to add more than 5 Non-Element leased Equipment?");
			if (noneqpno.isDisplayed()) {
				CommonFunctionUtils.addTextToTheInputField("Equipment Number", "Test-123");
				CommonFunctionUtils.addTextToTheInputField("Year", "2025");
				CommonFunctionUtils.addTextToTheInputField("Make", "Caterpillar ");
				CommonFunctionUtils.addTextToTheInputField("Model", "320 GC Hydraulic Excavator");
				CommonFunctionUtils.addTextToTheInputField("Serial Number", "CAT0320GCLX123456");
				CommonFunctionUtils.selectItemFromDropdown("Vehicle Type", "Forklifts");
				CommonFunctionUtils.selectItemFromDropdown("Deductible (in USD)", "1000");
				CommonFunctionUtils.selectItemFromDropdown("Category", "Lifts");
				CommonFunctionUtils.radioButtonSelect("no", "Is this a Pool Vehicle?");
				CommonFunctionUtils.addTextToTheInputField("Address", "1234 Elm Street");
				CommonFunctionUtils.addTextToTheInputField("City", "Dallas city");
				CommonFunctionUtils.selectItemFromDropdown("State", "AZ");
				CommonFunctionUtils.addTextToTheInputField("Zip Code", "75201");
				CommonFunctionUtils.addTextToTheInputField("Equipment Value", "4000");
				CommonFunctionUtils.activeButtonClick("Next");
				CommonFunctionUtils.activeButtonClick("Next");
			}
		} catch (Exception e) {
			CommonFunctionUtils.activeButtonClick("Next");
			CommonFunctionUtils.activeButtonClick("Next");
		}

	}
}
