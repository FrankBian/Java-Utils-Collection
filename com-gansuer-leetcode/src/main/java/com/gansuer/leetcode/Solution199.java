package com.gansuer.leetcode;

import java.util.*;

/**
 * Created by Frank on 11/22/15.
 */
public class Solution199 {

    /**
     * level order traversal,and return the last node per level
     * Accepted
     * 3ms
     * >= 18.55%
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideViewV0(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                TreeNode temp = null;
                for (int i = 0; i < size; i++) {
                    temp = queue.poll();
                    if (temp.left != null) queue.offer(temp.left);
                    if (temp.right != null) queue.offer(temp.right);
                }
                result.add(temp.val);
            }
        }
        return result;
    }


    /**
     * the recursive solution
     * Accepted
     * 2ms
     * >= 63.43%
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList list = new ArrayList();
        rightSideView(root, 0, list);
        return list;
    }

    public void rightSideView(TreeNode root, int level, ArrayList list) {
        if (root == null) return;
        if (list.size() == level) list.add(root.val);
        rightSideView(root.right, level + 1, list);
        rightSideView(root.left, level + 1, list);
    }
}
