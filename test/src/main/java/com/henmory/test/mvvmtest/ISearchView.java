package com.henmory.test.mvvmtest;

/**
 * author: henmory
 * time:  3/19/18
 * function:
 * description:
 */

public interface ISearchView {
    String getIPaddress();

    void setMsg(MyIP myIP);

    void hideLoad();

    void showLoad();
}
