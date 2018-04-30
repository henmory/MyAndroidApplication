package com.henmory.test.mvvmtest;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.henmory.test.databinding.MvvmTestBinding;

/**
 * author: henmory
 * time:  3/19/18
 * function:
 * description:
 */

public class MainViewModel implements onSearchListener {

    private MvvmTestBinding binding;
    private SearchModel searchModel = new SearchModel();
    private Handler handler;

    public MainViewModel(MvvmTestBinding binding) {
        this.binding = binding;
        handler = new Handler(Looper.getMainLooper());
    }

    public void search(View view) {
        binding.pbLoad.setVisibility(View.VISIBLE);
        searchModel.getIPaddressInfo(binding.etIp.getText().toString().trim(), this);
    }



    @Override
    public void onSuccess(final MyIP myIP) {
        handler.post(new Runnable() {
            @Override public void run() {
                binding.pbLoad.setVisibility(View.GONE);
                binding.tvMsg.setText(myIP.toString());
            }
        });
    }

    @Override
    public void onError() {

        handler.post(new Runnable() {
            @Override public void run() {
                binding.pbLoad.setVisibility(View.GONE);
                binding.tvMsg.setText("查询失败");
            }
        });
    }
}
