package com.imap.maps;

import android.os.Bundle;

/**
 * Created by zxy94400 on 2016/7/29.
 */
public interface IMapView {

    public IMap getMap();

    public  void onCreate(Bundle paramBundle);
    public  void onResume();

    /**
     * 用户重载这个方法时必须调用父类的这个方法。
     */
    public void onPause();

    /**
     * 用户重载这个方法时必须调用父类的这个方法。
     */
    public  void onDestroy();

    /**
     * 用户重载这个方法时必须调用父类的这个方法。
     *
     */
    public void onLowMemory();

    /**
     * 用户重载这个方法时必须调用父类的这个方法。
     */
    public void onSaveInstanceState(Bundle paramBundle);

    //不打算实现
//    public void setLayerType(int layerType, Paint paint) {
////		super.setLayerType(layerType, paint);
//    }

    /**
     * 是在是否显示，在fragment切换的时候可以使用，或者想隐藏MapView的时候可以使用
     * @param visibility View.VISIBILE：显示； View.GONE：不显示；
     */
    public void setVisibility(int visibility);
}
