package com.imap.demo;

import android.app.Application;


/**
 * Created by zxy94400 on 2016/7/29.
 */
public class DemoApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        com.common.maps.SDKInitializer.initialize(getApplicationContext());
    }
}
