package com.gansuer.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank on 11/20/15.
 */
public class Solution257 {


    /**
     * Accepted
     * 5ms
     * better than 7.50%
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            result = new ArrayList<>();
            List<String> temp = null;
            String begin = String.valueOf(root.val);
            if (root.left == null && root.right == null) {
                result.add(begin);
            } else if (root.left == null || root.right == null) {
                temp = root.left == null ? binaryTreePaths(root.right) : binaryTreePaths(root.left);
            } else {
                temp = new ArrayList<>();
                temp.addAll(binaryTreePaths(root.left));
                temp.addAll(binaryTreePaths(root.right));

            }
            if (temp != null && temp.size() > 0) {
                for (String item : temp) {
                    result.add(begin + "->" + item);
                }
            }
        }
        return result;
    }

    /**
     * Accepted
     * 3ms
     * better than 42.59%
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePathsV1(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            buildPath(root, true, "", result);
        }
        return result;
    }

    private void buildPath(TreeNode node, boolean isRoot, String path, List<String> result) {
        String newPath = isRoot ? path + node.val : path + "->" + node.val;

        if (node.left == null && node.right == null) {
            result.add(newPath);
            return;
        }
        if (node.left != null) {
            buildPath(node.left, false, newPath, result);
        }
        if (node.right != null) {
            buildPath(node.right, false, newPath, result);
        }
    }

}
