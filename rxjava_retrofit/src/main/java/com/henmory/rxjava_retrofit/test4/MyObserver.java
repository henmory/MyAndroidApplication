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
public class MyObserver<T> implements Observer<T> {

    private static final String TAG = MyObserver.class.getSimpleName();
    private ObserverOnNextListener listener;

    public MyObserver(ObserverOnNextListener listener) {
        this.listener = listener;
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.d(TAG, "onSubscribe: ");
    }
    @Override
    public void onNext(T t) {
        listener.onNext(t);
    }
    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: " + e.getMessage());
    }
    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: Over!");
    }

}
