package com.henmory.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.henmory.rxjavademo.demo1.APIService;
import com.henmory.rxjavademo.demo1.Translation;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *  @author henmory
 *  @date 4/4/18
 *  @description rxjava 是一种响应式 异步处理 事件流（一个一个一个）的一种框架
 *
 *                  子线程处理一个个事件 由主线程相应
 *                  让代码结构更清晰
 *  @param
 *
 *  @return
*/
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 参数说明：
        // 参数1 = 第1次延迟时间；
        // 参数2 = 间隔时间数字；
        // 参数3 = 时间单位；
        // 该例子发送的事件特点：延迟2s后发送事件，每隔1秒产生1个数字（从0开始递增1，无限个）


        Observable.interval(2,1, TimeUnit.SECONDS)

        /*
         * 步骤2：每次发送数字前发送1次网络请求（doOnNext（）在执行Next事件前调用）
         * 即每隔1秒产生1个数字前，就发送1次网络请求，从而实现轮询需求
         **/

                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d(TAG, "第 " + aLong + " 次轮询" );
                        Log.d(TAG, "accept: " + Thread.currentThread());

                        /*
                         * 步骤3：通过Retrofit发送网络请求
                         **/
                        // a. 创建Retrofit对象
//                        Retrofit retrofit = new Retrofit.Builder()
//                                .baseUrl("http://fy.iciba.com/") // 设置 网络请求 Url
//                                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
//                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava
//                                .build();
//                        APIService apiService = retrofit.create(APIService.class);
//
//                        apiService.getCall()
//                                .subscribeOn(Schedulers.io())
//                                .observeOn(AndroidSchedulers.mainThread())
//                                .subscribe(new Observer<Translation>() {
//                                    @Override
//                                    public void onSubscribe(Disposable disposable) {
//
//                                    }
//
//                                    @Override
//                                    public void onNext(Translation translation) {
//                                        // e.接收服务器返回的数据
//                                        translation.show() ;
//                                    }
//
//                                    @Override
//                                    public void onError(Throwable throwable) {
//                                        Log.d(TAG, "请求失败");
//                                    }
//
//                                    @Override
//                                    public void onComplete() {
//
//                                    }
//                                });
//
                    }
                }).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                Log.d(TAG, "onNext: " + Thread.currentThread());

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "请求失败");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "对Complete事件作出响应");
            }
        });
    }
}
