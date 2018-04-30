package com.henmory.test.mvvmtest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.henmory.test.R;
import com.henmory.test.databinding.MvvmTestBinding;

/**
 * author: henmory
 * time:  3/19/18
 * function:
 * description:
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MvvmTestBinding binding = DataBindingUtil.setContentView(this, R.layout.mvvm_test);
        binding.setViewModel(new MainViewModel(binding));
    }
}


