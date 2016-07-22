package com.gansuer.leetcode.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/22/16.
 */
public class Solution344Test {

    private Solution344 solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution344();
    }

    @Test
    public void reverseString() throws Exception {
        String src = "hello";

        Assert.assertEquals("olleh", solution.reverseString(src));
    }

}