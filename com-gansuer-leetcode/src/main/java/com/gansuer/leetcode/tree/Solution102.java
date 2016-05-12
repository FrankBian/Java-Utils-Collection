package com.gansuer.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Frank on 11/20/15.
 */
public class Solution102 {


    /**
     * AC
     * 3ms
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            result = new ArrayList<>();
            List<Integer> temp = null;
            List<TreeNode> children = new ArrayList<>();
            children.add(root);
            while (children != null && children.size() > 0) {
                temp = new ArrayList<>();
                for (TreeNode item : children) {
                    temp.add(item.val);
                }
                result.add(temp);
                children = BinaryTreeHelper.getChildren(children);
            }
        }
        return result;
    }

    /**
     * 2ms
     * AC
     * better than 71.93% java solutions
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderWithQueue(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    temp.add(cur.val);
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
                result.add(temp);
            }
        }
        return result;
    }

}
