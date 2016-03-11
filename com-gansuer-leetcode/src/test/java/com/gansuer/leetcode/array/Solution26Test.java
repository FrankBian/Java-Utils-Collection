package com.gansuer.leetcode.array;

import com.gansuer.common.debug.Debug;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Frank on 3/11/16.
 */
public class Solution26Test {

    private Solution26 solution26;

    @Before
    public void setUp() throws Exception {
        solution26 = new Solution26();

    }

    @Test
    public void testRemoveDuplicates() throws Exception {
        int[] src = {9, 8, 7, 6, 5, 4, 3, 2, 1, 4, 6, 8, 2, 5, 88, 1, 0, 3};
        Arrays.sort(src);
        Debug.print(src);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < src.length; i++) {
            set.add(src[i]);
        }
        int res = solution26.removeDuplicates(src);
        Debug.print(src);
        Assert.assertEquals(set.size(), res);

        int[] src1 = {1,1};
        res = solution26.removeDuplicates(src1);

        Assert.assertEquals(1,res);

    }
}