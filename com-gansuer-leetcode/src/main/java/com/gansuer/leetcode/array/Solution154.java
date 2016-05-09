package com.gansuer.leetcode.array;

/**
 * Created by Frank on 5/9/16.
 */
public class Solution154 {

    /**
     * Accepted
     * 1ms
     * 5.33%
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        assert nums != null;
        int low = 0, high = nums.length - 1, mid = 0;
        while (low < high) {
            if (nums[low] == nums[high]) {
                high--;
            } else if (nums[low] < nums[high]) {
                high = low;
            } else {
                mid = (low + high) / 2;
                if (nums[mid] <= nums[high]) {
                    high = mid;
                } else if (nums[mid] >= nums[low]) {
                    low = mid + 1;
                }
            }
        }
        return nums[low];
    }

    /**
     * Accepted
     * 1ms
     * 5.33%
     *
     * @param nums
     * @return
     */
    public int findMinX(int[] nums) {
        int low = 0, mid, high = nums.length - 1;
        while (low < high) {
            mid = (high + low) / 2;
            if (nums[mid] > nums[high]) low = mid + 1;
            else if (nums[mid] == nums[high]) high--;
            else high = mid;
        }
        return nums[low];
    }
}
