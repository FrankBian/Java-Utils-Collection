package com.gansuer.common.security;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;

/**
 * Created by liold on 2015/8/4.
 */
public class SHA1 {
    /**
     * SHA1加密，小写输出
     *
     * @param value
     * @return
     * @throws Exception
     */
    public static String encrypt(String value) throws Exception {
        if (StringUtils.isEmpty(value)) {
            return value;
        }

        MessageDigest m = MessageDigest.getInstance("sha-1");
        m.update(value.getBytes("UTF-8"));
        byte[] data = m.digest();
        String encryptText = byte2hex(data);
        return encryptText;

    }

    private static String byte2hex(byte[] b) //二行制转字符串
    {
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < b.length; n++) {
            String s = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (s.length() == 1) {
                sb.append("0");
            }
            sb.append(s);
        }
        return sb.toString().toLowerCase();
    }
}
