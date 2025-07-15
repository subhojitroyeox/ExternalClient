package com.eox.externalhdo.elementfleet.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.eox.externalhdo.elementfleet.base.Basetest;
import com.eox.utils.HDOUtils;

public class TileValidationTest extends Basetest {

	@Test
	public void clientadminTilevalidation() {
		boolean result = HDOUtils.readTilesRolesBasis("Admin",
				System.getProperty("user.dir") + "//src//test//java//data//Tileaccess.json");
		assertTrue(result);
		System.out.println(result);
	}

}
