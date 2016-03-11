package com.gansuer.leetcode.tree;

import com.gansuer.leetcode.tree.BinaryTreeHelper;
import com.gansuer.leetcode.tree.TreeNode;
import org.junit.Test;

/**
 * Created by Frank on 11/17/15.
 */
public class BinaryTreeHelperTest {

    @Test
    public void testBuildBinaryTree() throws Exception {
        Integer[] input = {1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, null, null, 5, 5};
        TreeNode root = BinaryTreeHelper.buildBinaryTree(input);
        BinaryTreeHelper.printBinaryTree(root);
    }

}