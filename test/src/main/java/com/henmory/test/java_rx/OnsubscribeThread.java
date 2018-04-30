package com.henmory.test.java_rx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: henmory
 * time:  4/3/18
 * function:
 * description:
 */

public class OnsubscribeThread <T> implements Onsubscribe<T> {

    private static ExecutorService executorService = Executors.newCachedThreadPool();
    Observable<T> source;


    public OnsubscribeThread(Observable<T> source) {
        this.source = source;
    }

    @Override
    public void call(Subscribe<? super T> subscribe) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                source.subscribe(subscribe);
            }
        };
        executorService.submit(runnable);
    }
}
