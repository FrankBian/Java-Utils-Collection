package com.gansuer.leetcode.string;

/**
 * Created by Frank on 4/21/2016.
 */
public class Solution151 {

    /**
     * Accepted
     * 3ms
     * 86.47%
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null) return s;
        s = s.trim();
        if (s.length() == 0) return s;
        String[] arrs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arrs.length - 1; i >= 0; i--) {
            if (arrs[i].trim().equals("")) continue;
            sb.append(arrs[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
