package com.henmory.test.tablayout_viewpager_fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.henmory.test.tablayout_viewpager_fragment.fragment.MyFragment;

import java.util.List;

/**
 * author: henmory
 * time:  4/12/18
 * function:
 * description:
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<MyFragment> fragments;
    public ViewPagerAdapter(FragmentManager fm, List<MyFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    //得到页面标题
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
}
