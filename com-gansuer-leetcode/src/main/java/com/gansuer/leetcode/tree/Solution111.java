package com.gansuer.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Frank on 11/20/15.
 */
public class Solution111 {

    /**
     * Accepted
     * 1ms
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 && right == 0) return 1;
        if (left == 0 || right == 0) return left > right ? left + 1 : right + 1;
        return left > right ? right + 1 : left + 1;
    }


    /**
     * From discuss forum
     *
     * @param root
     * @return
     */
    public int minDepthWithQueue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null) {
                    min = Math.min(min, level);
                    return min;
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return 0;
    }
}
