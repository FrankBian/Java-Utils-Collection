package com.gansuer.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Frank on 12/2/15.
 */
public class Solution105 {

    /**
     * Accepted
     * 24ms
     * >= 12.71%
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
        return buildV1(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int begin1, int end1, int[] inorder, int begin2, int end2) {
        if (preorder == null || inorder == null) return null;
        if (begin1 >= end1 || begin2 >= end2) return null;
        if (begin1 == end1 - 1) return new TreeNode(preorder[begin1]);
        TreeNode root = new TreeNode(preorder[begin1]);
        int indexOfRootInInorderArray = getElementIndex(inorder, preorder[begin1], begin2, end2);
        if (indexOfRootInInorderArray == begin2) {
            root.right = build(preorder, begin1 + 1, end1, inorder, indexOfRootInInorderArray + 1, end2);
        } else if (indexOfRootInInorderArray < end2 - 1) {
            int indexOfRightInPreorderArray = getRightTreeIndex(preorder,begin1+1,end1,inorder,indexOfRootInInorderArray+1, end2);
            root.left = build(preorder, begin1 + 1, indexOfRightInPreorderArray, inorder, begin2, indexOfRootInInorderArray);
            root.right = build(preorder, indexOfRightInPreorderArray, end1, inorder, indexOfRootInInorderArray + 1, end2);
        } else {
            root.left = build(preorder, begin1 + 1, end1, inorder, begin2, indexOfRootInInorderArray);
        }
        return root;
    }

    private int getElementIndex(int[] array, int element, int begin, int end) {
        if (array != null) {
            for (int i = begin; i < end; i++) {
                if (array[i] == element) return i;
            }
        }
        return -1;
    }
    private int getRightTreeIndex(int[] target, int begin, int end, int[] source, int begin1, int end1){
        Set<Integer> set = new HashSet<>();
        for (int i = begin1; i < end1; i++){
            set.add(source[i]);
        }
        for (int i = begin; i<end; i++){
            if (set.contains(target[i])){
                return i;
            }
        }
        return -1;
    }


    /**
     * optimized
     * Accepted
     * 15ms
     * >= 71.10%
     */
    private TreeNode buildV1(int[] preorder, int pb, int pe, int[] inorder, int ib,int ie){
        if (preorder == null || inorder == null) return null;
        if (pb >= pe || ib >= ie) return null;
        TreeNode root = new TreeNode(preorder[pb]);
        if (pb == pe -1) return root;
        int indexOfRootInInorderArray = getElementIndex(inorder,root.val,ib,ie);
        root.left = buildV1(preorder,pb+1,pb+1+indexOfRootInInorderArray-ib,inorder,ib,indexOfRootInInorderArray);
        root.right = buildV1(preorder,pb+1+indexOfRootInInorderArray-ib,pe,inorder,indexOfRootInInorderArray+1,ie);
        return root;
    }

    /**
     * optimized by cache
     * Accepted
     * 6ms
     * >= 79.24%
     */
    public TreeNode buildTreeV1(int[] preorder, int[] inorder){
        if (preorder == null || inorder == null || preorder.length ==0 || inorder.length ==0) return null;
        Map<Integer,Integer> inorderMap = new HashMap<>();
        for (int i = 0 ; i<inorder.length; i++){
            inorderMap.put(inorder[i],i);
        }
        return buildV2(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inorderMap);
    }

    private TreeNode buildV2(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, final Map<Integer, Integer> cache) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        if (ps == pe) return root;
        int rootIndex = cache.get(root.val);
        int offset = rootIndex - is;

        root.left = buildV2(preorder,ps+1,ps+offset,inorder,is,rootIndex-1,cache);
        root.right = buildV2(preorder,ps+offset+1,pe,inorder,rootIndex+1,ie,cache);
        return root;
    }
}
