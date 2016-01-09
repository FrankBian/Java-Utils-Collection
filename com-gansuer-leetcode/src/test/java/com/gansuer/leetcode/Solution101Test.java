package com.gansuer.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 11/19/15.
 */
public class Solution101Test {

    private Solution101 solution101;

    @Before
    public void setUp() throws Exception {
        solution101 = new Solution101();
    }

    @Test
    public void testIsSymmetric() throws Exception {
        Integer[] input1 = {1, 2, 2, 3, 4, 4, 3};
        Integer[] input2 = {1, 2, 2, null, 3, null, 3};

        TreeNode root = BinaryTreeHelper.buildBinaryTree(input1);
        boolean res = solution101.isSymmetric(root);

        Assert.assertTrue(res);

        root = BinaryTreeHelper.buildBinaryTree(input2);
        res = solution101.isSymmetric(root);

        Assert.assertTrue(!res);

        root = BinaryTreeHelper.buildBinaryTree(new Integer[]{});
        res = solution101.isSymmetric(root);

        Assert.assertTrue(res);
    }
}