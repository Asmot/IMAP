package com.imap.maps;

import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.imap.maps.model.LatLngWrapper;
import com.imap.maps.model.MarkerAdapter;
import com.imap.maps.model.MarkerOptionAdapter;

/**
 * Created by zxy94400 on 2016/7/29.
 */
public class MapAdapter implements IMap{
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

//    public MarkerAdapter addMarker(MarkerOptionAdapter optionAdapter) {
//
//        aMap.addMarker(optionAdapter.toMarkerOption())
//    }


}
