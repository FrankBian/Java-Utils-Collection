package com.gansuer.leetcode.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 6/23/16.
 */
public class Solution349Test {

    private Solution349 solution;
    @Before
    public void setUp() throws Exception {
        solution = new Solution349();
    }

    @Test
    public void intersect() throws Exception {

        int[] res = solution.intersection(new int[]{1,2,2,1}, new int[]{2,2});
        Assert.assertArrayEquals(new int[]{2},res);
    }
}