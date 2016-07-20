package com.gansuer.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    /**
     * Accepted
     * 284ms
     * 0.04%
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int index1, index2, tmp;
        for (int i = 0; i < nums.length - 1; i++) {
            index1 = i;
            index2 = -1;
            tmp = target - nums[index1];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == tmp) {
                    index2 = j;
                    break;
                }
            }
            if (index2 >= 0) {
                return new int[]{index1, index2};
            }
        }
        return null;
    }


    /**
     * Accepted
     * 6ms
     * 62.96%
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumByHashTable(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                if (i < map.get(target - nums[i])) {
                    res[0] = i;
                    res[1] = map.get(target - nums[i]);
                } else {
                    res[0] = map.get(target - nums[i]);
                    res[1] = i;
                }
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
    //
    //public int[] twoSumByTwoPointer(int[] nums, int target) {
    //    if (nums == null || nums.length < 2) return null;
    //    Arrays.sort(nums);
    //    int low = 0, high = nums.length - 1;
    //    while (low < high) {
    //        int val = nums[low] + nums[high];
    //        if (val == target) {
    //            return new int[]{low, high};
    //        } else if (val > target) {
    //            high--;
    //        } else {
    //            low++;
    //        }
    //    }
    //    return null;
    //}
}