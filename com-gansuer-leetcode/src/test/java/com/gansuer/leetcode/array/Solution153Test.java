package com.gansuer.leetcode.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 3/23/16.
 */
public class Solution153Test {


    private Solution153 solution153;

    @Before
    public void setUp() throws Exception {
        solution153 = new Solution153();
    }

    @Test
    public void findMin() throws Exception {
        int[] src = {4,5,6,7,1,2,3};

        Assert.assertEquals(1,solution153.findMin(src));
    }

    @Test
    public void findMinX() throws Exception {
        int[] test0 = {4,5,6,7,1,2,3};

        Assert.assertEquals(1,solution153.findMinX(test0));

        int[] test1 = {100,1,2,3,4,5,6,7,8,90,99};

        Assert.assertEquals(1,solution153.findMinX(test1));
    }
    //
    //@Test
    //public void findMinXX() throws Exception {
    //    int[] test0 = {4,5,6,7,1,2,3};
    //
    //    Assert.assertEquals(1,solution153.findMinXX(test0));
    //
    //    int[] test1 = {100,1,2,3,4,5,6,7,8,90,99};
    //
    //    Assert.assertEquals(1,solution153.findMinXX(test1));
    //
    //    Assert.assertEquals(1,solution153.findMinXX(new int[]{3,1,2}));
    //}
}