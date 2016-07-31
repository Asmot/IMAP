package com.amap;

import android.graphics.Bitmap;

import com.amap.api.maps.model.MarkerOptions;
import com.amap.model.MarkerWrapper;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.common.maps.IMap;
import com.common.maps.model.CameraPosition;
import com.common.maps.model.IMarker;
import com.common.maps.model.LatLngWrapper;
import com.common.maps.model.MarkerOptionWrapper;
import com.common.maps.tools.LogManager;

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
        if(listener == null) {
            aMap.setOnMapClickListener(null);
            return;
        }
        aMap.setOnMapClickListener(new AMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                listener.onMapClick(new LatLngWrapper(latLng.latitude,latLng.longitude));
            }
        });
    }

    @Override
    public void setOnCameraChangeListener(final OnCameraChangeListenerWrapper listener) {
        if(listener == null) {
            aMap.setOnCameraChangeListener(null);
            return;
        }
        aMap.setOnCameraChangeListener(new AMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(com.amap.api.maps.model.CameraPosition cameraPosition) {
                if(cameraPosition != null && cameraPosition.target != null) {
                    LatLngWrapper latLngWrapper = new LatLngWrapper(cameraPosition.target.latitude,cameraPosition.target.longitude);
                    com.common.maps.model.CameraPosition iCameraPosition = new CameraPosition(latLngWrapper,cameraPosition.zoom,cameraPosition.tilt,cameraPosition.bearing);
                    listener.onCameraChange(iCameraPosition);
                } else {
                    listener.onCameraChange(null);
                }
            }

            @Override
            public void onCameraChangeFinish(com.amap.api.maps.model.CameraPosition cameraPosition) {
                if(cameraPosition != null && cameraPosition.target != null) {
                    LatLngWrapper latLngWrapper = new LatLngWrapper(cameraPosition.target.latitude,cameraPosition.target.longitude);
                    com.common.maps.model.CameraPosition iCameraPosition = new CameraPosition(latLngWrapper,cameraPosition.zoom,cameraPosition.tilt,cameraPosition.bearing);
                    listener.onCameraChangeFinish(iCameraPosition);
                } else {
                    listener.onCameraChangeFinish(null);
                }
            }
        });
    }

    @Override
    public void setMapType(int mapType) {
        switch (mapType) {
            case IMAP_TYPE_NIGHT: aMap.setMapType(AMap.MAP_TYPE_NIGHT);break;
            case IMAP_TYPE_NAVI: aMap.setMapType(AMap.MAP_TYPE_NAVI);break;
            case IMAP_TYPE_SATELLITE: aMap.setMapType(AMap.MAP_TYPE_SATELLITE);break;
            case IMAP_TYPE_NONE: LogManager.Log(LogManager.WARN,"setMapType baidu sdk do not hava none tpye");break;
            default:aMap.setMapType(AMap.MAP_TYPE_NORMAL);break;
        }
    }

    @Override
    public int getMapType() {
        int mapType = aMap.getMapType();
        switch (mapType) {
            case AMap.MAP_TYPE_NIGHT: return IMAP_TYPE_NIGHT;
            case AMap.MAP_TYPE_NAVI: return IMAP_TYPE_NAVI;
            case AMap.MAP_TYPE_SATELLITE: return IMAP_TYPE_SATELLITE;
            default:return IMAP_TYPE_NORMAL;
        }
    }

    @Override
    public IMarker addMarker(MarkerOptionWrapper markerOptions) {
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

}
