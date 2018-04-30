package com.henmory.test.glidetest.module;

import android.content.Context;

import com.henmory.test.glidetest.bean.BookBean;
import com.henmory.test.glidetest.net.APIMethods;
import com.henmory.test.glidetest.net.ObserverOnNextListener;
import com.henmory.test.glidetest.net.ProgressObserver;
import com.henmory.test.glidetest.view.adapter.ItemBean;

import java.util.List;

/**
 * author: henmory
 * time:  4/16/18
 * function:
 * description:
 */
public class BookModule implements IBookModule{

    private Context context;
    //读书内容
    private  BookBean books = new BookBean();

    public BookModule(Context context) {
        this.context = context;
    }

    @Override
    public void getBookList(Context context, String className){
        APIMethods.getBookListByClass(new ProgressObserver<BookBean>(context, new ObserverOnNextListener<BookBean>() {
            @Override
            public void onNext(BookBean o) {
                books = o;
            }
        }), className, 0,20);

    }

}
