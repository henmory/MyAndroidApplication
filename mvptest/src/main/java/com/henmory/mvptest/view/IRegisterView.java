package com.henmory.mvptest.view;

/**
 * author: henmory
 * time:  3/5/18
 * function:
 * description:
 */

public interface IRegisterView {
    void showProgress();
    void shutProgress();

    interface IRegisterViewListener{
        void onSuccess();
        void onFail();
    }
}
