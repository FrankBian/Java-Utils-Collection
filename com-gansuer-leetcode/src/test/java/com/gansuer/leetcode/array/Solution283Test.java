package com.gansuer.leetcode.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/22/16.
 */
public class Solution283Test {

    private Solution283 solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution283();
    }

    @Test
    public void moveZeroes() throws Exception {
        int[] input = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(input);
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, input);
    }

}