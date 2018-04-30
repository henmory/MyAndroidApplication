package com.henmory.rxjava_retrofit.test6;

import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * author: henmory
 * time:  4/5/18
 * function:
 * description:
 */
public class Test6 {

    private static final String TAG = Test6.class.getSimpleName();

    public static void test6(Context context){

        ObserverOnNextListener<Movie> observerOnNextListener =  new ObserverOnNextListener<Movie>() {
            @Override
            public void onNext(Movie movie) {
                Log.d(TAG, "onNext: " + movie.getTitle());
                List<Movie.Subjects> list = movie.getSubjects();
                for (Movie.Subjects sub : list) {
                    Log.d(TAG, "onNext: " + sub.getId() + "," + sub.getYear() + "," + sub.getTitle());
                }
            }
        };

        APIMethods.getTopMovie(new ProgressObserver<Movie>(context, observerOnNextListener),0, 10);

        //用户取消下载数据====当数据正在加载时，用户点击返回按钮
        new ProgressObserver<Movie>(context, observerOnNextListener).onCancelProgress();


    }
}
