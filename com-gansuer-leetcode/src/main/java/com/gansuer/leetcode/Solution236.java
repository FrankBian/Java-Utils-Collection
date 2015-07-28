package com.gansuer.leetcode;

/**
 * Created by Frank on 7/27/15.
 */
public class Solution236 {

    /**
     * Accepted
     * 31/31 test cases passed
     * 1076 ms
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }

        if (findNode(root.left , p)){
            if (findNode(root.right, q)){
                return root;
            }else {
                return lowestCommonAncestor(root.left,p,q);
            }
        }else{
            if (findNode(root.left, q)){
                return root;
            }else{
                return lowestCommonAncestor(root.right,p,q);
            }

        }
    }

    private boolean findNode(TreeNode root , TreeNode node){
        if (root == null || node == null){
            return false;
        }
        if (root == node){
            return true;
        }

        boolean found = findNode(root.left , node);
        if ( !found){
            found = findNode(root.right, node);
        }
        return found;
    }
}
