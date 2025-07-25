package com.eox.externalhdo.elementfleet.tests;

import org.testng.annotations.Test;

import com.eox.externalhdo.elementfleet.base.Basetest;

public class Producerquotepublishtest extends Basetest {

	@Test
	public void publishquotetest() {
		extent.createTest("publishing Quote");
		publishquote.publishquoteaction();
	}
}
