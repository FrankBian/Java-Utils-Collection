package com.gansuer.leetcode.hashtable;

import java.util.*;

/**
 * Created by Frank on 7/20/16.
 */
public class Solution347 {

    /**
     * Accepted
     * 155ms
     * 1.03%
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, (a, b) -> a.getValue() - b.getValue());
        List<Integer> res = new ArrayList<>();
        for (int i = entryList.size() - 1; i >= 0; i--) {
            if (res.size() == k) return res;
            res.add(entryList.get(i).getKey());
        }
        return res;
    }


    /**
     * Accepted
     * 31ms
     * 77.98%
     * O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequentX(int[] nums, int k) {
        Map<Integer, Integer> frequentMap = new HashMap<>();
        for (int num : nums) {
            frequentMap.put(num, frequentMap.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : frequentMap.entrySet()) {
            int val = entry.getValue();
            if (bucket[val] == null) bucket[val] = new ArrayList<>();
            bucket[val].add(entry.getKey());
        }
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null) continue;
            for (Integer item : bucket[i]) {
                if (res.size() == k) return res;
                res.add(item);
            }
        }
        return res;
    }
}
