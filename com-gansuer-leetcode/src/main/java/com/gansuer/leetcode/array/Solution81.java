package com.gansuer.leetcode.array;

/**
 * Created by Frank on 4/15/16.
 */
public class Solution81 {

    /**
     * AC
     * 21.80%
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        return search(nums, 0, nums.length - 1, target);
    }

    private boolean search(int[] arr, int from, int to, int target) {
        if (from > to) return false;
        if (arr[from] == target) return true;
        if (arr[to] == target) return true;
        int mid = (from + to) / 2;
        if (arr[mid] == target) return true;
        if (search(arr, from, mid - 1, target)) return true;
        return search(arr, mid + 1, to, target);
    }


    /**
     * AC
     * 2.06%
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean searchX(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < nums[high]) {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > nums[high]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = low + 1;
                }
            } else {
                high--;
            }
        }
        return false;
    }
}
