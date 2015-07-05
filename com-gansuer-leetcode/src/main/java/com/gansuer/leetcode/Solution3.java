package com.gansuer.leetcode;

/**
 * Created by Frank on 7/5/15.
 */
public class Solution3 {

    /**
     * O(n^2)
     * Last executed error : Time Limit Exceeded
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int max = 0;
        char[] strings = s.toCharArray();
        for(int i = 0; i < strings.length ; i++){
            String tmp = strings[i]+"";
            for (int j = i+1; j < strings.length; j++){
                if (tmp.indexOf(strings[j]) < 0){ // No Repeats
                    tmp += strings[j];
                }else {
                    break;
                }
            }
            max = tmp.length() > max ? tmp.length() : max;
        }
        return max;
    }

    /**
     * Time Limit Exceeded
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringV2(String s){
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0 , begin = 0 , end = 0;
        String temp = "";
        char[] chars = s.toCharArray();
        while ( end < chars.length){
            if (temp.indexOf(chars[end]) < 0){
                temp += chars[end];
                end++;
            }else{
                max = temp.length() > max ? temp.length() : max ;
                end = ++begin;
                temp = "";
            }
        }
        max = temp.length() > max ? temp.length() : max ;
        return max;
    }

    /**
     * accepted
     * 981/981 test cases passed
     * 444ms
     *
     * this solution from discuss
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringV3(String s) {
        int max = 0, j = 1;
        for (int i = 0; i < s.length(); i++) {
            for (; j <= s.length(); j++) {
                if (i == j) continue;
                String sub = s.substring(i, j);
                if (sub.indexOf(s.charAt(j-1)) == sub.length() - 1) {
                    // enhancement by me
                    max = j-i > max ? j-i : max;
//                    if (max < j-i){
//                        max = j-i;
//                    }
                }
                else {
                    break;
                }
            }
        }
        return max;
    }

    /**
     * accepted
     * 981/981 test cases passed
     * 436ms
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringV4(String s){
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0 , begin = 0 , end = 0;
        while (end < s.length()+1){
            if (begin == end){
                end++;
                continue;
            }
            String sub = s.substring(begin,end);
            if (sub.indexOf(s.charAt(end-1)) == sub.length() - 1){
                max = (end-begin) > max ? (end-begin) : max;
                end++;
            }else{
                begin++;
            }
        }

        return max;
    }
}
