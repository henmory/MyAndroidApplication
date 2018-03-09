package com.henmory.fragementdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static String tag = "MainActivity";
    private Button button;
    private TextView textView;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();
        textView = findViewById(R.id.tv_show_from_fragment);
        button = findViewById(R.id.btn_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragement();
            }
        });

        Log.d(tag, "onCreate");
    }

    private void addFragement() {
        MyFragment fragment = new MyFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frag_my1, fragment,"my_fragement");
        fragmentTransaction.commit();

    }

    @Override
    protected void onStart() {
        Log.d(tag, "onStart");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.d(tag, "onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d(tag, "onResume");
        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.d(tag, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(tag, "onDestroy");
        super.onDestroy();
    }

    public void remove(View view){

        Fragment fragment = fragmentManager.findFragmentById(R.id.frag_my1);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }

    public void rename(View view){
        MyFragment fragment = (MyFragment) fragmentManager.findFragmentById(R.id.frag_my);
        fragment.getData(new MyFragment.CallBack() {
            @Override
            public void getResult(String str) {
                textView.setText(str);
            }
        });
    }



}
