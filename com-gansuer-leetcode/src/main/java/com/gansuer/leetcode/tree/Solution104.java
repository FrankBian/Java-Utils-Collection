package com.gansuer.leetcode.tree;

import com.gansuer.leetcode.tree.TreeNode;

/**
 * Created by Frank on 11/17/15.
 */
public class Solution104 {

    /**
     * Accepted
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return left > right ? left : right;
    }
}
