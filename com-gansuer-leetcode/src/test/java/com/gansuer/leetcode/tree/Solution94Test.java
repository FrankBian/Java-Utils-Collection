package com.gansuer.leetcode.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 11/20/15.
 */
public class Solution94Test {

    private Solution94 solution94;

    @Before
    public void setUp() throws Exception {
        solution94 = new Solution94();
    }

    @Test
    public void testInorderTraversal() throws Exception {
        Integer[] input = {1, null, 2, 3};

        TreeNode root = BinaryTreeHelper.buildBinaryTree(input);

        List<Integer> res = solution94.inorderTraversal(root);

        Assert.assertNotNull(res);
        Assert.assertEquals(1, res.get(0).intValue());
        Assert.assertEquals(3, res.get(1).intValue());
        Assert.assertEquals(2, res.get(2).intValue());

        res = solution94.inorderTraversalWithIterate(root);
        Assert.assertNotNull(res);
        Assert.assertEquals(3, res.size());
        Assert.assertEquals(1, res.get(0).intValue());
        Assert.assertEquals(3, res.get(1).intValue());
        Assert.assertEquals(2, res.get(2).intValue());

        res = solution94.inorderX(root);
        Assert.assertNotNull(res);
        Assert.assertEquals(3, res.size());
        Assert.assertEquals(1, res.get(0).intValue());
        Assert.assertEquals(3, res.get(1).intValue());
        Assert.assertEquals(2, res.get(2).intValue());
    }
}