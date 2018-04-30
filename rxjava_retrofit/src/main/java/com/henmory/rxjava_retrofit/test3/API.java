package com.henmory.rxjava_retrofit.test3;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: henmory
 * time:  4/5/18
 * function:
 * description: 封装Retrofit请求过程
 */
public class API {

    private static String baseUrl = "https://api.douban.com/v2/movie/";

    public static APIService apiService;


    private API(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiService = retrofit.create(APIService.class);

    }

    //单例
    public static APIService getApiService(){
        if (null == apiService){
            synchronized (API.class){
                if (null == apiService){
                    new API();
                }
            }
        }
        return apiService;
    }

}
