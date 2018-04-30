package com.henmory.test.glidetest.presenter;


import android.content.Context;

import com.henmory.test.glidetest.module.BookModule;
import com.henmory.test.glidetest.view.adapter.ItemBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * author: henmory
 * time:  4/16/18
 * function:
 * description:
 */
public class BookPresenter<T> {

    private Context context;
    private WeakReference<T> weakReference; //弱引用
    private BookModule bookModule;
    //tab标题内容
    private List<String> tab_titles;


    public BookPresenter(T context) {
        weakReference = new WeakReference<T>(context);
        this.context = (Context)context;
        bookModule = new BookModule(this.context);
    }

    public List<String> initTabLayoutContent(){
        tab_titles = new ArrayList<>();
        tab_titles.add("文学");
        tab_titles.add("军事");
        tab_titles.add("动画");
        return tab_titles;
    }

    public void initFragmentContent(int item){
        bookModule.getBookList(context, tab_titles.get(item));
    }
}
