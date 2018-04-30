package com.henmory.test.glidetest.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: henmory
 * time:  4/5/18
 * function:
 * description:
 */
public class ApiStrategy {

    public static String baseUrl = "https://api.douban.com/v2/book/";

    //读超时长，单位：毫秒
    public static final int READ_TIME_OUT = 7676;
    //连接时长，单位：毫秒
    public static final int CONNECT_TIME_OUT = 7676;

    //返回请求类文件对象
    public static APIService apiService;


    public static APIService getApiService() {
        if (apiService == null) {
            synchronized (API.class) {
                if (apiService == null) {
                    new ApiStrategy();
                }
            }
        }
        return apiService;
    }
    private ApiStrategy() {

// TODO: 4/6/18 继续学习
//        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
//        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //缓存
//        File cacheFile = new File(MyApplication.getContext().getCacheDir(), "cache");
//        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb
//        //增加头部信息
//        Interceptor headerInterceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request build = chain.request().newBuilder()
//                        //.addHeader("Content-Type", "application/json")//设置允许请求json数据
//                        .build();
//                return chain.proceed(build);
//            }
//        };

        //创建一个OkHttpClient并设置超时时间
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
//                .addInterceptor(mRewriteCacheControlInterceptor)
//                .addNetworkInterceptor(mRewriteCacheControlInterceptor)
//                .addInterceptor(headerInterceptor)
//                .addInterceptor(logInterceptor)
//                .cache(cache)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())//请求的结果转为实体类
                //适配RxJava2.0,RxJava1.x则为RxJavaCallAdapterFactory.create()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(APIService.class);
    }
    /**
     * 设缓存有效期为两天
     */
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;
    /**
     * 云端响应头拦截器，用来配置缓存策略
     * Dangerous interceptor that rewrites the server's cache-control header.
     */
//    private final Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request request = chain.request();
//            String cacheControl = request.cacheControl().toString();
//            if (!NetWorkUtils.isNetConnected(MyApplication.getContext())) {
//                request = request.newBuilder()
//                        .cacheControl(TextUtils.isEmpty(cacheControl) ? CacheControl
//                                .FORCE_NETWORK : CacheControl.FORCE_CACHE)
//                        .build();
//            }
//            Response originalResponse = chain.proceed(request);
//            if (NetWorkUtils.isNetConnected(MyApplication.getContext())) {
//                return originalResponse.newBuilder()
//                        .header("Cache-Control", cacheControl)
//                        .removeHeader("Pragma")
//                        .build();
//            } else {
//                return originalResponse.newBuilder()
//                        .header("Cache-Control", "public, only-if-cached, max-stale=" +
//                                CACHE_STALE_SEC)
//                        .removeHeader("Pragma")
//                        .build();
//            }
//        }
//    };
}
