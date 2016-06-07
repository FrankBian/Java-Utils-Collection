package com.gansuer.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Frank on 6/7/16.
 */
public class Solution152Test {

    private Solution152 solution152 = new Solution152();

    @Test
    public void maxProduct() throws Exception {
        int res = solution152.maxProduct(new int[]{2, 3, -1, 4});
        Assert.assertEquals(6, res);

        res = solution152.maxProduct(new int[]{3, -1, 4});
        Assert.assertEquals(4, res);

        res = solution152.maxProduct(new int[]{3, -4, -8});
        Assert.assertEquals(96, res);

        res = solution152.maxProduct(new int[]{-3, -4, -8, 10});
        Assert.assertEquals(320, res);

        res = solution152.maxProduct(new int[]{0, 2});
        Assert.assertEquals(2, res);

        res = solution152.maxProduct(new int[]{-2});
        Assert.assertEquals(-2, res);
    }


    @Test
    public void maxProductXB() throws Exception {
        int res = solution152.maxProductXB(new int[]{2, 3, -1, 4});
        Assert.assertEquals(6, res);

        res = solution152.maxProductXB(new int[]{3, -1, 4});
        Assert.assertEquals(4, res);

        res = solution152.maxProductXB(new int[]{3, -4, -8});
        Assert.assertEquals(96, res);

        res = solution152.maxProductXB(new int[]{-3, -4, -8, 10});
        Assert.assertEquals(320, res);

        res = solution152.maxProductXB(new int[]{0, 2});
        Assert.assertEquals(2, res);

        res = solution152.maxProductXB(new int[]{-2});
        Assert.assertEquals(-2, res);

    }
}