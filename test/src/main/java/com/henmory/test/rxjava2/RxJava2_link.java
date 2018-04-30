package com.henmory.test.rxjava2;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * author: henmory
 * time:  4/4/18
 * function:
 * description:
 */

public class RxJava2_link {

    private static final String TAG = RxJava2_link.class.getSimpleName();

    /**
     * @param
     * @return
     * @author henmory
     * @date 4/4/18
     * @description rxjava2基本代码
     * <p>
     * 基本使用
     */
    public void test1() {

        //创建一个上游 Observable：
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });

        //创建一个下游 Observer
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "subscribe");
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "" + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "error");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "complete");
            }
        };


        //建立连接
        observable.subscribe(observer);
    }


    /**
     * @param
     * @return
     * @author henmory
     * @date 4/4/18
     * @description 链式表达 ObservableEmitter Disposable使用
     */
    public void test2() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                Log.d(TAG, "Observable thread is :" + Thread.currentThread().getName());
                Log.d(TAG, "emit loading");
                e.onNext(1);
                Log.d(TAG, "emit 2");
                e.onNext(2);
                Log.d(TAG, "emit 3");
                e.onNext(3);
                Log.d(TAG, "emit 4");
                e.onNext(4);
                Log.d(TAG, "emit 5");
                e.onNext(5);
                Log.d(TAG, "emit 6");
                e.onNext(6);
                Log.d(TAG, "emit 7");
                e.onNext(7);
            }

        }).subscribe(new Observer<Integer>() {
            private Disposable mDisposable;
            private int i;

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "subscribe");
                mDisposable = d;
            }

            @Override
            public void onNext(Integer value) {

                Log.d(TAG, "Observer thread is :" + Thread.currentThread().getName());
                Log.d(TAG, "onNext: " + value);
                i++;
                if (i == 2) {
                    Log.d(TAG, "dispose");
                    mDisposable.dispose();
                    Log.d(TAG, "isDisposed : " + mDisposable.isDisposed());
                }
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
