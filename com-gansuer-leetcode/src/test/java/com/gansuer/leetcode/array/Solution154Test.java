package com.gansuer.leetcode.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 5/9/16.
 */
public class Solution154Test {

    private Solution154 solution154;

    @Before
    public void setUp() throws Exception {
        solution154 = new Solution154();
    }

    @Test
    public void findMin() throws Exception {
        int[] case1 = {4,5,6,7,0,1,2};
        int res = solution154.findMin(case1);
        Assert.assertEquals(0,res);

        res = solution154.findMin(new int[]{7,7,7,7,7,9,9,9,9,1,1,1,1,2,2,2,2,3});
        Assert.assertEquals(1,res);

        res = solution154.findMin(new int[]{3,1,1});
        Assert.assertEquals(1,res);

        res = solution154.findMin(new int[]{2,0,1,1,1});
        Assert.assertEquals(0,res);
    }

    @Test
    public void findMinX() throws Exception {
        int[] case1 = {4,5,6,7,0,1,2};
        int res = solution154.findMinX(case1);
        Assert.assertEquals(0,res);

        res = solution154.findMinX(new int[]{7,7,7,7,7,9,9,9,9,1,1,1,1,2,2,2,2,3});
        Assert.assertEquals(1,res);

        res = solution154.findMinX(new int[]{3,1,1});
        Assert.assertEquals(1,res);

        res = solution154.findMinX(new int[]{2,0,1,1,1});
        Assert.assertEquals(0,res);
    }
}