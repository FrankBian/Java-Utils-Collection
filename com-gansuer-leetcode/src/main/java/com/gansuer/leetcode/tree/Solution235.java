package com.gansuer.leetcode.tree;

/**
 * Created by Frank on 11/17/15.
 */
public class Solution235 {

    /**
     * Accepted
     * get a better result after changed the if/else to ?:
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (root.val > p.val) {
            return root.val < q.val ? root : lowestCommonAncestor(root.left, p, q);
        } else {
            return root.val > q.val ? root : lowestCommonAncestor(root.right, p, q);
        }
    }

    /**
     * Ensure that p and q exist in the tree.
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (root.val < Math.min(p.val, q.val)) return lowestCommonAncestorV1(root.right, p, q);
        if (root.val > Math.max(p.val, q.val)) return lowestCommonAncestorV1(root.left, p, q);
        return root;
    }
}
