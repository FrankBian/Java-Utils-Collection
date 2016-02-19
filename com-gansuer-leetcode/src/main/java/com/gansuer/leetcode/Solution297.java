package com.gansuer.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Frank on 1/17/16.
 */
public class Solution297 {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue queue = new LinkedList();
        queue.offer(root);
        TreeNode cur = root;
        while (cur != null) {

        }
        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) return null;
        return null;
    }
}
