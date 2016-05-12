package com.gansuer.leetcode.array;

/**
 * Created by Frank on 4/18/16.
 */
public class Solution4 {

    /**
     * Merge this two array, and return the median
     * <p>
     * AC
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] total = new int[nums1.length + nums2.length];
        int cur1 = 0, cur2 = 0, cur = 0;
        while (cur1 < nums1.length && cur2 < nums2.length) {
            total[cur++] = nums1[cur1] < nums2[cur2] ? nums1[cur1++] : nums2[cur2++];
        }
        while (cur1 < nums1.length) {
            total[cur++] = nums1[cur1++];
        }
        while (cur2 < nums2.length) {
            total[cur++] = nums2[cur2++];
        }
        return median(total, 0, cur);
    }

    /**
     * [from,to)
     *
     * @param nums
     * @return
     */
    private double median(int[] nums, int from, int to) {
        int len = to - from, mid = (from + to) / 2;
        if (len % 2 == 0) {
            return (nums[mid - 1] + nums[mid]) / 2.0;
        }
        return nums[mid];
    }


    /**
     * O(log(m + n))
     * AC
     * 40.63%
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArraysX(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, total = len1 + len2;
        if (total % 2 != 0) {
            return getKthSmallest(nums1, 0, nums2, 0, total / 2 + 1);
        }
        return (getKthSmallest(nums1, 0, nums2, 0, total / 2) +
                getKthSmallest(nums1, 0, nums2, 0, total / 2 + 1)) / 2.0;
    }

    /**
     * find the Kth smallest number from two sorted arrays ,
     * k is [1...N] , and N = nums1.length + nums2.length
     *
     * @param nums1
     * @param begin1
     * @param nums2
     * @param begin2
     * @param k
     * @return
     */
    private double getKthSmallest(int[] nums1, int begin1, int[] nums2, int begin2, int k) {
        if (begin1 >= nums1.length) return nums2[begin2 + k - 1];
        if (begin2 >= nums2.length) return nums1[begin1 + k - 1];
        if (k == 1) return Math.min(nums1[begin1], nums2[begin2]);

        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
        if (begin1 + k / 2 - 1 < nums1.length) mid1 = nums1[begin1 + k / 2 - 1];
        if (begin2 + k / 2 - 1 < nums2.length) mid2 = nums2[begin2 + k / 2 - 1];
        if (mid1 < mid2) {
            begin1 += k / 2;
        } else {
            begin2 += k / 2;
        }
        return getKthSmallest(nums1, begin1, nums2, begin2, k - k / 2);
    }


}
