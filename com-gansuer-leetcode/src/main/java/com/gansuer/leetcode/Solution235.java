package com.gansuer.leetcode;

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
        if (root == null || p == null || q == null) return null;
        if (root.val > p.val) {
//            if (root.val < q.val) {
//                return root;
//            } else {
//                return lowestCommonAncestor(root.left, p, q);
//            }
            return root.val < q.val ? root : lowestCommonAncestor(root.left, p, q);
        } else {
//            if (root.val > q.val) {
//                return root;
//            } else {
//                return lowestCommonAncestor(root.right, p, q);
//            }
            return root.val > q.val ? root : lowestCommonAncestor(root.right, p, q);
        }
    }

    public TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (root.val < Math.min(p.val, q.val)) return lowestCommonAncestorV1(root.right, p, q);
        if (root.val > Math.max(p.val, q.val)) return lowestCommonAncestorV1(root.left, p, q);
        return root;
    }
}
