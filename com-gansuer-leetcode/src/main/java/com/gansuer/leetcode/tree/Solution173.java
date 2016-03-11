package com.gansuer.leetcode.tree;

import com.gansuer.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Frank on 11/22/15.
 */
public class Solution173 {

    /**
     * Accepted
     * 62ms
     * better than 0.69% solutions
     */
    static class BSTIterator {

        private TreeNode root;
        private int index = 0;
        private List<TreeNode> nodeList = null;

        public BSTIterator(TreeNode root) {
            this.root = root;
            this.nodeList = new LinkedList<>();
            init();
        }

        /**
         * inorder traversal
         */
        private void init() {
            if (root != null) {
                inorder(root);
            }
        }

        private void inorder(TreeNode root) {
            if (root.left != null) inorder(root.left);
            nodeList.add(root);
            if (root.right != null) inorder(root.right);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return index < nodeList.size();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return nodeList.get(index++).val;
        }
    }

    /**
     * 8ms
     * >= 10.87% solutions
     */
    static class BSTIteratorV1 {

        private Stack<TreeNode> stack = null;

        public BSTIteratorV1(TreeNode root) {
            this.stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            if (hasNext()) {
                TreeNode temp = stack.pop();
                int res = temp.val;
                if (temp.right != null) {
                    temp = temp.right;
                    while (temp != null) {
                        stack.push(temp);
                        temp = temp.left;
                    }
                }
                return res;
            }
            return Integer.MAX_VALUE;
        }
    }
}
