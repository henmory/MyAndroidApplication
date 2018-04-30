package com.henmory.test.tablayout_viewpager_fragment.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.henmory.test.R;
import com.henmory.test.tablayout_viewpager_fragment.adapter.ViewPagerAdapter;
import com.henmory.test.tablayout_viewpager_fragment.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TablayoutActivity extends AppCompatActivity implements MyFragment.OnFragmentInteractionListener{


    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tab)
    TabLayout tab;

    private List<MyFragment> fragments;
    private ViewPagerAdapter adapter;

    private List<String> titles;
    private final int TITLE_NUM = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("oncreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {

        initToolbar();
        initFloatingActionButton();
        initTabLayout();
        initFragment();
        initViewPager();

        //关联viewpage
        tab.setupWithViewPager(viewpager);

    }

    private void initTabLayout() {
        titles = new ArrayList<>();
        tab.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < TITLE_NUM; i++) {
            titles.add("标题" + i);
            tab.addTab(tab.newTab().setText(titles.get(i)));
        }

    }

    private void initFragment() {
        fragments = new ArrayList<>();
        for (int i = 0; i < TITLE_NUM; i++) {
            MyFragment temp = MyFragment.newInstance(titles.get(i), "内容" + i);
            System.out.println("fragment = " + temp);

            fragments.add(temp);
        }
    }

    private void initViewPager() {
        //设置viewpager适配器
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
    }

    private void initFloatingActionButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("tablayout 测试");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
