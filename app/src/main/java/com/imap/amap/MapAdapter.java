package com.imap.amap;

import android.graphics.Bitmap;

import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.imap.amap.model.MarkerWrapper;
import com.imap.maps.IMap;
import com.imap.maps.model.IMarker;
import com.imap.maps.model.IMarkerOptions;
import com.imap.maps.model.LatLngWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxy94400 on 2016/7/29.
 */
public class MapAdapter implements IMap {
    AMap aMap;
    public MapAdapter(AMap amap) {
        this.aMap = amap;
    }

    @Override
    public void setOnMapClickListener(final OnMapClickListenerWrapper listener) {
        aMap.setOnMapClickListener(new AMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                listener.onMapClick(new LatLngWrapper(latLng.latitude,latLng.longitude));
            }
        });
    }

    @Override
    public IMarker addMarker(IMarkerOptions markerOptions) {
        MarkerOptions options = new MarkerOptions();
        options.title(markerOptions.getTitle());
        options.snippet(markerOptions.getSnippet());

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
        options.setFlat(markerOptions.isFlat());
        options.draggable(markerOptions.isDraggable());
        options.perspective(markerOptions.isPerspective());
        options.zIndex(markerOptions.getZIndex());
        options.anchor(markerOptions.getAnchorU(),markerOptions.getAnchorV());
        options.setInfoWindowOffset(markerOptions.getInfoWindowOffsetX(),markerOptions.getInfoWindowOffsetY());
        Marker marker = aMap.addMarker(options);
        if(marker != null)
            return new MarkerWrapper(marker);
        return null;
    }

//    public MarkerWrapper addMarker(MarkerOptionWrapper optionAdapter) {
//
//        aMap.addMarker(optionAdapter.toMarkerOption())
//    }


}
