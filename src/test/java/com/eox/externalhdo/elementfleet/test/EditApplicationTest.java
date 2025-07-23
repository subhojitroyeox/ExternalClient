package com.eox.externalhdo.elementfleet.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eox.externalhdo.elementfleet.base.Basetest;
import com.eox.utils.CommonFunctionUtils;

public class EditApplicationTest extends Basetest {

	@Test
	public void editApplication() throws InterruptedException {
		editpage.searchAndEditApplicationForCompany("Main Test Company");
		editpage.editAndSubmit();
	}
}
