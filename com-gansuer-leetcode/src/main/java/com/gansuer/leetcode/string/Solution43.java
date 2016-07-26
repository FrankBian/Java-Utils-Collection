package com.gansuer.leetcode.string;

/**
 * Created by Frank on 7/26/16.
 */
public class Solution43 {

    /**
     * Accepted
     * 51ms
     * 8.93%
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        return num1.length() > num2.length() ? multiplyBy(num1, num2) : multiplyBy(num2, num1);
    }

    protected String multiplyBy(String longStr, String shortStr) {
        int len = shortStr.length();
        String[] res = new String[len];
        for (int i = 1; i <= len; i++) {
            String temp = multiply(longStr, char2int(shortStr.charAt(len - i)));
            if (temp != "0") {
                for (int j = 1; j < i; j++) temp += "0";
            }
            res[i - 1] = temp;
        }
        String result = res[0];
        for (int i = 1; i < len; i++)
            result = res[i].length() > result.length() ? add(res[i], result) : add(result, res[i]);
        return result;
    }

    protected String multiply(String num, int n) {
        if (n == 0) return "0";
        int len = num.length();
        StringBuilder stringBuilder = new StringBuilder();
        int divide = 0;
        for (int i = 1; i <= len; i++) {
            int res = n * char2int(num.charAt(len - i)) + divide;
            stringBuilder.append(res % 10);
            divide = res / 10;
        }
        if (divide > 0) stringBuilder.append(divide);
        return stringBuilder.reverse().toString();
    }

    protected String add(String longStr, String shortStr) {
        int lLen = longStr.length(), sLen = shortStr.length();
        int mod = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= lLen; i++) {
            int num1 = char2int(longStr.charAt(lLen - i));
            int num2 = i > sLen ? 0 : char2int(shortStr.charAt(sLen - i));
            int res = num1 + num2 + mod;
            stringBuilder.append(res % 10);
            mod = res / 10;
        }
        if (mod > 0) stringBuilder.append(mod);
        return stringBuilder.reverse().toString();
    }

    protected int char2int(char ch) {
        return ch - '0';
    }


    /***************Best*********************/

    /**
     * Accepted
     * 9ms
     * 66.95%
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiplyX(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[n + m];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) if (!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
