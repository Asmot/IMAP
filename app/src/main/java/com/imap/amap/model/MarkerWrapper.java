package com.imap.amap.model;

import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.imap.maps.IPoint;
import com.imap.maps.model.IMarker;
import com.imap.maps.model.LatLngWrapper;

import java.util.ArrayList;

/**
 * Created by zxy94400 on 2016/7/29.
 */
public class MarkerWrapper implements IMarker{
    Marker marker = null;
    public MarkerWrapper(Marker marker) {
        this.marker = marker;
    }

    @Override
    public void setPeriod(int var1) {
        if(marker != null)
        marker.setPeriod(var1);
    }

    @Override
    public int getPeriod() {
        if(marker != null)
        return marker.getPeriod();
        return 0;
    }

    @Override
    public void setIcons(ArrayList<BitmapDescriptor> var1) {
        if(marker != null)
            marker.setIcons(var1);
    }

    @Override
    public ArrayList<BitmapDescriptor> getIcons() {
        if(marker != null)
        return marker.getIcons();
        return null;
    }

    @Override
    public void remove() {
        if(marker != null)
        marker.remove();
    }

    @Override
    public void destroy() {
        if(marker != null)
        marker.destroy();
    }

    @Override
    public String getId() {
        if(marker != null)
        return marker.getId();
        return "";
    }

    @Override
    public void setPerspective(boolean var1) {
        if(marker != null)
        marker.setPerspective(var1);
    }

    @Override
    public boolean isPerspective() {
        if(marker != null)
        return marker.isPerspective();
        return false;
    }

    @Override
    public void setPosition(LatLngWrapper var1) {
        if(marker != null)
        if(var1 != null) {
            marker.setPosition(new LatLng(var1.latitude,var1.longitude));
        }

    }

    @Override
    public void setTitle(String var1) {
        if(marker != null)
marker.setTitle(var1);
    }

    @Override
    public String getTitle() {
        if(marker != null)
            return marker.getTitle();
        return null;
    }

    @Override
    public void setSnippet(String var1) {
        if(marker != null)
marker.setSnippet(var1);
    }

    @Override
    public String getSnippet() {
        if(marker != null)
            return marker.getSnippet();
        return null;
    }

    @Override
    public void setIcon(BitmapDescriptor var1) {
        if(marker != null)
marker.setIcon(var1);
    }

    @Override
    public void setAnchor(float var1, float var2) {

        if(marker != null)
            marker.setAnchor(var1,var2);
    }

    @Override
    public void setDraggable(boolean var1) {
        if(marker != null)
            marker.setDraggable(var1);

    }

    @Override
    public boolean isDraggable() {
        if(marker != null)
            return marker.isDraggable();
        return false;
    }

    @Override
    public void showInfoWindow() {
        if(marker != null)
            marker.showInfoWindow();

    }

    @Override
    public void hideInfoWindow() {

        if(marker != null)
            marker.hideInfoWindow();

    }

    @Override
    public boolean isInfoWindowShown() {
        if(marker != null)
            marker.isInfoWindowShown();
        return false;
    }

    @Override
    public void setVisible(boolean var1) {
        if(marker != null)
            marker.setVisible(var1);

    }

    @Override
    public boolean isVisible() {

        if(marker != null)
            return marker.isVisible();
        return false;
    }

    @Override
    public void setObject(Object var1) {
        if(marker != null)
            marker.setObject(var1);

    }

    @Override
    public Object getObject() {
        if(marker != null)
            marker.getObject();
        return null;
    }

    @Override
    public void setRotateAngle(float var1) {
        if(marker != null)
            marker.setRotateAngle(var1);

    }

    @Override
    public float getRotateAngle() {
        if(marker != null)
            return marker.getRotateAngle();
        return 0;
    }

    @Override
    public void setToTop() {
        if(marker != null)
            marker.setToTop();

    }

    @Override
    public void setGeoPoint(IPoint var1) {
        if(marker != null)
            marker.setGeoPoint(new com.autonavi.amap.mapcore.IPoint(var1.x,var1.y));

    }

    @Override
    public IPoint getGeoPoint() {
        if(marker != null) {
            com.autonavi.amap.mapcore.IPoint iPoint = marker.getGeoPoint();
            if (iPoint != null)
                return new IPoint(iPoint.x, iPoint.y);
        }
        return null;
    }

    @Override
    public void setFlat(boolean var1) {
        if(marker != null)
            marker.setFlat(var1);

    }

    @Override
    public boolean isFlat() {
        if(marker != null)
            return marker.isFlat();
        return false;
    }

    @Override
    public void setPositionByPixels(int var1, int var2) {
        if(marker != null)
            marker.setPositionByPixels(var1,var2);

    }

    @Override
    public void setZIndex(float var1) {
        if(marker != null)
            marker.setZIndex(var1);

    }

    @Override
    public float getZIndex() {
        if(marker != null)
            return marker.getZIndex();
        return 0;
    }
}
