package com.gansuer.http;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;


public class HttpWebRequest {

    // 毫秒
    private static final int CONNECTION_TIMEOUT = 10 * 1000;
    // 毫秒
    private static final int SO_TIMEOUT = 10 * 1000;

    public static final String JsonContentType = "application/json";

    private HttpWebRequest() {
    }

    /**
     * HTTP GET请求
     *
     * @param url
     * @param paramMap
     * @return
     */
    public static String get(String url, Map<String, String> paramMap) throws Exception {
        String result = request(HttpWebRequestMethod.Get, url, paramMap, null, null);
        return result;
    }

    /**
     * HTTP POST请求
     *
     * @param url
     * @param httpEntityData
     * @return
     * @throws Exception
     */
    public static String post(String url, String httpEntityData) throws Exception {
        String result = request(HttpWebRequestMethod.Post, url, null, httpEntityData, null);
        return result;
    }

    /**
     * HTTP POST请求
     *
     * @param url
     * @param paramMap
     * @return
     * @throws java.io.IOException
     */
    public static String post(String url, Map<String, String> paramMap, String httpEntityData, String contentType)
            throws Exception {
        String result = request(HttpWebRequestMethod.Post, url, paramMap, httpEntityData, contentType);
        return result;
    }

    /**
     * POST JSON数据
     *
     * @param url
     * @param json
     * @return
     */
    public static String postJSON(String url, String json) throws Exception {
        String result = request(HttpWebRequestMethod.Post, url, null, json, JsonContentType);
        return result;
    }

    /**
     * Http Put 请求
     *
     * @param url
     * @param paramMap
     * @param httpEntityData
     * @param contentType
     * @return
     * @throws Exception
     */
    public static String put(String url, Map<String, String> paramMap, String httpEntityData, String contentType) throws Exception {
        String result = request(HttpWebRequestMethod.Put, url, paramMap, httpEntityData, contentType);
        return result;
    }

    /**
     * HTTP Delete请求
     *
     * @param url
     * @param paramMap
     * @return
     * @throws Exception
     */
    public static String delete(String url, Map<String, String> paramMap) throws Exception {
        String result = request(HttpWebRequestMethod.Delete, url, paramMap, null, null);
        return result;
    }


    public static String request(String method, String url, Map<String, String> paramMap, String httpEntityData, String
            contentType) throws Exception {

        String result = "";

        // 处理url
        url = processUrl(url, paramMap);

        HttpClient httpClient = new DefaultHttpClient();

        try {
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, CONNECTION_TIMEOUT);
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, SO_TIMEOUT);

            HttpUriRequest request = createUriRequest(method, url);

            if (contentType != null) {
                request.addHeader(HTTP.CONTENT_TYPE, contentType);
            }

            // 设置HttpEntity
            if (httpEntityData != null) {
                method = method.toUpperCase();
                if (method.equals(HttpWebRequestMethod.Post) || method.equals(HttpWebRequestMethod.Put)) {
                    StringEntity httpEntity = new StringEntity(httpEntityData, HTTP.UTF_8);
                    ((HttpEntityEnclosingRequestBase) request).setEntity(httpEntity);
                }
            }

            HttpResponse response = httpClient.execute(request);
            if (response != null && HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, HTTP.UTF_8);
                }
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new IOException();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }

        return result;
    }

    /**
     * @param method
     * @return
     */
    private static HttpUriRequest createUriRequest(String method, String url) {
        if (method.equals(HttpWebRequestMethod.Get)) {
            return new HttpGet(url);
        }

        if (method.equals(HttpWebRequestMethod.Post)) {
            return new HttpPost(url);
        }

        if (method.equals(HttpWebRequestMethod.Put)) {
            return new HttpPut(url);
        }

        if (method.equals(HttpWebRequestMethod.Delete)) {
            return new HttpDelete(url);
        }

        return new HttpPost(url);
    }

    /**
     * @param url
     * @param paramMap
     * @return
     */
    private static String processUrl(String url, Map<String, String> paramMap) throws Exception {
        String params = prepareParam(paramMap);
        if (!StringUtils.isEmpty(params)) {
            if (url.indexOf("?") == -1 && url.indexOf("&") == -1) {
                url += "?" + params;
            } else {
                url += "&" + params;
            }
        }
        return url;
    }

    /**
     * 预处理请求参数值
     *
     * @param paramMap
     * @return
     */
    private static String prepareParam(Map<String, String> paramMap) throws Exception {
        StringBuffer buffer = new StringBuffer();
        if (paramMap == null) {
            return buffer.toString();
        }

        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            if (buffer.length() > 0) {
                buffer.append("&");
            }
            buffer.append(URLEncoder.encode(entry.getKey(), HTTP.UTF_8))
                    .append("=")
                    .append(URLEncoder.encode(entry.getValue(), HTTP.UTF_8));
        }

        return buffer.toString();
    }


    interface HttpWebRequestMethod {
        String Get = "GET";
        String Post = "POST";
        String Put = "PUT";
        String Delete = "DELETE";
    }
}
