package com.gansuer.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Frank on 2015/7/30.
 */
public class ConversionUtils {
    /**
     * 把Long类型的列表转换成“,”分隔的字符串
     *
     * @param items
     * @return
     */
    public static String longListToString(List<Long> items) {
        StringBuilder sb = new StringBuilder("");
        if (items != null && items.size() > 0) {
            for (Long item : items) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(Long.toString(item));
            }
        }
        return sb.toString();
    }

    /**
     * 把“,”分隔的字符串转成Long类型的列表
     *
     * @param longStr
     * @return
     */
    public static List<Long> stringToLongList(String longStr) {
        if (StringUtils.isEmpty(longStr)) {
            return null;
        }
        String[] arr = longStr.split(",");
        List<Long> list = new ArrayList<Long>();
        for (int i = 0; i < arr.length; i++) {
            list.add(Long.parseLong(arr[i]));
        }
        return list;
    }

    /**
     * 整型字符串拆分成长整型数组
     *
     * @param intStr
     * @return
     */
    public static List<Integer> stringToIntegerList(String intStr, String splitter) {
        if (StringUtils.isEmpty(intStr)) {
            return null;
        }
        String[] arr = StringUtils.split(splitter);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(Integer.parseInt(arr[i]));
        }
        return list;
    }

    /**
     * 长整型字符串拆分成长整型数组
     *
     * @param longStr
     * @param splitter
     * @return
     */
    public static List<Long> stringToLongList(String longStr, String splitter) {
        if (StringUtils.isEmpty(longStr)) {
            return null;
        }
        String[] arr = StringUtils.split(splitter);
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(Long.parseLong(arr[i]));
        }
        return list;
    }

    /**
     * @param strStr
     * @return
     */
    public static List<String> stringToStringList(String strStr) {
        if (StringUtils.isEmpty(strStr)) {
            return null;
        }
        String[] arr = strStr.split(",");
        return Arrays.asList(arr);
    }
}
