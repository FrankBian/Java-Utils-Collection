package com.gansuer.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Frank on 3/16/16.
 */
public class Solution53Test {


    private Solution53 solution53 = new Solution53();

    @Test
    public void testMaxSubArray() throws Exception {
        int[] src = {-2,1,-3,4,-1,2,1,-5,4};

        int res = solution53.maxSubArray(src);

        Assert.assertEquals(6,res);
    }
}