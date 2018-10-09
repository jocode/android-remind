package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    private String TAG = "Test";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(this, "Empieza el servicio", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "Empieza el servicio...");
        return START_STICKY;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "Termina el servicio", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "Termina el servicio...");
    }
}
