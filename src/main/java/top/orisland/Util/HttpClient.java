package top.orisland.Util;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static top.orisland.Util.JsonTool.mapper;
import static top.orisland.Util.LogUtil.MLOG;

/**
 * @Author: zhaolong
 * @Time: 17:44
 * @Date: 2021年07月11日 17:44
 **/



public class HttpClient {

    public static int reTry = 10;
    /**
     * httpclient，获取url
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static byte[] getUrlByByte(String url) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .callTimeout(60, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Connection", "keep-alive")
                .build();

        return client.newCall(request).execute().body().bytes();
    }

    /**
     * json访问网页返回
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static JsonNode getUrlByJson(String url) {
        OkHttpClient client = null;
        Request request = null;
        int count = 0;
        while (count <= reTry) {
            try {
                client = new OkHttpClient.Builder()
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .callTimeout(30, TimeUnit.SECONDS)
                        .build();

                request = new Request.Builder()
                        .url(url)
                        .addHeader("Connection", "keep-alive")
                        .build();
                return mapper.readTree(client.newCall(request).execute().body().bytes());
            } catch (Exception e) {
                MLOG.warning("第{}次访问出现异常！");
                ++count;
                e.printStackTrace();

                try {
                    Thread.sleep(reTry / 10 * 1000);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        }
        MLOG.error("访问失败！");
        return null;
    }

    /**
     * Post方式进行json访问网页返回
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static JsonNode PostUrlByJson(String url, RequestBody body) {
        OkHttpClient client = null;
        Request request = null;
        try {
            client = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .callTimeout(10, TimeUnit.SECONDS)
                    .build();

            request = new Request.Builder()
                    .url(url)
                    .addHeader("Connection", "keep-alive")
                    .post(body)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return mapper.readTree(client.newCall(request).execute().body().bytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * api get方法，专用于api调用
     *
     * @param url
     * @param args
     * @return
     * @throws IOException
     */
    public static JsonNode apiGetByJson(String url, String... args) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .callTimeout(30, TimeUnit.SECONDS)
                .build();

        url += "?";
        StringBuilder arg = new StringBuilder();
        for (String str : args) {
            arg.append(str);
            arg.append("&");
        }

        url += arg;

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Connection", "keep-alive")
                .build();
        return mapper.readTree(client.newCall(request).execute().body().bytes());
    }
}
