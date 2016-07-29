package com.amap;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.common.maps.ConfigableConst;
import com.common.maps.IMap;
import com.common.maps.IMapView;

/**
 * Created by zxy94400 on 2016/7/29.
 */
public class MapViewAdapter extends FrameLayout implements IMapView {
    MapView mapView;

    public MapViewAdapter(Context paramContext) {
        super(paramContext);
        if (ConfigableConst.MAP_TYPE == ConfigableConst.AMAP)
            mapView = new MapView(paramContext);
    }

    public MapViewAdapter(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        if (ConfigableConst.MAP_TYPE == ConfigableConst.AMAP)
            mapView = new MapView(paramContext, paramAttributeSet);
    }

    public MapViewAdapter(Context paramContext, AttributeSet paramAttributeSet,
                          int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        if (ConfigableConst.MAP_TYPE == ConfigableConst.AMAP)
            mapView = new MapView(paramContext, paramAttributeSet, paramInt);
    }

    //// TODO: 2016/7/29 带MapOption的实现方式
//    public MapView(Context paramContext, AMapOptions mapOptions) {
//        super(paramContext);
//        MapFragmentDelegateImp.context=paramContext.getApplicationContext();
//        getMapFragmentDelegate().setContext(paramContext);
//        getMapFragmentDelegate().setOptions(mapOptions);
//    }

    public IMap getMap() {
        if (ConfigableConst.MAP_TYPE == ConfigableConst.AMAP) {
            if (mapView != null) {
                AMap amap = mapView.getMap();
                if (amap != null) {
                    return new MapAdapter(amap);
                }
            }
        }
        return null;
    }

    public final void onCreate(Bundle paramBundle) {
        if (mapView != null) {
            mapView.onCreate(paramBundle);
            ViewGroup.LayoutParams mparams = new ViewGroup.LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT);
            this.addView(mapView, mparams);
        }
    }

    public final void onResume() {
        if (mapView != null) {
            mapView.onResume();
        }
    }

    /**
     * 用户重载这个方法时必须调用父类的这个方法。
     */
    public final void onPause() {
        if (mapView != null) {
            mapView.onPause();
        }
    }

    /**
     * 用户重载这个方法时必须调用父类的这个方法。
     */
    public final void onDestroy() {
        if (mapView != null) {
            mapView.onDestroy();
        }
    }

    /**
     * 用户重载这个方法时必须调用父类的这个方法。
     */
    public final void onLowMemory() {
        if (mapView != null) {
            mapView.onLowMemory();
        }
    }

    /**
     * 用户重载这个方法时必须调用父类的这个方法。
     */
    public final void onSaveInstanceState(Bundle paramBundle) {
        if (mapView != null) {
            mapView.onSaveInstanceState(paramBundle);
        }
    }

    //不打算实现
//    public void setLayerType(int layerType, Paint paint) {
////		super.setLayerType(layerType, paint);
//    }

    /**
     * 是在是否显示，在fragment切换的时候可以使用，或者想隐藏MapView的时候可以使用
     *
     * @param visibility View.VISIBILE：显示； View.GONE：不显示；
     */
    public void setVisibility(int visibility) {
        if (mapView != null) {
            mapView.setVisibility(visibility);
        }
    }
}
