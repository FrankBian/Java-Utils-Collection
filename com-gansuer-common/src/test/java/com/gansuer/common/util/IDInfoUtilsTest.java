package com.gansuer.common.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Frank on 6/28/16.
 */
public class IDInfoUtilsTest {


    private String id = "622823199307182213";

    @Test
    public void isValidatedID() throws Exception {
        Assert.assertTrue(IDInfoUtils.isValidatedID(id, "622823"));
        Assert.assertTrue(!IDInfoUtils.isValidatedID("622823001300221","622823"));
    }

    @Test
    public void getBirthDay() throws Exception {
        Date date = IDInfoUtils.getBirthDay(id);
        Assert.assertNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Assert.assertEquals(1993,calendar.get(Calendar.YEAR));
        Assert.assertEquals(7,calendar.get(Calendar.MONTH)+1);
        Assert.assertEquals(18,calendar.get(Calendar.DAY_OF_MONTH));
    }

}