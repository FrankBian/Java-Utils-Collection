package com.gansuer.leetcode.string;

/**
 * Created by Frank on 7/22/16.
 */
public class Solution344 {

    /**
     * Accepted
     * 2ms
     * 90.16%
     *
     * @param s
     * @return
     */
    public String reverseString(String s) {
        if (s == null || s.length() < 2) return s;
        char[] arr = s.toCharArray();
        int low = 0, high = arr.length - 1;
        while (low < high) {
            char temp = arr[low];
            arr[low++] = arr[high];
            arr[high--] = temp;
        }
        return new String(arr);
    }
}
