//package com.henmory.test.rxjavademo;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.View;
//import android.widget.TextView;
//
//import com.henmory.test.R;
//
//import java.util.Arrays;
//import java.util.List;
//
//import rx.Observable;
//import rx.Subscriber;
//import rx.functions.Action1;
//import rx.functions.Func1;
//
//public class RxJavaActivity extends AppCompatActivity {
//
//    private static final String TAG = RxJavaActivity.class.getSimpleName();
//    private TextView textView;
//    private List<String> list;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rxjava);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        textView = findViewById(R.id.tv_test);
//        test1();
////        test2();
////        test3();
////        test4();
////        test5();
//
//    }
//
//    private void test5() {
//        Observable.just("hello")
//                .map(new Func1<String, Integer>() {
//                    @Override
//                    public Integer call(String s) {
//                        return 2011;
//                    }
//                }).map(new Func1<Integer, String>() {
//                    @Override
//                    public String call(Integer integer) {
//                        return String.valueOf(integer);
//                    }
//        }).subscribe(s -> textView.setText(s));
//
//        list = Arrays.asList("android", "java", "ios", "big data");
//        Observable.from(list).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println(s);
//            }
//        });
//    }
//
//    //拉姆达表达式
//    private void test4() {
//        Observable.just("Hello world!!!!")
//                .subscribe(s -> System.out.println(s));
//    }
//
//    private void test3() {
//        Observable.just("Hello, World!")
//                .map(new Func1<String, String>() {
//                    @Override
//                    public String call(String s) {
//                        return s + "henmory";
//                    }
//                })
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        System.out.println(s);
//                    }
//                });
//    }
//
//    private void test2() {
//        Observable<String> myObservable = Observable.just("Hello World!");
//        Action1<String> onNextAction = new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println(s);
//            }
//        };
//        myObservable.subscribe(onNextAction);
//    }
//
//    private void test1() {
//        //定义一个被观察者
//        Observable<String> myObservable =  Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("Hello, World");
//                subscriber.onNext("Hello, World1");
//                subscriber.onCompleted();
//            }
//        });
//
//        //定义观察者
//        Subscriber<String> mySubscriber = new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                Log.d(TAG, "onCompleted");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "onError");
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.d(TAG, s);
//
//            }
//        };
//
//        //订阅
//        myObservable.subscribe(mySubscriber);
//    }
//
//}
