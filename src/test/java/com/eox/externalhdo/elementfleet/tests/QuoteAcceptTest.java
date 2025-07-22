package com.eox.externalhdo.elementfleet.tests;

import org.testng.annotations.Test;

import com.eox.externalhdo.elementfleet.base.Basetest;

public class QuoteAcceptTest extends Basetest {

	@Test
	public void paymenttest() {
		payment.AcceptQuote();
	}
}
