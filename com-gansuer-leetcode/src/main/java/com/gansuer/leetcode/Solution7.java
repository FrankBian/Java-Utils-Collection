package com.gansuer.leetcode;

/**
 * Created by Frank on 7/21/15.
 */
public class Solution7 {

    /**
     * accepted
     * 1032 / 1032 test cases passed
     * 356 ms
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        boolean isNegative = x < 0;
        long xl = x;
        xl = Math.abs(xl);
        String temp = String.valueOf(xl);
        String res = "";
        for (int i = temp.length() - 1; i >= 0; i--) {
            res += temp.charAt(i);
        }

        long reverse = Long.parseLong(res);
        if (reverse > Integer.MAX_VALUE || Integer.MIN_VALUE > 0 - reverse) {
            return 0;
        }
        return isNegative ? (int) reverse*(-1) : (int) reverse;
    }

    /**
     * @param x
     * @return
     */
    @Deprecated
    public int reverse1 (int x){
        return Integer.reverseBytes(x);
    }

    /**
     * Accepted
     * 1032 / 1032 test cases passed
     * 236 ms
     * @param x
     * @return
     */
    public int reverse2(int x) {
        boolean negative = false;
        int res = 0;
        if(x < 0)  {
            if(x == Integer.MIN_VALUE) return 0;
            x = -x;
            negative = true;
        }
        while(x / 10 != 0) {
            res = 10 * res + x % 10;
            if(res > Integer.MAX_VALUE / 10) return 0;
            x /= 10;
        }
        res = 10 * res + x;
        return negative ? -res : res;
    }
}
