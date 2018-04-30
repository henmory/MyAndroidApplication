package com.henmory.test.java_rx;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.henmory.test.R;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = Main2Activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    //链式调度
    public void watchMovie(View view){
        //创建一个被观察者Onsubscribe是实际的观察者，Observable只是一个场景，提供观察者与被观察者的联系
        Observable.create(new Onsubscribe<String>() {
            //被观察者通知观察者，subscribe是一个观察者，被观察者把事件通过观察者的onNext的参数传递给观察者
            @Override
            public void call(Subscribe<? super String> subscribe) {
                subscribe.onNext("男生：走，看电影去");
            }
            //在subscribe过程中调用观察者的onNext方法
        }).subscribe(new Subscribe<String>() {//生成一个观察者
            //观察者实际要做的事情
            @Override
            public void onNext(String s) {
                Log.d(TAG, s);
                Log.d(TAG, "女生：可以，那就一起去看电影");
            }
        });
    }


    //事件变换（url－－bitmap）
    public void makeLove(View view){
        //new Onsubscribe 主人公
        Observable.create(new Onsubscribe<String>() {

            //主人公想做的事情, subscribe在subscribe中new的对象传入，即调用该对象的onNext
            @Override
            public void call(Subscribe<? super String> subscribe) {
                subscribe.onNext("男生：看电影");
            }
            //主人公转换－－需要借助到好兄弟
        }).map(new Func1<String, Bitmap>() {
            @Override
            public Bitmap call(String s) {
                Log.d(TAG, s);
                Log.d(TAG, "老婆:  不行");
                return BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            }
            //new Subscribe<Bitmap> 闺蜜
        }).subscribeOnIO().subscribe(new Subscribe<Bitmap>() {
            @Override
            public void onNext(Bitmap bitmap) {
                Log.d(TAG, "闺蜜: 走，开房去");
            }
        });
    }

}
