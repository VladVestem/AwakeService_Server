package com.example.aidlawakeservice_server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class AIDLAwakeService extends Service {
    public AIDLAwakeService() {
    }

    long serviceStartTime;

    @Override
    public void onCreate(){
        super.onCreate();
        serviceStartTime = System.nanoTime();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return binder;
    }

    private final IAIDLAwakeServiceInterface.Stub binder = new IAIDLAwakeServiceInterface.Stub() {
        @Override
        public long GetServiceElapsedTime() throws RemoteException {
            Log.d("Server", "GetServiceElapsedTime()");
            return (System.nanoTime() - serviceStartTime);
        }
    };
}