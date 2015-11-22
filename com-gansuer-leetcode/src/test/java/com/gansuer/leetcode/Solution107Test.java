package com.gansuer.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 11/20/15.
 */
public class Solution107Test {

    private Solution107 solution107;

    @Before
    public void setUp() throws Exception {
        solution107 = new Solution107();
    }

    @Test
    public void testLevelOrderBottom() throws Exception {
        Integer[] input = {3,9,20,null,null,15,7};

        TreeNode root = BinaryTreeHelper.buildBinaryTree(input);

        List<List<Integer>> res = solution107.levelOrderBottom(root);

        Assert.assertNotNull(res);
        Assert.assertTrue(res.size() == 3);
        Assert.assertTrue(res.get(0).size() == 2);
        Assert.assertTrue(res.get(1).size() == 2);
        Assert.assertTrue(res.get(2).size() == 1);
    }
}