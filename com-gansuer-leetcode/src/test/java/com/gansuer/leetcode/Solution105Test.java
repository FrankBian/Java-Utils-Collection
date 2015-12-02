package com.gansuer.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 12/2/15.
 */
public class Solution105Test {

    private Solution105 solution105;

    @Before
    public void setUp() throws Exception {
        solution105 = new Solution105();
    }

    @Test
    public void testBuildTree() throws Exception {
        int[] preorder = {1,2,3,6,5,4};
        int[] inorder = {3,2,6,1,5,4};

        TreeNode root = solution105.buildTree(preorder,inorder);

        Assert.assertNotNull(root);
        Assert.assertEquals(1,root.val.intValue());
    }

    @Test
    public void testBuildTree2() throws Exception {
        int[] preorder = {1,2};
        int[] inorder = {2,1};

        TreeNode root = solution105.buildTree(preorder,inorder);

        Assert.assertNotNull(root);
        Assert.assertEquals(1, root.val.intValue());
    }

    @Test
    public void testBuildTree3() throws Exception {
        int[] preorder = {2,1,6,3,5,4};
        int[] inorder = {1,2,3,4,5,6};

        TreeNode root = solution105.buildTree(preorder,inorder);

        Assert.assertNotNull(root);
        Assert.assertEquals(1, root.val.intValue());
    }
}