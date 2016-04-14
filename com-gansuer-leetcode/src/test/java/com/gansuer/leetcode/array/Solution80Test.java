package com.gansuer.leetcode.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Frank on 4/14/16.
 */
public class Solution80Test {

    private Solution80 solution80;

    @Before
    public void setUp() throws Exception {
        solution80 = new Solution80();
    }

    @Test
    public void removeDuplicates() throws Exception {
        int[] case1 = {1,1,1,2,2,3};
        int res = solution80.removeDuplicates(case1);
        Assert.assertEquals(5,res);
        Assert.assertArrayEquals(new int[]{1,1,2,2,3}, Arrays.copyOf(case1,res));

        int[] case2 = {1,1,2,2};
        res = solution80.removeDuplicates(case2);
        Assert.assertEquals(4,res);
        Assert.assertArrayEquals(new int[]{1,1,2,2},Arrays.copyOf(case2,res));
    }

}