package com.gansuer.leetcode.array;

/**
 * Created by Frank on 3/11/16.
 */
public class Solution26 {

    /**
     * Accepted
     * 54.30%
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int pre = 1, cur = 0;
        for (; pre < nums.length; pre++) {
            if (nums[pre] != nums[cur]) {
                nums[++cur] = nums[pre];
                continue;
            }
            while (pre < nums.length && nums[pre] == nums[cur]) {
                pre++;
            }
            if (pre == nums.length) break;
            nums[++cur] = nums[pre];
        }
        return cur + 1;
    }
}
