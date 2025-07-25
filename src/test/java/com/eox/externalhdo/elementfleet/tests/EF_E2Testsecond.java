package com.eox.externalhdo.elementfleet.tests;

import org.testng.annotations.Test;

import com.eox.externalhdo.elementfleet.base.Basetest;

public class EF_E2Testsecond extends Basetest {

	@Test(priority = 1)
	public void publishQuotetest() {
		loginUtils.switchUser("hub_1752834223754", "He_7aMRSek5i", "Element Fleet");
		publishquote.publishquoteaction();
	}

//6th - this or 6th can run single time - producerusername ( all)
	@Test(priority = 2)
	public void quoteAccept() throws InterruptedException {
		loginUtils.switchUser("hub_1752834223754", "He_7aMRSek5i", "Element Fleet");
		quoteaccepted.quoteaccept();
	}

}
