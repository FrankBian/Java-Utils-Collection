package com.gansuer.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Frank on 11/17/15.
 */
public class BinaryTreeHelper {


    public static TreeNode buildBinaryTree(Integer[] input) {
        if (input == null || input.length == 0 || input[0] == null) return null;
        TreeNode root = new TreeNode(input[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (index < input.length) {
                if (input[index] != null) {
                    TreeNode left = new TreeNode(input[index]);
                    cur.left = left;
                    queue.offer(left);
                }
                index++;
            }
            if (index < input.length) {
                if (input[index] != null) {
                    TreeNode right = new TreeNode(input[index]);
                    cur.right = right;
                    queue.offer(right);
                }
                index++;
            }
        }
        return root;
    }

    public static void printBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            System.out.print(point.val + ",");

            if (point.left != null) {
                queue.add(point.left);
            }
            if (point.right != null) {
                queue.add(point.right);
            }
        }
        queue.clear();
    }

    public static List<TreeNode> getChildren(List<TreeNode> parents) {
        List<TreeNode> res = null;
        if (parents != null && parents.size() > 0) {
            res = new ArrayList<>();
            for (TreeNode item : parents) {
                if (item.left != null) res.add(item.left);
                if (item.right != null) res.add(item.right);
            }
        }
        return res;
    }

    public static List<List<TreeNode>> levelOrder(TreeNode root) {
        List<List<TreeNode>> result = null;
        if (root != null) {
            result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<TreeNode> temp = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    temp.add(cur);
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
                result.add(temp);
            }
        }
        return result;
    }

}
