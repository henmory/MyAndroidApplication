package com.henmory.rxjava_retrofit.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.henmory.rxjava_retrofit.R;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        test3();
    }

    private void test3() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final GetRequest_Interface getRequest_interface = retrofit.create(GetRequest_Interface.class);

        getRequest_interface.getCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Translation>() {
                    @Override
                    public void accept(Translation translation) throws Exception {
                        Log.d(TAG, "第1次网络请求成功");
                        translation.show();
                        Log.d(TAG, "doOnNext accept: current thread" + Thread.currentThread().getName());
                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<Translation, ObservableSource<Translation1>>() {
                    @Override
                    public ObservableSource<Translation1> apply(Translation translation) throws Exception {
                        Log.d(TAG, "Function apply: current thread" + Thread.currentThread().getName());

                        return getRequest_interface.getCall1();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Translation1>() {
                    @Override
                    public void accept(Translation1 translation1) throws Exception {
                        Log.d(TAG, "第2次网络请求成功");
                        translation1.show();
                        Log.d(TAG, "subscribe accept: current thread" + Thread.currentThread().getName());

                        // 对第2次网络请求返回的结果进行操作 = 显示翻译结果
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("登录失败");
                    }
                });


    }

    /**
     *  @author henmory
     *  @date 4/4/18
     *  @description 进行网络嵌套的开发
     *
     *  @param
     *
     *  @return
    */
    private void test2() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final GetRequest_Interface getRequest_interface = retrofit.create(GetRequest_Interface.class);

        //封装网络请求
        Observable<Translation> observable = getRequest_interface.getCall();

//        final Observable<Translation1> observable1 = getRequest_interface.getCall1();

        observable.subscribeOn(Schedulers.io())    // （初始被观察者）切换到IO线程进行网络请求1
                .observeOn(AndroidSchedulers.mainThread()) // （新观察者）切换到主线程 处理网络请求1的结果
                .doOnNext(new Consumer<Translation>() {
                    @Override
                    public void accept(Translation translation) throws Exception {
                        Log.d(TAG, "第1次网络请求成功");
                        translation.show();
                        // 对第1次网络请求返回的结果进行操作 = 显示翻译结果
                    }
                })
                // （新被观察者，同时也是新观察者）切换到IO线程去发起登录请求
                // 特别注意：因为flatMap是对初始被观察者作变换，所以对于旧被观察者，它是新观察者，所以通过observeOn切换线程
                // 但对于初始观察者，它则是新的被观察者
                .observeOn(Schedulers.io())

                .flatMap(new Function<Translation, ObservableSource<Translation1>>() {
                    @Override
                    public ObservableSource<Translation1> apply(Translation translation) throws Exception {
                        return getRequest_interface.getCall1();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())// （初始观察者）切换到主线程 处理网络请求2的结果
                .subscribe(new Consumer<Translation1>() {
                    @Override
                    public void accept(Translation1 translation1) throws Exception {
                        Log.d(TAG, "第2次网络请求成功");
                        translation1.show();
                        // 对第2次网络请求返回的结果进行操作 = 显示翻译结果
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("登录失败");
                    }
                });


    }

    /**
     *  @author henmory
     *  @date 4/4/18
     *  @description 使用retrofit和rxjava进行网路通信
     *
     *  @param
     *
     *  @return
    */
    public void test1(){
        //创建retrofit对象
        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")//url设置
                .addConverterFactory(GsonConverterFactory.create())//使用json解析
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加对rxjava的支持
                .build();

        //创建  网络请求接口 的实例
        GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);

        //采用observable<...> 形式 对 网络请求 进行封装==封装成一个被观察者
        Observable<Translation> observable = request.getCall();

        //发送网络请求
        observable.subscribeOn(Schedulers.io())  //在io线程进行网路请求
                .observeOn(AndroidSchedulers.mainThread())//主线程显示ui
                .subscribe(new Observer<Translation>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "开始采用subscribe连接");
                    }

                    @Override
                    public void onNext(Translation value) {
                        value.show() ;
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "请求失败");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "请求成功");
                    }
                });
    }
}
