package com.changhong.myapplication;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.changhong.aidlserver.IMyInterface;


public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Myserviec", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Myserviec", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
//        int pid = android.os.Process.myPid();
//        ActivityManager mActivityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
//                .getRunningAppProcesses()) {
//            if (appProcess.pid == pid) {
//                Log.d("MyService",appProcess.processName);
//            }
//        }
        return iBinder;
    }

    private IBinder iBinder = new IMyInterface.Stub() {
        @Override
        public int add(int a, int b) throws RemoteException {
            return a + b;
        }

        @Override
        public int minus(int a, int b) throws RemoteException {
            return a - b;
        }
    };


}
