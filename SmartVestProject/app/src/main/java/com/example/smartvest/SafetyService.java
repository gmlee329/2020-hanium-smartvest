package com.example.smartvest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class SafetyService extends Service {
    boolean run = true;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 1;
                boolean up = true;
                while (run) {
                    try {
                        Intent intent = new Intent("worker_safety");
                        intent.setPackage("com.example.smartvest");
                        if (progress >= 100 || progress <= 0)
                            up = !up;
                        if (up)
                            progress++;
                        else
                            progress--;
                        intent.putExtra("progress", progress);
                        sendBroadcast(intent);
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        run = false;
    }
}
