package com.gansuer.leetcode.array;

/**
 * Created by Frank on 6/21/16.
 */
public class Solution209 {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return minSubArrayLen(nums, 0, nums.length, s);
    }

    /**
     * [low,high)
     *
     * @param nums
     * @param low
     * @param high
     * @param s
     * @return
     */
    private int minSubArrayLen(int[] nums, int low, int high, int s) {
        return 0;
    }
}
