package com.luckynineapps.danakilat.application;

import android.app.Application;
import android.graphics.Typeface;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.google.android.gms.ads.MobileAds;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AndroidNetworking.initialize(getApplicationContext());
        AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
    }

}
