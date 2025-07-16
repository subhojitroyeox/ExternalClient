package com.eox.externalhdo.elementfleet.test;

import org.testng.annotations.Test;

import com.eox.externalhdo.elementfleet.base.Basetest;

public class UserManagementTest extends Basetest {
	@Test
	public void userCreation() throws InterruptedException {

		UmPage.dataGridtest();
		//utils.selectChoicesDropdownValue("//div[contains(@class,'ui.selection.dropdown')]", "Claims Advocate");
	}
}
