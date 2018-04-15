package com.yogiw.fastandroidnetworking;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

public class FastAndroidNetworking extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AndroidNetworking.initialize(getApplicationContext());
    }
}
