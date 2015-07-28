package com.gansuer.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 7/27/15.
 */
public class Solution236Test {

    private TreeNode root;
    private Solution236 solution236;
    private TreeNode node1;
    private TreeNode node2;

    @Before
    public void setUp() throws Exception {
        node1 = new TreeNode(1);
        node2 = new TreeNode(2);
        root = node1;
        root.left = node2;

        solution236 = new Solution236();
    }

    @Test
    public void testLowestCommonAncestor() throws Exception {
        TreeNode res = solution236.lowestCommonAncestor(root, node1, node2);

        Assert.assertNotNull(res);
        Assert.assertEquals(1 , res.val);
    }
}