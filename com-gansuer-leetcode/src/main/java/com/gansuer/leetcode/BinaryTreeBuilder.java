package com.gansuer.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Frank on 11/17/15.
 */
public class BinaryTreeBuilder {

    private static Queue<TreeNode> queue = new ArrayDeque<>();

    public static TreeNode buildBinaryTree(Integer[] input) {
        if (input == null || input.length == 0 || input[0] == null) return null;
        if (input.length == 1) return new TreeNode(input[0]);
        queue.add(new TreeNode(input[0]));
        TreeNode root = queue.poll(), point = root, temp = null;
        for (int i = 1; i < input.length - 1; i = i + 2) {
            if (input[i] != null) {
                temp = new TreeNode(input[i]);
                point.left = temp;
                queue.add(temp);
            }
            if (input[i + 1] != null) {
                temp = new TreeNode(input[i + 1]);
                point.right = temp;
                queue.add(temp);
            }
            point = queue.poll();
        }
        queue.clear();
        return root;
    }

    public static void printBinaryTree(TreeNode root) {
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
}
