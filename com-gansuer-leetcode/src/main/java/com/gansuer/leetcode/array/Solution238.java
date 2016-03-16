package com.gansuer.leetcode.array;

/**
 * Created by Frank on 3/16/16.
 */
public class Solution238 {

    /**
     * TODO : correct
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int total = 1;
        for (int item : nums) {
            if (item == 0) continue;
            total *= item;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            nums[i] = total / nums[i];
        }
        return nums;
    }
}
