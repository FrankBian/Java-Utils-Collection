package com.gansuer.leetcode.tree;

import java.util.*;

/**
 * Created by Frank on 12/2/15.
 */
public class Solution103 {

    /**
     * 3ms
     * Accepted
     * >= 14.53%
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<Integer> item = null;
            while (!queue.isEmpty()) {
                int size = queue.size();
                item = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    item.add(cur.val);
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
                result.add(item);
            }
            for (int i = 0; i < result.size(); i++) {
                if (i % 2 == 1) {
                    Collections.reverse(result.get(i));
                }
            }
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrderV1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<Integer> item = null;
            boolean order = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                item = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    if (order) {
                        item.add(cur.val);
                    } else {
                        item.add(0, cur.val);
                    }
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
                result.add(item);
                order = !order;
            }
        }
        return result;
    }
}
