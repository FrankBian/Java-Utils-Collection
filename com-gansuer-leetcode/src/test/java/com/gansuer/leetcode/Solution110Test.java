package com.gansuer.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Frank on 11/17/15.
 */
public class Solution110Test {

    @Test
    public void testIsBalanced() throws Exception {
        Integer[] input = {1, 2, 2, 3, 3, null, null, 4, 4};

        TreeNode root = BinaryTreeHelper.buildBinaryTree(input);

        boolean res = new Solution110().isBalanced(root);

        Assert.assertTrue(!res);
    }
}