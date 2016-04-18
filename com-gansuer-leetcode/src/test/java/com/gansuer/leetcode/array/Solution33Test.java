package com.gansuer.leetcode.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 4/18/16.
 */
public class Solution33Test {

    private Solution33 solution33;

    @Before
    public void setUp() throws Exception {
        solution33 = new Solution33();
    }

    @Test
    public void search() throws Exception {
        int[] case1 = {4,5,6,7,0,1,2};
        int res = solution33.search(case1,3);
        Assert.assertEquals(-1,res);

        res = solution33.search(case1,2);
        Assert.assertEquals(6,res);

        res = solution33.search(case1,4);
        Assert.assertEquals(0,res);

        res = solution33.search(case1,5);
        Assert.assertEquals(1,res);
    }

}