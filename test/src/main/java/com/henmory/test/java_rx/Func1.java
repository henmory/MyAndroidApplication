package com.henmory.test.java_rx;

/**
 * author: henmory
 * time:  4/3/18
 * function:
 * description:转换过程，具体实现由客户端自己写
 */

public interface Func1<T, R> {

    R call(T t);
}
