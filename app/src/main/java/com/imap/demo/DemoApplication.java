package com.imap.demo;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by zxy94400 on 2016/7/29.
 */
public class DemoApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
    }
}
