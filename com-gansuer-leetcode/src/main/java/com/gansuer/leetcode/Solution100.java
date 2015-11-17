package com.gansuer.leetcode;


/**
 * Created by Frank on 11/17/15.
 */
public class Solution100 {

    /**
     * Accepted
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q ){
        if (p == q) return true;
        if (p == null || q == null ) return false;
        if (p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
}
