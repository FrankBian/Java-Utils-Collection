package com.gansuer.leetcode;

/**
 * Created by Frank on 8/1/15.
 */
public class Solution5 {

    /**
     * Time Limited Exceeded
     * n^2
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2){
            return s;
        }
        String longestPalindrome = "" , temp = "";
        for ( int i = 0;  i < s.length() ; i++){
            for ( int j = i+1; j < s.length(); j++){
                temp = s.substring(i,j);
                if (isPalindrome(temp) && temp.length() >= longestPalindrome.length()){
                    longestPalindrome = temp;
                }
            }
        }
        return longestPalindrome;
    }

    private boolean isPalindrome(String string){
        return new StringBuffer(string).reverse().toString().equalsIgnoreCase(string);
    }
}
