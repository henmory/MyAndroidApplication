package com.henmory.test.glidetest.view.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.henmory.test.R;
import com.henmory.test.glidetest.Bean;
import com.henmory.test.glidetest.presenter.BookPresenter;
import com.henmory.test.glidetest.view.adapter.ViewPagerAdapter;
import com.henmory.test.glidetest.view.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GlideRecyclerViewACtivity extends AppCompatActivity implements MyFragment.OnFragmentInteractionListener{

    private final static String TAG = GlideRecyclerViewACtivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tablelayout)
    TabLayout tablelayout;
    @BindView(R.id.bnv)
    BottomNavigationView bnv;

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private ViewPagerAdapter adapter;
    private List<MyFragment> fragments;

    //tab标题内容
    private List<String> tab_titles;

    private BookPresenter bookPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_recycler_view_activity);
        ButterKnife.bind(this);

        bookPresenter = new BookPresenter(this);

        initView();
        initData();


    }

    private void initView() {

        initToolbar();
        initTabLayout();
        initData();
        initFragment();
        initViewPager();
//        关联viewpage
        tablelayout.setupWithViewPager(viewpager);

        initBottomNavigation();
    }


    private void initViewPager() {
        //设置viewpager适配器
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
    }
    private void initFragment() {
        fragments = new ArrayList<>();
        for (int i = 0; i < tab_titles.size(); i++) {
            fragments.add(MyFragment.newInstance(this, tab_titles.get(i), i + ""));
        }
    }
    private void initTabLayout() {
        tab_titles = bookPresenter.initTabLayoutContent();
        tablelayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < tab_titles.size(); i++) {
            tablelayout.addTab(tablelayout.newTab().setText(tab_titles.get(i)));
        }

    }
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("测试");

    }



    private void initBottomNavigation() {
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.menu_item_home:
                        break;
                    case R.id.menu_item_gank_io:
                        break;
                    case R.id.menu_item_movie:
                        break;
                    case R.id.menu_item_book:
                        break;
                    case R.id.menu_item_personal:
                        break;
                }
                return true;
            }
        });
    }


    private void initData() {

//        testData();
        bookPresenter.initFragmentContent(0);

    }

    private void testData() {
        List<Bean> urls;

        urls = new ArrayList<>();
//        urls.add(new Bean(null, 0)); //不加头
        urls.add(new Bean("http://img05.tooopen.com/images/20160109/tooopen_sy_153858412946.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/018d4e554967920000019ae9df1533.jpg@900w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img07.tooopen.com/images/20170316/tooopen_sy_201956178977.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/010a1b554c01d1000001bf72a68b37.jpg@1280w_1l_2o_100sh.png", 2));
        urls.add(new Bean("http://www.taopic.com/uploads/allimg/140421/318743-140421213T910.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/013f5958c53a47a801219c772a5335.jpg@900w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/010f87596f13e6a8012193a363df45.jpg@1280w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/01f09e577b85450000012e7e182cf0.jpg@1280w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img.taopic.com/uploads/allimg/121019/234917-121019231h258.jpg", 2));
        urls.add(new Bean("http://pic.58pic.com/58pic/13/68/03/86S58PIC26b_1024.jpg", 2));
        urls.add(new Bean("http://img.taopic.com/uploads/allimg/140729/240450-140HZP45790.jpg", 2));
        urls.add(new Bean("http://img05.tooopen.com/images/20160109/tooopen_sy_153858412946.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/018d4e554967920000019ae9df1533.jpg@900w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img07.tooopen.com/images/20170316/tooopen_sy_201956178977.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/010a1b554c01d1000001bf72a68b37.jpg@1280w_1l_2o_100sh.png", 2));
        urls.add(new Bean("http://www.taopic.com/uploads/allimg/140421/318743-140421213T910.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/013f5958c53a47a801219c772a5335.jpg@900w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/010f87596f13e6a8012193a363df45.jpg@1280w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/01f09e577b85450000012e7e182cf0.jpg@1280w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img.taopic.com/uploads/allimg/121019/234917-121019231h258.jpg", 2));
        urls.add(new Bean("http://pic.58pic.com/58pic/13/68/03/86S58PIC26b_1024.jpg", 2));
        urls.add(new Bean("http://img.taopic.com/uploads/allimg/140729/240450-140HZP45790.jpg", 2));
        urls.add(new Bean("http://img05.tooopen.com/images/20160109/tooopen_sy_153858412946.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/018d4e554967920000019ae9df1533.jpg@900w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img07.tooopen.com/images/20170316/tooopen_sy_201956178977.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/010a1b554c01d1000001bf72a68b37.jpg@1280w_1l_2o_100sh.png", 2));
        urls.add(new Bean("http://www.taopic.com/uploads/allimg/140421/318743-140421213T910.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/013f5958c53a47a801219c772a5335.jpg@900w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/010f87596f13e6a8012193a363df45.jpg@1280w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/01f09e577b85450000012e7e182cf0.jpg@1280w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img.taopic.com/uploads/allimg/121019/234917-121019231h258.jpg", 2));
        urls.add(new Bean("http://pic.58pic.com/58pic/13/68/03/86S58PIC26b_1024.jpg", 2));
        urls.add(new Bean("http://img.taopic.com/uploads/allimg/140729/240450-140HZP45790.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/010f87596f13e6a8012193a363df45.jpg@1280w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/01f09e577b85450000012e7e182cf0.jpg@1280w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img.taopic.com/uploads/allimg/121019/234917-121019231h258.jpg", 2));
        urls.add(new Bean("http://pic.58pic.com/58pic/13/68/03/86S58PIC26b_1024.jpg", 2));
        urls.add(new Bean("http://img.taopic.com/uploads/allimg/140729/240450-140HZP45790.jpg", 2));
        urls.add(new Bean("http://img05.tooopen.com/images/20160109/tooopen_sy_153858412946.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/018d4e554967920000019ae9df1533.jpg@900w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img07.tooopen.com/images/20170316/tooopen_sy_201956178977.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/010a1b554c01d1000001bf72a68b37.jpg@1280w_1l_2o_100sh.png", 2));
        urls.add(new Bean("http://www.taopic.com/uploads/allimg/140421/318743-140421213T910.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/013f5958c53a47a801219c772a5335.jpg@900w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/010f87596f13e6a8012193a363df45.jpg@1280w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img.zcool.cn/community/01f09e577b85450000012e7e182cf0.jpg@1280w_1l_2o_100sh.jpg", 2));
        urls.add(new Bean("http://img.taopic.com/uploads/allimg/121019/234917-121019231h258.jpg", 2));
        urls.add(new Bean("http://pic.58pic.com/58pic/13/68/03/86S58PIC26b_1024.jpg", 2));
        urls.add(new Bean("http://img.taopic.com/uploads/allimg/140729/240450-140HZP45790.jpg", 2));
        urls.add(new Bean(null, 1));
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
