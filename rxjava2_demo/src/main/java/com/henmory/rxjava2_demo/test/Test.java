package com.henmory.rxjava2_demo.test;


import android.util.Log;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * author: henmory
 * time:  4/18/18
 * function:
 * description:
 */
public class Test {

    private static final String TAG = Test.class.getSimpleName();

    public static void test1() {
        //创建一个上游Observable
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
                emitter.onComplete();
            }
        });

        //创建一个下游Observer
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        };

        //建立链接
        observable.subscribe(observer);
    }

    //disposal的练习
    public static void test2() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "emit 1");
                emitter.onNext(1);
                Log.d(TAG, "emit 2");
                emitter.onNext(2);
                Log.d(TAG, "emit 3");

                emitter.onNext(3);
                Log.d(TAG, "emit 4");
                emitter.onNext(4);
                Log.d(TAG, "emit onComplete");
                emitter.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            Disposable disposable;

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");

            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext: " + integer);
                if (integer == 2) {
                    disposable.dispose();
                }

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");

            }
        });
    }

    public static void test3() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "emit 1");
                emitter.onNext(1);
                Log.d(TAG, "Observable thread is : " + Thread.currentThread().getName());
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "Observer thread is :" + Thread.currentThread().getName());
                Log.d(TAG, "onNext: " + integer);
            }
        });
    }

    //线程切换的练习
    public static void test4() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "emit 1");
                emitter.onNext(1);
                Log.d(TAG, "Observable thread is : " + Thread.currentThread().getName());
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "Observer thread is :" + Thread.currentThread().getName());
                        Log.d(TAG, "onNext: " + integer);
                    }
                });
    }

    //map的练习
    public static void test5() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "emit 1");
                emitter.onNext(1);
                Log.d(TAG, "Observable thread is : " + Thread.currentThread().getName());
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return "test " + integer;
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String string) {
                        Log.d(TAG, "onNext: " + string);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //flatMap的练习
    public static void test6() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "emit 1");
                emitter.onNext(1);
                Log.d(TAG, "emit 2");
                emitter.onNext(2);
                Log.d(TAG, "emit 3");

                emitter.onNext(3);
                Log.d(TAG, "emit 4");
                emitter.onNext(4);
                Log.d(TAG, "emit onComplete");
                emitter.onComplete();
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {

                return Observable.just(integer + "", integer + "", integer + "");
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String string) {
                        Log.d(TAG, "onNext: " + string);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //zip的练习
    public static void test7() {

        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
            }
        });

        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("my value1 is ");
                emitter.onNext("my value2 is ");
                emitter.onNext("my value3 is ");
                emitter.onNext("my value4 is ");
                emitter.onNext("my value5 is ");
            }
        });
        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return s + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, "accept: " + s);
            }
        });
    }


    //订阅和发送的线程问题
    /**
     *  @author henmory
     *  @date 4/18/18
     *  @description 当发送线程和订阅线程在同一个线程的时候，是先执行发送然后执行接收
     *              但当它们处在不同的线程的时候，那么在发送线程就会有一个缓存存有所有的事件，接收线程一个个的从
     *              缓存中取事件，如果发送和接收的速率不同，会导致缓存的内容越来越多，最终oom
     *              由此可见，如果是同步即在一个线程不存在这个这个问题
     *              如果是异步，那么就会有发送缓冲区
     *
     *              上下游流速不均衡
     *
     *  @param
     *
     *  @return
    */
    public static void test8() {

        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                while (true) {
                    emitter.onNext(1);
                    Log.d(TAG, "subscribe: ");
                }
            }
        })/*.subscribeOn(Schedulers.io())*/;

        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("my value1 is ");
                emitter.onNext("my value2 is ");
                emitter.onNext("my value3 is ");
                emitter.onNext("my value4 is ");
                emitter.onNext("my value5 is ");
            }
        })/*.subscribeOn(Schedulers.io())*/;
        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return s + integer;
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.d(TAG, "accept: " + s);
                    }
                });
    }

    //想办法解决缓存内容过多的情况，这里是增加一个过滤器，只把能被10整除的结果放到缓存，相当于放的数据有所减少
    public static void test9(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                for (int i = 0; ; i++) {  //无限循环发送事件
                    emitter.onNext(i);
                }
            }
        }).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer % 10 == 0;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "" + integer);
                    }
                });


    }

    //换另外一种方式，每两秒取样
    public static void test10(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                for (int i = 0; ; i++) {  //无限循环发送事件
                    emitter.onNext(i);
                }
            }
        }).sample(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "" + integer);
                    }
                });


    }

    //上面两种反式都是减少了发送的事件，但是会导致事件的丢失，这种方法可以考虑让发送方发送的速度降一下，
    public static void test11(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                for (int i = 0; ; i++) {  //无限循环发送事件
                    emitter.onNext(i);
                    Thread.sleep(2000);
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "" + integer);
                    }
                });


    }


    /**
     *  @author henmory
     *  @date 4/18/18
     *  @description Flowable就是为了解决上下游发送数据速率不匹配的问题，代码有两处不同
     *              1.BackpressureStrategy.ERROR＝＝当速率不匹配时的策略
     *              2.s.request(Long.MAX_VALUE);下游控制上游发送的数据数量＝＝＝
     *                  如果没有这个，上游会认为下游没有能力处理，同时如果它们在同一个线程里，上游不会一游不会
     *                  一直等待下游去处理，进而它抛出异常
     *                  如果他们是在不同的线程中，那么上游有个128的缓存，可以把事件放到这里，如果放满了，下游仍然还不去处理
     *                  那么就抛出异常
     *              3.下游开始处理事件的时机是当它调用s.request(Long.MAX_VALUE)时，它会去缓存中取Long.MAX_VALUE个事件进行处理
     *
     *  @param
     *
     *  @return
    */
    public static void test12(){
        Flowable<Integer> upstream = Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "emit 1");
                emitter.onNext(1);
                Log.d(TAG, "emit 2");
                emitter.onNext(2);
                Log.d(TAG, "emit 3");
                emitter.onNext(3);
                Log.d(TAG, "emit complete");
                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io());

        Subscriber<Integer> downStream = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.d(TAG, "onSubscribe: ");
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext: " + integer);
            }

            @Override
            public void onError(Throwable t) {
                Log.d(TAG, "onError: " + t);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        };

        upstream.subscribe(downStream);

    }

    /**
     *  @author henmory
     *  @date 4/18/18
     *  @description 这里主要是验证每 s.request调用一次就回去缓存中读取事件，但是我做两个测试要求必须是异步线程，
     *              同时还需要必须是链式调用才行；.observeOn(AndroidSchedulers.mainThread())代码必须要写
     *
     *  @param
     *
     *  @return
    */

    static Subscription temp;

    public static void request() {
        temp.request(1);
    }
    public static void test13(){
        Flowable<Integer> upstream = Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "emit 1");
                emitter.onNext(1);
                Log.d(TAG, "emit 2");
                emitter.onNext(2);
                Log.d(TAG, "emit 3");
                emitter.onNext(3);
                Log.d(TAG, "emit complete");
                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

        Subscriber<Integer> downStream = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.d(TAG, "onSubscribe: ");
                temp = s;
//                s.request(1);
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext: "  + integer);
            }

            @Override
            public void onError(Throwable t) {
                Log.d(TAG, "onError: " + t);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        };

        upstream.subscribe(downStream);

    }

    //换一种策略，既然flowable是为了解决上下🈶游速率不匹配问题，而且在上游有个缓存，缓存大小为128，当超过128事件后，就拋异常
    //那么我们是否可以找个一个缓存更大的上游呢，答案是有的，BackpressureStrategy.BUFFER 就是无限大的缓存，但是这样同样会造成
    //oom问题

    //这部分属于背压策略问题了，它有四种模式，我们可以自己实验
    public static void test14(){
        Flowable<Integer> upstream = Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                for (int i = 0; ; i++) {
                    emitter.onNext(i);
                    Log.d(TAG, "subscribe: " + i);
                }
            }
        }, BackpressureStrategy.BUFFER).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

        Subscriber<Integer> downStream = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.d(TAG, "onSubscribe: ");
                temp = s;
//                s.request(1);
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext: "  + integer);
            }

            @Override
            public void onError(Throwable t) {
                Log.d(TAG, "onError: " + t);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        };

        upstream.subscribe(downStream);

    }
}
