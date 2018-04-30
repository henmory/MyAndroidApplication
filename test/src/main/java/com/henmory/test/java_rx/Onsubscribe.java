package com.henmory.test.java_rx;

/**
 * author: henmory
 * time:  4/3/18
 * function:
 * description: 男生－－－被观察者抽象
 *              T:看电影
 *              Subscribe<? super T> 看电影的女生
 *              Subscribe：女生
 *
 *
 */

public interface Onsubscribe<T> extends Action1<Subscribe<? super T>> {
}
