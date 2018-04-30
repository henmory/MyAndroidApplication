package com.henmory.test.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.henmory.test.R;
import com.henmory.test.databinding.DatabindingTestBinding;

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabindingTestBinding binding = DataBindingUtil.setContentView(this, R.layout.databinding_test);
        User user = new User("henmory", "Han");
        binding.setUser(user);
        HandlerEvent handlerEvent = new HandlerEvent(this);
        binding.setHandler(handlerEvent);
    }

}
