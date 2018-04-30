//package com.henmory.test.android_rxjava;
//
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//
//import com.henmory.test.R;
//import com.henmory.test.android_rxjava.utils.DownLoadUtils;
//
//import rx.Subscriber;
//import rx.android.schedulers.AndroidSchedulers;
//import rx.schedulers.Schedulers;
//
//public class Main3Activity extends AppCompatActivity {
//
//    private final static String TAG = Main3Activity.class.getSimpleName();
//    private Button button;
//    private ImageView imageView;
//    private String path = "http://img.sccnn.com/bimg/338/34264.jpg";
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main3);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new DownLoadUtils().downLoadImage(path)
//                        .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
//                        .observeOn(AndroidSchedulers.mainThread())// 指定 Subscriber 的回调发生在主线程
//                        .subscribe(new Subscriber<byte[]>() {//观察者
//                    @Override
//                    public void onCompleted() {
//                        Log.d(TAG, "onCompleted: ");//对话框消失
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "onError: " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(byte[] bytes) {
//                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0,bytes.length);
//                        imageView.setImageBitmap(bitmap);
//                    }
//                });
//            }
//        });
//
//        imageView = findViewById(R.id.iv);
//
//    }
//
//}
