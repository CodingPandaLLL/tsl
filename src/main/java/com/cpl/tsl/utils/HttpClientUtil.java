package com.cpl.tsl.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * HttpClient工具类
 *
 * @author: lll
 * @date: 2022年11月21日 14:11:51
 */
public class HttpClientUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    private static String CONTENTTYPE = "Content-Type";

    /**
     * get请求
     *
     * @param url     请求地址
     * @param headers 请求头，可以为null
     * @return String
     */
    public static String doGet(String url, Map<String, String> headers) {
        String httpCharset = "utf-8";
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建HttpResponse对象
        CloseableHttpResponse response = null;
        logger.info("request param info : {}", url);
        logger.info("request header info : {}", headers);
        try {
            try {
                // 创建HttpPost对象
                HttpGet get = new HttpGet(url);
                // 封装请求头
                if (null != headers) {
                    headers.keySet().forEach(key -> {
                        get.addHeader(key, headers.get(key));
                    });
                }
                response = httpClient.execute(get);
                String result = EntityUtils.toString(response.getEntity(), Charset.forName(httpCharset));
                logger.info("response info : {}", result);
                return result;
            } catch (IOException e) {
                logger.error("get链接失败：" + e.getMessage());
            } finally {
                // 释放连接
                response.close();
            }
        } catch (IOException e) {
            logger.error("post关闭response失败：" + e.getMessage());
        }
        return null;
    }

    /**
     * get请求 带时间配置请求
     *
     * @param url                      请求地址
     * @param headers                  请求头，可以为null
     * @param connectTimeout           连接超时时间
     * @param connectionRequestTimeout 建立连接超时时间，
     * @param socketTimeout            读取数据超时时间
     * @return String
     * @author: lll
     * @date: 2022年11月21日 17:11:21
     */
    public static String doGet(String url, Map<String, String> headers, int connectTimeout, int connectionRequestTimeout, int socketTimeout) {
        String httpCharset = "utf-8";
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建HttpResponse对象
        CloseableHttpResponse response = null;
        logger.info("request param info : {}", url);
        logger.info("request header info : {}", headers);
        try {
            try {
                // 创建HttpPost对象
                HttpGet get = new HttpGet(url);
                get.setConfig(RequestConfig.custom().setConnectTimeout(connectTimeout).setConnectionRequestTimeout(connectionRequestTimeout).setSocketTimeout(socketTimeout).build());
                // 封装请求头
                if (null != headers) {
                    headers.keySet().forEach(key -> {
                        get.addHeader(key, headers.get(key));
                    });
                }
                response = httpClient.execute(get);
                String result = EntityUtils.toString(response.getEntity(), Charset.forName(httpCharset));
                logger.info("response info : {}", result);
                return result;
            } catch (IOException e) {
                logger.error("get链接失败：" + e.getMessage());
            } finally {
                // 释放连接
                response.close();
            }
        } catch (IOException e) {
            logger.error("post关闭response失败：" + e.getMessage());
        }
        return null;
    }

    /**
     * post请求 body为json 带时间配置请求
     *
     * @param url                      请求地址
     * @param headers                  请求头，可以为null
     * @param body                     json请求体
     * @param connectTimeout           连接超时时间
     * @param connectionRequestTimeout 建立连接超时时间，
     * @param socketTimeout            读取数据超时时间
     * @return String
     * @author: lll
     * @date: 2022年11月21日 14:11:49
     */
    public static String doPost(String url, Map<String, String> headers, String body, int connectTimeout, int connectionRequestTimeout, int socketTimeout) {
        String httpCharset = "utf-8";
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建HttpResponse对象
        CloseableHttpResponse response = null;
        logger.info("request param info : {}", body);
        logger.info("request header info : {}", headers);
        try {
            try {
                // 创建HttpPost对象
                HttpPost post = new HttpPost(url);
                post.setConfig(RequestConfig.custom().setConnectTimeout(connectTimeout).setConnectionRequestTimeout(connectionRequestTimeout).setSocketTimeout(socketTimeout).build());
                // 封装请求头
                if (null != headers) {
                    headers.keySet().forEach(key -> {
                        post.addHeader(key, headers.get(key));
                    });
                }
                post.addHeader(HTTP.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                // 封装请求体
                if (StringUtils.isNotBlank(body)) {
                    // 请求体主要封装在HttpEntity中
                    post.setEntity(new StringEntity(body, Charset.forName(httpCharset)));
                }

                response = httpClient.execute(post);
                // 处理响应
                String result = EntityUtils.toString(response.getEntity(), Charset.forName(httpCharset));
                logger.info("response info : {}", result);
            } catch (IOException e) {
                logger.error("post链接失败：" + e.getMessage());
            } finally {
                // 释放连接
                response.close();
            }
        } catch (IOException e) {
            logger.error("post关闭response失败：" + e.getMessage());
        }
        return null;
    }

    /**
     * post请求 body为json
     *
     * @param url     请求地址
     * @param headers 请求头，可以为null
     * @param body    json请求体
     * @return String
     * @author: lll
     * @date: 2022年11月21日 14:11:49
     */
    public static String doPost(String url, Map<String, String> headers, String body) {
        String httpCharset = "utf-8";
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建HttpResponse对象
        CloseableHttpResponse response = null;
        logger.info("request param info : {}", body);
        logger.info("request header info : {}", headers);
        try {
            try {
                // 创建HttpPost对象
                HttpPost post = new HttpPost(url);
                // 封装请求头
                if (null != headers) {
                    headers.keySet().forEach(key -> {
                        post.addHeader(key, headers.get(key));
                    });
                }
                post.addHeader(HTTP.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                // 封装请求体
                if (StringUtils.isNotBlank(body)) {
                    // 请求体主要封装在HttpEntity中
                    post.setEntity(new StringEntity(body, Charset.forName(httpCharset)));
                }

                response = httpClient.execute(post);
                // 处理响应
                String result = EntityUtils.toString(response.getEntity(), Charset.forName(httpCharset));
                logger.info("response info : {}", result);
            } catch (IOException e) {
                logger.error("post链接失败：" + e.getMessage());
            } finally {
                // 释放连接
                response.close();
            }
        } catch (IOException e) {
            logger.error("post关闭response失败：" + e.getMessage());
        }
        return null;
    }

    /**
     * post请求 body为form
     *
     * post请求 body为json 带时间配置请求
     *
     * @param url                      请求地址
     * @param headers                  请求头，可以为null
     * @param body                     form请求体
     * @return String
     * @author: lll
     * @date: 2022年11月21日 14:11:49
     */
    public static String doPost(String url, Map<String, String> headers, Map body, int connectTimeout, int connectionRequestTimeout, int socketTimeout) {
        String httpCharset = "utf-8";
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建HttpResponse对象
        CloseableHttpResponse response = null;
        logger.info("request param info : {}", body);
        logger.info("request header info : {}", headers);
        try {
            try {
                // 创建HttpPost对象
                HttpPost post = new HttpPost(url);
                post.setConfig(RequestConfig.custom().setConnectTimeout(connectTimeout).setConnectionRequestTimeout(connectionRequestTimeout).setSocketTimeout(socketTimeout).build());
                // 封装请求头
                if (null != headers) {
                    headers.keySet().forEach(key -> {
                        post.addHeader(key, headers.get(key));
                    });
                }
                // 封装请求体
                List<NameValuePair> nvps = new ArrayList<>();
                for (Iterator iter = body.keySet().iterator(); iter.hasNext(); ) {
                    String name = (String) iter.next();
                    String value = String.valueOf(body.get(name));
                    nvps.add(new BasicNameValuePair(name, value));
                }
                post.setEntity(new UrlEncodedFormEntity(nvps));

                response = httpClient.execute(post);
                // 处理响应
                String result = EntityUtils.toString(response.getEntity(), Charset.forName(httpCharset));
                logger.info("response info : {}", result);
            } catch (IOException e) {
                logger.error("post链接失败：" + e.getMessage());
            } finally {
                // 释放连接
                response.close();
            }
        } catch (IOException e) {
            logger.error("post关闭response失败：" + e.getMessage());
        }
        return null;
    }

    /**
     * post请求 body为form
     *
     * post请求 body为json 带时间配置请求
     *
     * @param url                      请求地址
     * @param headers                  请求头，可以为null
     * @param body                     json请求体
     * @param connectTimeout           连接超时时间
     * @param connectionRequestTimeout 建立连接超时时间，
     * @param socketTimeout            读取数据超时时间
     * @return String
     * @author: lll
     * @date: 2022年11月21日 14:11:49
     */
    public static String doPost(String url, Map<String, String> headers, Map body) {
        String httpCharset = "utf-8";
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建HttpResponse对象
        CloseableHttpResponse response = null;
        logger.info("request param info : {}", body);
        logger.info("request header info : {}", headers);
        try {
            try {
                // 创建HttpPost对象
                HttpPost post = new HttpPost(url);
                // 封装请求头
                if (null != headers) {
                    headers.keySet().forEach(key -> {
                        post.addHeader(key, headers.get(key));
                    });
                }
                // 封装请求体
                List<NameValuePair> nvps = new ArrayList<>();
                for (Iterator iter = body.keySet().iterator(); iter.hasNext(); ) {
                    String name = (String) iter.next();
                    String value = String.valueOf(body.get(name));
                    nvps.add(new BasicNameValuePair(name, value));
                }
                post.setEntity(new UrlEncodedFormEntity(nvps));

                response = httpClient.execute(post);
                // 处理响应
                String result = EntityUtils.toString(response.getEntity(), Charset.forName(httpCharset));
                logger.info("response info : {}", result);
            } catch (IOException e) {
                logger.error("post链接失败：" + e.getMessage());
            } finally {
                // 释放连接
                response.close();
            }
        } catch (IOException e) {
            logger.error("post关闭response失败：" + e.getMessage());
        }
        return null;
    }

//
//    /**
//     * post请求(用于key-value格式的参数)
//     *
//     * @param url
//     * @param params
//     * @return
//     */
//    public static String doPost(String url, Map params) {
//
//        BufferedReader in = null;
//        try {
//            // 定义HttpClient
//            HttpClient client = new DefaultHttpClient();
//            // 实例化HTTP方法
//            HttpPost request = new HttpPost();
//            request.setURI(new URI(url));
//
//            //设置参数
//            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//            for (Iterator iter = params.keySet().iterator(); iter.hasNext(); ) {
//                String name = (String) iter.next();
//                String value = String.valueOf(params.get(name));
//                nvps.add(new BasicNameValuePair(name, value));
//            }
//            request.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
//
//            HttpResponse response = client.execute(request);
//            int code = response.getStatusLine().getStatusCode();
//            if (code == 200) {    //请求成功
//                in = new BufferedReader(new InputStreamReader(response.getEntity()
//                        .getContent(), "utf-8"));
//                StringBuffer sb = new StringBuffer("");
//                String line = "";
//                String NL = System.getProperty("line.separator");
//                while ((line = in.readLine()) != null) {
//                    sb.append(line + NL);
//                }
//
//                in.close();
//
//                return sb.toString();
//            } else {    //
//                System.out.println("状态码：" + code);
//                return null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//            return null;
//        }
//    }
//
//    /**
//     * post请求（用于请求json格式的参数）
//     *
//     * @param url
//     * @param params
//     * @return
//     */
//    public static String doPost(String url, String params) throws Exception {
//
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(url);// 创建httpPost
//        httpPost.setHeader("Accept", "application/json");
//        httpPost.setHeader("Content-Type", "application/json");
//        httpPost.setHeader("sentinel-resource", "HelloWorld");
//        String charSet = "UTF-8";
//        StringEntity entity = new StringEntity(params, charSet);
//        httpPost.setEntity(entity);
//        CloseableHttpResponse response = null;
//
//        try {
//
//            response = httpclient.execute(httpPost);
//            StatusLine status = response.getStatusLine();
//            int state = status.getStatusCode();
//            if (state == HttpStatus.SC_OK) {
//                HttpEntity responseEntity = response.getEntity();
//                String jsonString = EntityUtils.toString(responseEntity);
//                return jsonString;
//            } else {
//                logger.error("请求返回:" + state + "(" + url + ")");
//            }
//        } finally {
//            if (response != null) {
//                try {
//                    response.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            try {
//                httpclient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }

}
