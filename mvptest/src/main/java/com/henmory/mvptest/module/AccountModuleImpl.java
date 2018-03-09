package com.henmory.mvptest.module;

import android.content.Context;
import com.henmory.mvptest.bean.*;

/**
 * author: henmory
 * time:  3/5/18
 * function:
 * description:
 */

public class AccountModuleImpl implements IAccountmodule {

    private Context context;

    public AccountModuleImpl(Context context) {
        this.context = context;
    }

    @Override
    public void login(Context context, Account account, IAccountmoduleListener listener) {


    }

    @Override
    public void register(Context context, Account account, IAccountmoduleListener listener) {

    }

    @Override
    public void getSmsCode(Context context, Account account, IAccountmoduleListener listener) {

    }
}
