package com.henmory.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.henmory.test.databinding.DataBindingActivity;
import com.henmory.test.recyclerview.MyRecyclerViewAdapter;
import com.henmory.test.tablayout_viewpager_fragment.activity.TablayoutActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    private MyRecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDatas();
    }

    private void initView(){
        recyclerView = findViewById(R.id.recycler_main);

    }
    private void initDatas(){

        list = new ArrayList<>();
        addFeatures();
        adapter = new MyRecyclerViewAdapter(list,MainActivity.this);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL,false));

        adapter.setOnItemClickListener(new MyRecyclerViewAdapter.onItemClickListener() {
            @Override
            public void onClick(int position) {
                switch (position){
                    case 0:
                        startActivity(new Intent(MainActivity.this, com.henmory.test.glidetest.view.activity.GlideActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, DataBindingActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, com.henmory.test.mvvmtest.MainActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, com.henmory.test.rxjava2.RxJava2Activity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, com.henmory.test.java_rx.Main2Activity.class));
                        break;
                    case 5:
//                        startActivity(new Intent(MainActivity.this, com.henmory.test.android_rxjava.Main3Activity.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this, TablayoutActivity.class));
                        break;

                }
            }
        });
    }

    /**
     *  @author henmory
     *  @date 3/16/18
     *  @description 添加测试功能
     *
     *  @param
     *
     *  @return
    */

    private void addFeatures(){
        list.add("glid_test");
        list.add("data binding test");
        list.add("mvvm test");
        list.add("rxjava2 test");
        list.add("java_rx source test");
        list.add("android_rx source test");
        list.add("tablayout_viewpager test");

    }


}
