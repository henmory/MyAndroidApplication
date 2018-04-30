package com.henmory.rxjava_retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.henmory.rxjava_retrofit.test2.Test2;
import com.henmory.rxjava_retrofit.test3.Test3;
import com.henmory.rxjava_retrofit.test4.Test4;
import com.henmory.rxjava_retrofit.test5.Test5;


public class Main2Activity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = findViewById(R.id.tv_show);

    }


    public void test2(View view){
//        Test2.test2();
//        Test3.test3();
//        Test4.test4();
        Test5.test5(Main2Activity.this);
    }
}
