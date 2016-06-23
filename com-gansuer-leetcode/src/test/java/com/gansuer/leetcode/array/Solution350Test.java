package com.gansuer.leetcode.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 6/23/16.
 */
public class Solution350Test {

    private Solution350 solution;
    @Before
    public void setUp() throws Exception {
        solution = new Solution350();
    }

    @Test
    public void intersect() throws Exception {

        int[] res = solution.intersect(new int[]{1,2,2,1}, new int[]{2,2});
        Assert.assertArrayEquals(new int[]{2,2},res);
    }

}