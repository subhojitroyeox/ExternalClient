package com.eox.externalhdo.elementfleet.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eox.externalhdo.elementfleet.base.Basetest;

public class EditUserDetails extends Basetest{

    @Test
    public void EditUserDetails(HashMap<String, String> input) throws InterruptedException {
       userManagementPage.umPage(input);
        
    }

}
