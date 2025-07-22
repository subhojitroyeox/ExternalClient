package com.eox.externalhdo.elementfleet.tests;
import java.util.List;
import org.testng.annotations.Test;
import com.eox.externalhdo.elementfleet.base.Basetest;
public class ReferralCheck extends Basetest {
	@Test
	public void referralTest() {
		referralCheck.referralTab();
		referralCheck.referralCheck();
	}

}
