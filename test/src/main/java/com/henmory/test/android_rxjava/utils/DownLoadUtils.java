//package com.henmory.test.android_rxjava.utils;
//
//
//import java.io.IOException;
//
//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//import rx.Observable;
//import rx.Subscriber;
//
///**
// * author: henmory
// * time:  4/3/18
// * function:
// * description:
// */
//
//public class DownLoadUtils {
//
//    private OkHttpClient client;
//
//    public DownLoadUtils(){
//        client = new OkHttpClient();
//    }
//
//    //声明一个被观察者对象，作为结果返回
//    public Observable<byte[]> downLoadImage(String path){
//        return Observable.create(new Observable.OnSubscribe<byte[]>() {
//            //被观察者调用观察者的方法，即通知事件发出，参数为onnext的参数
//            @Override
//            public void call(Subscriber<? super byte[]> subscriber) {
//                if (!subscriber.isUnsubscribed()){
//                    //访问网络请求
//                    Request request = new Request.Builder().url(path).build();
//                    client.newCall(request).enqueue(new Callback() {
//                        @Override
//                        public void onFailure(Call call, IOException e) {
//                            subscriber.onError(e);
//                        }
//
//                        @Override
//                        public void onResponse(Call call, Response response) throws IOException {
//                            if (response.isSuccessful()){
//                                byte[] data = response.body().bytes();
//                                if (null != data){
//                                    subscriber.onNext(data);
//                                }
//                            }
//                            subscriber.onCompleted();
//                        }
//                    });
//
//                }
//            }
//        });
//    }
//}
