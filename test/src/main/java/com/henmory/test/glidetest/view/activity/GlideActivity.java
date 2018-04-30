package com.henmory.test.glidetest.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.henmory.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GlideActivity extends AppCompatActivity {


    @BindView(R.id.btn_glide_base)
    Button button1;
    @BindView(R.id.btn_glide_base1)
    Button button2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button1 = findViewById(R.id.btn_glide_base);
        button2 = findViewById(R.id.btn_glide_base1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GlideActivity.this, GlideBaseACtivity.class));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GlideActivity.this, GlideRecyclerViewACtivity.class));

            }
        });


    }


}
