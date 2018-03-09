package com.henmory.mvptest.netconnection;

/**
 * author: henmory
 * time:  11/23/16
 * function:
 * description: http请求，可以取消，发生IOException异常
 * 同步方式需要自己管理同时请求的次数
 * 异步方法Dispatcher复杂管理
 * <p>
 * https://github.com/square/okhttp/wiki/Recipes
 */

import android.util.Log;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtil {
    private final static String tag = "OkHttpUtil";
    //1.创建okhttp对象
    private static final OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     *  @author henmory
     *  @date 11/23/16
     *  @description 同步get方法---需要自己开辟线程
     *
     *  @param  param http_methord[0] + action[1] + token[2,3]
     *
     *  @return
     */
    public static Object get(final String... param) throws IOException {

        String keyAction = param[1];
        String keyToken = param[2];
        String tokenValue = ServerConfig.TOKEN_FLAG + param[3];

        String parems;
        parems = ServerConfig.SERVER_IP + ServerConfig.SERVER_API + keyAction + "?";
//        parems = parems + keyToken + "=" + tokenValue;
        for (int i = 4; i < param.length - 1; i += 2) {
            parems += param[i];
            parems += "=";
            parems += param[i + 1];
            parems += "&";
        }


        Request request = new Request.Builder()
                .url(parems)
                .addHeader(keyToken, tokenValue)
                .build();
        Log.d(tag, "head = " + request.headers().toString());
        Log.d(tag, "url = " + request.url().toString());


        //block,wait.....
        Response response = null;
        response = client.newCall(request).execute();

        if (response.isSuccessful()) {

            String string = response.body().string();
            Log.d(tag, string);
            return string;
        } else {
            Log.d(tag, "http error code = " + response.code());
            String string = response.body().string();
            Log.d(tag, string);
            return string;
        }
    }


    /**
     *  @author henmory
     *  @date 11/23/16
     *  @description 同步delete方法---需要自己开辟线程
     *
     *  @param  param http_methord[0] + action[1] + token[2,3]
     *
     *  @return
     */
    public static Object delete(final String... param) throws IOException {

        String keyAction = param[1];
        String keyToken = param[2];
        String tokenValue = ServerConfig.TOKEN_FLAG + param[3];

        String parems;
        parems = ServerConfig.SERVER_IP + ServerConfig.SERVER_API + keyAction + "?";
//        parems = parems + keyToken + "=" + tokenValue;
        for (int i = 4; i < param.length - 1; i += 2) {
            parems += "&";
            parems += param[i];
            parems += "=";
            parems += param[i + 1];
        }

        Log.d(tag, parems);

        Request request = new Request.Builder()
                .url(parems)
                .addHeader(keyToken, tokenValue)
                .delete()
                .build();
        Log.d("okhttp  ", request.toString());

        //block,wait.....
        Response response = null;
        response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            String string = response.body().string();
            Log.d(tag, string);
            return string;
        } else {
            Log.d(tag, "error code = " + response.code());
            Log.d(tag, "okhttp failed");
            return null;
        }
    }


    /**
     *  @author henmory
     *  @date 11/23/16
     *  @description 异步get
     *
     *  @param
     *
     *  @return
     */
    public void getAsnync() throws Exception {
        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();
                for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }

                System.out.println(response.body().string());
            }
        });
    }

    /**
     *  @author henmory
     *  @date 11/23/16
     *  @description post表单参数
     *
     *  @param
     *
     *  @return
     */

    public void post() throws Exception {
        RequestBody formBody = new FormBody.Builder()
                .add("Usr", "13488783239")
                .add("Pwd", "12345")
                .build();
        Request request = new Request.Builder()
                .url("http://182.92.165.152:8081/api/Token?v=2")
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }

        System.out.println(response.body().string());
    }

    /**
     *  @author henmory
     *  @date 11/23/16
     *  @description 采用同步post，外部自己新开辟线程
     *
     *  @param  param: http_methotd[0] + action[1] + token[2,3] + param[key,value]
     *
     *  @return 失败 null
     *          成功 消息体的字符串
     *          异常 抛出
     */
    public static String post(final String... param) throws IOException {

        //build json body
        String keyToken = param[2];
        String tokenValue = ServerConfig.TOKEN_FLAG + param[3];

        JSONObject jsonObject = new JSONObject();
        for (int i = 4; i < param.length - 1; i += 2) {
            try {
                jsonObject.put(param[i], param[i + 1]);
            } catch (JSONException e) {
                e.printStackTrace();
                Log.d(tag, "okhttp failed");
                return null;
            }
        }

        String jsonData = jsonObject.toString();
        Log.d(tag, jsonData);
        RequestBody requestBody = RequestBody.create(JSON, jsonData);

//        FormBody.Builder builder = new FormBody.Builder();
//        for (int i = 4; i < param.length - 1; i +=2){
//            builder.add(param[i],param[i + 1]);
//        }
//        RequestBody formBody = builder.build();

        //build request
        String keyAction = param[1];

        Request request = new Request.Builder()
                .url(ServerConfig.SERVER_IP + ServerConfig.SERVER_API + keyAction)
                .addHeader(keyToken, tokenValue)
                .post(requestBody)
                .build();

        //block,wait.....
        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            String string = response.body().string();
            //print
            Log.e(tag, string);
            return string;
        } else {
            Log.d(tag, "okhttp failed");
            Log.d(tag, response.code()+"");
            return null;
        }

    }
}
