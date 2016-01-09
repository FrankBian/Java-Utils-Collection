package com.gansuer.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 11/20/15.
 */
public class Solution144Test {

    private Solution144 solution144;

    @Before
    public void setUp() throws Exception {
        solution144 = new Solution144();
    }

    @Test
    public void testPreorderTraversal() throws Exception {
        Integer[] input = {1, null, 2, 3};

        TreeNode root = BinaryTreeHelper.buildBinaryTree(input);

        List<Integer> res = solution144.preorderTraversal(root);

        Assert.assertNotNull(res);
        Assert.assertEquals(1, res.get(0).intValue());
        Assert.assertEquals(2, res.get(1).intValue());
        Assert.assertEquals(3, res.get(2).intValue());

        res = solution144.preorderTraversalWithIterate(root);
        Assert.assertNotNull(res);
        Assert.assertEquals(1, res.get(0).intValue());
        Assert.assertEquals(2, res.get(1).intValue());
        Assert.assertEquals(3, res.get(2).intValue());
    }
}