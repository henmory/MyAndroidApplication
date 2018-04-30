package com.henmory.test.java_rx;

/**
 * author: henmory
 * time:  4/3/18
 * function:
 * description: T表示动作
 */

public interface Action1<T> {
    void call(T t);
}
