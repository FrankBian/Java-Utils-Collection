package com.gansuer.leetcode.tree;

import com.gansuer.leetcode.tree.TreeNode;

/**
 * Created by Frank on 7/27/15.
 */
public class Solution236 {

    /**
     * TODO: Wrong
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
//        if (root.val == p.val || root.val == q.val) return root;
        if (root == p || root == q) return root;
        if (findNode(root.left, p)) {
            return findNode(root.right, q) ? root : lowestCommonAncestor(root.left, p, q);
        } else {
            return findNode(root.left, q) ? root : lowestCommonAncestor(root.right, p, q);
        }
    }

    private boolean findNode(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return false;
        }
        if (root == node) {
            return true;
        }

//        boolean found = findNode(root.left, node);
//        if (!found) {
//            found = findNode(root.right, node);
//        }
//        return found;
        return findNode(root.left, node) || findNode(root.right, node);
    }

    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestorRecursive(root.left, p, q);
        if (left != null) return left;
        TreeNode right = lowestCommonAncestorRecursive(root.right, p, q);
        if (right != null) return right;
        return root;
    }

    /**
     * Accepted
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode left = lowestCommonAncestorV1(root.left, p, q),
                right = lowestCommonAncestorV1(root.right, p, q);
        if (root == q || root == p || (left != null && right != null))
            return root;
        else if (left != null)
            return left;
        else if (right != null)
            return right;
        return null;
    }
}
