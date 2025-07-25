package com.eox.externalhdo.elementfleet.tests;

import java.util.Optional;

import org.testng.annotations.Test;

import com.eox.externalhdo.elementfleet.base.Basetest;
import com.eox.utils.CommonFunctionUtils;
import com.eox.utils.HDOUtils;

public class RecordDelete extends Basetest {
	@Test
	public void recordDelete() {
		CommonFunctionUtils.openSideNavBar("Element_US_List");
		CommonFunctionUtils.verifyListViewRecordAndAction(driver, "Company Name", "ATZZ Test Client",
				Optional.of("Delete"));
		CommonFunctionUtils.popupAccept();

	}
}
