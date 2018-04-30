package com.henmory.mvptest.presenter;

import android.content.Context;
import android.util.Log;

import com.henmory.mvptest.bean.*;
import com.henmory.mvptest.module.*;
import com.henmory.mvptest.view.*;
import java.lang.ref.WeakReference;

import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author: henmory
 * time:  3/5/18
 * function:
 * description:所有的业务逻辑，ui部分逻辑在activity实现，数据获取逻辑在module实现
 */

public class AccountPresenter<T> {

    private final static String TAG = AccountPresenter.class.getSimpleName();
    private Account account = new Account();
    private WeakReference<T> weakReference; //弱引用
    private AccountModuleImpl accountModule;
    private Context context;

    public AccountPresenter(T View) {
        weakReference = new WeakReference<T>(View);
        accountModule = new AccountModuleImpl((Context) View);
        this.context = (Context) View;
    }

    public void login(String phone, String password){

        ((ILoginView)weakReference.get()).showProgress();// 调用view的逻辑

        account.setPhone(phone);
        account.setPassword(password);
        //调用module的逻辑---之前的逻辑
//        accountModule.login(context, account, new IAccountmodule.IAccountmoduleListener() {
//            @Override
//            public void onSuccess() {
//                ((ILoginView)weakReference.get()).shutProgress();// 调用view的逻辑
//            }
//
//            @Override
//            public void onFail() {
//                ((ILoginView)weakReference.get()).shutProgress();// 调用view的逻辑
//                ((ILoginView)weakReference.get()).backLoginview();
//            }
//        });

        // 采用rxjava的逻辑

        accountModule.login(context, "sf", null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {//处理对话框操作
                ((ILoginView)weakReference.get()).shutProgress();// 调用view的逻辑
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onNext(String s) {//成功去解析数据

            }
        });
    }

    public void initVerificationRequest(){

        ((IRegisterView)weakReference.get()).showProgress();// 调用view的逻辑

        accountModule.register(context, account, new IAccountmodule.IAccountmoduleListener() {
            @Override
            public void onSuccess() {
                ((IRegisterView)weakReference.get()).shutProgress();
            }

            @Override
            public void onFail() {
                ((IRegisterView)weakReference.get()).showProgress();// 调用view的逻辑
            }
        });
    }

    public void getSmsCode(String phone){

        ((IRegisterView)weakReference.get()).showProgress();// 调用view的逻辑

        accountModule.getSmsCode(context, account, new IAccountmodule.IAccountmoduleListener() {
            @Override
            public void onSuccess() {

                ((IRegisterView)weakReference.get()).shutProgress();
            }

            @Override
            public void onFail() {

                ((IRegisterView)weakReference.get()).shutProgress();

            }
        });

    }
    public void register(String phone, String password, String code){

        account.setPhone(phone);
        account.setPassword(password);

        accountModule.register(context, account, new IAccountmodule.IAccountmoduleListener() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onFail() {

            }
        });

    }
}
