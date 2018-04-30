package com.henmory.test.java_rx;

import android.util.Log;

/**
 * author: henmory
 * time:  4/3/18
 * function:
 * description:黑屋子  平安夜场景
 *              T 表示看电影
 */

public class Observable<T> {

    private static final String TAG = Observable.class.getSimpleName();
    private Onsubscribe<T>  onsubscribe;//主人公－－－由客户端去new，具体做什么由客户端实现

    //场景
    private Observable(Onsubscribe<T> onsubscribe) {
        this.onsubscribe = onsubscribe;
    }


    public static <T> Observable<T> create(Onsubscribe<T> onsubscribe){
        Log.d(TAG, "create: ");
        return new Observable<T>(onsubscribe);
    }

    //做事情，传入一个看电影的女生－－－观察者与被观察者联系起来，通过Observable
    public void subscribe(Subscribe<? super T> subscribe){
        Log.d(TAG, "subscribe: ");
        onsubscribe.call(subscribe);
    }

    //主人公转换，由func1实现具体转换过程，由t类型转换成r类型
    //返回的是R类型，即自己需要的
    //传入的是自己给的下一个责任链即OnsubscribeLift
    public <R> Observable<R> map(Func1<? super T, ? extends R> func1){
        Log.d(TAG, "map: ");
        return new Observable<R>(new OnsubscribeLift<>(onsubscribe, func1));
    }

    public Observable<T> subscribeOnIO(){
        return create(new OnsubscribeThread<T>(this));
    }
}
