package com.gansuer.leetcode;

/**
 * Created by Frank on 11/20/15.
 */
public class Solution108 {

    /**
     * 1ms
     * Accepted
     * better than 10.95%
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return build(nums,0,nums.length);
    }

    /**
     * contain begin , not include end
     * @param nums
     * @param begin
     * @param end
     * @return
     */
    private TreeNode build(int[] nums, int begin, int end){
        if (begin >= end) return null;
        if (begin == end -1) return new TreeNode(nums[begin]);
        int mid = (end + begin) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums,begin,mid);
        root.right = build(nums,mid+1,end);
        return root;
    }
}
