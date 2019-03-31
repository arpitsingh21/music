package com.example.meeera.musicmuniassignment;

import android.app.Application;
import android.os.Handler;

/**
 * Created by Arpit on 6/6/18.
 */

public class MyApplication extends Application {
    public static volatile Handler applicationHandler = null;
    @Override
    public void onCreate() {
        applicationHandler = new Handler(getApplicationContext().getMainLooper());
        super.onCreate();
    }
}
