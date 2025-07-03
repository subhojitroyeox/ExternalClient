package com.eox.externalhdo.elementfleet.test;

import org.testng.annotations.Test;

import com.eox.externalhdo.elementfleet.base.Basetest;

public class UserManagementLaunchTest extends Basetest {

	@Test
	public void usercreation()
	{
		System.out.println("This is test");
		userpage.clickManageApplication();
		
		
	}
}
