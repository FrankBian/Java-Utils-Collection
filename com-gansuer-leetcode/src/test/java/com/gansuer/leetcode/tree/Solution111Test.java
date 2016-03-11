package com.gansuer.leetcode.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 11/20/15.
 */
public class Solution111Test {

    private Solution111 solution111;

    @Before
    public void setUp() throws Exception {
        solution111 = new Solution111();
    }

    @Test
    public void testMinDepth() throws Exception {
        Integer[] input = {1, 2};

        TreeNode root = BinaryTreeHelper.buildBinaryTree(input);

//        int res = solution111.minDepth(root);

        int res = solution111.minDepthWithQueue(root);
        Assert.assertTrue(res == 2);
    }
}