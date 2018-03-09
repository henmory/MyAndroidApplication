package com.henmory.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.henmory.aidlserver.Person;
public class MyAIDLService extends Service {
    public MyAIDLService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    private IBinder iBinder = new IMyAidlInterface.Stub() {
        @Override
        public int add(int a, int b) throws RemoteException {
            return a + b;
        }

        @Override
        public void save(Person person) throws RemoteException {
            Log.i("PersonService", person.getAge()+"="+ person.getName());
        }
    };

}
