package com.eox.externalhdo.elementfleet.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.eox.externalhdo.elementfleet.base.Basetest;
import com.eox.externalhdo.elementfleet.pages.TileAccessValidationPage;
import com.eox.utils.HDOUtils;

public class TileValidationTest extends Basetest {
	@Test
	public void clientadminTilevalidation() {
		boolean result = tilevalidate.tileaccesscheck();
		assertTrue(result);
	}

}
