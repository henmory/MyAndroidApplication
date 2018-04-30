package com.henmory.test.java_rx;

import android.util.Log;

/**
 * author: henmory
 * time:  4/3/18
 * function:
 * description: 好兄弟
 *  T:想找能开房的女生
 *  R：能够开房的女生
 *
 *  implements Onsubscribe<R> 表示想找到可以开房的女生
 */

public class OnsubscribeLift<T,R> implements Onsubscribe<R> {

    public static final String TAG = OnsubscribeLift.class.getSimpleName();

    //主人公，想要会开房的女生
    private Onsubscribe<T> boy;

    //好兄弟转换t---r
    private Func1<? super T, ? extends R> transform;


    //好兄弟有主人公
    public OnsubscribeLift(Onsubscribe<T> boy, Func1<? super T, ? extends R> transform) {
        Log.d(TAG, "OnsubscribeLift: ");
        this.boy = boy;
        this.transform = transform;
    }

    //想看电影的女生
    @Override
    public void call(Subscribe<? super R> subscribe) {

        Log.d(TAG, "call: ");
        Subscribe<? super T> wife = new OperaChange<>(subscribe, transform);
        boy.call(wife);

    }



    /**
     * 好兄弟的老婆
     *
     * Subscribe<T>：表示自己只能看电影不能开房
     * <T, R> 表示自己可以找到能开房的
     * */
    private static class OperaChange<T, R> extends Subscribe<T>{

        public  static final String TAG = OperaChange.class.getSimpleName();
        //能开房的闺蜜
        private Subscribe<? super R> actual;

        //转换
        private Func1<? super T, ? extends R> transform;

        public OperaChange(Subscribe<? super R> actual, Func1<? super T, ? extends R> transform) {
            Log.d(TAG, "OperaChange: ");
            this.actual = actual;
            this.transform = transform;
        }

        //老婆通过看电影的女生，然后转换成可以开房的女生，具体怎么转换由客户端实现
        @Override
        public void onNext(T t) {
            Log.d(TAG, "onNext: ");
            //自己t替换闺蜜
            R r = this.transform.call(t);
            actual.onNext(r);
        }
    }
}
