package com.gansuer.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Frank on 6/23/16.
 */
public class Solution350 {

    /**
     * 8ms
     * Accepted
     * 37.86
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for (int item : nums1) {
            if (cache.containsKey(item)) cache.put(item, cache.get(item) + 1);
            else cache.put(item, 1);
        }
        for (int item : nums2) {
            if (!cache.containsKey(item)) continue;
            int val = cache.get(item);
            if (val == 0) {
                cache.remove(item);
            } else {
                cache.put(item, val - 1);
                temp.add(item);
            }
        }
        int len = temp.size();
        int[] res = new int[len];
        for (int item : temp) {
            res[--len] = item;
        }
        return res;
    }
}
