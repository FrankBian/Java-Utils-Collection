package com.gansuer.leetcode.array;

/**
 * Created by Frank on 3/11/16.
 */
public class Solution189 {

    public void rotate(int[] nums, int k) {
        if (nums == null) return;
        k = k % nums.length;
        if (k == 0) return;
        rotate(nums, 0, nums.length, k, 1);
//        rotateRight(nums, 0, nums.length, k);
    }

    /**
     * Accepted
     * 11.70%
     * @param nums
     * @param from
     * @param to
     * @param k
     * @param flag rotate to right if flag == 1, and to left if flag = -1
     */
    private void rotate(int[] nums, int from, int to, int k, int flag) {
        int len = to - from;
        if (k > len / 2) {
            rotate(nums, from, to, len - k, flag * (-1));
        } else {
            int j = to - k;
            for (int i = from; i < from + k; i++) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
            int rest = len - 2 * k;
            if (rest > 0) {
                if (flag == 1) { //right
                    from += k;
                } else { //left
                    to -= k;
                }
                rotate(nums, from, to, k, flag);
            }
            return;
        }
    }


    private void rotateLeft(int[] nums, int from, int to, int k) {
        int len = to - from;
        if (k > len / 2) {
            rotateRight(nums, from, to, len - k);
        } else {
            //do sth
            int j = to - k;
            for (int i = from; i < from + k; i++) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
            int rest = len - 2 * k;
            if (rest == 0) {
                return;
            } else {
                rotateLeft(nums, from, to - k, k);
            }
        }
    }

    /**
     * Accepted
     * 11.70%
     *
     * @param nums
     * @param from
     * @param to
     * @param k
     */
    private void rotateRight(int[] nums, int from, int to, int k) {
        int len = to - from;
        if (k > len / 2) {
            rotateLeft(nums, from, to, len - k);
        } else {
            //do sth
            int j = to - k;
            for (int i = from; i < from + k; i++) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
            int rest = len - 2 * k;
            if (rest == 0) {
                return;
            } else {
                rotateRight(nums, from + k, to, k);
            }
        }
    }
}
