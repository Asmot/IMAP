package com.common.maps;

import android.content.Context;

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
//        if(context != null) {
//            com.baidu.mapapi.SDKInitializer.initialize(context.getApplicationContext());
//        }
    }
}
