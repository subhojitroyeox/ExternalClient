
package com.eox.functional.Hdo.MyCompanyDetails.tests;

import org.testng.annotations.Test;

import com.eox.functional.Hdo.MyCompanyDetails.pages.LaunchMyCompanyPage;
import com.eox.functional.Hdo.base.BaseTest;

public class LaunchMyCompanyTests extends BaseTest {
	
	@Test
	public void test() throws InterruptedException {
		System.out.println("this is my test");
		LaunchMyCompanyPage.fetchAllTabsButton();
	}

}
