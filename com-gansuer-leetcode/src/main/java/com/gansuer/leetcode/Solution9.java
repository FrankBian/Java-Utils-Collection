package com.gansuer.leetcode;

/**
 * Created by Frank on 7/30/15.
 */
public class Solution9 {

    /**
     * Accepted
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int temp = Math.abs(x);
        String str = String.valueOf(temp);

        int len = str.length() , i = 0 , j = len - 1 ;
        for (; i <= j;){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * Accepted
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x){
        String temp = String.valueOf(x);
        return new StringBuffer(temp).reverse().toString().equalsIgnoreCase(temp);
    }
}
