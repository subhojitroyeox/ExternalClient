package com.eox.externalhdo.elementfleet.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eox.externalhdo.elementfleet.base.Basetest;

public class CreateAdminUserFromClientAdmin extends Basetest{

    @Test(dataProvider = "getData")
    public void createProducer(HashMap<String, String> input) throws InterruptedException {
        String actualMessage = userManagementClientAdminPage.umPage(input);
        Assert.assertEquals(actualMessage, "User added successfully.", "User addition message did not match!");
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//data//UM_Admin_from_ClientadminLogin.json");
        return new Object[][] { { data.get(0) } };
    }
}
