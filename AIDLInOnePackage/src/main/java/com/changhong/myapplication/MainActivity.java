package com.changhong.myapplication;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.changhong.aidlserver.IMyInterface;


public class MainActivity extends AppCompatActivity {

    IMyInterface aidl;
    Button btn;
    Button btn_create;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_create = findViewById(R.id.btn_test);
        btn = findViewById(R.id.btn_test);
        textView = findViewById(R.id.tv);
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent("com.changhong.application1.MyService"));
            }
        });
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int result = 0;
//                try {
//                    result = aidl.add(1, 2);
//                    Log.d("afd","result = " + result);
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        bindService();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService();
            }
        });
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.changhong.myapplication","com.changhong.myapplication.MyService"));
        bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("MainActivity", "onServiceConnected: " + service);

            aidl = IMyInterface.Stub.asInterface(service);

//            int pid = android.os.Process.myPid();
//            ActivityManager mActivityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//            for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
//                    .getRunningAppProcesses()) {
//                if (appProcess.pid == pid) {
//                    Log.d("MainActivity",appProcess.processName);
//                }
//            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("MainActivity", "onServiceConnected: " + "fail");

            aidl = null;
        }
    };
}
