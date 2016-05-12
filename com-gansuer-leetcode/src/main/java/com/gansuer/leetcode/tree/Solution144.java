package com.gansuer.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Frank on 11/20/15.
 */
public class Solution144 {

    /**
     * 1ms
     * AC
     * better than 61.95%
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> vals) {
        if (root != null) {
            vals.add(root.val);
            preorder(root.left, vals);
            preorder(root.right, vals);
        }
    }


    /**
     * AC
     * 2ms
     * better than 4.32%
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalWithIterate(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return result;
    }

}
