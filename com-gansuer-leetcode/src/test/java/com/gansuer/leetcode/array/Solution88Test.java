package com.gansuer.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Frank on 3/11/16.
 */
public class Solution88Test {

    private Solution88 solution88 = new Solution88();

    @Test
    public void testMergeX() throws Exception {
        int[] num1 = new int[30];
        for (int i = 0; i < 15; i++) {
            num1[i] = i;
        }
        int[] num2 = new int[10];
        for (int i = 0; i < num2.length; i++) {
            num2[i] = i;
        }

        solution88.mergeX(num1, 15, num2, 10);

        for (int i = 1; i < 25; i++) {
            Assert.assertTrue(num1[i] >= num1[i - 1]);
        }
    }
}