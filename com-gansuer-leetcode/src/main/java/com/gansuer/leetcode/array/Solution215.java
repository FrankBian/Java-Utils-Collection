package com.gansuer.leetcode.array;

/**
 * Created by Frank on 3/23/16.
 */
public class Solution215 {

    /**
     * Accepted
     * 18.65%
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        assert nums != null;
        assert k >= 1 && k <= nums.length;

        int low = 0, high = nums.length - 1;
        while (low < high) {
            int index = partition(nums, low, high);
            if (index == k - 1) break;
            else if (index < k) low = index + 1;
            else high = index - 1;

        }
        return nums[k - 1];
    }

    /**
     * quick sort
     *
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] nums, int low, int high) {
        int key = nums[low];
        while (low < high) {
            while (low < high && nums[high] < key) {
                high--;
            }
            if (low < high) nums[low++] = nums[high];

            while (low < high && nums[low] > key) {
                low++;
            }
            if (low < high) nums[high--] = nums[low];
        }
        nums[low] = key;
        return low;
    }
}
