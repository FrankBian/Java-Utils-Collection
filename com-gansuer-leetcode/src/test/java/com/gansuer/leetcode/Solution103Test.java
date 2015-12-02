package com.gansuer.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 12/2/15.
 */
public class Solution103Test {


    private Solution103 solution103;

    @Before
    public void setUp() throws Exception {
        solution103 = new Solution103();
    }

    @Test
    public void testZigzagLevelOrder() throws Exception {
        Integer[] input = {3,9,20,null,null,15,7};

        TreeNode root = BinaryTreeHelper.buildBinaryTree(input);

        Assert.assertNotNull(root);
        List<List<Integer>> result = solution103.zigzagLevelOrderV1(root);

        Assert.assertNotNull(result);
        Assert.assertEquals(3,result.size());
        Assert.assertEquals(1,result.get(0).size());
        Assert.assertEquals(3,result.get(0).get(0).intValue());
        Assert.assertEquals(2,result.get(1).size());
        Assert.assertEquals(20,result.get(1).get(0).intValue());
        Assert.assertEquals(9,result.get(1).get(1).intValue());
        Assert.assertEquals(2,result.get(2).size());
        Assert.assertEquals(15,result.get(2).get(0).intValue());
        Assert.assertEquals(7,result.get(2).get(1).intValue());
    }
}