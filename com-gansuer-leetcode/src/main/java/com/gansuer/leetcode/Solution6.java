package com.gansuer.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Frank on 7/21/15.
 */
public class Solution6 {
    /**
     * 每 2N-2 个字母为一组 ：从上到下再到上（上到第二行）
     * 索引index以1开头 : [1 ... 2n-2]
     * 每个字母该在的行的索引 = index<= n ? index : n - (index -n)
     * <p>
     * Accepted
     * 1158 / 1158 test cases passed
     * Runtime : 564 ms
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (s == null || s.equals("") || numRows <= 1) {
            return s;
        }
        int limit = 2 * numRows - 2;
        Map<Integer, String> res = new HashMap<Integer, String>();
        int loop = s.length() / limit + 1;
        for (int i = 0; i < loop; i++) {
            for (int j = 1; j <= limit; j++) {
                int index = i * limit + j - 1;
                if (index >= s.length()) {
                    break;
                }
                int key = j <= numRows ? j : 2 * numRows - j;
                if (res.containsKey(key)) {
                    res.put(key, res.get(key) + s.charAt(index));
                } else {
                    res.put(key, "" + s.charAt(index));
                }
            }
        }
        String result = "";
        for (int i = 1; i <= numRows; i++) {
            if (res.get(i) == null) {
                break;
            }
            result += res.get(i);
        }
        return result;
    }
}
