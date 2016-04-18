package com.gansuer.leetcode.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 4/18/16.
 */
public class Solution4Test {

    private Solution4 solution4;

    @Before
    public void setUp() throws Exception {
        solution4 = new Solution4();
    }

    @Test
    public void findMedianSortedArrays() throws Exception {
        double res = solution4.findMedianSortedArrays(new int[]{11,13,19,20,35,48},
                new int[]{21,22,25,26,29,36,97});
        Assert.assertEquals("",25,res,0.0);

        res = solution4.findMedianSortedArrays(new int[]{},new int[]{2,3});
        Assert.assertEquals("",2.5,res,0.0);
    }

    @Test
    public void findMedianSortedArraysX() throws Exception {

        double res = solution4.findMedianSortedArraysX(new int[]{11,13,19,20,35,48},
                new int[]{21,22,25,26,29,36,97});
        Assert.assertEquals("",25,res,0.0);

        res = solution4.findMedianSortedArraysX(new int[]{},new int[]{2,3});
        Assert.assertEquals("",2.5,res,0.0);
    }
}