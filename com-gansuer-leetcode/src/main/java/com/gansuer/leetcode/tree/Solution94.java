package com.gansuer.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Frank on 11/20/15.
 */
public class Solution94 {

    /**
     * AC
     * 1ms
     * better than 64.96%
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            inorder(root, result);
        }
        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root.left != null) inorder(root.left, result);
        result.add(root.val);
        if (root.right != null) inorder(root.right, result);
    }

    /**
     * 2ms
     * AC
     * better than 6.70%
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalWithIterate(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    /**
     * AC
     * 2ms
     * 3.35%
     *
     * @param root
     * @return
     */
    public List<Integer> inorderX(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
