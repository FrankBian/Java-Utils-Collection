package com.gansuer.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Frank on 11/20/15.
 */
public class Solution108Test {

    private Solution108 solution108;

    @Before
    public void setUp() throws Exception {
        solution108 = new Solution108();
    }

    @Test
    public void testSortedArrayToBST() throws Exception {
        int[] input = {0,1,2,3,4,5,6,7,8,9};

        TreeNode root = solution108.sortedArrayToBST(input);

        Solution110 solution110 = new Solution110();

        Assert.assertTrue(solution110.isBalanced(root));

        List<List<TreeNode>> children = BinaryTreeHelper.levelOrder(root);
        Assert.assertEquals(4,children.size());

    }
}