package com.henmory.rxjava_retrofit.test4;

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
public class Test4 {

    private static final String TAG = Test4.class.getSimpleName();

    public static void test4(){

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
        APIMethods.getTopMovie(new MyObserver<Movie>(observerOnNextListener),0, 10);
    }
}
