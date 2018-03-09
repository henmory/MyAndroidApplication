package com.henmory.fragementdemo;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * author: henmory
 * time:  3/7/18
 * function:
 * description:
 */

public class MyFragment extends Fragment {

    private final static String tag = "MyFragment";

    private TextView textView;
    private Button button;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(tag, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(tag, "onCreate");
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d(tag, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_my, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.d(tag, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.tv_show);
        button = view.findViewById(R.id.btn_modify_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        textView.setText("ok");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(tag, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(tag, "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(tag, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(tag, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(tag, "onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(tag, "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(tag, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(tag, "onDetach");
        super.onDetach();
    }
    public void setTextView(String str){
        textView.setText(str);
    }

    public void getData(CallBack callBack){
        String str = "你好";
        callBack.getResult(str);
    }
    interface CallBack{
        void getResult(String str);
    }
}
