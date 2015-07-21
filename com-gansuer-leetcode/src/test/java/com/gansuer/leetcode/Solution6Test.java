package com.gansuer.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/21/15.
 */
public class Solution6Test {

    private Solution6 solution6;

    @Before
    public void setUp() throws Exception {
        solution6 = new Solution6();
    }

    @Test
    public void testConvert() throws Exception {
        String text = "PAYPALISHIRING";
        int numRows = 3;
        String expected = "PAHNAPLSIIGYIR";

        String actual = solution6.convert(text, numRows);

        Assert.assertEquals(expected, actual);

        text = "A";
        numRows = 2;
        expected = "A";

        actual = solution6.convert(text, numRows);

        Assert.assertEquals(expected, actual);
    }
}