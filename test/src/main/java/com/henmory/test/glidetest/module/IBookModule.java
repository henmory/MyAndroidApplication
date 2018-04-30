package com.henmory.test.glidetest.module;

import android.content.Context;

/**
 * author: henmory
 * time:  4/16/18
 * function:
 * description:
 */
public interface IBookModule {

    //获取不同classname的书籍列表
    void getBookList(Context context, String className);
}
