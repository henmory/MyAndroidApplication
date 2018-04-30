package com.henmory.rxjava_retrofit.test2;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * author: henmory
 * time:  4/5/18
 * function:
 * description:
 */
public class Test2 {

    private static final String TAG = Test2.class.getSimpleName();

    public static void test2(){
        String baseUrl = "https://api.douban.com/v2/movie/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                //请求的结果转为实体类
                .addConverterFactory(GsonConverterFactory.create())
                //适配RxJava2.0,RxJava1.x则为RxJavaCallAdapterFactory.create()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        APIService apiService = retrofit.create(APIService.class);

        apiService.getTopMovie(0, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Movie>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }
                    @Override
                    public void onNext(Movie movie) {
                        Log.d(TAG, "onNext: " + movie.getTitle());
                        List<Movie.Subjects> list = movie.getSubjects();
                        for (Movie.Subjects sub : list) {
                            Log.d(TAG, "onNext: " + sub.getId() + "," + sub.getYear() + "," + sub.getTitle());
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                    }
                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: Over!");
                    }
                });

    }
}
