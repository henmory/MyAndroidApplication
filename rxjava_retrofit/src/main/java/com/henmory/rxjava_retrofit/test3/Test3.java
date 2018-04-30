package com.henmory.rxjava_retrofit.test3;

import android.util.Log;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * author: henmory
 * time:  4/5/18
 * function:
 * description:
 */
public class Test3 {

    private static final String TAG = Test3.class.getSimpleName();

    public static void test3(){

        APIMethods.getTopMovie(new Observer<Movie>() {
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

        },0, 10);
    }
}
