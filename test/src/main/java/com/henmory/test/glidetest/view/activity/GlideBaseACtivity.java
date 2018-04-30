package com.henmory.test.glidetest.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.henmory.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GlideBaseACtivity extends AppCompatActivity {


    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.iv3)
    ImageView iv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.iv4)
    ImageView iv4;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.iv5)
    ImageView iv5;
    @BindView(R.id.tv6)
    TextView tv6;
    @BindView(R.id.iv6)
    ImageView iv6;
    @BindView(R.id.tv7)
    TextView tv7;
    @BindView(R.id.iv7)
    ImageView iv7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_base_activity);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //加载网络图片
        tv1.setText("1.加载网络图片");
        Glide.with(this).load("http://img.taopic.com/uploads/allimg/120727/201995-120HG1030762.jpg").into(iv1);

        //2.加载资源图片
        tv2.setText("2.加载资源图片");
        Glide.with(this).load(R.mipmap.ic_launcher).into(iv2);

        //3。加载本地图片，文件
        //3.加载网络gif
        tv3.setText("3.加载网络gif");
        String path = "http://img3.duitang.com/uploads/item/201608/20/20160820130758_hKTci.gif";
        Glide.with(this).load(path).asGif()
        .diskCacheStrategy(DiskCacheStrategy.SOURCE).error(R.mipmap.ic_launcher_round).into(iv3);

        //4.加载资源gif
        tv4.setText("4.加载本地资源gif");
        Glide.with(this).load(R.drawable.loading)
                .asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).placeholder(R.mipmap.ic_launcher_round).into(iv4);

        //5.加载缩略图
        tv5.setText("5.加载资源图片");
        Glide.with(this).load(R.mipmap.ic_launcher).thumbnail(0.1f).centerCrop().into(iv5);

        //6.先加载一个有的缩略图，再加载原图
        tv6.setText("6.先加载一个有的缩略图，再加载原图");
        DrawableRequestBuilder thumbnail = Glide.with(this).load(R.drawable.loading);
        Glide.with(this).load("http://img.taopic.com/uploads/allimg/120727/201995-120HG1030762.jpg")
                .thumbnail(thumbnail).centerCrop().into(iv6);

    }

}
