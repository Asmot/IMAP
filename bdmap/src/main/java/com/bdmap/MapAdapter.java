package com.bdmap;

import android.graphics.Bitmap;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.model.LatLng;
import com.bdmap.model.MarkerWrapper;
import com.common.maps.IMap;
import com.common.maps.model.IMarker;
import com.common.maps.model.LatLngWrapper;
import com.common.maps.model.MarkerOptionWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxy94400 on 2016/7/29.
 */
public class MapAdapter implements IMap {
    BaiduMap baiduMap;
    public MapAdapter(BaiduMap baiduMap) {
        this.baiduMap = baiduMap;
    }

    @Override
    public void setOnMapClickListener(final OnMapClickListenerWrapper listener) {
        baiduMap.setOnMapClickListener(new BaiduMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                listener.onMapClick(new LatLngWrapper(latLng.latitude,latLng.longitude));
            }

            @Override
            public boolean onMapPoiClick(MapPoi mapPoi) {
                return false;
            }
        });
    }

    @Override
    public IMarker addMarker(MarkerOptionWrapper markerOptions) {
        MarkerOptions options = new MarkerOptions();
        options.title(markerOptions.getTitle());
//        options.snippet(markerOptions.getSnippet());

        //经纬进行转换 转成amap的经纬度
        LatLngWrapper latLngWrapper = markerOptions.getPosition();
        if(latLngWrapper != null) {
            options.position(new LatLng(latLngWrapper.latitude,latLngWrapper.longitude));
        }

        //图片进行一次转换 转成amap的图片
        Bitmap temp = markerOptions.getIcon();
        if(temp != null) {
            options.icon(BitmapDescriptorFactory.fromBitmap(temp));
        }


        List<Bitmap> bitmaps = markerOptions.getIcons();
        if(bitmaps != null) {
            ArrayList<BitmapDescriptor> bitmapDescriptors = new ArrayList<BitmapDescriptor>();
            for (Bitmap bitmap : bitmaps) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap);
                    if (bitmapDescriptor != null) {
                        bitmapDescriptors.add(bitmapDescriptor);
                    }
                }
            }
            options.icons(bitmapDescriptors);
        }

        options.period(markerOptions.getPeriod());
        options.visible(markerOptions.isVisible());
//        options.setFlat(markerOptions.isFlat());
        options.flat(markerOptions.isFlat());
        options.draggable(markerOptions.isDraggable());
        options.perspective(markerOptions.isPerspective());
        options.zIndex((int) markerOptions.getZIndex());
        options.anchor(markerOptions.getAnchorU(),markerOptions.getAnchorV());
//        options.setInfoWindowOffset(markerOptions.getInfoWindowOffsetX(),markerOptions.getInfoWindowOffsetY());

        Marker marker = (Marker) baiduMap.addOverlay(options);
        if(marker != null)
            return new MarkerWrapper(marker);
        return null;
    }

//    public MarkerWrapper addMarker(MarkerOptionWrapper optionAdapter) {
//
//        baiduMap.addMarker(optionAdapter.toMarkerOption())
//    }


}
