package com.gansuer.leetcode.tree;

import com.gansuer.leetcode.tree.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution226 {

    /**
     * Accepted
     * 68/68 test cases passeed
     * 348 ms
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);
        return root;
    }

    /**
     * Accepted
     * 68/68 test cased passed
     * 348 ms
     *
     * @param root
     * @return
     */
    public TreeNode invertTree_No_Recursive(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            stack.pop();
            if (node.left != null || node.right != null) {
                TreeNode tmp = node.right;
                node.right = node.left;
                node.left = tmp;
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return root;
    }
}

