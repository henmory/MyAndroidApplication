package com.henmory.mvptest.module;

import android.content.Context;

import com.henmory.mvptest.bean.Account;

/**
 * author: henmory
 * time:  3/5/18
 * function:
 * description:module层的所有接口，presenter使用的关于module层的接口都定义在这里
 */

public interface IDevicemodule {

    void login(Context context, Account account, IAccountmoduleListener listener);
    void register(Context context, Account account, IAccountmoduleListener listener);
    void getSmsCode(Context context, Account account, IAccountmoduleListener listener);

    interface IAccountmoduleListener{
        void onSuccess();
        void onFail();
    }
}
