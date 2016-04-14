package com.gansuer.leetcode.array;

/**
 * Created by Frank on 3/23/16.
 */
public class Solution80 {


    /**
     * Accepted
     * 6.71%
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        assert nums != null;
        if (nums.length < 3) return nums.length;
        int cur = 0, pre = 1, count = 1;
        for (; pre < nums.length; ) {
            if (nums[cur] == nums[pre]) {
                count++;
            } else if (count >= 2) {
                count = 1;
            }
            if (count > 2) {
                pre++;
            } else {
                nums[++cur] = nums[pre++];
            }
        }
        return cur + 1;
    }
}
