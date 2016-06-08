package com.gansuer.leetcode.array;

/**
 * Created by Frank on 5/9/16.
 */
public class Solution152 {

    /**
     * Accepted
     * 4ms
     * 46.04%
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = min[0] = nums[0];
        int res = max[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = max(nums[i], nums[i] * max[i - 1], nums[i] * min[i - 1]);
            min[i] = min(nums[i], nums[i] * max[i - 1], nums[i] * min[i - 1]);
            res = res > max[i] ? res : max[i];
        }
        return res;
    }

    private int max(int a, int b, int c) {
        int temp = a > b ? a : b;
        return temp > c ? temp : c;
    }

    private int min(int a, int b, int c) {
        int temp = a < b ? a : b;
        return temp < c ? temp : c;
    }


    /**
     * Accepted
     */
    public int maxProductX(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        int n = nums.length;
        int preMin, preMax;
        int curMin, curMax;
        preMin = preMax = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] >= 0) {
                curMin = preMin <= 0 ? preMin * nums[i] : nums[i];
                curMax = preMax > 0 ? preMax * nums[i] : nums[i];
            } else {
                curMax = preMin <= 0 ? preMin * nums[i] : nums[i];
                curMin = preMax > 0 ? preMax * nums[i] : nums[i];
            }
            res = res > curMax ? res : curMax;
            preMin = curMin;
            preMax = curMax;
        }
        return res;
    }

    /**
     * Accepted
     * 4ms
     * 46.04%
     *
     * @param nums
     * @return
     */
    public int maxProductXB(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        int max = nums[0], min = nums[0], totalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = nums[i] * max;
            int tempMin = nums[i] * min;
            max = Math.max(Math.max(tempMax, tempMin), nums[i]);
            min = Math.min(Math.min(tempMax, tempMin), nums[i]);
            totalMax = Math.max(totalMax, max);
        }
        return totalMax;
    }

}
