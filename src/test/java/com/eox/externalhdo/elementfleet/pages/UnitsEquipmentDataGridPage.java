package com.eox.externalhdo.elementfleet.pages;

import java.util.HashMap;

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
	@FindBy(xpath = "//input[contains(@id,'eqUnitNumber1')]")
	WebElement noneqpno;
	@FindBy(css = "i[ref='removeLink'].fa-remove")
	WebElement canceliconclick;
	@FindBy(xpath = "//button[normalize-space()='Upload Excel']")
	WebElement uploadclick;

	public void elementLeasedUnits(HashMap<String, String> input) {
		try {
			CommonFunctionUtils.radioButtonSelect(input.get("Do you want to add more than 5 Element Leased Units?"),
					"Do you want to add more than 5 Element Leased Units?");
			CommonFunctionUtils.radioButtonSelect(input.get("Do you want to add more than 5 Element Leased Units?"),
					"Do you want to add more than 5 Element Leased Units?");
			if (unitno.isDisplayed()) {
				CommonFunctionUtils.addTextToTheInputField("Unit Number", input.get("leased_unit_Unit Number"));
				CommonFunctionUtils.addTextToTheInputField("Year", input.get("leased_unit_Year"));
				CommonFunctionUtils.addTextToTheInputField("Make", input.get("leased_unit_Make"));
				CommonFunctionUtils.addTextToTheInputField("Model", input.get("leased_unit_Model"));
				CommonFunctionUtils.addTextToTheInputField("VIN #", input.get("leased_unit_VIN #"));
				CommonFunctionUtils.selectItemFromDropdown("Gross Vehicle Weight (in lbs)",
						input.get("leased_unit_Gross Vehicle Weight (in lbs)"));
				CommonFunctionUtils.selectItemFromDropdown("Vehicle Type", input.get("leased_unit_Vehicle Type"));
				CommonFunctionUtils.addTextToTheInputField("License Plate Number",
						input.get("leased_unit_License Plate Number"));
				CommonFunctionUtils.selectItemFromDropdown("State of License Registration",
						input.get("leased_unit_State of License Registration"));
				CommonFunctionUtils.selectItemFromDropdown("Deductible (in USD)",
						input.get("leased_unit_Deductible (in USD)"));
				CommonFunctionUtils.radioButtonSelect(
						input.get("leased_unit_Do you intend to use this unit for less than 30 days?"),
						"Do you intend to use this unit for less than 30 days?");
				CommonFunctionUtils.radioButtonSelect(input.get("leased_unit_Is this a Pool Vehicle?"),
						"Is this a Pool Vehicle?");
				CommonFunctionUtils.addTextToTheInputField("Address", input.get("leased_unit_Address"));
				CommonFunctionUtils.addTextToTheInputField("City", input.get("leased_unit_City"));
				CommonFunctionUtils.selectItemFromDropdown("State", input.get("leased_unit_State"));
				CommonFunctionUtils.addTextToTheInputField("Zip Code", input.get("leased_unit_Zip Code"));
				CommonFunctionUtils.addTextToTheInputField("Cap Cost (Original cost + Upfit value)(in USD)",
						input.get("leased_unit_Cap Cost (Original cost + Upfit value)(in USD)"));
				CommonFunctionUtils.addTextToTheInputField("Lease Start Date",
						input.get("leased_unit_Lease Start Date"));
				CommonFunctionUtils.addTextToTheInputField("Lease Term (in Months)",
						input.get("leased_unit_Lease Term (in Months)"));
				CommonFunctionUtils.activeButtonClick("Next");
			}
		} catch (Exception e) {
			System.out.println("Element is not clickable");
			CommonFunctionUtils.activeButtonClick("Next");
		}
	}

	public void elementLeasedEquipment(HashMap<String, String> input) {
		try {
			CommonFunctionUtils.radioButtonSelect(input.get("Do you want to add more than 5 Element Leased Equipment?"),
					"Do you want to add more than 5 Element Leased Equipment?");
			CommonFunctionUtils.radioButtonSelect(input.get("Do you want to add more than 5 Element Leased Equipment?"),
					"Do you want to add more than 5 Element Leased Equipment?");
			if (eqpno.isDisplayed()) {
				CommonFunctionUtils.addTextToTheInputField("Equipment Number",
						input.get("leased_equipment_Equipment Number"));
				CommonFunctionUtils.addTextToTheInputField("Year", input.get("leased_equipment_Year"));
				CommonFunctionUtils.addTextToTheInputField("Make", input.get("leased_equipment_Make"));
				CommonFunctionUtils.addTextToTheInputField("Model", input.get("leased_equipment_Model"));
				CommonFunctionUtils.addTextToTheInputField("Serial Number",
						input.get("leased_equipment_Serial Number"));
				CommonFunctionUtils.selectItemFromDropdown("Vehicle Type", input.get("leased_equipment_Vehicle Type"));
				CommonFunctionUtils.selectItemFromDropdown("Deductible (in USD)",
						input.get("leased_equipment_Deductible (in USD)"));
				CommonFunctionUtils.selectItemFromDropdown("Category", input.get("leased_equipment_Category"));
				CommonFunctionUtils.addTextToTheInputField("Address", input.get("leased_equipment_Address"));
				CommonFunctionUtils.addTextToTheInputField("City", input.get("leased_equipment_City"));
				CommonFunctionUtils.selectItemFromDropdown("State", input.get("leased_equipment_State"));
				CommonFunctionUtils.addTextToTheInputField("Zip Code", input.get("leased_equipment_Zip Code"));
				CommonFunctionUtils.addTextToTheInputField("Equipment Value",
						input.get("leased_equipment_Equipment Value"));
				CommonFunctionUtils.addTextToTheInputField("Lease Start Date",
						input.get("leased_equipment_Lease Start Date"));
				CommonFunctionUtils.addTextToTheInputField("Lease Term", input.get("leased_equipment_Lease Term"));

				CommonFunctionUtils.activeButtonClick("Next");
			}
		} catch (Exception e) {
			System.out.println("Exception Leased Equipment is not clickable");
			CommonFunctionUtils.activeButtonClick("Next");
		}

	}

	public void nonElementLeasedUnits(HashMap<String, String> input) {
		try {
			CommonFunctionUtils.radioButtonSelect(input.get("Do you want to add more than 5 Element Leased Equipment?"),
					"Do you want to add more than 5 Element Leased Equipment?");
			CommonFunctionUtils.radioButtonSelect(input.get("Do you want to add more than 5 Element Leased Equipment?"),
					"Do you want to add more than 5 Element Leased Equipment?");

			CommonFunctionUtils.radioButtonSelect(input.get("Do you want to create a list of lessors?"),
					"Do you want to create a list of lessors?");
			CommonFunctionUtils.addTextToTheInputField("Name", input.get("lessor_Name"));
			CommonFunctionUtils.addTextToTheInputField("Address", input.get("lessor_Address"));
			CommonFunctionUtils.addTextToTheInputField("City", input.get("lessor_City"));
			CommonFunctionUtils.selectItemFromDropdown("State", input.get("lessor_State"));
			CommonFunctionUtils.addTextToTheInputField("Zip Code", input.get("lessor_Zip Code"));

			CommonFunctionUtils.radioButtonSelect(input.get("Do you want to create a list of loss payees?"),
					"Do you want to create a list of loss payees?");
			CommonFunctionUtils.addTextToTheInputField("Name", input.get("loss_payee_Name"));
			CommonFunctionUtils.addTextToTheInputField("Address", input.get("loss_payee_Address"));
			CommonFunctionUtils.addTextToTheInputField("City", input.get("loss_payee_City"));
			CommonFunctionUtils.selectItemFromDropdown("State", input.get("loss_payee_State"));
			CommonFunctionUtils.addTextToTheInputField("Zip Code", input.get("loss_payee_Zip Code"));

			CommonFunctionUtils.addTextToTheInputField("Year", input.get("non_leased_units_Year"));
			CommonFunctionUtils.addTextToTheInputField("Make", input.get("non_leased_units_Make"));
			CommonFunctionUtils.addTextToTheInputField("Model", input.get("non_leased_units_Model"));
			CommonFunctionUtils.addTextToTheInputField("VIN #", input.get("non_leased_units_VIN #"));
			CommonFunctionUtils.selectItemFromDropdown("Gross Vehicle Weight (in lbs)",
					input.get("non_leased_units_Gross Vehicle Weight (in lbs)"));
			CommonFunctionUtils.selectItemFromDropdown("Vehicle Type", input.get("non_leased_units_Vehicle Type"));
			CommonFunctionUtils.addTextToTheInputField("License Plate Number",
					input.get("non_leased_units_License Plate Number"));
			CommonFunctionUtils.selectItemFromDropdown("State of License Registration",
					input.get("non_leased_units_State of License Registration"));
			CommonFunctionUtils.selectItemFromDropdown("Deductible (in USD)",
					input.get("non_leased_units_Deductible (in USD)"));
			CommonFunctionUtils.radioButtonSelect(
					input.get("non_leased_units_Do you intend to use this unit for less than 30 days?"),
					"Do you intend to use this unit for less than 30 days?");
			CommonFunctionUtils.addTextToTheInputField("Address", input.get("non_leased_units_Address"));
			CommonFunctionUtils.addTextToTheInputField("City", input.get("non_leased_units_City"));
			CommonFunctionUtils.selectItemFromDropdown("State", input.get("non_leased_units_State"));
			CommonFunctionUtils.addTextToTheInputField("Zip Code", input.get("non_leased_units_Zip Code"));
			CommonFunctionUtils.addTextToTheInputField("ACV (Actual Cost Value) (in USD)",
					input.get("non_leased_units_ACV (Actual Cost Value) (in USD)"));
			CommonFunctionUtils.radioButtonSelect(
					input.get("non_leased_units_Is there an Additional Upfitting component?"),
					"Is there an Additional Upfitting component?");
			CommonFunctionUtils.activeButtonClick("Next");
		} catch (Exception e) {
			System.out.println("Non Leased Units Not clickable");
			CommonFunctionUtils.activeButtonClick("Next");
		}

	}

	public void nonElementLeasedEquipments(HashMap<String, String> input) {
		try {
			CommonFunctionUtils.radioButtonSelect(
					input.get("Do you want to add more than 5 Non-Element leased Equipment?"),
					"Do you want to add more than 5 Non-Element leased Equipment?");

			if (noneqpno.isDisplayed()) {
				CommonFunctionUtils.addTextToTheInputField("Equipment Number",
						input.get("non_leased_equipments_Equipment Number"));
				CommonFunctionUtils.addTextToTheInputField("Year", input.get("non_leased_equipments_Year"));
				CommonFunctionUtils.addTextToTheInputField("Make", input.get("non_leased_equipments_Make"));
				CommonFunctionUtils.addTextToTheInputField("Model", input.get("non_leased_equipments_Model"));
				CommonFunctionUtils.addTextToTheInputField("Serial Number",
						input.get("non_leased_equipments_Serial Number"));
				CommonFunctionUtils.selectItemFromDropdown("Vehicle Type",
						input.get("non_leased_equipments_Vehicle Type"));
				CommonFunctionUtils.selectItemFromDropdown("Deductible (in USD)",
						input.get("non_leased_equipments_Deductible (in USD)"));
				CommonFunctionUtils.selectItemFromDropdown("Category", input.get("non_leased_equipments_Category"));
				CommonFunctionUtils.radioButtonSelect(input.get("non_leased_equipments_Is this a Pool Vehicle?"),
						"Is this a Pool Vehicle?");
				CommonFunctionUtils.addTextToTheInputField("Address", input.get("non_leased_equipments_Address"));
				CommonFunctionUtils.addTextToTheInputField("City", input.get("non_leased_equipments_City"));
				CommonFunctionUtils.selectItemFromDropdown("State", input.get("non_leased_equipments_State"));
				CommonFunctionUtils.addTextToTheInputField("Zip Code", input.get("non_leased_equipments_Zip Code"));
				CommonFunctionUtils.addTextToTheInputField("Equipment Value",
						input.get("non_leased_equipments_Equipment Value"));
				CommonFunctionUtils.activeButtonClick("Next");
			}
		} catch (Exception e) {
			System.out.println("NonLeased Equipment Not clickable");
			CommonFunctionUtils.activeButtonClick("Next");
		}

	}

	// excel upload page

	public void LeasedUnitsExcelupload() {
		canceliconclick.click();
		CommonFunctionUtils.excelUpload("Excel Upload", "HDO\\ElementFleet\\Template-US-Element_Leased_Units.xlsx");
		CommonFunctionUtils.waitForVisibility(canceliconclick);
		CommonFunctionUtils.waitForVisibility(uploadclick);
		uploadclick.click();
		CommonFunctionUtils.activeButtonClick("OK");
		CommonFunctionUtils.activeButtonClick("Next");

	}

	public void LeasedEquipmentExcelupload() {
		canceliconclick.click();
		CommonFunctionUtils.excelUpload("Excel Upload", "HDO\\ElementFleet\\Template-US-Element_Leased_Equipment.xlsx");
		CommonFunctionUtils.waitForVisibility(canceliconclick);
		CommonFunctionUtils.waitForClickableElement(uploadclick);
		uploadclick.click();
		CommonFunctionUtils.activeButtonClick("OK");
		CommonFunctionUtils.activeButtonClick("Next");

	}

	public void NonLeasedUnitExcelupload() {
		canceliconclick.click();
		CommonFunctionUtils.excelUpload("Excel Upload", "HDO\\ElementFleet\\Template-US-Non-Element_Leased_Units.xlsx");
		CommonFunctionUtils.waitForVisibility(canceliconclick);
		CommonFunctionUtils.waitForClickableElement(uploadclick);
		uploadclick.click();
		CommonFunctionUtils.activeButtonClick("OK");
		CommonFunctionUtils.activeButtonClick("Next");

	}

	public void NonLeasedEquipmentExcelupload() {
		canceliconclick.click();
		CommonFunctionUtils.excelUpload("Excel Upload",
				"HDO\\ElementFleet\\Template-US-Non-Element_Leased_Equipment.xlsx");
		CommonFunctionUtils.waitForVisibility(canceliconclick);
		CommonFunctionUtils.waitForClickableElement(uploadclick);
		uploadclick.click();
		CommonFunctionUtils.activeButtonClick("OK");
		CommonFunctionUtils.activeButtonClick("Next");

	}

}
