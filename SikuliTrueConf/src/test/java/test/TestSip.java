package test;

import automat.AuthAfterSip;

import org.testng.annotations.Test;
import util.DataProperties;

import static org.testng.Assert.assertTrue;

/**
 * Created by Alex on 29.08.2015.
 */

public class TestSip extends BaseTestCase{

    @Test
    public void testEnter() throws Exception {
        AuthAfterSip sip = new AuthAfterSip();
       // sip.enterAuth(DataProperties.get("password"));
       // sip.inputSipValid(DataProperties.get("valid_tel"));
       // sip.inputSipInValid(DataProperties.get("invalid_tel"));
      //  assertTrue(sip.isErrorCall());
        sip.outTrueConfId();




    }




}