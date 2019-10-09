package com.example.retrofitandrxjava;

import android.app.Application;

import com.example.retrofitandrxjava.util.NetWorkManager;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NetWorkManager.getInstance().init();
    }
}

