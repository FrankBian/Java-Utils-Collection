package com.gansuer.leetcode.tree;

import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * Created by Frank on 11/17/15.
 */
public class Solution110 {

    /**
     * WRONG
     *
     * @param root
     * @return
     */
    @Ignore
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left != null && root.right == null) {
            return root.left.left == null && root.left.right == null;
        }
        if (root.left == null && root.right != null) {
            return root.right.left == null && root.right.right == null;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int heightLeft = depth(root.left);
        int heightRight = depth(root.right);
        return heightLeft > heightRight ? 1 + heightLeft : 1 + heightRight;
    }

    /**
     * Accepted
     *
     * @param root
     * @return
     */
    public boolean isBalancedV1(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(depth(root.left) - depth(root.right)) < 2) {
            return isBalancedV1(root.left) && isBalancedV1(root.right);
        }
        return false;
    }

}
