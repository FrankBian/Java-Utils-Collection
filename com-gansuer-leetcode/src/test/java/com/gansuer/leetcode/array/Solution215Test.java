package com.gansuer.leetcode.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 3/23/16.
 */
public class Solution215Test {

    private Solution215 solution215;

    @Before
    public void setUp() throws Exception {
        solution215 = new Solution215();
    }

    @Test
    public void findKthLargest() throws Exception {
        int[] case1 = {3,2,1,5,6,4};
        Assert.assertEquals(5,solution215.findKthLargest(case1,2));

        int[] case2 = {2,1};
        Assert.assertEquals(2,solution215.findKthLargest(case2,1));
    }
}