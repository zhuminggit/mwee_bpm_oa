package com.mvee.bpm.oa.comon.http;

import com.squareup.okhttp.*;

import java.io.IOException;

/**
 * Created by chen.nie on 16/8/19.
 */
public class HttpUtils {
    private static OkHttpClient httpClient = new OkHttpClient();

    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    public String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(HttpUtils.get("http://localhost:8080/oa/activiti/ping"));
    }
}
