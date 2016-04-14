package com.gansuer.leetcode.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 4/14/16.
 */
public class Solution238Test {
    private Solution238 solution238;

    @Before
    public void setUp() throws Exception {
        solution238 = new Solution238();
    }

    @Test
    public void productExceptSelf() throws Exception {

    }

    @Test
    public void productExceptSelfX() throws Exception {
        int[] case1 = {1,2,3,4};
        int[] res = solution238.productExceptSelfX(case1);
        Assert.assertArrayEquals(new int[]{24,12,8,6},res);

        res = solution238.productExceptSelfX(new int[]{1,0});
        Assert.assertArrayEquals(new int[]{0,1},res);
    }

}