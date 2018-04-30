package com.henmory.test.rxjava2;

import android.content.Context;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: henmory
 * time:  4/4/18
 * function:
 * description:
 */

public class RxJava_Disposal {

    /**
     *  @author henmory
     *  @date 4/4/18
     *  @description Disposal代码测试 需要以后修改，这里面的不对
     *
     *  @param
     *
     *  @return
     */
    public static void test4(Context context) {

        Retrofit retrofit =  new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://www.baidu.com")
                .build();
        API api = retrofit.create(API.class);
        api.login("request").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    private Disposable disposable;
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(String value) {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(context, "登录失败", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(context, "登录失败", Toast.LENGTH_SHORT).show();
                    }
                });


    }


}
