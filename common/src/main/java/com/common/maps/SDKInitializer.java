package com.common.maps;

import android.content.Context;

import java.lang.reflect.Method;

/**
 * Created by zxy94400 on 2016/7/29.
 */
public class SDKInitializer {
    /**
     * baidu地图特有方法
     * //在使用SDK各组件之前初始化context信息，传入ApplicationContext
     //注意该方法要再setContentView方法之前实现
     SDKInitializer.initialize(getApplicationContext());
     */
    public static void initialize(Context context) {
        if(ConfigableConst.MAP_TYPE == ConfigableConst.AMAP) {

        } else {

        }
        //因为不一定有baidu sdk的包，所有根据名字直接进行调用
        Class<?> c;
        try {
            c = Class.forName("com.baidu.mapapi.SDKInitializer");


            Method m = c.getMethod("initialize", new Class[] {
                    Context.class });
            //调用方法
            Object s = m.invoke(null, context.getApplicationContext());
        } catch (Throwable e) {
            e.printStackTrace();

        }
    }
}
