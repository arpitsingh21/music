package com.example.meeera.musicmuniassignment.UI;

import com.example.meeera.musicmuniassignment.MyApplication;

/**
 * Created by Arpit on 23/5/18.
 */

public class RunOnUIThread {

    private final static Integer lock = 1;

    public static void run(Runnable runnable) {
        synchronized (lock) {
            MyApplication.applicationHandler.post(runnable);
        }
    }
}