package com.henmory.mvptest.module;

import android.content.Context;
import com.henmory.mvptest.bean.*;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * author: henmory
 * time:  3/5/18
 * function:
 * description:
 */

public class AccountModuleImpl implements IAccountmodule {


    private Context context;
    private OkHttpClient client;
    public AccountModuleImpl(Context context) {
        this.context = context;
        client = new OkHttpClient();
    }

    @Override
    public void login(Context context, Account account, IAccountmoduleListener listener) {


    }

    //网络请求采用txjava方式
    public Observable<String> login(final Context context, final String url, final Map<String, String> params){

        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    FormBody.Builder builder = new FormBody.Builder();
                    if (null != params && !params.isEmpty()){
                        for (Map.Entry<String, String> entry: params.entrySet()){
                            builder.add(entry.getKey(), entry.getValue());
                        }
                    }
                    RequestBody requestBody = builder.build();
                    final Request request = new Request.Builder().url(url).post(requestBody).build();
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            subscriber.onError(e);
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if (response.isSuccessful()){
                                subscriber.onNext(response.body().string());
                            }
                            subscriber.onCompleted();
                        }
                    });
                }
            }
        });
    }

    @Override
    public void register(Context context, Account account, IAccountmoduleListener listener) {

    }

    @Override
    public void getSmsCode(Context context, Account account, IAccountmoduleListener listener) {

    }
}
