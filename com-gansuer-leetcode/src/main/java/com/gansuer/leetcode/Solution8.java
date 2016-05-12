package com.gansuer.leetcode;

/**
 * Created by Frank on 7/27/15.
 */
public class Solution8 {


    /**
     * AC
     * 1045/1045 test cases passed
     * 365ms
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if (str == null || str.trim().equals("")) {
            return 0;
        }
        str = str.trim();
        int result = 0;
        boolean negative = false;
        int i = 0, len = str.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        char firstChar = str.charAt(0);
        if (firstChar < '0') { // Possible leading "+" or "-"
            if (firstChar == '-') {
                negative = true;
                limit = Integer.MIN_VALUE;
            } else if (firstChar != '+')
                return 0;

            if (len == 1) // Cannot have lone "+" or "-"
                return 0;
            i++;
        }
        multmin = limit / 10;
        while (i < len) {
            digit = Character.digit(str.charAt(i++), 10);
            if (digit < 0) {
                return negative ? result : -result;
            }
            if (result < multmin) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result *= 10;
            if (result < limit + digit) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result -= digit;
        }
        return negative ? result : -result;
    }
}
