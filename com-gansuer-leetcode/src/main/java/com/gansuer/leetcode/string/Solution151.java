package com.gansuer.leetcode.string;

/**
 * Created by Frank on 4/21/2016.
 */
public class Solution151 {

    /**
     * AC
     * 3ms
     * 86.47%
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null) return s;
        //s = s.replaceAll("([\\s\\t\\r]+)", " ");  18ms/27.65%
        String[] arr = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].trim().length() == 0) continue;
            stringBuilder.append(arr[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    /**
     * 25ms
     * Accepted
     * 23.66%
     *
     * @param s
     * @return
     */
    public String reverse(String s) {
        if (s == null || s.length() == 0) return s;
        s = s.replaceAll("([\\s\\t\\r]+)", " ");
        char[] chs = s.trim().toCharArray();
        reverse(chs, 0, chs.length);
        int begin = 0, end = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                reverse(chs, begin, end);
                begin = i + 1;
                end = i + 1;
            } else {
                end++;
            }
        }
        reverse(chs, begin, end);
        return new String(chs);
    }

    /**
     * [begin,end)
     *
     * @param chars
     * @param begin
     * @param end
     */
    private void reverse(char[] chars, int begin, int end) {
        for (int i = begin, j = end - 1; i <= j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
}
