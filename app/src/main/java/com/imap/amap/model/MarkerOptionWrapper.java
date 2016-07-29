package com.imap.amap.model;

import com.amap.api.maps.model.BitmapDescriptor;
import com.imap.maps.model.IMarkerOptions;
import com.imap.maps.model.LatLngWrapper;

import java.util.ArrayList;

/**
 * Created by zxy94400 on 2016/7/29.
 */
public class MarkerOptionWrapper implements IMarkerOptions{

    private LatLngWrapper latLng;
    private String title;
    private String snippet;
    private float anchorU = 0.5F;
    private float anchorV = 1.0F;
    private float zIndex = 0;
    private boolean isDraggable = false;
    private boolean isVisible = true;
    String id;
    private boolean perspective = false;
    private int offsetX = 0, offsetY = 0;
    private ArrayList<BitmapDescriptor> bitmapDescriptors = new ArrayList<BitmapDescriptor>();
    ;
    /**
     * 刷新周期
     */
    private int period = 20;
    private boolean isGps = false;
    private boolean isFlat = false;
    private boolean isPerspective;

    @Override
    public IMarkerOptions icons(ArrayList<BitmapDescriptor> var1) {
        this.bitmapDescriptors = var1;
        return this;
    }

    @Override
    public ArrayList<BitmapDescriptor> getIcons() {
        return bitmapDescriptors;
    }

    @Override
    public IMarkerOptions period(int var1) {
        this.period = var1;
        return this;
    }

    @Override
    public int getPeriod() {
        return period;
    }

    @Override
    public boolean isPerspective() {
        return isPerspective;
    }

    @Override
    public IMarkerOptions perspective(boolean var1) {
        this.isPerspective = var1;
        return this;
    }

    @Override
    public IMarkerOptions position(LatLngWrapper var1) {
        this.latLng = var1;
        return this;
    }

    @Override
    public IMarkerOptions setFlat(boolean var1) {
        this.isFlat = var1;
        return this;
    }


    private void initBitmapDescriptors() {
        if (bitmapDescriptors == null) {
            bitmapDescriptors = new ArrayList<BitmapDescriptor>();
        }
    }

    /**
     * 设置MarkerOptions 对象的自定义图标。
     *
     * @param icon 设置图标的BitmapDescriptor对象
     * @return MarkerOptions对象。
     * @since V2.0
     */
    public IMarkerOptions icon(BitmapDescriptor icon) {
        initBitmapDescriptors();
        bitmapDescriptors.clear();
        bitmapDescriptors.add(icon);
        return this;
    }

    @Override
    public IMarkerOptions anchor(float anchorX, float anchorY) {
        this.anchorU =anchorX;
        this.anchorV =anchorY;
        return this;
    }

    @Override
    public IMarkerOptions setInfoWindowOffset(int offsetX, int offsetY) {
        this.offsetX =offsetX;
        this.offsetY =offsetY;

        return this;
    }

    @Override
    public IMarkerOptions title(String var1) {
        this.title =var1;
        return this;
    }

    @Override
    public IMarkerOptions snippet(String var1) {
        this.snippet =var1;
        return this;
    }

    @Override
    public IMarkerOptions draggable(boolean var1) {
        this.isDraggable =var1;
        return this;
    }

    @Override
    public IMarkerOptions visible(boolean var1) {
        this.isVisible =var1;
        return this;
    }

    @Override
    public IMarkerOptions setGps(boolean var1) {
        this.isGps = var1;
        return this;
    }

    @Override
    public LatLngWrapper getPosition() {
        return latLng;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSnippet() {
        return snippet;
    }

    @Override
    public BitmapDescriptor getIcon() {
        if (bitmapDescriptors != null && bitmapDescriptors.size() != 0) {
            return this.bitmapDescriptors.get(0);
        } else {
            return null;
        }
    }

    @Override
    public float getAnchorU() {
        return anchorU;
    }

    @Override
    public int getInfoWindowOffsetX() {
        return offsetX;
    }

    @Override
    public int getInfoWindowOffsetY() {
        return offsetY;
    }

    @Override
    public float getAnchorV() {
        return anchorV;
    }

    @Override
    public boolean isDraggable() {
        return isDraggable;
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public boolean isGps() {
        return isGps;
    }

    @Override
    public boolean isFlat() {
        return isFlat;
    }

    @Override
    public IMarkerOptions zIndex(float var1) {
        this.zIndex =var1;
        return this;
    }

    @Override
    public float getZIndex() {
        return zIndex;
    }
}
