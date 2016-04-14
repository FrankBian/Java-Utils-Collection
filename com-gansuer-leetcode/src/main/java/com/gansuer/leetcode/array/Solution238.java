package com.gansuer.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Frank on 3/16/16.
 */
public class Solution238 {

    /**
     * Time Limit Exceeded
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int total = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                total *= nums[j];
            }
            res[i] = total;
        }
        return res;
    }

    /**
     * Accepted
     * 11.83%
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelfX(int[] nums) {
        int total = 1;
        Set<Integer> zeros = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros.add(i);
            } else {
                total *= nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = zeros.size() > 1 ? 0 : total;
            } else {
                nums[i] = zeros.size() > 0 ? 0 : total / nums[i];
            }
        }
        return nums;
    }
}
