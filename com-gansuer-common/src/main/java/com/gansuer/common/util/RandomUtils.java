package com.gansuer.common.util;


import java.security.SecureRandom;

public class RandomUtils {
    static char c[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o',
            'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static SecureRandom random = null;

    static {
        try {
            random = SecureRandom.getInstance("SHA1PRNG");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 获取指定长度的随机字符串
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomValue = random.nextInt() * 1009;
            int a = Math.abs(randomValue % c.length);
            char s = c[a];
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * 获取指定长度的由数字组成的随机字符串
     * @param length
     * @return
     */
    public static String getRandomNumberString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }
}
