package com.gansuer.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Frank on 7/5/15.
 */
public class Solution3 {

    /**
     * Accepted
     * 18ms
     * 61.21%
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        int max = Integer.MIN_VALUE;
        char[] strings = s.toCharArray();
        String temp = "";
        //int tempBegin = 0;
        for (int i = 0; i < strings.length; i++) {
            int index = temp.indexOf(strings[i]);
            if (index >= 0) {
                max = max < temp.length() ? temp.length() : max;
                temp = temp.substring(index + 1);
                //tempBegin += index+1;
            }
            temp += strings[i];
        }
        return max < temp.length() ? temp.length() : max;
    }

    /**
     * AC
     * 981/981 test cases passed
     * 444ms
     * <p>
     * this solution from discuss
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringV3(String s) {
        int max = 0, j = 1;
        for (int i = 0; i < s.length(); i++) {
            for (; j <= s.length(); j++) {
                if (i == j) continue;
                String sub = s.substring(i, j);
                if (sub.indexOf(s.charAt(j - 1)) == sub.length() - 1) {
                    // enhancement by me
                    max = j - i > max ? j - i : max;
                } else {
                    break;
                }
            }
        }
        return max;
    }

    /**
     * AC
     * 981/981 test cases passed
     * 436ms
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringV4(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0, begin = 0, end = 0;
        while (end < s.length() + 1) {
            if (begin == end) {
                end++;
                continue;
            }
            String sub = s.substring(begin, end);
            if (sub.indexOf(s.charAt(end - 1)) == sub.length() - 1) {
                max = (end - begin) > max ? (end - begin) : max;
                end++;
            } else {
                begin++;
            }
        }

        return max;
    }

    /**
     * From discuss of leetcode
     * <p>
     * max of length of substring between the same characters
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringV5(String s) {
        int[] m = new int[127];
        char[] ch = s.toCharArray();
        int max = 0;
        int start = 0;
        for (int i = 0; i < m.length; i++) {
            m[i] = -1;
        }
        for (int i = 0; i < ch.length; i++) {
            if (m[ch[i]] < 0) {
                m[ch[i]] = i;
            } else {
                start = Math.max(start, m[ch[i]] + 1);
                m[ch[i]] = i;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }


    /**
     * Time Limit Exceeded
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringV6(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();
        Map<Character, Integer> hash = new HashMap();
        int length = s.length();
        int max = 0, end = 0, start = 0;
        for (; end < length; end++) {
            if (hash.containsKey(s.charAt(end)) && hash.get(s.charAt(end)) >= start) {
                start = hash.get(s.charAt(end)) + 1;
            }
            hash.put(s.charAt(end), end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    /**
     * from discuss
     * 981/981 test cases passed
     * Runtime : 392ms
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringV7(String s) {
        if (s.length() < 2) return s.length();
        Map<Character, Integer> hash = new HashMap();
        int length = s.length();
        int max = 1, end = 1, start = 0;

        hash.put(s.charAt(0), 0);
        while (end < length) {
            if (hash.containsKey(s.charAt(end)) && hash.get(s.charAt(end)) >= start) {
                //s.charAt(end))>=start keep start not backforward
                //or abba＝3
                start = hash.get(s.charAt(end)) + 1;
            }
            max = Math.max(max, end - start + 1);
            hash.put(s.charAt(end), end);
            end++;
        }
        return max;
    }
}
