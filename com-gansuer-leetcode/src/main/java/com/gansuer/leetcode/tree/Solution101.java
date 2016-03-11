package com.gansuer.leetcode.tree;

import com.gansuer.leetcode.tree.TreeNode;

/**
 * Created by Frank on 11/17/15.
 */
public class Solution101 {

    /**
     * Accepted  : 1ms
     * symmetric -- 对称的
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeNode root1 = clone(root);
        TreeNode invertedTree = invertTree(root1);
        return isEquals(root, invertedTree);
    }

    private TreeNode clone(TreeNode root) {
        if (root == null) return null;
        TreeNode res = new TreeNode(root.val);
        res.left = clone(root.left);
        res.right = clone(root.right);
        return res;
    }

    private TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left),
                right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * compare based on the value of node
     *
     * @param tree1
     * @param tree2
     * @return
     */
    private boolean isEquals(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null || tree2 == null) {
            return tree1 == tree2;
        }
        return tree1.val == tree2.val && isEquals(tree1.left, tree2.left) && isEquals(tree1.right, tree2.right);
    }

    /**
     * the best solution
     */
    public boolean isSymmetricV1(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (p.val == q.val) && isSame(p.left, q.right) && isSame(p.right, q.left);
    }
}
