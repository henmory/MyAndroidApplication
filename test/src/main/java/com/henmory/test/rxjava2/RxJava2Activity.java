package com.henmory.test.rxjava2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.henmory.test.R;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class RxJava2Activity extends AppCompatActivity {
    private static final String TAG = RxJava2Activity.class.getSimpleName();

    private Disposable mDisposable;//当activity消失后，用它隔断观察者，防止界面崩溃

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        RxJava_thread.test3();
    }





    @Override
    protected void onStop() {
        super.onStop();
        mDisposable.dispose();//隔断观察者与activity的关系，如果activity消失，那么相应的消息就不再处理
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDisposable.dispose();//隔断观察者与activity的关系
    }
}
