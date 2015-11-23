package com.gansuer.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Frank on 11/23/15.
 */
public class Solution114 {

    /**
     * Accepted
     * 2ms
     * >= 23.89%
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root != null) {
            preorderTraversal(root, list);
        }
        if (list.size() > 0) {
            root = list.get(0);
            TreeNode cur = root;
            for (int i = 1; i < list.size(); i++) {
                cur.left = null;
                cur.right = list.get(i);
                cur = cur.right;
            }
        }
    }

    private void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

    /**
     * Accepted
     * 3ms
     * >= 8.18%
     * @param root
     */
    public void flattenV1(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = null;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            if (left != null) {
                node.right = left;
            } else {
                node.right = stack.isEmpty() ? right : stack.peek();
            }
        }
    }


    /**
     * 1ms
     * Accepted
     * >= 33.57%
     * @param root
     */
    public void flattenV2(TreeNode root) {
        if (root == null)
            return;
        flattenV2(root.left);
        flattenV2(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        while (root.right != null)
            root = root.right;
        root.right = right;
    }

}
