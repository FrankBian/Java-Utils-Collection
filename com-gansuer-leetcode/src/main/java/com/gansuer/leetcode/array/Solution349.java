package com.gansuer.leetcode.array;

import java.util.HashSet;

/**
 * Created by Frank on 6/23/16.
 */
public class Solution349 {

    /**
     * 7ms
     * Accepted
     * 34.14%
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> temp = new HashSet<>();
        for (int item : nums1) {
            set.add(item);
        }
        for (int item : nums2) {
            if (set.remove(item)) temp.add(item);
        }
        int[] res = new int[temp.size()];
        int index = 0;
        for (int item : temp) {
            res[index++] = item;
        }
        return res;
    }
}
