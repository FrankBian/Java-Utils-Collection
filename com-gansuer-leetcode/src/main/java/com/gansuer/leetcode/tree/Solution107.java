package com.gansuer.leetcode.tree;

import com.gansuer.leetcode.tree.BinaryTreeHelper;
import com.gansuer.leetcode.tree.TreeNode;

import java.util.*;

/**
 * Created by Frank on 11/19/15.
 */
public class Solution107 {

    /**
     * Accepted
     * without queue solution
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            Collections.reverse(result);
        }
        return result;
    }


    /**
     * Accepted
     * with queue solution
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottomWithQueue(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            result.add(0, list);
        }
        return result;

    }
}
