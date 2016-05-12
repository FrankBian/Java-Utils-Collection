package com.gansuer.leetcode.array;

import java.util.Arrays;

/**
 * Created by Frank on 3/11/16.
 */
public class Solution88 {

    /**
     * AC
     * 5.86%
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null) return;
        for (int i = 0; i < n; i++) {
            nums1[m++] = nums2[i];
        }
        Arrays.sort(nums1, 0, m);
    }

    /**
     * AC
     * 5.86%
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeX(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        while (m > 0 && n > 0) {
            nums1[k--] = nums1[m - 1] > nums2[n - 1] ? nums1[--m] : nums2[--n];
        }
        while (n > 0) {
            nums1[k--] = nums2[--n];
        }
    }
}
