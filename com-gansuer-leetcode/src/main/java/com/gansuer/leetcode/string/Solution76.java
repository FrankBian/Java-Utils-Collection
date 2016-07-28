package com.gansuer.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Frank on 7/28/16.
 */
public class Solution76 {

    /**
     * TODO : incorrect
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length())
            return "";
        Set<Character> tSet = new HashSet<>();
        char[] tcahrs = t.toCharArray();
        for (Character ch : tcahrs)
            tSet.add(ch);
        char[] schars = s.toCharArray();
        int pre = -1;
        String min = s;
        Set<Character> sset = new HashSet<>();
        boolean flag = false;
        for (int i = 0; i < schars.length; i++) {
            sset.add(schars[i]);
            if (pre == -1 && tSet.contains(schars[i])) { //first occur
                pre = i;
            }
            if (sset.containsAll(tSet)) {
                flag = true;
                String temp = s.substring(pre, i + 1);
                min = temp.length() < min.length() ? temp : min;
                sset.clear();
                for (int k = pre + 1; k <= i; k++) {
                    if (tSet.contains(schars[k])) {
                        pre = k;
                        break;
                    }
                }
                for (int k = pre; k <= i; k++) {
                    sset.add(schars[k]);
                }
            }
        }
        return flag ? min : "";
    }
}
