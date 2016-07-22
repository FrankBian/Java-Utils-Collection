package com.gansuer.leetcode.array;

/**
 * Created by Frank on 7/22/16.
 */
public class Solution283 {

    /**
     * Accepted
     * 1ms
     * 24.01%
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int cur = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (cur >= 0) {
                    nums[cur++] = nums[i];
                    nums[i] = 0;
                    while (nums[cur] != 0) {
                        cur++;
                    }
                }
            } else if (cur < 0) cur = i;
        }
    }
}
