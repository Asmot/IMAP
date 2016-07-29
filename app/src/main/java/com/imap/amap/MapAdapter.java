package com.imap.amap;

import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.imap.amap.model.MarkerWrapper;
import com.imap.maps.IMap;
import com.imap.maps.model.IMarker;
import com.imap.maps.model.IMarkerOptions;
import com.imap.maps.model.LatLngWrapper;

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
        LatLngWrapper latLngWrapper = markerOptions.getPosition();
        if(latLngWrapper != null) {
            options.position(new LatLng(latLngWrapper.latitude,latLngWrapper.longitude));
        }
        BitmapDescriptor bitmapDescriptor = markerOptions.getIcon();
        if(bitmapDescriptor != null) {
            options.icon(bitmapDescriptor);
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
