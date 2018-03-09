package com.henmory.mvptest.view;

/**
 * author: henmory
 * time:  3/5/18
 * function:
 * description:所有view层的接口，具体实现在view中
 *              所有presenter使用到的ui逻辑都在这里定义
 */

public interface ILoginView {

    void showProgress();
    void shutProgress();
    void backLoginview();
    interface ILoginViewListener{
        void onSuccess();
        void onFail();
    }
}
