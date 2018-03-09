package com.henmory.aidlclient;

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

import com.henmory.aidlserver.IMyAidlInterface;
import com.henmory.aidlserver.Person;


public class MainActivity extends AppCompatActivity {

    IMyAidlInterface aidl;
    Button btn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn_test);
        textView = findViewById(R.id.tv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = 0;
                try {
                    result = aidl.add(1, 2);
                    Log.d("afd","result = " + result);
                    try {
                        aidl.save(new Person("liming",12));
                    } catch (RemoteException e) {
                        Log.e("ClientActivity", e.toString());
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        bindService();
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.henmory.aidlserver","com.henmory.aidlserver.MyAIDLService"));
        bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("MainActivity", "onServiceConnected: " + service);
            aidl = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("MainActivity", "onServiceConnected: " + "fail");

            aidl = null;
        }
    };
}
