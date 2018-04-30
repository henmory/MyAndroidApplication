package com.henmory.rxjava_retrofit.test5;

import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * author: henmory
 * time:  4/5/18
 * function:
 * description:
 */
public class Test5 {

    private static final String TAG = Test5.class.getSimpleName();

    public static void test5(Context context){

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
    }
}
