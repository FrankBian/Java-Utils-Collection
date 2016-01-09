package com.gansuer.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 11/22/15.
 */
public class Solution199Test {

    private Solution199 solution199;

    @Before
    public void setUp() throws Exception {
        solution199 = new Solution199();
    }

    @Test
    public void testRightSideViewV0() throws Exception {
        Integer[] input = {1, 2, 3, null, 5, null, 4};

        TreeNode root = BinaryTreeHelper.buildBinaryTree(input);

        List<Integer> res = solution199.rightSideViewV0(root);

        Assert.assertNotNull(res);
        Assert.assertEquals(3, res.size());
        Assert.assertEquals(1, res.get(0).intValue());
        Assert.assertEquals(3, res.get(1).intValue());
        Assert.assertEquals(4, res.get(2).intValue());
    }

    @Test
    public void testRightSideView() throws Exception {
        Integer[] input = {1, 2, 3, null, 5, null, 4};

        TreeNode root = BinaryTreeHelper.buildBinaryTree(input);

        List<Integer> res = solution199.rightSideView(root);

        Assert.assertNotNull(res);
        Assert.assertEquals(3, res.size());
        Assert.assertEquals(1, res.get(0).intValue());
        Assert.assertEquals(3, res.get(1).intValue());
        Assert.assertEquals(4, res.get(2).intValue());
    }
}