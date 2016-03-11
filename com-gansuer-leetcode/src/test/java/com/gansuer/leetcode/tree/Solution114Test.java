package com.gansuer.leetcode.tree;

import com.gansuer.leetcode.tree.BinaryTreeHelper;
import com.gansuer.leetcode.tree.Solution114;
import com.gansuer.leetcode.tree.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 11/23/15.
 */
public class Solution114Test {

    private Solution114 solution114;

    @Before
    public void setUp() throws Exception {
        solution114 = new Solution114();
    }

    @Test
    public void testFlatten() throws Exception {
        Integer[] input = {1, 2, 5, 3, 4, null, 6};

        TreeNode root = BinaryTreeHelper.buildBinaryTree(input);

        solution114.flatten(root);

        TreeNode cur = root;
        int num = 1;
        while (cur != null) {
            Assert.assertEquals(num++, cur.val.intValue());
            Assert.assertEquals(null, cur.left);
            cur = cur.right;
        }
    }

    @Test
    public void testFlattenV1() throws Exception {
        Integer[] input = {1, 2, 5, 3, 4, null, 6};

        TreeNode root = BinaryTreeHelper.buildBinaryTree(input);

        solution114.flattenV1(root);

        TreeNode cur = root;
        int num = 1;
        while (cur != null) {
            Assert.assertEquals(num++, cur.val.intValue());
            Assert.assertEquals(null, cur.left);
            cur = cur.right;
        }
    }

    @Test
    public void testFlattenV2() throws Exception {
        Integer[] input = {1, 2, 5, 3, 4, null, 6};

        TreeNode root = BinaryTreeHelper.buildBinaryTree(input);

        solution114.flattenV2(root);

        TreeNode cur = root;
        int num = 1;
        while (cur != null) {
            Assert.assertEquals(num++, cur.val.intValue());
            Assert.assertEquals(null, cur.left);
            cur = cur.right;
        }
    }
}