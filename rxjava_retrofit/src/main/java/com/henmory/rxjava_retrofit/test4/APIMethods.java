package com.henmory.rxjava_retrofit.test4;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * author: henmory
 * time:  4/5/18
 * function:
 * description:封装线程管理和订阅
 *              在使用RxJava的过程中，每次都重复写线程管理和订阅代码也是一件繁琐的事情。
                创建ApiMethods用于封装线程管理和订阅的过程及调用请求。
 */
public class APIMethods {


    /**
     * 封装线程管理和订阅的过程
     */
    private static void ApiSubscribe(Observable observable, Observer observer) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    /**
     * 用于获取豆瓣电影Top250的数据
     *
     * @param observer 由调用者传过来的观察者对象
     * @param start    起始位置
     * @param count    获取长度
     */
    public static void getTopMovie(Observer<Movie> observer, int start, int count) {
        ApiSubscribe(API.getApiService().getTopMovie(start, count), observer);
    }
}
