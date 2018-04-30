package com.henmory.test.java_rx;

/**
 * author: henmory
 * time:  4/3/18
 * function:
 * description: 抽象女生－－－观察者
 */

public abstract class Subscribe<T> {
    public abstract void onNext(T t);
}
