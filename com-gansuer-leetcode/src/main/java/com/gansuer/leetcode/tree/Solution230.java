package com.gansuer.leetcode.tree;

/**
 * Created by Frank on 6/24/16.
 */
public class Solution230 {

    /**
     * 1ms
     * Accepted
     * 53.21%
     * BugFree
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        int left = getElementNumber(root.left);
        if (k <= left) return kthSmallest(root.left, k);
        else if (k == left + 1) return root.val;
        else return kthSmallest(root.right, k - left - 1);
    }

    private int getElementNumber(TreeNode node) {
        if (node == null) return 0;
        return 1 + getElementNumber(node.left) + getElementNumber(node.right);
    }
}
