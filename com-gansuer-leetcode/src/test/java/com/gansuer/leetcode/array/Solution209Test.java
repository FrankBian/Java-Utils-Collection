package com.gansuer.leetcode.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 6/21/16.
 */
public class Solution209Test {

    private Solution209 solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution209();
    }

    @Test
    public void minSubArrayLen() throws Exception {
        int res = solution.minSubArrayLen(7,new int[]{2,3,1,2,4,3});
        Assert.assertEquals(2,res);

        res = solution.minSubArrayLen(11,new int[]{1,2,3,4,5});
        Assert.assertEquals(3,res);
    }

}