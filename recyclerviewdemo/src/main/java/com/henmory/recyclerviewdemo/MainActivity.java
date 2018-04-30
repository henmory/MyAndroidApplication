package com.henmory.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter adapter;
    private List<String> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        initDatas();
    }
    private void initDatas(){
        datas = new ArrayList<>();
        for (int i = 0; i < 100; i++){
                datas.add("content" + i);
            }
            adapter = new MyRecyclerViewAdapter(datas, MainActivity.this);
        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        //设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));

            //添加分割线
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getDrawable(R.drawable.item_divide));
        recyclerView.addItemDecoration(dividerItemDecoration );

        adapter.setOnItemClickListener(new MyRecyclerViewAdapter.onItemClickListener() {
                @Override
                public void onClick(View view, String data) {
                    Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                }

        });
    }

    public void add(View view){

        adapter.add(0, "new content");
        recyclerView.scrollToPosition(0);
    }
    public void remove(View view){
        adapter.remove(0);
        recyclerView.scrollToPosition(0);
    }
    //设置listview效果
    public void list(View view){
//        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
    }
    //设置gridview效果
    public void grid(View view){
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3, GridLayoutManager.VERTICAL, false));

    }
    //设置瀑布流效果
    public void flow(View view){
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager( 2, StaggeredGridLayoutManager.VERTICAL));

    }


}
