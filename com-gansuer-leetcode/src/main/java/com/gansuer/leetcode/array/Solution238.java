package com.gansuer.leetcode.array;

/**
 * Created by Frank on 3/16/16.
 */
public class Solution238 {

    /**
     * Time Limit Exceeded
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int total = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                total *= nums[j];
            }
            res[i] = total;
        }
        return res;
    }

    public int[] productExceptSelfX(int[] nums){

        return nums;
    }
}
