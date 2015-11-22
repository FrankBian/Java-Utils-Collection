package com.gansuer.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 11/20/15.
 */
public class Solution257Test {

    private Solution257 solution257;

    @Before
    public void setUp() throws Exception {
        solution257 = new Solution257();
    }

    @Test
    public void testBinaryTreePaths() throws Exception {
        Integer[] input = {1,2,3,null,5};

        TreeNode root = BinaryTreeHelper.buildBinaryTree(input);

        List<String> res = solution257.binaryTreePaths(root);

        Assert.assertNotNull(res);
        Assert.assertEquals(2,res.size());
        Assert.assertEquals("1->2->5",res.get(0));
        Assert.assertEquals("1->3",res.get(1));
    }
}