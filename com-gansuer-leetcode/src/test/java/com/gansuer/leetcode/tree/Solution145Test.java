package com.gansuer.leetcode.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 5/12/16.
 */
public class Solution145Test {

    private Solution145 solution145;

    @Before
    public void setUp() throws Exception {
        solution145 = new Solution145();
    }

    @Test
    public void postorderTraversal() throws Exception {
        TreeNode root = BinaryTreeHelper.buildBinaryTree(new Integer[]{1, null, 2,3});
        BinaryTreeHelper.printBinaryTree(root);
        List<Integer> res = solution145.postorderTraversal(root);

        Assert.assertNotNull(res);
        Assert.assertEquals(3, res.size());
        Assert.assertEquals(3, res.get(0).intValue());
        Assert.assertEquals(2, res.get(1).intValue());
        Assert.assertEquals(1, res.get(2).intValue());
    }

    @Test
    public void postorderTraversalIterater() throws Exception {
        TreeNode root = BinaryTreeHelper.buildBinaryTree(new Integer[]{1, null, 2,3});
        BinaryTreeHelper.printBinaryTree(root);
        List<Integer> res = solution145.postorderTraversalIterater(root);

        Assert.assertNotNull(res);
        Assert.assertEquals(3, res.size());
        Assert.assertEquals(3, res.get(0).intValue());
        Assert.assertEquals(2, res.get(1).intValue());
        Assert.assertEquals(1, res.get(2).intValue());
    }

    @Test
    public void postorderTraversalIteraterX() throws Exception {
        TreeNode root = BinaryTreeHelper.buildBinaryTree(new Integer[]{1, null, 2,3});
        BinaryTreeHelper.printBinaryTree(root);
        List<Integer> res = solution145.postorderTraversalIteraterX(root);

        Assert.assertNotNull(res);
        Assert.assertEquals(3, res.size());
        Assert.assertEquals(3, res.get(0).intValue());
        Assert.assertEquals(2, res.get(1).intValue());
        Assert.assertEquals(1, res.get(2).intValue());
    }
}