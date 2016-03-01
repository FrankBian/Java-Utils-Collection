package com.gansuer.common.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 封装请求相关的辅助操作
 */
public class RequestUtils {

    /**
     * 从Get参数获取整数值
     *
     * @param request
     * @param paramName
     * @param defaultValue
     * @return
     */
    public static int getQueryInt(HttpServletRequest request, String paramName, int defaultValue) {
        int val = defaultValue;
        if (StringUtils.isEmpty(paramName)) {
            return val;
        }
        String paramVal = request.getParameter(paramName);
        if (!StringUtils.isBlank(paramVal) && StringUtils.isNumeric(paramVal)) {
            val = Integer.valueOf(paramVal);
        }
        return val;
    }

    /**
     * 从Get参数中获取长整型值
     *
     * @param request
     * @param paramName
     * @param defaultValue
     * @return
     */
    public static long getQueryLong(HttpServletRequest request, String paramName, long defaultValue) {
        long val = defaultValue;
        if (StringUtils.isEmpty(paramName)) {
            return val;
        }
        String paramVal = request.getParameter(paramName);
        if (!StringUtils.isBlank(paramVal) && StringUtils.isNumeric(paramVal)) {
            val = Long.parseLong(paramVal);
        }
        return val;
    }

    public static String getQueryString(HttpServletRequest request, String paramName, String defaultValue) {
        String val = defaultValue;
        if (StringUtils.isEmpty(paramName)) {
            return val;
        }
        val = request.getParameter(paramName);
        return val;
    }
}
