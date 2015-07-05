package com.gansuer.leetcode;

import org.junit.Assert;
import org.junit.Before;

/**
 * Created by Frank on 7/1/15.
 */
public class Solution1Test {
    private Solution1 solution1;

    @Before
    public void setUp() throws Exception {
        solution1 = new Solution1();
    }

    @org.junit.Test
    public void testTwoSum() throws Exception {
        int[] ints = new int[]{2,9,10,18,30};
        int[] res = solution1.twoSum(ints,20);

        Assert.assertEquals(res.length,2);
        Assert.assertEquals(res[0],1);
        Assert.assertEquals(res[1],4);
    }

    @org.junit.Test
    public void testTwoSum1() throws Exception {
        int[] ints = new int[]{2,9,10,18,30};
        int[] res = solution1.twoSum(ints,20);

        Assert.assertEquals(res.length,2);
        Assert.assertEquals(res[0],1);
        Assert.assertEquals(res[1],4);
    }
}