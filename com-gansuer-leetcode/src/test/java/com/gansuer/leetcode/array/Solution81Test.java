package com.gansuer.leetcode.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 4/18/16.
 */
public class Solution81Test {

    private Solution81 solution81;

    @Before
    public void setUp() throws Exception {
        solution81 = new Solution81();
    }

    @Test
    public void search() throws Exception {
        int[] case1 = {3,1,1};
        boolean res = solution81.search(case1,3);
        Assert.assertTrue(res);
        res = solution81.searchX(case1,3);
        Assert.assertTrue(res);

        int[] case2 = {1,1,3,1};
        res = solution81.search(case2,3);
        Assert.assertTrue(res);
        res = solution81.searchX(case2,3);
        Assert.assertTrue(res);
    }

}