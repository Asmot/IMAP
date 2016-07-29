package com.bdmap.model;

import android.graphics.Bitmap;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.model.LatLng;
import com.common.maps.IPoint;
import com.common.maps.model.IMarker;
import com.common.maps.model.LatLngWrapper;
import com.common.maps.tools.LogManager;

import java.util.ArrayList;

/**
 * Created by zxy94400 on 2016/7/29.
 */
public class MarkerWrapper implements IMarker {

    Marker marker = null;

    private ArrayList<Bitmap> bitmaps = new ArrayList<Bitmap>();

    public MarkerWrapper(Marker marker) {
        this.marker = marker;
    }

    @Override
    public void setPeriod(int var1) {
        if (marker != null)
            marker.setPeriod(var1);
    }

    @Override
    public int getPeriod() {
        if (marker != null)
            return marker.getPeriod();
        return 0;
    }

    @Override
    public void setIcons(ArrayList<Bitmap> var1) {
        if (marker != null && var1 != null && var1.size() > 0) {
            ArrayList<BitmapDescriptor> bitmapDescriptors = new ArrayList<BitmapDescriptor>();
            synchronized (bitmaps) {
//                recycleBitmaps();
                bitmaps.clear();
                bitmaps.addAll(var1);
                for(Bitmap bitmap: bitmaps) {
                    if(bitmap != null && !bitmap.isRecycled()) {
                        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap);
                        if(bitmapDescriptor != null) {
                            bitmapDescriptors.add(bitmapDescriptor);
                        }
                    }
                }

                marker.setIcons(bitmapDescriptors);
            }
        }
    }

    @Override
    public ArrayList<Bitmap> getIcons() {
//        if (marker != null)
//            return marker.getIcons();
        return bitmaps;
    }

    @Override
    public void remove() {
        if (marker != null)
            marker.remove();
    }

    /**
     * 只会回收当前记录的图片
     */
    @Override
    public void destroy() {
//        if (marker != null)
//            marker.destroy();


        LogManager.Log(LogManager.WARN,"bdmap do not hava destory in Marker");

        recycleBitmaps();
    }

    private void recycleBitmaps() {
        synchronized (bitmaps) {
            for (Bitmap bitmap : bitmaps) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                    bitmap = null;
                }
            }
            bitmaps.clear();
        }
    }

    @Override
    public String getId() {
//        if (marker != null)
//            return marker.getId();

        LogManager.Log(LogManager.WARN,"bdmap do not hava getId in Marker");
        return "";
    }

    @Override
    public void setPerspective(boolean var1) {
        if (marker != null)
            marker.setPerspective(var1);
    }

    @Override
    public boolean isPerspective() {
        if (marker != null)
            return marker.isPerspective();
        return false;
    }

    @Override
    public void setPosition(LatLngWrapper var1) {
        if (marker != null)
            if (var1 != null) {
                marker.setPosition(new LatLng(var1.latitude, var1.longitude));
            }

    }

    @Override
    public void setTitle(String var1) {
        if (marker != null)
            marker.setTitle(var1);
    }

    @Override
    public String getTitle() {
        if (marker != null)
            return marker.getTitle();
        return null;
    }

    @Override
    public void setSnippet(String var1) {
//        if (marker != null)
//            marker.setSnippet(var1);

        LogManager.Log(LogManager.WARN,"bdmap do not hava setSnippet in Marker");
    }

    @Override
    public String getSnippet() {
//        if (marker != null)
//            return marker.gett();

        LogManager.Log(LogManager.WARN,"bdmap do not hava getSnippet in Marker");
        return null;
    }

    /**
     * 记得自定处理上一张图片，调用此方法对于之前的图片不会进行回收
     * @param var1
     */
    @Override
    public void setIcon(Bitmap var1) {
        if (marker != null && var1 != null && !var1.isRecycled()) {
            ArrayList<BitmapDescriptor> bitmapDescriptors = new ArrayList<BitmapDescriptor>();
            synchronized (bitmaps) {
//                recycleBitmaps();
                bitmaps.clear();
                bitmaps.add(var1);
                for(Bitmap bitmap: bitmaps) {
                    if(bitmap != null && !bitmap.isRecycled()) {
                        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap);
                        if(bitmapDescriptor != null) {
                            bitmapDescriptors.add(bitmapDescriptor);
                        }
                    }
                }

                marker.setIcons(bitmapDescriptors);
            }
        }
    }

    @Override
    public void setAnchor(float var1, float var2) {

        if (marker != null)
            marker.setAnchor(var1, var2);
    }

    @Override
    public void setDraggable(boolean var1) {
        if (marker != null)
            marker.setDraggable(var1);

    }

    @Override
    public boolean isDraggable() {
        if (marker != null)
            return marker.isDraggable();
        return false;
    }

    @Override
    public void showInfoWindow() {
        LogManager.Log(LogManager.WARN,"bdmap do not hava showInfoWindow in Marker");

    }

    @Override
    public void hideInfoWindow() {
//
//        if (marker != null)
//            marker.hideInfoWindow();
        LogManager.Log(LogManager.WARN,"bdmap do not hava hideInfoWindow in Marker");


    }

    @Override
    public boolean isInfoWindowShown() {
//        if (marker != null)
//            marker.isInfoWindowShown();
        LogManager.Log(LogManager.WARN,"bdmap do not hava isInfoWindowShown in Marker");

        return false;
    }

    @Override
    public void setVisible(boolean var1) {
        if (marker != null)
            marker.setVisible(var1);

    }

    @Override
    public boolean isVisible() {

        if (marker != null)
            return marker.isVisible();
        return false;
    }

    @Override
    public void setObject(Object var1) {
//        if (marker != null)
//            marker.setObject(var1);

        LogManager.Log(LogManager.WARN,"bdmap do not hava setObject in Marker");


    }

    @Override
    public Object getObject() {
//        if (marker != null)
//            marker.getObject();

        LogManager.Log(LogManager.WARN,"bdmap do not hava getObject in Marker");
        return null;
    }

    @Override
    public void setRotateAngle(float var1) {
        if (marker != null)
            marker.setRotate(var1);

    }

    @Override
    public float getRotateAngle() {
        if (marker != null)
            return marker.getRotate();
        return 0;
    }

    @Override
    public void setToTop() {
        if (marker != null)
            marker.setToTop();

    }

    @Override
    public void setGeoPoint(IPoint var1) {
//        if (marker != null)
//            marker.setGeoPoint(new com.autonavi.amap.mapcore.IPoint(var1.x, var1.y));

        LogManager.Log(LogManager.WARN,"bdmap do not hava setGeoPoint in Marker");
    }

    @Override
    public IPoint getGeoPoint() {
//        if (marker != null) {
//            com.autonavi.amap.mapcore.IPoint iPoint = marker.getGeoPoint();
//            if (iPoint != null)
//                return new IPoint(iPoint.x, iPoint.y);
//        }

        LogManager.Log(LogManager.WARN,"bdmap do not hava getGeoPoint in Marker");
        return null;
    }

    @Override
    public void setFlat(boolean var1) {
        if (marker != null)
            marker.setFlat(var1);

    }

    @Override
    public boolean isFlat() {
        if (marker != null)
            return marker.isFlat();
        return false;
    }

    @Override
    public void setPositionByPixels(int var1, int var2) {
//        if (marker != null)
//            marker.setPositionByPixels(var1, var2);

        LogManager.Log(LogManager.WARN,"bdmap do not hava setPositionByPixels in Marker");
    }

    @Override
    public void setZIndex(float var1) {
        if (marker != null)
            marker.setZIndex((int) var1);
    }

    @Override
    public float getZIndex() {
        if (marker != null)
            return marker.getZIndex();
        return 0;
    }
}
