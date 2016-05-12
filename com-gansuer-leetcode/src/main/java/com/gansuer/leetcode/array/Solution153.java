package com.gansuer.leetcode.array;

/**
 * Created by Frank on 3/23/16.
 */
public class Solution153 {

    /**
     * AC
     * 2.14%
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int min = nums[0], cur = nums[nums.length - 1];
        if (min > cur) {
            for (int i = nums.length - 1; i > 0; i--) {
                cur = nums[i];
                if (cur <= min) {
                    min = cur;
                } else {
                    break;
                }
            }
        }
        return min;
    }

    /**
     * binary search solution
     *
     * @param nums
     * @return
     */
    public int findMinX(int[] nums) {
        int low = 0, high = nums.length - 1,mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            if (nums[mid] >= nums[low] && nums[mid] >= nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low];
    }
}
