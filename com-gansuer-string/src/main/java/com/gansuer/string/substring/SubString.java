package com.gansuer.string.substring;

import java.io.UnsupportedEncodingException;

/**
 * Created by Frank on 11/4/15.
 */
public class SubString {

    /**
     * 按字节截取字符串
     *
     * @param orignal 原始字符串
     * @param count   截取位数
     * @return 截取后的字符串
     * @throws UnsupportedEncodingException 使用了JAVA不支持的编码格式
     */
    public static String substring(String orignal, int count)
            throws UnsupportedEncodingException {
        // 原始字符不为null，也不是空字符串
        if (orignal != null && !"".equals(orignal)) {
            // 将原始字符串转换为GBK编码格式
            // 要截取的字节数大于0，且小于原始字符串的字节数
            if (count > 0 && count < orignal.getBytes("GBK").length) {
                StringBuffer buff = new StringBuffer();
                char c;
                for (int i = 0; i < count; i++) {
                    c = orignal.charAt(i);
                    buff.append(c);
                    if (String.valueOf(c).getBytes("GBK").length > 1) {
                        // 遇到中文汉字，截取字节总数减1
                        --count;
                    }
                }
                return new String(buff.toString().getBytes(), "UTF-8");
            }
        }
        return orignal;
    }
}
