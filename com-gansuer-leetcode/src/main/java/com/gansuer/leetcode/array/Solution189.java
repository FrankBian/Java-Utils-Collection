package com.gansuer.leetcode.array;

/**
 * Created by Frank on 3/11/16.
 */
public class Solution189 {

    public void rotate(int[] nums, int k) {
        //if (nums == null) return;
        //// validate k
        //k = k % nums.length;
        //if (k == 0) return;
        //int i = 0, change = 0, cache = nums[i];
        //while (change <= nums.length) {
        //    int next = (i + k) % nums.length;
        //    int tmp = nums[next];
        //    nums[next] = cache;
        //    cache = tmp;
        //    i = next;
        //    change++;
        //}
        if (nums == null) return;
        k = k % nums.length;
        if (k == 0) return;
        rotate(nums, 0, nums.length, k);
    }

    private void rotate(int[] nums, int from, int to, int k) {
        int len = to - from, left = len - k, rest = left - k;
        if (rest <= 0) return;
        int j = len - k;
        for (int i = 0; i < k; i++) {
            int tmp = nums[j];
            nums[j] = nums[from + i];
            nums[from + i] = tmp;
            j++;
        }
        rotate(nums, from + k, to, k);
    }
}
