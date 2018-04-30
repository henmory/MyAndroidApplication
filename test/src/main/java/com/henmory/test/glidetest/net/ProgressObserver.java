package com.henmory.test.glidetest.net;

import android.content.Context;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * author: henmory
 * time:  4/5/18
 * function:
 * description: 对观察者的封装
 *              1.观察者的回调方法很多基本一致，除了onNext方法＝＝＝继承Observer
 *              2.为onNext方法专门设置一个接口，这样就可以直接实现这个接口即可ObserverOnNextListener
 *              3.处理它的回调接口，主要是与加载对话框有关，ProgressDialogHandler
 *              4.处理用户取消网络加载
 */
public class ProgressObserver<T> implements Observer<T>, ProgressCancelListener {

    private static final String TAG = ProgressObserver.class.getSimpleName();

    // onNext 方法处理的接口
    private ObserverOnNextListener listener;

    //加载对话框处理的对象
    private ProgressDialogHandler mProgressDialogHandler;

    //加载对话框出现的上下文
    private Context context;

    private Disposable d;


    public ProgressObserver(Context context, ObserverOnNextListener listener) {
        this.listener = listener;
        this.context = context;
        mProgressDialogHandler = new ProgressDialogHandler(context, this, true);
    }

    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }
    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG)
                    .sendToTarget();
            mProgressDialogHandler = null;
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.d = d;//
        showProgressDialog();
    }
    @Override
    public void onNext(T t) {
        listener.onNext(t);
    }
    @Override
    public void onError(Throwable e) {
        dismissProgressDialog();
        Log.e(TAG, "onError: " + e.getMessage());
    }
    @Override
    public void onComplete() {
        dismissProgressDialog();
        Log.d(TAG, "onComplete: Over!");
    }

    /**
     *  @author henmory
     *  @date 4/5/18
     *  @description    用户取消订阅状态，即用户现在不需要网络，当调用它的dispose方法后，观察者将不再收到数据
     *                  但是被观察者是否还在下网络就不得而知了
     *
     *  @param
     *
     *  @return
    */
    @Override
    public void onCancelProgress() {
        //如果处于订阅状态，则取消订阅
        if (!d.isDisposed()) {
            d.dispose();
        }
    }
}
