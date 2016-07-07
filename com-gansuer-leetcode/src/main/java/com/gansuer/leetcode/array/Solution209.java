package com.gansuer.leetcode.array;

/**
 * Created by Frank on 6/21/16.
 */
public class Solution209 {
    //
    ///**
    // * TODO: Time Limit Exceeded
    // *
    // * @param s
    // * @param nums
    // * @return
    // */
    //public int minSubArrayLen(int s, int[] nums) {
    //    if (nums == null || nums.length == 0) return 0;
    //    int sum = 0;
    //    for (int item : nums) sum += item;
    //    return minSubArrayLen(nums, 0, nums.length, sum, s);
    //}
    //
    //
    ///**
    // * [low,high)
    // *
    // * @param nums
    // * @param low
    // * @param high
    // * @param sum
    // * @param target
    // * @return
    // */
    //private int minSubArrayLen(int[] nums, int low, int high, int sum, int target) {
    //    if (low >= high) return 0;
    //    int len = high - low;
    //    if (sum < target) return 0;
    //    else if (sum == target) return len;
    //    else {
    //        if (len == 1) return 1;
    //        int left = minSubArrayLen(nums, low, high - 1, sum - nums[high - 1], target);
    //        int right = minSubArrayLen(nums, low + 1, high, sum - nums[low], target);
    //        if (left == 0 && right == 0) return high - low;
    //        else if (left == 0) return right;
    //        else if (right == 0) return left;
    //        else return left <= right ? left : right;
    //    }
    //}

    /**
     * Accepted
     * 1ms
     * 16.39%
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int low = 0, high = 0, sum = 0, res = Integer.MAX_VALUE;
        while (high < nums.length) {
            sum += nums[high++];
            while (sum >= target && low < high) { //[low,high)
                res = Math.min(res, high - low);
                sum -= nums[low++];
            }
        }
        return res != Integer.MAX_VALUE ? res : 0;
    }
}
