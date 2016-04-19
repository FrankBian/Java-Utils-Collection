package com.gansuer.leetcode.array;

/**
 * Created by Frank on 3/16/16.
 */
public class Solution53 {

    /**
     * Time Limit Exceeded
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * TODO : correct
     *
     * @param nums
     * @return
     */
    public int maxSubArrayX(int[] nums) {
        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; ) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
                i++;
            } else {

            }
        }
        return max;
    }
}
