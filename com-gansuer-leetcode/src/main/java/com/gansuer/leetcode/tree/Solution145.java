package com.gansuer.leetcode.tree;

import java.util.*;

/**
 * Created by Frank on 5/12/16.
 */
public class Solution145 {


    /**
     * AC
     * 1ms
     * 70.01%
     * recursive
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
    }

    /**
     * AC
     * 3ms
     * 0.86%
     *
     * @param root
     * @return
     */
    @Deprecated
    public List<Integer> postorderTraversalIterater(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> handled = new HashSet<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (handled.contains(top)) {
                res.add(top.val);
                stack.pop();
            } else {
                if (top.left == null && top.right == null) {
                    res.add(top.val);
                    stack.pop();
                } else {
                    handled.add(top);

                    if (top.right != null) {
                        stack.push(top.right);
                    }
                    if (top.left != null) {
                        stack.push(top.left);
                    }
                }

            }
        }
        return res;
    }

    /**
     * AC
     * 2ms
     * 7.50%
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalIteraterX(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top != null) {
                res.add(top.val);
                stack.push(top.left);
                stack.push(top.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * AC
     * 2ms
     * 7.50%
     *
     * @param root
     * @return
     */
    public List<Integer> postIteraterBest(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            res.add(0, top.val);
            if (top.left != null) stack.push(top.left);
            if (top.right != null) stack.push(top.right);
        }
        return res;
    }
}
