package com.henmory.test.rxjava2;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author: henmory
 * time:  4/4/18
 * function:
 * description:
 */

public class RxJava_thread {
    private static final String TAG = RxJava_thread.class.getSimpleName();

    /**
     * @param
     * @return
     * @author henmory
     * @date 4/4/18
     * @description 线程调度实例
     */
    public static void test3() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                Log.d(TAG, "Observable thread is :" + Thread.currentThread().getName());
                e.onNext(1);
                e.onComplete();

            }

        })//.subscribeOn(Schedulers.newThread())//发送事件的线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//接受事件的线程
               // .observeOn(Schedulers.io())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "subscribe; thread = " +  Thread.currentThread().getName());
                    }

                    @Override
                    public void onNext(Integer value) {

                        Log.d(TAG, "Observer thread is :" + Thread.currentThread().getName());
                        Log.d(TAG, "onNext: " + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "error");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "complete");
                    }
                });
    }



}
