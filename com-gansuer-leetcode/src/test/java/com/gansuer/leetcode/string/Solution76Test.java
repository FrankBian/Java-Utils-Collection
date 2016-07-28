package com.gansuer.leetcode.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/28/16.
 */
public class Solution76Test {

    private Solution76 solution76;

    @Before
    public void setUp() throws Exception {
        solution76 = new Solution76();
    }

    @Test
    public void minWindow() throws Exception {
        String s = "EADOBECODEBANC";
        String t = "ABC";

        Assert.assertEquals("BANC", solution76.minWindow(s, t));

        s = "a";
        t = "aa";
        Assert.assertEquals("", solution76.minWindow(s, t));

        s = "aa";
        t = "aa";
        Assert.assertEquals("aa", solution76.minWindow(s, t));
    }

}